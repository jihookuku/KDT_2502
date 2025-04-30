'use client'
import {Provider} from "react-redux";
import {store} from "@/redux/Store";

export default function Layout({ children }) {
    return (
        <html>
        <head>
            <meta charSet="utf-8" />
        </head>
        <body>
        <Provider store={store}>
            {children}
        </Provider>

        </body>
        </html>
    );
}