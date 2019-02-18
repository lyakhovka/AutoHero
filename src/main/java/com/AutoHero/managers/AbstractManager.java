package com.AutoHero.managers;

/**
 * Created by olena on 2/16/19.
 */
public class AbstractManager {

    ICommonManager CommonManager;

    public AbstractManager(){

        CommonManager = ExecutionContext.getInstance().CommonManager();
    }
}
