package hu.meiit.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserModelData {

	private String username;
	private String credit;
	private Map<String, String> school = new HashMap<String, String>();

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

	public Map<String, String> getSchool() {
		return school;
	}

	public void setSchool(Map<String, String> school) {
		this.school = school;
	}

}
