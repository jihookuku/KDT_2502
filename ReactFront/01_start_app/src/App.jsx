import './App.css'
import React from "react";

// html 태그 자체를 넣을수도 있고, 그것을 요소 자체로 출력할수도 있다.
// 이 형태를 html + js + xml 이 뒤섞은 형태라 하여 jsx 템플릿 라고 한다.
//const html = <h3>Hello, React.js</h3>;

// 컴포넌트는 함수형태 또는 클래스 형태로 표현된다.
// 함수 컴포넌트 : 가장 널리 사용되는 형태
// 클래스 컴포넌트 보다 기능이 없지만 hooks 를 통해 많이 개선 되었다.
/*
function App() {
  // 밖으로 내보낼 내용
  return (
    <div>{html}</div>
  )
}
*/

import {Component} from "react";

// react.js 에서 사용하라고 한대 권고 했으나 현재는 권고까지는 아님
class App extends Component {
    render() {
        //{} 표시는 return 문 안에서 특정 변수의 내용을 사용하겠다는 뜻
        return (<h3>Hello, React.js</h3>);
    }
}

export default App
