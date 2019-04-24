package lk.avalanche.godslayer.service.custom.impl;

import lk.avalanche.godslayer.dto.UserTypeDTO;
import lk.avalanche.godslayer.entity.UserType;
import lk.avalanche.godslayer.repository.UserTypeRepository;
import lk.avalanche.godslayer.service.custom.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/11/2019
 * Time: 1:26 AM}
 */

@Service
public class UserTypeServiceImpl implements UserTypeService {

    @Autowired
    UserTypeRepository userTypeRepository;

    @Override
    public List<UserTypeDTO> findAll() {
        return userTypeRepository.findAll().stream().map(c -> {
            return new UserTypeDTO(c.getUserTypeId(), c.getName());
        }).collect(Collectors.toList());
    }

    @Override
    public UserTypeDTO getrById(int id) {
        UserType userType = userTypeRepository.getOne(id);
        return new UserTypeDTO(userType.getUserTypeId(),userType.getName());
    }

    @Override
    public void update(UserTypeDTO userTypeDTO) {
        userTypeRepository.save(new UserType(userTypeDTO.getUserTypeId(), userTypeDTO.getName()));
    }

    @Override
    public void delete(int id) {
        userTypeRepository.deleteById(id);
    }

    @Override
    public void insert(UserTypeDTO userTypeDTO) {
        userTypeRepository.save(new UserType(userTypeDTO.getName()));
    }

    public UserTypeDTO entityToDto(UserType userType) {
        return new UserTypeDTO(userType.getUserTypeId(), userType.getName());
    }
}
