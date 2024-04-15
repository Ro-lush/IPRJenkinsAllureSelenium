package MailTestUI;

import Base.BaseCore;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class MailAuthorization extends BaseCore {

@Step("Нажать на кнопку Войти")
public void pressLoginButton(){
   driver.findElement(By.xpath("//button[contains(text(),'Войти')]")).click();
  WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@src,'https://account.mail.ru/login/')]"));
  Assertions.assertEquals("Имя аккаунта",driver.switchTo().frame(iframe).findElement(By.xpath("//input[@name=\"username\"]")).getAccessibleName());

}

}
