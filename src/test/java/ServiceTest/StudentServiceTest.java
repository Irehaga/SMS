package ServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.persistence.TypedQuery;
import jpa.entitymodels.Student;
import jpa.services.StudentService;
import jpa.util.ConnectionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentServiceTest {

    private StudentService studentService;
    static ConnectionFactory factoryTest;

    @BeforeEach
    void setUp() {

        studentService = new StudentService();
        factoryTest = ConnectionFactory.GET_SESSION.getInstance();
    }

    @Test
    void testValidateStudentTrue() {
        String sEmail = "tamnguyen@bingbing.com";
        String sPassword = "helloworld";
        boolean result = studentService.validateStudent(sEmail, sPassword);
//        TypedQuery<Student> st = factoryTest.getSession().createQuery("from Student ");
//        List<Student> testST = st.getResultList();
////        assertTrue(result, "Validation should pass");
//        for(Student s : testST){
//            System.out.println("Name: " + s.getsName() + "Email: " + s.getsEmail() + "Pass: " + s.getsPass());
//        }


        assertTrue(result);
    }

    @Test
    void testValidateStudentFalse() {
        String sEmail = "failed@email.com";
        String sPassword = "dfsfsd3";

        boolean result = studentService.validateStudent(sEmail, sPassword);
        assertFalse(result, "Validation should fail");
    }
}
