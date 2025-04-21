export default function Item({children, done, done_yn, toggle,idx, del}) {

    let class_name = `text ${done_yn}`;
    //console.log(idx);
    return(
        <div className="item">
            <input className="chk" type="checkbox"
                checked={done}
                onChange={()=>{toggle(idx)}}
            />
            <div className={class_name}>{children}</div>
            <div className="delete"
                 onClick={()=>{del(idx)}}>[삭제]</div>
        </div>);
}