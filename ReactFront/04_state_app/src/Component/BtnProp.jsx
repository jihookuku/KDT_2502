//Props 는 부모로 부터 내려주는 데이터로 변경이 불가능 하다.
export default function BtnProp(props){

    console.log(props);

    const sendMsg = (name) => {
        alert("your name is"+name);
    }

    return(
        <div style={{margin:10}}>
            {/*
                함수에 () 가 들어가면 즉시 실행이 된다.
                원치 않는다면 익명함수 안에 넣어야 한다.
            */}
            <button onClick={()=>{sendMsg(props.name)}}>{props.name}</button>
        </div>
    );
}