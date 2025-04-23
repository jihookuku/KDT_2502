'use client'
import "../member.css"
import {useRef, useState} from "react";
import axios from "axios";

export default function JoinPage(){

    const[info,setInfo]=useState({id:'',pw:'',name:'',age:20,gender:'',email:''});
    let chk = useRef(false);

    const input=(e)=>{
        let {name,value} = e.target;
        //console.log(name,value);
        setInfo({...info, [name]:value});
    };

    const overlay=async (e) => {
        if(info.id == ''){
            alert('아이디를 입력 하세요');
        }else {
            let {data} = await axios.get('http://localhost/overlay/'+info.id);
            if(data.use){
                alert(`${info.id} 는 사용 가능한 아이디 입니다.`);
                chk.current = true;
            }else{
                alert(`${info.id} 는 사용중인 아이디 입니다.`);
                setInfo({...info, id:''});
            }
        }
    }

    const join=async()=>{
        if(chk.current){
            let{data} = await axios.post('http://localhost/join/',info);
            if(data.success){
                alert('회원가입에 성공 했습니다.');
                location.href='/';
            }else{
                alert('회원가입에 실패 했습니다.');
            }
        }else{
            alert('중복체크를 수행해 주세요!');
        }
    }

    return(
        <>
            <h3>회원가입</h3>
            <table>
                <tbody>
                    <tr>
                        <th>ID</th>
                        <td>
                            <input type="text" name="id" onChange={input} value={info.id}/>
                            <button type="button" id="overlay" onClick={overlay}>중복체크</button>
                        </td>
                    </tr>
                    <tr>
                        <th>PW</th>
                        <td>
                            <input type="text" name="pw" onChange={input} value={info.pw}/>
                        </td>
                    </tr>
                    <tr>
                        <th>NAME</th>
                        <td>
                            <input type="text" name="name" onChange={input} value={info.name}/>
                        </td>
                    </tr>
                    <tr>
                        <th>AGE</th>
                        <td>
                            <input type="text" name="age" onChange={input} value={info.age}/>
                        </td>
                    </tr>
                    <tr>
                        <th>GENDER</th>
                        <td>
                            <input type="radio" name="gender" value="남" onChange={input}/> 남
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="radio" name="gender" value="여" onChange={input}/> 여
                        </td>
                    </tr>
                    <tr>
                        <th>EMAIL</th>
                        <td>
                            <input type="text" name="email" onChange={input} value={info.email}/>
                        </td>
                    </tr>
                    <tr>
                        <th colSpan="2">
                            <input type="button" value="회원가입" onClick={join}/>
                        </th>
                    </tr>
                </tbody>
            </table>
        </>
    );
}