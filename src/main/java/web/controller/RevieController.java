package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.ReviewDto;
import web.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/review")
public class RevieController {

    @Autowired
    private ReviewService reviewService;




    //등록
    @PostMapping("")
    public boolean conFine(@RequestBody ReviewDto reviewDto){
        System.out.println("RevieController.onFine");
        System.out.println("reviewDto = " + reviewDto);

        return reviewService.conFine(reviewDto);
    }


    //조회
    @GetMapping("")
    public List<ReviewDto> findAll(){
        System.out.println("RevieController.findAll");
        System.out.println();

        return reviewService.findAll();
    }

    //삭제
    @DeleteMapping("")
    public boolean remove(@RequestParam int ino , int pwd){
        System.out.println("RevieController.remove");
        System.out.println("ino = " + ino + ", pwd = " + pwd);

        return reviewService.remove(ino, pwd);
    }

}
