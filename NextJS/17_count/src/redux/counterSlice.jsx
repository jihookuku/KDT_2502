import {createSlice} from "@reduxjs/toolkit";

const counterSlice = createSlice({
    name: "counter", // 호출할 이름
    initialState: { // reducer 에서 다룰 state
        count: 0,
    },
    reducers: { // state 를 다룰 reducer 들
        increment: (state, action) => { // 여기서 다룰 state, 전달받을 매개변수 action.payload
            console.log('state',state);
            console.log('action',action);
            state.count += 1;
            return state;
        },
        decrement: (state, action) => {
            state.count -= 1;
            return state;
        },
    }
});

export default counterSlice.reducer;

