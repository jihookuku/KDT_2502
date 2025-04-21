// 컴포넌트는 클래스 타입과 함수타입 두가지가 있다.
// 기본적으로 클래스타입에 더 많은 기능들이 내장되어 있으며
// 함수형에서는 이것을 이용하기 위한 hook 들이 제공 된다.
// 이 외에도 render 함수 유무에 따른 차이가 있다.
import ClassComp from "./Component/ClassComp.jsx";
import FuncComp from "./Component/FuncComp.jsx";

export default function App() {
    return (
        <>
            <ClassComp/>
            <FuncComp/>
        </>
    );
}
/*
*  alert() 은 render 함수를 막는다.
* 그렇기 때문에 함수형의 경우는 영향을 받게 된다.
* 왜 영향을 받나? 함수형은 함수 자체가 하나의 render 함수가 된다.
* 그래서 alert 이 실행 되면 함수 자체의 변수들은 값을 저장하지 못한다.
* 클래스의 경우 render 가 별도로 분리되어있기에 해당 함수 밖에서는
* 데이터를 주고 받을 수 있다.
* 함수형의 경우 render 에 영향받지 않는 ref 를 활용하면
* 클래스와 같은 효과를 낼 수 있다.
* */



