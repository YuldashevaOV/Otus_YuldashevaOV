package org.prepare;

import com.github.javafaker.Faker;

/**
 * Модель юзера
 */

public class User {

    private Faker faker = new Faker();

    private String username = "";
    private String password = "";
    private String email = "";


    public User() {
        this.username = faker.name().username();
        this.password = faker.regexify("[a-zA-Z0-9]{10}");
        this.email = faker.internet().emailAddress();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }
}
