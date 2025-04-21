import {useContext} from "react";
import {UserContext} from "./App.jsx";

export default function UserComp() {

    const {info, setInfo} = useContext(UserContext);

    const inputStr=(field,e)=>{
        console.log(field,e.target.value);
        setInfo({...info,[field]:e.target.value});
    }

    console.log('UserComp rendering...');

    return (
        <>
            <p>
                ID : <input type={"text"} value={info.id}
                            onChange={(e) => {inputStr('id',e)}}/>
            </p>
            <p>
                PW : <input type={"password"} value={info.pw}
                            onChange={(e) => {inputStr('pw',e)}}/>
            </p>
            <p>입력한 ID : {info.id} / 입력한 PW : {info.pw}</p>
        </>
    );
}