'use client'
import {PieChart} from "@mui/x-charts";

export default function PiePage(){
    return (
        <>
            <h3>Pie Chart Sample</h3>
            <div style={{width:'30%', float:'left'}}>
                <PieChart
                    colors={['red','dodgerblue','yellowgreen']}
                    series={[{
                        data: [
                            {value:10,label:'data A'},
                            {value:15,label:'data B'},
                            {value:75,label:'data C'},
                        ]
                    }]}
                    width={400}
                    height={400}
                />
            </div>

            <div style={{width:'30%', float:'left'}}>
                <PieChart
                    series={[{
                        data: [
                            {value:10,label:'data A'},
                            {value:15,label:'data B'},
                            {value:75,label:'data C'},
                        ],
                        arcLabel:(item)=>{
                            console.log(item);
                            return`${item.value}%`
                        },
                        innerRadius:50, // 파이 안쪽의 구멍 크기
                        outerRadius:200, // 외각 라인 크기(outer - inner = 보여지는 파이 크기)
                        paddingAngle:3, // 파이 사이의 간격
                        cornerRadius:10, // 파이의 모서리 둥글기
                        startAngle:30,
                        endAngle: 390,
                    }]}
                    width={400}
                    height={400}
                />
            </div>

            <div style={{width:'30%', float:'left'}}>
                <PieChart
                    colors={['red','dodgerblue','yellowgreen']}
                    series={[{
                        data: [
                            {value:10,label:'data A'},
                            {value:15,label:'data B'},
                            {value:75,label:'data C'},
                        ],
                        highlightScope:{highlight:'item', fade:'global'}, // 마우스 오버시 효과
                        faded:{color:'gray', innerRadius:70, additionalRadius:-30},//fade 에 대한 상세 효과를 조정 할 수 있다.
                    }]}
                    width={400}
                    height={400}
                />
            </div>
        </>
    )
}