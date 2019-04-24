package lk.avalanche.godslayer.dto;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 3:16 PM}
 */

public class ClassDTO extends SuperDTO{

    private int classId;

    private String day;
    private String fromTime;
    private String toTime;

    private TutorDTO tutor;
    private SubjectDTO subject;
    private InstitueDTO institute;

    public ClassDTO() {
    }

    public ClassDTO(int classId, String day, String fromTime, String toTime, TutorDTO tutor, SubjectDTO subject, InstitueDTO institute) {
        this.classId = classId;
        this.day = day;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.tutor = tutor;
        this.subject = subject;
        this.institute = institute;
    }

    @Override
    public String toString() {
        return "ClassDTO{" +
                "classId=" + classId +
                ", day='" + day + '\'' +
                ", fromTime='" + fromTime + '\'' +
                ", toTime='" + toTime + '\'' +
                ", tutor=" + tutor +
                ", subject=" + subject +
                ", institute=" + institute +
                '}';
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
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

    public TutorDTO getTutor() {
        return tutor;
    }

    public void setTutor(TutorDTO tutor) {
        this.tutor = tutor;
    }

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }

    public InstitueDTO getInstitute() {
        return institute;
    }

    public void setInstitute(InstitueDTO institute) {
        this.institute = institute;
    }
}
