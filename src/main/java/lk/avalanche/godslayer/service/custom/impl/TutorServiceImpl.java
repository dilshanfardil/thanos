package lk.avalanche.godslayer.service.custom.impl;

import lk.avalanche.godslayer.dto.TutorDTO;
import lk.avalanche.godslayer.entity.Tutor;
import lk.avalanche.godslayer.entity.User;
import lk.avalanche.godslayer.entity.UserType;
import lk.avalanche.godslayer.repository.TutorRepository;
import lk.avalanche.godslayer.service.custom.TutorService;
import org.springframework.beans.BeanUtils;
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
public class TutorServiceImpl implements TutorService {

    @Autowired
    TutorRepository tutorRepository;

    @Override
    public List<TutorDTO> findAll() {

        List<Tutor> all = tutorRepository.findAll();

        return tutorRepository.findAll().stream().map(c -> {
            TutorDTO x = new TutorDTO();
            BeanUtils.copyProperties(c, x);
            return x;
        }).collect(Collectors.toList());
    }

    @Override
    public TutorDTO getrById(int id) {
        Tutor tutor = tutorRepository.getOne(id);
        return new TutorDTO(tutor.getTutorId(),tutor.getFname(),tutor.getLname(), tutor.getReviewValue(),tutor.getImage());

    }

    @Override
    public void update(TutorDTO tutorDTO) {
        tutorRepository.save(new Tutor(tutorDTO.getTutorId(), tutorDTO.getLname(),tutorDTO.getFname(), tutorDTO.getReviewValue(), tutorDTO.getImage()));
    }

    @Override
    public void delete(int id) {
        tutorRepository.deleteById(id);
    }

    @Override
    public void insert(TutorDTO tutorDTO) {
        tutorRepository.save(new Tutor(tutorDTO.getLname(),tutorDTO.getFname(), tutorDTO.getReviewValue(), tutorDTO.getImage()));
    }

    public List<TutorDTO> search(String examId, String subjectId, String location, String name) {
        return tutorRepository.fetchTutorAccordingToSearch(examId,subjectId,location,name).stream().map(c -> {
            TutorDTO x = new TutorDTO();
            BeanUtils.copyProperties(c, x);
            return x;
        }).collect(Collectors.toList());
    }
}
