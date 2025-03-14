
import {Link, useNavigate} from "react-router-dom";
import { useState } from 'react'     
import axios from "axios";
     
     
     
     // 수정함수
       
     
     export default function Update(props){

        

        const navigate = useNavigate();
        
        const [bookUpform , setbookUpForm] = useState({ino : '' ,  pwd : '', title : ''  , writer : '' , intro : ''})
        const onValueChange = (e) => {
            setbookUpForm({...bookUpform, [e.target.name] : e.target.value})
        
        }

        

        const onUpdate = async (  ) => {
            {
            const response = await axios.put("http://localhost:8080/book", bookUpform)
            if(response.data == true){alert("등록성공")
            setbookUpForm({ino : '' ,  pwd : '', title : ''  , writer : '' , intro : ''})
                navigate('/');
             } else{alert('수정실패 : 없는제품번호이거나 시스템 오류')}
           }
        }
        

        return(<>
            <h3> 수정페이지</h3>
            <form>
                수정책번호 : <input type="text" name="ino"  value={bookUpform.ino} onChange={onValueChange}/><br/>
                수정할책제목 : <input type="text" name="title" value={bookUpform.title} onChange={onValueChange}/><br/>
                수정할작가 : <input type="text" name="writer" value={bookUpform.writer} onChange={onValueChange}/><br/>
                수정 추천사 : <input type="text" name="intro" value={bookUpform.intro} onChange={onValueChange}/><br/>
                수정책비밀번호 : <input type="text" name="pwd" value={bookUpform.pwd} onChange={onValueChange}/><br/>
                <button type="button" onClick={onUpdate}>수정</button>
            </form>
        </>)

    }
