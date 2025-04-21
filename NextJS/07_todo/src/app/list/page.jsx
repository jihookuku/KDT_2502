'use client'
export default function ListPage(props) {

    let id = ''

    if(typeof window !== 'undefined') {
        id = sessionStorage.getItem('loginId');
        console.log('loginId',id);
    }

    return (
        <>
            <h3>INPUT</h3>
            <h3>LIST</h3>
        </>
    );
}