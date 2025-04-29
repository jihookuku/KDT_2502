'use client'
import {useEffect, useRef, useState} from "react";
import axios from "axios";
import Link from "next/link";

export default function DetailPage(props){

    useEffect(() => {
        // detail/30 에서 30을 가져왔던 방법?
        // params 는 Promise 객체 이므로 일반적인 방법으로는 빼 올 수 없다.
        //console.log(props.params.slug); // props.params.slug
        // Promise 객체를 대하는 방법 
        // 1. then() 사용 -> 대신 처리 후 값을 반환 할 수 없다.
        // 2. await async 사용 -> 일부 함수에서 사용할 수 없다.
        // -> async 함수를 따로 만들어서 호출하는 방법을 사용
       props.params.then(({slug})=>{
           console.log(slug);
           getDetail(slug);
       });
    }, []);

    const [info,setInfo] = useState({});
    let div = useRef(null);
    let editor = null;

    const getDetail = async(idx)=>{
        const id = sessionStorage.getItem('id');
        const token = sessionStorage.getItem('token');
        let {data} = await axios.get(`http://localhost/detail/${id}/${idx}`,{headers:{Authorization: token}});
        console.log(data);
        setInfo(data.detail);
        // 적용 element, config
        editor = new RichTextEditor(div.current,{
            maxWidthForMobile:'332px', // 모바일버전으로 변경되는 사이즈
            editorResizeMode:'none',
            toolbar: 'simple',
            toolbar_simple:'{save, print, html2pdf, code}'
        });
        editor.setHTMLCode(data.detail.content);
        editor.setReadOnly();
    }

    return(
        <>
            <h3>상세보기</h3>
            <table>
                <tbody>
                    <tr>
                        <td>제목 : {info.subject}</td>
                    </tr>
                    <tr>
                        <td>작성자 : {info.user_name}</td>
                    </tr>
                    <tr>
                        <td>작성일 : {info.reg_date}</td>
                    </tr>
                    <tr>
                        <td><div ref={div}></div></td>
                    </tr>
                    <tr>
                        <th><Link href={'/list'}>리스트</Link></th>
                    </tr>
                </tbody>
            </table>
        </>
    );
}