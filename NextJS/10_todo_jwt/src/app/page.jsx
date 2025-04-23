// login page -> "/"
// join page -> "/join"
// todo-list page -> "/list"
'use client'
import "./member.css"
import Link from "next/link";
import axios from "axios";
import {useEffect, useState} from "react";

export default function LoginPage(){

    const [info, setInfo] = useState({id:'',pw:''});

    useEffect(()=>{
            const loginId = sessionStorage.getItem("loginId");
            const token = sessionStorage.getItem("token");
            if(loginId != null){
                sessionStorage.removeItem("loginId");
            }
            if(token != null){
                sessionStorage.removeItem("token");
            }
            console.log("loginId : ",loginId);
            console.log("token : ",token);
    },[]);



    const input=(e) => {
        let {name, value} = e.target;
        setInfo({...info,[name]:value});
    }

    const login = async () => {
        let {data}=await axios.post('http://localhost/login',info);
        if(data.success){
            alert('로그인에 성공 했습니다.');
            sessionStorage.setItem('token',data.token);
            sessionStorage.setItem('loginId',info.id);
            location.href='/list';
        }else{
            alert('아이디 또는 비밀번호를 확인하세요!');
        }
    }

    return(
        <>
            <h3>로그인</h3>
            <table>
                <tbody>
                    <tr>
                        <th>ID</th>
                        <td><input type="text" name="id" onChange={input} value={info.id}/></td>
                    </tr>
                    <tr>
                        <th>PW</th>
                        <td><input type="password" name="pw" onChange={input} value={info.pw}/></td>
                    </tr>
                    <tr>
                        <th colSpan="2">
                            <button onClick={login}>LOGIN</button>
                            <Link href="/join">회원가입</Link>
                        </th>
                    </tr>
                </tbody>
            </table>
        </>
    );
}