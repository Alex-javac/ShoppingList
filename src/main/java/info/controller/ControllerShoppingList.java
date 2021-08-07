package info.controller;

import info.model.User;
import info.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerShoppingList {

    private final UserService userService;

    public ControllerShoppingList(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new User());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView backToMain() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new User());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/check-user", method = RequestMethod.POST)
    public ModelAndView checkUserPost(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        if (userService.addUser(user)) {
            modelAndView.setViewName("secondPage");
        } else {
            modelAndView.setViewName("break");
        }
        modelAndView.addObject("userJSP", user);
        return modelAndView;
    }

    @RequestMapping(value = "/enter", method = RequestMethod.POST)
    public ModelAndView enterUserPost(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        User updateUser = userService.getUser(user);
        if (updateUser != null) {
            modelAndView.setViewName("enter");
        } else {
            modelAndView.setViewName("enterBreak");
        }
        modelAndView.addObject("userJSP", updateUser);
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("createUserJSP", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/shopList", method = RequestMethod.POST)
    public ModelAndView shopList(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", user);
        modelAndView.setViewName("shopList");
        return modelAndView;
    }
}

