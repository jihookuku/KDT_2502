import {store} from "@/redux/Store";

export default function Item({item}){

    const toggle = () => {};

    const del = () => {
        store.dispatch({type:'todo/del',payload:item.idx});
    };

    return (
        <div className={"item"}>
            <input className={"checkbox"} type={"checkbox"} checked={item.done} onChange={toggle}/>
            <div className={`text ${item.done ? 'done':''}`}>
                {item.content}
            </div>
            <div onClick={del} className={"delete"}>[삭제]</div>
        </div>
    );
}