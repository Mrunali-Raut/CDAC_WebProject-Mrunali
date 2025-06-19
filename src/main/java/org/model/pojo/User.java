package org.model.pojo;

public class User {

	private String userName;
	private String password;
	private String name;
	private String email;
	private String city;

	public User() { }

	public User(String userName, String password, String name, String email, String city) {
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
		this.city = city;
	}

	// Getters and Setters

	public String getUserName() { return userName; }
	public void setUserName(String userName) { this.userName = userName; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }
}
