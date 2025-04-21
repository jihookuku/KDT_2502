export default function Layout({ children }) {
    return (
        <html>
        <head>
            <meta charSet="utf-8" />
            <title>Api Test App</title>
        </head>
        <body>
        {children}
        </body>
        </html>
    );
}