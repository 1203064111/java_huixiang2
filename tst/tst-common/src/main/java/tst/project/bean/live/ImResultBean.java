package tst.project.bean.live;

public class ImResultBean {
	private String ActionStatus;
	private String ErrorInfo;
	private String ErrorCode;
	public String getActionStatus() {
		return ActionStatus;
	}
	public ImResultBean setActionStatus(String actionStatus) {
		ActionStatus = actionStatus;
		return this;
	}
	public String getErrorInfo() {
		return ErrorInfo;
	}
	public ImResultBean setErrorInfo(String errorInfo) {
		ErrorInfo = errorInfo;
		return this;
	}
	public String getErrorCode() {
		return ErrorCode;
	}
	public ImResultBean setErrorCode(String errorCode) {
		ErrorCode = errorCode;
		return this;
	}
}
