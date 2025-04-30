'use client'
import {useEffect, useRef} from "react";
import Link from "next/link";
import {useSelector} from "react-redux";
import {store} from "@/redux/store";

export default function DetailPage(props){

    let div = useRef(null);
    let editor = null;
    let idx = 0;

    useEffect(() => {
        // 적용 element, config
        editor = new RichTextEditor(div.current,{
            maxWidthForMobile:'332px', // 모바일버전으로 변경되는 사이즈
            editorResizeMode:'none',
            toolbar: 'simple',
            toolbar_simple:'{save, print, html2pdf, code}' // html 저장, 출력, pdf 저장, html 코드로 보기
        });
        getDetail();
    }, []);


    let info = useSelector(({board}) => {
        //console.log(board);
        if(editor != null){ // getDetail 에서 에디터를 만들때 아직 데이터를 받지 못해 제대로 표시되지 않는다.
            console.log('editor',editor);
            console.log('info',board.detail);
            editor.setHTMLCode(board.detail.content);
            editor.setReadOnly();
        }
        return board.detail;
    });

    const getDetail = async()=>{
        idx = (await props.params).slug;
        store.dispatch({type:'board/detail',payload:idx});
        console.log(idx,info);
    }

    return(
        <>
            <h3>상세보기</h3>
            <table className={"editor_table"}>
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