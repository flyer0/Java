package ch.hfict.esta.core.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import ch.hfict.esta.core.domain.EduClass;

@Transactional
@SpringBootTest
@ActiveProfiles(value = "test")
@ExtendWith(SpringExtension.class)
public class EduClassRepositoryTest {
    @Autowired
    EduClassRepository eduClassRepository;

    @Test
    public void testSave() {
        EduClass educlass = new EduClass();
        educlass.setName("Class B");
        assertNull(educlass.getId(), "empty pk");
        educlass = eduClassRepository.save(educlass);
        assertNotNull(educlass.getId(), "generated pk");
    }
    
    @Test
    @Sql("/test-educlass-data.sql")
    public void findByName() {
        List<EduClass> educlass = eduClassRepository.findByName("Class A");
        int expected = 1;
        int actual = educlass.size();
        assertEquals(expected, actual, "find EduClass by name!");
    }

}
