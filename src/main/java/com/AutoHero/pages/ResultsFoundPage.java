package com.AutoHero.pages;

import com.AutoHero.Car;
import com.AutoHero.managers.ExecutionContext;
import com.google.common.collect.Comparators;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by olena on 2/14/19.
 */
public class ResultsFoundPage extends AbstractPage {

    @FindBy(xpath = ".//div[@data-qa-selector-type='LIST']/div[contains(@class, 'item')]")
    List<WebElement> shownCars;

    @FindBy(xpath = ".//ul[@class='pagination']")
    WebElement pagination;

    @FindBy(xpath = ".//select[@name='sort']")
    WebElement sort;

    @FindBy(xpath = ".//div[ul/li[@data-qa-selector='active-filter']]")
    List<WebElement> filtersApplied;

    public WebElement getSort() {
        return sort;
    }

    public WebElement getPagination() {
        return pagination;
    }

    public boolean isFilterApplied(String filterName) {
        try {
            CommonManager.Wait().until(ExpectedConditions.visibilityOf(filtersApplied.get(0)));

        } catch (TimeoutException e) {
            e.printStackTrace();
            return false;
        }
        for (int i = 0; i < filtersApplied.size(); i++) {
            if (filtersApplied.get(i).findElement(By.xpath("./ul/li/button")).getText().contains(filterName))
                return true;
        }
        return false;
    }

    public WebElement getAppliedFilter(String filterName) {

        CommonManager.Wait().until(ExpectedConditions.visibilityOfAllElements(filtersApplied));

        for (int i = 0; i < filtersApplied.size(); i++) {
            if (filtersApplied.get(i).findElement(By.xpath("./ul/li/button")).getText().contains(filterName))
                return filtersApplied.get(i);
        }
        return null;
    }

    public int getPagesAmount() {

        return Integer.parseInt(pagination.findElement(By.xpath("./li[last()-2]/a")).getText());
    }

    public boolean isPageActive(int i) {
        CommonManager.Wait().until(ExpectedConditions.visibilityOf(pagination));
        return pagination.findElement(By.xpath("./li[a[text()='" + i + "']]")).getAttribute("class").contains("active");
    }

    public void getCars() {

        int pagesAmount = getPagesAmount();
        int itemsOnPage = shownCars.size();
        ExecutionContext.getInstance().cars = new ArrayList<>(pagesAmount * itemsOnPage);

        for (int j = 1; j <= pagesAmount; j++) {

            String p = String.valueOf(j);
            CommonManager.clickLink(pagination.findElement(By.xpath("./li/a[text()='" + p + "']")));
            if (j > 1) CommonManager.Wait().until(ExpectedConditions.stalenessOf(shownCars.get(0)));

            for (int i = (j - 1) * itemsOnPage; i < itemsOnPage * j; i++) {

                if (shownCars.size() == i - itemsOnPage * (j - 1)) break;

                ExecutionContext.getInstance().cars.add(i, new Car());

                for (int k = 0; k < 4; k++) {
                    try {

                        String date = shownCars.get(i - itemsOnPage * (j - 1)).findElement(By.xpath(".//ul/li[1]")).getText().split("\\r?\\n")[1];
                        ExecutionContext.getInstance().cars.get(i).setDate(date);

                        String price = shownCars.get(i - itemsOnPage * (j - 1)).findElement(By.xpath(".//div[contains(@class, 'price')]/div[contains(@class, 'totalPrice')]")).getText().split(" ")[0].replaceAll("\\.", "");
                        ExecutionContext.getInstance().cars.get(i).setPrice(Double.parseDouble(price));

                        break;

                    } catch (StaleElementReferenceException ex) {
                        shownCars = CommonManager.Driver().findElements(By.xpath(".//div[@data-qa-selector-type='LIST']/div[contains(@class, 'item')]"));
                    }
                }
            }
        }

//        for(int i=0; i<ExecutionContext.getInstance().cars.size(); i++){
//            System.out.println("total: " + ExecutionContext.getInstance().cars.size());
//            System.out.println(ExecutionContext.getInstance().cars.get(i));
//        }
    }

    public boolean isCarsNewerThen(String date) throws ParseException {

        Date dateFiltered = new SimpleDateFormat("yyyy").parse(date);
        boolean res = true;
        int n = ExecutionContext.getInstance().cars.size();

        for (int i = 0; i < n; i++)
            res = res && (ExecutionContext.getInstance().cars.get(i).getDate().after(dateFiltered) || ExecutionContext.getInstance().cars.get(i).getDate().equals(dateFiltered));

        return res;
    }

    public boolean isCarsSorted(String parameter) {
//        setCars();
        Comparator<Car> cPrice = (car1, car2) -> {
            return new Double(car1.getPrice()).compareTo(new Double(car2.getPrice()));
        };

        boolean res = Comparators.isInOrder(ExecutionContext.getInstance().cars, cPrice.reversed());
        System.out.println(res);
        return res;
    }

}
