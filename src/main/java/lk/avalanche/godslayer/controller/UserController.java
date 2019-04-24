package lk.avalanche.godslayer.controller;

import lk.avalanche.godslayer.dto.TutorDTO;
import lk.avalanche.godslayer.dto.UserDTO;
import lk.avalanche.godslayer.entity.Tutor;
import lk.avalanche.godslayer.entity.User;
import lk.avalanche.godslayer.repository.UserRepository;
import lk.avalanche.godslayer.service.custom.UserService;
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
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDTO> getUser(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") int id){
        return userService.getrById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity insertUser(@RequestBody UserDTO dto){
        userService.insert(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public ResponseEntity updateUser(@RequestBody UserDTO dto){
        userService.update(dto);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable int id){
        userService.delete(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    /**
     * @param email
     * @return emails exsists return the user object otherwise return null
     *
     * */
    @GetMapping("/check")
    @ResponseBody
    public UserDTO getUserByEmail(@RequestParam String email){
        return userService.getTutorByEmail(email);
    }

}
