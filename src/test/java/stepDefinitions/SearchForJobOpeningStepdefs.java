package stepDefinitions;

import hooks.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Optional;
import pageObjects.SearchForJobOpeningsPage;

  public class SearchForJobOpeningStepdefs {
    SearchForJobOpeningsPage searchJobOpeningsPage = new SearchForJobOpeningsPage(BasePage.getDriver());

    @Given("user navigate to civil service jobs")
    public void userNavigateToCivilServiceJobs() {
        searchJobOpeningsPage = new SearchForJobOpeningsPage(BasePage.getDriver());
    }

    @When("user clicks verify protected by ALTCHA checkbox")
    public void userClicksVerifyProtectedByALTCHACheckbox() {
        searchJobOpeningsPage.clickVerifyProtectedByALTCHACheckbox();
    }

    @When("user clicks continue button")
    public void userClicksContinueButton() {

        searchJobOpeningsPage.clickContinueButton();
    }

    @And("user clicks accept additional cookies")
    public void userClicksAcceptAdditionalCookies() {

        searchJobOpeningsPage.clickAcceptAdditionalCookies();
    }

    @Then("civil service job search page displayed")
    public void civilServiceJobSearchPageDisplayed() {
    }

    @When("user enters job title, skill or keywords {string}")
    public void userEntersJobTitleSkillOrKeywords(String title) {
        searchJobOpeningsPage.enterJobTitle(title);
    }

    @And("user enters a postcode, town or region {string}")
    public void userEntersAPostcodeTownOrRegion(String region) {
        searchJobOpeningsPage.enterRegion(region);
    }

    @And("user clicks search for jobs button")
    public void userClicksSearchForJobsButton() {
        searchJobOpeningsPage.clickSearchJobButton();
    }

    @Then("search results listing relevant jobs appear")
    public void searchResultsListingRelevantJobsAppear() {
        Assert.assertTrue(searchJobOpeningsPage.verifyRelevantJobListingsAppear());
    }

    @When("user clicks department to filter")
    public void userClicksDepartmentToFilter() {
        searchJobOpeningsPage.selectDepartment();
    }

    @And("user enters medicine in {string}")
    public void userEntersMedicineIn(String medicinetext) {
        searchJobOpeningsPage.enterMedicineInSearchField(medicinetext);
    }

    @And("user clicks to select the medicines and healthcare product regulatory agency checkbox")
    public void userClicksToSelectTheMedicinesAndHealthcareProductRegulatoryAgencyCheckbox() {
        searchJobOpeningsPage.tickMedicinesAndHealthcareProductsRegulatoryAgencyCheckbox();
    }

    @And("user clicks update results")
    public void userClicksUpdateResults() {
        searchJobOpeningsPage.clickUpdateResultsButton();
    }


      @Then("number of jobs available displayed")
      public void numberOfJobsAvailableDisplayed() {
       searchJobOpeningsPage.verifyNumberOfJobsAvailable();
      }
}
