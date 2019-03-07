package com.lasalle.automation.vueling.web.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;

public class ResultPage extends PageObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(how = How.CSS, using = "#outboundFlight > div.availabilitySection__title.inlineElements.clearBoth > h2")
    private WebElementFacade flyInfo;

    @FindBy(how = How.CLASS_NAME, using = "travelInfo_headerTitle")
    private WebElementFacade destination;

    public boolean atResultPage() {

        System.out.println("TITLE: "+this.getTitle());

        System.out.println(flyInfo.getText());

        return false;
    }

    public String getDestination() {
        return destination.getText();
    }
}
