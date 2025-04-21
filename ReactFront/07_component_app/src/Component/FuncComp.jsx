import {useRef, useState} from "react";

export default function FuncComp() {

    const[count,setCount]=useState(0);
    const refVal = useRef(0);

    const updateCount=()=>{
        setCount(count + 1);
        refVal.current=count+1;
    }

    const alertCount=()=>{
        setTimeout(()=>{
            //render 함수에 영향받지 않는 ref 는 alert 이 실행되어도 데이터를 가져올 수 있다.
            alert('You clicked On : '+refVal.current);
        },3000);
    }

    const btnStyle={
        margin:'5px',
    }

    return (
        <div>
            <h3>You Click {count}  times</h3>
            <button
                style={btnStyle}
                onClick={updateCount}>click me!!</button>

            <button
                style={btnStyle}
                onClick={alertCount}>show alert</button>
        </div>
    );
}