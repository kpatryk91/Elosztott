package hu.meiit.model;

public class User {

	private String username;
	private int credit;

	public User() {

	}

	public User(String username, int credit) {
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

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
}
