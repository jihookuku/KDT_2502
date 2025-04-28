"use client"
import {BarChart} from "@mui/x-charts";

export default function BarPage(){
    return(
        <>
            <div style={{width:'30%',float:'left'}}>
                <BarChart
                    series={[{data:[4,2,3,5], label:'성장률'}]}/*막대 하나하나의 내용*/
                    xAxis={[{data:['1분기','2분기','3분기','4분기'], scaleType:'band'}]}/*X 축의 내용*/
                    width={500}
                    height={300}
                    barLabel={"value"}/*Bar 에 표시될 내용*/
                    borderRadius={10}
                    grid={{horizontal:true}}
                />
            </div>
            
            <div style={{width:'30%',float:'left'}}>
                <BarChart
                    series={[
                        {data:[4,2,3,5], label:'매출'},
                        {data:[1,6,3,2], label:'순익'},
                        {data:[2,2,5,6], label:'방문객'}

                    ]}/*막대 하나하나의 내용*/
                    xAxis={[{data:['groupA','groupB','groupC','groupD'], scaleType:'band'}]}/*X 축의 내용*/
                    width={500}
                    height={300}
                    barLabel={"value"}/*Bar 에 표시될 내용*/
                    borderRadius={10}
                    grid={{horizontal:true}}
                />
            </div>

            <div style={{width:'30%',float:'left'}}>
                <BarChart
                    /*stack 의 이름이 동일한 녀석들 끼리 쌓이게 된다.*/
                    series={[
                        {data:[4000,2000,3000,5000], label:'매출', stack:'stack1'},
                        {data:[1000,6000,3000,2000], label:'순익', stack:'stack1'},

                    ]}/*막대 하나하나의 내용*/
                    xAxis={[{data:['1분기','2분기','3분기','4분기'], scaleType:'band'}]}/*X 축의 내용*/
                    width={500}
                    height={300}
                    barLabel={"value"}/*Bar 에 표시될 내용*/
                    borderRadius={10}
                    grid={{horizontal:true}}
                />
            </div>
        </>
    );
}