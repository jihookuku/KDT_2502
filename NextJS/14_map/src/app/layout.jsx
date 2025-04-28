export default function Layout({ children }) {
    return (
       <html lang="ko">
       <head>
           <meta charSet="utf-8" />
       </head>
       <body>
       {children}
       </body>
       </html>
    );
}