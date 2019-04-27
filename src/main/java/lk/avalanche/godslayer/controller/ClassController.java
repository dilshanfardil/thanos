package lk.avalanche.godslayer.controller;

import lk.avalanche.godslayer.dto.ClassDTO;
import lk.avalanche.godslayer.service.custom.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/11/2019
 * Time: 12:45 AM}
 */

@RestController
@RequestMapping("api/v1/class")
public class ClassController {

    @Autowired
    ClassService classService;

    @GetMapping
    public @ResponseBody List<ClassDTO> getClasses(){
        return classService.findAll();
    }

    @GetMapping("/{id}")
    public ClassDTO getClassId(@PathVariable("id") int id){
        return classService.getrById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity insertClass(@RequestBody ClassDTO dto){
        classService.insert(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public ResponseEntity updateClass(@RequestBody ClassDTO dto){
        classService.update(dto);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteClass(@PathVariable int id){
        classService.delete(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public List<ClassDTO> fetchClassAccordingToTutorId(@RequestParam(name = "tutor_id",defaultValue = "")int id){
        return classService.fetchClassAccordingToTutorId(id);
    }

}
