package uz.avotech.service;

import org.springframework.stereotype.Component;
import uz.avotech.domain.User;

@Component
public class UserValidator {

    public void validate(User user) {
        String login = user.getLogin();
        if (login == null || login.isEmpty()) {
            throw new RuntimeException("login empty");
        }

        String password = user.getPassword();
        if (password == null || password.length() < 6) {
            throw new RuntimeException("password too short");
        }
    }

}
