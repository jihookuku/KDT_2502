// login page -> "/"
// join page -> "/join"
// todo-list page -> "/list"
import "./member.css"
import Link from "next/link";

export default function LoginPage(){
    return(
        <>
            <h3>로그인</h3>
            <table>
                <tbody>
                    <tr>
                        <th>ID</th>
                        <td><input type="text" name="id"/></td>
                    </tr>
                    <tr>
                        <th>PW</th>
                        <td><input type="password" name="pw"/></td>
                    </tr>

                    <tr>
                        <th colSpan="2">
                            <button>LOGIN</button>
                            <Link href="/join">회원가입</Link>
                        </th>
                    </tr>
                </tbody>
            </table>
        </>
    );
}