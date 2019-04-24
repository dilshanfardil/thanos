package lk.avalanche.godslayer.repository;

import lk.avalanche.godslayer.entity.Review;
import lk.avalanche.godslayer.entity.ReviewByCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/9/2019
 * Time: 1:07 PM}
 */


public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
