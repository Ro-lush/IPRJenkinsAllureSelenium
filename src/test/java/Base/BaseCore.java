package Base;

import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class BaseCore {
    protected WebDriver driver;
    protected WebDriverWait driverWait;

    /**
     * Метод запускается вначале  тестов
     */
    @BeforeEach
    public void startDriver() {
        // System.setProperty(ConfigReader.DRIVER_NAME, ConfigReader.CHROME_DRIVER_MAC); // пример записи указывает имя дрйвера и путь до драйвера
        // в новой версии selenium скачивает все нужные драйвера сам.
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));//Устанавливает время ожидания завершения загрузки страницы перед выдачей ошибки.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Указывает время, в течение которого драйвер должен ждать при поиске элемента, если он отсутствует сразу.
        SeleniumPage.setDriver(driver, driverWait);
    }

    public  void closeDriver() {
        driver.close();
        driver.quit();
    }

    @Step("Ввод адреса сайта")
    public void setURL(String url) {
        driver.get(url);
    }

}
