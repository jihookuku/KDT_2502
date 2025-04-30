'use client'
// npm install axios
// npm install react-redux @reduxjs/toolkit
// npm install @mui/material @emotion/react @emotion/styled
import {useEffect, useState} from "react";
import {store} from "@/redux/store";

export default function LoginPage(){
    const [info, setInfo] = useState({id:'',pw:''});

    useEffect(() => {
        sessionStorage.removeItem('token');
        sessionStorage.removeItem('id');
    },[]);

    const input=(e)=>{
        let {name, value} = e.target;
        setInfo({...info, [name]: value});
    }

    const login=async()=>{
        store.dispatch({type:'member/login',payload:info});
    }


    return (
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