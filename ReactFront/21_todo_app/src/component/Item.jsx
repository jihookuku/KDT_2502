// cssName.moule.css 형태는 class 의 이름을 변수처럼 활용 할 수 있다.
import ItemStyles from './Item.module.css';
import store from "../redux/Store.jsx";

export default function Item({item}){

    console.log(item);

    const toggle = () => {
        store.dispatch({type:'todo/toggle',payload:item.idx});
    }

    const del = () => {
        store.dispatch({type:'todo/del',payload:item.idx});
    }


    return (
        <div className={ItemStyles.item}>
            <input type={"checkbox"}
                   checked={item.done} onChange={toggle}/>
            <div className={`${ItemStyles.text} ${item.done ? ItemStyles.done : ''}`}>
                {item.text}
            </div>
            <div className={ItemStyles.delete}
                onClick={del}>[삭제]</div>
        </div>
    );
}