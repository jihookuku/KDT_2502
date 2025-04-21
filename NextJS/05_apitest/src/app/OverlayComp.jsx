import {useState} from "react";
import axios from "axios";

export default function OverlayComp() {

    const[id, setId] = useState("");

    // origin 'http://localhost:3000' has been blocked by
    // CORS policy: No 'Access-Control-Allow-Origin' header...
    const overlay = async() => {
        console.log('overlay check!!')
        const url = 'http://localhost/overlay';
        //let data = await axios.get(`${url}/${id}`);// GET 방식
        let {data} = await axios.post(url,{id:id}); // POST 방식1
        //await axios({method:'post', url:url, id:id}); // POST 방식2
        console.log(data);
        
        if(data.use){
            alert(id+' 는 사용 가능 합니다.');
        }else{
            alert(id+' 는 이미 사용중 입니다.');
        }

    }

    return(
        <div>
            <input type={"text"} value={id} onChange={(e) => setId(e.target.value)} />
            <button onClick={overlay}>중복체크</button>
        </div>
    );
}