import Item from "./Item.jsx";
import {useMemo} from "react";

export default function List(props){


    //console.log(props);

    //memo -> 특정한 변화가 있을 경우 메모리에 있는 연산을 실행
    // todos 에 직접적인 변화가 없다면 실행되지 않는다.
    let list = useMemo(()=>{
        console.log('todos 에 변화 발생');
        return(
            props.todos.map(item=>{
                return (
                    <Item
                        key={item.idx}
                        done={item.done}
                        toggle={()=>{props.toggle(item.idx)}}
                        del={()=>{props.del(item.idx)}}
                    >{item.todo}</Item>
                );
            })
        );
    },[props.todos]);

    return (
        <div>{list}</div>
    );
}