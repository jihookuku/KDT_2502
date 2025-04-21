import {Component} from "react";
import './App.css'; // 외부 css 파일 불러오기

export default function App(){

    //js 식 스타일
    const styles={
        fontSize:26,
        fontWeight:600,
        color:'blue',
        backgroundColor:'yellowgreen',
    };

    return (
        <>
            <h1 style={{color:'red'}}>Hello Inline Style</h1>
            <p style={styles}>Java Script Object Style</p>
            <span>Use Style Sheet</span>
            <h1 className="App-title">Use ClassName</h1>
        </>
    );
}

class ClassApp extends Component {
    render() {
        return (
            <>

            </>
        );
    }

}
