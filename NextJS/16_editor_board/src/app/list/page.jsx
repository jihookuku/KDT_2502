'use client'
import Link from "next/link";
import axios from "axios";
import {useEffect, useState} from "react";
import {Pagination, Stack} from "@mui/material";
// npm install @mui/material @emotion/react @emotion/styled

export default function ListPage(){

    useEffect(() => {
        callList(1);
    }, []);

    const [list, setList] = useState([]);
    const [page, setPage] = useState(0);

    const callList = async (no)=>{
        const id = sessionStorage.getItem('id');
        const token = sessionStorage.getItem('token');
        const {data} = await axios.get(`http://localhost/list/${id}/${no}`,{headers: {'Authorization': token}});
        console.log(data);
        setPage(data.pages);
        let content = data.list.map(item=>(
            <tr key={item.idx}>
                <td>{item.idx}</td>
                <td><Link href={`/detail/${item.idx}`}>{item.subject}</Link></td>
                <td>{item.user_name}</td>
                <td>{item.reg_date}</td>
            </tr>
        ));
        setList(content);
    }

    return(
        <>
            <Link href={'/write'}><button>글쓰기</button></Link>
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                    </tr>
                </thead>
                <tbody>
                    {list}
                    <tr>
                        <th colSpan={4}>
                            <Stack spacing={2}>
                                <Pagination count={page} onChange={(e,page)=>{
                                    console.log(e);
                                    callList(page)
                                }}/>
                            </Stack>
                        </th>
                    </tr>
                </tbody>
            </table>
        </>
    );
}