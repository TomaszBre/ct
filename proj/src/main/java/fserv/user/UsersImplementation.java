package fserv.user;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fserv.database.DatabaseConnImplementation;

@Component
public class UsersImplementation implements Users {
	private DatabaseConnImplementation db;
	
	@Autowired
	public UsersImplementation(DatabaseConnImplementation db) {
		this.db = db;
	}

	@Override
	public List<User> getAllUsers() throws SQLException {
		return db.getAllUsers();
	}

	@Override
	public User getOneUser(int id) throws SQLException {
		return db.getOneUser(id);
	}

}
