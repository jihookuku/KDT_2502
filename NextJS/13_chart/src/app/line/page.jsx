'use client'
import {LineChart} from "@mui/x-charts";

export default function LinePage(){
    return (
        <>
            <h3>Line Chart Sample</h3>
            <div style={{width:'30%',float:'left'}}>
                <LineChart
                   /*curve : smooth, curve, catmullRom, linear, monotoneX, monotoneY, natural, step, stepBefore, stepAfter*/
                    series={[
                        {data:[2,5,2,8,1,5],curve:"step"}
                    ]}
                    xAxis={[{scaleType:'band',data:['1월','2월','3월','4월','5월','6월']}]}
                    width={500}
                    height={300}
                />
            </div>

            <div style={{width:'30%',float:'left'}}>
                <LineChart
                    series={[
                        {data:[2,2.5,5.5,2,8.5,1.5,5], area:true, color:'dodgerblue'},
                    ]}
                    xAxis={[{data:[1,2,3,5,8,10,12]}]}
                    width={500}
                    height={300}
                />
            </div>

            <div style={{width:'30%',float:'left'}}>
                <LineChart
                    xAxis={[{scaleType:'band',data:['1분기','2분기','3분기','4분기']}]}
                    series={[
                        {data:[3,4,2,6],area:true, stack:'total', label:'A', highlightScope:{highlight:'item'}},
                        {data:[4,3,1,5],area:true, stack:'total', label:'B', highlightScope:{highlight:'item'}},
                        {data:[5,2,5,4],area:true, stack:'total', label:'C', highlightScope:{highlight:'item'}},
                    ]}
                    onAreaClick={(e,data)=>console.log(e,data)}
                    onLineClick={(e,data)=>console.log(e,data)}
                    onMarkClick={(e,data)=>console.log(e,data)}
                    width={500}
                    height={300}
                />
            </div>
        </>
    );
}