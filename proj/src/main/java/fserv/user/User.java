package fserv.user;

import java.time.LocalDate;

public class User{
	private int id;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private LocalDate dateOfRegistration;
	private boolean activeUser;

	public User() {
	}
	
	public User(int id, String firstName, String lastName, String login, String password, LocalDate dateOfRegistration,
			boolean activeUser) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.dateOfRegistration = dateOfRegistration;
		this.activeUser = activeUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", login=" + login + ", password=" + password
				+ ", dateOfRegistration=" + dateOfRegistration + ", activeUser=" + activeUser + "]";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public LocalDate getDateOfRegistration() {
		return dateOfRegistration;
	}
	public void setDateOfRegistration(LocalDate dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
	public boolean isActiveUser() {
		return activeUser;
	}
	public void setActiveUser(boolean activeUser) {
		this.activeUser = activeUser;
	}


}
