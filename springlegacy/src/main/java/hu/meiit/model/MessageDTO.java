package hu.meiit.model;

public class MessageDTO {

	private String userid;
	private String message;

	public MessageDTO() {

	}

	public MessageDTO(String userid, String message) {
		super();
		this.userid = userid;
		this.message = message;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageDTO [userid=" + userid + ", message=" + message + "]";
	}

}
