package lk.avalanche.godslayer.dto;

import lk.avalanche.godslayer.entity.Class;

import java.util.Set;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 3:20 PM
 */


public class InstitueDTO extends SuperDTO {

    private int instituteId;

    private String name;
    private String place;

    public InstitueDTO() {
    }

    public InstitueDTO(int instituteId, String name, String place) {
        this.instituteId = instituteId;
        this.name = name;
        this.place = place;
    }

    public InstitueDTO(String name, String place) {
        this.name=name;
        this.place=place;
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
