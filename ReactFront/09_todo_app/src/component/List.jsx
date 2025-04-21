import Item from "./Item.jsx";

export default function List({list, toggle, del}) {
    //console.log(list);

    const items = list.map(item=>{
        //console.log(item);
        return <Item
            key={item.idx}
            idx={item.idx}
            done={item.done}
            done_yn={item.done === true? "done":""}
            toggle={toggle}
            del={del}
        >{item.todo}</Item>;
    });

    return(
        <div>{items}</div>
    );
}