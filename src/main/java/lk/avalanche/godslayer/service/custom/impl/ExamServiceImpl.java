package lk.avalanche.godslayer.service.custom.impl;

import lk.avalanche.godslayer.dto.ExamDTO;
import lk.avalanche.godslayer.entity.Exam;
import lk.avalanche.godslayer.repository.ExamRepository;
import lk.avalanche.godslayer.service.custom.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/11/2019
 * Time: 1:17 AM}
 */

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    ExamRepository examRepository;

    @Override
    public List<ExamDTO> findAll() {
        return examRepository.findAll().stream().map(c -> {
            return new ExamDTO(c.getExamId(), c.getName());
        }).collect(Collectors.toList());
    }

    @Override
    public ExamDTO getrById(int id) {
        Exam one = examRepository.getOne(id);
        return new ExamDTO(one.getExamId(),one.getName());
    }

    @Override
    public void update(ExamDTO examDTO) {
        examRepository.save(new Exam(examDTO.getExamId(), examDTO.getName()));
    }

    @Override
    public void delete(int id) {
        examRepository.deleteById(id);
    }

    @Override
    public void insert(ExamDTO examDTO) {
        examRepository.save(new Exam(examDTO.getName()));
    }


    @Override
    public List<ExamDTO> fetchExams(String subjectId, String location, String name) {
        return examRepository.fetchExams(subjectId,location,name).stream().map(c -> new ExamDTO(c.getExamId(), c.getName())).collect(Collectors.toList());
    }

}
