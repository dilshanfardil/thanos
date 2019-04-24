package lk.avalanche.godslayer.controller;

import lk.avalanche.godslayer.dto.SubjectDTO;
import lk.avalanche.godslayer.entity.Subject;
import lk.avalanche.godslayer.service.custom.SubjectService;
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
@RequestMapping("api/v1/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @GetMapping
    public List<SubjectDTO> getUserType(){
        return subjectService.findAll();
    }

    @GetMapping("/search")
    public List<SubjectDTO> fetchSubjectList(@RequestParam(name = "exam_id",defaultValue = "") String examId,
                                             @RequestParam(name = "location",defaultValue = "") String location,
                                             @RequestParam(name = "name",defaultValue = "") String name){
        return subjectService.fetchSubjects(examId,location,name);
    }

    @GetMapping("/{id}")
    public SubjectDTO getUserTypeById(@PathVariable("id") int id){
        return subjectService.getrById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity insertUserType(@RequestBody SubjectDTO dto){
        subjectService.insert(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public ResponseEntity updateUserType(@RequestBody SubjectDTO dto){
        subjectService.update(dto);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserType(@PathVariable int id){
        subjectService.delete(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
