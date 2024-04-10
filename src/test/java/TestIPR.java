import Base.BaseCore;
import Base.ConfigReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestIPR extends BaseCore {

    @Test
   public void MailHomePage(){
        driver.get(ConfigReader.URL);
        Assertions.assertEquals(ConfigReader.URL,driver.getCurrentUrl());
    }

}
