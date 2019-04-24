package lk.avalanche.godslayer.service.custom.impl;

import lk.avalanche.godslayer.dto.CommentDTO;
import lk.avalanche.godslayer.dto.SubCommentDTO;
import lk.avalanche.godslayer.entity.SubComment;
import lk.avalanche.godslayer.repository.SubCommentRepository;
import lk.avalanche.godslayer.service.custom.SubCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/22/2019
 * Time: 4:38 PM}
 */

@Service
public class SubCommentServiceImpl implements SubCommentService {

    @Autowired
    SubCommentRepository subCommentRepository;

    @Override
    public List<SubCommentDTO> findAll() {
        return subCommentRepository.findAll().stream().map(c -> {
            return new SubCommentDTO(c.getSubCommentId(),c.getCommentId(), c.getCommentDetailsId());
        }).collect(Collectors.toList());
    }

    @Override
    public SubCommentDTO getrById(int id) {
        SubComment one = subCommentRepository.getOne(id);
        return new SubCommentDTO(one.getSubCommentId(), one.getCommentId(), one.getCommentDetailsId());
    }

    @Override
    public void update(SubCommentDTO subCommentDTO) {
        subCommentRepository.save(new SubComment(subCommentDTO.getSubCommentId(), subCommentDTO.getCommentId(), subCommentDTO.getCommentDetailsId()));
    }

    @Override
    public void delete(int id) {
        subCommentRepository.deleteById(id);
    }

    @Override
    public void insert(SubCommentDTO subCommentDTO) {
        subCommentRepository.save(new SubComment(subCommentDTO.getCommentId(), subCommentDTO.getCommentDetailsId()));
    }
}
