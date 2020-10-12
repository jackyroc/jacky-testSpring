package BasicTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author JackyRoc
 * @date 2020/10/12 16:56
 */
public class SwitchTest {
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

    @Test
    public void switchWindow(){
        try {
            driver.get("https://www.baidu.com/");
            driver.manage().window().maximize();
            driver.findElements(By.xpath("//a[@name='tj_login']")).get(1).click();
            //获取页面句柄
            String baiduWin = driver.getWindowHandle();
            driver.findElement(By.xpath("//a[@class='pass-reglink pass-link']")).click();

            for(String win:driver.getWindowHandles()){
                if(!win.equals(baiduWin)){
                    driver.switchTo().window(win);
                }
            }
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
