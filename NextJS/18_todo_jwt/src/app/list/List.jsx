import {useMemo} from "react";
import Item from "@/app/list/Item";

export default function List({list}){

    // list 를 item 을 통해서 그리는 것
    let listItems = <div>등록된 To-Do 리스트가 없습니다.</div>

    if(list.length > 0){
        console.log('drawing');
        listItems = list.map(item => <Item key={item.idx} item={item}/>);
    }

    return (
        <>{listItems}</>
    );
}