import InputStyle from "./Input.module.css"
import {useState} from "react";
import axios from "axios";

export default function Input({id}){

    const [content, setContent] = useState();

    const send = async()=>{
        let param = {"id":id, "content":content,"done":false};
        console.log(param);
        let {data} = await axios.post('http://localhost/insert',param);
        console.log(data);
        if(!data.loginYN){
            alert('로그인이 필요한 서비스 입니다.');
            location.href='/';
        }

    }

    return(
        <div>
            <h2>해야할 일</h2>
            <input type="text" value={content} className={InputStyle.inputBox}
                   onChange={(e)=>{setContent(e.target.value)}}/>
            <button className={InputStyle.button} onClick={send}>추가</button>
        </div>
    );
}