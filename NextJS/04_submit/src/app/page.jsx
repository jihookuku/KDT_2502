'use client'
// next.js 는서버와 클라이언트를 모두 다룰수 있는 프레임워크 이다.
// 그래서 특정 이벤트등을 사용할 경우 이것이 client 용인가, server 용 인가 표시해 줘야 한다.
// 'use client' 'use server' 를 사용하는데, 우리는 client 용으로만 사용 할 것 이므로 앞으로 page 에는 'use client' 를 추가해 준다.
// npm install axios
import axios from "axios";
import {useState} from "react";
import Post from "@/app/Post";

// "/" 를 대표하는 페이지
export default function App(){

    const url = 'https://jsonplaceholder.typicode.com/posts/';
    const [list, setList] = useState([]);

    const send = async() =>{
        let {data} = await axios.get(url);
        //console.log(data);
        setList(data);
    }

    return (
        <div>
            <h3>서버로 부터 json 받아오기</h3>
            <button onClick={send}>요청</button>
            <hr/>
            <Post list={list}/>
        </div>
    );
}