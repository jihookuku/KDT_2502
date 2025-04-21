import {useContext} from "react";
import {PostContext} from "./App.jsx";

export default function PostComp() {

    const {like, setLike} = useContext(PostContext);

    console.log('PostComp rendering...');

    return (
        <>
            <h3>Post 에 대한 좋아요 수 : {like}</h3>
            <button onClick={()=>{setLike(like+1)}}>좋아요!</button>
        </>
    );
}