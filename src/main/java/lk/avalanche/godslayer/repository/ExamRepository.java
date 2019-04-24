package lk.avalanche.godslayer.repository;

import lk.avalanche.godslayer.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/9/2019
 * Time: 1:09 PM
 */


public interface ExamRepository extends JpaRepository<Exam, Integer> {

    @Query("SELECT new Exam (e.examId,e.name) FROM Tutor t,Class c,Institute i,Subject s,Exam e " +
            "WHERE t.tutorId=c.tutorId AND c.instituteId=i.instituteId AND c.subjectId=s.subjectId AND s.examId=e.examId " +
            "AND s.subjectId LIKE CONCAT('%',?1) AND i.place LIKE CONCAT('%',?2,'%') AND (t.lname LIKE CONCAT('%',?3,'%') OR  t.fname LIKE CONCAT('%',?3,'%')) " +
            "GROUP BY e.name")
    List<Exam> fetchExams(String subjectId, String location, String name);

}
