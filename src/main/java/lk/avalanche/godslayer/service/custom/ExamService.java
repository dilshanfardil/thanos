package lk.avalanche.godslayer.service.custom;

import lk.avalanche.godslayer.dto.ExamDTO;
import lk.avalanche.godslayer.service.SuperService;

import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/9/2019
 * Time: 12:56 PM}
 */


public interface ExamService extends SuperService<ExamDTO> {
    List<ExamDTO> fetchExams(String subjectId, String location, String name);
}
