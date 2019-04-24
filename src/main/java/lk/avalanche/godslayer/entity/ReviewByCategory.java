package lk.avalanche.godslayer.entity;

import javax.persistence.*;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 10:03 PM}
 */

@Entity
@Table(name = "review_by_category")
public class ReviewByCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_by_category_id")
    private int reviewByCategoryId;

//    @ManyToOne(targetEntity = ReviewCategory.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "review_category_id" , referencedColumnName = "review_category_id")
    private int reviewCategoryId;

//    @OneToOne(targetEntity = Review.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "review_id" , referencedColumnName = "review_id")
    private int reviewId;

    @Column(name = "value")
    private double value;

    public ReviewByCategory() {
    }

    public ReviewByCategory(int reviewByCategoryId, int reviewCategoryId, int reviewId, double value) {
        this.reviewByCategoryId = reviewByCategoryId;
        this.reviewCategoryId = reviewCategoryId;
        this.reviewId = reviewId;
        this.value = value;
    }

    public ReviewByCategory(int reviewCategoryId, int reviewId, double value) {
        this.reviewCategoryId = reviewCategoryId;
        this.reviewId = reviewId;
        this.value = value;
    }

    @Override
    public String toString() {
        return "ReviewByCategory{" +
                "reviewByCategoryId=" + reviewByCategoryId +
                ", reviewCategoryId=" + reviewCategoryId +
                ", reviewId=" + reviewId +
                ", value=" + value +
                '}';
    }

    public int getReviewByCategoryId() {
        return reviewByCategoryId;
    }

    public void setReviewByCategoryId(int reviewByCategoryId) {
        this.reviewByCategoryId = reviewByCategoryId;
    }

    public int getReviewCategoryId() {
        return reviewCategoryId;
    }

    public void setReviewCategoryId(int reviewCategoryId) {
        this.reviewCategoryId = reviewCategoryId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
