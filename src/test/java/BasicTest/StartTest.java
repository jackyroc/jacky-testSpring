package BasicTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author JackyRoc
 * @date 2020/10/10 16:15
 */
public class StartTest {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        // Test name: test
        // Step # | name | target | value
        // 1 | open | /documentation/zh-cn/webdriver/driver_requirements/ |
        driver.get("https://www.baidu.com/");
        // 2 | setWindowSize | 1050x900 |
        driver.manage().window().setSize(new Dimension(1050, 900));
        // 3 | click |
        driver.findElement(By.id("kw")).sendKeys("hello");
        driver.findElement(By.id("su")).click();
        //wait.until使用
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(string(),'百度翻译')]"))).click();
        Thread.sleep(3000);
    }

}
