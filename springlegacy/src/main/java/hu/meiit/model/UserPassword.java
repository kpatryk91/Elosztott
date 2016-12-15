package hu.meiit.model;

public class UserPassword {

	private String userid;

	public UserPassword() {

	}

	public UserPassword(String userid) {
		super();
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "UserPassword [userid=" + userid + "]";
	}

}
