package fserv.login;

public class UserLogin {
	private String login;
	private String password;
	

	public UserLogin(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public UserLogin() {
	}
	
	@Override
	public String toString() {
		return "UserLogin [login=" + login + ", password=" + password + "]";
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
