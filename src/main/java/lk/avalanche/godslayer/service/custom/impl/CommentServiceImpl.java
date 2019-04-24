package lk.avalanche.godslayer.service.custom.impl;

import lk.avalanche.godslayer.dto.CommentDTO;
import lk.avalanche.godslayer.entity.Comment;
import lk.avalanche.godslayer.repository.CommentRepository;
import lk.avalanche.godslayer.service.custom.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/22/2019
 * Time: 4:13 PM}
 */


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;


    @Override
    public List<CommentDTO> findAll() {
        return commentRepository.findAll().stream().map(c -> {
            return new CommentDTO(c.getCommentId(), c.getTopicId(), c.getCommentDetailsId());
        }).collect(Collectors.toList());
    }

    @Override
    public CommentDTO getrById(int id) {
        Comment one = commentRepository.getOne(id);
        return new CommentDTO(one.getCommentId(), one.getTopicId(), one.getCommentDetailsId());
    }

    @Override
    public void update(CommentDTO commentDTO) {
        commentRepository.save(new Comment(commentDTO.getCommentId(), commentDTO.getTopicId(), commentDTO.getCommentDtailsId()));
    }

    @Override
    public void delete(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void insert(CommentDTO commentDTO) {
        commentRepository.save(new Comment(commentDTO.getTopicId(), commentDTO.getCommentDtailsId()));
    }
}
