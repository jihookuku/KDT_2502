import {createSlice} from "@reduxjs/toolkit";

const TodoSlice = createSlice({
    name:'todo',
    initialState: {
        idx:4,
        list:[
            {idx:1,text:'Spring Boot',done:true},
            {idx:2,text:'React.js',done:false},
            {idx:3,text:'React-Redux',done:false},
        ]
    },
    reducers: {
        insert(state, action){
            let todo = {idx:state.idx,text:action.payload, done:false};
            state.list.push(todo);
            state.idx++;
            return state;
        },
        toggle(state, action){
            const no = action.payload;
            const index = state.list.findIndex(item => item.idx === no);
            state.list[index].done = !state.list[index].done;
            return state;
        },
        del(state, action){
            const no = action.payload;
            const index = state.list.findIndex(item => item.idx === no);
            state.list.splice(index, 1);
            return state;
        }

    }
});

export default TodoSlice.reducer;









