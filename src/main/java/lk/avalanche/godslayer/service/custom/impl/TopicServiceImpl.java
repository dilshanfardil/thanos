package lk.avalanche.godslayer.service.custom.impl;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lk.avalanche.godslayer.dto.TopicDTO;
import lk.avalanche.godslayer.entity.Topic;
import lk.avalanche.godslayer.repository.TopicRepository;
import lk.avalanche.godslayer.service.custom.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/22/2019
 * Time: 4:01 PM}
 */

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicRepository topicRepository;

    @Override
    public List<TopicDTO> findAll() {
        return topicRepository.findAll().stream().map(c -> {
            return new TopicDTO(c.getTopicId(), c.getTopicName());
        }).collect(Collectors.toList());
    }

    @Override
    public TopicDTO getrById(int id) {
        Topic one = topicRepository.getOne(id);
        return new TopicDTO(one.getTopicId(),one.getTopicName());
    }

    @Override
    public void update(TopicDTO topicDTO) {
        topicRepository.save(new Topic(topicDTO.getTopicName()));
    }

    @Override
    public void delete(int id) {
        topicRepository.deleteById(id);
    }

    @Override
    public void insert(TopicDTO topicDTO) {
        topicRepository.save(new Topic(topicDTO.getTopicId(),topicDTO.getTopicName()));
    }
}
