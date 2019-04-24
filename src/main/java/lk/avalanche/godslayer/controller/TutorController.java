package lk.avalanche.godslayer.controller;

import lk.avalanche.godslayer.dto.TutorDTO;
import lk.avalanche.godslayer.service.custom.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/11/2019
 * Time: 12:48 AM}
 */

@RestController
@RequestMapping("api/v1/tutor")
public class TutorController {

    @Autowired
    TutorService tutorService;

    @GetMapping
    public List<TutorDTO> getTutor(){
        return tutorService.findAll();
    }

    @GetMapping("/search")
    public List<TutorDTO> searchTutor(@RequestParam(name = "exam_id",defaultValue = "") String examId,
                                      @RequestParam(name = "subject_id",defaultValue = "") String subjectId,
                                      @RequestParam(name = "location",defaultValue = "") String location,
                                      @RequestParam(name = "name",defaultValue = "") String name){
        return tutorService.search(examId,subjectId,location,name);
    }


    @GetMapping("/{id}")
    public TutorDTO getTutorById(@PathVariable("id") int id){
        return tutorService.getrById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity insertTutor(@RequestBody TutorDTO dto){
        tutorService.insert(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public ResponseEntity updateTutor(@RequestBody TutorDTO dto){
        tutorService.update(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTutor(@PathVariable int id){
        tutorService.delete(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }




}
