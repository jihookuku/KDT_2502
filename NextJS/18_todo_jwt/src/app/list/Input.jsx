'use client'
import {useState} from "react";
import '../commons.css';
import {store} from "@/redux/Store";

export default function Input(){

    const [todo,setTodo] = useState('');

    const keyHandler = (e) => {
        if(e.key === 'Enter'){insert();}
    }

    const insert = ()=>{
        console.log('입력 내용 추가 : '+todo);
        // id,content,done
        // token
        store.dispatch({type:'todo/insert',payload:todo});
    }

    return (
        <>
            <input type="text" value={todo} className={"inputBox"}
                   onChange={(e)=>{setTodo(e.target.value)}}
                   onKeyUp={keyHandler}/>
            <button className={"inputButton"} onClick={insert}>추가</button>
        </>
    );
}