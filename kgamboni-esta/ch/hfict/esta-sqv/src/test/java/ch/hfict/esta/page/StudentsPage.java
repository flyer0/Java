package ch.hfict.esta.page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentsPage {
  private final String baseUrl;
  private final String URL = "/students";
  private final WebDriver driver;
  private WebDriverWait wait;
  
  public StudentsPage(WebDriver driver, String baseUrl) {
    this.driver = driver;
    this.baseUrl = baseUrl;
    this.wait = new WebDriverWait(driver, 10);
  }
  
  public void open() {
    driver.get(baseUrl+URL);
    if(!wait.until(ExpectedConditions.urlContains(URL))){
      throw new IllegalStateException(URL + " is not displayed");
    }      
  }
  private WebElement studentTable() {
    return driver.findElement(By.id("student-table"));
  }
  
  public int getNumTableRows() {
    return studentTable().findElements(By.tagName("tr")).size();
  }
  
  public void clickEdit(int i) {
    studentTable().findElements(By.tagName("a")).get(i).click();
  }

  public void waitUntilTextFieldContains(String fieldname, String value) {
    wait.until(ExpectedConditions.attributeToBe(
        By.id(fieldname), "value", value));
  }
  
  public List<String> getFormContent(){
    List<String> content = new ArrayList<>();
    for(String field: new String[]{"firstname", "lastname", "birthdate"}) {
      content.add(driver.findElement(By.id(field)).getAttribute("value"));
    }
    return content;
  }
  
  public void enterText(String field, String value) {
    WebElement textfield = driver.findElement(By.id(field));
    // modify text field
    textfield.clear();
    textfield.sendKeys(value);    
  }

  public void clickSubmit() {
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.navigate().refresh();
  }
  
  public List<List<String>> getTableContent() {
    List<WebElement> rows = studentTable().findElements(By.tagName("tr"));
    List<List<String>> content = new ArrayList<>();
    for(int r=0; r<rows.size(); r++) {
      List<WebElement> columns = rows.get(r).findElements(By.tagName("td"));
      List<String> col = new ArrayList<>();
      for(int c=0; c<columns.size()-1; c++) { // without last column
          col.add(columns.get(c).getText());
      }
      if( col.size()>0) {
        content.add(col);
      }
    }
    return content;
  }

  public void waitUntilTableFieldContains(int row, int col, String value) {
    wait.until(ExpectedConditions.textToBePresentInElementLocated(
        By.xpath("//table/tbody/tr["+row+"]/td["+col+"]"), value));    
  }
}
