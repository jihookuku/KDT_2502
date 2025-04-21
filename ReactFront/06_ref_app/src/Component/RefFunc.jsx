import {useRef, useState} from "react";

export default function RefFunc(){

    const [text, setText] = useState('');

    const inputRef = useRef();

    const inputTxt=(e)=>{
        setText(e.target.value);
    }

    const txtFocus=()=>{
        //console.log([inputRef.current]);
        inputRef.current.focus();
        setText('');
    }

    return(
        <div>
            <h3>입력값 : {text}</h3>
            <input type="text"
                   onChange={inputTxt} ref={inputRef} value={text}/>
            <button onClick={txtFocus}>focus</button>
        </div>);
}