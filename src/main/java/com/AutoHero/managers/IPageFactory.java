package com.AutoHero.managers;

import com.AutoHero.pages.AbstractPage;

/**
 * Created by olena on 2/14/19.
 */
public interface IPageFactory {

    ICommonManager commonManager();

    <T extends AbstractPage> T create(Class<T> pageClass);
}
