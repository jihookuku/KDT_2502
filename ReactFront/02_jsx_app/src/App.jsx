import {Component} from "react";

class App extends Component{

    constructor(props) {// 클래스라 생성자가 존재 한다.
        super(props);
        console.log(props);
    }

    // 여기서도 변수 선언이 가능
    name = 'kim';
    
    render(){ // render 함수의 존재가 함수형과 클래스형의 차이를 준다.
        
        // 여기서 변수 선언이 가능
        const gender = '남자';
        let age = 30;
        
        return(
            <>
                {this.name}/{gender}/{age}
            </>
        );
    }
}

function App2(){

    // 변수(let, const, var)
    let name = '김지훈';
    const gender = '남자';
    let age = 30;

    // 본래 js 에서는 html 태그는 문자열로 저장해야 했다.
    let js = '<h3>Hello, JS</h3>';
    // jsx 에서는 html 태그를 그대로 넣을수다 있다.
    let jsx = <h3>Hello, JSX</h3>;
    // return 은 반드시 하나의 태그로 묶여 있어야 한다.
    return (
        <>{/* 만약에 의미있는 태그로 묶기 싫다면 아무런 의미 없는 태그로 묶어도 된다. */}
            {/* 변수를 표현할떄는 {} 안에 표현해 준다.*/}
            {name}/{age}/{gender}<br/>{/* 단일태그라도 / 로 마무리 해주지 않으면 에러 발생*/}
            {js}
            {jsx}
            <div>
                {/*return 문 안에서는 if 문 사용이 불가능 하다.*/}
                {/*대체 방법 1. 3항 연산자*/}
                {1+1 === 2 ? (<p>1+1 은 2 입니다.</p> ): (<p>1+1 은 2가 아닙니다.</p>)}
                {/*대체 방법 2. 익명함수 활용*/}
                {
                    (()=>{
                        if(age ===10){
                            return <div>10대 입니다.</div>;
                        }
                        if(age ===20){
                            return <div>20대 입니다.</div>;
                        }
                        if(age ===30){
                            return <div>30대 입니다.</div>;
                        }
                    })()
                }
            </div>
        </>
    );
}

import './App.css'

export default App; // 이 jsx 파일을 대표하는 기본 컴포넌트 선언










