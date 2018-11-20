package fserv.login;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fserv.database.DatabaseConn;
import fserv.user.User;

@Component
public class LoginImplementation implements Login {
	private DatabaseConn db;
	private User user;
	
	@Autowired
	public LoginImplementation(DatabaseConn db) {
		this.db = db;
		user = null;
	}

	@Override
	public LoginResult checkLoginDetails(UserLogin userLogin) {
		try {
			user = db.getLoggedUserIfLoginDetailsAreCorrect(userLogin);
		} catch (SQLException e) {
			return new LoginResult(false, "Wrong details provided.");
		}
		
		System.out.println("UZYTKOWNIK: " + user);
		return new LoginResult(true, "");
		
	}

	@Override
	public User getUser(String login) {
		return user;
	}

}
