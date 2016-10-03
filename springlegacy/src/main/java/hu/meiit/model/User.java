package hu.meiit.model;

public class User {

	private String username;
	private String credit;

	public User() {

	}

	public User(String username, String credit) {
		super();
		this.username = username;
		this.credit = credit;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}
}
