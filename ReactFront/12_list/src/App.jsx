import NumberList from "./NumberList.jsx";
import BlogList from "./BlogList.jsx";

const App = () => {

    const number = [1,2,3,4,5];
    const post = [
        {id:1,title:'Hello, World!', content: 'Welcome to Learning React!'},
        {id:2,title:'Installation', content: 'You Can install React from npm or yarn'},
    ];

    return (
        <>
            <NumberList list ={number} />
            <BlogList list={post} />
        </>
    );
}

export default App;