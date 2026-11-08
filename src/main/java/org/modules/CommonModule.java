package org.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.prepare.User;
import org.prepare.UsersPrepareAPI;

/**
 * Регистрация юзера
 */

public class CommonModule extends AbstractModule {

    @Provides
    @Singleton
    public User getUser() {
        String customLogin = System.getProperty("login");
        String customPass = System.getProperty("password");

        //Запуск по дефолту, логин/пароль в pom либо можно указать в консоле
        if (customLogin != null && !customLogin.isEmpty() && customPass != null && !customPass.isEmpty()) {
            User user = new User();
            user.setUsername(customLogin);
            user.setPassword(customPass);
            return user;
        }

        // Если передаем пустой логин/пароль, то регистрируем юзера
        User user = new User();
        try {
            new UsersPrepareAPI().registerUser(user);
        } catch (Exception ignored) {

        }

        return user;
    }

}
