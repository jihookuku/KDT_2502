'use client'
import "./common.css"
export default function LoginPage(){
    return(
        <>
            <h3>로그인</h3>
            <hr/>
            <table>
                <tbody>
                <tr>
                    <th>ID</th>
                    <td><input type="text" name="id" placeholder="아이디를 입력 하세요"/></td>
                    <th rowSpan="2">
                        <input className="login" type="button" value="로그인"/>
                    </th>
                </tr>
                <tr>
                    <th>PW</th>
                    <td><input type="text" name="pw" placeholder="비밀번호를 입력 하세요"/></td>
                </tr>
                </tbody>
            </table>
        </>
    );
}