'use client'
import "../common.css";
import {useState} from "react";
import axios from "axios";
//npm install axios

export default function Join(){

    const [info,setInfo]=useState({id:'',pw:'',name:'',age:20,gender:'',email:''});
    let chk = false;

    const input=(e)=>{
        let {name,value} = e.target;
        //console.log(name,value);
        setInfo({...info,[name]:value});
    }

    const overlay=async()=>{
        console.log(info);
        const {data} = await axios.get(`http://localhost/overlay/${info.id}`);
        //console.log(data);
        if(data.use){
            alert('사용가능한 아이디 입니다.');
            chk = true;
        }else{
            alert('이미 사용중인 아이디 입니다.');
            setInfo({...info,id:''});
        }
    }

    const join= async()=>{
        console.log(info);
        console.log('overlay check : ',chk);

        if(chk){// chk 가 true 이고, info 내의 값이 모두 있다면..
           const {data} = await axios.post('http://localhost/join/',info);
           if(data.success){
               alert('회원가입에 성공 하였습니다.');
               location.href='/';
           }else {
               alert('회원가입에 실패 하였습니다.');
           }

        }else{
            alert('아이디 중복 체크를 먼저 해 주세요!');
        }

    }

    return (
        <>
            <h3>회원가입 페이지</h3>
            <hr/>
            <table>
                <tbody>
                <tr>
                    <th>아이디</th>
                    <td>
                        <input type="text" name="id" onChange={(e)=>{input(e)}} value={info.id}/>
                        <button onClick={overlay}>중복 체크</button>
                    </td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password" name="pw" onChange={(e)=>{input(e)}}/></td>
                </tr>
                <tr>
                    <th>이름</th>
                    <td><input type="text" name="name" onChange={(e)=>{input(e)}}/></td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td><input type="email" name="email" onChange={(e)=>{input(e)}}/></td>
                </tr>
                <tr>
                    <th>성별</th>
                    <td>
                        <input type="radio" name="gender" value="남자" onChange={(e)=>{input(e)}}/> 남자
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="gender" value="여자" onChange={(e)=>{input(e)}}/>여자
                    </td>
                </tr>
                <tr>
                    <th>나이</th>
                    <td><input type="number" min="20" max="80" name="age" onChange={(e)=>{input(e)}}/></td>
                </tr>
                <tr>
                    <th colSpan="2">
                        <button onClick={join}>회원가입</button>
                    </th>
                </tr>
                </tbody>
            </table>
            </>
        );
   }