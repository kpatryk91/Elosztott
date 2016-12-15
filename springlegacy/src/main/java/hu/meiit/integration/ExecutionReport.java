package hu.meiit.integration;

public class ExecutionReport {

	private boolean success;
	private String message;

	public ExecutionReport() {

	}

	public ExecutionReport(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ExecutionReport [success=" + success + ", message=" + message + "]";
	}

}
