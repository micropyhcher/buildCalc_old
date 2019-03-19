package by.tms.buildCalc.controller;

import by.tms.buildCalc.entity.User;
import by.tms.buildCalc.service.ImplUserService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/unlog")
public class UserUnLoginController {

    @Autowired
    private ImplUserService userService;

    @GetMapping
    public String userList (HttpServletRequest request){
        request.getSession().setAttribute("userEnteredSession", new User());
        return "redirect:/list";
    }
}
