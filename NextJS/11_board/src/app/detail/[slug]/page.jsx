'use client'
// Component 함수에 async 가 붙으면 use client 를 사용할 수 없다.
import {useEffect, useState} from "react";
import Link from "next/link";
import "../../common.css";
import axios from "axios";
export default function DetailPage(props){

    const [info,setInfo]=useState({idx:0,subject:'',content:'',user_name:'',reg_date:'',bHit:0});
    const [list,setList]=useState('');

    useEffect(() => {
        props.params.then(({slug})=>{
            console.log("idx :"+slug);
            // axios 로 slug 를 가지고 해당 상세 정보를 서버에 요청
            getDetail(slug);
        });
    },[]);

    const getDetail=async(idx)=>{
        const id = sessionStorage.getItem("id");
        const token = sessionStorage.getItem("token");
        const {data} = await axios.get(`http://localhost/detail/${id}/${idx}`,{headers:{Authorization:token}});
        console.log(data);
        setInfo(data.detail);

        if(data.photos.length>0){
            setList(<PhotoList photos={data.photos}/>);
        }
    }

    const del=async()=>{
        const token = sessionStorage.getItem("token");
        const id = sessionStorage.getItem("id");
        let {data} = await axios.delete(`http://localhost/del/${id}/${info.idx}`,{headers:{Authorization:token}});
        console.log(data);
        alert('삭제 되었습니다.');
        location.href='/list';
    }

    return(
        <>
            <table className={"form"}>
                <tbody>
                <tr>
                    <th>제목</th>
                    <td>{info.subject}</td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td>{info.user_name}</td>
                </tr>
                <tr>
                    <th>작성일</th>
                    <td>{info.reg_date}</td>
                </tr>
                <tr>
                    <th>조회수</th>
                    <td>{info.bHit}</td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td>{info.content}</td>
                </tr>
                {list}
                <tr>
                    <th colSpan="2">
                        <Link href={"/list"}>
                            <input type="button" value="리스트"/>
                        </Link>
                        <input type="button" value="삭제" onClick={del}/>
                        <Link href={`/update/${info.idx}`}>
                            <input type="button" value="수정"/>
                        </Link>
                    </th>
                </tr>
                </tbody>
            </table>
        </>
    );
}

function PhotoList({photos}){

    let content = photos.map(photo=>{
        return(
            <>
                <p><img src={`http://localhost/photo/${photo.file_idx}`} width={300}/></p>
                <br/>
                <a href={`http://localhost/download/${photo.file_idx}`}>다운로드</a>
                <br/>
            </>
        );
    });

    return(
        <tr>
            <th>사진</th>
            <td>{content}</td>
        </tr>
    );
}

