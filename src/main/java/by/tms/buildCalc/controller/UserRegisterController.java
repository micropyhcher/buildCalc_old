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
		modelAndView.addObject("userFromRegForm",new User());
		return modelAndView;
	}

	@PostMapping
	public ModelAndView userList (@Valid @ModelAttribute("userFromRegForm") User userFromRegForm,
	                              BindingResult bindingResult,
	                              ModelAndView modelAndView){

//		============================= ВАЛИДАЦИЯ ===============================

		if (bindingResult.hasErrors()){
			modelAndView.setViewName("userRegister");
			List<FieldError> regError = bindingResult.getFieldErrors();
			List<String> regErrorList = new ArrayList<>();
			for (int i = 0; i < regError.size(); i++){
				regErrorList.add(regError.get(i).getDefaultMessage());
			}
			modelAndView.addObject("errorRegisterMessage", regErrorList);

//		========================== ПРОШЛИ ВАЛИДАЦИЮ ===========================

		}else{
			boolean isUserSaved = userService.saveUser(userFromRegForm);
			if (isUserSaved == true){ // если сохранение прошло успешно (вернулось true)
				modelAndView.setViewName("redirect:/list");
			}else{  // если сохранение не удалось (вернулось false), значит пользователь с введенными данными уже существует
				modelAndView.setViewName("userRegister");
				modelAndView.addObject("errorRegisterMessage_doubleUser", "Пользователь с таким E-Mail уже зарегистрирован в сиситеме");
			}
		}
		return modelAndView;
	}
}
