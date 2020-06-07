package ch.hfict.esta.core.repository;

import ch.hfict.esta.core.domain.EduClass;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EduClassRepository extends JpaRepository<EduClass, Long> {
    List<EduClass> findByName(String string);
}
