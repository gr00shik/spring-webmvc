package uz.avotech.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.avotech.domain.Context;
import uz.avotech.domain.User;
import uz.avotech.service.HomeService;
import uz.avotech.service.UserValidator;

//@Controller
//@RequestMapping(value = "/app")
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;
    private final Context context;
    private final UserValidator validator;

    @GetMapping(value = "/home")
    public String home(Model model, @ModelAttribute(name = "usermodel") User user) {

        context.setName("home");
        homeService.getTitle();
        model.addAttribute("name", "Sergey!");

//        ModelAndView modelAndView = new ModelAndView("home");
//        modelAndView.addObject("name", "Sergey");

        return "home";
    }

    @PostMapping("/info")
    public String info(@ModelAttribute(name = "usermodel") @Valid User user, BindingResult bindingResult,  Model model) {
        if (!bindingResult.hasErrors()) {
            model.addAttribute("usermodel" , new User());
        }

        homeService.save(user);

        return "home";
    }

    @GetMapping(value = "/book/{id}/{action}")
    public String path(@PathVariable(name = "id") String bookId, @PathVariable(name = "action") String actionName) {
        System.out.println();
        return "home";
    }

    @ExceptionHandler(Exception.class)
    public String processErrorLogin(Exception exc, Model model) {
        model.addAttribute("error", exc.getMessage());
        return "errorpage";
    }

//    @ExceptionHandler(PasswordException.class)
//    public String processErrorPassword() {
//        return "errorpage";
//    }

}
