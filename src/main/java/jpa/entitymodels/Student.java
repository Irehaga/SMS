package jpa.entitymodels;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@NamedQueries({
   @NamedQuery(name = "getAllStudent", query = "from Student "),
   @NamedQuery(name = "getStudentByEmail", query = "from Student s where s.sEmail = :email"),
  // @NamedQuery(name = "getStudentCourses", query = "select  c from Course c JOIN  c.students  s  where s.sEmail = :email"),
   @NamedQuery(name = "getAllCourses", query = "from Course "),
   @NamedQuery(name = "validateStudent", query = "from Student s where s.sEmail = :email and s.sPass = :pass"),
   @NamedQuery(name = "getStudentPass", query = "select s.sPass from Student s where s.sEmail = :email")
})
@Entity
@Table
public class Student {

    @Id
    @Column(name = "email", unique = true, nullable = false, length = 50)
    private String sEmail;


    @Column(name = "sName", nullable = false, length = 50)
    private String sName;
    @Column(name = "password", nullable = false, length = 50)
    private String sPass;

    @ManyToMany(targetEntity = Course.class, fetch = FetchType.LAZY)
    private List<Course> sCourses;
    public Student(){}


    public Student(String sEmail, String sName, String sPass){
        this.sEmail = sEmail;
        this.sName = sName;
        this.sPass = sPass;

    }

    public Student(String sEmail, String sName, String sPass, List<Course> sCourses){
        this.sName = sName;
        this.sEmail = sEmail;
        this.sPass = sPass;
        this.sCourses = sCourses;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPass() {
        return sPass;
    }

    public void setsPass(String sPass) {
        this.sPass = sPass;
    }

    public List<Course> getsCourses() {
        return sCourses;
    }

    public void setsCourses(List<Course> sCourses) {
        this.sCourses = sCourses;
    }



    @Override
    public String toString() {
        return "Student{" +
                "sEmail='" + sEmail + '\'' +
                ", sName='" + sName + '\'' +
                ", sPass='" + sPass + '\'' +
                ", sCourses=" + sCourses +
                '}';
    }
}// end of Student class
