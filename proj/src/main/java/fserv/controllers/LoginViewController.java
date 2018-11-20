package fserv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fserv.login.Login;
import fserv.login.LoginResult;
import fserv.login.UserLogin;

@Controller
@RequestMapping(value="/login")
public class LoginViewController {
	private Login login;
	
	@Autowired
	public LoginViewController(Login login) {
		this.login = login;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView showLoginView() {
		return new ModelAndView("login", "userLogin", new UserLogin());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String logUser(Model model, UserLogin userLogin) {
		LoginResult result = login.checkLoginDetails(userLogin);

		if (result.isResult()) {
			return "redirect:/home";
		}
		else {
			model.addAttribute("error", result.getErrorComment());
			return "login";
		}
			
	}

}
