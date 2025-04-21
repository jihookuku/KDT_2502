'use client'
import "./common.css";
import Link from "next/link";
import {useState} from "react";
import axios from "axios";
export default function Login(){

    const[id,setId]=useState("");
    const[pw,setPw]=useState("");

    const login = async ()=>{
        console.log(id,pw);
        const {data} = await axios.post('http://localhost/login',{"id":id,"pw":pw});
        console.log(data);
        if(data.success){
            alert('로그인에 성공 했습니다.');
            sessionStorage.setItem('loginId',id); // sessionStorage 에 loginId 를 저장(로그인 징표)
            location.href='/list';
        }else{
            alert('로그인에 실패 했습니다.');
        }
    }

    return(
        <>
            <h3>로그인</h3>
            <hr/>
            <table>
                <tbody>
                <tr>
                    <th>ID</th>
                    <td><input type="text" name="id"onChange={(e)=>{setId(e.target.value)}}/></td>
                    <td rowSpan="2">
                        <input className={"login"} type="button" value="로그인" onClick={login}/>
                    </td>
                </tr>
                <tr>
                    <th>PW</th>
                    <td><input type="password" name="pw" onChange={(e)=>{setPw(e.target.value)}}/></td>
                </tr>
                <tr>
                    <th colSpan="3">
                        <Link href="/join">
                            <input type="button" value="회원가입"/>
                        </Link>
                        <input type="button" value="아이디/비번 찾기"/>
                    </th>
                </tr>
                </tbody>
            </table>
        </>
    );
}