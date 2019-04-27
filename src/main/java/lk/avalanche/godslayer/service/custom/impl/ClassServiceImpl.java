package lk.avalanche.godslayer.service.custom.impl;


import lk.avalanche.godslayer.dto.*;
import lk.avalanche.godslayer.entity.*;
import lk.avalanche.godslayer.entity.Class;
import lk.avalanche.godslayer.repository.*;
import lk.avalanche.godslayer.service.custom.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/10/2019
 * Time: 9:29 PM}
 */

@Service
public class ClassServiceImpl  implements ClassService {

    @Autowired
    ClassRepository classRepository;
    @Autowired
    TutorRepository tutorRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    InstituteRepository instituteRepository;
    @Autowired
    ExamRepository examRepository;

    @Override
    public List<ClassDTO> findAll() {

        List<Class> all = classRepository.findAll();

        List<ClassDTO> returnList = new ArrayList<>();

        for (int i = 0; i < all.size(); i++) {

            Class aClass = all.get(i);

            Tutor tutor = tutorRepository.getOne(aClass.getTutorId());
            Subject subject = subjectRepository.getOne(aClass.getSubjectId());
            Exam exam = examRepository.getOne(subject.getExamId());
            Institute institute = instituteRepository.getOne(aClass.getInstituteId());

            TutorDTO tutorDTO = new TutorDTO(tutor.getTutorId(), tutor.getFname(), tutor.getLname(), tutor.getReviewValue(), tutor.getImage());
            SubjectDTO subjectDTO = new SubjectDTO(subject.getSubjectId(), new ExamDTO(exam.getExamId(), exam.getName()),subject.getName());
            InstitueDTO institueDTO = new InstitueDTO(institute.getInstituteId(), institute.getName(), institute.getPlace());

            ClassDTO classDTO = new ClassDTO(aClass.getClassId(), aClass.getDay(), aClass.getFromTime(), aClass.getToTime(),tutorDTO, subjectDTO, institueDTO, aClass.getYear());


            returnList.add(classDTO);

        }

        return returnList;
    }



    private ClassDTO dtoToEntity(Class c) {
        return dtoToEntity(c);
    }

    @Override
    public ClassDTO getrById(int id) {
        Class aClass = classRepository.getOne(id);

        Tutor tutor = tutorRepository.getOne(aClass.getTutorId());
        Subject subject = subjectRepository.getOne(aClass.getSubjectId());
        Exam exam = examRepository.getOne(subject.getExamId());
        Institute institute = instituteRepository.getOne(aClass.getInstituteId());

        TutorDTO tutorDTO = new TutorDTO(tutor.getTutorId(), tutor.getFname(), tutor.getLname(), tutor.getReviewValue(), tutor.getImage());
        SubjectDTO subjectDTO = new SubjectDTO(subject.getSubjectId(), new ExamDTO(exam.getExamId(), exam.getName()),subject.getName());
        InstitueDTO institueDTO = new InstitueDTO(institute.getInstituteId(), institute.getName(), institute.getPlace());

        ClassDTO classDTO = new ClassDTO(aClass.getClassId(), aClass.getDay(), aClass.getFromTime(), aClass.getToTime(),tutorDTO, subjectDTO, institueDTO, aClass.getYear());
        return classDTO;
    }

    @Override
    public void update(ClassDTO dto) {
        classRepository.save(new Class(dto.getClassId(),dto.getTutor().getTutorId(), dto.getInstitute().getInstituteId(), dto.getSubject().getSubjectId(), dto.getDay(), dto.getFromTime(), dto.getToTime(), dto.getYear()));

    }

    @Override
    public void delete(int id) {
        classRepository.deleteById(id);

    }

    @Override
    public void insert(ClassDTO dto) {
        classRepository.save(new Class(dto.getTutor().getTutorId(), dto.getInstitute().getInstituteId(), dto.getSubject().getSubjectId(), dto.getDay(), dto.getFromTime(), dto.getToTime(), dto.getYear()));
    }

    @Override
    public List<ClassDTO> fetchClassAccordingToTutorId(int id) {
        List<Class> all = classRepository.fetchClassAccordingToTutorId(id);

        List<ClassDTO> returnList = new ArrayList<>();

        for (int i = 0; i < all.size(); i++) {

            Class aClass = all.get(i);

            Tutor tutor = tutorRepository.getOne(aClass.getTutorId());
            Subject subject = subjectRepository.getOne(aClass.getSubjectId());
            Exam exam = examRepository.getOne(subject.getExamId());
            Institute institute = instituteRepository.getOne(aClass.getInstituteId());

            TutorDTO tutorDTO = new TutorDTO(tutor.getTutorId(), tutor.getFname(), tutor.getLname(), tutor.getReviewValue(), tutor.getImage());
            SubjectDTO subjectDTO = new SubjectDTO(subject.getSubjectId(), new ExamDTO(exam.getExamId(), exam.getName()),subject.getName());
            InstitueDTO institueDTO = new InstitueDTO(institute.getInstituteId(), institute.getName(), institute.getPlace());

            ClassDTO classDTO = new ClassDTO(aClass.getClassId(), aClass.getDay(), aClass.getFromTime(), aClass.getToTime(),tutorDTO, subjectDTO, institueDTO, aClass.getYear());


            returnList.add(classDTO);

        }

        return returnList;
    }
}




//    private void saveAndUpdateSame(ClassDTO dto) {
//        Class aClass = new Class();

//        TutorDTO tutorDTO = dto.getTutor();
//        ExamDTO examDTO = dto.getSubject().getExam();
//        Tutor tutor = new Tutor(tutorDTO.getLname(), tutorDTO.getFname(), tutorDTO.getReviewValue(), tutorDTO.getImage());
//        Exam exam = new Exam(examDTO.getName());
//
//        SubjectDTO subjectDTO = dto.getSubject();
//        Subject subject = new Subject(exam, subjectDTO.getName());
//
//        InstitueDTO instituteDTO = dto.getInstitute();
//        Institute institute = new Institute(instituteDTO.getName(), instituteDTO.getPlace());
//
//        classRepository.save(new Class(tutor, institute, subject, dto.getDay(), dto.getFromTime(), dto.getToTime()));
//    }

//    private ClassDTO dtoEntityMapping(Class c) {
//        Tutor oneTutor = c.getTutorId();
//        Subject oneSubject = c.getSubjectId();
//        Institute oneInstitute = c.getInstituteId();
//
//        Exam oneExam = examRepository.getOne(oneSubject.getExamId().getExamId());
//
//        TutorDTO tutor = new TutorDTO(oneTutor.getTutorId(), oneTutor.getLname(), oneTutor.getFname(), oneTutor.getReviewValue(), oneTutor.getImage());
//
//        SubjectDTO subject = new SubjectDTO(oneSubject.getSubjectId(), new ExamDTO(oneExam.getExamId(), oneExam.getName()), oneSubject.getName());
//        InstitueDTO institute = new InstitueDTO(oneInstitute.getInstituteId(), oneInstitute.getName(), oneInstitute.getPlace());
//
//
//        return new ClassDTO(c.getClassId(), c.getDay(), c.getFromTime(), c.getToTime(), tutor, subject, institute);
//    return null;
//    }

