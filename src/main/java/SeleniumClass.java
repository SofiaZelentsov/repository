import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumClass {

    private final By GOOGLE_SEARCH = By.xpath("//input[@class='gLFyf gsfi']");
    private final By THIRD_LINK = By.xpath("//h3[@class='LC20lb']");
    private List<WebElement> objList;

    public String Method() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        driver.findElement(GOOGLE_SEARCH).sendKeys("LexisNexis");
        driver.findElement(GOOGLE_SEARCH).submit();

        objList = driver.findElements(THIRD_LINK);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", objList.get(2));
        objList.get(2).click();

        String actualTitle = driver.getTitle();
        driver.quit();
        return actualTitle;
    }
}