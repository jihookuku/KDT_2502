import PostComp from "./PostComp.jsx";
import UserComp from "./UserComp.jsx";
import {createContext, useContext, useState} from "react";

const PostCtx = createContext({
    like:0, setLike:()=>{},
});

const UserCtx = createContext({
    info:{id:'',pw:''}, setInfo:()=>{},
});

export default function App() {

    const [like, setLike]  = useState(0);
    const [info,setInfo] = useState({id:'',pw:''});

    return(
        <>
            <PostCtx.Provider value={{like, setLike}}>
                <PostComp/>
            </PostCtx.Provider>
            <UserCtx.Provider value={{info,setInfo}}>
                <UserComp/>
            </UserCtx.Provider>

        </>
    );
}

export {PostCtx, UserCtx};