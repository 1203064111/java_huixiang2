package tst.project.utils;


import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alipay.api.domain.Member;

import io.rong.RongCloud;
import io.rong.methods.message.history.History;
import io.rong.methods.user.User;
import io.rong.methods.user.onlinestatus.OnlineStatus;
import io.rong.models.Result;
import io.rong.models.response.CheckOnlineResult;
import io.rong.models.response.HistoryMessageResult;
import io.rong.models.response.TokenResult;
import io.rong.models.user.UserModel;

public class RongCloudUtils {

	public static void main(String[] args) {

//		 Map<String, Object> map=new HashMap<String, Object>();
//		 map.put("userId", "1000");
//		 map.put("name", "沈佳波2");
//		 map.put("portraitUri","http://img-blh.tstweiguanjia.com/20181207/2141716870909133830.jpg");
//		 onlineMember("6tnym1br64ei7","pdhVrzt25w7Pxq","1000");
		
		historyRecord("6tnym1br64ei7","pdhVrzt25w7Pxq",null);
	}
	/**
	 * 注册一个用户
	 */
	public static String historyRecord(String appKey,String appSecret, Map<String, Object> map) {
		try{	
			RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
			History history=rongCloud.message.history;
//			for (int i = 1; i < 31; i++) {
//				
//				
//				for (int j = 1; j < 25; j++) {
//					String str="201812"+(i<10?"0"+i:i);
//					str+=(j<10?"0"+j:j);
//					HistoryMessageResult result=history.get(str);
//					System.out.println(JSON.toJSONString(result));
//				}
//			}
			
			HistoryMessageResult result=history.get("2018010511");
			System.out.println(JSON.toJSONString(result));
			
//			if(result.getCode()==200){
//				return result.getToken();
//			}else{
//				System.out.println(result.getMsg());
//			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	/**
	 * 注册一个用户
	 */
	public static String registerMember(String appKey,String appSecret, Map<String, Object> map) {
		try{	
			RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
			User userUtils = rongCloud.user;
			UserModel user = new UserModel().setId(map.get("userId")+"").setName(map.get("name")+"")
					.setPortrait(map.get("portraitUri")+"");
			TokenResult result = userUtils.register(user);
			System.out.println(JSON.toJSONString(result));
			if(result.getCode()==200){
				return result.getToken();
			}else{
				System.out.println(result.getMsg());
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**
	 * 更新用户信息
	 * @param appKey
	 * @param appSecret
	 * @param map
	 */
	public static void updateMember(String appKey,String appSecret, Map<String, Object> map) {
		try{	
			RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
			User userUtils = rongCloud.user;
			UserModel user = new UserModel().setId(map.get("userId")+"").setName(map.get("name")+"")
					.setPortrait(map.get("portraitUri")+"");
			Result result=userUtils.update(user);
			System.out.println("getToken:  " + result.toString());
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * 用户是否在线
	 * @param appKey
	 * @param appSecret
	 * @param map
	 */
	public static String onlineMember(String appKey,String appSecret, String userId) {
		try{	
			RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
			OnlineStatus userUtils = rongCloud.user.onlineStatus;
			UserModel user = new UserModel().setId(userId);
			CheckOnlineResult result=userUtils.check(user);
			if(result.code==200){
				return result.getStatus();
			}
			System.out.println("getToken:  " + result.toString());
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "0";
	}
}
