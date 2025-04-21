import Link from "next/link";

export default function Home(){
    return (
        <div>
            <h1>Main Page!!</h1>
            <p><Link href="/blog">blog 페이지 이동</Link></p>
            <p><Link href="/blog?idx=11&req=detail">파라메터 처리</Link></p>
            <p><Link href="/blog/11">@PathVariable 처럼 사용</Link></p>
        </div>
    );
}