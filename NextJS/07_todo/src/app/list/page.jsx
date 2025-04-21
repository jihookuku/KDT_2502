'use client'
import Input from "@/app/list/Input";
import {useEffect, useRef, useState} from "react";
import axios from "axios";
import List from "@/app/list/List";

export default function ListPage(props) {

    const [list,setList] = useState([]);
    const id = useRef('');

    useEffect(() => {
        if(typeof window !== 'undefined') {
            id.current = sessionStorage.getItem('loginId');
        }
        getList(id.current);
    },[]);

    const getList = async(loginId) => {
        console.log(loginId+' list 호출 실행');
        let {data} = await axios.post('http://localhost/list',{"id":loginId});
        console.log(data);
        if(!data.loginYN){
            alert('로그인이 필요한 서비스 입니다.');
            location.href='/';
        }
        setList(data.list);
    }

    return (
        <>
            <Input id={id.current} getList={getList}/>
            <List id={id.current} list={list}/>
        </>
    );
}