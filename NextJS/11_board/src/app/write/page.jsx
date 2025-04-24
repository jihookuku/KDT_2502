'use client'
import "../common.css";
export default function WritePage(){

    return(
        <>
            <h3>글쓰기</h3>
            <hr/>
            <table className={"form"}>
                <tbody>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="subject"/></td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td><input type="text" name="user_name"/></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><textarea name="content"></textarea></td>
                </tr>
                <tr>
                    <th>사진</th>
                    <td><input type="file" name="files" multiple="multiple"/></td>
                </tr>
                <tr>
                    <th colSpan="2">
                        <input type="button" value="리스트"/>
                        <button>저장</button>
                    </th>
                </tr>
                </tbody>
            </table>
        </>
    );
}