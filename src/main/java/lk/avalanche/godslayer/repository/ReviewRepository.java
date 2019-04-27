package lk.avalanche.godslayer.repository;

import lk.avalanche.godslayer.entity.Review;
import lk.avalanche.godslayer.entity.ReviewByCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/9/2019
 * Time: 1:07 PM}
 */


public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query("SELECT r FROM Review r WHERE r.tutorId=?1")
    List<Review> fetchReviewAccordingToTutorId(int id);

    @Query("SELECT COUNT(r) FROM Review r WHERE r.tutorId=?1")
    Integer fetchReviewCountAccordingToTutorId(int id);

}
