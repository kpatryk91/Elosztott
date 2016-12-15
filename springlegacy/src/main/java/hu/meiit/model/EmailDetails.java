package hu.meiit.model;

public class EmailDetails {

	/**
	 * Userid
	 */
	private String addressee;

	/**
	 * Content of the message
	 */
	private String message;

	/**
	 * 0: email <br/>
	 * 1: inner message
	 */
	private int type;

	public EmailDetails() {

	}

	public EmailDetails(String addressee, String message, int type) {
		super();
		this.addressee = addressee;
		this.message = message;
		this.type = type;
	}

	public String getAddressee() {
		return addressee;
	}

	public void setaddressee(String addressee) {
		this.addressee = addressee;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "EmailDetails [addressee=" + addressee + ", message=" + message + ", type=" + type + "]";
	}

}
