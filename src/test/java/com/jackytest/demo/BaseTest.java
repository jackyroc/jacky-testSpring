package com.jackytest.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 多浏览器支持
 * @author JackyRoc
 * @date 2020/10/12 17:22
 */
public class BaseTest {
    public static WebDriver driver;

    @BeforeAll
    public static void init(){
//        String browserName = "Chrome";
        String browserName = System.getenv("browser");

        if("Chrome".equals(browserName)){
            System.setProperty("webdriver.chrome.driver","D:/WorkSpace/WebDriver/chromedriver.exe");
            driver = new ChromeDriver();
        }else if("FireFox".equals(browserName)){
            System.out.println("browserName:"+browserName);
        }
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
