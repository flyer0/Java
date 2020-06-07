package ch.hfict.esta.core.repository;

import ch.hfict.esta.core.domain.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{

    List<Student> findByLastnameLike(String string);


}
