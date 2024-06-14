package uz.avotech.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.avotech.domain.User;
import uz.avotech.errors.LoginException;
import uz.avotech.service.HomeService;

import java.util.List;

//@Controller
//@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final HomeService service;

    @RequestMapping(method = RequestMethod.GET)
    public String user() {

        List<User> all = service.getAll();

        return "user";
    }

    @GetMapping("/1")
    public String user1() {

        if (true) {
            throw new RuntimeException();
        }

        return "user";
    }

}
