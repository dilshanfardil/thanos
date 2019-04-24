package lk.avalanche.godslayer.service.custom.impl;

import lk.avalanche.godslayer.dto.*;
import lk.avalanche.godslayer.entity.*;
import lk.avalanche.godslayer.repository.*;
import lk.avalanche.godslayer.service.custom.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/11/2019
 * Time: 1:23 AM}
 */

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ReviewByCategoryRepository reviewByCategoryRepository;

    @Autowired
    ReviewCategoryRepository reviewCategoryRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TutorRepository tutorRepository;

    @Autowired
    UserTypeRepository userTypeRepository;

    @Override
    public List<ReviewByCategoryDTO> findAll() {
        List<ReviewByCategory> all = reviewByCategoryRepository.findAll();

        List<ReviewByCategoryDTO> returnAll = new ArrayList<>();

        for (int i = 0; i < all.size(); i++) {
            ReviewByCategory reviewByCategory = all.get(i);

            ReviewCategory reviewCategory = reviewCategoryRepository.getOne(reviewByCategory.getReviewCategoryId());
            Review review = reviewRepository.getOne(reviewByCategory.getReviewId());
            User user = userRepository.getOne(review.getUserId());
            Tutor tutor = tutorRepository.getOne(review.getTutorId());
            UserType userType = userTypeRepository.getOne(user.getUserTypeId());

            ReviewCategoryDTO reviewCategoryDTO = new ReviewCategoryDTO(reviewCategory.getReviewCategoryId(), reviewCategory.getName());
            UserDTO userDTO = new UserDTO(user.getUserId(), new UserTypeDTO(userType.getUserTypeId(), userType.getName()), user.getName(), user.getEmail(), user.getPhoneNo());
            TutorDTO tutorDTO = new TutorDTO(tutor.getTutorId(), tutor.getLname(), tutor.getFname(), tutor.getReviewValue(), tutor.getImage());


            ReviewByCategoryDTO reviewByCategoryDTO = new ReviewByCategoryDTO(
                    reviewByCategory.getReviewByCategoryId(),
                    reviewCategoryDTO,
                    new ReviewDTO(review.getReviewId(), userDTO, tutorDTO, review.getReviewValue(), review.getReviewComment(), review.getPublish()),
                    reviewByCategory.getValue()
            );

            returnAll.add(reviewByCategoryDTO);
//            UserDTO userDTO = new UserDTO(one.getUserId().getUserId(), one.getUserId().get )
//
//            ReviewByCategoryDTO reviewByCategoryDTO = new ReviewByCategoryDTO(
//                    reviewByCategory.getReviewByCategoryId(),
//                    new ReviewCategory(c.getReviewCategoryId().getName()), c.getReview().getReviewId(), c.getValue());
//
//
//            returnAll.add(reviewByCategory);
        }

        return returnAll;
    }

    @Override
    public ReviewByCategoryDTO getrById(int id) {
        ReviewByCategory reviewByCategory = reviewByCategoryRepository.getOne(id);

        ReviewCategory reviewCategory = reviewCategoryRepository.getOne(reviewByCategory.getReviewCategoryId());
        Review review = reviewRepository.getOne(reviewByCategory.getReviewId());
        User user = userRepository.getOne(review.getUserId());
        Tutor tutor = tutorRepository.getOne(review.getTutorId());
        UserType userType = userTypeRepository.getOne(user.getUserTypeId());

        ReviewCategoryDTO reviewCategoryDTO = new ReviewCategoryDTO(reviewCategory.getReviewCategoryId(), reviewCategory.getName());
        UserDTO userDTO = new UserDTO(user.getUserId(), new UserTypeDTO(userType.getUserTypeId(), userType.getName()), user.getName(), user.getEmail(), user.getPhoneNo());
        TutorDTO tutorDTO = new TutorDTO(tutor.getTutorId(), tutor.getLname(), tutor.getFname(), tutor.getReviewValue(), tutor.getImage());


        return new ReviewByCategoryDTO(
                reviewByCategory.getReviewByCategoryId(),
                reviewCategoryDTO,
                new ReviewDTO(review.getReviewId(), userDTO, tutorDTO, review.getReviewValue(), review.getReviewComment(), review.getPublish()),
                reviewByCategory.getValue()
        );
    }

    @Override
    public void update(ReviewByCategoryDTO dto) {

        Review review = new Review(
                dto.getReview().getReviewId(),
                dto.getReview().getUser().getUserId(),
                dto.getReview().getTutor().getTutorId(),
                dto.getValue(),
                dto.getReview().getReviewComment(),
                dto.getReview().getStatus()
        );

        Review save = reviewRepository.save(review);


        ReviewByCategory reviewByCategory = new ReviewByCategory(
                dto.getReviewByCategoryId(),
                dto.getReviewCategory().getReviewCategoryId(), save.getReviewId(), dto.getValue()
        );

        System.out.println(reviewByCategory);

        reviewByCategoryRepository.save(reviewByCategory);
    }

    @Override
    public void delete(int id) {
        reviewByCategoryRepository.deleteById(id);
    }

    @Override
    public void insert(ReviewByCategoryDTO dto) {

        Review review = new Review(
                dto.getReview().getUser().getUserId(),
                dto.getReview().getTutor().getTutorId(),
                dto.getValue(),
                dto.getReview().getReviewComment(),
                dto.getReview().getStatus()
        );

        Review save = reviewRepository.save(review);


        ReviewByCategory reviewByCategory = new ReviewByCategory(
                dto.getReviewCategory().getReviewCategoryId(), save.getReviewId(), dto.getValue()
        );

        System.out.println(reviewByCategory);

        reviewByCategoryRepository.save(reviewByCategory);
    }
}
