package com.AutoHero.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by olena on 2/14/19.
 */
public class SearchFiltersPage extends AbstractPage {

    @FindBy(xpath = ".//div[contains(@data-qa-selector, 'filter-')]")
    private List<WebElement> filters;

//    @FindBy(xpath =".//select[@data-qa-selector='select'][@name='make']")
//    WebElement makeSlct;
//
//    @FindBy(xpath =".//select[@data-qa-selector='select'][@name='make']")
//    WebElement makeSlct;
//
//    @FindBy(xpath =".//select[@data-qa-selector='select'][@name='make']")
//    WebElement makeSlct;
//
//    @FindBy(xpath =".//select[@data-qa-selector='select'][@name='make']")
//    WebElement makeSlct;
//
//    @FindBy(xpath =".//select[@data-qa-selector='select'][@name='make']")
//    WebElement makeSlct;
//
//    @FindBy(xpath =".//select[@data-qa-selector='select'][@name='make']")
//    WebElement makeSlct;

    public List<WebElement> getFilters() {
        return this.filters;
    }

    public boolean isFilterOpened(WebElement filter) {

        return filter.getAttribute("class").contains("open");

    }

    public WebElement getFilter(String filterName) {
        for (int i = 0; i < filters.size(); i++) {
            if (filters.get(i).findElement(By.xpath("./div[contains(@class, 'label')]/span")).getText().contains(filterName))
            return filters.get(i);
        }
        return null;
    }
}




