import InputStyle from "./Input.module.css"

export default function Input({id}){

    return(
        <div>
            <h2>해야할 일</h2>
            <input type="text" value={""} className={InputStyle.inputBox}/>
            <button className={InputStyle.button}>추가</button>
        </div>
    );
}