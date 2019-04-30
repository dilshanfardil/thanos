package lk.avalanche.godslayer.service.custom.impl;

import lk.avalanche.godslayer.dto.*;
import lk.avalanche.godslayer.entity.*;
import lk.avalanche.godslayer.repository.*;
import lk.avalanche.godslayer.service.custom.ReviewByCategoryService;
import lk.avalanche.godslayer.service.custom.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    UserRepository userRepository;

    @Autowired
    UserTypeRepository userTypeRepository;

    @Autowired
    TutorRepository tutorRepository;

    @Override
    public List<ReviewDTO> findAll() {
        return reviewRepository.findAll().stream().map(c -> {

            User oneUser = userRepository.getOne(c.getUserId());
            UserType oneUserType = userTypeRepository.getOne(oneUser.getUserTypeId());
            Tutor oneTutor = tutorRepository.getOne(c.getTutorId());

            return new ReviewDTO(c.getReviewId(),
                    new UserDTO(oneUser.getUserId(), new UserTypeDTO(oneUserType.getUserTypeId(),oneUserType.getName()), oneUser.getName(), oneUser.getEmail(), oneUser.getPhoneNo()),
                    new TutorDTO(oneTutor.getTutorId(), oneTutor.getFname(), oneTutor.getLname(), oneTutor.getReviewValue(), oneTutor.getImage()), c.getReviewValue(), c.getReviewComment(),c.getPublish());
        }).collect(Collectors.toList());
    }

    @Override
    public ReviewDTO getrById(int id) {
        Review c = reviewRepository.getOne(id);
        User oneUser = userRepository.getOne(c.getUserId());
        UserType oneUserType = userTypeRepository.getOne(oneUser.getUserTypeId());
        Tutor oneTutor = tutorRepository.getOne(c.getTutorId());

        return new ReviewDTO(c.getReviewId(),
                new UserDTO(oneUser.getUserId(), new UserTypeDTO(oneUserType.getUserTypeId(),oneUserType.getName()), oneUser.getName(), oneUser.getEmail(), oneUser.getPhoneNo()),
                new TutorDTO(oneTutor.getTutorId(), oneTutor.getFname(), oneTutor.getLname(), oneTutor.getReviewValue(), oneTutor.getImage()), c.getReviewValue(), c.getReviewComment(),c.getPublish());

    }

    @Override
    public void update(ReviewDTO reviewDTO) {
        Review save = reviewRepository.save(new Review(reviewDTO.getUser().getUserId(), reviewDTO.getTutor().getTutorId(), reviewDTO.getReviewValue(), reviewDTO.getReviewComment(), reviewDTO.getStatus()));

        List<ReviewByCategoryDTO> reviewByCategoryDTOS = reviewDTO.getReviewByCategoryDTOS();

        for (ReviewByCategoryDTO dto : reviewByCategoryDTOS) {
            reviewByCategoryRepository.save(new ReviewByCategory(
                    dto.getReviewCategory().getReviewCategoryId(), save.getReviewId(), dto.getValue()
            ));
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void insert(ReviewDTO reviewDTO) {

        Review save = reviewRepository.save(new Review(reviewDTO.getReviewId(), reviewDTO.getUser().getUserId(), reviewDTO.getTutor().getTutorId(), reviewDTO.getReviewValue(), reviewDTO.getReviewComment(), reviewDTO.getStatus()));

        List<ReviewByCategoryDTO> reviewByCategoryDTOS = reviewDTO.getReviewByCategoryDTOS();

        for (int i = 0; i < reviewByCategoryDTOS.size(); i++) {
            ReviewByCategoryDTO dto = reviewByCategoryDTOS.get(i);

            reviewByCategoryRepository.save(new ReviewByCategory(
                    dto.getReviewByCategoryId(),i+1, save.getReviewId(), dto.getValue()
            ));

        }



    }

    @Override
    public List<ReviewDTO> fetchReviewAccordingToTutorId(int id) {
        return reviewRepository.fetchReviewAccordingToTutorId(id).stream().map(c -> {

            User oneUser = userRepository.getOne(c.getUserId());
            UserType oneUserType = userTypeRepository.getOne(oneUser.getUserTypeId());
            Tutor oneTutor = tutorRepository.getOne(c.getTutorId());

            return new ReviewDTO(c.getReviewId(),
                    new UserDTO(oneUser.getUserId(), new UserTypeDTO(oneUserType.getUserTypeId(),oneUserType.getName()), oneUser.getName(), oneUser.getEmail(), oneUser.getPhoneNo()),
                    new TutorDTO(oneTutor.getTutorId(), oneTutor.getFname(), oneTutor.getLname(), oneTutor.getReviewValue(), oneTutor.getImage()), c.getReviewValue(), c.getReviewComment(),c.getPublish());
        }).collect(Collectors.toList());
    }

    @Override
    public Integer fetchReviewCountAccordingToTutorId(int id) {
        return reviewRepository.fetchReviewCountAccordingToTutorId(id);
    }
}
