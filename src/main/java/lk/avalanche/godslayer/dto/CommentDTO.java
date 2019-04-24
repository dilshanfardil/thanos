package lk.avalanche.godslayer.dto;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/21/2019
 * Time: 9:41 PM}
 */


public class CommentDTO extends SuperDTO{

    private int topicId;
    private int commentId;
    private int commentDtailsId;

    public CommentDTO(int topicId, int commentId, int commentDtailsId) {
        this.topicId = topicId;
        this.commentId = commentId;
        this.commentDtailsId = commentDtailsId;
    }

    public CommentDTO(int commentId, int commentDtailsId) {
        this.commentId = commentId;
        this.commentDtailsId = commentDtailsId;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "topicId=" + topicId +
                ", commentId=" + commentId +
                ", commentDtailsId=" + commentDtailsId +
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

    public int getCommentDtailsId() {
        return commentDtailsId;
    }

    public void setCommentDtailsId(int commentDtailsId) {
        this.commentDtailsId = commentDtailsId;
    }
}
