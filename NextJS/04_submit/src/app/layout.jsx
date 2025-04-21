export default function Layout({ children }) {
    return (
        <html>
        <head>
            <meta charSet="utf-8" />
            <title>Next.js</title>
        </head>
        <body>
            {children}
        </body>
        </html>
    );
}