package by.tms.buildCalc.controller;

import by.tms.buildCalc.entity.User;
import by.tms.buildCalc.service.ImplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/regform")
public class UserRegisterController {

	@Autowired
	private ImplUserService userService;

	@GetMapping
	public ModelAndView regUser (ModelAndView modelAndView){
		modelAndView.setViewName("userRegister");
		modelAndView.addObject("newUser",new User());
		return modelAndView;
	}

	@PostMapping
	public ModelAndView userList (@Valid @ModelAttribute("newUser") User newUser,
	                              BindingResult bindingResult,
	                              ModelAndView modelAndView){
		boolean isUserAdd = false;
		if (bindingResult.hasErrors()){
			modelAndView.setViewName("userRegister");
			List<FieldError> regError = bindingResult.getFieldErrors();
			List<String> regErrorList = new ArrayList<>();
			for (int i = 0; i < regError.size(); i++){
				regErrorList.add(regError.get(i).getDefaultMessage());
			}
			modelAndView.addObject("errorRegisterMessage", regErrorList);
		}else{
			if (userService.saveUser(newUser)){
				modelAndView.setViewName("redirect:/list");
			}else{
				modelAndView.setViewName("userRegister");
				modelAndView.addObject("errorRegisterMessage_doubleUser", "Пользователь с таким E-Mail уже зарегистрирован в сиситеме");
			}
		}
		return modelAndView;
	}
}
