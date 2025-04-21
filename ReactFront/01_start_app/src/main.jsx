import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'    // css 불러오기
import App from './App.jsx' // App.jsx 에서 모듈을 불러온다.

// root 에 그린다.
createRoot(document.getElementById('root')).render(
  <StrictMode> {/*엄격한 문법 모드(자체 로그를 찍는다.)*/}
    <App /> {/* App 함수 또는 클래스의 컴포넌트를 의미한다. */}
  </StrictMode>,
)
