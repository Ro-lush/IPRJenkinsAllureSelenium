package MailTestUI;


import Base.ConfigReader;
import Base.SeleniumPage;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CreateMail extends SeleniumPage {
    public CreateMail() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//a[contains(@href,'account.mail.ru/signup?from=main')]")
    private WebElement creatMail;
    @FindBy(xpath = "//input[@name='lname']")
    private WebElement loginLName;
    @FindBy(xpath = "//div[@data-test-id='bdate-tooltip']")
    private WebElement date;


    @Step("Проверка кнопки Создать почту")
    public void checkButtonCreateMail() {
        creatMail.click();
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        assertEquals(ConfigReader.URL_CREATE_MAIL, webDriver.getCurrentUrl());
    }

    @Step("Видимость элементов")
    public void elementVisibility() {
        assertAll(
                () -> assertTrue(loginLName.isDisplayed(), "Поле Имя отсутсвует"),
                () -> assertTrue(loginLName.isDisplayed(), "Поле Фамилия отсутвует"),
                () -> assertTrue(date.isDisplayed(), "Поле Дата рождения отсутвует")
        );
    }

}
