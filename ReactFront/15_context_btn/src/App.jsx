import Title from "./Title.jsx";
import {createContext, useState} from "react";

// 컨텍스트를 생성해서
const DataContext = createContext({
    cnt: 0,
    setCnt: ()=>{}
});

export default function App(){
    const [cnt,setCnt] = useState(0);
    return(
        // cnt 와 setCnt 를 담고
        <DataContext.Provider value={{cnt, setCnt}}>
            <Title />
        </DataContext.Provider>
    );
}

// 누구나 사용 할 수 있도록 공개
export {DataContext};