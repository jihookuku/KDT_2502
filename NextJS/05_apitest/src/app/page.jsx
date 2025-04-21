'use client'
import OverlayComp from "@/app/OverlayComp";
import UploadComp from "@/app/UploadComp";

export default function App(){
    return(
        <div>
            <h3>중복체크</h3>
            <OverlayComp/>
            <hr/>
            <h3>파일 업로드</h3>
            <UploadComp/>
        </div>
    );
}