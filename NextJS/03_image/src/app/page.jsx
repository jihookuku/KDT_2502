import Image from "next/image";

export default function App(){
    return (
        <div>
            <h3>img 와 Image 태그 비교</h3>
            <img src="/img.png" alt="lovlies image" width={1027} height={768} />
            <hr/>
            <Image src="/img.png" alt="lovlies image" width={1027} height={768}
                placeholder="blur" blurDataURL="/img.png" />
        </div>
    );
}