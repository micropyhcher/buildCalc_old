package by.tms.buildCalc.controller;

import by.tms.buildCalc.entity.User;
import by.tms.buildCalc.service.ImplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/logform")
public class UserLoginController {

	@Autowired
	private ImplUserService userService;

	@GetMapping
	public ModelAndView logUser(ModelAndView modelAndView) {
		modelAndView.setViewName("userLogin");
		modelAndView.addObject("userFromLoginForm", new User());
		return modelAndView;
	}

	@PostMapping
	public ModelAndView userEnter(@Valid @ModelAttribute(name = "userFromLoginForm") User userFromLoginForm, BindingResult bindingResult,
                                  ModelAndView modelAndView, HttpServletRequest request) {

//		============================= ВАЛИДАЦИЯ ===============================
        List<String> logErrorList = new ArrayList<>();
		if (bindingResult.hasErrors()){
			modelAndView.setViewName("userLogin");
			List<FieldError> logError = bindingResult.getFieldErrors();

			for (int i = 0; i < logError.size(); i++){
				logErrorList.add(logError.get(i).getDefaultMessage());
			}
			modelAndView.addObject("errorLoginMessage", logErrorList);

//		========================== ПРОШЛИ ВАЛИДАЦИЮ ===========================

		}else{
			User userFromDB = userService.getUser(userFromLoginForm);
			System.out.println(userFromDB);
			if(userFromDB.getName() == null){
				modelAndView.setViewName("userLogin");
				logErrorList.add("Email или пароль не верны");
				modelAndView.addObject("errorLoginMessage", logErrorList);
			}else{
				request.getSession().setAttribute("userEnteredSession", userFromDB);
				modelAndView.setViewName("redirect:/list");
			}
		}
		return modelAndView;
	}
}
