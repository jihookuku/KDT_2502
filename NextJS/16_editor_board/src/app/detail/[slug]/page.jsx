'use client'
import {useEffect} from "react";
import axios from "axios";

export default function DetailPage(props){

    useEffect(() => {
        // detail/30 에서 30을 가져왔던 방법?
        // params 는 Promise 객체 이므로 일반적인 방법으로는 빼 올 수 없다.
        //console.log(props.params.slug); // props.params.slug
        // Promise 객체를 대하는 방법 
        // 1. then() 사용 -> 대신 처리 후 값을 반환 할 수 없다.
        // 2. await async 사용 -> 일부 함수에서 사용할 수 없다.
        // -> async 함수를 따로 만들어서 호출하는 방법을 사용
       props.params.then(({slug})=>{
           console.log(slug);
           getDetail(slug);
       });
    }, []);

    const getDetail = async(idx)=>{
        const id = sessionStorage.getItem('id');
        const token = sessionStorage.getItem('token');
        let {data} = await axios.get(`http://localhost/detail/${id}/${idx}`,{headers:{Authorization: token}});
        console.log(data);
    }


    return(
        <>
            <h3>상세보기</h3>
        </>
    );
}