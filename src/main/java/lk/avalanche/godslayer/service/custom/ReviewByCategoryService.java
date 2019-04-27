package lk.avalanche.godslayer.service.custom;

import lk.avalanche.godslayer.dto.ReviewByCategoryDTO;
import lk.avalanche.godslayer.entity.ReviewByCategory;
import lk.avalanche.godslayer.service.SuperService;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/26/2019
 * Time: 10:34 PM}
 */


public interface ReviewByCategoryService extends SuperService<ReviewByCategoryDTO> {

    List<ReviewByCategoryDTO> fetchReviewByCategoryAccordingToReviewId(int id);

}
