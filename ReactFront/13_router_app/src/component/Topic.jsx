import {Link, Route, Routes, useParams} from "react-router-dom";

export default function Topic() {
    // 여기서는 BrowserRouter 가 감싸져 있지 않은데?
    // 이미 해당 영역에 들어가 있어서...
    return (
        <div>
            <h2>topics</h2>
            <ul>
                <li><Link to="/topics/13">13번 주제</Link></li>
                <li><Link to="/topics/14">14번 주제</Link></li>
            </ul>
            <Routes>
                <Route path="/:idx" element={<Post/>} />
            </Routes>
        </div>
    );
}

function Post(){
    const param = useParams();
    console.log(param);
    return (
        <h3>요청하신 {param.idx} 번 글 내용 입니다.</h3>
    );
}