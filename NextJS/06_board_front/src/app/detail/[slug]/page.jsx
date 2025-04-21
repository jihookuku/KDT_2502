//'use client' // async Component 이용은 서버에서 가능
// props 를 통해 파라메터를 얻어 올 수 있었다.
// params           : 경로에 있는 파라메터
// searchParams : ? 뒤에오는 파라메터
import Post from "@/app/detail/[slug]/Post";

export default async function Detail(props){
        const idx = (await props.params).slug;
        console.log(idx);
    return (
        <div>
            <h3>상세보기</h3>
            <hr/>
            <Post idx={idx}/>
        </div>
    );
}