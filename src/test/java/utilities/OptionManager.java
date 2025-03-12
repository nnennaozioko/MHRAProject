package utilities;

import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

public class OptionManager {

    public Properties prop;
    public ChromeOptions co;

    public OptionManager(Properties prop){
        this.prop=prop;}

    public ChromeOptions getChromeOptions() {
        co = new ChromeOptions();

        return co;

    }


}