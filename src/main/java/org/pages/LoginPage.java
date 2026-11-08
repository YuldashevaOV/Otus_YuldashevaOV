package org.pages;

import org.annotations.Path;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Path("/login")
public class LoginPage extends AbsBasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Авторизация
    @FindBy(css = "input[type='text']")
    private WebElement usernameInput;

    @FindBy(css = "input[type='password']")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    public void loginAs(String username, String password) {
        waiters.waitForElementVisible(By.cssSelector("input[type='text']"));

        usernameInput.clear();
        passwordInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    //Проверяем наличие кнопки "Выйти"
    public void verifyUserIsLoggedIn() {
        boolean isVisible = waiters.waitForElementVisible(By.cssSelector("a[role='button']"));
        Assertions.assertTrue(isVisible, "Авторизация не прошла");
    }
}