package fserv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class MainViewController {
	
	@Autowired
	public MainViewController() {
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView showMainView() {
		return new ModelAndView("index", "", null);
	}
}
