'use client'
import {ScatterChart} from "@mui/x-charts";

export default function ScatterPage(){

    const data = [
        {x1: 329.39, y1: 443.28, x2: 391.29, y2: 153.9},
        {x1: 96.94, y1: 110.5, x2: 139.6, y2: 217.8},
        {x1: 336.35,x2: 282.34, y1: 175.23,y2: 286.32},
        {x1: 159.44,x2: 384.85,y1: 195.97,y2: 325.12},
        {x1: 188.86,x2: 182.27,y1: 351.77,y2: 144.58},
        {x1: 143.86, x2: 360.22,y1: 43.253,y2: 146.51},
        {x1: 202.02,x2: 209.5,y1: 376.34, y2: 309.69},
        {x1: 384.41,x2: 258.93,y1: 31.514,y2: 236.38},
        {x1: 256.76,x2: 70.571,y1: 231.31,y2: 440.72},
        {x1: 143.79,x2: 419.02,y1: 108.04,y2: 20.29},
        {x1: 103.48,x2: 15.886,y1: 321.77,y2: 484.17},
        {x1: 272.39,x2: 189.03,y1: 120.18,y2: 54.962},
        {x1: 23.57,x2: 456.4,y1: 366.2,y2: 418.5},
        {x1: 219.73,x2: 235.96,y1: 451.45,y2: 181.32},
        {x1: 54.99,x2: 434.5,y1: 294.8,y2: 440.9},
        {x1: 134.13,x2: 383.8,y1: 121.83,y2: 273.52},
        {x1: 12.7,x2: 270.8,y1: 287.7,y2: 346.7},
        {x1: 176.51, x2: 119.17,y1: 134.06,y2: 74.528},
        {x1: 65.05,x2: 78.93,y1: 104.5,y2: 150.9},
        {x1: 162.25,x2: 63.707,y1: 413.07,y2: 26.483},
        {x1: 68.88,x2: 150.8,y1: 74.68,y2: 333.2},
        {x1: 95.29,x2: 329.1,y1: 360.6,y2: 422.0},
        {x1: 390.62,x2: 10.01,y1: 330.72,y2: 488.06},
    ];

    return (
        <>
            <h3>Scatter Sample</h3>
            <div style={{width:'50%'}}>
                <ScatterChart series={[
                    {label:'Group A', data:data.map(item=>({x:item.x1,y:item.y1}))},//{x:x1, y:y1}
                    {label:'Group B', data:data.map(item=>({x:item.x2,y:item.y2}))},//{x:x2, y:y2}
                ]}
                 width={600}
                 height={300}
                grid={{vertical:true, horizontal:true}}
                />
            </div>

            <div style={{width:'50%'}}>
                <ScatterChart
                    series={[
                        {
                            label:'Group A',
                            data:data.map(item=>({x:item.x1,y:item.y1})),
                            highlightScope:{highlight:'item', fade:'global'},
                        },//{x:x1, y:y1}
                        {
                            label:'Group B',
                            data:data.map(item=>({x:item.x2,y:item.y2})),
                            highlightScope:{highlight:'item', fade:'global'},
                        },//{x:x2, y:y2}
                    ]}
                    width={600}
                    height={300}
                    grid={{vertical:true, horizontal:true}}
                />
            </div >

            <div style={{width:'50%'}}>
                <ScatterChart
                    series={[
                        {label:'Group A', data:data.map(item=>({x:item.x1,y:item.y1}))},//{x:x1, y:y1}
                    ]}
                    width={600}
                    height={300}
                    xAxis={[
                        {
                            // colorMap:{
                            //     type:'piecewise', // piecewise, continuous
                            //     thresholds:[100,200,300],
                            //     colors:['yellow','orange','red']
                            // }
                            colorMap:{
                                type:'continuous', // piecewise, continuous
                                min:100,
                                max:400,
                                color:['yellow','green']
                            }
                        }
                    ]}
                    grid={{vertical:true, horizontal:true}}
                />
            </div>
        </>
    );
}