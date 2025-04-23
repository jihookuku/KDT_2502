import {useRef, useState} from "react";
import axios from "axios";

export default function Item({item,getList}){

    const [chk, setChk] = useState(item.done);
    console.log(item.id);
    const token = useRef(sessionStorage.getItem("token"));

    const toggle=()=>{
        setChk(!chk);
        console.log(token.current);
        axios.put('http://localhost/update',{"id":item.id,"done":!chk,"idx":item.idx},
            {headers:{authorization: token.current}}).then(({data})=> console.log(data));
    }

    // 400 해결
    // token 만료시 해결
    const del=()=>{
        console.log(token.current);
        // post, put, patch -> url,{body}, {config}
        // get, delete 는 바디가 없다. -> url,{cofig}
        // 그래서 delete 같은 경우는 -> url, {dara:{},config:{}}
        axios.delete('http://localhost/del',{data:{"id":item.id,"idx":item.idx}
            ,headers:{authorization: token.current}}).then(({data})=>{
                console.log(data);
                getList();
        });

    }

    return(
        <div className="item">
            <input type="checkbox" checked={chk} onChange={toggle}/>
            <div className={`text ${chk ? 'done':''}`}>{item.content}</div>
            <div className="delete" onClick={del}>[삭제]</div>
        </div>
    );
}