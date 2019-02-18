package com.AutoHero.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by olena on 2/14/19.
 */
public interface ICommonManager {

    public WebDriver Driver();

    public Actions Actions();

    public WebDriverWait Wait();

    public void clickLink(WebElement link);

    public void setSelectOption(WebElement dropdown, String option);


}
