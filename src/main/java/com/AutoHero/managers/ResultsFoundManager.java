package com.AutoHero.managers;

import com.AutoHero.Car;
import com.AutoHero.pages.ResultsFoundPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by olena on 2/14/19.
 */
public class ResultsFoundManager extends AbstractManager {

    public void ensureFilterApplied(String filterName) {
        CommonManager.Wait()
                .until(ExpectedConditions.visibilityOf(ExecutionContext.getInstance().getPage(ResultsFoundPage.class).getAppliedFilter(filterName)));
    }

    public void setSortValue(String value){
        Select sort = new Select(ExecutionContext.getInstance().getPage(ResultsFoundPage.class).getSort());
        sort.selectByVisibleText(value);
    }

    public void goToPage(int i){
        CommonManager.Wait().until(ExpectedConditions.visibilityOf(ExecutionContext.getInstance().getPage(ResultsFoundPage.class).getPagination()));
        CommonManager.clickLink(ExecutionContext.getInstance().getPage(ResultsFoundPage.class).getPagination().findElement(By.xpath("./li[a[text()='"+i+"']]")));
    }
}
