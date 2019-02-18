package com.AutoHero.managers;

import com.AutoHero.DefaultSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by olena on 2/14/19.
 */
public class CommonManager implements ICommonManager {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public CommonManager() {
        driver = initDriver();
        driver.manage().timeouts().setScriptTimeout(3000, TimeUnit.MILLISECONDS);
        wait = new WebDriverWait(Driver(), DefaultSettings.WaitTime);
        actions = new Actions(Driver());
    }

    public WebDriver Driver() {
        return driver;
    }

    public Actions Actions() {
        return actions;
    }

    public WebDriverWait Wait() {
        return wait;
    }

    private WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver", DefaultSettings.ChromeDriverLocation);
        return new ChromeDriver();

    }

    public void clickLink(WebElement link) {
        wait.until(ExpectedConditions.visibilityOf(link));
        actions.moveToElement(link).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(link));
        actions.click().build().perform();
    }

    public void setSelectOption(WebElement dropdown, String option) {

        Select selectObj = new Select(dropdown);
        //TODO catch exception about no such option
        selectObj.selectByVisibleText(option);


    }
}
