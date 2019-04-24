package lk.avalanche.godslayer.dto;

import lk.avalanche.godslayer.entity.Review;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 3:30 PM
 */


public class ReviewByCategoryDTO extends SuperDTO {

    private int reviewByCategoryId;

    private ReviewCategoryDTO reviewCategory;
    private ReviewDTO review;
    private double value;

    public ReviewByCategoryDTO() {
    }

    public ReviewByCategoryDTO(int reviewByCategoryId, ReviewCategoryDTO reviewCategory, ReviewDTO review, double value) {
        this.reviewByCategoryId = reviewByCategoryId;
        this.reviewCategory = reviewCategory;
        this.review = review;
        this.value = value;
    }

    @Override
    public String toString() {
        return "ReviewByCategoryDTO{" +
                "reviewByCategoryId=" + reviewByCategoryId +
                ", reviewCategory=" + reviewCategory +
                ", review=" + review +
                ", value=" + value +
                '}';
    }

    public int getReviewByCategoryId() {
        return reviewByCategoryId;
    }

    public void setReviewByCategoryId(int reviewByCategoryId) {
        this.reviewByCategoryId = reviewByCategoryId;
    }

    public ReviewCategoryDTO getReviewCategory() {
        return reviewCategory;
    }

    public void setReviewCategory(ReviewCategoryDTO reviewCategory) {
        this.reviewCategory = reviewCategory;
    }

    public ReviewDTO getReview() {
        return review;
    }

    public void setReview(ReviewDTO review) {
        this.review = review;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
