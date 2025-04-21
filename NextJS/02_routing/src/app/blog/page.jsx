import Link from "next/link";

export default async function BlogMain(props){//params, searchParams
    //console.log(props);
    // /blog/11 의 경우 blog 폴더 밑에 11 폴더를 찾으므로 404 발생
    // ?idx=11&req=detail 의 경우 ? 뒤는 파라메터이기 떼문에 searchParams 로 받아낼 수 있다.
    /*
    props.params.then(val=> console.log('params',val));
    props.searchParams.then(val=> console.log('searchParams',val));
    */

    const param = await props.params;
    console.log('params',param);

    const search = await props.searchParams;
    console.log('search',search);

    let list = Object.keys(search).map(key => {
        console.log(key+':'+search[key]);
        return <li key={key}>{key}+:+{search[key]}</li>;
    });

    return (
        <div>
            <h1>blog/page.jsx</h1>
            <Link href="/">되돌아가기</Link>
            <p>받아온 파라메터</p>
            <ul>{list}</ul>
        </div>
    );
}