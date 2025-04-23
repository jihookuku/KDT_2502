export default function Item({item,getList}){

    return(
        <div className="item">
            <input type="checkbox" checked={item.done}/>
            <div className="text">{item.content}</div>
            <div className="delete">[삭제]</div>
        </div>
    );
}