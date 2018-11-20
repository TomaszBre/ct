package fserv.login;

import fserv.user.User;

public interface Login {
	User getUser(String login);
	LoginResult checkLoginDetails(UserLogin userLogin);

}
