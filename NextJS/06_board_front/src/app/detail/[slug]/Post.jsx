'use client'
import {useEffect, useState} from "react";
import axios from "axios";
import Link from "next/link";
import "./Post.css";

export default  function Post({idx}){

    const [post,setPost] = useState(null);

    useEffect(()=>{
        axios.get(`http://localhost/detail/${idx}`).then(({data})=>{
            console.log(data);   
            makeHTML(data.post);
        });
    },[]);
    
    const makeHTML = (info) => {
        console.log(info);
        let html = (
            <div>
                게시물이 존재하지 않습니다.
                <p>
                    <Link href="/">돌아가기</Link>
                </p>
            </div>
        );

        const del = async(idx) => {
            console.log('delete '+idx);
            const {data} = await axios.get(`http://localhost/delete/${idx}`);
            console.log(data);
            if(data.success){
                alert(data.idx+' 번 삭제가 성공 하였습니다.');
                location.href = '/';
            }else{
                alert(data.idx+' 번 삭제가 실패 하였습니다.');
            }
        }

        if(info != null){
            html = (
                <div>
                    <div className="header">
                        <div>작성자 : {info.user_name}</div>
                        <div>조회수 : {info.bHit}</div>
                    </div>
                    <div className="title">
                        제목 : {info.subject}
                    </div>
                    <hr/>
                    <div>{info.content}</div>
                    <hr/>
                    <div className="btn_area">
                        <Link href="/">리스트</Link>
                        <button onClick={()=>{del(info.idx)}}>삭제</button>
                    </div>
                </div>
            );
        }


        setPost(html);
    }

    return(
        <div>{post}</div>
    );
}





