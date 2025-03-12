package web.model.mapper;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import web.model.dto.ReviewDto;

import java.util.List;

@Mapper
public interface ReviewMapper {

    //ino 수정필요
    @Insert("insert into bookReview( latter , pwd) values ( #{latter} , #{pwd})")
    public boolean conFine(ReviewDto reviewDto);

    @Select("select * from bookReview")
    public List<ReviewDto> findAll();

    @Delete("delete from bookReview where rno = #{rno}")
    public boolean remove(int rno , int pwd);


}
