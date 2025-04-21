//npm install react-redux
//npm install @reduxjs/toolkit
import { createRoot } from 'react-dom/client'
import {Provider} from "react-redux";
import App from './App.jsx'
import Store from "./redux/Store.jsx";

//store 를 반드시 Provider 로 등록 해 주자
createRoot(document.getElementById('root')).render(
<Provider store={Store}>
    <App />
</Provider>
)
