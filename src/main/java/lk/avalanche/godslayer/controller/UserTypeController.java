package lk.avalanche.godslayer.controller;


import lk.avalanche.godslayer.dto.UserTypeDTO;
import lk.avalanche.godslayer.service.custom.UserTypeService;
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
@RequestMapping("api/v1/usertype")
public class UserTypeController {

    @Autowired
    UserTypeService userTypeService;

    @GetMapping
    public List<UserTypeDTO> getUserType(){
        return userTypeService.findAll();
    }

    @GetMapping("/{id}")
    public UserTypeDTO getUserTypeById(@PathVariable("id") int id){
        return userTypeService.getrById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity insertUserType(@RequestBody UserTypeDTO dto){
        userTypeService.insert(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public ResponseEntity updateUserType(@RequestBody UserTypeDTO dto){
        userTypeService.update(dto);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserType(@PathVariable int id){
        userTypeService.delete(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
