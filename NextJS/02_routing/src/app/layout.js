import style from './main.module.css';

export default function RootLayout({ children }) { // children 은 page.js 를 의미
  return (
    <html lang="ko">
      <head>
        <title>Next.js Main page</title>
      </head>
       <body>
         <div className={style.layout}>{children}</div>
       </body>
    </html>
  );
}
