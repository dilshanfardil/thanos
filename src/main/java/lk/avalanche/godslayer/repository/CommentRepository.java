package lk.avalanche.godslayer.repository;


import lk.avalanche.godslayer.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/22/2019
 * Time: 11:40 AM
 */


public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
