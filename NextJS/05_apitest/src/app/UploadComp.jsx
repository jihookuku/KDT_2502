import axios from "axios";
import {useState} from "react";

export default function UploadComp(){

    const [file, setFile] = useState(null);
    const[path,setPath]=useState("");

    const upload = async() => {
        const url = 'http://localhost/upload';
        const formData = new FormData();// 1. 비동기로 파일 전송시 FormData 를 이용해야 한다.
        formData.append('file', file);// 2. 파일 정보를 넣는다.
        const config = {// 3. header 에 multipart/form-data 사용한다는 것을 명시
            headers: {"content-type": "multipart/form-data"},
        };
        let {data} = await axios.post(url, formData, config);
        console.log(data);
        // path : "/files/99470809-ec57-4753-956c-736b280cbcae.png"
        setPath(data.path);
    }

    const fileSelect = (e) => {
        //console.log(e);
        setFile(e.target.files[0]);
    }

    return (
        <div>
            <input type={"file"} name={"file"} onChange={fileSelect}/>
            <button onClick={upload}>전송</button>
            <hr/>
            {path != '' ? <img src={`http://localhost${path}`} width={400}/> : ''}
        </div>
    );
}