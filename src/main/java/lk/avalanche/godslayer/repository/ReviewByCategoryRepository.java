package lk.avalanche.godslayer.repository;

import lk.avalanche.godslayer.entity.ReviewByCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/9/2019
 * Time: 1:12 PM}
 */


public interface ReviewByCategoryRepository extends JpaRepository<ReviewByCategory, Integer> {

    @Query("SELECT new ReviewByCategory(r.reviewByCategoryId, r.reviewCategoryId, r.reviewId, r.value) FROM ReviewByCategory r WHERE r.reviewId=?1")
    List<ReviewByCategory> fetchReviewByCategoryAccordingToReviewId(int id);

}
