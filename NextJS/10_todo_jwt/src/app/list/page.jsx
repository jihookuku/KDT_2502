'use client'
import Input from "@/app/list/Input";
import "./todo.css";
import {useEffect, useState} from "react";
import axios from "axios";

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
        setList([...list,data.list]);
    }

    return(
        <>
            <h3>해야 할 일</h3>
            <Input />
            <div>LIST</div>
        </>
    );
}