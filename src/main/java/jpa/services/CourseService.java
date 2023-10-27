package jpa.services;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;
import jpa.util.ConnectionFactory;

import java.util.ArrayList;
import java.util.List;

public class CourseService implements CourseDAO {

    ConnectionFactory factory = ConnectionFactory.GET_SESSION.getInstance();
    @Override
    public List<Course> getAllCourses() {
        try {
            TypedQuery<Course> typedQuery = factory.getSession().getNamedQuery("getAllCourses");
            return typedQuery.getResultList();
        }catch (NoResultException e){
                throw new NoResultException("No Courses found in the database.");
        }
    }
}
