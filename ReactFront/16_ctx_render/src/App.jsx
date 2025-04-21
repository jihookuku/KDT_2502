import UserComp from "./UserComp.jsx";
import PostComp from "./PostComp.jsx";
import {createContext, useState} from "react";

const UserContext = createContext({
    info:{id:'',pw:''},
    setInfo:()=>{},
});

const PostContext = createContext({
    like:0,
    setLike:()=>{},
});

export default function App(){

    const [like, setLike] = useState(0);
    const [info, setInfo] = useState({id:'',pw:''});

    return (
        <>
            <PostContext.Provider value={{like:like,setLike:setLike}}>
                <PostComp/>
            </PostContext.Provider>
            <UserContext.Provider value={{info:info, setInfo:setInfo}}>
                <UserComp/>
            </UserContext.Provider>
        </>
    );
}

export {UserContext, PostContext};