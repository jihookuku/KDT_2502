export default function Layout({ children }) {
    return (
        <html>
        <head>
            <meta charSet="utf-8" />
            <title>Image Tag 테스트</title>
        </head>
        <body>
            {children}
        </body>
        </html>
    );
}