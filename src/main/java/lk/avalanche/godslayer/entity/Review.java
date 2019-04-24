package lk.avalanche.godslayer.entity;

import javax.persistence.*;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 10:02 PM}
 */

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private int reviewId;

//    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id" , referencedColumnName = "user_id")
    private int userId;

//    @OneToOne(targetEntity = Tutor.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "tutor_id" , referencedColumnName = "tutor_id")
    private int tutorId;

    @Column(name = "review_value")
    private double reviewValue;

    @Column(name = "review_comment")
    private String reviewComment;

    @Column(name = "publish")
    private int publish;

    public Review() {
    }

    public Review(int reviewId, int userId, int tutorId, double reviewValue, String reviewComment, int publish) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.tutorId = tutorId;
        this.reviewValue = reviewValue;
        this.reviewComment = reviewComment;
        this.publish = publish;
    }

    public Review(int userId, int tutorId, double reviewValue, String reviewComment, int publish) {
        this.userId = userId;
        this.tutorId = tutorId;
        this.reviewValue = reviewValue;
        this.reviewComment = reviewComment;
        this.publish = publish;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", userId=" + userId +
                ", tutorId=" + tutorId +
                ", reviewValue=" + reviewValue +
                ", reviewComment='" + reviewComment + '\'' +
                ", publish=" + publish +
                '}';
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTutorId() {
        return tutorId;
    }

    public void setTutorId(int tutorId) {
        this.tutorId = tutorId;
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

    public int getPublish() {
        return publish;
    }

    public void setPublish(int publish) {
        this.publish = publish;
    }
}
