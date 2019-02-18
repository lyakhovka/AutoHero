package com.AutoHero.steps;

import com.AutoHero.customExceptions.NoFilterException;
import com.AutoHero.managers.ExecutionContext;
import com.AutoHero.managers.ResultsFoundManager;
import com.AutoHero.managers.SearchFiltersManager;
import com.AutoHero.pages.ResultsFoundPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by olena on 2/16/19.
 */
public class ResultsFoundSteps {

    @When("^Ensure filter \"([^\"]*)\" is applied$")
    public void ensure_filter_applied(String filterName) {
        new ResultsFoundManager().ensureFilterApplied(filterName);

    }

    @When("^Sorts results by \"([^\"]*)\"$")
    public void sort_results(String sortValue) {
        new ResultsFoundManager().setSortValue(sortValue);

    }

    @When("^Gets found results$")
    public void get_results() {
        ExecutionContext.getInstance().getPage(ResultsFoundPage.class).getCars();
    }

    @Then("^Search results are filtered by \"([^\"]*)\" \"([^\"]*)\"$")
    public void results_filtered(String filter, String value) throws ParseException, NoFilterException {
        switch (filter) {
            case "Erstzulassung":
                Assert.assertTrue(ExecutionContext.getInstance().getPage(ResultsFoundPage.class).isCarsNewerThen(value));
                break;
            default:
                throw new NoFilterException("There is no such filter: " + filter);
        }

    }

    @Then("^results are sorted by \"([^\"]*)\"$")
    public void results_sorted(String parameter) {

        Assert.assertTrue(ExecutionContext.getInstance().getPage(ResultsFoundPage.class).isCarsSorted(parameter));

    }
}
