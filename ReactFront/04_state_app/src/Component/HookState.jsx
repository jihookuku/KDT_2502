
// 객체에서 원하는 요소만 가져오고 싶을 경우 {요소} 활용 가능
// state 는 본래 class 에서만 사용 가능했다.
// 하지만 함수형 컴포넌트로 필요하기에 사용할수 있는 편법(Hook)을 제공한다.
import {useState} from "react";

export default function HookState({name}) {

    console.log(name);
    // state 값을 기본 100 으로 설정하여 생성
    //[state,setState함수]
   const [count,setCount] =  useState(100);

    const downCount = () => {
        setCount(count-1);
    };

    return(
        <div style={{margin:10}}>
            <h3>COUNT : {count}</h3>
            <button onClick={downCount}>down count</button>
        </div>);
}