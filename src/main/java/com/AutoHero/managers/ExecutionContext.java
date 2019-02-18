package com.AutoHero.managers;

import com.AutoHero.Car;
import com.AutoHero.pages.AbstractPage;

import java.util.*;

/**
 * Created by olena on 2/14/19.
 */
public class ExecutionContext {

    private static ExecutionContext instance;
    private Map<String, AbstractPage> pages;
    private IPageFactory factory;

    public List<Car> cars;

    public ExecutionContext(IPageFactory factory){
        this.factory = factory;
        ExecutionContext.instance = this;
        pages = new HashMap<String, AbstractPage>();

    }

    public static ExecutionContext getInstance(){
        return instance;
    }

    public IPageFactory Factory(){return factory;}

    public ICommonManager CommonManager(){return factory==null?null:factory.commonManager();}

    public <T extends AbstractPage> T getPage(Class<T> pageClass){
        AbstractPage existed = pages.get(pageClass.getName());
        if(existed!=null) return (T) existed;
        T page = Factory().create(pageClass);
        pages.put(pageClass.getName(), page);
        return page;
    }
}
