package MailTestUI;

import Base.BaseCore;
import Base.ConfigReader;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CreateMail extends BaseCore {
    public CreateMail(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='footer gcl__fkdf-1pn6uk5 footer_logged-out']")
    private WebElement creatMail;

    @FindBy(xpath = "//input[@name='fname']")
    private WebElement loginName;

    @FindBy(xpath = "//input[@name='lname']")
    private WebElement loginLName;

    @FindBy(xpath = "//div[@data-test-id='bdate-tooltip']")
    private WebElement date;

    @Step("Проверка кнопки Создать почту")
    public void checkButtonCreateMail() {
        creatMail.click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertEquals(ConfigReader.URL_CREATE_MAIL, driver.getCurrentUrl());
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
