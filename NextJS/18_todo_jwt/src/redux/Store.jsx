import {configureStore} from "@reduxjs/toolkit";
import MemberSlice from "@/redux/MemberSlice";
import TodoSlice from "@/redux/TodoSlice";

export const store = configureStore({
    reducer:{
        member:MemberSlice,
        todo:TodoSlice
    }
});