export default function Input({val, onChange, onInsert}) {

    const onKeyUp=(e)=>{
        if(e.keyCode === 13){
            onInsert();
        }
    }

    return (
        <div>
            <h2>일정관리</h2>
            <hr/>
            <input type="text"
                   onChange={onChange}
                   onKeyUp={onKeyUp}
                   value={val}/>
            <button onClick={onInsert}>추가</button>
        </div>
    );
    
}