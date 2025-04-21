// npm install react-router-dom
// 으로 라우터를 설치해야 함

import Home from "./component/Home.jsx";
import First from "./component/First.jsx";
import Second from "./component/Second.jsx";
import {BrowserRouter, Link, Route, Routes} from "react-router-dom";
import Topic from "./component/Topic.jsx";

export default function App() {
    // Link to -> Route path -> 특정 컴포넌트로 이동
    return (
        // Link 는 BrowserRouter 로 감싸져 있어야 한다.
        <BrowserRouter>
            <ul>
                <li><Link to="/">Home 이동</Link></li>
                <li><Link to="/first">First 이동</Link></li>
                <li><Link to="/second">Second 이동</Link></li>
                <li><Link to="topics">서브경로 예시</Link></li>
            </ul>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/first" element={<First />} />
                <Route path="/second" element={<Second />} />
                {/*topics 이후 무언가 붙어서 온다면... @PathVariable 과 비슷*/}
                <Route path="/topics/*" element={<Topic/>}/>
            </Routes>
        </BrowserRouter>
    );
}