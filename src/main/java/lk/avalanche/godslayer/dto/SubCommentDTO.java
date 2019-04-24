package lk.avalanche.godslayer.dto;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/21/2019
 * Time: 9:42 PM}
 */


public class SubCommentDTO extends SuperDTO{

    private int subCommentId;
    private int commentId;
    private int commentDetailsId;

    public SubCommentDTO(int subCommentId, int commentId, int commentDetailsId) {
        this.subCommentId = subCommentId;
        this.commentId = commentId;
        this.commentDetailsId = commentDetailsId;
    }

    public SubCommentDTO(int commentId, int commentDetailsId) {
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
