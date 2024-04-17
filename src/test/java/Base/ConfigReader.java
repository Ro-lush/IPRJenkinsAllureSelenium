package Base;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigReader {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.load("config.conf");
    }

    String CHROME_DRIVER_WIN = config.getString("chromeDriverWin64");
    String DRIVER_NAME = config.getString("driverName");
    String URL = config.getString("url");
    String CHROME_DRIVER_MAC = config.getString("chromeDriverMacArm");
    String URL_CREATE_MAIL = config.getString("urlCreateMail");
}
