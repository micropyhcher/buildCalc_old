package by.tms.buildCalc.controller;

import by.tms.buildCalc.entity.User;
import by.tms.buildCalc.service.ImplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/")
public class IndexController {

	@Autowired
	private ImplUserService userService;

	@GetMapping
	public String index() {
//		modelAndView.setViewName("index");
		return "index";
	}

	@GetMapping(path = "list")
	public ModelAndView indexUserList(ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView.setViewName("index");
		User userFromSession = (User) request.getSession().getAttribute("userEnteredSession");
		modelAndView.addObject("enteredUser", userFromSession.getName() + " [" + userFromSession.getEmail() + "]");
		return modelAndView;
	}
}
