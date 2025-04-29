export default function Layout({children}) {
    return(
        <html>
        <head>
            <meta charSet="utf-8" />
            <link rel="stylesheet" type="text/css" href="/common.css" />
        </head>
        <body>
        {children}
        </body>
        </html>
    );
}