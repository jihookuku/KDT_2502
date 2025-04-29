export default function Layout({ children }) {
    return (
        <html>
        <head>
            <meta charSet="utf-8" />
        </head>
        <body>
        {children}
        </body>
        </html>
    );
}