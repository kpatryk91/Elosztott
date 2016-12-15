package hu.meiit.integration;

import java.util.ArrayList;
import java.util.List;

public class UserDetails {

	private String userid;
	private String email;
	private String detail;
	private List<String> messages;

	public UserDetails() {

	}

	public UserDetails(String userid, String email, String detail, List<String> messages) {
		super();
		this.userid = userid;
		this.email = email;
		this.detail = detail;
		this.messages = messages;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(String message) {
		if (this.messages == null) {
			this.messages = new ArrayList<String>(10);
		}
		this.messages.add(message);
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
