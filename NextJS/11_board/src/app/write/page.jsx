'use client'
import "../common.css";
import {useState} from "react";
import Link from "next/link";
import axios from "axios";
export default function WritePage(){

    const [info,setInfo]=useState({subject:'',content:'',user_name:''});
    const id = sessionStorage.getItem("id");
    const token = sessionStorage.getItem("token");

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

        const {data} = await axios.post('http://localhost/write',formData,
            {headers:{Authorization:token, "enc-type": "multipart/form-data", "Content-Type": "application/json"}});
        console.log(data);
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
                {/*<tr>*/}
                {/*    <th>사진</th>*/}
                {/*    <td><input type="file" name="files" multiple="multiple"/></td>*/}
                {/*</tr>*/}
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