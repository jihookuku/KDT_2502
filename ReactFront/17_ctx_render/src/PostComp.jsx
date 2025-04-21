import {useContext, useMemo} from "react";
import {PostCtx} from "./App.jsx";

export default function PostComp(){

    const {like, setLike} = useContext(PostCtx);

    const html = useMemo(()=>{
        console.log('Post Comp Rendering...');
        return(
            <div>
                <h3>Post 에 대한 좋아요 수 : {like}</h3>
                <button onClick={()=>{setLike(like+1)}}>좋아요</button>
            </div>
        );
    },[like]);


    return(<>{html}</>);
}