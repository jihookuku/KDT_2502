import { useState} from "react";

export default function Item({name}){

    const [cnt, setCnt] = useState(0);


    return(
        <div className="item" onClick={()=>{setCnt(cnt+1)}}>
            <div>{name} 아이템 구매 수</div>
            <div className="cnt">{cnt}</div>
        </div>
    );
}