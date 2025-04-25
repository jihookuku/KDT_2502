'use client'
import "../common.css";
import {useState} from "react";
import Link from "next/link";
import axios from "axios";
import Image from "next/image";
export default function WritePage(){

    const [info,setInfo]=useState({subject:'',content:'',user_name:''});
    const id = sessionStorage.getItem("id");
    const token = sessionStorage.getItem("token");
    
    const [prev,setPrev]=useState([]); // 미리보기 이미지
    const [upload,setUpload]=useState([]); // 업로드 파일

    const input=(e)=>{
        setInfo({...info, [e.target.name]: e.target.value});
    }

    //file upload 조건
    // 1. POST 방식일것
    // 2. enctype=multipart/form-data 일것
    const save=async (e)=>{
        const formData = new FormData();
        formData.append("user_name", id);
        formData.append("content", info.content);
        formData.append("subject", info.subject);

        for (let i=0; i<upload.length;i++){
            formData.append("files", upload[i]);
        }

        const {data} = await axios.post('http://localhost/write',formData, {headers:{Authorization:token}});
        console.log(data);
        if(data.success){
            alert('글 등록에 성공 하였습니다.');
            location.href='/detail/'+data.idx;
        }
    }

    const fileSelect=(e)=>{
        //console.log(e);
        let file = e.target.files[0]; // 파일 정보를 추출해
        console.log('file',file);
        setUpload([...upload,file]); // 업로드 시킬 정보에 등록
        // 사진 미리보기
        let reader = new FileReader(); // 파일을 stream 으로 읽을 리더 준비
        reader.readAsDataURL(file); // BASE64 인코딩 형식으로 바이너리를 읽어옴(base64 -> 바이너리를 16진수 64비트 숫자로 표현)
        reader.onloadend = (e)=>{// 다 읽어졌을 경우  이 이벤트 실행
            console.log('evt',e);//e.target.result 를 이용하면  이미지를 표현 할 수 있다.
            setPrev([...prev,<Image key={e.timeStamp} src={e.target.result} alt={file.name} width={100} height={100}/>]);
        }
    }

    return(
        <>
            <h3>글쓰기</h3>
            <hr/>
            <table className={"form"}>
                <tbody>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="subject" onChange={input} value={info.subject}/></td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td><input type="text" name="user_name" readOnly={true} value={id}/></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><textarea name="content" onChange={input} value={info.content}></textarea></td>
                </tr>
                <tr>
                    <th>사진</th>
                    <td>
                        <input type="file" name="files" onChange={fileSelect}/>
                        <div>{prev}</div>
                    </td>
                </tr>
                <tr>
                    <th colSpan="2">
                        <Link href={'/list'}>
                            <input type="button" value="리스트"/>
                        </Link>
                        <button onClick={save}>저장</button>
                    </th>
                </tr>
                </tbody>
            </table>
        </>
    );
}