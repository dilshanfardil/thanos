package lk.avalanche.godslayer.repository;

import lk.avalanche.godslayer.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/9/2019
 * Time: 1:04 PM
 */


public interface TutorRepository extends JpaRepository<Tutor, Integer> {
    @Query("SELECT new Tutor(t.tutorId,t.lname,t.fname,t.reviewValue,t.image) FROM Tutor t,Class c,Institute i,Subject s,Exam e " +
            "WHERE t.tutorId=c.tutorId AND c.instituteId=i.instituteId AND c.subjectId=s.subjectId AND s.examId=e.examId " +
            "AND e.examId LIKE CONCAT('%',?1) AND s.subjectId LIKE CONCAT('%',?2) AND i.place LIKE CONCAT('%',?3,'%') AND (t.lname LIKE CONCAT('%',?4,'%') OR  t.fname LIKE CONCAT('%',?4,'%')) " +
            "GROUP BY t.tutorId")
    List<Tutor> fetchTutorAccordingToSearch(String examId, String subjectId, String location, String name);
}
