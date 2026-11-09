package org.pages;

import org.components.HeaderComponent;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        actions.moveToElement(viewUsers).click().perform();
    }

    //Проверяем, что перешли в список пользователей
    public void verifyUsersPage(String expectedTitle) {
        HeaderComponent headerComponent = new HeaderComponent(driver);
        headerComponent.waitForText(expectedTitle);
        String actualTitle = headerComponent.getText();
        Assertions.assertTrue(actualTitle.contains(expectedTitle), "Заголовок не совпадает");
    }

    //Ждем прогрузки хотя бы одной карточки пользователя
    public void waitUsersCardBody() {
        waiters.waitForCondition(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".card-title"), 0));
    }

    //Метод, для проверки не пустоты списка пользователей
    public int getUsersCount() {
        return driver.findElements(By.cssSelector(".card")).size();
    }

    //Поиск карточки пользователя по логину
    public WebElement findUserCardByName(String username) {
        By xpathLocator = By.xpath(String.format("//div[contains(@class, 'card') and .//div[contains(text(), '%s')]]", username));
        waiters.waitForCondition(ExpectedConditions.visibilityOfElementLocated(xpathLocator));
        return driver.findElement(xpathLocator);
    }

    public WebElement findTargetUserCard() {
        String targetUser = System.getProperty("target.user");
        return findUserCardByName(targetUser);
    }

    // Клик по кнопке "Посмотреть списки желаний"
    public void clickViewWishlistsButton(WebElement userCard) {
        WebElement viewButton = userCard.findElement(By.cssSelector("a.btn-primary"));
        viewButton.click();
    }

}
