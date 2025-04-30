import {configureStore} from "@reduxjs/toolkit";
import MemberSlice from "@/redux/MemberSlice";

export const store = configureStore({
    reducer:{
        member:MemberSlice,
    }
});