package com.lasalle.automation.vueling.web.pages;

import com.lasalle.automation.vueling.web.domain.Daterize;
import com.lasalle.automation.vueling.web.domain.SearchDto;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SearchPage extends PageObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(how = How.CSS, using = ".searchbar-container .searchbar-main .searchbar-main_tab-content .searchbar-main_tab-content_pane .form-group>.form-input.origin .input-group input")
    private WebElementFacade origin;

    @FindBy(how = How.CSS, using = ".searchbar-container .searchbar-main .searchbar-main_tab-content .searchbar-main_tab-content_pane .form-group>.form-input.destination .input-group input")
    private WebElementFacade destination;

    @FindBy(how = How.ID, using = "inputGoing")
    private WebElementFacade outboundFly;

    @FindBy(how = How.ID, using = "inputComeBack")
    private WebElementFacade returnFly;

    @FindBy(how = How.ID, using = "passengers-input")
    private WebElementFacade passengers;

    @FindBy(how = How.ID, using = "btnSubmitHomeSearcher")
    private WebElementFacade btnSearch;

    @FindBy(how = How.CSS, using = "td:not(.ui-state-disabled) a.ui-state-default")
    private List<WebElementFacade> listOfAvailableDays;

    @FindBy(how = How.CLASS_NAME, using = "addReturnFlight")
    private WebElementFacade addReturnLink;


    public void searchFlight(SearchDto search) {
        LOGGER.debug("searchFlight starts, reservation: [{}]", search);

        setOrigin(search.getOrigin());
        setDestination(search.getDestination());

        setDate(search.getOutboundFly());

        //start add passengers...

        //end add passengers

        addReturnLink.click();
        setDate(search.getReturnFly());

        btnSearch.click();

    }

    public void setOrigin(String originCity) {
        origin.typeAndEnter(originCity);
    }

    public void setDestination(String destinationCity) {
        destination.typeAndEnter(destinationCity);
    }

    public void setDate(String outboundDateKey){

        Date outboundDate = Daterize.fromString(outboundDateKey);

        int day = Integer.parseInt(new SimpleDateFormat("dd").format(outboundDate));
        int lastDayElementChecked = Integer.parseInt(listOfAvailableDays.get(0).getText());

        for(WebElementFacade dayElement : listOfAvailableDays){
            int dayNumber = Integer.parseInt(dayElement.getText());

            if(dayNumber >= day || dayNumber < lastDayElementChecked ) {
                dayElement.click();
                break;
            }

            lastDayElementChecked = dayNumber;
        }

    }

}
