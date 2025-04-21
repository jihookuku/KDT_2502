import "./Input.css"
import {useState} from "react";
import store from "../redux/Store.jsx";

export default function Input(){

    const [input, setInput] = useState("");

    const insert = () => {
        store.dispatch({type:'todo/insert',payload:input});
        setInput('');
    }
    
    return(
        <div>
            <h2>해야 할 일</h2>
            <hr/>
            <input type={"text"} value={input}
                   onChange={(e) => setInput(e.target.value)}/>
            <button onClick={insert}>등록</button>
        </div>
    );

}