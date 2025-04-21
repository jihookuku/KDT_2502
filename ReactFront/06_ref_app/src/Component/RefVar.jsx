import {useRef, useState} from "react";

export default function RefVar() {

    const [cnt,setCnt] = useState(0);
    const refVal = useRef(0); // 값을 저장하고 싶을 경우 초기값을 넣어주자

    // state 는 값 변화시 렌더링이 다시 된다.
    // ui 를 변화시키고 싶을때는 state 를 활용한다.
    const updateState = () => {
        setCnt(cnt+1);
    }

    // ref 는 값 변화시 렌더링이 되지 않는다.
    // 값이 변하더라도 재 렌더링이 되지 않길 원한다면 ref 를 활용 한다.
    const updateRef = () => {
        refVal.current += 1;
        console.log(refVal.current);
    }

    return (
        <div style={{margin:20}}>
            <button onClick={updateState}>state count : {cnt}</button>
            <button onClick={updateRef}>ref count : {refVal.current}</button>
        </div>
    );
}

