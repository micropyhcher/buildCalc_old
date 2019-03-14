package by.tms.buildCalc.controller;

import by.tms.buildCalc.entity.User;
import by.tms.buildCalc.service.ImplUserService;
import by.tms.buildCalc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/logform")
public class UserLoginController {

	@Autowired
	private ImplUserService implUserService;

	@GetMapping
	public ModelAndView logUser(ModelAndView modelAndView) {
		modelAndView.setViewName("userLogin");
		modelAndView.addObject("userLogined", new User());
		return modelAndView;
	}

	@PostMapping
	public ModelAndView userEnter(@ModelAttribute(name = "userLogined") User userLogined,
	                              ModelAndView modelAndView, HttpSession httpSession) {
		User userEntered = implUserService.getUser(userLogined);
		boolean isUserLogined = false;
		if(userEntered.getName().equals("Guest")){
			modelAndView.setViewName("userLogin");
			modelAndView.addObject("userEntered", "Email или пароль не верны");
		}else{
//			modelAndView.setViewName("index");
//			isUserLogined = true;
			httpSession.setAttribute("userEnteredSession", userEntered);
			modelAndView.addObject("userEntered", userEntered);
//            modelAndView.addObject("isUserLogined", isUserLogined);
			modelAndView.setViewName("redirect:/list");
		}
		return modelAndView;
	}
}
