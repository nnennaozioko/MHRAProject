package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.Set;

public class CivilServiceCodePage {

   public WebDriver driver;

    public CivilServiceCodePage(WebDriver driver){
        this.driver=driver;
    }

    private final By careersAvailableInTheCivilServiceLink = By.xpath("(//a[@target='_blank'])[2]");
    private final By acceptCookiesButton = By.xpath("(//button[@type='submit'])[1]");
    private final By civilServiceCareersPageDisplayed = By.xpath("(//img[@class='megamenu-logo__img'])[1]");
    private final By lifeInTheCivilServiceDropdown = By.xpath("(//span[@class='megamenu-submenu__chevron'])[3]");
    private final By workingForTheCivilService = By.xpath("(//span[text()='Working for the Civil Service'])[1]");
    private final By civilServiceCodeLink = By.xpath("//a[text()='Civil Service Code']");
    private final By civilServiceCommissionCodeSessionDisplayed = By.xpath("//a[text()='The Code']");

    public void clickCareersAvailableInTheCivilServiceLink(){

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(careersAvailableInTheCivilServiceLink));
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
        }
    }

    public void clickAcceptCookiesButton(){
        driver.findElement(acceptCookiesButton).click();
    }

   public boolean verifyCivilServiceCareersPageDisplayed(){
        return driver.findElement(civilServiceCareersPageDisplayed).isDisplayed();
   }

   public void clickLifeInTheCivilServiceDropdown(){
        driver.findElement(lifeInTheCivilServiceDropdown).click();
  }


   public void clickWorkingForTheCivilService(){
        driver.findElement(workingForTheCivilService).click();
 }

 public void clickCivilServiceCodeLink(){
        driver.findElement(civilServiceCodeLink).click();
 }

 public boolean verifyCivilServiceCommissionCodeSessionDisplayed(){
        return driver.findElement(civilServiceCommissionCodeSessionDisplayed).isDisplayed();
 }
}
