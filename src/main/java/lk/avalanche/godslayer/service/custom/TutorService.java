package lk.avalanche.godslayer.service.custom;

import lk.avalanche.godslayer.dto.TutorDTO;
import lk.avalanche.godslayer.service.SuperService;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 11:10 PM}
 */


public interface TutorService extends SuperService<TutorDTO> {
    List<TutorDTO> search(String examId, String subjectId, String location, String name);
}
