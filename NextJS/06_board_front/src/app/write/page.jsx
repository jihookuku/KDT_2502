'use client'
import Link from "next/link";
import "./Write.css";
import {useState} from "react";
import axios from "axios";
export default function Write() {

    const [info, setInfo] = useState({user_name:'', subject:'',content:''});
    const input=(key,e)=>{
        setInfo({
            ...info,
            [key]:e.target.value,
        });
    }
    const write = async()=>{
        console.log(info);
        const {data}= await axios.post('http://localhost/write',info);
        console.log(data);
        if(data.success){
            alert('글쓰기에 성공 하였습니다.');
            location.href='/detail/'+data.idx;
        }else{
            alert('글쓰기에 실패 하였습니다.');
        }
    }
    return (
        <div className="write">
            <div className="header">
                <div>
                    <input type="text" value={info.user_name} placeholder="작 성 자" onChange={(e)=>{input('user_name',e)}}/>
                </div>
            </div>
            <div className="title">
                <input type="text" value={info.subject} placeholder="글 제 목" onChange={(e)=>{input('subject',e)}}/>
            </div>
            <hr/>
            <div><textarea onChange={(e)=>{input('content',e)}} value={info.content}></textarea></div>
            <hr/>
            <div className="btn_area">
                <Link href="/">리스트</Link>
                <button onClick={write}>글쓰기</button>
            </div>
        </div>
    );
}