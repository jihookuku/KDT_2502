import {configureStore} from "@reduxjs/toolkit";
import TodoReducer from "./TodoReducer.jsx";

// createStore() 는 deprecated 되었다.
// 그래서 configureStore 사용을 권장함
// store        : state 를 관리하는 객체
// reducer    : state 를 변화 시키는 함수(이때 action 을 활용함)
// patch       : 특정 reducer 를 호출하는 함수
// describe   : state 변화 후 호출 되는 callback 함수

// redux toolkit 에서는 위 내용을 조금 더 통합적으로 관리함
// store 는 reducer 를 등록하고 관리함
const Store = configureStore({
    reducer: {
        todo: TodoReducer
    }
});

export default Store;