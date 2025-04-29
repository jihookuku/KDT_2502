'use client'
import Link from "next/link";
import {useEffect, useRef, useState} from "react";
import axios from "axios";

export default function WritePage(){

    let div = useRef(null);
    let editor = useRef(null);
    const [info, setInfo] = useState({user_name:'',content:'',subject:''});

    useEffect(() => {
        const id = sessionStorage.getItem('id');
        setInfo({...info,user_name:id});
        editor.current = new RichTextEditor(div.current,{
            maxWidthForMobile:'332px',
            editorResizeMode:'none',
        });
    }, []);

    const save = () => {
        let code = editor.current.getHTMLCode();
        // console.log(code.length/1024+'KB');
        // 총 컨텐츠가 20MB 를 넘어갔을 경우 저장하지 않는다.
        if(code.length>=(20*1024*1024)){
            alert('컨텐츠가 너무 큽니다. 이미지의 크기나 갯수를 줄여 주세요');
        }else{
            const token = sessionStorage.getItem('token');
            setInfo({...info,content:code});
            axios.post('http://localhost/write',info,{headers:{Authorization:token}})
                .then(({data})=>{
                    console.log(data);
                    debugger;
                    if(data.success){
                        alert('글쓰기가 성공 하였습니다.');
                        location.href = '/detail/'+data.idx;
                    }
                });
        }
    }

    return(
        <>
            <h3>글쓰기</h3>
            <table className={"editor_table"}>
                <tbody>
                <tr>
                    <td>
                        <input type={"text"}
                               name={"subject"}
                               value={info.subject}
                                placeholder={"제목"}
                                onChange={(e)=>setInfo({...info,subject:e.target.value})}/>
                    </td>
                </tr>
                <tr>
                    <td><input type={"text"} name={"subject"} value={info.user_name} placeholder={"작성자"}  readOnly={true}/></td>
                </tr>
                <tr>
                    <td><div ref={div}></div></td>
                </tr>
                <tr>
                    <th>
                        <Link href={'/list'}>리스트</Link>
                        <button onClick={save}>저장</button>
                    </th>
                </tr>
                </tbody>
            </table>
        </>
    );
}