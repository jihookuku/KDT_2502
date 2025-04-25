'use client'
import Link from "next/link";
import "../../common.css";
import axios from "axios";
import {useEffect, useState} from "react";
export default function UpdatePage(props){

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
        const {data} = await axios.get(`http://localhost/update_view/${id}/${idx}`,{headers:{Authorization:token}});
        console.log(data);
        setInfo(data.detail);

        if(data.photos.length>0){
            setList(<PhotoList photos={data.photos}/>);
        }
    }

    return (
        <>
            <table className={"form"}>
                <tbody>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="subject" value={info.subject}/></td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td><input type="text" name="user_name" value={info.user_name} readOnly={true}/></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><textarea name="content" value={info.content}></textarea></td>
                </tr>
                {list}
                <tr>
                    <th>사진 추가</th>
                    <td><input type="file" name="files" /></td>
                </tr>
                <tr>
                    <th colSpan="2">
                        <Link href={"/list"}>
                            <input type="button" value="리스트"/>
                        </Link>
                        <button>저장</button>
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
            <div key={photo.file_idx}>
                <p><img src={`http://localhost/photo/${photo.file_idx}`} width={300}/></p>
            </div>
        );
    });

    return(
        <tr>
            <th>사진</th>
            <td>{content}</td>
        </tr>
    );
}