package org.pages;

import org.annotations.Path;
import org.openqa.selenium.WebDriver;

public abstract class AbsBasePage extends AbsCommon {

    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

    private String baseUel = System.getProperty("base.url");

    private String getPath() {
        Class clazz = getClass();
        if (clazz.isAnnotationPresent(Path.class)) {
            Path path = (Path)clazz.getDeclaredAnnotation(Path.class);
            return path.value();
        }

        return "";
    }
//    private By titleEventElement = By.cssSelector(".title");

    public void open() {
        driver.get(baseUel + getPath());
    }
}
