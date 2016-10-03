package hu.meiit;

import java.util.List;

import hu.meiit.model.NEM;
import hu.meiit.model.School;
import lombok.Data;

@Data
public class CreateUserDTO {

	private String username;
	private String credit;
	private School school;
	private List<String> favcol;
	private NEM gend;

	public CreateUserDTO() {

	}

	public CreateUserDTO(String username, String credit) {
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

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public List<String> getFavcol() {
		return favcol;
	}

	public void setFavcol(List<String> favcol) {
		this.favcol = favcol;
	}

	public NEM getGender() {
		return gend;
	}

	public void setGender(NEM gender) {
		this.gend = gender;
	}

}
