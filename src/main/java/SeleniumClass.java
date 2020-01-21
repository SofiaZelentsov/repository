import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumClass {

    private final By GOOGLE_SEARCH = By.xpath("//input[@class='gLFyf gsfi']");
    private final By ALL_LINKS = By.xpath("//div[@id='rso']//div[@class='rc']/*[@class='r']/a");

    public String Method() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        driver.findElement(GOOGLE_SEARCH).sendKeys("LexisNexis");
        driver.findElement(GOOGLE_SEARCH).submit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> findElements2 = new ArrayList<>();
        List<WebElement> findElements = driver.findElements(ALL_LINKS);
        for (int i = 0; i < findElements.size(); i++) {
            if (!findElements.get(i).getText().isEmpty())
                findElements2.add(findElements.get(i));
        }
        findElements2.get(2).click();
        String actualTitle = driver.getTitle();
        driver.quit();
        return actualTitle;
    }
}