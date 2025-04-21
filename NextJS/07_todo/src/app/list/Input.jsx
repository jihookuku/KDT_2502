import InputStyle from "./Input.module.css"
import {useState} from "react";
import axios from "axios";

export default function Input({id, getList}){

    const [content, setContent] = useState('');

    const send = async()=>{
        let param = {"id":id, "content":content,"done":false};
        console.log(param);
        let {data} = await axios.post('http://localhost/insert',param);
        console.log(data);
        if(!data.loginYN){
            alert('로그인이 필요한 서비스 입니다.');
            location.href='/';
        }
        if(data.success){
            alert('추가 하였습니다.');
            setContent('');
            getList(id);
        }else{
            alert('추가에 실패 하였습니다.');
        }
    }

    const keyHandler = (e)=>{
        if(e.keyCode == 13){
            send();
        }
    }

    return(
        <div>
            <h2>해야할 일</h2>
            <input type="text" value={content} className={InputStyle.inputBox}
                   onChange={(e)=>{setContent(e.target.value)}} onKeyUp={keyHandler}/>
            <button className={InputStyle.button} onClick={send}>추가</button>
        </div>
    );
}