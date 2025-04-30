import Link from "next/link";
import {Pagination, Stack} from "@mui/material";
import {store} from "@/redux/store";

export default function List({board}){

    let listItem =  <tr><th colSpan={5}>작성된 게시물이 없습니다.</th></tr>;

    const del=(idx)=>{
        store.dispatch({type:'board/del',payload:idx});
    }

    if(board.list.length > 0){
        //console.log('drawing...');
        listItem = board.list.map(item=>(
            <tr key={item.idx}>
                <td>{item.idx}</td>
                <td><Link href={`/detail/${item.idx}`}>{item.subject}</Link></td>
                <td>{item.user_name}</td>
                <td>{item.reg_date}</td>
                <th><button onClick={()=>{del(item.idx)}}>삭제</button></th>
            </tr>
        ));
    }
    return (
        <>
            {listItem}
            <tr>
                <th colSpan={5}>
                    <Stack spacing={2}>
                        <Pagination count={board.pages} onChange={(e,page)=>{
                            store.dispatch({type:'board/list',payload:page});
                        }}/>
                    </Stack>
                </th>
            </tr>
        </>
    );
}