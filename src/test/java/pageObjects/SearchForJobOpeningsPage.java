package pageObjects;

import org.openqa.selenium.*;

public class SearchForJobOpeningsPage {

    public WebDriver driver;

    private final By verifyProtectedByALTCHA = By.xpath("//input[@type='checkbox']");
    private final By continueButton = By.xpath("//button[@type='submit']");
    private final By acceptAdditionalCookies = By.xpath("//input[@id='accept_all_cookies_button']");
    private final By jobTitleField = By.xpath("//input[@id='what']");
    private final By regionField = By.xpath("//input[@id='whereselector']");
    private final By searchJobButton = By.id("submitSearch");
    private final By searchResultsRelevantJobListingsAppear = By.cssSelector("h1[id='id_common_page_title_h1']");
    private final By departmentButton = By.xpath("//button[text()=' Department ']");
    private final By searchField = By.xpath("(//input[@type='text'])[3]");
    private final By medicinesAndHealthcareProductsRegulatoryAgencyCheckbox = By.xpath("//input[@aria-label='Medicines and Healthcare Products Regulatory Agency']");
    private final By updateResultsButton = By.id("submitSearchUpdate");
    private final By numberOfJobsAvailableDisplayed = By.xpath("//h1[@id='id_common_page_title_h1']");


    public SearchForJobOpeningsPage(WebDriver driver){
        this.driver=driver;
    }

      public void clickVerifyProtectedByALTCHACheckbox(){
       driver.findElement(verifyProtectedByALTCHA).click();{
        }
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();

            Thread.sleep(5000);

            driver.findElement(continueButton).click();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    public void clickAcceptAdditionalCookies(){
          driver.findElement(acceptAdditionalCookies).click();
     }

    public void enterJobTitle(String jobtitle ){
        driver.findElement(jobTitleField).sendKeys(jobtitle);

    }

    public void enterRegion(String region){
        driver.findElement(regionField).sendKeys(region);
    }

    public void clickSearchJobButton(){
        driver.findElement(searchJobButton).click();
    }

    public boolean verifyRelevantJobListingsAppear(){
        return driver.findElement(searchResultsRelevantJobListingsAppear).isDisplayed();
    }

    public void selectDepartment(){
        driver.findElement(departmentButton).click();
    }

    public void enterMedicineInSearchField(String medicinetext){
        driver.findElement(searchField).sendKeys(medicinetext);
    }

    public  void tickMedicinesAndHealthcareProductsRegulatoryAgencyCheckbox(){
        driver.findElement(medicinesAndHealthcareProductsRegulatoryAgencyCheckbox).click();
    }

    public void clickUpdateResultsButton(){
        driver.findElement(updateResultsButton).click();
    }

    public int verifyNumberOfJobsAvailable() {
        String resultsText = driver.findElement(numberOfJobsAvailableDisplayed).getText();
        try {
          return Integer.parseInt(resultsText.replaceAll("[^0-9]", ""));
        } catch (NumberFormatException e) {

            return 1;
        }
    }


}
