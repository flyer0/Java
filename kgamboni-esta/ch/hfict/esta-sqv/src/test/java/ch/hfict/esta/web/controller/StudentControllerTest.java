package ch.hfict.esta.web.controller;

import ch.hfict.esta.core.domain.Student;
import ch.hfict.esta.core.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StudentController.class)
@ActiveProfiles(value = "test")
class StudentControllerTest {
    @Autowired
    private MockMvc mvc; // MockMvc von Spring

    @MockBean
    StudentService studentService;

    @Test
    public void getStudents() throws Exception {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student());
        given(studentService.findAll()).willReturn(students);
        
        MvcResult result = mvc.perform(get("/students")).andExpect(status().isOk())
                .andExpect(view().name("jquery/students/view")).andExpect(model().attribute("students", students))
                .andReturn();

        @SuppressWarnings("unchecked")
        List<Student> actual = (List<Student>) result.getModelAndView().getModel().get("students");
        assertEquals(students, actual, "students in page");
        Mockito.verify(studentService).findAll();
    }
}
