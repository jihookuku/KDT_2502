"use client"
import Link from 'next/link';

export default function HomePage(){
    return (
        <>
            <h3>Chart Library 모음</h3>
            <Link href={"/bar"}>Bar Chart</Link>
            <br/>
            <Link href={"/line"}>Line Chart</Link>
            <br/>
            <Link href={"/pie"}>Pie Chart</Link>
            <br/>
            <Link href={"/scatter"}>Scatter Chart</Link>
            <br/>
        </>
    )
}