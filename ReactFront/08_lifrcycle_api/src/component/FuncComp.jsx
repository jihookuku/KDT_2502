import {useEffect, useState} from "react";

export default function FuncComp() {

    const [cnt,setCnt] = useState(0);

    // componentDidMount
    useEffect(() => {
        console.log('컴포넌트가 최초 랜더링되면 호출!');
    }, []);
    
     // shouldComponentUpdate
    useEffect(() => {
        console.log('cnt 값이 변경될 때만 호출');
        // shouldComponentUpdate 처럼 변화가 없을경우 렌더링하지 않는 기능은
        // 나중에 배울 memo 를 통해서 가능 하다.
    }, [cnt]);// [] 안에는 , 를 통해서 여러 state 를 지정 할 수 있다.

    // componentWillUnmount
    useEffect(() => {
        console.log('컴포넌트가 최초 랜더링되면 호출!');
        return () => {
            console.log('컴포넌트가 할 일을 다 끝내고 사라질때 할 일들...');
        }
    }, []);

    return (
        <div>
            <h3>COUNT : {cnt}</h3>
            <button onClick={()=>{setCnt(cnt+1)}}>+</button>
            <button onClick={()=>{setCnt(cnt-1)}}>-</button>
        </div>);
}