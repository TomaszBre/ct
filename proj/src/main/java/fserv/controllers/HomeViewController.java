package fserv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/home")
public class HomeViewController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String showHomeView() {
		return "home";
	}

}
