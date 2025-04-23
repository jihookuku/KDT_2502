'use client'
import Input from "@/app/list/Input";
import "./todo.css";
import {useEffect, useState} from "react";
import axios from "axios";
import List from "@/app/list/List";

export default function TodoPage(){

    const[list,setList]=useState([]);

    useEffect(()=>{
        getList();
    },[]);

    const getList=async()=>{
        const token = sessionStorage.getItem("token");
        const loginId = sessionStorage.getItem("loginId");
        const {data} = await axios.post('http://localhost/list',{"id":loginId}, {headers:{authorization: token}})
        console.log(data);
        setList(data.list);
        loginChk(data.loginYN);
    }

    const loginChk=(loginYN)=>{
        if(!loginYN){
            alert('로그인 하지 않았거나 만료된 토큰 입니다.\r\n 다시 로그인 해 주세요!');
            location.href='/';
        }
    }

    return(
        <>
            <h3>해야 할 일</h3>
            <Input loginChk={loginChk}/>
            <List list={list} getList={getList} loginChk={loginChk}/>
        </>
    );
}