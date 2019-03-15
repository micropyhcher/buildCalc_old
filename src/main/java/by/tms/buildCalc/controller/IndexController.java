package by.tms.buildCalc.controller;

import by.tms.buildCalc.entity.User;
import by.tms.buildCalc.service.ImplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping(path = "/")
public class IndexController {

	@Autowired
	private ImplUserService userService;

	@GetMapping
	public String index (){
//		modelAndView.setViewName("index");
		return "index";
	}

	@GetMapping(path = "list")
	public ModelAndView indexUserList(ModelAndView modelAndView, HttpServletResponse response, HttpServletRequest request, HttpSession httpSession){
		modelAndView.setViewName("index");

//		=============================== session ==============================================

//		httpSession = (HttpSession) request.getAttribute("userSession");
//		User userFromSession = (User) httpSession.getAttribute("userEnteredSession");
//		modelAndView.addObject("enteredUserFromSession",userFromSession);
//		System.out.println("index " + userFromSession);

//		========================= userList on index page ======================================
//
//		boolean isUserListEmpty = true;
//		if (userService.getUserList().isEmpty()){
//			modelAndView.setViewName("redirect:/");
//		}else{
//			isUserListEmpty = false;
//			ArrayList<User> userList = (ArrayList<User>) userService.getUserList();
//			User lastRegistereduser = userList.get(userList.size()-1);
//			modelAndView.addObject("userList",userList);
//			modelAndView.addObject("lastRegistereduser",lastRegistereduser);
//		}
//		modelAndView.addObject("isUserListEmpty",isUserListEmpty);

//		=========================================================================================

		return modelAndView;
	}
}
