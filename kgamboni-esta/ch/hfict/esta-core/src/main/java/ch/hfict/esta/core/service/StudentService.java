package ch.hfict.esta.core.service;

import java.util.List;
import java.util.Optional;

import ch.hfict.esta.core.domain.Student;

public interface StudentService {
    Student save(Student student);

    Optional<Student> findById(Long id);

    List<Student> findAll();
}