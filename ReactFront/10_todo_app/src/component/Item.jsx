import {useMemo} from "react";

export default function Item(props){

    //console.log(props);
    //let class_name = props.done ? "text done" : "text";
    let class_name = useMemo(()=>{
        console.log('done 변화 발생');
        return (props.done ? "text done" : "text");
    },[props.done]);

    //console.log(class_name);

    return(
        <div className="item">
            <input type="checkbox" checked={props.done}
                onChange={props.toggle}/>
            <div className={class_name}>{props.children}</div>
            <div className="delete" onClick={props.del}>[삭제]</div>
        </div>
    );

}