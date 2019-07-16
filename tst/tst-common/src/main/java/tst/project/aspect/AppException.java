package tst.project.aspect;

public class AppException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String message;

	public AppException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
