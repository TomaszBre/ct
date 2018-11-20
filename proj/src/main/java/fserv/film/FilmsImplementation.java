package fserv.film;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fserv.database.DatabaseConn;

@Component
public class FilmsImplementation implements Films {
	private DatabaseConn db;
	
	@Autowired
	public FilmsImplementation(DatabaseConn db) {
		this.db = db;
	}

	@Override
	public List<Film> getAllFilms() throws SQLException {
		return db.getAllFilms();
	}

	@Override
	public List<Film> getTop10Films() throws SQLException {
		return db.getTop10Films();
	}

	@Override
	public void addNewFilm(Film film) throws SQLException {
		db.addNewFilm(film);
		
	}

	@Override
	public Film getOneFilm(int id) throws SQLException {
		return db.getOneFilm(id);
	}

	@Override
	public void evaluateFilm(int filmId, int mark) {
		System.out.println("Film id: " + filmId + ", ocena: " + mark);
		try {
			db.evaluateFilm(filmId, mark);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	


}
