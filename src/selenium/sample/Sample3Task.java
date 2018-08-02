package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class Sample3Task {
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
    public void assertEqualsTask() throws Exception {
//         TODO:
//         check how many element with class "test" there are on page (5)
        int expected = 5;
//         check that value of second button is "This is also a button"
        int actual = driver.findElements(By.className("test")).size();
        assertEquals(expected, actual);
    }

    @Test
    public void assertTrueTask () throws Exception {
//         TODO:
//         check that it is True that value of second button is "this is Also a Button" if you ignore Caps Locks
        String secondButtonValue = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertTrue(secondButtonValue.equalsIgnoreCase("this is Also a Button"));
//         fail with custom error message:
        try {
            assertTrue(false);
        } catch (AssertionError e) {
            System.err.println("Failed with custom message");
            e.printStackTrace();
        }
    }

    @Test
    public void assertFalseTask () throws Exception {
//         TODO:
//        check that it is False that value of second button is "This is a button"
        String secondButtonValue = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertFalse(secondButtonValue.equals("This is a button"));
    }

    @Test
    public void failTask() throws Exception {
//        TODO:
//        check that none of items with class "test" contain number 190

    }
}
