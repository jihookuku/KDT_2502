'use client'
import './commons.css';
import {useEffect, useState} from "react";
import axios from "axios";

export default function LoginPage(){

    const [info, setInfo] = useState({id:'',pw:''});

    useEffect(()=>{
        sessionStorage.removeItem('token');
        sessionStorage.removeItem('id');
    },[]);

    const input=(e)=>{
       let {name,value} = e.target;
       setInfo({...info, [name]:value});
    };

    const login = () => {
        // await-async : 비동기로 받은 내용을 외부로 반환하고 싶을때
        // then : 비동기로 받은 내용을 자체적으로 처리 하고 싶을때
        axios.post("http://localhost/login",info).then(({data})=>{
            console.log(data);
            if(data.success){
                sessionStorage.setItem("token",data.token);
                sessionStorage.setItem("id",info.id);
                //debugger;
                location.href='/list';
            }
        });
    };

    return(
        <table>
            <tbody>
                <tr>
                    <th>ID</th>
                    <td><input type={"text"} name={"id"} value={info.id} onChange={input}/></td>
                </tr>
                <tr>
                    <th>PW</th>
                    <td><input type={"password"} name={"pw"} value={info.pw} onChange={input}/></td>
                </tr>
                <tr>
                    <th colSpan={2}>
                        <button onClick={login}>로그인</button>
                    </th>
                </tr>
            </tbody>
        </table>
    );
}