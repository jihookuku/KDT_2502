//React.useState
import {useState} from "react";

export default function Input(){

    const [text, setText] = useState('');

    const getText=(e)=>{
        console.log(e.target.value);
        setText(e.target.value);
    }

    return (
        <div>
            <h3>입력내용 : {text}</h3>
            <input type="text" value={text} onChange={(e)=>{getText(e)}}
                   placeholder="아무거나 입력 하세요"/>
            <button onClick={()=>{setText('')}}>초기화</button>
        </div>
    );
}