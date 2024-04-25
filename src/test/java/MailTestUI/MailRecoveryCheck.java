package MailTestUI;

import Base.SeleniumPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import java.util.ArrayList;

public class MailRecoveryCheck extends SeleniumPage {

    @Step("Проверка восстановления почты")
    public void checkRecovery(String login){
        webDriver.findElement(By.xpath("//a[@href='https://trk.mail.ru/c/jlsxn4?mt_sub1=mail.ru']")).click();
        ArrayList<String> window = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(window.get(1));
        webDriver.findElement(By.xpath("//a[@data-test-id='remind']")).click();
        ArrayList<String> window1 = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(window1.get(2));
        webDriver.findElement(By.xpath("//input[@name='username']")).sendKeys(login);
        webDriver.findElement(By.xpath("//button[@data-test-id=\"submit-button\"]")).click();
        Assertions.assertEquals("Восстановление доступа к" +"\n"+ login,
                webDriver.findElement(By.xpath("//span[@class='b-panel__header__text']")).getText());

    }
}
