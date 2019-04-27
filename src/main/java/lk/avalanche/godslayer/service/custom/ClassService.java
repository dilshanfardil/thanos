package lk.avalanche.godslayer.service.custom;

import lk.avalanche.godslayer.dto.ClassDTO;
import lk.avalanche.godslayer.service.SuperService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/14/2019
 * Time: 10:56 AM}
 */


public interface ClassService extends SuperService<ClassDTO> {

    List<ClassDTO> fetchClassAccordingToTutorId(int id);

}
