package lk.avalanche.godslayer.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 4/8/2019
 * Time: 7:49 PM}
 */

@Entity
@Table(name = "tutor")
public class Tutor {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "tutor_id")
    private int tutorId;

    @Column(name = "lname")
    private String lname;

    @Column(name = "fname")
    private String fname;

    @Column(name = "review_value")
    private double reviewValue;

    @Column(name = "image")
    private byte[] image;

    public Tutor() {
    }

    public Tutor(String lname, String fname, double reviewValue, byte[] image) {
        this.lname = lname;
        this.fname = fname;
        this.reviewValue = reviewValue;
        this.image = image;
    }

    public Tutor(int tutorId, String lname, String fname, double reviewValue, byte[] image) {
        this.tutorId = tutorId;
        this.lname = lname;
        this.fname = fname;
        this.reviewValue = reviewValue;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Tutor{" +
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
