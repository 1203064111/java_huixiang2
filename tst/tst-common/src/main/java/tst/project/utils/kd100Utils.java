package tst.project.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.NameValuePair;

import com.alibaba.fastjson.JSON;

public class kd100Utils {

	public static void main(String[] args) {
		 Map<String, Object> maps=getLogisticss("bQGTkPob835","5003E96B81978360DFD590C1FD965370","yunda","3945820699470");
		 System.out.print(JSON.toJSONString(maps));
	}

	public static Map<String, Object> getLogisticss(String key,String customer,String com,String num) {
		try {
			String param = "{\"com\":\""+com+"\",\"num\":\""+num+"\"}";
			String sign = MD5Util.md5EncodeOrigin(param + key + customer).toUpperCase();
			HashMap params = new HashMap();
			params.put("param", param);
			params.put("sign", sign);
			params.put("customer", customer);
			String resp = HttpUtils.getDataByPost("http://poll.kuaidi100.com/poll/query.do",
					new NameValuePair[] { new NameValuePair("param", param), new NameValuePair("sign", sign),
							new NameValuePair("customer", customer) });
			Map<String, Object> map=JSON.parseObject(resp,Map.class);
			//System.out.println(resp);

			if("200".equals(map.get("status")+"")){
				//List<Map<String, Object>> resultMaps=(List<Map<String, Object>>) map.get("data");
				return map;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	};
}
