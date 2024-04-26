package MailTestUI;

import Base.SeleniumPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MailAuthorization extends SeleniumPage {
    public MailAuthorization() {

        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//iframe[contains(@src,'https://account.mail.ru/login/')]")
    @CacheLookup
    private WebElement iframe;
    @FindBy(xpath = "//input[@name='username']")
    @CacheLookup
    private WebElement loginField;

    public WebElement element(String xpath) {

        return webDriver.findElement(By.xpath(xpath));
    }

    @Step("Нажать на кнопку Войти")
    public void pressLoginButton() {
        webDriver.findElement(By.xpath("//button[contains(text(),'Войти')]")).click();
        webDriver.switchTo().frame(iframe);
        assertEquals("Имя аккаунта", loginField.getAccessibleName());

    }

    @Step("Проверка видимости элементов")
    public void elementVisibilityCheck() {
        assertAll("Проверка видимости элементов в фрайме Войти",
                () -> assertTrue(element("//div[@data-provider='yandex']")
                        .isDisplayed(), "Яндекс отсутсвует"),
                () -> assertTrue(element("//div[@data-provider='other']")
                        .isDisplayed(), "Другой отсутствует"),
                () -> assertTrue(loginField.isDisplayed(), "Поле ввода логина отсутствует")
        );
    }
}
