package tst.project.utils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import tst.project.bean.hx.HXBean;
import tst.project.bean.hx.HXSettingBean;

public class HuanXinUtils {
	private static String url="https://a1.easemob.com/";
	/**
	 * 注册一个用户
	 */
	public static boolean registerOneUser(HXSettingBean hxSettingBean,
			String username, String password, String nickname) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url + hxSettingBean.getId() + "/"
				+ hxSettingBean.getName() + "/users");
		Response response = target
				.request()
				.buildPost(
						Entity.entity("{\"username\":\"" + username
								+ "\",\"password\":\"" + password
								+ "\",\"nickname\":\"" + nickname + "\"}",
								MediaType.APPLICATION_JSON)).invoke();
		response.accepted().header("Content-Type", "application/json");
		String value = response.readEntity(String.class);
		response.close(); // 关闭连接
		HXBean hxBean = new Gson().fromJson(value, HXBean.class);
		if (hxBean.getError() == null) {
			return true;
		}
		return false;
	}
	/**
	 * 注册一个用户
	 */
	public static boolean registerOneUser2(String hx_id,String hx_name,String username,String password){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url+hx_id+"/"+hx_name+"/users");
		Response response = target.request().buildPost(Entity.entity("{\"username\":\""+username+"\",\"password\":\""+password+"\",\"nickname\":\""+password+"\"}", MediaType.APPLICATION_JSON)).invoke();
		response.accepted().header("Content-Type", "application/json");
		String value = response.readEntity(String.class);
		response.close(); // 关闭连接	

		HXBean hxBean=JSON.parseObject(value, HXBean.class);
		if(hxBean.getError()==null){
			return true;
		}
		return false;
	}
}
