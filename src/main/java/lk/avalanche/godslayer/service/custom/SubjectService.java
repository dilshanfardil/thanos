package lk.avalanche.godslayer.service.custom;

import lk.avalanche.godslayer.dto.SubjectDTO;
import lk.avalanche.godslayer.service.SuperService;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/9/2019
 * Time: 12:55 PM}
 */


public interface SubjectService extends SuperService<SubjectDTO> {
    List<SubjectDTO> fetchSubjects(String examId, String location, String name);
}
