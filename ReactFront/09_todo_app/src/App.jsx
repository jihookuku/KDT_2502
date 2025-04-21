import TodoInput from "./component/TodoInput.jsx";
import "./App.css";
import {useEffect, useRef, useState} from "react";
import List from "./component/List.jsx";
export default function App() {

    const [list, setList] = useState([]);
    const [input, setInput] = useState("");

    let idx = useRef(2);

    useEffect(() => {
        setList([
            {idx:1,todo:'Spring 공부하기', done:true},
            {idx:2,todo:'react 공부하기', done:false}
        ]);
    },[]);

    const insertTodo=()=>{
        idx.current++;
        let todo = {idx:idx.current,todo:input,done:false};
        console.log('to-do : ',todo);
        setList([...list,todo]);
        setInput('');
    }

    const typing=(e)=>{
        setInput(e.target.value);
    }

    const toggle=(id)=>{
        console.log(id,'번 checked 변화 발생');
        // 1. list 에서 id 번의 item 을 가져오기
        //findIndex 존건이 참이면 해당 index 를 반환
        let index = list.findIndex(item=>{
            return item.idx === id;
        });
        console.log(index,list[index]);
        // 2. 해당 아이템의 done 값을 변경하기
        // 2-1. list 의 안전을 위해 복사본을 만든다.
        let copy_list = [...list];
        // 2-2. 특정 인덱스의 done 값을 반전하여 저장
        copy_list[index].done = !copy_list[index].done;
        //2-3. 최종 데이터를 덮어쓴다.
        setList(copy_list);
    }

    const del=(id)=>{
        console.log(id+'번 삭제');

        let index = list.findIndex(item=>{
            return item.idx === id;
        });

        let copy_list = [...list];
        copy_list.splice(index,1);
        setList(copy_list);
    }

    return (
        <div className="app">
            <TodoInput
                onInsert={insertTodo}
                value={input}
                onTyping={typing}/>
            <List list={list} toggle={toggle} del={del}/>
        </div>
    );
}