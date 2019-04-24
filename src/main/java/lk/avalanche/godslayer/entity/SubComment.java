package lk.avalanche.godslayer.entity;

import javax.persistence.*;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/22/2019
 * Time: 2:36 AM}
 */

@Entity
@Table(name = "sub_comment")
public class SubComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sub_comment_id")
    private int subCommentId;

    @JoinColumn(name = "comment_id", referencedColumnName = "comment_id")
    private int commentId;

    @JoinColumn(name = "comment_details_id", referencedColumnName = "comment_details_id")
    private int commentDetailsId;

    public SubComment() {
    }

    public SubComment(int subCommentId, int commentId, int commentDetailsId) {
        this.subCommentId = subCommentId;
        this.commentId = commentId;
        this.commentDetailsId = commentDetailsId;
    }

    public SubComment(int commentId, int commentDetailsId) {
        this.commentId = commentId;
        this.commentDetailsId = commentDetailsId;
    }


    @Override
    public String toString() {
        return "SubCommentDTO{" +
                "subCommentId=" + subCommentId +
                ", commentId=" + commentId +
                ", commentDetailsId=" + commentDetailsId +
                '}';
    }

    public int getSubCommentId() {
        return subCommentId;
    }

    public void setSubCommentId(int subCommentId) {
        this.subCommentId = subCommentId;
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
