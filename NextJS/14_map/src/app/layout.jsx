export default function Layout({ children }) {
    return (
       <html lang="ko">
       <head>
           <meta charSet="utf-8" />
           <script src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=ba582e11274f85938e4607271e92ac7f&autoload=false"></script>
       </head>
       <body>
       {children}
       </body>
       </html>
    );
}