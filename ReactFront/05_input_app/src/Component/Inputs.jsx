import {useState} from "react";

export default function Inputs() {

    const [inputs, setInputs] = useState({name:'',id:''});
    /* 일반적인 객체의 속성 할당 방법
    const id = inputs.id;
    const name = inputs.name;
    */
    /* 비구조 할당
    const {id} = inputs;     
    const {name} = inputs;
    */
    const {id,name} = inputs;

    const reset = () =>{
        setInputs({name:'',id:''});
    }

    const typing=(key,val)=>{
        console.log(key+'='+val);
        // inputs 에 id 속성을 건드릴때 name 속성은 제어가 되지 않아 초기화 된다.
        // 그래서 기존값이 초기화 되지 않도록 유지해 줘야 한다.
        // spread 연산자(...) 특정 객체를 복사해 놓는 연산자
         setInputs({
             ...inputs,
             [key]:val});
    }

    return(
        <div style={{marginTop: '10px'}}>

            아이디 : <input type="text" value={id}
                         onChange={(e)=>{typing('id',e.target.value)}}/><br/>

            닉네임 : <input type="text" value={name}
                         onChange={(e)=>{typing('name',e.target.value)}}/><br/>

            <button onClick={reset}>초기화</button>
            <p>아이디 : {id} / 닉네임 : {name}</p>
        </div>
    );
}

/*
export default function Inputs() {

    const[id,setId]=useState('');
    const [name,setName]=useState('');

    const reset = () =>{
        setId('');
        setName('');
    }

    return(
        <div style={{marginTop: '10px'}}>

            아이디 : <input type="text" value={id}
                onChange={(e)=>{setId(e.target.value)}}/><br/>

            닉네임 : <input type="text" value={name}
                onChange={(e)=>{setName(e.target.value)}}/><br/>

            <button onClick={reset}>초기화</button>
            <p>아이디 : {id} / 닉네임 : {name}</p>
        </div>
    );
}
 */