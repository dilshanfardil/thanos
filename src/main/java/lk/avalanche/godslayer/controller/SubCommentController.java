package lk.avalanche.godslayer.controller;

import lk.avalanche.godslayer.dto.SubCommentDTO;
import lk.avalanche.godslayer.service.custom.SubCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/23/2019
 * Time: 1:57 PM
 */

@RestController
@RequestMapping("api/v1/subcomment")
public class SubCommentController {

    @Autowired
    SubCommentService subCommentService;

    @GetMapping
    public List<SubCommentDTO> getSubComment(){
        return subCommentService.findAll();
    }

    @GetMapping("/{id}")
    public SubCommentDTO getSubCommentById(@PathVariable("id") int id){
        return subCommentService.getrById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity insertSubComment(@RequestBody SubCommentDTO dto){
        subCommentService.insert(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public ResponseEntity updateSubComment(@RequestBody SubCommentDTO dto){
        subCommentService.update(dto);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteSubComment(@PathVariable int id){
        subCommentService.delete(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
