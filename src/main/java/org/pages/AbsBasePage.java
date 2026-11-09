package org.pages;

import org.annotations.Path;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AbsBasePage extends AbsCommon {

    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

    private String baseUel = System.getProperty("base.url");

    @FindBy(css = "a[role='button']")
    private WebElement logoutButton;

    private String getPath() {
        Class clazz = getClass();
        if (clazz.isAnnotationPresent(Path.class)) {
            Path path = (Path)clazz.getDeclaredAnnotation(Path.class);
            return path.value();
        }

        return "";
    }

    public void open() {
        driver.get(baseUel + getPath());
    }

    public void logout() {
        try {
            waiters.waitForElementVisible(By.cssSelector("a[role='button']"));
            logoutButton.click();
        } catch (Exception e) {
            System.out.println("Кнопка 'Выйти' не найдена");
        }
    }

}
