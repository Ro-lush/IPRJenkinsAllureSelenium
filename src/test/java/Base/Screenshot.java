package Base;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Date;

public class Screenshot extends BaseCore implements TestWatcher {
    Date currentDate = new Date();
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.getLifecycle().addAttachment("screenshot"+" "+ currentDate,"image/png"
                ,"png",((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
        /*driver.close();
        driver.quit();*/

    }
}
