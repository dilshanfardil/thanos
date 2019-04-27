package lk.avalanche.godslayer.service.custom;

import lk.avalanche.godslayer.dto.ReviewByCategoryDTO;
import lk.avalanche.godslayer.dto.ReviewDTO;
import lk.avalanche.godslayer.entity.Review;
import lk.avalanche.godslayer.entity.ReviewByCategory;
import lk.avalanche.godslayer.service.SuperService;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 11:12 PM}
 */


public interface  ReviewService extends SuperService<ReviewDTO> {

    List<ReviewDTO> fetchReviewAccordingToTutorId(int id);

    Integer fetchReviewCountAccordingToTutorId(int id);
}
