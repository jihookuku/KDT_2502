import {configureStore} from "@reduxjs/toolkit";
import TodoSlice from "./TodoSlice.jsx";

const Store = configureStore({
    reducer:{
        todo:TodoSlice
    }
});

export default Store;