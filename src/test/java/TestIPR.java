import Base.BaseCore;
import Base.ConfigReader;
import Base.Screenshot;
import MailTestUI.CreateMail;
import MailTestUI.MailAuthorization;
import MailTestUI.MailRecoveryCheck;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(Screenshot.class)
public class TestIPR extends BaseCore {

    @Test
    @Description("Проверка адреса сайта")
    @Owner("Иванов Иван Иванович iii@mail.ru")
    public void mailHomePage() {
        setURL(ConfigReader.URL);
        Assertions.assertEquals(ConfigReader.URL, driver.getCurrentUrl());
        closeDriver();
    }

    @Test
    @Description("Проверка кнопки Войти")
    @Owner("Иванов Иван Иванович iii@mail.ru")
    public void buttonEntry() {
        MailAuthorization mailAuthorization = new MailAuthorization();
        setURL(ConfigReader.URL);
        mailAuthorization.pressLoginButton();
        mailAuthorization.elementVisibilityCheck();
        closeDriver();
    }

    @Test
    @Description("Проверка кнопки Создать почту")
    @Owner("Иванов Иван Иванович iii@mail.ru")
    public void buttonCreateMail() {
        CreateMail createMail = new CreateMail();
        setURL(ConfigReader.URL);
        createMail.checkButtonCreateMail();
        createMail.elementVisibility();
        closeDriver();
    }

    @Test
    @Description("Проверка кнопки Восстановить почту")
    @Owner("Иванов Иван Иванович iii@mail.ru")
    public void mailRecovery() {
        MailRecoveryCheck mailRecoveryCheck = new MailRecoveryCheck();
        setURL(ConfigReader.URL);
        mailRecoveryCheck.checkRecovery("pupkin@mail.ru");
        closeDriver();
    }
}
