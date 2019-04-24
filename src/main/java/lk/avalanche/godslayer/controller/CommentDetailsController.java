package lk.avalanche.godslayer.controller;

import lk.avalanche.godslayer.dto.CommentDTO;
import lk.avalanche.godslayer.dto.CommentDetailsDTO;
import lk.avalanche.godslayer.service.custom.CommentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/23/2019
 * Time: 2:01 PM}
 */

@RestController
@RequestMapping("api/v1/commentdetails")
public class CommentDetailsController {

    @Autowired
    CommentDetailsService commentDetailsService;

    @GetMapping
    public List<CommentDetailsDTO> getComment(){
        return commentDetailsService.findAll();
    }

    @GetMapping("/{id}")
    public CommentDetailsDTO getCommentDetailsById(@PathVariable("id") int id){
        return commentDetailsService.getrById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity insertCommentDetails(@RequestBody CommentDetailsDTO dto){
        commentDetailsService.insert(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public ResponseEntity updateCommentDetails(@RequestBody CommentDetailsDTO dto){
        commentDetailsService.update(dto);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCommentDetails(@PathVariable int id){
        commentDetailsService.delete(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
