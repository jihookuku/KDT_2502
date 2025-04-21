// npm install redux
// npm install react-redux

import {createStore} from "redux";
import {useState} from "react";

//2. Store : state 를 저장하는 저장소, state 를 변경할 함수(리듀서)를 등록해 둔다.
const store = createStore(counter);

export default function App() {

    const [cnt, setCnt] = useState(0);
    console.log('cnt state : ',cnt);

    const updateState = (mode) => {
        //console.log(mode);
        //3. dispatch : 리듀서에게 특정 action 을 주고 store 의 state 를 변경하도록 요청한다.
        store.dispatch({type:mode});
    }

    // 4. state 의 변화가 생기면 해당 store 를 구독중이던 함수가 실행 된다.
    store.subscribe(()=>{
        let state = store.getState();
        console.log("현재 state 값 : ",state);
        setCnt(state);
    });

    return(
        <div>
            <h3>COUNT : {cnt}</h3>
            <button onClick={()=>{updateState('UP')}}>Increment</button>
            <button onClick={()=>{updateState('DOWN')}}>Decrement</button>
        </div>
    );
}

//1. Reducer : dispatch 의요청에 따라 state 값을 수정하는 함수
function counter(state=0,action){ // dispatch 로 부터 오는 요청 값을 action 이라고 한다.
   // console.log(state,action);
    switch(action.type){
        case 'UP':
            return state+1;

        case 'DOWN':
            return state-1;

        default:
            return state;
    }

}









