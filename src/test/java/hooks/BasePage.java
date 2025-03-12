package hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.OptionManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class BasePage {


    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public Properties prop;
    public OptionManager op;

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    @Before
    public void setUp() {
        loadProperties();
        initializeDriver();
        waitForPageLoad();
    }

    public void loadProperties() {
        prop = new Properties();
        try (FileInputStream input = new FileInputStream("src/test/resources/extent.properties")) {
            prop.load(input);
        } catch (Exception e) {
            System.err.println("Failed to load properties: " + e.getMessage());
        }
    }

    public void initializeDriver() {
        op = new OptionManager(prop);

        String browser = prop.getProperty("browser", "chrome").toLowerCase();
        WebDriver driver;

        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                EdgeDriver driverEdge;
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        tlDriver.set(driver);
        driver.manage().window().maximize();
        getDriver().get("https://www.civilservicejobs.service.gov.uk/csr/index.cgi");}


    public void waitForPageLoad() {
        WebDriver driver = getDriver();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
    }

    @SneakyThrows
    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        WebDriver driver = getDriver();
        if (driver instanceof TakesScreenshot) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        } else {
            System.out.println("Driver does not support screenshots");
        }
    }

    @After
    public void tearDown() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
           tlDriver.remove();
        }
    }
}
