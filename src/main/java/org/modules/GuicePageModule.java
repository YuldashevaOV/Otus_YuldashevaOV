package org.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.openqa.selenium.WebDriver;
import org.pages.*;

public class GuicePageModule extends AbstractModule {

    private WebDriver driver;

    public GuicePageModule(WebDriver driver) {
        this.driver = driver;
    }

    @Provides
    @Singleton
    public MainPage getMainPage() {
        return new MainPage(driver);
    }

    @Provides
    @Singleton
    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    @Provides
    @Singleton
    public WishlistPage getWishlistPage() {
        return new WishlistPage(driver);
    }

    @Provides
    @Singleton
    public UsersPage getUsersPage() {
        return new UsersPage(driver);
    }

    @Provides
    @Singleton
    public UsersWishlistsPage getUsersWishlists() {
        return new UsersWishlistsPage(driver);
    }

}
