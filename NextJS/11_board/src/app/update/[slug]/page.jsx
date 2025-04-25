'use client'
import Link from "next/link";
import "../../common.css";
import axios from "axios";
import {useEffect, useState} from "react";
import Image from "next/image";
export default function UpdatePage(props){

    const [info,setInfo]=useState({idx:0,subject:'',content:'',user_name:'',reg_date:'',bHit:0});
    const [list,setList]=useState('');

    const [prev,setPrev]=useState([]); // 미리보기 이미지
    const [upload,setUpload]=useState([]); // 업로드 파일

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

    const input=(e)=>{
        setInfo({...info,[e.target.name]:e.target.value});
    }

    const fileSelect=(e)=>{
        // prev state, upload state
        // e.target.files[0] 로 부터 미리보기 제공, upload 에 저장
        let file = e.target.files[0];
        setUpload([...upload,file]); // 업로드 시킬 정보에 등록
        // 사진 미리보기
        let reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onloadend = (e)=>{
            setPrev([...prev,<Image key={e.timeStamp} src={e.target.result} alt={file.name} width={100} height={100}/>]);
        }
    }

    return (
        <>
            <table className={"form"}>
                <tbody>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="subject" value={info.subject} onChange={input}/></td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td><input type="text" name="user_name" value={info.user_name} readOnly={true}/></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><textarea name="content" value={info.content} onChange={input}></textarea></td>
                </tr>
                {list}
                <tr>
                    <th>사진 추가</th>
                    <td>
                        <input type="file" name="files" onChange={fileSelect}/>
                        <div>{prev}</div>
                    </td>
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