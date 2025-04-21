import ItemStyle from "./Item.module.css";
export default function List({id, list}){
    //console.log(list);
    let listItem = (<div className={ItemStyle.item}>
        등록된 아이템이 없습니다.</div>);

     listItem = list.map((item)=>{
        return <Item key={item.idx}>{item}</Item>
    });

    return (
        <>{listItem}</>
    );
}

function Item({children}){
    console.log(children);
    return(
        <div className={ItemStyle.item}>
            <input className={ItemStyle.checkbox}
                   type={"checkbox"} checked={false}/>
            <div className={`${ItemStyle.text}  ${children.done ? ItemStyle.done : ''}`}>
                {children.content}
            </div>
            <div className={ItemStyle.delete}>[삭제]</div>
        </div>
    );
}