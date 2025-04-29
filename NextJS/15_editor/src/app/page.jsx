'use client'
import {useEffect, useRef} from "react";

export default function HomePage(){

    let div = useRef(null);//div 요소를 담을 ref
    let editor = null; // 에디터 객체를 담을 변수

    useEffect(() => {
        editor = new window.RichTextEditor(div.current);
        // editor 에 특정한 내용을 넣고 싶을때
        editor.setHTMLCode('<h3>Hello World</h3>');
    },[]);

    const getText=()=>{
        // editor 에 작성된 내용을 가져오고 싶을때
        // 이미지도 base64 형태로 저장하므로 텍스트 형태로 저장 할 수 있다.
        // 다만 글 내용의 용량이 굉장히 커질 수 있다.
        let content = editor.getHTMLCode();
        console.log(content);
    }

    return(
        <>
            <h3>Rich Text Editor Sample</h3>
            {/*아래 DIV 에 에디터 적용*/}
            <div ref={div}></div>
            <button onClick={getText}>작성한 내용 가져오기</button>
        </>
    );
}