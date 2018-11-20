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
public class ShowTop10FilmsController {
	Films films;
	
	@Autowired
	public ShowTop10FilmsController(Films films) {
		this.films = films;
	}
	
	@RequestMapping(value="/top", method=RequestMethod.GET)
	public String showTop10Films(Model model) {
		try {
			model.addAttribute("films", films.getTop10Films());
		} catch (SQLException e) {
			System.out.println("Cann not display films." + e.getLocalizedMessage());
		} catch (Exception e) {
			System.out.println("Error in ShowUsersController");
		}
	
		return "data/films/showTop10Films";
	}

}
