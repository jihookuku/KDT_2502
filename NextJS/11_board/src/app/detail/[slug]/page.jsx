'use client'
// Component 함수에 async 가 붙으면 use client 를 사용할 수 없다.
import {useEffect} from "react";
import Link from "next/link";
import "../../common.css";
export default function DetailPage(props){

    useEffect(() => {
        props.params.then(({slug})=>{
            console.log("idx :"+slug);
            // axios 로 slug 를 가지고 해당 상세 정보를 서버에 요청
        });
    },[]);

    return(
        <>
            <table className={"form"}>
                <tbody>
                <tr>
                    <th>제목</th>
                    <td></td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td></td>
                </tr>
                <tr>
                    <th>작성일</th>
                    <td></td>
                </tr>
                <tr>
                    <th>조회수</th>
                    <td></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td></td>
                </tr>
                {/*<tr>*/}
                {/*    <th>사진</th>*/}
                {/*    <td>*/}
                {/*        <p>*/}
                {/*            <img src="" width="300px"/>*/}
                {/*        </p>*/}
                {/*        <br/>*/}
                {/*        <a href="#">다운로드</a>*/}
                {/*        <br/>*/}
                {/*    </td>*/}
                {/*</tr>*/}
                <tr>
                    <th colSpan="2">
                        <Link href={"/list"}>
                            <input type="button" value="리스트"/>
                        </Link>
                        <input type="button" value="삭제"/>
                        <input type="button" value="수정"/>
                    </th>
                </tr>
                </tbody>
            </table>
        </>
    );
}