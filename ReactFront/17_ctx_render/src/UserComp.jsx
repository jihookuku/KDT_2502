import {useContext, useMemo} from "react";
import {UserCtx} from "./App.jsx";

export default function UserComp(){

    const {info,setInfo} = useContext(UserCtx);

    const inputStr=(field,val)=>{
        setInfo({...info,[field]:val});
    }

    const html = useMemo(()=>{
        console.log('Post Comp Rendering...');
        return(
            <>
                <p>ID : <input type={"text"} value={info.id}
                               onChange={(e)=>{inputStr('id',e.target.value)}}
                /></p>
                <p>PW : <input type={"password"} value={info.pw}
                               onChange={(e)=>{inputStr('pw',e.target.value)}}
                /></p>
                <p>ID: {info.id}/ PW : {info.pw}</p>
            </>
        );
    },[info]);


    return(<>{html}</>);
}