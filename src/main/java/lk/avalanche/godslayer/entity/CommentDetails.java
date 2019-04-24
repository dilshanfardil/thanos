package lk.avalanche.godslayer.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/22/2019
 * Time: 2:40 AM}
 */

@Entity
@Table(name = "comment_details")
public class CommentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commentDetailsId;

    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private int userId;

    @Column(name = "like")
    private int like;

    @Column(name = "dislike")
    private int dislike;

    @Column(name = "date_time")
    private String date;

    @Column(name = "comment")
    private String comment;


    public CommentDetails() {
    }

    public CommentDetails(int commentDetailsId, int userId, int like, int dislike, String date, String comment) {
        this.commentDetailsId = commentDetailsId;
        this.userId = userId;
        this.like = like;
        this.dislike = dislike;
        this.date = date;
        this.comment = comment;
    }

    public CommentDetails(int userId, int like, int dislike, String date, String comment) {
        this.userId = userId;
        this.like = like;
        this.dislike = dislike;
        this.date = date;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "CommentDetailsDTO{" +
                "commentDetailsId=" + commentDetailsId +
                ", userId=" + userId +
                ", like=" + like +
                ", dislike=" + dislike +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                '}';
    }

    public int getCommentDetailsId() {
        return commentDetailsId;
    }

    public void setCommentDetailsId(int commentDetailsId) {
        this.commentDetailsId = commentDetailsId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
