import {createSlice} from "@reduxjs/toolkit";
import axios from "axios";
import Link from "next/link";
import {store} from "@/redux/store";

const boardSlice = createSlice({
    name:'board',
    initialState:{
        id: typeof window == 'undefined' ? '' : sessionStorage.getItem('id'),
        token: typeof window == 'undefined' ? '' : sessionStorage.getItem('token'),
        list:[],
        pages:0,
        detail:{},
    },
    reducers: {
        set_state(state, action){
            Object.keys(action.payload).forEach(key => {
                state[key] = action.payload[key];
            });
            return state;
        },
        write(state, action) {
            //redux 에서는 form-data 등 직렬화를 할 수 없는 데이터는 사용 하지 말도록 권고한다.
            // 그래서 slice 에서는 form-data 는 안쓰거나 외부에서 쓰는것을 추천
            axios.post('http://localhost/write',action.payload,{headers:{Authorization:state.token}})
                .then(({data})=>{
                    console.log(data);
                    if(data.success){
                        alert('글쓰기가 성공 하였습니다.');
                        location.href = '/detail/'+data.idx;
                    }
                });
        },
        list(state, action) {
            console.log('list 호출 : '+action.payload+'page');
            axios.get(`http://localhost/list/${state.id}/${action.payload}`
                ,{headers: {'Authorization': state.token}}).then(({data})=>{
                console.log(data);
                store.dispatch({type:'board/set_state',payload:{pages:data.pages, list:data.list}});
            });
        },
        del(state, action) {
            axios.delete(`http://localhost/del/${state.id}/${action.payload}`,{headers:{Authorization:state.token}
            }).then(({data})=>{
                console.log(data);
                if(data.success){
                    console.log('삭제 성공 리스트 재 호출');
                    store.dispatch({type:'board/list',payload:1});
                }
            });
        },
        detail(state, action) {
            axios.get(`http://localhost/detail/${state.id}/${action.payload}`,{headers:{Authorization: state.token}})
                .then(({data})=>{
                    store.dispatch({type:'board/set_state',payload:{detail:data.detail}});
                });
            return state;
        },
    }
});

export default boardSlice.reducer;