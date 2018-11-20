package fserv.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import fserv.film.Film;
import fserv.login.UserLogin;
import fserv.user.User;

@Component
public class DatabaseConnImplementation implements DatabaseConn {
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://mysql31.mydevil.net/m1287_ct";
	String username = "m1287_tomekkbp";
	String pswd = "Haslo_ct12"; 
	Connection conn;
	
	public DatabaseConnImplementation() {
		
		//Checking if driver was located.
		try {
			checkDriver();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver was not found.");
		}
		
		//Establishing connection
		try {
			connectDB();
		} catch (SQLException e) {
			System.out.println("Database connection failed: " + e.getLocalizedMessage());
		}
	
		System.out.println("Database connected.");
		
	}
	
	@Override
	public void evaluateFilm(int filmId, int mark) throws SQLException {
		String sqlQuery = "INSERT INTO MARKS_B(F_ID, MARK) VALUES("
				+ "?,?)";
		
		try (PreparedStatement pStat = conn.prepareStatement(sqlQuery)) {
		pStat.setInt(1, filmId);
		pStat.setInt(2,  mark);
	
		pStat.execute();
		pStat.close();
		}
		
	}
	
	@Override
	public User getLoggedUserIfLoginDetailsAreCorrect(UserLogin userLogin) throws SQLException {
		String login = userLogin.getLogin();
		String password = userLogin.getPassword();
		
		String sqlQuery = "SELECT * FROM USERS_B WHERE LOGIN='" + login + "' AND PASSWORD='" + password + "'";
		
		try (Statement stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(sqlQuery)) {
				
		rs.next();
		
		User user = new User(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					"",
					rs.getDate(6).toLocalDate(),
					rs.getBoolean(7));
		
		stat.close();
		
		user.toString();
		
		return user;
		}
	}
	
	@Override
	public void addNewFilm(Film film) throws SQLException {
		String sqlQuery = "INSERT INTO FILMS_B(TITLE, DIRECTOR, ACTOR1, ACTOR2, DESCRIPTION) VALUES("
				+ "?,?,?,?,?)";
		
		try (PreparedStatement pStat = conn.prepareStatement(sqlQuery)) {
		pStat.setString(1, film.getTitle());
		pStat.setString(2,  film.getDirector());
		pStat.setString(3,  film.getActor1());
		pStat.setString(4,  film.getActor2());
		pStat.setString(5,  film.getDescription());
	
		pStat.execute();
		pStat.close();
		}
		
	}
	
	@Override
	public List<Film> getTop10Films() throws SQLException {
		String sqlQuery = "SELECT FILMS_B.*, SUM(MARKS_B.MARK) "
				+ "FROM FILMS_B LEFT JOIN MARKS_B ON FILMS_B.F_ID = MARKS_B.F_ID "
				+ "GROUP BY FILMS_B.F_ID, FILMS_B.TITLE, FILMS_B.DIRECTOR, FILMS_B.ACTOR1, FILMS_B.ACTOR2, FILMS_B.DESCRIPTION "
				+ "ORDER BY SUM(MARKS_B.MARK) DESC "
				+ "LIMIT 10";
				
		List<Film> list = new ArrayList<>();
		
		try (Statement stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(sqlQuery)) {
		
		
		while(rs.next()) {
			list.add(new Film(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getInt(7)));
		}
		
		return list;
		}
	}
	
	@Override
	public List<Film> getAllFilms() throws SQLException {
		String sqlQuery = "SELECT * FROM FILMS_B";
		List<Film> list = new ArrayList<>();
		
		try (Statement stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(sqlQuery)) {
		
		
		while(rs.next()) {
			list.add(new Film(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					0));
		}
		
		stat.close();
		rs.close();
		return list;
		}
		
	}
	
	@Override
	public Film getOneFilm(int id) throws SQLException {
		String sqlQuery = "SELECT * FROM FILMS_B WHERE F_ID=" + id;
		
		try (Statement stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(sqlQuery)) {
		
		
		rs.next();
		System.out.println("RS: " + rs.getString(2));
		
		Film film = new Film(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					0);
		
		stat.close();
		
		return film;
		}
	}
	
	@Override
	public User getOneUser(int id) throws SQLException {
		String sqlQuery = "SELECT * FROM USERS_B WHERE U_ID=" + id;
		
		try (Statement stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(sqlQuery)) {
	
		rs.next();
		System.out.println("RS: " + rs.getString(2));
		
		User user = new User(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					"",
					rs.getDate(6).toLocalDate(),
					rs.getBoolean(7));
		
		stat.close();
		return user;
		}
		
	}
	
	@Override
	public List<User> getAllUsers() throws SQLException {
		String sqlQuery = "SELECT * FROM USERS_B";
		List<User> list = new ArrayList<>();
		
		try (Statement stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(sqlQuery)) {
		
		while(rs.next()) {
			list.add(new User(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					"",
					rs.getDate(6).toLocalDate(),
					rs.getBoolean(7)));
		}
		
		stat.close();
		rs.close();
		return list;
		}
		
	}
	
	private void checkDriver() throws ClassNotFoundException {
		Class c = Class.forName(driver);
	}
	
	private void connectDB() throws SQLException {
		conn = DriverManager.getConnection(url, username, pswd);
		conn.setAutoCommit(true);
	}


}
