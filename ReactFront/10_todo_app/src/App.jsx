import Input from "./component/Input.jsx";
import "./App.css";
import {useEffect, useRef, useState} from "react";
import List from "./component/List.jsx";

export default function App() {

    const [list, setList] = useState([]);
    const [input, setInput] = useState("");

    useEffect(() => {
        setList([
            {idx:1,todo:'Spring Boot',done:true},
            {idx:2,todo:'React.js',done:false},
            {idx:3,todo:'Redux',done:false}
        ]);
    }, []);

    let idx = useRef(3);

    const typing=(e)=>{
        let {value} = e.target;
        setInput(value);
    }

    const insert=(e)=>{
        idx.current++;
        let todo = {idx:idx.current,todo:input,done:false};
        console.log(todo);
        setList([...list,todo]);
        setInput("");
    }

    const toggle=(no)=>{
        let index=list.findIndex(item=> item.idx === no);
        let clist = [...list];
        clist[index].done = !clist[index].done;
        setList(clist);
    }

    const del=(no)=>{
        let index=list.findIndex(item=> item.idx === no);
        let clist = [...list];
        clist.splice(index,1);
        setList(clist);
    }

    return (
        <>
            <Input val={input} onChange={typing} onInsert={insert}/>
            <List todos={list} toggle={toggle} del={del}/>
        </>
    );

}