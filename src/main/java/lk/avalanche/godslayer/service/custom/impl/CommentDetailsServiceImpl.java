package lk.avalanche.godslayer.service.custom.impl;

import lk.avalanche.godslayer.dto.CommentDetailsDTO;
import lk.avalanche.godslayer.entity.CommentDetails;
import lk.avalanche.godslayer.repository.CommentDetailsRepository;
import lk.avalanche.godslayer.service.custom.CommentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/22/2019
 * Time: 5:05 PM}
 */

@Service
public class CommentDetailsServiceImpl implements CommentDetailsService {

    @Autowired
    CommentDetailsRepository commentDetailsRepository;

    @Override
    public List<CommentDetailsDTO> findAll() {
        return commentDetailsRepository.findAll().stream().map(c -> {
            return new CommentDetailsDTO(c.getCommentDetailsId(), c.getUserId(), c.getLike(), c.getDislike(),c.getDate(),c.getComment());
        }).collect(Collectors.toList());
    }

    @Override
    public CommentDetailsDTO getrById(int id) {
        CommentDetails one = commentDetailsRepository.getOne(id);
        return new CommentDetailsDTO(one.getCommentDetailsId(), one.getUserId(), one.getLike(), one.getDislike(),one.getDate(),one.getComment());
    }

    @Override
    public void update(CommentDetailsDTO commentDetailsDTO) {
        commentDetailsRepository.save(new CommentDetails(commentDetailsDTO.getUserId(),
                commentDetailsDTO.getLike(),
                commentDetailsDTO.getDislike(),
                commentDetailsDTO.getDate(),
                commentDetailsDTO.getComment()));
    }

    @Override
    public void delete(int id) {
        commentDetailsRepository.deleteById(id);
    }

    @Override
    public void insert(CommentDetailsDTO commentDetailsDTO) {
        commentDetailsRepository.save(new CommentDetails(commentDetailsDTO.getCommentDetailsId(),
                commentDetailsDTO.getUserId(),
                commentDetailsDTO.getLike(),
                commentDetailsDTO.getDislike(),
                commentDetailsDTO.getDate(),
                commentDetailsDTO.getComment()));

    }
}
