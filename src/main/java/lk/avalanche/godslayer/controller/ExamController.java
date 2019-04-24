package lk.avalanche.godslayer.controller;

import lk.avalanche.godslayer.dto.ExamDTO;
import lk.avalanche.godslayer.service.custom.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/11/2019
 * Time: 12:46 AM}
 */

@RestController
@RequestMapping("api/v1/exam")
public class ExamController {

    @Autowired
    ExamService examService;

    @GetMapping
    public List<ExamDTO> getExam(){
        return examService.findAll();
    }

    @GetMapping("/{id}")
    public ExamDTO getExamById(@PathVariable("id") int id){
        return examService.getrById(id);
    }

    @GetMapping("search")
    public List<ExamDTO> fetchExamList(@RequestParam(name = "subject_id",defaultValue = "") String subjectId,
                                       @RequestParam(name = "location",defaultValue = "") String location,
                                       @RequestParam(name = "name",defaultValue = "") String name){
        return examService.fetchExams(subjectId,location,name);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity insertExam(@RequestBody ExamDTO dto){
        examService.insert(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public ResponseEntity updateExam(@RequestBody ExamDTO dto){
        examService.update(dto);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteExam(@PathVariable int id){
        examService.delete(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
