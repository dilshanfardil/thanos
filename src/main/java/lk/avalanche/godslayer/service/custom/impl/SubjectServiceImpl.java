package lk.avalanche.godslayer.service.custom.impl;

import lk.avalanche.godslayer.dto.ExamDTO;
import lk.avalanche.godslayer.dto.SubjectDTO;
import lk.avalanche.godslayer.entity.Exam;
import lk.avalanche.godslayer.entity.Subject;
import lk.avalanche.godslayer.repository.ExamRepository;
import lk.avalanche.godslayer.repository.SubjectRepository;
import lk.avalanche.godslayer.service.custom.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/11/2019
 * Time: 1:25 AM}
 */

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    ExamRepository examRepository;

    @Override
    public List<SubjectDTO> findAll() {
        return subjectRepository.findAll().stream().map(c -> {
            Exam one = examRepository.getOne(c.getExamId());
            return new SubjectDTO(c.getSubjectId(), new ExamDTO(one.getExamId(),one.getName()),c.getName());
        }).collect(Collectors.toList());
    }

    @Override
    public SubjectDTO getrById(int id) {
        Subject subject = subjectRepository.getOne(id);
        Exam exam = examRepository.getOne(subject.getExamId());

        SubjectDTO subjectDTO =  new SubjectDTO(subject.getSubjectId(), new ExamDTO(exam.getExamId(),exam.getName()),subject.getName());


        return subjectDTO;
    }

    @Override
    public void update(SubjectDTO subjectDTO) {
        subjectRepository.save(new Subject(subjectDTO.getSubjectId(),subjectDTO.getExam().getExamId(), subjectDTO.getName()));
    }

    @Override
    public void delete(int id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public void insert(SubjectDTO subjectDTO) {
        subjectRepository.save(new Subject(subjectDTO.getExam().getExamId(), subjectDTO.getName()));
    }

    @Override
    public List<SubjectDTO> fetchSubjects(String examId, String location, String name) {
        return subjectRepository.fetchSubjects(examId,location,name).stream().map(c -> {
            return new SubjectDTO(c.getSubjectId(),c.getName());
        }).collect(Collectors.toList());
    }
}
