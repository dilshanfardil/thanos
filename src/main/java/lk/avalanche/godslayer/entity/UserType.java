package lk.avalanche.godslayer.entity;

import javax.persistence.*;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/18/2019
 * Time: 12:58 PM}
 */


@Entity
@Table(name = "user_type")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_type_id")
    private int userTypeId;

    @Column(name = "name")
    private String name;


    public UserType() {
    }

    public UserType(String name) {
        this.name = name;
    }

    public UserType(int userTypeId, String name) {
        this.userTypeId = userTypeId;
        this.name = name;
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
