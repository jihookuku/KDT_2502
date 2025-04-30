import {createSlice} from "@reduxjs/toolkit";
import axios from "axios";
import {store} from "@/redux/Store";

const TodoSlice = createSlice({
    name:'todo',
    initialState:{
        id:sessionStorage.getItem('id'),
        token:sessionStorage.getItem('token'),
    },
    reducers:{
        list(state, action){


        },
        insert(state, action){
            console.log('id:'+state.id);
            console.log('content :',action.payload);
            console.log('token:',state.token);
            axios.post('http://localhost/insert'
                ,{id:state.id,content:action.payload,done:false}
                ,{headers:{Authorization:state.token}})
                .then(({data})=>{
                    console.log(data);
                    if(!data.loginYN){
                        store.dispatch({type:'todo/loginChk'}); // 같은 slice 안의 리뷰서라도 이런형식으로 호출 한다.
                    }else{

                    }

                });

        },
        toggle(state, action){

        },
        del(state, action){

        },
        loginChk(state, action){
            alert('로그인이 필요한 서비스 입니다.');
            location.href='/';
        }
    }
});

export default TodoSlice.reducer;