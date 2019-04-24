package lk.avalanche.godslayer.dto;

import lk.avalanche.godslayer.entity.Class;
import lk.avalanche.godslayer.entity.Review;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 3:25 PM
 */


public class TutorDTO extends SuperDTO {

    private int tutorId;
    private String lname;
    private String fname;
    private double reviewValue;
    private byte[] image;


    public TutorDTO() {
    }

    public TutorDTO(int tutorId, String lname, String fname, double reviewValue, byte[] image) {
        this.tutorId = tutorId;
        this.lname = lname;
        this.fname = fname;
        this.reviewValue = reviewValue;
        this.image = image;
    }

    @Override
    public String toString() {
        return "TutorDTO{" +
                "tutorId=" + tutorId +
                ", lname='" + lname + '\'' +
                ", fname='" + fname + '\'' +
                ", reviewValue=" + reviewValue +
                ", image=" + Arrays.toString(image) +
                '}';
    }

    public int getTutorId() {
        return tutorId;
    }

    public void setTutorId(int tutorId) {
        this.tutorId = tutorId;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public double getReviewValue() {
        return reviewValue;
    }

    public void setReviewValue(double reviewValue) {
        this.reviewValue = reviewValue;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
