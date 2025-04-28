'use client'
import {useEffect, useRef, useState} from "react";
import axios from "axios";
import Link from "next/link";
import "./List.css";
import {Pagination, Stack} from "@mui/material";
// npm install @mui/material @emotion/react @emotion/styled

export default function App(){
    // list, detail, delete 중에서 페이지가 필요한 녀석은?
    // list, detail
    const [list, setList] = useState([]);
    const [pages, setPages] = useState(1);
    let page = useRef(1);

    useEffect(()=>{
        // 서버에 리스트 요청 (/list/1)
        makeList();
    },[]);
    /*
    const more=()=>{
        page.current++;
        console.log(page.current+' page 호출');
        makeList();
    }
    */
    const makeList=()=>{
        axios.get(`http://localhost/list/${page.current}`).then(({data})=>{
            console.log(data);
            setPages(data.pages);
            console.log(page.current+'=='+data.pages);
            let content = data.list.map((item)=>{
                console.log(item);
                return(
                    <div key={item.idx} className="post">
                        <Link href={`/detail/${item.idx}`}>
                            <div className="title">
                                {item.idx} : {item.subject}
                            </div>
                        </Link>
                        <div className="sub">{item.user_name}</div>
                    </div>
                );
            });
            //setList([...list,content]);
            setList(content);
        });
    }


    const changePage=(e,val)=>{
        console.log(val,e);
        page.current=val;
        makeList();
    }

    return (
        <div>
            <h3>리스트 가져오기</h3>
            <Link href="/write"><button>글쓰기</button></Link>
            <p>current page : {page.current} / total page : {pages}</p>
            <hr/>
            {list}
            <div style={{margin:15}}>
                <Stack spacing={2}>
                    <Pagination 
                        count={pages}// 전체 페이지 수
                        color={"primary"}
                        variant={"outlined"}
                        shape={"rounded"}
                        siblingCount={0} // 현재 페이지 양쪽에 표시할 갯수
                        onChange={changePage}
                    />
                </Stack>
            </div>
        </div>
    );
}