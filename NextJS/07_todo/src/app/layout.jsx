export default function Layout({ children }) {
    return (
        <html>
        <head>
            <meta charSet="utf-8" />
            <title>To-Do List</title>
        </head>
        <body>{children}</body>
        </html>
    );
}