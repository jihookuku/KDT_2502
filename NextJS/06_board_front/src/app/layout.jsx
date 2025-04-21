export default function Layout({ children }) {
    return (
        <html>
        <head>
            <meta charSet="utf-8" />
            <title>Board App</title>
        </head>
        <body>
            {children}
        </body>
        </html>
    );
}