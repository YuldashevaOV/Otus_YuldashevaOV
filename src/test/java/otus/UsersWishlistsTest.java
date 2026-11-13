package otus;

import com.google.inject.Inject;
import org.extensions.UIExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebElement;
import org.pages.LoginPage;
import org.pages.UsersPage;
import org.pages.UsersWishlistsPage;
import org.prepare.User;

@ExtendWith(UIExtension.class)
public class UsersWishlistsTest {

    @Inject
    private LoginPage loginPage;

    @Inject
    private UsersPage usersPage;

    @Inject
    private User user;

    @Inject
    private UsersWishlistsPage usersWishlistsPage;

    @Test
    @DisplayName("Сценарий 3. Поиск пользователя и подсветка элемента")
    public void checkUserHighlightAndNavigate() {
        // Авторизация
        loginPage.open();
        loginPage.loginAs(user.getUsername(), user.getPassword());
        loginPage.verifyUserIsLoggedIn();

        // Переход в раздел "Пользователи"
        usersPage.openUsers();
        usersPage.verifyUsersPage("Пользователи");
        usersPage.waitUsersCardBody();
        Assertions.assertTrue(usersPage.getUsersCount() > 0);

        //Поиск второй карточки по логину. Клик + подсветка
        WebElement userCard = usersPage.findTargetUserCard();
        usersPage.clickViewWishlistsButton(userCard);
        usersWishlistsPage.verifyUsersWishlistsPage("Списки желаний пользователя");

        //Логаут
        usersWishlistsPage.logout();
        loginPage.verifyLoginPage("Вход в систему");
    }

}
