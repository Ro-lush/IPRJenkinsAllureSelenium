package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class SeleniumPage {
    protected static WebDriver webDriver;
    protected static WebDriverWait webDriverWait;

    public static void setDriver(WebDriver selDriver, WebDriverWait selWebDriverWait) {
        webDriver = selDriver;
        webDriverWait = selWebDriverWait;
    }


}
