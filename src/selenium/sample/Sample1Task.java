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
        WebDriver chDriver = new ChromeDriver();

//         go to https://kristinek.github.io/test-sample/index2.html
        chDriver.get("https://kristinek.github.io/test-sample/index2.html");

//         get title of page
        System.out.println("Title: " + chDriver.getTitle());

//         get URL of current page
        System.out.println("Current URL: " + chDriver.getCurrentUrl());

        //Sleep for 10 seconds
        //Thread.sleep(10000);

//         close browser
        chDriver.close();
    }
}
