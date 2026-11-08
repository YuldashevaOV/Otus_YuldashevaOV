package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.waiters.Waiters;

/**
 * Базовый класс для страниц и компонентов
 */

public abstract class AbsCommon {

    protected WebDriver driver;
    protected Actions actions;
    protected Waiters waiters;

    public AbsCommon(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.waiters = new Waiters(driver);

        PageFactory.initElements(driver, this);
    }
}
