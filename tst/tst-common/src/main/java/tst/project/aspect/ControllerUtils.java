package tst.project.aspect;


public class ControllerUtils {

	/**
	 * 获取成功返回对象值
	 * 
	 * @return
	 */
	public static AppResponseInfoDTO getSuccessfulResponse() {
		AppResponseInfoDTO appResponseInfo = new AppResponseInfoDTO();
		appResponseInfo.setFooterSuccessful();
		return appResponseInfo;
	}

	public static AppResponseInfoDTO getSuccessfulResponse(Object body) {
		AppResponseInfoDTO appResponseInfo = getSuccessfulResponse();
		appResponseInfo.setBody(body);
		return appResponseInfo;
	}

	/**
	 * 获取失败消息返回对象值
	 * 
	 * @return
	 */
	public static AppResponseInfoDTO getErrorResponse() {
		AppResponseInfoDTO appResponseInfo = new AppResponseInfoDTO();
		appResponseInfo.setFooterSystemError();
		return appResponseInfo;
	}

	/**
	 * 获取失败消息返回对象值
	 * 
	 * @param errorMessage
	 *            错误消息
	 * @return
	 */
	public static AppResponseInfoDTO getErrorResponseWithMessage(String errorMessage) {
		AppResponseInfoDTO appResponseInfo = new AppResponseInfoDTO();
		appResponseInfo.setFooterSystemError(errorMessage);
		return appResponseInfo;
	}

	public static AppResponseInfoDTO getErrorResponseWithObject(Object body) {
		AppResponseInfoDTO appResponseInfo = getErrorResponse();
		appResponseInfo.setBody(body);
		return appResponseInfo;
	}

	public static AppResponseInfoDTO getErrorResponseWithMessageAndObject(String errorMessage, Object body) {
		AppResponseInfoDTO appResponseInfo = getErrorResponseWithMessage(errorMessage);
		appResponseInfo.setBody(body);
		return appResponseInfo;
	}

	public static AppResponseInfoDTO getErrorResponseWithKeyCodeAndMessageBody(String key, String errorMessage, Object body) {
		AppResponseInfoDTO appResponseInfo = new AppResponseInfoDTO();
		appResponseInfo.setFooterCustomError(key, errorMessage);
		appResponseInfo.setBody(body);
		return appResponseInfo;
	}

}
