package MailTestUI;

import Base.BaseCore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MailRecoveryCheck extends BaseCore {

    public void chekRecovery(String login){
        driver.findElement(By.xpath("//a[@href='https://trk.mail.ru/c/jlsxn4?mt_sub1=mail.ru']")).click();
        ArrayList<String> window = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(window.get(1));
        driver.findElement(By.xpath("//a[@data-test-id='remind']")).click();
        ArrayList<String> window1 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(window1.get(2));
    }
}
