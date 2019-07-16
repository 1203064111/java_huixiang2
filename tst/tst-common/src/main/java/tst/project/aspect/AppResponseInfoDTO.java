package tst.project.aspect;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * App 响应DTO
 * 
 * @author Speed J
 *
 */
public class AppResponseInfoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	public AppResponseInfoDTO() {
		this.setFooterSuccessful(); // 默认是成功
	}

	private Map<String, Object> footer = new HashMap<String, Object>();

	private Object body;

	public static final String STATUS_SUCCESS_200 = "200"; // 成功标志
	public static final String FOOTER_STATUS = "status";
	public static final String FOOTER_MESSAGE = "message";
	public static final String FOOTER_ACTION_TYPE = "actionType";

	/**
	 * 系统异常
	 */
	public static final String STATUS_ERROR_600 = "600";

	public static final String MESSAGE_ERROR_600 = "系统繁忙,请稍后再试";

	/**
	 * 业务异常
	 */
	public static final String STATUS_ERROR_601 = "601";

	public static final String MESSAGE_ERROR_601 = "系统繁忙,请稍后再试";

	/**
	 * 设置成功方法 - 默认成功
	 */
	public void setFooterSuccessful() {
		footer.put(FOOTER_STATUS, STATUS_SUCCESS_200);
	}

	/**
	 * 设置失败 系统异常
	 */
	public void setFooterSystemError() {
		footer.put(FOOTER_STATUS, STATUS_ERROR_600);
		footer.put(FOOTER_MESSAGE, MESSAGE_ERROR_600);
	}

	/**
	 * 设置失败 系统异常
	 * 
	 * @param message
	 */
	public void setFooterSystemError(String message) {
		footer.put(FOOTER_STATUS, STATUS_ERROR_600);
		footer.put(FOOTER_MESSAGE, message);
	}

	/**
	 * 设置失败 系统异常
	 */
	public void setFooterBusinessError() {
		footer.put(FOOTER_STATUS, STATUS_ERROR_601);
		footer.put(FOOTER_MESSAGE, MESSAGE_ERROR_601);
	}

	/**
	 * 设置失败 系统异常
	 * 
	 * @param message
	 */
	public void setFooterBusinessError(String message) {
		footer.put(FOOTER_STATUS, STATUS_ERROR_601);
		footer.put(FOOTER_MESSAGE, message);
	}

	public void setFooterCustomError(String status, String message) {
		footer.put(FOOTER_STATUS, status);
		footer.put(FOOTER_MESSAGE, message);
	}

	public Map<String, Object> getFooter() {
		return footer;
	}

	public void setFooter(Map<String, Object> footer) {
		this.footer = footer;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

}
