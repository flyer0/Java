package ch.hfict.esta.cucumber.steps;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;

import ch.hfict.esta.core.domain.Student;
import ch.hfict.esta.core.repository.StudentRepository;
import ch.hfict.esta.page.StudentsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StudentManagement{
  Logger logger = LoggerFactory.getLogger(StudentManagement.class);
  @Autowired
  StudentRepository studentRepository;

  @LocalServerPort
  private int port;
  
  StudentsPage page;

  @Before
  public void clean() {
    /*studentRepository.deleteAll();*/
  }
  
  @Given("the list of students")
  public void initial_list_of_students(DataTable dt) throws ParseException  {
    List<List<String>> list = dt.asLists(String.class);
    for(int i=0; i<list.size(); i++) {
      /*this.studentRepository.save(new Student(
          list.get(i).get(0),
          list.get(i).get(1),
          new SimpleDateFormat("yyyy-MM-dd").parse(list.get(i).get(2)))); */
    }  
    boolean enableJavascript = true;
    WebDriver driver = new HtmlUnitDriver(enableJavascript);
    String baseUrl = "http://localhost:"+port;
    page = new StudentsPage(driver, baseUrl);
    page.open();
  }

  @When("the student {string} is selected")
  public void the_student_is_selected(String fullname) {
    String [] name = fullname.split(" ");
    String firstname = name[0];
    String lastname = name[1];
    int selectedRow = 0;
    for(List<String> row: page.getTableContent() ) {
      if( row.get(0).equals(firstname) && row.get(1).equals(lastname)) {
        break;
      }
      selectedRow++;
    }
    logger.info("click edit {}", selectedRow);
    page.clickEdit(selectedRow);
    page.waitUntilTextFieldContains("firstname", firstname);
  }
  
  @Then("the form displays")
  public void the_form_displays(DataTable expected) {
    List<String> actual = page.getFormContent();
    assertEquals("Student form", expected.asLists().get(0), actual);
  }

  @When("the students lastname is modified to {string}")
  public void the_students_lastname_is_modified(String name) {
    page.enterText("lastname", name);
  }

  @When("the save button is pressed")
  public void the_save_button_is_pressed() {
    page.clickSubmit();
  }

  @Then("the table displays")
  public void the_table_displays(DataTable expected) throws Throwable {
    List<List<String>> actual = page.getTableContent();
    expected.diff(DataTable.create(actual));    
  }

}

