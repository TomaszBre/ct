package fserv.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fserv.user.Users;

@Controller
public class ShowUsersController {
	private Users users;
	
	@Autowired
	public ShowUsersController(Users users) {
		this.users = users;
	}
	
	@RequestMapping(value="/showUsers/{id}", method=RequestMethod.GET)
	public String showOneUser(
			@PathVariable("id") int id,
			Model model) {
		
		try {
			model.addAttribute("user", users.getOneUser(id));
		} catch (SQLException e) {
			System.out.println("No such user");
		}
		
		return "data/users/showUser";
	}
	
	@RequestMapping(value="/showUsers", method=RequestMethod.GET)
	public String showAllUsers(Model model) {
		try {
			model.addAttribute("users", users.getAllUsers());
		} catch (SQLException e) {
			System.out.println("Cann not display users.");
		} catch (Exception e) {
			System.out.println("Error in ShowUsersController");
		}
	
		return "data/users/showAllUsers";
	}
	
	

}
