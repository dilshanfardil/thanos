package lk.avalanche.godslayer.dto;

import lk.avalanche.godslayer.entity.Class;
import lk.avalanche.godslayer.entity.Exam;

import java.util.Set;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 3:27 PM
 */


public class SubjectDTO extends SuperDTO {

    private int subjectId;
    private ExamDTO exam;
    private String name;

    public SubjectDTO() {
    }

    public SubjectDTO(int subjectId, ExamDTO exam, String name) {
        this.subjectId = subjectId;
        this.exam = exam;
        this.name = name;
    }

    public SubjectDTO(int subjectId, String name) {
        this.subjectId=subjectId;
        this.name=name;
    }

    @Override
    public String toString() {
        return "SubjectDTO{" +
                "subjectId=" + subjectId +
                ", exam=" + exam +
                ", name='" + name + '\'' +
                '}';
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public ExamDTO getExam() {
        return exam;
    }

    public void setExam(ExamDTO exam) {
        this.exam = exam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
