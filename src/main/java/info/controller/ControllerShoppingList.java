package info.controller;

import info.model.User;
import info.service.UserService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerShoppingList {

   private final UserService us;

    public ControllerShoppingList(UserService us) {
        this.us = us;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        System.out.println("_________________________________main");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new User());
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView backToMain() {
        System.out.println("_________________________________backToMain");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new User());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/check-user", method = RequestMethod.POST)
    public ModelAndView checkUserPost(@ModelAttribute("userJSP") User user) {
        System.out.println("_________________________________checkUserPost");
        ModelAndView modelAndView = new ModelAndView();
       if(us.addUser(user)){
           modelAndView.setViewName("secondPage");
       }else {
           modelAndView.setViewName("breack");
       }
        modelAndView.addObject("userJSP", user);
        return modelAndView;
    }

    @RequestMapping(value = "/enter", method = RequestMethod.POST)
    public ModelAndView enterUserPost(@ModelAttribute("userJSP") User user) {
        System.out.println("_________________________________enterUserPost");
        ModelAndView modelAndView = new ModelAndView();
        User updateUser = us.getUser(user);
        if(updateUser != null){
            modelAndView.setViewName("enter");
        }else {
            modelAndView.setViewName("enterBreack");
        }
        modelAndView.addObject("userJSP", updateUser);
        return modelAndView;
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        System.out.println("_________________________________register");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("createUserJSP", new User());
        modelAndView.setViewName("register");
        return modelAndView;
    }

    }

