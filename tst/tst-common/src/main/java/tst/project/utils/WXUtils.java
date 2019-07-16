package tst.project.utils;

import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import tst.project.bean.wx.WXBean;
import tst.project.bean.wx.WXFansBean;
import tst.project.bean.wx.WXPayBean;
import tst.project.bean.wx.WXPubBean;
import tst.project.wx.RequestHandler;

public class WXUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(WXUtils.class);

	public static String getWXACodeUnlimit(String appid, String secret,String scene,String page,String path) {
		OutputStream os=null;
		try {
			String access_token = getAccess_token(appid, secret);

			String Url = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?"
					+ "access_token=" + access_token;
			Map<String, String> map=new HashMap<String, String>();
			map.put("scene", scene);
			if(page!=null){
				map.put("page", page);
			}
			String json=JSON.toJSONString(map);
			URL url = new URL(Url);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			//connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");  
			connection.setRequestProperty("Charset", "UTF-8");
			connection.connect();
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());

			out.write(json.getBytes("UTF-8"));
			out.flush();
			out.close();
			InputStream inputStream=connection.getInputStream();
			
			UUIDUtils uusUtils = new UUIDUtils(1);
			String fileName = uusUtils.nextId(false, 10)  +".png";
			
			// 2、保存到临时文件
			// 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			// 输出的文件流保存到本地文件

			File tempFile = new File(path);
			if (!tempFile.exists()) {
				tempFile.mkdirs();
			}
			os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
			// 开始读取
			while ((len = inputStream.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			return fileName;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 完毕，关闭所有链接
			try {
				if(os!=null){
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	/**
	 * 微信公众号支付下单
	 * 
	 * @param weixin_appid
	 *            微信appid
	 * @param weixin_secret
	 *            微信秘钥
	 * @param weixin_partnerkey
	 *            微信商户私钥
	 * @param weixin_mchid
	 *            微信商户号
	 * @param wx_pub_openid
	 *            用户openid
	 * @param order_pay_no
	 *            支付单号
	 * @param price
	 *            支付金额
	 * @param notify_url
	 *            回调链接
	 * @return
	 */
	public static Map<String, String> getWxPubPay(String weixin_appid, String weixin_secret, String weixin_partnerkey,
			String weixin_mchid, String wx_pub_openid, String order_pay_no, int price, String notify_url) {
		return getWxPubPay(weixin_appid, weixin_secret, weixin_partnerkey, weixin_mchid, wx_pub_openid, order_pay_no,
				price, notify_url, "商品购买", "商品购买");
		
	}

	/**
	 * 微信公众号支付下单
	 * 
	 * @param weixin_appid
	 *            微信appid
	 * @param weixin_secret
	 *            微信秘钥
	 * @param weixin_partnerkey
	 *            微信商户私钥
	 * @param weixin_mchid
	 *            微信商户号
	 * @param wx_pub_openid
	 *            用户openid
	 * @param order_pay_no
	 *            支付单号
	 * @param price
	 *            支付金额
	 * @param notify_url
	 *            回调链接
	 * @return
	 */
	public static Map<String, String> getWxPubPay(String weixin_appid, String weixin_secret, String weixin_partnerkey,
			String weixin_mchid, String wx_pub_openid, String order_pay_no, int price, String notify_url, String attach,
			String body) {
		// 设置微信原生支付所需参数
		String appid = weixin_appid;// "wxe5703c4e06a09cc8";
		String appsecret = weixin_secret; // merchantsWeiXinBean.getWeixin_appsecret();
		String partnerkey =weixin_partnerkey;// "HAYServices137670713564607753998";//merchantsWeiXinBean.getPartnerkey();
		String mch_id = weixin_mchid;// "1265437601";//merchantsWeiXinBean.getMch_id();
		String nonce_str = NumberUtils.createRandom(false, 32);
		String openid = wx_pub_openid;// memberBean2.getWx_pub_openid();
		String out_trade_no = order_pay_no;
		String spbill_create_ip = "127.0.0.1";

		String total_fee = String.valueOf(price);
		String trade_type = "JSAPI";
		String sign_type = "MD5";

		// 封装
		SortedMap<String, String> paraMap = new TreeMap<String, String>();
		paraMap.put("appid", appid);
		paraMap.put("attach", attach);
		paraMap.put("body", body);
		paraMap.put("mch_id", mch_id);
		paraMap.put("nonce_str", nonce_str);

		paraMap.put("openid", openid);
		paraMap.put("out_trade_no", out_trade_no);
		paraMap.put("spbill_create_ip", spbill_create_ip);
		paraMap.put("total_fee", total_fee);
		paraMap.put("trade_type", trade_type);
		paraMap.put("notify_url", notify_url);
		paraMap.put("sign_type", sign_type);

		// 签名
		RequestHandler reqHandler = new RequestHandler(null, null);
		reqHandler.init(appid, appsecret, partnerkey);
		String sign = reqHandler.createSign(paraMap);
		System.out.println("微信支付的参数为:------------------------"+new Gson().toJson(paraMap));
		paraMap.put("sign", sign);

		// 统一下单
		String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		String xml = WXUtils.ArrayToXml(paraMap);
		System.out.println(xml);
		System.out.println("-=========");
		String prepay_id = "";
		try {
			// 提交
			prepay_id = getPayNo(url, xml);//
			if (prepay_id.equals("")) {
				return null;
			} else {
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
		System.out.println("付款单号" + prepay_id);
		SortedMap<String, String> packageParams = new TreeMap<String, String>();

		// 需要再次签名，这里要加上时间戳
		String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
		String prepay_id2 = "prepay_id=" + prepay_id;
		String packages = prepay_id2;
		packageParams.put("appId", appid);
		packageParams.put("timeStamp", timestamp);
		packageParams.put("nonceStr", nonce_str);
		packageParams.put("package", packages);
		packageParams.put("signType", sign_type);
		String finalsign = reqHandler.createSign(packageParams);

		packageParams.put("paySign", finalsign);
		return packageParams;
	}

	public static String getPayNo(String url, String xmlParam) {
		String prepay_id = "";
		try {
			String result = HttpUtils.getDataByJson(url, xmlParam);
			if (result.indexOf("FAIL") != -1) {
				return prepay_id;
			}
			// Map map = doXMLParse(result);
			// String return_code = (String) map.get("return_code");
			Document document = XmlUtils.getDocumentByXml(result);
			prepay_id = XmlUtils.getValueByTagName(document, "prepay_id");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			

			System.out.println("------------------------------" + e.getMessage());
		}
		return prepay_id;
	}

	public static String ArrayToXml(Map<String, String> arr) {
		String xml = "<xml>";

		Iterator<Entry<String, String>> iter = arr.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, String> entry = iter.next();
			String key = entry.getKey();
			String val = entry.getValue();
			xml += "<" + key + ">" + val + "</" + key + ">";
		}

		xml += "</xml>";
		return xml;
	}

	/**
	 * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
	 * 
	 * @param strxml
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
	public static SortedMap<String, String> doXMLParse(String strxml) throws Exception {
		if (null == strxml || "".equals(strxml)) {
			return null;
		}
		strxml=filterXXE(strxml);
		
		SortedMap<String, String> m = new TreeMap<String, String>();
		InputStream in = String2Inputstream(strxml);
		SAXBuilder builder = new SAXBuilder();
		org.jdom.Document doc = builder.build(in);
		Element root = doc.getRootElement();
		List list = root.getChildren();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Element e = (Element) it.next();
			String k = e.getName();
			String v = "";
			List children = e.getChildren();
			if (children.isEmpty()) {
				v = e.getTextNormalize();
			} else {
				v = getChildrenText(children);
			}

			m.put(k, v);
		}

		// 关闭流
		in.close();

		return m;
	}
	
	public static String filterXXE(String xmlStr) {
		xmlStr = xmlStr.replace("DOCTYPE", "").replace("SYSTEM", "").replace("ENTITY", "").replace("PUBLIC", "");
		return xmlStr;
	}

	
	public static InputStream String2Inputstream(String str) {
		return new ByteArrayInputStream(str.getBytes());
	}
	
	/**
	 * 获取子结点的xml
	 * @param children
	 * @return String
	 */
	public static String getChildrenText(List children) {
		StringBuffer sb = new StringBuffer();
		if(!children.isEmpty()) {
			Iterator it = children.iterator();
			while(it.hasNext()) {
				Element e = (Element) it.next();
				String name = e.getName();
				String value = e.getTextNormalize();
				List list = e.getChildren();
				sb.append("<" + name + ">");
				if(!list.isEmpty()) {
					sb.append(getChildrenText(list));
				}
				sb.append(value);
				sb.append("</" + name + ">");
			}
		}
		
		return sb.toString();
	}
	/**
	 * 发送微信模板消息
	 * 
	 * @param access_token
	 */
	public static String sendTemplet(String access_token, String json) {
		try {
			String Url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + access_token;
			String result = HttpUtils.getDataByJson(Url, json);
			System.out.print(result);
			WXBean wxBean = JSON.parseObject(result, WXBean.class);
			if ("ok".equals(wxBean.getErrmsg())) {
				return result;
			} else {
				System.out.println("参数：" + json);
				System.out.println("错误信息：" + wxBean.getErrmsg());
				return wxBean.getErrmsg();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
	}

	/**
	 * 设置微信菜单
	 * 
	 * @return
	 */
	public static boolean settingMenu(String access_token, String json) {
		try {
			String Url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + access_token;
			String result = HttpUtils.getDataByJson(Url, json);
			WXBean wxBean = JSON.parseObject(result, WXBean.class);
			if ("ok".equals(wxBean.getErrmsg())) {
				return true;
			} else {
				System.out.println("参数：" + json);
				System.out.println("错误信息：" + wxBean.getErrmsg());
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 微信支付 MD5签名
	 * 
	 * @throws Exception
	 */
	public static WXPayBean wxMD5Sign(String appId, String key, String packageStr) throws Exception {
		String signType = "MD5";
		String nonceStr = NumberUtils.createRandom(false, 32);
		long timeStamp = Long.parseLong(String.valueOf(System.currentTimeMillis()).toString().substring(0, 10));

		String wait_sign = "appId=" + appId + "&nonceStr=" + nonceStr + "&package=" + packageStr + "&signType="
				+ signType + "&timeStamp=" + timeStamp + "&key=" + key;

		String paySign = MD5Util.md5EncodeOrigin(wait_sign).toUpperCase();

		WXPayBean wxPayBean = new WXPayBean();
		wxPayBean.setAppId(appId);
		wxPayBean.setNonceStr(nonceStr);
		wxPayBean.setPackageStr(packageStr);
		wxPayBean.setSignType(signType);
		wxPayBean.setTimeStamp(timeStamp + "");
		wxPayBean.setPaySign(paySign);

		return wxPayBean;
	}

	public static String getQrcode(String access_token, String content) {
		try {
			String Url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + access_token;
			String result = HttpUtils.getDataByJson(Url, "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\":"
					+ " {\"scene\": {\"scene_str\": \"" + content + "\"}}}");
			if (!result.equals("-1") && !result.equals("-2")) {
				try {
					WXBean wxBean = JSON.parseObject(result, WXBean.class);
					String url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + wxBean.getTicket();

					return url;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "-1";
				}
			} else {
				return result;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "-1";
		}
	}

	public static String getJsapi(String access_token) {
		try {
			String Url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + access_token
					+ "&type=jsapi";
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod(Url);
			post.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=ISO-8859-1");
			post.setRequestBody(new NameValuePair[] {});
			int statu = client.executeMethod(post);
			String str = post.getResponseBodyAsString();

			System.out.println("jsapi结果:" + str);

			if (statu == 200) {
				WXPubBean wxBean = JSON.parseObject(str, WXPubBean.class);
				if (wxBean.getErrcode().equals("0")) {
					return wxBean.getTicket();
				} else {
					return "";
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		return "";
	}

	public static String getAccess_token(String appid, String secret) {
		try {
			String Url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential" + "&appid=" + appid
					+ "&secret=" + secret;
			System.out.println(Url);
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod(Url);
			post.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			post.setRequestBody(new NameValuePair[] {});
			int statu = client.executeMethod(post);
			String str = post.getResponseBodyAsString();
			System.out.println("token结果:" + str);

			if (statu == 200) {
				WXPubBean wxBean = JSON.parseObject(str, WXPubBean.class);
				if (wxBean.getErrcode() == null) {
					return wxBean.getAccess_token();
				} else {
					return str;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		return "";
	}
	/**
	 * 微信小程序 根据code获得用户的信息
	 * 
	 * @param code
	 *            时效性是5分钟
	 */
	public static WXPubBean getWXLiteUserInfo(String appid, String secret, String code) {
		try {               
			String Url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+ "&js_code=" + code + "&grant_type=authorization_code";
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod(Url);
			post.setRequestBody(new NameValuePair[] {});
			int statu = client.executeMethod(post);
			String str = post.getResponseBodyAsString();
			System.out.println(str);
			if (statu == 200) {
				WXPubBean wxPubBean =JSON.parseObject(str, WXPubBean.class);
				if (wxPubBean.getErrcode() == null) {
					return wxPubBean;
				} else {
					return null;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}
	public static void main(String[] args) {
		
		WXPubBean wxBean =getWXUserInfo("wx1c89dc96687106ca","778f2e7eb1af3911797a7d926e9f6c8c","021SGJtj2D7K8H0217tj2XG0uj2SGJtV");
		System.out.println(new Gson().toJson(wxBean));
	}
	
	/**
	 * 微信公众号 根据code获得用户的信息
	 * 
	 * @param code
	 *            时效性是5分钟
	 */
	public static WXPubBean getWXUserInfo(String appid, String secret, String code) {
		try {
			String Url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid + "&secret=" + secret
					+ "&code=" + code + "&grant_type=authorization_code";
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod(Url);
			post.setRequestBody(new NameValuePair[] {});
			int statu = client.executeMethod(post);
			String str = post.getResponseBodyAsString();
			if (statu == 200) {
				WXPubBean wxBean = JSON.parseObject(str, WXPubBean.class);
				String result = getUserInfoByOenid(wxBean.getAccess_token(), wxBean.getOpenid());
				System.out.println(result+"------");
				if (!result.equals("")) {
					WXPubBean wxPubBean = JSON.parseObject(result, WXPubBean.class);
					if (wxPubBean.getErrcode() == null) {
						wxPubBean.setNickname(wxPubBean.getNickname().replaceAll("[\ue000-\uefff]", "...")
								.replaceAll("[\ud83c\udc00-\ud83c\udfff]", "...")
								.replaceAll("[\ud83d\udc00-\ud83d\udfff]", "...").replaceAll("[\u2600-\u27ff]", "..."));

						return wxPubBean;
					} else {
						return null;
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public static String getUserInfoByOenid(String ACCESS_TOKEN, String openID) {
		try {
			String Url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + ACCESS_TOKEN + "&openid=" + openID
					+ "&lang=zh_CN";
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod(Url);

			post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");

			post.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			post.setRequestBody(new NameValuePair[] {});

			int statu = client.executeMethod(post);
			String str = post.getResponseBodyAsString();

			if (statu == 200) {
				return str;
			} else {
				return "";
			}
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 获取关注公众号的粉丝列表
	 *
	 * @param access_token
	 *            调用接口凭证
	 * @param next_openid
	 *            第一个拉取的OPENID，不填默认从头开始拉取
	 * @return
	 */
	public static WXFansBean wxFans(String access_token, String next_openid) {
		if (null != access_token && !Objects.equals("", access_token)) {
			long startTime = System.currentTimeMillis();
			String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=" + access_token + "&next_openid="
					+ next_openid;
			HttpClient client = new HttpClient();
			GetMethod get = new GetMethod(url);
			get.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			try {
				int status = client.executeMethod(get);
				if (status == HttpStatus.SC_OK) {
					String response = get.getResponseBodyAsString();
					if (null != response && response.length() > 0) {
						WXFansBean wxFansBean = JSON.parseObject(response, WXFansBean.class);
						if (wxFansBean.getErrcode() == null) {
							LOGGER.info("get fans list success, access_token {}, use time {} ms, content {}",
									access_token, (System.currentTimeMillis() - startTime), wxFansBean);
							return wxFansBean;
						}
					}
				}
			} catch (IOException e) {
				LOGGER.error("get fans list error, access_token {}, next_openid {}", access_token, next_openid, e);
			}
		}
		return null;
	}
}
