package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dto.BookDto;
import web.model.mapper.BookMapper;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;


    public boolean conFine(BookDto bookDto){
        System.out.println("BookService.conFine");
        System.out.println("bookDto = " + bookDto);

        return bookMapper.conFine(bookDto);
    }

    public List<BookDto> findAll(){
        System.out.println("BookService.findAll");
        System.out.println();

        return bookMapper.findAll();
    }

    public BookDto alter(int ino){
        System.out.println("BookService.alter");
        System.out.println("ino = " + ino);

        return bookMapper.alter(ino);
    }

    public boolean update(BookDto bookDto){
        System.out.println("BookService.Update");
        System.out.println("bookDto = " + bookDto);

        return bookMapper.update(bookDto);
    }

    public boolean remove(int ino, int pwd){
        System.out.println("BookService.remove");
        System.out.println("ino = " + ino + ", pwd = " + pwd);

        return bookMapper.remove(ino, pwd);
    }


}
