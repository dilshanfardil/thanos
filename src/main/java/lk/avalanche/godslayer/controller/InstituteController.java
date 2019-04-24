package lk.avalanche.godslayer.controller;

import lk.avalanche.godslayer.dto.InstitueDTO;
import lk.avalanche.godslayer.service.custom.InstitueService;
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
@RequestMapping("api/v1/institute")
public class InstituteController {

    @Autowired
    InstitueService institueService;

    @GetMapping
    public List<InstitueDTO> getInstitute(){
        return institueService.findAll();
    }

    @GetMapping("/search")
    public List<InstitueDTO> searchTutor(@RequestParam(name = "exam_id",defaultValue = "") String examId,
                                         @RequestParam(name = "subject_id",defaultValue = "") String subjectId,
                                         @RequestParam(name = "name",defaultValue = "") String name){
        return institueService.fetchInstitutes(examId,subjectId,name);
    }


    @GetMapping("/{id}")
    public InstitueDTO getInstituteById(@PathVariable("id") int id){
        return institueService.getrById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity insertInstitute(@RequestBody InstitueDTO dto){
        institueService.insert(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public ResponseEntity updateInstitute(@RequestBody InstitueDTO dto){
        institueService.update(dto);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteInstitute(@PathVariable int id){
        institueService.delete(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
