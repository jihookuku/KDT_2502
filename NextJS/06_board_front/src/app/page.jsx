'use client'
import {useEffect, useRef, useState} from "react";
import axios from "axios";
import Link from "next/link";
import "./List.css";


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

    const more=()=>{
        page.current++;
        console.log(page.current+' page 호출');
        makeList();
    }

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
            setList([...list,content]);

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
            {pages > page.current ? <div className="more" onClick={more}>더보기</div> : ''}

        </div>
    );
}