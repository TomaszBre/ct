package fserv.film;

import java.sql.SQLException;
import java.util.List;

public interface Films {
	Film getOneFilm(int id) throws SQLException;
	List<Film> getAllFilms() throws SQLException;
	List<Film> getTop10Films() throws SQLException;
	void addNewFilm(Film film) throws SQLException;
	void evaluateFilm(int filmId, int mark);
}
