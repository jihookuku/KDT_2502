import {configureStore} from "@reduxjs/toolkit";
import counterSlice from "@/redux/counterSlice";

export const store = configureStore({
    reducer: {
        counter:counterSlice
    }
});