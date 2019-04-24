package lk.avalanche.godslayer.repository;

import lk.avalanche.godslayer.entity.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/9/2019
 * Time: 1:10 PM}
 */


public interface InstituteRepository extends JpaRepository<Institute, Integer> {
    @Query("SELECT new Institute(i.name,i.place) FROM Tutor t,Class c,Institute i,Subject s,Exam e " +
            "WHERE t.tutorId=c.tutorId AND c.instituteId=i.instituteId AND c.subjectId=s.subjectId AND s.examId=e.examId " +
            "AND e.examId LIKE CONCAT('%',?1) AND s.subjectId LIKE CONCAT('%',?2) AND (t.lname LIKE CONCAT('%',?3,'%') OR  t.fname LIKE CONCAT('%',?3,'%')) " +
            "GROUP BY i.place")
    List<Institute> fetchInstitutes(String examId, String subjectId, String name);
}
