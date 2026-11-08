package org.components;

import org.annotations.Component;
import org.assertj.core.api.Assertions;
import org.exceptions.ComponentNotFoundException;
import org.exceptions.ComponentNotSupportedException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pages.AbsCommon;

/**
 * Базовый класс для всех компонентов
 */

public abstract class AbsComponent extends AbsCommon {
    public AbsComponent(WebDriver driver) {
        super(driver);
    }

    {
        try {
            Assertions.assertThat(waiters.waitForElementPresent(componentMetaDataAdapter()))
                    .as("Error")
                    .isTrue();
        } catch (Exception e) {
        }

    }

    private By componentMetaDataAdapter() {
        Class clazz = getClass();
        if (clazz.isAnnotationPresent(Component.class)) {
            Component component = (Component) clazz.getDeclaredAnnotation(Component.class);
            String componentMetaData = component.value();
            String[] componentData = componentMetaData.split(":");
            String strategy = componentData[0];
            String strategyValue = componentData[1];

            switch (strategy) {
                case "css":
                    return By.cssSelector(strategyValue);
                default:
                    throw new ComponentNotSupportedException(String.format("Стратегия поиска '%s' не поддерживается в классе %s",
                            strategy, clazz.getSimpleName()));
            }
        }

        throw new ComponentNotSupportedException(String.format("Класс %s не имеет аннотации @Component", clazz.getSimpleName()));
    }

    protected WebElement getComponentEntry() {
        try {
            return driver.findElement(componentMetaDataAdapter());
        } catch (NoSuchElementException e) {
            throw new ComponentNotFoundException(
                    String.format("Компонент %s не найден на странице по локатору: %s",
                            this.getClass().getSimpleName(), componentMetaDataAdapter()), e);
        }
    }
}
