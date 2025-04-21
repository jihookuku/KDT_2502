export default function BlogList({list}) {

    //console.log(list);

    const posts = list.map((item) => {
        console.log(item);
        return(
            <li key={item.id}>
                <h3>[{item.id}]  {item.title}</h3>
                <div>{item.content}</div>
            </li>
        );
    });

    return (
        <ul>{posts}</ul>
    );
}