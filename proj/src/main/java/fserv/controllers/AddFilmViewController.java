package fserv.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fserv.film.Film;
import fserv.film.Films;
import fserv.user.Users;

@Controller
@RequestMapping(value="/addFilm")
public class AddFilmViewController {
	private Films filmsBase;
	
	@Autowired
	public AddFilmViewController(Films filmsBase) {
		this.filmsBase = filmsBase;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView showRegistrationView() {
		return new ModelAndView("addFilm", "addFilm", new Film());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String registerUser(Model model, Film film) {
		String errorMessage = "";
		
		try {
			filmsBase.addNewFilm(film);
		} catch (SQLException e) {
			errorMessage = "ERROR: " + e.getLocalizedMessage();
			System.out.println(errorMessage);
			model.addAttribute("addFilm", new Film());
			model.addAttribute("error", errorMessage);
			return "/addFilm";
		}
		
		return "redirect:/showFilms";
	}
	
	

}
