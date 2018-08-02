package selenium.sample;

import com.sun.xml.internal.bind.v2.TODO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample6Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get("https://kristinek.github.io/test-sample/examples/loc");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void findElementByXPath() throws Exception {
//         TODO:
////         1-2 ways to write xapth to
//        "Heading 2 text":
        System.out.println(driver.findElement(By.xpath("//*[@id='heading_2']")).getText());
//        "Test Text 1"
        System.out.println(driver.findElement(By.xpath("//*[@class='test']")).getText());
//        "Test Text 2"
        System.out.println(driver.findElement(By.xpath("//*[@class='twoTest']")).getText());
//        "Test Text 3"
        System.out.println(driver.findElement(By.xpath("//*[contains(text(), '3')]")).getText());
//        "Test Text 4"
        System.out.println(driver.findElement(By.xpath("//*[@id='test3']/p[2]")).getText());
//        "Test Text 5"
        System.out.println(driver.findElement(By.xpath("/html/body/div[6]/p[1]")).getText());
//        "This is also a button"
        System.out.println(driver.findElement(By.xpath("//*[@name='randomButton2']")).getAttribute("value"));
    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//         1-2 ways to write css to
//        "Heading 2 text":
        System.out.println(driver.findElement(By.cssSelector("#heading_2")).getText());
//        "Test Text 1"
        System.out.println(driver.findElement(By.cssSelector(".test")).getText());
//        "Test Text 2"
        System.out.println(driver.findElement(By.cssSelector(".twoTest")).getText());
//        "Test Text 3"
        System.out.println(driver.findElement(By.cssSelector("#test3 p:nth-of-type(1)")).getText());
//        "This is also a button"
        System.out.println(driver.findElement(By.cssSelector("input[name='randomButton2']")).getAttribute("value"));
    }
}
