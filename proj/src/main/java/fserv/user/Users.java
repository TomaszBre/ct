package fserv.user;

import java.sql.SQLException;
import java.util.List;

public interface Users {
	List<User> getAllUsers() throws SQLException;
	User getOneUser(int id) throws SQLException;
}
