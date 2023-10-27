package jpa.services;

import com.sun.source.tree.TryTree;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.util.ConnectionFactory;
import org.hibernate.Session;

import java.lang.reflect.Type;
import java.util.List;

public class StudentService implements StudentDAO {


    ConnectionFactory factory = ConnectionFactory.GET_SESSION.getInstance();

    @Override
    public List<Student> getAllStudent() {

        try{
            TypedQuery<Student> typedQuery = factory.getSession().getNamedQuery("getAllStudent");
           return typedQuery.getResultList();
        }catch (NoResultException e){
            throw new NoResultException("No student found");
        }
    }
    @Override
    public Student getStudentByEmail(String sEmail) {
       try{
           TypedQuery<Student> typedQuery = factory.getSession().getNamedQuery("getStudentByEmail");
           typedQuery.setParameter("email", sEmail);
//            factory.closeSession();
            return typedQuery.getSingleResult();
       }catch (NoResultException e){
                throw new NoResultException("No Student Found");
//       }finally {
//           if (factory.getSession() != null && factory.getSession().isOpen()){
//               factory.closeSession();
//           }
       }
    }

    @Override
    public void registerStudentToCourse(String sEmail, int cId) {
        try{
            TypedQuery<String> typedQuery = factory.getSession().getNamedQuery("getStudentPass");
            typedQuery.setParameter("email", sEmail);
            String student_pass = typedQuery.getSingleResult();

            if(validateStudent(sEmail, student_pass)){

                Student student = factory.getSession().find(Student.class, sEmail);
                Course  course  = factory.getSession().find(Course.class, cId);

                if(student != null && course != null){
                    if(!student.getsCourses().contains(course)){
                        student.getsCourses().add(course);
                        factory.getSession().merge(student);
                    }
                }

            }else {
                throw new NoResultException("Invalid student");
            }

            Session session = factory.getSession();
            if(!session.getTransaction().isActive()){
                factory.getSession().beginTransaction();
            }
            factory.doCommit();
        }catch(NoResultException e){

            throw new NoResultException("No pass found");

//        }finally {
//            if (factory.getSession() != null && factory.getSession().isOpen()){
//                factory.closeSession();
//            }
        }

    }

    @Override
    public List<Course> getStudentCourses(String sEmail) {

        TypedQuery<Student> typedQuery = factory.getSession().getNamedQuery("getStudentByEmail");
        typedQuery.setParameter("email", sEmail);
        List<Course> courses = typedQuery.getSingleResult().getsCourses();
        if(courses.isEmpty()){
            System.out.println("You are not registered for any courses.");
        }
        return courses;
    }

//    @Override
//    public boolean validateStudent(String sEmail, String sPassword) {
//
//        try {
//            TypedQuery<Student> typedQuery = factory.getSession().getNamedQuery("validateStudent");
//            typedQuery.setParameter("email", sEmail);
//            typedQuery.setParameter("pass", sPassword);
//            Student student = typedQuery.getSingleResult();
//            return true;
//        }catch (NoResultException e){
//            return false;
//
//        }
//    }
    @Override
    public boolean validateStudent(String sEmail, String sPassword) {
        try {
            TypedQuery<Student> typedQuery = factory.getSession().createQuery(
                    "SELECT s FROM Student s WHERE s.sEmail = :email AND s.sPass = :pass", Student.class);
            typedQuery.setParameter("email", sEmail);
            typedQuery.setParameter("pass", sPassword);
            Student student = typedQuery.getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

}
