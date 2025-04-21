import {useSelector} from "react-redux";
import Item from "./Item.jsx";

export default function List(){

    const list = useSelector(({todo}) => {
        console.log(todo);
        return todo.list;
    });

    const todos = list.map(item => {
        return(
            <Item key={item.idx} item={item}/>
        );
    });

    return (
        <>{todos}</>
    );
}