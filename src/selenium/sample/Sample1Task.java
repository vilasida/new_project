package selenium.sample;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample1Task {
    static String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
//         TODO:
//         define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        WebDriver ChromeDriver = new ChromeDriver();

//         go to https://kristinek.github.io/test-sample/index2.html
        ChromeDriver.get("https://kristinek.github.io/test-sample/index2.html");

//         get title of page
        System.out.println(ChromeDriver.getTitle());

//         get URL of current page
        System.out.println(ChromeDriver.getCurrentUrl());

//         close browser
        ChromeDriver.close();
    }
}
