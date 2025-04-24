'use client'
import "../common.css"
import Link from "next/link";
import {useEffect, useRef} from "react";
import axios from "axios";
export default function ListPage(){

    let page = useRef(1);

    useEffect(()=>{
        callList(page.current);
    },[]);

    const callList=async(page)=>{
        const id = sessionStorage.getItem("id");
        const token = sessionStorage.getItem("token");
        const {data} = await axios.get(`http://localhost/list/${id}/${page}`,{headers:{Authorization:token}});
        console.log(data);
    }


    return(
        <>
            <Link href={"/write"}>
                <button>글쓰기</button>
            </Link>
            <table>
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
                <tr>
                    <th colSpan="6">작성된 글이 없습니다.</th>
                </tr>
                <tr>
                    <td></td>
                    <th>
                        <img src="/image.png" width="25px"/>
                        <img src="/noimage.png" width="25px"/>
                    </th>
                    <td><a href="#"></a></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                </tbody>
            </table>
        </>
    );
}