package jpa.mainrunner;

import jpa.entitymodels.Course;
import jpa.services.CourseService;
import jpa.services.StudentService;
import jpa.util.ConnectionFactory;
import jpa.util.CreateTable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SMSRunner {
    private final static StudentService studentService = new StudentService();
    private final static  CourseService courseService = new CourseService();
    private final static ConnectionFactory factory = ConnectionFactory.GET_SESSION;
    public static void main(String[] args) {
        CreateTable table = new CreateTable();
        table.createStudentAndCourseTableAndData();
        System.out.println("**********************************************************************************************************************");
        System.out.println("Please Use: tamnguyen@bingbing.com and password: helloworld to test for this project if you dont want to make new one.");
        System.out.println("**********************************************************************************************************************");
        running();
    }

    private static void running(){
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        String student_Email = "";
        int input;

        do {
            System.out.println("Are you a(n): ");
            System.out.println("1.   Student");
            System.out.println("2.   Quit");
            System.out.println("Please enter 1 or 2.");
            input = scanner.nextInt();
            System.out.println(input);
            if (input == 1) {
                if (!loggedIn) {
                    System.out.println("Enter Your Email: ");
                    student_Email = scanner.next();
                    System.out.println("Enter Your Password: ");
                    String password = scanner.next();
                    if (studentService.validateStudent(student_Email, password)) {
                        loggedIn = true;
                        System.out.println("Your Classes: ");
                        displayRegisterCourse(student_Email);
                        int input_2;
                        do {
                            System.out.println(("1.   Register to Class"));
                            System.out.println("2.    Logout");
                            input_2 = scanner.nextInt();
                            System.out.println(input_2);
                            if (input_2 == 1) {
                                System.out.println("All Course: ");
                                displayAllCourses();
                                System.out.println("Which course do you want to register?");
                                System.out.println("Please enter the Course's ID");
                                int course_input = scanner.nextInt();
                                studentService.registerStudentToCourse(student_Email, course_input);
                                System.out.println("Your classes: ");
                                displayRegisterCourse(student_Email);
                            } else if (input_2 != 2) {

                                System.out.println("Invalid option. Please try again");

                            }
                        } while (input_2 != 2);
                        System.out.println("************************");
                        System.out.println("You have been signed out");
                        System.out.println("************************");
                    } else {
                                System.out.println("Invalid email or password. Please try again.");
                        }
                }
            }
        }while(input != 2);
        System.out.println("You have been signed out");
        factory.closeSession();
    }// end of running method
    public static void displayCourses(List<Course> courseList){
        System.out.printf("%-2s %-15s %-15s%n", "ID", " Course Name", " Instructor Name");
        for(Course c : courseList){
            System.out.printf("%-2d %-15s %-25s%n " , c.getcId() ,c.getcName() , c.getcInstructorName());
        }
    }
    public static void displayRegisterCourse(String sEmail){
        List<Course> student_course = studentService.getStudentCourses(sEmail);
        displayCourses(student_course);
    }

    public static void displayAllCourses (){
        List<Course> allCourse = courseService.getAllCourses();
        displayCourses(allCourse);
    }
}// end of SMSrunner
