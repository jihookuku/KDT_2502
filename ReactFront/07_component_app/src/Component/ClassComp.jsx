import {Component} from "react";

export default class ClassComp extends Component {

    state = {count:0};

    updateCount=()=>{
        this.setState({count:this.state.count + 1});
    }

    alertCount=()=>{
        setTimeout(()=>{
            alert('You clicked On : '+this.state.count);
        },3000);
    }

    btnStyle={
        margin:'5px',
    }

    render() {
        return (
            <div>
                <h3>You Click {this.state.count}  times</h3>
                <button
                    style={this.btnStyle}
                    onClick={this.updateCount}>click me!!</button>

                <button
                    style={this.btnStyle}
                    onClick={this.alertCount}>show alert</button>
            </div>
        );
    }

}