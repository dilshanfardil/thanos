package lk.avalanche.godslayer.dto;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 3:22 PM
 */


public class UserTypeDTO extends SuperDTO {

    private int userTypeId;
    private String name;

    public UserTypeDTO() {
    }

    public UserTypeDTO(int userTypeId, String name) {
        this.userTypeId = userTypeId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserTypeDTO{" +
                "userTypeId=" + userTypeId +
                ", name='" + name + '\'' +
                '}';
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
