package MailTestUI;

import Base.BaseCore;
import Base.ConfigReader;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateMail extends BaseCore {
    public CreateMail(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
@FindBy(xpath = "//button[@class='resplash-btn resplash-btn_primary resplash-btn_mailbox-big gcl__fkdf-1jdtl7f']")
private WebElement creatMail;

    @Step("Проверка кнопки Создать почту")
    public void checkButtonCreateMail(){
        creatMail.click();
        assertEquals(ConfigReader.URL_CREATE_MAIL,driver.getCurrentUrl());
    }

}
