package jpa.entitymodels;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Course{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cId",nullable = false)
    private int cId;

    @Column(name = "cName", nullable = false, length = 50)
    private String cName;

    @Column(name = "Instructor", nullable = false, length = 50)
    private String cInstructorName;

    public Course(){}

    public Course(String cName, String cInstructorName){
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }

    public Course(int cId, String cName, String cInstructorName) {
        this.cId = cId;
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }


    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcInstructorName() {
        return cInstructorName;
    }

    public void setcInstructorName(String cInstructorName) {
        this.cInstructorName = cInstructorName;
    }


    @Override
    public String toString() {
        return "Course{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cInstructorName='" + cInstructorName + '\'' +
                '}';
    }
}// end of Course class

