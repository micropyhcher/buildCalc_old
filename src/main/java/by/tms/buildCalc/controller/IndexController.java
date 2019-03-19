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
	public String index(HttpServletRequest request) {
//		========================== создание сессии =============================
		if (request.getSession().isNew()){
			request.getSession().setAttribute("userEnteredSession", new User());
		}
		return "redirect:/list";
	}

	@GetMapping(path = "list")
	public ModelAndView indexList(ModelAndView modelAndView, HttpServletRequest request) {
		User userFromSession = (User) request.getSession().getAttribute("userEnteredSession");
		modelAndView.setViewName("index");
		if (userFromSession == null || userFromSession.equals(new User())){
			modelAndView.addObject("enteredUserFlag",false);
			modelAndView.addObject("enteredUser","Вы не авторизированы");
		}else{
			modelAndView.addObject("enteredUserFlag",true);
			modelAndView.addObject("enteredUser", userFromSession.getName() + " [" + userFromSession.getEmail() + "]");
		}
		return modelAndView;
	}

// =================================== for rev2 ===============================================
//	@GetMapping
//	public String index( ModelAndView modelAndView, HttpServletRequest request) {
//		modelAndView.setViewName("index");
////		========================== создание пустой сессии =============================
//
//		if (request.getSession().isNew()){
//			request.getSession().setAttribute("userEnteredSession", new User());
//		}
//
//	========================== проверка на то, залогинлся ли пользоваатель =============================
////	?????
//		return "index"; // ?????
//	}
//
//	@GetMapping(path = "guest")
//	public ModelAndView indexGuest(ModelAndView modelAndView, HttpServletRequest request) {
//		modelAndView.setViewName("index_guest");
//
//		return modelAndView;
//	}
//
//	@GetMapping(path = "user")
//	public ModelAndView indexUser(ModelAndView modelAndView, HttpServletRequest request) {
//		modelAndView.setViewName("index_user");
//		User userFromSession = (User) request.getSession().getAttribute("userEnteredSession");
//		if (userFromSession == null || userFromSession.equals(new User())){
//			modelAndView.addObject("enteredUserFlag",false);
//			modelAndView.addObject("enteredUser","Вы не авторизированы");
//		}else{
//			modelAndView.addObject("enteredUserFlag",true);
//			modelAndView.addObject("enteredUser", userFromSession.getName() + " [" + userFromSession.getEmail() + "]");
//		}
//		return modelAndView;
//	}
//
//	@GetMapping(path = "admin")
//	public ModelAndView indexAdmin(ModelAndView modelAndView, HttpServletRequest request) {
//		modelAndView.setViewName("index_admin");
//		return modelAndView;
//	}

	// ==============================================================================================

}
