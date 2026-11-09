package org.pages;

import org.components.HeaderComponent;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WishlistPage extends AbsBasePage {

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    //Кнопка "Просмотр"
    @FindBy(css = "a[href^='/wishlists/'] button")
    private WebElement viewButton;

    // Клик по кнопке "Просмотр"
    public void openWishlist() {
        waiters.waitForCondition(ExpectedConditions.visibilityOf(viewButton));
        actions.moveToElement(viewButton).click().perform();
    }

    //Проверяем, что перешли в список желаний
    public void verifyWishlist(String expectedTitle) {
        HeaderComponent headerComponent = new HeaderComponent(driver);
        headerComponent.waitForText(expectedTitle);
        String actualTitle = headerComponent.getText();
        Assertions.assertTrue(actualTitle.contains(expectedTitle),"Заголовок не совпадает");
    }

    //Все карточки подарков
    @FindBy(css = ".card")
    private List<WebElement> giftCards;

    //Цены внутри карточки
    private final By priceLocator = By.cssSelector("p.card-text");

    // Получаем список цен и преобразуем в чистое число
    public List<Integer> getGiftPrices() {
        return giftCards.stream()
                .flatMap(card -> card.findElements(priceLocator).stream())
                .map(WebElement::getText)
                .filter(text -> text.contains("Цена"))
                .map(text -> text.replaceAll("[^0-9]", ""))
                .filter(text -> !text.isEmpty())
                .map(Integer::parseInt)
                .toList();
    }

    // Получаем самый дорогой подарок
    public int findMaxGiftPriceReduce() {
        return getGiftPrices().stream()
                .reduce(0, (a, b) -> a > b ? a : b);
    }

    // Получаем самый дешевый подарок
    public int findMinGiftPriceReduce() {
        return getGiftPrices().stream()
                .reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);
    }
}
