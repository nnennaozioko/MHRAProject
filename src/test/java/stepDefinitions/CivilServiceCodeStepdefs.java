package stepDefinitions;

import hooks.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.CivilServiceCodePage;

public class CivilServiceCodeStepdefs {
    CivilServiceCodePage civilServiceCodePage = new CivilServiceCodePage(BasePage.getDriver());

    @When("user clicks careers available in the civil service link")
    public void userClicksCareersAvailableInTheCivilServiceLink() {

       civilServiceCodePage.clickCareersAvailableInTheCivilServiceLink();
    }

    @And("user clicks accept cookies")
    public void userClicksAcceptCookies() {
        civilServiceCodePage.clickAcceptCookiesButton();
    }

    @Then("civil service careers page displayed")
    public void civilServiceCareersPageDisplayed() {
        Assert.assertTrue(civilServiceCodePage.verifyCivilServiceCareersPageDisplayed());
    }

    @When("user clicks life in the civil service dropdown")
    public void userClicksLifeInTheCivilServiceDropdown() {
        civilServiceCodePage.clickLifeInTheCivilServiceDropdown();
    }

    @And("user clicks working for the civil service")
    public void userClicksWorkingForTheCivilService() {
        civilServiceCodePage.clickWorkingForTheCivilService();
    }

    @And("user clicks civil service code link")
    public void userClicksCivilServiceCodeLink() {
        civilServiceCodePage.clickCivilServiceCodeLink();
    }

    @Then("civil service commission code session displayed")
    public void civilServiceCommissionCodeSessionDisplayed() {
        Assert.assertTrue(civilServiceCodePage.verifyCivilServiceCommissionCodeSessionDisplayed());
    }
}
