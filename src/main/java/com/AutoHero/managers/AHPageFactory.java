package com.AutoHero.managers;

import com.AutoHero.pages.AbstractPage;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by olena on 2/14/19.
 */
public class AHPageFactory implements IPageFactory {

    private ICommonManager commonManager;

    public ICommonManager commonManager() {
        return commonManager;
    }

    public AHPageFactory (ICommonManager manager){
        commonManager = manager;
    }

    public <T extends AbstractPage> T create(Class<T> pageClass) {
        T page = PageFactory.initElements(commonManager().Driver(), pageClass);
        page.CommonManager = commonManager();
        return page;
    }
}
