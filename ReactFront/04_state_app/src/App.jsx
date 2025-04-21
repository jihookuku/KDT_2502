import BtnProp from "./Component/BtnProp.jsx";
import BtnState from "./Component/BtnState.jsx";
import HookState from "./Component/HookState.jsx";

const App =() => (
    <div>
        <BtnProp name="This is Prop Button"/>
        <BtnState name="This is State Button"/>
        <HookState name="This is Hook State"/>
    </div>
);

export default App;