package web.model.mapper;


import org.apache.ibatis.annotations.*;
import web.model.dto.BookDto;

import java.util.List;

@Mapper
public interface BookMapper {

    @Insert("insert into bookinsert(title, writer, intro ,pwd) values (#{title} , #{writer} , #{intro}, #{pwd})")
    public boolean conFine(BookDto bookDto);

    @Select("select * from bookinsert")
    public List<BookDto> findAll();

    @Select("selete from bookinsert where ino ")
    public  BookDto alter(int ino);

    @Update("update bookinsert set title = #{title} , writer = #{writer}, intro = #{intro}, pwd = #{pwd} where ino = #{ino} and pwd = #{pwd}")
    boolean update(BookDto bookDto);

    @Delete("delete from bookinsert where ino = #{ino} and pwd = #{pwd}")
    boolean remove(BookDto bookDto);


}
