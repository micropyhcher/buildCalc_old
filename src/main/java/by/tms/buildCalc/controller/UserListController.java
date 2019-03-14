package by.tms.buildCalc.controller;

import by.tms.buildCalc.entity.User;
import by.tms.buildCalc.service.ImplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/userlist")
public class UserListController {

    @Autowired
    private ImplUserService userService;

    @GetMapping
    public ModelAndView userListLobby (ModelAndView modelAndView){
        modelAndView.setViewName("userList");
        List<User> userList = userService.getUserList();
        boolean isUserListEmpty = true;
        if (!userList.isEmpty()){
            isUserListEmpty = false;
        }
        modelAndView.addObject("isUserListEmpty",isUserListEmpty);
        modelAndView.addObject("userList",userList);
        return modelAndView;
    }

//    @PostMapping
//    public ModelAndView userList (ModelAndView modelAndView, HttpSession httpSession){
//        modelAndView.setViewName("userList");
//
//        return modelAndView;
//    }
}
