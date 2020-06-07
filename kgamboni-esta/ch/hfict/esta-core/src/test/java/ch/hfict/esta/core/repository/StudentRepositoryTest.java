package ch.hfict.esta.core.repository;

import ch.hfict.esta.core.domain.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@Transactional
@SpringBootTest
@ActiveProfiles(value = "test")
@ExtendWith(SpringExtension.class)
public class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @Test
    public void testSave() {
        Student stud = new Student();
        stud.setFirstname("firstname");
        stud.setLastname("lastname");
        assertNull(stud.getId(), "empty pk");
        stud = studentRepository.save(stud);
        assertNotNull(stud.getId(), "generated pk");
    }

    @Test
    @Sql("/test-educlass-data.sql")
    @Sql("/test-students-data.sql")
    public void findAll() {
        List<Student> students = studentRepository.findAll();
        int expected = 2;
        int actual = students.size();
        assertEquals(expected, actual, "find all students");
        String [] firstnames = new String [] {"Firstname1","Firstname2"};
        String [] actualFirstnames = new String [students.size()];
        int i=0;
        for(Student s : students) {
            actualFirstnames[i] = s.getFirstname();
            i++;
        }
        assertArrayEquals(firstnames, actualFirstnames,"correct Names in DB.");
    }

    @Test
    @Sql("/test-educlass-data.sql")
    @Sql("/test-students-data.sql")
    public void findByLastname() {
        //findByLastnameLike = Declartive Query (See Spring Data JPA Documentation 5.3.2)
        List<Student> students = studentRepository.findByLastnameLike("%2");
        int expected = 1;
        int actual = students.size();
        assertEquals(expected, actual, "find students by lastname");
    }

    

}