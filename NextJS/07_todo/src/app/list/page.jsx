'use client'
import Input from "@/app/list/Input";

export default function ListPage(props) {

    let id = '';

    if(typeof window !== 'undefined') {
        id = sessionStorage.getItem('loginId');
        console.log('loginId',id);
    }

    return (
        <>
            <Input id={id}/>
            <h3>LIST</h3>
        </>
    );
}