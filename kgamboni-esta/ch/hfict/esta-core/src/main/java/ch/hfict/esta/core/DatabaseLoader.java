package ch.hfict.esta.core;

import ch.hfict.esta.core.domain.EduClass;
import ch.hfict.esta.core.domain.Student;
import ch.hfict.esta.core.repository.EduClassRepository;
import ch.hfict.esta.core.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.GregorianCalendar;

@Profile("dev") //Only run if in development mode (For JUnit Test)
@Component
public class DatabaseLoader implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EduClassRepository eduClassRepository;

    @Override
    public void run(String... strings) throws Exception {
        
        
        this.eduClassRepository.save(new EduClass("Class A"));
        this.eduClassRepository.save(new EduClass("Class B"));
        this.eduClassRepository.save(new EduClass("Class C"));
        
        this.studentRepository.save(new Student("Jakob", "Lanz", new GregorianCalendar(1993, 3, 9).getTime(), 1));
        this.studentRepository.save(new Student("Peter", "Meier", new GregorianCalendar(1986, 6, 29).getTime(),2));
        this.studentRepository.save(new Student("Stefan", "Thommen", new GregorianCalendar(1991, 2, 23).getTime(),3));
        this.studentRepository.save(new Student("Susanne", "Huber", new GregorianCalendar(1989, 8, 2).getTime(),1));
    }
}