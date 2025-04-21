import {Component, createRef} from "react";

class RefClass extends Component {

    state = {name:'', phone:''};

    // 특정 요소를 담을 ref 객체들...
    nameInput = createRef();
    phoneInput = createRef();

    regist=()=>{
        console.log(this.nameInput.current.value);
        console.log(this.phoneInput.current.value);
        this.setState({
            name:this.nameInput.current.value,
            phone:this.phoneInput.current.value
        })
    }

    render () {
        return (
            <div>
                <h3>{this.state.name}({this.state.phone})</h3>
                <input type="text" placeholder="이름" ref={this.nameInput}/>
                <input type="text" placeholder="전화번호" ref={this.phoneInput}/>
                <button onClick={this.regist}>입력</button>
            </div>
        );
    }

}

export default RefClass;