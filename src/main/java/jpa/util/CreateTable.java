package jpa.util;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.List;

public class CreateTable {

    ConnectionFactory factory;
    List<Course> sCourse = new ArrayList<>();


    public void createStudentAndCourseTableAndData(){

        try{
            factory =  ConnectionFactory.GET_SESSION.getInstance();
            Student student_1 = new Student("hluckham0@google.ru", "Hazel Luckham", "X1uZcoIh0dj", sCourse);
            Student student_2 = new Student("sbowden1@yellowbook.com","Sonnnie Bowden","SJc4aWSU", sCourse);
            Student student_3 = new Student("qllorens2@howstuffworks.com","Quillan Llorens","W6rJuxd", sCourse);
            Student student_4 = new Student("cstartin3@flickr.com","Clem Startin","XYHzJ1S", sCourse);
            Student student_5 = new Student("tattwool4@biglobe.ne.jp","Thornie Attwool","Hjt0SoVmuBz",  sCourse);
            Student student_6 = new Student("hguerre5@deviantart.com","Harcourt Guerre","OzcxzD1PGs",  sCourse);
            Student student_7 = new Student("htaffley6@columbia.edu","Holmes Taffley","xowtOQ",  sCourse);
            Student student_8 = new Student("aiannitti7@is.gd","Alexandra Iannitti","TWP4hf5j",  sCourse);
            Student student_9 = new Student("ljiroudek8@sitemeter.com","Laryssa Jiroudek","bXRoLUP",  sCourse);
            Student student_10 = new Student("cjaulme9@bing.com","Cahra Jaulme","FnVklVgC6r6" , sCourse);
            Student student_11 = new Student("tamnguyen@bingbing.com","Tam Nguyen","helloworld" , sCourse);

            factory.doPersist(student_1);
            factory.doPersist(student_2);
            factory.doPersist(student_3);
            factory.doPersist(student_4);
            factory.doPersist(student_5);
            factory.doPersist(student_6);
            factory.doPersist(student_7);
            factory.doPersist(student_8);
            factory.doPersist(student_9);
            factory.doPersist(student_10);
            factory.doPersist(student_11);

            Course course_1 = new Course("English","Anderea Scamaden");
            Course course_2 = new Course("Mathematics","Eustace Niemetz");
            Course course_3 = new Course("Anatomy","Reynolds Pastor");
            Course course_4 = new Course("Organic Chemistry","Odessa Belcher");
            Course course_5 = new Course("Physics","Dani Swallow");
            Course course_6 = new Course("Digital Logic","Glenden Reilingen");
            Course course_7 = new Course("Object Oriented Programming","Giselle Ardy");
            Course course_8 = new Course("Data Structures","Carolan Stoller");
            Course course_9 = new Course("Politics","Carmita De Maine");
            Course course_10= new Course("Art","Kingsly Doxsey");

            factory.doPersist(course_1);
            factory.doPersist(course_2);
            factory.doPersist(course_3);
            factory.doPersist(course_4);
            factory.doPersist(course_5);
            factory.doPersist(course_6);
            factory.doPersist(course_7);
            factory.doPersist(course_8);
            factory.doPersist(course_9);
            factory.doPersist(course_10);
            factory.doCommit();

        }catch (HibernateException e){
            throw new HibernateException(e);
        }
    }

//    public void createCourseTableAndData(){
//        factory = ConnectionFactory.GET_SESSION.getInstance();
//        Course course_1 = new Course(1,"English","Anderea Scamaden");
//        Course course_2 = new Course(2,"Mathematics","Eustace Niemetz");
//        Course course_3 = new Course(3,"Anatomy","Reynolds Pastor");
//        Course course_4 = new Course(4,"Organic Chemistry","Odessa Belcher");
//        Course course_5 = new Course(5,"Physics","Dani Swallow");
//        Course course_6 = new Course(6,"Digital Logic","Glenden Reilingen");
//        Course course_7 = new Course(7,"Object Oriented Programming","Giselle Ardy");
//        Course course_8 = new Course(8,"Data Structures","Carolan Stoller");
//        Course course_9 = new Course(9,"Politics","Carmita De Maine");
//        Course course_10= new Course(10,"Art","Kingsly Doxsey");
//
//        factory.doPersist(course_1);
//        factory.doPersist(course_2);
//        factory.doPersist(course_3);
//        factory.doPersist(course_4);
//        factory.doPersist(course_5);
//        factory.doPersist(course_6);
//        factory.doPersist(course_7);
//        factory.doPersist(course_8);
//        factory.doPersist(course_9);
//        factory.doPersist(course_10);
//
//        factory.closeSession();
//
//    }

}
