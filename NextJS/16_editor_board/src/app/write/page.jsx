'use client'
import Link from "next/link";
import {useEffect, useRef} from "react";

export default function WritePage(){

    let div = useRef(null);
    let editor = null;

    useEffect(() => {
        editor = new RichTextEditor(div.current,{
            maxWidthForMobile:'332px',
            editorResizeMode:'none',
        });
    }, []);

    return(
        <>
            <h3>글쓰기</h3>
            <table className={"editor_table"}>
                <tbody>
                <tr>
                    <td><input type={"text"} name={"subject"} value={""} placeholder={"제목"}/></td>
                </tr>
                <tr>
                    <td><input type={"text"} name={"subject"} value={""} placeholder={"작성자"}  readOnly={true}/></td>
                </tr>
                <tr>
                    <td><div ref={div}></div></td>
                </tr>
                <tr>
                    <th>
                        <Link href={'/list'}>리스트</Link>
                        <button>저장</button>
                    </th>
                </tr>
                </tbody>
            </table>
        </>
    );
}