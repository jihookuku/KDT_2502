import {createContext, useContext} from "react";

const DataContext = createContext('');

export default function App(){
    return(
        // context 로 prop 을 전달하는 과정
        <DataContext.Provider value="Context 에 저장된 데이터">
            <Island/>
            <First/>
        </DataContext.Provider>
    );
}

function Island() {
    const data = useContext(DataContext);
    return(
        <h3>Context 로 부터 받은 데이터 : {data}</h3>
    );
}

function First(){
    return(
        <>
            <h3>거쳐간 곳 1</h3>
            <Second/>
        </>
    );
}

function Second(){
    return(
        <>
            <h3>거쳐간 곳 2</h3>
            <Third/>
        </>
    );
}

function Third(){

    const data = useContext(DataContext);

    return(
        <h3>Context 로 부터 직접 받은 데이터 : {data}</h3>
    );    
}


