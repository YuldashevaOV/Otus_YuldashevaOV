package otus;

import com.google.inject.Inject;
import org.extensions.UIExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.pages.LoginPage;
import org.pages.MainPage;
import org.pages.UsersPage;
import org.prepare.User;

@ExtendWith(UIExtension.class)
public class UsersTest {

    @Inject
    private MainPage mainPage;

    @Inject
    private LoginPage loginPage;

    @Inject
    private UsersPage usersPage;

    @Inject
    private User user;

    @Test
    @DisplayName("Сценарий 2. Явные ожидания")
    public void checkUsersListLoading() {

        // Авторизация
        mainPage.open();
        loginPage.open();
        loginPage.loginAs(user.getUsername(), user.getPassword());
        loginPage.verifyUserIsLoggedIn();

        // Переход в раздел "Пользователи"
        usersPage.openUsers();
        usersPage.verifyUsersPage("Пользователи");

        //Ждем загрузки карточек пользователей
        usersPage.waitUsersCardBody();

        //Проверяем, что список не пустой
        Assertions.assertTrue(usersPage.getUsersCount() > 0);

        //Логаут
        usersPage.logout();
        loginPage.verifyLoginPage("Вход в систему");
    }
}
