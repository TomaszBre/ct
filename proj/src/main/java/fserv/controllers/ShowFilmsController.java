package fserv.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fserv.film.Films;

@Controller
public class ShowFilmsController {
	Films films;
	
	@Autowired
	public ShowFilmsController(Films films) {
		this.films = films;
	}
	

	
	@RequestMapping(value="/showFilms/{id}", method=RequestMethod.GET)
	public String evaluateFilm(
			@PathVariable("id") int id,
			Model model) {
		
		try {
			model.addAttribute("film", films.getOneFilm(id));
		} catch (SQLException e) {
			System.out.println("No such film.");
		}
		
		return "data/films/evaluateFilm";
		
	}
	
	@RequestMapping(value="/showFilms", method=RequestMethod.GET)
	public String showAllFilms(Model model) {
		try {
			model.addAttribute("films", films.getAllFilms());
		} catch (SQLException e) {
			System.out.println("Cann not display films." + e.getLocalizedMessage());
		} catch (Exception e) {
			System.out.println("Error in ShowUsersController");
		}
	
		return "data/films/showAllFilms";
	}

}
