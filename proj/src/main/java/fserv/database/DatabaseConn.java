package fserv.database;

import java.sql.SQLException;
import java.util.List;

import fserv.film.Film;
import fserv.login.UserLogin;
import fserv.user.User;

public interface DatabaseConn {
	List<User> getAllUsers() throws SQLException;
	User getOneUser(int id) throws SQLException;
	
	List<Film> getAllFilms() throws SQLException;
	List<Film> getTop10Films() throws SQLException;
	Film getOneFilm(int id) throws SQLException;
	void addNewFilm(Film film) throws SQLException;
	
	User getLoggedUserIfLoginDetailsAreCorrect(UserLogin userLogin) throws SQLException;
	
	public void evaluateFilm(int filmId, int mark) throws SQLException;
	
	
}
