package lk.avalanche.godslayer.repository;

import lk.avalanche.godslayer.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/9/2019
 * Time: 1:07 PM}
 */


public interface ClassRepository extends JpaRepository<Class, Integer> {

    @Query("SELECT new Class(c.classId,c.tutorId, c.instituteId,c.subjectId,c.day,c.fromTime,c.toTime) FROM Class c WHERE c.tutorId=?1")
    List<Class> fetchClassAccordingToTutorId(int id);

}
