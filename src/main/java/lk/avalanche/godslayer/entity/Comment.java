package lk.avalanche.godslayer.entity;

import javax.persistence.*;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/22/2019
 * Time: 2:31 AM}
 */

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private int commentId;

    @JoinColumn(name = "topic_id", referencedColumnName = "topic_id")
    private int topicId;

    @JoinColumn(name = "comment_details_id", referencedColumnName = "comment_details_id")
    private int commentDetailsId;


    public Comment() {
    }

    public Comment(int topicId, int commentId, int commentDetailsId) {
        this.topicId = topicId;
        this.commentId = commentId;
        this.commentDetailsId = commentDetailsId;
    }

    public Comment(int commentId, int commentDetailsId) {
        this.commentId = commentId;
        this.commentDetailsId = commentDetailsId;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "topicId=" + topicId +
                ", commentId=" + commentId +
                ", commentDetailsId=" + commentDetailsId +
                '}';
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getCommentDetailsId() {
        return commentDetailsId;
    }

    public void setCommentDetailsId(int commentDetailsId) {
        this.commentDetailsId = commentDetailsId;
    }

}
