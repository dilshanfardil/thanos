package lk.avalanche.godslayer.controller;

import lk.avalanche.godslayer.dto.CommentDTO;
import lk.avalanche.godslayer.service.custom.CommentService;
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
 * Time: 1:47 PM}
 */

@RestController
@RequestMapping("api/v1/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<CommentDTO> getComment(){
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public CommentDTO getCommentById(@PathVariable("id") int id){
        return commentService.getrById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity insertComment(@RequestBody CommentDTO dto){
        commentService.insert(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public ResponseEntity updateComment(@RequestBody CommentDTO dto){
        commentService.update(dto);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTopic(@PathVariable int id){
        commentService.delete(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
