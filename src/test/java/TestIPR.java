import Base.BaseCore;
import Base.ConfigReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestIPR extends BaseCore {

    @Test
   public void MailHomePage(){
        driver.get(ConfigReader.URL);
        Assertions.assertTrue(driver.getCurrentUrl().equals(ConfigReader.URL),
                "Адрес неверный - ожидаем: "+ConfigReader.URL+", получаем: "+ driver.getCurrentUrl());

    }

}
