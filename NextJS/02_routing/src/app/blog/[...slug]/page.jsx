// page : app/blog/[...slug]/page.jsx      url: /blog/11         param: slug:11
// page : app/blog/[...slug]/page.jsx      url: /blog/food/11        param: slug:[food,11]
// page : app/blog/[cate]/[item]/page.jsx      url: /blog/food/11        param: {cate:food, item:11}
export default async function blogPath(props){

    const param = await props.params;
    console.log(param.slug);

    // [...slug] 를 하면  이후 모든 경로를 배열로 받는다.
    const list = param.slug.map((item, idx) => {
        console.log(item);
        return <li key={idx}>{item}</li>
    });

    return (
        <>
            <p>경로로 받아온 params</p>
            <ul>{list}</ul>
        </>
    );
}