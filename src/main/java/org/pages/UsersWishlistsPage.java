package org.pages;

import org.components.HeaderComponent;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class UsersWishlistsPage extends AbsBasePage {

    public UsersWishlistsPage(WebDriver driver) {
        super(driver);
    }

    //Проверяем, что перешли в список желаний пользователя
    public void verifyUsersWishlistsPage(String expectedTitle) {
        HeaderComponent headerComponent = new HeaderComponent(driver);
        headerComponent.waitForText(expectedTitle);
        String actualTitle = headerComponent.getText();
        Assertions.assertTrue(actualTitle.contains(expectedTitle),"Заголовок не совпадает");
    }

}
