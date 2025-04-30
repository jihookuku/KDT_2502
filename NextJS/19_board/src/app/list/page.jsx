'use client'
import Link from "next/link";
import {useEffect} from "react";
import {store} from "@/redux/store";
import {useSelector} from "react-redux";
import List from "./List";

export default function ListPage(){

    useEffect(() => {callList(1)}, []);

    const callList = async (no)=>{
        store.dispatch({type:'board/list',payload:no});
    };

    let board = useSelector(state => {
        //console.log(state.board);
        return state.board
    });

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
                    <th>삭제</th>
                </tr>
                </thead>
                <tbody>
                    <List board={board}/>
                </tbody>
            </table>
        </>
    );
}