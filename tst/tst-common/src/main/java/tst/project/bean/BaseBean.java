package tst.project.bean;

public class BaseBean {
	private String status;
	private String error;
	private Object data;
	private Object extra;
	private int total;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}

	public Object getData() {
		return data;
	}
	public BaseBean setData(Object data) {
		this.data = data;
		return this;
	}
	
	public Object getExtra() {
		return extra;
	}
	public BaseBean setExtra(Object extra) {
		this.extra = extra;
		return this;
	}
	public int getTotal() {
		return total;
	}
	public BaseBean setTotal(int total) {
		this.total = total;
		return this;
	}
	
	
}
