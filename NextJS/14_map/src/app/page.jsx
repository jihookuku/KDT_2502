'use client'
/*global kakao*/
import {useEffect} from "react";
export default function HomePage(){

    useEffect(() => {
        /*
        // 1.script 태그 생성
        const script = document.createElement('script');
        // 2. head 태그에 끼워넣기
        script.src='https://dapi.kakao.com/v2/maps/sdk.js?appkey=ba582e11274f85938e4607271e92ac7f&autoload=false';
        document.head.appendChild(script);
        */
        //3.  script 가 다 읽혀지면, 라이브러리 읽기
        let mapContainer = document.getElementById('map')

        //script.onload = ()=>{
            kakao.maps.load(()=>{
                const mapOption = {
                    center: new kakao.maps.LatLng(37.57190029146425, 126.98715765847491), // 지도의 중심좌표
                    level: 3 // 지도의 확대 레벨
                };

                // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
                let map = new kakao.maps.Map(mapContainer, mapOption);

                // 최초 마커 등록
                let marker = new kakao.maps.Marker({
                    position: map.getCenter(),
                });

                marker.setMap(map);

                // 이벤트 등록
                kakao.maps.event.addListener(map, 'click', function (event) {
                    console.log('evt',event);
                    let latLan = event.latLng;
                    marker.setPosition(latLan); // 특정 위도 경도록 마커 이동
                    let msg = '클릭한 위치의 위도는 '+latLan.getLat()+',  경도는 '+latLan.getLng()+'  입니다.';
                    document.getElementById('msg').innerHTML = msg;
                });

            });
        //}

    }, []);



    return (
        <>
            <div id="map" style={{width:"100%",height:"500px"}}></div>
            <p id="msg"></p>
        </>
    );
}