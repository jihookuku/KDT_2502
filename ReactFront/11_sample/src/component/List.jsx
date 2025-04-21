import Item from "./Item.jsx";
import {useMemo} from "react";

export default function List(){

    const arr = ['A', 'B', 'C', 'D', 'E'];
    /*
    const list = arr.map(item => {
        return <Item key={item} name={item}/>;
    });
    */

    const list = useMemo(()=>{
        return(
            arr.map(item => {
                return <Item key={item} name={item}/>;
            })
        );
    },[arr]);

    return(
        <>{list}</>
    );
}