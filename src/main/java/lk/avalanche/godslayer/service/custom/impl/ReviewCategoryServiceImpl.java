package lk.avalanche.godslayer.service.custom.impl;


import lk.avalanche.godslayer.dto.ReviewCategoryDTO;
import lk.avalanche.godslayer.entity.ReviewCategory;
import lk.avalanche.godslayer.repository.ReviewCategoryRepository;
import lk.avalanche.godslayer.service.custom.ReviewCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/14/2019
 * Time: 12:13 AM}
 */

@Service
public class ReviewCategoryServiceImpl implements ReviewCategoryService {

    @Autowired
    ReviewCategoryRepository reviewCategoryRepository;

    @Override
    public List<ReviewCategoryDTO> findAll() {
        return reviewCategoryRepository.findAll().stream().map(c -> {
            return new ReviewCategoryDTO(c.getReviewCategoryId(), c.getName());
        }).collect(Collectors.toList());
    }

    @Override
    public ReviewCategoryDTO getrById(int id) {
        ReviewCategory one = reviewCategoryRepository.getOne(id);
        return new ReviewCategoryDTO(one.getReviewCategoryId(), one.getName());
    }

    @Override
    public void update(ReviewCategoryDTO reviewCategoryDTO) {
        reviewCategoryRepository.save(new ReviewCategory(reviewCategoryDTO.getReviewCategoryId(),reviewCategoryDTO.getName()));
    }

    @Override
    public void delete(int id) {
        reviewCategoryRepository.deleteById(id);
    }

    @Override
    public void insert(ReviewCategoryDTO reviewCategoryDTO) {
        reviewCategoryRepository.save(new ReviewCategory(reviewCategoryDTO.getName()));
    }
}
