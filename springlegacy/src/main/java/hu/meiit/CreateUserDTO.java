package hu.meiit;

import lombok.Data;

@Data
public class CreateUserDTO {

	private String username;
	private int credit;

	public CreateUserDTO() {

	}

	public CreateUserDTO(String username, int credit) {
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
