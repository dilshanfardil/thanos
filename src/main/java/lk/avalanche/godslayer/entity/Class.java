package lk.avalanche.godslayer.entity;

import javax.persistence.*;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 6:35 PM}
 */


@Entity
@Table(name = "class")
public class Class {

    @Id
    @GeneratedValue()
    @Column(name = "class_id")
    private int classId;

    @JoinColumn(name = "tutor_id", referencedColumnName = "tutor_id")
    private int tutorId;

    @JoinColumn(name = "institute_id", referencedColumnName = "institute_id")
    private int instituteId;

    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private int subjectId;

    @Column(name = "day")
    private String day;

    @Column(name = "from_time")
    private String fromTime;

    @Column(name = "to_time")
    private String toTime;

    @Column(name = "year")
    private int year;


    public Class() {
    }

    public Class(int classId, int tutorId, int instituteId, int subjectId, String day, String fromTime, String toTime, int year) {
        this.classId = classId;
        this.tutorId = tutorId;
        this.instituteId = instituteId;
        this.subjectId = subjectId;
        this.day = day;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.year = year;
    }


    public Class(int tutorId, int instituteId, int subjectId, String day, String fromTime, String toTime, int year) {
        this.tutorId = tutorId;
        this.instituteId = instituteId;
        this.subjectId = subjectId;
        this.day = day;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.year = year;
    }



    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", tutorId=" + tutorId +
                ", instituteId=" + instituteId +
                ", subjectId=" + subjectId +
                ", day='" + day + '\'' +
                ", fromTime='" + fromTime + '\'' +
                ", toTime='" + toTime + '\'' +
                ", year=" + year +
                '}';
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getTutorId() {
        return tutorId;
    }

    public void setTutorId(int tutorId) {
        this.tutorId = tutorId;
    }

    public int getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(int instituteId) {
        this.instituteId = instituteId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
