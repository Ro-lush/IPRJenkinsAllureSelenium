import Base.BaseCore;
import Base.ConfigReader;
import Base.Screenshot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(Screenshot.class)
public class TestIPR extends BaseCore {

    @Test
   public void MailHomePage(){
        driver.get(ConfigReader.URL);
        Assertions.assertEquals(ConfigReader.URL,driver.getCurrentUrl());
    }

}
