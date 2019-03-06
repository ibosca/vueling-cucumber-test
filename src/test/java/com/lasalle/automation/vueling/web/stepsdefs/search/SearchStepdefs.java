package com.lasalle.automation.vueling.web.stepsdefs.search;

import com.lasalle.automation.vueling.web.domain.SearchDto;
import com.lasalle.automation.vueling.web.pages.SearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchStepdefs {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static WebDriver driver;

    private SearchPage searchPage;

    private List<SearchDto> searches;

    @Before
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "/Users/isaac/Desktop/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        LOGGER.debug("driver started");
    }

    @After
    public static void afterClass() {
        driver.close();
        LOGGER.debug("driver closed");
    }
    
    @Given("^I'm main page$")
    public void iMMainPage() {
        // Write code here that turns the phrase above into concrete actions
        LOGGER.debug("I'm main page started");
        driver.get("https://www.vueling.com/es");


    }

    @When("^I try to find a fly$")
    public void iTryToFindAFly(List<SearchDto> searchDtoList) {
        // Write code here that turns the phrase above into concrete actions
        LOGGER.debug("Destination: [{}]", searchDtoList.get(0).getDestination());

        searches = searchDtoList;
        searchPage.setDriver(driver);
        searchPage.searchFlight(searches.get(0));

    }

    @Then("^I get available flight$")
    public void iGetAvailableFlight() {

    }
}
