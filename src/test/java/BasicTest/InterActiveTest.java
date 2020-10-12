package BasicTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * @author JackyRoc
 * @date 2020/10/11 20:19
 */
public class InterActiveTest {
    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    //鼠标点击
    @Test
    public void clickTest() throws InterruptedException {
        try {
            driver.get("http://sahitest.com/demo/clicks.htm");
            Actions actions = new Actions(driver);
            //鼠标单击
            actions.click(driver.findElement(By.xpath("//input[@value='click me']")));
            //鼠标双击
            actions.doubleClick(driver.findElement(By.xpath("//input[@value='dbl click me']")));
            //鼠标右击
            actions.contextClick(driver.findElement(By.xpath("//input[@value='right click me']")));
            //actions提交
            actions.perform();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //拖拽
    @Test
    public void drag(){
        try {
            driver.get("http://sahitest.com/demo/dragDropMooTools.htm");
            Actions actions = new Actions(driver);
            actions.dragAndDrop(driver.findElement(By.id("dragger")), driver.findElement(By.xpath("//div[@id='dragger']/../div[last()]"))).perform();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //组合键操作
    @Test
    public void sendKeys(){
        try {
            driver.get("http://sahitest.com/demo/label.htm");
            Actions actions = new Actions(driver);

            WebElement label01 = driver.findElements(By.xpath("//input[@type='textbox']")).get(0);
            WebElement label02 = driver.findElements(By.xpath("//input[@type='textbox']")).get(1);

            label01.sendKeys("test");
            label01.sendKeys(Keys.CONTROL+"a");
            label01.sendKeys(Keys.CONTROL+"c");
            label02.sendKeys(Keys.CONTROL+"v");

//            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
//            actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
//            actions.keyDown(driver.findElements(By.xpath("//input[@type='textbox']")).get(1), Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //页面滚动
    @Test
    public void scrollWeb(){
        try {
            driver.get("https://www.baidu.com/");
            driver.findElement(By.id("kw")).sendKeys("apple");
            Thread.sleep(1000);
            driver.findElement(By.id("su")).click();

//            TouchActions actions = new TouchActions(driver);
//            actions.click(driver.findElement(By.id("su")));

            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(3000);

            driver.findElement(By.xpath("//a[@class='n']")).click();
            Thread.sleep(1000);
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
