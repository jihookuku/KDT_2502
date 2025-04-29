'use client'
import {store} from "@/redux/store";
import {useSelector} from "react-redux";

export default function HomePage(){

    const countUp = () => {
       store.dispatch({type:'counter/increment', payload:'매개변수'});
    };

    const countDn = () => {
        store.dispatch({type:'counter/decrement', payload:'매개변수'});
    };

    let cnt = useSelector(state => { // store 에 등록된 모든 slice의 state 정보
        console.log(state);
        return state.counter.count;
    });

    return (
        <div>
            <h3>COUNT : {cnt}</h3>
            <button onClick={countUp}>증가</button>
            <button onClick={countDn}>감소</button>
        </div>
    );
}