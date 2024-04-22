package MailTestUI;

import Base.BaseCore;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import java.util.ArrayList;

public class MailRecoveryCheck extends BaseCore {

    @Step("Проверка восстановления почты")
    public void chekRecovery(String login){
        driver.findElement(By.xpath("//a[@href='https://trk.mail.ru/c/jlsxn4?mt_sub1=mail.ru']")).click();
        ArrayList<String> window = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(window.get(1));
        driver.findElement(By.xpath("//a[@data-test-id='remind']")).click();
        ArrayList<String> window1 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(window1.get(2));
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(login);
        driver.findElement(By.xpath("//button[@data-test-id=\"submit-button\"]")).click();
        Assertions.assertEquals("Восстановление доступа к" +"\n"+ login,
                driver.findElement(By.xpath("//span[@class='b-panel__header__text']")).getText());

    }
}
