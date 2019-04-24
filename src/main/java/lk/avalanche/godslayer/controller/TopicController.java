package lk.avalanche.godslayer.controller;

import lk.avalanche.godslayer.dto.TopicDTO;
import lk.avalanche.godslayer.service.custom.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/22/2019
 * Time: 12:21 PM}
 */

@RestController
@RequestMapping("api/v1/topic")
public class TopicController {

    @Autowired
    TopicService topicService;


    @GetMapping
    public List<TopicDTO> getTopic(){
        return topicService.findAll();
    }

    @GetMapping("/{id}")
    public TopicDTO getTopicById(@PathVariable("id") int id){
        return topicService.getrById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity insertTopic(@RequestBody TopicDTO dto){
        topicService.insert(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public ResponseEntity updateTopic(@RequestBody TopicDTO dto){
        topicService.update(dto);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTopic(@PathVariable int id){
        topicService.delete(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
