package lk.avalanche.godslayer.controller;

import lk.avalanche.godslayer.dto.ReviewByCategoryDTO;
import lk.avalanche.godslayer.dto.TutorDTO;
import lk.avalanche.godslayer.service.custom.ReviewByCategoryService;
import lk.avalanche.godslayer.service.custom.ReviewCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan Fardil
 * Date: 4/11/2019
 * Time: 12:47 AM}
 */

@RestController
@RequestMapping("api/v1/reviewbycategory")
public class ReviewByCategoryController {

    @Autowired
    ReviewByCategoryService reviewByCategoryService;

    @Autowired
    ReviewCategoryService reviewCategoryService;


    @GetMapping
    public List<ReviewByCategoryDTO> getReview(){
        return reviewByCategoryService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewByCategoryDTO getReviewById(@PathVariable("id") int id){
        return reviewByCategoryService.getrById(id);
//        return new ReviewByCategory(new ReviewCategory(c.getReviewCategoryId().getName()), c.getReview().getReviewId(), c.getValue());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity insertUserType(@RequestBody ReviewByCategoryDTO dto){
        reviewByCategoryService.insert(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public ResponseEntity updateUserType(@RequestBody ReviewByCategoryDTO dto){
        reviewByCategoryService.update(dto);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserType(@PathVariable int id){
        reviewByCategoryService.delete(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/search")
    public List<ReviewByCategoryDTO> fetchReviewByCategoryAccordingToReviewId(@RequestParam(name = "review_id",defaultValue = "")int id){
        return reviewByCategoryService.fetchReviewByCategoryAccordingToReviewId(id);
    }

}
