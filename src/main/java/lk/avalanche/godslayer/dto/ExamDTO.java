package lk.avalanche.godslayer.dto;

import lk.avalanche.godslayer.entity.Subject;

import java.util.Set;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 3:19 PM
 */


public class ExamDTO extends SuperDTO {

    private int examId;
    private String name;

    public ExamDTO() {
    }

    public ExamDTO(int examId, String name) {
        this.examId = examId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExamDTO{" +
                "examId=" + examId +
                ", name='" + name + '\'' +
                '}';
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
