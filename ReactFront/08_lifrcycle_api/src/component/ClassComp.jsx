import {Component} from "react";

export default class ClassComp extends Component {

    state = {cnt:10};

    //Life Cycle API - 함수형 컴포넌트에서는 사용 불가
    constructor(props) {
        super(props);
        console.log('컴포넌트 생성시 호출');
    }

    componentDidMount() {
        console.log('컴포넌트가 화면에 나타났을때 호출');
        // 외부 라이브러리 연동시 활용
        // 또는 화면에 필요한 데이터를 비동기 방식으로 요청할때 활용
    }

    shouldComponentUpdate(nextProps, nextState) {
        // 값에 변화가 있을 경우 호출
        console.log("기존값 : ",this.state);
        console.log("변화한 값 : ",nextState);

        if (nextState.cnt === this.state.cnt) {// 기존 state 값과 변화한 state 값이 같으면...
            return false;//렌더링 하지마
        }
        return true; // 렌더링 여부를 결정해주는 반환 값
    }

    getSnapshotBeforeUpdate(prevProps, prevState) {
        // render() 실행과 DOM 업데이트 사이에 발생
        console.log('shouldComponentUpdate 의 반환이 true 이군요!');
        console.log('prevProps',prevProps);
        console.log('prevState',prevState);
        return {'msg':'특정한 값을 반환 할 수 있다.'};
    }

    // render() 실행 후 호출
    // getSnapshotBeforeUpdate() 실행 후 반환한 값을 snapshot 으로 받는다.
    componentDidUpdate(prevProps, prevState, snapshot) {
        console.log('prevProps',prevProps);
        console.log('prevState',prevState);
        console.log('snapshot',snapshot);
    }

    //컴포넌트가 제거될 때 호출
    componentWillUnmount() {
        console.log('컴포넌트 제거될 예정!');
    }

    upCount=()=>{
        this.setState({cnt:this.state.cnt+1});
    }

    downCount=()=>{
        //this.setState({cnt:this.state.cnt-1});
        // 복잡한 처리를 할 경우 익명함수 활용 가능
        // 1. 매개변수로 현재의 state 값을 받아낼 수 있다.
        this.setState(({cnt})=>{
            console.log(cnt);
            return {cnt:cnt-1};// 2. 이함수에서 반환되는 값이 state 에 저장된다.
        });
    }


    render() {
        return (
            <div>
                <h3>COUNT : {this.state.cnt}</h3>
                <button onClick={this.upCount}>+</button>
                <button onClick={this.downCount}>-</button>
            </div>);
    }
}