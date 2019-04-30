package lk.avalanche.godslayer.controller;

import lk.avalanche.godslayer.dto.ReviewDTO;
import lk.avalanche.godslayer.service.custom.ReviewCategoryService;
import lk.avalanche.godslayer.service.custom.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/26/2019
 * Time: 8:23 PM}
 */


@RestController
@RequestMapping("api/v1/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    ReviewCategoryService reviewCategoryService;

    @GetMapping
    public List<ReviewDTO> getReview(){
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewDTO getReviewById(@PathVariable("id") int id){
        return reviewService.getrById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity inserReview(@RequestBody ReviewDTO dto){
        reviewService.insert(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public ResponseEntity updateReview(@RequestBody ReviewDTO dto){
        reviewService.update(dto);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteReview(@PathVariable int id){
        reviewService.delete(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public List<ReviewDTO> fetchReviewAccordingToTutorId(@RequestParam(name = "tutor_id",defaultValue = "")int id){
        return reviewService.fetchReviewAccordingToTutorId(id);
    }

    @GetMapping("/count")
    public Integer fetchReviewCountAccordingToTutorId(@RequestParam(name = "tutor_id",defaultValue = "")int id){
        return reviewService.fetchReviewCountAccordingToTutorId(id);
    }


}
