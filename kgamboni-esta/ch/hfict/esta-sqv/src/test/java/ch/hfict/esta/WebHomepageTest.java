package ch.hfict.esta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebHomepageTest {

    WebDriver browserDriver;
    
    String homePageUrl = "http://localhost/students";
    String searchTextBoxId = "tr";
    String editButtonLocator = "//table/tbody/tr[3]/td[4]/a";

    public WebHomepageTest(WebDriver driver1) {
        browserDriver = driver1;
        //browserDriver.get("http://localhost/students");
    }

    public void openPage() {
       this.browserDriver.get("http://localhost:8080/students");
    }

    public void searchForKeyword(String keyword) {
        typeSearchKeyword(keyword);
        executeEdit();
    }

    private void typeSearchKeyword(String keyword) {
        WebElement searchTextBox = browserDriver.findElement(By.tagName(searchTextBoxId));

        searchTextBox.sendKeys(keyword);
        searchTextBox.submit();
    }

    private void executeEdit() {
        WebElement editTextButton = browserDriver.findElement(By.xpath(editButtonLocator));
        editTextButton.click();
    }

}
