package lk.avalanche.godslayer.entity;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 6:54 PM}
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;

//    @OneToOne(targetEntity = UserType.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_type_id", referencedColumnName = "user_type_id")
    private int userTypeId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNo;


    public User() {
    }

    public User(int userId, int userTypeId, String name, String email, String phoneNo) {
        this.userId = userId;
        this.userTypeId = userTypeId;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public User(int userTypeId, String name, String email, String phoneNo) {
        this.userTypeId = userTypeId;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userTypeId=" + userTypeId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
