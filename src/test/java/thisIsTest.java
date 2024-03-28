import Base.BaseCore;
import Base.ConfigReader;
import org.junit.jupiter.api.Test;

public class thisIsTest extends BaseCore {

    @Test
   public void testGoogleSerch(){
        driver.get(ConfigReader.URL);

    }

}
