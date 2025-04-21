export default function NumberList({list}) {

    //const numbers = list.map(item=> <li key={item}>{item}</li>);
    //map 이 싫으면 for 활용 가능
    const numbers = [];
    for (const item of list) {
        numbers.push(<li key={item}>{item}</li>);
    }

    return(
        <ul>{numbers}</ul>
    );
}