'use client'
import "../common.css"
import Link from "next/link";
import {useEffect, useRef, useState} from "react";
import axios from "axios";
export default function ListPage(){

    let page = useRef(1);
    const [list, setList] = useState([]);
    const[pages, setPages] = useState(1);

    useEffect(()=>{
        callList(page.current);
    },[]);

    const callList=async(p)=>{
        const id = sessionStorage.getItem("id");
        const token = sessionStorage.getItem("token");
        const {data} = await axios.get(`http://localhost/list/${id}/${p}`,{headers:{Authorization:token}});
        console.log(data);
        setPages(data.pages); // 보여줄 수 있는 페이지
        page.current = data.page; // 현재페이지
        
        let content = data.list.length == 0 ? (<tr><th colSpan="6">작성된 글이 없습니다.</th></tr>)
            : data.list.map(item=>{
                return(
                    <tr key={item.idx}>
                        <td>{item.idx}</td>
                        <th>
                            {item.cnt > 0 ? <img src="/image.png" width="25px"/> : <img src="/noimage.png" width="25px"/>}
                        </th>
                        <td><Link href={`/detail/${item.idx}`}>{item.subject}</Link></td>
                        <td>{item.user_name}</td>
                        <td>{item.bHit}</td>
                        <td>{item.reg_date}</td>
                    </tr>
                );
            });

        setList([...list,content]);
    }

    return(
        <>
            <Link href={"/write"}>
                <button>글쓰기</button>
            </Link>
            <table className="list">
                <thead>
                <tr>
                    <th>idx</th>
                    <th>이미지</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>조회수</th>
                    <th>작성일</th>
                </tr>
                </thead>
                <tbody>
                   {list}
                </tbody>
            </table>
            {pages > page.current ? <button onClick={()=>{callList(page.current+1)}}>더보기</button> : ''}
        </>
    );
}