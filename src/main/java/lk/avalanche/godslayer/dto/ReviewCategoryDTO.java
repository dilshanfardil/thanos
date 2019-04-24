package lk.avalanche.godslayer.dto;

import lk.avalanche.godslayer.entity.ReviewByCategory;

import java.util.Set;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 3:28 PM
 */


public class ReviewCategoryDTO extends SuperDTO {

    private int reviewCategoryId;
    private String name;


    public ReviewCategoryDTO() {
    }

    public ReviewCategoryDTO(int reviewCategoryId, String name) {
        this.reviewCategoryId = reviewCategoryId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReviewCategoryDTO{" +
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
