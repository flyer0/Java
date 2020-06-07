package ch.hfict.esta;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.mockito.BDDMockito.given;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import com.gargoylesoftware.htmlunit.html.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;

import ch.hfict.esta.core.domain.Student;
import ch.hfict.esta.core.service.StudentService;
import ch.hfict.esta.web.controller.StudentController;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class WebApplicationIntegrationTest {
    @Autowired
    private WebClient webClient;

    @MockBean
    private StudentService studentService;

    @Test
    public void showStudentTableAndModify() throws FailingHttpStatusCodeException, MalformedURLException, IOException{
        Student jesse = new Student();
        jesse.setFirstname("Jesse");
        jesse.setLastname("Pinkman");
        Student paige = new Student();
        paige.setId(2L);
        paige.setFirstname("Paige");
        paige.setLastname("Jennings");

        given(studentService.findAll())
        .willReturn(
            newArrayList(jesse, paige)
        );
        HtmlPage studentsPage = webClient.getPage("/students");
        HtmlTable table = studentsPage.getHtmlElementById("student-table");

        assertThat(table.getRowCount()).isEqualTo(3);

        List<String> entries = table.getRow(2).getCells().stream()
            .map(cell -> cell.asText())
            .collect(toList());
        assertThat(entries).hasSize(4);
        assertThat(entries).contains(
                paige.getFirstname(), paige.getLastname(), "Edit");

        given(studentService.findById(2L))
                .willReturn(Optional.ofNullable(paige));
        HtmlAnchor a = (HtmlAnchor) table.getRow((2)).getCell(3).getFirstElementChild();
        HtmlPage page2 = a.click();

        final HtmlForm form = page2.getForms().get(0);
        final HtmlTextInput textField = form.getInputByName("firstname");
        assertThat(textField.getText()).isEqualTo(paige.getFirstname());

        textField.setText("firstname");
        // submit
        final HtmlButton button = (HtmlButton)
                form.getElementsByAttribute("button",
                         "type",
                        "submit").get(0);
        final HtmlPage page3 = button.click();
        verify(studentService).save(any(Student.class));
        // TODO: should check for correct student
    }
}
