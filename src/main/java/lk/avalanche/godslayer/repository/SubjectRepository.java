package lk.avalanche.godslayer.repository;

import lk.avalanche.godslayer.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/9/2019
 * Time: 1:08 PM
 */


public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    @Query("SELECT new Subject(s.subjectId,s.name) FROM Tutor t,Class c,Institute i,Subject s,Exam e " +
            "WHERE t.tutorId=c.tutorId AND c.instituteId=i.instituteId AND c.subjectId=s.subjectId AND s.examId=e.examId " +
            "AND e.examId LIKE CONCAT('%',?1) AND i.place LIKE CONCAT('%',?2,'%') AND (t.lname LIKE CONCAT('%',?3,'%') OR  t.fname LIKE CONCAT('%',?3,'%')) " +
            "GROUP BY s.name")
    List<Subject> fetchSubjects(String examId, String location, String name);

}
