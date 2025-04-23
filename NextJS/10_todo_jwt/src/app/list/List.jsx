import Item from "@/app/list/Item";

export default function List({list, getList}) {
    console.log(list);
    let itemList = list.length == 0 ?
        <div className={"item"}>등록된 TO DO List 가 없습니다.</div>
        : list.map(item => {
            console.log(item);
           return( <Item key={item.idx} item={item} getList={getList}/>);
        });

    return(
        <>
            {itemList}
        </>
    );
}