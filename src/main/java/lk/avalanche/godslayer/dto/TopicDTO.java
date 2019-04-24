package lk.avalanche.godslayer.dto;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/21/2019
 * Time: 9:39 PM}
 */


public class TopicDTO extends SuperDTO{

    private int topicId;
    private String topicName;

    public TopicDTO(int topicId, String topicName) {
        this.topicId = topicId;
        this.topicName = topicName;
    }

    public TopicDTO(String topicName) {
        this.topicName = topicName;
    }

    @Override
    public String toString() {
        return "TopicDTO{" +
                "topicId=" + topicId +
                ", topicName='" + topicName + '\'' +
                '}';
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}

