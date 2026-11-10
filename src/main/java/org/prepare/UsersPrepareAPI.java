package org.prepare;

import java.io.IOException;

/**
 * Формируем JSON из объекта User и отправляем запрос
 */

public class UsersPrepareAPI extends AbsRestClient {

    public void registerUser(User user) throws IOException, InterruptedException {
        String requestBody = String.format("{\"username\":\"%s\",\"email\":\"%s\",\"password\":\"%s\"}",
                user.getUsername(), user.getEmail(), user.getPassword());
        this.post("/api/auth/register", requestBody);
    }

}
