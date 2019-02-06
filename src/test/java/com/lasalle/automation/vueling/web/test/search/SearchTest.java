package com.lasalle.automation.vueling.web.test.search;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/search",
        glue = "com.lasalle.automation.vueling.web.stepsdefs.search")
public class SearchTest {}
