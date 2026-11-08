package otus;

import com.google.inject.Inject;
import org.extensions.UIExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.pages.LoginPage;
import org.pages.MainPage;
import org.pages.WishlistPage;
import org.prepare.User;

@ExtendWith(UIExtension.class)
public class WishlistTest {

    @Inject
    private MainPage mainPage;

    @Inject
    private User user;

    @Inject
    private LoginPage loginPage;

    @Inject
    private WishlistPage wishlistPage;

    @Test
    @DisplayName("Сценарий 1. Выбор самого дорогого и самого дешёвого подарка")
    public void checkMaxAndMinGiftPrice() {
        // Авторизация
        mainPage.open();
        loginPage.open();
        loginPage.loginAs(user.getUsername(), user.getPassword());
        loginPage.verifyUserIsLoggedIn();

        // Переход к списку подарков
        wishlistPage.openWishlist();
        wishlistPage.verifyWishlist("Сценарий 1");

        // Выбираем из карточек на странице самый дорогой и самый дешёвый подарок и проверяем, что они совпадают с ожидаемыми.
        int maxPrice = wishlistPage.findMaxGiftPriceReduce();
        int minPrice = wishlistPage.findMinGiftPriceReduce();
        System.out.println("Самый дорогой подарок: " + maxPrice + ", Самый дешевый подарок: " + minPrice);

        // Сверяем найденные цены с ожидаемыми
        int expectedMax = Integer.parseInt(System.getProperty("expected.max.price", "0"));
        int expectedMin = Integer.parseInt(System.getProperty("expected.min.price", "0"));

        Assertions.assertEquals(expectedMax, maxPrice,
                "Самый дорогой подарок не совпадает с ожидаемым");
        Assertions.assertEquals(expectedMin, minPrice,
                "Самый дешевый подарок не совпадает с ожидаемым");
    }
}
