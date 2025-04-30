'use client'
import Input from "@/app/list/Input";
import {useEffect, useMemo} from "react";
import {store} from "@/redux/Store";
import {useSelector} from "react-redux";
import List from "@/app/list/List";

export default function TodoPage(){

    useEffect(()=> {
        store.dispatch({type:'todo/list'});
    },[]);

    let list = useSelector(state=>{
        //console.log(state); // store 에 있는 모든 리듀서의 state 값을 가져온다.
        return state.todo.list;
    });

    return(
        <>
            <h3>해야 할 일</h3>
            <hr/>
            <Input/>
            <List list={list}/>
        </>
    );
}