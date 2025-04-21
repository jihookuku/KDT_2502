import {useSelector} from "react-redux";
import store from "../redux/Store.jsx";

export default function List(){
    let list = <div>등록된 아이템이 없습니다.</div>;
    //Slice의 state 값 가져오기
    //useSelector 를 이용하면 모든 Slice 의 state 값을 볼 수 있다.
    let slices = useSelector((state) => {
        console.log(state);
        return state.todo.list;
    });
    list = slices.map((item) => {
        return(<Item key={item.idx} item={item} />);
    });
    console.log('list render')
    return (<>{list}</>);
}


// 어차피 List 에서만 쓸 것이므로 한 파일에 Item 도 같이 넣었다.
function Item({item}){
    let class_name = item.done ? 'text done' : 'text';

    const toggle = ()=>{
        store.dispatch({type:'todo/toggle',payload:item.idx});
    }

    const del = ()=>{
        store.dispatch({type:'todo/del',payload:item.idx});
    }

    return(
        <div className="item">
            <input type={"checkbox"}  checked={item.done}
            onChange={toggle}/>
            <div className={class_name}>{item.todo}</div>
            <div className={"delete"} onClick={del}>[삭제]</div>
        </div>);
}














