package com.AutoHero.steps;

import com.AutoHero.managers.ExecutionContext;
import com.AutoHero.managers.ICommonManager;
import com.AutoHero.managers.SearchFiltersManager;
import com.AutoHero.pages.SearchFiltersPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by olena on 2/16/19.
 */
public class SearchFiltersSteps {

    @When("^Sets \"([^\"]*)\" for \"([^\"]*)\" filter$")
    public void set_value_for_filter(String option, String filter) {
        new SearchFiltersManager().setDropdownFilter(filter,option);

    }

}
