package lk.avalanche.godslayer.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 10:04 PM}
 */

@Entity
@Table(name = "institute")
public class Institute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "institute_id")
    private int instituteId;

    @Column(name = "name")
    private String name;

    @Column(name = "place")
    private String place;

    public Institute() {
    }

    public Institute(int instituteId, String name, String place) {
        this.instituteId = instituteId;
        this.name = name;
        this.place = place;
    }

    public Institute(String name, String place) {
        this.name = name;
        this.place = place;
    }

    @Override
    public String toString() {
        return "Institute{" +
                "instituteId=" + instituteId +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                '}';
    }

    public int getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(int instituteId) {
        this.instituteId = instituteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
