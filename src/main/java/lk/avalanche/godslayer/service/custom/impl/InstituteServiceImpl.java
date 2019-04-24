package lk.avalanche.godslayer.service.custom.impl;

import lk.avalanche.godslayer.dto.InstitueDTO;
import lk.avalanche.godslayer.entity.Institute;
import lk.avalanche.godslayer.repository.InstituteRepository;
import lk.avalanche.godslayer.service.custom.InstitueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/11/2019
 * Time: 1:23 AM}
 */

@Service
public class InstituteServiceImpl implements InstitueService {

    @Autowired
    InstituteRepository instituteRepository;

    @Override
    public List<InstitueDTO> findAll() {
        return instituteRepository.findAll().stream().map(c -> {
            return new InstitueDTO(c.getInstituteId(),c.getName(), c.getPlace());
        }).collect(Collectors.toList());
    }

    @Override
    public InstitueDTO getrById(int id) {
        Institute one = instituteRepository.getOne(id);
        return new InstitueDTO(one.getInstituteId(),one.getName(),one.getPlace());
    }

    @Override
    public void update(InstitueDTO institueDTO) {
        instituteRepository.save(new Institute(institueDTO.getName(), institueDTO.getPlace()));
    }

    @Override
    public void delete(int id) {
        instituteRepository.deleteById(id);
    }

    @Override
    public void insert(InstitueDTO institueDTO) {
        instituteRepository.save(new Institute(institueDTO.getName(), institueDTO.getPlace()));
    }

    @Override
    public List<InstitueDTO> fetchInstitutes(String examId, String subjectId, String name) {
        return instituteRepository.fetchInstitutes(examId,subjectId,name).stream().map(c -> new InstitueDTO(c.getName(), c.getPlace())).collect(Collectors.toList());
    }
}
