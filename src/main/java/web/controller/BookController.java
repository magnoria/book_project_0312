package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import web.model.dto.BookDto;
import org.springframework.web.bind.annotation.*;
import web.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin("http://localhost:5173")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("") // { "title":"연금술사 ", "writer" :"미정 ", "intro": "초심자의 행운~~" , "pwd":"12342" }
    public boolean conFine(@RequestBody BookDto bookDto){
        System.out.println("BookController.conFine");
        System.out.println("bookDto = " + bookDto);

        return bookService.conFine(bookDto);
    }


    @GetMapping("")
    public List<BookDto> findAll(){
        System.out.println("BookController.findAll");
        System.out.println();

       return bookService.findAll();
    }

    @GetMapping("/info")
    public BookDto alter(@RequestParam("ino") int ino){
        System.out.println("BookController.alter");
        System.out.println("ino = " + ino);

        return bookService.alter(ino);
    }



    @PutMapping("")
    public boolean Update(@RequestBody BookDto bookDto){
        System.out.println("BookController.Update");
        System.out.println("bookDto = " + bookDto);

        return bookService.update(bookDto);
    }

    @DeleteMapping("")// 시간 있으면 dto 로 변경할것
    public boolean remove(@RequestParam int ino , int pwd){
        System.out.println("BookController.remove");
        System.out.println("ino = " + ino + ", pwd = " + pwd);

        return bookService.remove(ino,pwd);

    }




}//c end
