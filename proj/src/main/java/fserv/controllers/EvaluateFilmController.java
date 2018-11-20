package fserv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fserv.film.Films;

@Controller
@RequestMapping(value="/evaluate")
public class EvaluateFilmController {
	private Films films;
	
	@Autowired
	public EvaluateFilmController(Films films) {
		this.films = films;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String evaluateMovie(
			@RequestParam("filmId") int id,
			@RequestParam("mark") int mark,
			Model model) {
		
		films.evaluateFilm(id, mark);
		
		return "redirect:/showFilms/" + id;
	}

}
