package lk.avalanche.godslayer.service.custom.impl;

import lk.avalanche.godslayer.dto.UserDTO;
import lk.avalanche.godslayer.dto.UserTypeDTO;
import lk.avalanche.godslayer.entity.User;
import lk.avalanche.godslayer.entity.UserType;
import lk.avalanche.godslayer.repository.UserRepository;
import lk.avalanche.godslayer.repository.UserTypeRepository;
import lk.avalanche.godslayer.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/11/2019
 * Time: 1:26 AM}
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserTypeRepository userTypeRepository;

    @Override
    public List<UserDTO> findAll() {

        List<User> allUsers = userRepository.findAll();
        List<UserDTO> allUserDTOs = new ArrayList<>();

        for (int i = 0; i < allUsers.size(); i++) {
            User c = allUsers.get(i);

            UserType userType = userTypeRepository.getOne(c.getUserTypeId());

            allUserDTOs.add(new UserDTO(c.getUserId(), new UserTypeDTO(userType.getUserTypeId(),userType.getName()), c.getName(), c.getEmail(), c.getPhoneNo()));

        }

        return allUserDTOs;
    }

    @Override
    public UserDTO getrById(int id) {
        User user = userRepository.getOne(id);
        UserType userType = userTypeRepository.getOne(user.getUserTypeId());
        return new UserDTO(user.getUserId(), new UserTypeDTO(userType.getUserTypeId(), userType.getName()), user.getName(), user.getEmail(), user.getPhoneNo());
    }

    @Override
    public void update(UserDTO userDTO) {
        userRepository.save(new User(userDTO.getUserId(), userDTO.getUserType().getUserTypeId(), userDTO.getName(), userDTO.getEmail(), userDTO.getPhoneNo()));

    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);

    }

    @Override
    public void insert(UserDTO userDTO) {
        System.out.println(userDTO);
        User user = new User(userDTO.getUserType().getUserTypeId(), userDTO.getName(), userDTO.getEmail(), userDTO.getPhoneNo());
        userRepository.save(user);

    }

    public UserTypeDTO entityToDto(UserType userType) {
        return new UserTypeDTO(userType.getUserTypeId(), userType.getName());
    }

    @Override
    public UserDTO getTutorByEmail(String email) {
        return null;
    }

}
