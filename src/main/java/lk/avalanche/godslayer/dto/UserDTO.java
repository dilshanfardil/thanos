package lk.avalanche.godslayer.dto;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 3:23 PM
 */


public class UserDTO extends SuperDTO {

    private int userId;

    private UserTypeDTO userType;

    private String name;
    private String email;
    private String phoneNo;


    public UserDTO() {
    }

    public UserDTO(int userId, UserTypeDTO userType, String name, String email, String phoneNo) {
        this.userId = userId;
        this.userType = userType;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserTypeDTO getUserType() {
        return userType;
    }

    public void setUserType(UserTypeDTO userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
