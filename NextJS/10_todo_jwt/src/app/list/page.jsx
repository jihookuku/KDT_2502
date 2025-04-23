'use client'
import Input from "@/app/list/Input";
import "./todo.css";

export default function TodoPage(){
    return(
        <>
            <h3>해야 할 일</h3>
            <Input />
            <div>LIST</div>
        </>
    );
}