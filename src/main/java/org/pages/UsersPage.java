package org.pages;

import org.components.HeaderComponent;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class UsersPage extends AbsBasePage {

    public UsersPage(WebDriver driver) {
        super(driver);
    }

    //Кнопка "Пользователи"
    @FindBy(css = "a[href^='/users']")
    private WebElement viewUsers;

    // Клик по кнопке "Пользователи"
    public void openUsers() {
        waiters.waitForCondition(ExpectedConditions.visibilityOf(viewUsers));
        viewUsers.click();
    }

    //Проверяем, что перешли в список пользователей
    public void verifyUsers(String expectedTitle) {
        HeaderComponent headerComponent = new HeaderComponent(driver);
        String actualTitle = headerComponent.getText();
        Assertions.assertTrue(actualTitle.contains(expectedTitle),"Заголовок не совпадает");
    }

    //Ждем прогрузки хотя бы одной карточки пользователя
    public void waitUsersCardBody() {
        waiters.waitForCondition(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".card-title"), 0));
    }

    //Метод, для проверки не пустоты списка пользователей
    public int getUsersCount() {
        return driver.findElements(By.cssSelector(".card")).size();
    }
}
