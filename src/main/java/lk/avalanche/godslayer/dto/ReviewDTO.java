package lk.avalanche.godslayer.dto;

import lk.avalanche.godslayer.entity.Tutor;
import lk.avalanche.godslayer.entity.User;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 3:33 PM
 */


public class ReviewDTO extends SuperDTO {

    private int reviewId;
    private UserDTO user;
    private TutorDTO tutor;
    private double reviewValue;
    private String reviewComment;
    private int status;


    public ReviewDTO() {
    }

    public ReviewDTO(int reviewId, UserDTO user, TutorDTO tutor, double reviewValue, String reviewComment, int status) {
        this.reviewId = reviewId;
        this.user = user;
        this.tutor = tutor;
        this.reviewValue = reviewValue;
        this.reviewComment = reviewComment;
        this.status = status;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public TutorDTO getTutor() {
        return tutor;
    }

    public void setTutor(TutorDTO tutor) {
        this.tutor = tutor;
    }

    public double getReviewValue() {
        return reviewValue;
    }

    public void setReviewValue(double reviewValue) {
        this.reviewValue = reviewValue;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
