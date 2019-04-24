package lk.avalanche.godslayer.service.custom;

import lk.avalanche.godslayer.dto.UserDTO;
import lk.avalanche.godslayer.service.SuperService;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 11:10 PM}
 */


public interface UserService extends SuperService<UserDTO> {

    UserDTO getTutorByEmail(String email);

}
