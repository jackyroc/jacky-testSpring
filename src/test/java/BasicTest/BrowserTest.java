package BasicTest;

import org.junit.jupiter.api.Test;

/**
 * @author JackyRoc
 * @date 2020/10/12 17:22
 */
public class BrowserTest extends BaseTest{

    @Test
    public void browserTest(){
        driver.get("https://baidu.com");
    }
}
