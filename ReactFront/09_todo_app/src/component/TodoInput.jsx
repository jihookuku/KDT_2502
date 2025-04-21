export default function TodoInput({onInsert, value, onTyping}){

    // [{idx:1, todo:'할일',done:false},{},...]
    //console.log('props', props);
    //console.log(onInsert);
    //console.log(value);

    const keyUpHandler=(e)=>{
        //console.log(e);
        if(e.keyCode===13){
            onInsert();
        }
    }

    return(
        <div className="input">
            <h2>할일 관리</h2>
            <hr/>
            <input type="text" onChange={onTyping} value={value}
                onKeyUp={keyUpHandler}/>
            <button onClick={onInsert}>추가</button>
        </div>
    );
}