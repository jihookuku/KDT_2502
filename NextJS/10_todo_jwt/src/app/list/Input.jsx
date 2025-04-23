import {useState} from "react";
import axios from "axios";

export default function Input(props) {
    const [todo, setTodo] = useState('');
    const insert=async ()=>{
        let{data} = await axios.post('http://localhost/insert',
            {"id":sessionStorage.getItem('loginId'), "content":todo, "done":false },
            {headers: {'authorization': sessionStorage.getItem('token')}}
       );
        console.log(data);
        if(!data.loginYN){
            alert('로그인이 필요한 서비스 입니다.');
            location.href='/';
        }
    }

    return (
        <>
            <input type="text" value={todo} onChange={(e)=>{setTodo(e.target.value)}}/>
            <button onClick={insert}>추가</button>
        </>
    );
}