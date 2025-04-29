export default function Layout({ children }) {
    return (
        <html>
        <head>
            <meta charSet="utf-8" />
            <link rel="stylesheet" href="/richtexteditor/rte_theme_default.css" />
            <script type="text/javascript" src="/richtexteditor/rte.js"></script>
            <script type="text/javascript" src='/richtexteditor/plugins/all_plugins.js'></script>
        </head>
        <body>
        {children}
        </body>
        </html>
    );
}