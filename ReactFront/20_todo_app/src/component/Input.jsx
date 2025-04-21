import {useState} from "react";
import store from "../redux/Store.jsx";

export default function Input() {
    const [input, setInput] = useState('');
    const keyUp = (e) => {
        if (e.keyCode === 13) {
            insert();
        }
    }
    const insert=()=>{ // slice에 있는 reducer 호출
        // type:'호출할 리듀서', payload:Action
        store.dispatch({type:'todo/insert',payload:input});
        setInput('');
    }
    return(
        <>
            <h2>해야할 일</h2>
            <hr/>
            <input type={"text"} value={input} onKeyUp={keyUp}
                onChange={(e) => setInput(e.target.value)}/>
            <button onClick={insert}>추가</button>
        </>
    );
}