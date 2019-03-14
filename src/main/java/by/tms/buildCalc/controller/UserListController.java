package by.tms.buildCalc.controller;

import by.tms.buildCalc.entity.User;
import by.tms.buildCalc.service.ImplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/userlist")
public class UserListController {

    @Autowired
    private ImplUserService implUserService;

    @GetMapping
    public ModelAndView userListLobby (ModelAndView modelAndView, HttpSession httpSession){
//        User loginnedUser = (User) httpSession.getAttribute("userEnteredSession");
        modelAndView.setViewName("userList");
        modelAndView.addObject("newUser",new User());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView userList (ModelAndView modelAndView, HttpSession httpSession){
        modelAndView.setViewName("userList");
        User loginnedUser = (User) httpSession.getAttribute("userEnteredSession");
        modelAndView.addObject("loginnedUser", loginnedUser);
        return modelAndView;
    }
}
