package uz.avotech.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import uz.avotech.errors.LoginException;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(LoginException.class)
    public ModelAndView handleLoginException(LoginException ex) {
        ModelAndView view = new ModelAndView("errorpage");
        view.addObject("test", "hello");

        return view;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleLoginException(Exception ex) {
        ModelAndView view = new ModelAndView("errorpage");
        view.addObject("test", "hello");
        return view;
    }

}
