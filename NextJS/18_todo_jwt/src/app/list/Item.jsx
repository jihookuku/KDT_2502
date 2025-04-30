import {store} from "@/redux/Store";
import {useState} from "react";

export default function Item({item}){

    const [chk, setChk] = useState(item.done);

    const toggle = (e) => {
        setChk(!chk);
        store.dispatch({
            type:'todo/toggle',
            payload: {done:e.target.checked, idx:item.idx}
        });
    };

    const del = () => {
        store.dispatch({type:'todo/del',payload:item.idx});
    };

    return (
        <div className={"item"}>
            <input className={"checkbox"} type={"checkbox"} checked={chk} onChange={toggle}/>
            <div className={`text ${chk ? 'done':''}`}>
                {item.content}
            </div>
            <div onClick={del} className={"delete"}>[삭제]</div>
        </div>
    );
}