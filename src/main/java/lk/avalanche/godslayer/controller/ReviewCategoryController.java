package lk.avalanche.godslayer.controller;

import lk.avalanche.godslayer.dto.ReviewCategoryDTO;
import lk.avalanche.godslayer.entity.ReviewCategory;
import lk.avalanche.godslayer.service.custom.ReviewCategoryService;
import lk.avalanche.godslayer.service.custom.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/11/2019
 * Time: 12:47 AM}
 */

@RestController
@RequestMapping("api/v1/reviewcategory")
public class ReviewCategoryController {

    @Autowired
    ReviewCategoryService reviewCategoryService;


    @GetMapping
    public List<ReviewCategoryDTO> getUserType(){
        return reviewCategoryService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewCategoryDTO getUserTypeById(@PathVariable("id") int id){
        return reviewCategoryService.getrById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity insertUserType(@RequestBody ReviewCategoryDTO dto){
        reviewCategoryService.insert(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public ResponseEntity updateUserType(@RequestBody ReviewCategoryDTO dto){
        reviewCategoryService.update(dto);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserType(@PathVariable int id){
        reviewCategoryService.delete(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
