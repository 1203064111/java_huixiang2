package tst.project.utils;



import com.alibaba.fastjson.JSON;

import tst.project.bean.live.ImResultBean;

public class TengxunImUtils {
	
	/**
	 * 独立模式导入账号
	 */
	public static boolean importAccount(String usersig,String identifier,String sdkappid,String json){
		String url="https://console.tim.qq.com/v4/im_open_login_svc/account_import";
		String result=HttpUtils.getDataByJson(url+"?usersig="+usersig+"&apn=1&identifier="+identifier+"&sdkappid="+sdkappid+"&contenttype=json", json);
		ImResultBean imResultBean=JSON.parseObject(result, ImResultBean.class);
		if(imResultBean!=null){
			if("OK".equals(imResultBean.getActionStatus())){
				return true;
			}
		}
		return false;
	}
}
