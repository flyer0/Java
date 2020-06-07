package ch.hfict.esta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebResultsPage {

    WebDriver browserDriver;

    String resultCountLocator = "//span[@class='items_showing_count']";
    String expectedResultsPageTitle = "";
    String expectedResultsPageUrl = "http://localhost:8080/students";

    public WebResultsPage(WebDriver driver) {
        browserDriver = driver;
    }

    public boolean isOpen() {
        boolean isTitleCorrect = browserDriver.getTitle().equalsIgnoreCase(expectedResultsPageTitle);
        boolean isUrlCorrect = browserDriver.getCurrentUrl().equalsIgnoreCase(expectedResultsPageUrl);

        return isTitleCorrect && isUrlCorrect;
    }

    public int resultCount() {
        WebElement resultCountLabel = browserDriver.findElement(By.xpath(resultCountLocator));

        String resultCountText = resultCountLabel.getText();
        return extractNumberFromResultCountText(resultCountText);
    }

    private int extractNumberFromResultCountText(String resultCountText) {
        int startIndex = resultCountText.indexOf("of") + 3;
        int endIndex = resultCountText.indexOf(" items");
        return Integer.parseInt(resultCountText.substring(startIndex, endIndex));
    }

}
