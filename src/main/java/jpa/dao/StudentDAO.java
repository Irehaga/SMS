package jpa.dao;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import java.util.List;


public interface StudentDAO {


    public List<Student> getAllStudent();
    public Student getStudentByEmail(String sEmail);
    public void registerStudentToCourse(String sEmail, int cId);
    public List<Course> getStudentCourses(String sEmail);
    public boolean validateStudent(String sEmail, String sPassword);

}
