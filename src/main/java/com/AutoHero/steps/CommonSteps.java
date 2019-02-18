package com.AutoHero.steps;

import com.AutoHero.managers.CommonManager;
import com.AutoHero.managers.ExecutionContext;
import com.AutoHero.managers.AHPageFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;

/**
 * Created by olena on 2/14/19.
 */
public class CommonSteps {

    CommonManager manager;

    @Before
    public void setUp(){
        manager = new CommonManager();
        AHPageFactory factory = new AHPageFactory(manager);
        new ExecutionContext(factory);
    }

    @After
    public void tearDown(){
        manager.Driver().quit();
    }


    @When("^user opens page \"([^\"]*)\"$")
    public void open_page(String page) {
        manager.Driver().get(page);

    }
}
