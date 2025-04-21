import {Component} from "react";
/*
* state 는 props 와 다르게 수정이 가능한 값이다.
* state 는 setState() 함수를 통해 업데이트 해야 한다.
* */
class BtnState extends Component {
    constructor(props) {
        super(props);
        console.log(props);
        // state 는 본래 class 에서만 사용 가능함
        this.state = {count:0};
    }

    // this.state 를 인식 하기 위해서는 화살표 함수를 활용 해 줘야 한다.
    upCount=()=>{
        this.setState({count:this.state.count + 1}); // state 가 업데이트 되야만 UI 가 다시 렌더링 하게 된다.
    }

    render() {
        return (
            <div style={{margin:10}}>
                <h3>{this.state.count.toString()}</h3>
                <button onClick={this.upCount}>click</button>
            </div>
        );
    }
}

export default BtnState;