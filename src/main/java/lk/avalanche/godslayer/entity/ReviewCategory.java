package lk.avalanche.godslayer.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 10:03 PM}
 */


@Entity
@Table(name = "review_category")
public class ReviewCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_category_id")
    private int reviewCategoryId;

    @Column(name = "name")
    private String name;

    public ReviewCategory() {
    }

    public ReviewCategory(int reviewCategoryId, String name) {
        this.name = name;
    }

    public ReviewCategory(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReviewCategory{" +
                "reviewCategoryId=" + reviewCategoryId +
                ", name='" + name + '\'' +
                '}';
    }

    public int getReviewCategoryId() {
        return reviewCategoryId;
    }

    public void setReviewCategoryId(int reviewCategoryId) {
        this.reviewCategoryId = reviewCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
