import Area from "./Area.jsx";
import {useMemo} from "react";

export default function Title(){

    // 하위 컴포넌트가 렌더링 되면 상위 컴포넌트도 함께 렌더링 된다.
    // 그래서 버튼을 누를때 마다, Title 도 같이 렌더링 된다.
    // useMemo 를 활용하여 최초 한번만 렌더링 하도록 할 수 있다.
    const title = useMemo(()=>{
        console.log('title re rendering');
        return <div>버튼을 눌러서 값을 증가시켜 보세요!</div>;
    },[]);

    return(
        <>
            {title}
            <Area />
        </>
    );
}