import {configureStore} from "@reduxjs/toolkit";
import memberSlice from "@/redux/memberSlice";
import boardSlice from "@/redux/boardSlice";

export const store = configureStore({
    reducer: {
        member:memberSlice,
        board:boardSlice,
    }
});