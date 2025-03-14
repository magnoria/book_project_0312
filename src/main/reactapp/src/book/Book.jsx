import { useState, useEffect } from "react"
import axios from "axios";
import {useNavigate} from "react-router-dom";
import { Link } from 'react-router-dom';

export default function Book(props){

    useEffect(() => {onFindAll()}, [] )


   const navigate = useNavigate();


    const[books , setBooks] = useState([]);

    const onFindAll = async () => {
        try {
            const response = await axios.get('http://localhost:8080/book');
            setBooks(response.data);
        } catch (error) {
            console.log(error);
        }
    }

    //데이터 저장함수
    const[bookData , setBookData] = useState({  pwd : '', title : ''  , writer : '' , intro : ''})

    //입력받은 데이터 렌더링
    const formDataChange = (e) => {
        console.log(e);
        console.log(e.target.name)
        console.log(e.target.value)
        
        setBookData({...bookData, [e.target.name] : e.target.value});

    }

    
    //스프링 서버에 보내기
    const onPost = async (e) => {
        try {
            const response = await axios.post('http://localhost:8080/book', bookData)// 3번째가 옵션 json 타입이 기본값으로 되서 입력안해도됨
        if(response.data == true){alert("등록성공")
        setBookData({ pwd : '', title : '' , writer : '' , intro : ''})
            onFindAll();
        }else{alert('등록실패')}
        } catch (error) { console.log(error);
            
        }
    }
    // 수정부분 끝







    // 삭제 함수

    const[deleteIno , setDeletIno] = useState({ino : '' , pwd : ''});
    const onValueChange = (e) => {
        setDeletIno(e.target.value);
    }

    const onDelete = async (ino , pwd) => {
        deleteIno.ino = prompt(`현재 번호 : ${ino}` , deleteIno.ino);
        deleteIno.pwd = prompt('비밀번호' , deleteIno.pwd)
        if(pwd == deleteIno.pwd){
        const response = await axios.delete(`http://localhost:8080/book?ino=${ino}&pwd=${pwd}`)
        if(response.data == true){
            alert('삭제성공'); onFindAll();
        }else{alert('삭제실패')}}
    }








    return(<>
    
    <div>
        <form>
            <h1>추천할책</h1>
            <h3>제목</h3>
            <input type="text" value={bookData.title} name="title" onChange={formDataChange}/>
            <h3>작가</h3>
            <input type="text" value={bookData.writer} name="writer" onChange={formDataChange}/>
            <h3>추천사</h3>
            <input type="text" value={bookData.intro} name="intro" onChange={formDataChange}/>
            <h3>비밀번호</h3>
            <input type="text" value={bookData.pwd} name="pwd" onChange={formDataChange}/><br/>
            <button type="button" onClick={onPost}>저장</button>
            
        </form>
        
        <table border={1}>
            <thead><tr><td>번호</td><td>제목</td><td>작가</td><td>추천사</td><td>수정</td><td>삭제</td><td>리뷰</td></tr></thead>
            
        
            <tbody>
                {
                
                books.map((book , index) => {
                    return(<tr key={index}>
                        <td>{book.ino}</td>
                        <td>{book.title}</td>
                        <td>{book.writer}</td>
                        <td>{book.intro}</td>
                        <td><button type="button" onClick={ () => {navigate('/update')}}>수정</button></td>
                        <td><button type="button" onClick={ () => {onDelete(book.ino,book.pwd)}}>삭제</button></td>
                        <td><Link to="/review" replace>리뷰이동</Link></td>
                    </tr>)
                })
            
                }
            </tbody>
        </table>
    </div>
    </>)
}