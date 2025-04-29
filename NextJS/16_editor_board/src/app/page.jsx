'use client'
import {useEffect, useState} from "react";
import axios from "axios";
// npm install axios
export default function LoginPage(props) {

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
        const {data} = await axios.post("http://localhost/login",info);
        console.log(data);
        debugger; // F12 개발자 모드에서만 동작(개발 종료시 지워줘야 한다.)
        if(data.success){
            sessionStorage.setItem('token',data.token);
            sessionStorage.setItem('id',info.id);
            debugger; // F12 개발자 모드에서만 동작(개발 종료시 지워줘야 한다.)
            location.href='/list';
        }else {
            alert('아이디 또는 비밀번호를 확인해 주세요!');
        }
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