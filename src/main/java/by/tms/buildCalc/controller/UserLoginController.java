package by.tms.buildCalc.controller;

import by.tms.buildCalc.entity.User;
import by.tms.buildCalc.service.ImplUserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.HttpResource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
		modelAndView.addObject("userLogined", new User());
		return modelAndView;
	}

	@PostMapping
	public ModelAndView userEnter(@Valid @ModelAttribute(name = "userLogined") User userLogined, BindingResult bindingResult,
                                  ModelAndView modelAndView, HttpServletRequest request, HttpSession httpSession) {
        if (bindingResult.hasErrors()){
            modelAndView.setViewName("userLogin");
            List<FieldError> logError = bindingResult.getFieldErrors();
            List<String> logErrorList = new ArrayList<>();
            for (int i = 0; i < logError.size(); i++){
                logErrorList.add(logError.get(i).getDefaultMessage());
            }
            modelAndView.addObject("errorLoginMessage", logErrorList);
        }else{
            User userEntered = userService.getUser(userLogined);
            boolean isUserLogined = false;
            if(userEntered.getName().equals("Guest")){
                modelAndView.setViewName("userLogin");
                modelAndView.addObject("userEntered", "Email или пароль не верны");
            }else{
                modelAndView.setViewName("index");
                httpSession.setAttribute("userEnteredSession", userEntered);
                request.setAttribute("userSession",httpSession);
//                System.out.println("login - " + httpSession.getAttribute("userEnteredSession"));
                isUserLogined = true;
                modelAndView.addObject("isUserLogined", isUserLogined);
                modelAndView.addObject("userEntered", userEntered.getName() + ", " + userEntered.getEmail());
//			modelAndView.setViewName("redirect:/list");
            }
        }
		return modelAndView;
	}
}
