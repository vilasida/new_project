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
        WebDriver Chromedriver = new ChromeDriver();

//         go to https://kristinek.github.io/test-sample/index2.html
        Chromedriver.get("https://kristinek.github.io/test-sample/index2.html");
//         get title of page
        System.out.println(Chromedriver.getTitle());
//        goto https://google.com
        Chromedriver.get("https://google.com");
//        get URL of current page
        System.out.println(Chromedriver.getCurrentUrl());
//        sleep for 10 seconds
        //Thread.sleep(10000);
//         close browser
        Chromedriver.close();
    }
}
