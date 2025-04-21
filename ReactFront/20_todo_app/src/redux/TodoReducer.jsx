
// reducer : slice 로도 불리며 state 를 수정하는 함수와 해당 state 를 관리
import {createSlice} from "@reduxjs/toolkit";

const TodoReducer = createSlice({
    name:'todo', // store 에 등록시 사용할 이름(필수는 아님)
    initialState:{//state 초기값(여러 컴포넌트에서 사용 할 수 있음)
        idx:3,
        list:[
            {idx:1, todo:'Spring Boot 공부', done:true},
            {idx:2, todo:'React.js 공부', done:false},
            {idx:3, todo:'Redux 공부', done:false},
        ]
    },
    reducers:{// 위 state 를 관리할 리듀서들...
        insert(state, action){//state, 보내온 값(payload)
            state.idx++;
            let todo = {idx:state.idx, todo:action.payload, done:false};
            state.list.push(todo);
            return state;
        },
        toggle(state, action){
            let index = state.list.findIndex((item)=>{
                return item.idx === action.payload;
            });
            state.list[index].done = !state.list[index].done;
            return state;
        },
        del(state, action){
            let index = state.list.findIndex((item)=>{
                return item.idx === action.payload;
            });
            state.list.splice(index, 1);
            return state;
        }
    }
});

// slice 의 reducer 들을 외부에서 사용 할 수 있도록 공개
export default TodoReducer.reducer;