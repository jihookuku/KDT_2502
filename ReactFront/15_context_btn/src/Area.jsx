import {useContext} from "react";
import {DataContext} from "./App.jsx";

export default function Area(){

    const {cnt,setCnt} = useContext(DataContext);

    console.log('Area Re rendering');

    return(
        <>
            <h3>COUNT : {cnt}</h3>
            <button onClick={()=>{setCnt(cnt+1)}}>click</button>
        </>
    );
}