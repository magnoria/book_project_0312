package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dto.ReviewDto;
import web.model.mapper.ReviewMapper;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    public boolean conFine(ReviewDto reviewDto){
        System.out.println("reviewService.onFine");
        System.out.println("reviewDto = " + reviewDto);

        return reviewMapper.conFine(reviewDto);
    }

    public List<ReviewDto> findAll(){
        System.out.println("reviewService.findAll");
        System.out.println();

        return reviewMapper.findAll();
    }

    public boolean remove(int rno , int pwd){
        System.out.println("reviewService.remove");
        System.out.println("rno = " + rno);

        return reviewMapper.remove(rno, pwd);
    }

}
