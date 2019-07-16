package tst.project.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.alibaba.fastjson.JSON;

public class TengxunMapUtils {
	/**
	 * 通过经纬度反编译得到区
	 * @return
	 */
	public static Map<String, Object> geocoderDistrict(String key,String latitual_longitual){
		try{
			String Url = "https://apis.map.qq.com/ws/geocoder/v1/?location="+latitual_longitual+"&key="+key+"&get_poi=0";
			String str=HttpUtils.sendGet(Url);
			Map<String,Object> map=JSON.parseObject(str,Map.class);
			if("0".equals(map.get("status")+"")){
				Map<String,Object> resultMap=(Map) map.get("result");
				Map<String,Object> addressMap=(Map) resultMap.get("address_component");
				String district=addressMap.get("district")+"";
				
				Map reMap=new HashMap<String, Object>();
				reMap.put("district", district);
				reMap.put("adinfoBean", resultMap.get("ad_info"));
				return reMap;
			}else{
				return null;
			}
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	/**
	 * 根据地址 解析出经纬度
	 * @param key
	 * @param address
	 * @return
	 */
	public static Map<String,Object> geocoderLocation(String key,String address){
		try{
			String Url = "https://apis.map.qq.com/ws/geocoder/v1/?address="+address+"&key="+key;
			String str=HttpUtils.sendGet(Url);
			Map<String,Object> map=JSON.parseObject(str,Map.class);
			if("0".equals(map.get("status")+"")){
				Map<String,Object> resultMap=(Map) map.get("result");
				Map<String,Object> locationMap=(Map) resultMap.get("location");
				
				return locationMap;
			}else{
				return null;
			}
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	
	public static void main(String[] args) {
		//System.out.println(geocoderDistrict());
	}
}
