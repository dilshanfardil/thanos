package lk.avalanche.godslayer.controller;

import lk.avalanche.godslayer.dto.ReviewByCategoryDTO;
import lk.avalanche.godslayer.dto.ReviewDTO;
import lk.avalanche.godslayer.entity.ReviewByCategory;
import lk.avalanche.godslayer.entity.ReviewCategory;
import lk.avalanche.godslayer.service.custom.ReviewCategoryService;
import lk.avalanche.godslayer.service.custom.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan Fardil
 * Date: 4/11/2019
 * Time: 12:47 AM}
 */

@RestController
@RequestMapping("api/v1/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    ReviewCategoryService reviewCategoryService;



    @GetMapping
    public List<ReviewByCategoryDTO> getReview(){
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewByCategoryDTO getReviewById(@PathVariable("id") int id){
        return reviewService.getrById(id);
//        return new ReviewByCategory(new ReviewCategory(c.getReviewCategoryId().getName()), c.getReview().getReviewId(), c.getValue());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity insertUserType(@RequestBody ReviewByCategoryDTO dto){
        reviewService.insert(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public ResponseEntity updateUserType(@RequestBody ReviewByCategoryDTO dto){
        reviewService.update(dto);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserType(@PathVariable int id){
        reviewService.delete(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
