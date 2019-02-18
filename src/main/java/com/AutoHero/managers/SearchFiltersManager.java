package com.AutoHero.managers;

import com.AutoHero.pages.ResultsFoundPage;
import com.AutoHero.pages.SearchFiltersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by olena on 2/16/19.
 */
public class SearchFiltersManager extends AbstractManager {

    public void openFilter(WebElement filter) {

        CommonManager.clickLink(filter.findElement(By.xpath("./div[contains(@class, 'label')]/*[name()='svg']")));
    }

    public void setDropdownFilter(String filterName, String option) {

       WebElement filter = ExecutionContext.getInstance().getPage(SearchFiltersPage.class).getFilter(filterName);

       if(!ExecutionContext.getInstance().getPage(SearchFiltersPage.class).isFilterOpened(filter))
           openFilter(filter);

       WebElement dropdown = filter.findElement(By.xpath(".//select"));

        CommonManager.setSelectOption(dropdown, option);

    }

    public void navigatePage(int page){
        CommonManager.clickLink(ExecutionContext.getInstance().getPage(ResultsFoundPage.class).getPagination().findElement(By.xpath(".//ul[@class='pagination']/li/a[text()='"+page+"']")));
    }
}
