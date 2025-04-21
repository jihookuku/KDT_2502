import ItemStyle from "./Item.module.css";
import {useState} from "react";
import axios from "axios";
export default function List({list, getList}){
    //console.log(list);
    let listItem = (<div className={ItemStyle.item}>
        등록된 아이템이 없습니다.</div>);

     listItem = list.map((item)=>{
        return <Item key={item.idx} getList={getList}>
               {item}
        </Item>
    });

    return (
        <>{listItem}</>
    );
}

function Item({children, getList}){
    console.log(children);
    const [chk,setChk] = useState(children.done);

    const toggle=()=>{
        setChk(!chk);
        let param = {
            "idx":children.idx,
            "id":children.id,
            done: !chk
        };
        console.log('param',param);
        axios.put('http://localhost/update',param).then(({data})=>{
            console.lo(data);
            //getList(param.id);
            // 어차피 체크는 UI 상에 적요오디어 있으므로
            // 굳이 리스트를 불러오지 않아도 된다.
        });
    }

    return(
        <div className={ItemStyle.item}>
            <input className={ItemStyle.checkbox}
                   type={"checkbox"} checked={chk} onChange={toggle}/>
            <div className={`${ItemStyle.text}  ${chk ? ItemStyle.done : ''}`}>
                {children.content}
            </div>
            <div className={ItemStyle.delete}>[삭제]</div>
        </div>
    );
}