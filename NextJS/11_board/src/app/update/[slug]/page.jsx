'use client'
import Link from "next/link";
import "../../common.css";
import axios from "axios";
export default function UpdatePage(props){

    // axios 에서 await 을 쓰고 싶다면 그것을 실행하는 함수가 async 를 달고 있어야 한다.
    // 하지만  props.params 에서는 async 를 붙일수 없다.
    // 그럼 어떻게 처리 해야 할지...
    props.params.then(({slug})=>{
        console.log("idx:"+slug);
    });

    return (
        <>
            <table className={"form"}>
                <tbody>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="subject" value=""/></td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td><input type="text" name="user_name" value=""/></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><textarea name="content"></textarea></td>
                </tr>
                {/*<tr>*/}
                {/*    <th>사진</th>*/}
                {/*    <td>*/}
                {/*        <p>*/}
                {/*            <img src="" width="500px"/>*/}
                {/*        </p>*/}
                {/*    </td>*/}
                {/*</tr>*/}
                {/*<tr>*/}
                {/*    <th>사진 추가</th>*/}
                {/*    <td><input type="file" name="files" multiple="multiple"/></td>*/}
                {/*</tr>*/}
                <tr>
                    <th colSpan="2">
                        <Link href={"/list"}>
                            <input type="button" value="리스트"/>
                        </Link>
                        <button>저장</button>
                    </th>
                </tr>
                </tbody>
            </table>
        </>
    );
}