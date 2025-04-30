import {createSlice} from "@reduxjs/toolkit";
import axios from "axios";
import {store} from "@/redux/Store";

const TodoSlice = createSlice({
    name:'todo',
    initialState:{
        id: typeof window == 'undefined' ? '' : sessionStorage.getItem('id'),
        token: typeof window == 'undefined' ? '' : sessionStorage.getItem('token'),
        list:[]
    },
    reducers:{
        set_state(state, action){
            console.log(action.payload);
            state.list = action.payload;
            return state;
        },
        list(state, action){
            axios.post('http://localhost/list',{id:state.id},{headers:{Authorization:state.token}})
                .then(({data})=>{
                    console.log(data);
                    if(data.loginYN){
                        console.log('insert : ',data.list);
                        store.dispatch({type:'todo/set_state',payload:data.list});
                    }else{
                        store.dispatch({type:'todo/loginChk'});
                    }
                });
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
                        store.dispatch({type:'todo/list'});
                    }
                });
        },
        toggle(state, action){

        },
        del(state, action){
            axios.delete('http://localhost/del',{
                data:{id:state.id,idx:action.payload}
                ,headers:{Authorization:state.token}
            }).then(({data})=>{
                console.log(data);
                if(data.loginYN){
                    if(data.success){
                        store.dispatch({type:'todo/list'});
                    }
                }else{
                    store.dispatch({type:'todo/loginChk'});
                }
            });
        },
        loginChk(state, action){
            alert('로그인이 필요한 서비스 입니다.');
            location.href='/';
        }
    }
});

export default TodoSlice.reducer;