// page.jsx 의 구성을 이루는 Component
export default function Post({list}) {
    //console.log(list);
    let posts = list.map(item => {
        return (<li key={item.id}>{item.title}</li>);
    });
    return (
   <ul>
        {posts.length>0 ? posts : <li>불러온 POST 가 없습니다.</li>}
    </ul>);
}