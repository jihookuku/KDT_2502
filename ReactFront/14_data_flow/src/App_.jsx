export default function App(){
    return(
        // item 이라는 이름의 prop 을 전달 하는 과정
        <div>
            <Island item="Island 에 전달할 데이터"/>
            <First item="Third 에 전달할 데이터"/>
        </div>
    );
}

function First({item}){
    return(
        <>
            <h3>거쳐간 곳 1</h3>
            <Second item={item}/>
        </>
    );
}

function Second({item}){
    return(
        <>
            <h3>거쳐간 곳 2</h3>
            <Third item={item}/>
        </>
    );
}

function Third({item}){
    return(
        <>
            <h3>최종 도착지 : {item}</h3>
        </>
    );    
}

function Island({ item }) {
    return(
        <h3>전달 받은 데이터 : {item}</h3>
    );
}
