package tst.project.utils;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.google.gson.Gson;

import tst.project.aspect.AppException;
import tst.project.wx.RequestHandler;

public class PayUtils {

	public static void main222(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("path", "/mnt/tomcat/images/clue/" + "wx_lite.p12");
		map.put("mchid", "1528445061");
		map.put("mch_appid", "wxaabd3b03228d10b9");

		map.put("openid", "ofc4-5a36e08CWsD_IE771sBOlwQ");
		map.put("partner_trade_no", "p12345678");// total_fee
		map.put("amount", 30);
		map.put("desc", "提现");
		map.put("wx_appsecret", "c3054f08b2838303550315e5de165039");
		map.put("wx_partnerkey", "wvgvfuy6e17r67m6h6yp9axa1f7b4ca4");

		Map<String, Object> resultMap = PayUtils.transfers(map);
		System.out.print(JSON.toJSON(resultMap));
	}

	/**
	 * 企业付款
	 * 
	 * @param map
	 */
	public static Map<String, Object> transfers(Map<String, Object> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			String path = map.get("path") + "";
			String mchid = map.get("mchid") + "";
			String mch_appid = map.get("mch_appid") + "";
			String nonce_str = NumberUtils.createRandom(false, 30);
			String openid = map.get("openid") + "";
			String partner_trade_no = map.get("partner_trade_no") + "";
			String check_name = "NO_CHECK";
			String amount = map.get("amount") + "";
			String desc = map.get("desc") + "";
			String spbill_create_ip = "120.76.230.149";

			SortedMap<String, String> packageParams = new TreeMap<String, String>();
			packageParams.put("mchid", mchid);
			packageParams.put("mch_appid", mch_appid);
			packageParams.put("nonce_str", nonce_str);
			packageParams.put("openid", openid);
			packageParams.put("partner_trade_no", partner_trade_no);
			packageParams.put("check_name", check_name);
			packageParams.put("amount", amount);
			packageParams.put("desc", desc);
			packageParams.put("spbill_create_ip", spbill_create_ip);

			String secret = map.get("wx_appsecret") + "";
			String partnerkey = map.get("wx_partnerkey") + "";

			/*----2.根据package生成签名sign---- */
			RequestHandler reqHandler = new RequestHandler(null, null);
			reqHandler.init(mch_appid, secret, partnerkey);
			String sign = reqHandler.createSign(packageParams);
			System.out.println("sign=" + sign);
			/*----3.拼装需要提交到微信的数据xml---- */
			String xml = "<xml>" + "<mchid>" + mchid + "</mchid>" + "<mch_appid>" + mch_appid + "</mch_appid>"
					+ "<nonce_str>" + nonce_str + "</nonce_str>" + "<openid>" + openid + "</openid>"
					+ "<partner_trade_no>" + partner_trade_no + "</partner_trade_no>" + "<check_name>" + check_name
					+ "</check_name>" + "<amount>" + amount + "</amount>" + "<desc>" + desc + "</desc>"
					+ "<spbill_create_ip>" + spbill_create_ip + "</spbill_create_ip>" + "<sign>" + sign + "</sign>"
					+ "</xml>";

			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			FileInputStream instream = new FileInputStream(new File(path));
			try {
				keyStore.load(instream, mchid.toCharArray());
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				instream.close();
			}
			// Trust own CA and all self-signed certs
			@SuppressWarnings("deprecation")
			SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, mchid.toCharArray()).build();
			// Allow TLSv1 protocol only
			@SuppressWarnings("deprecation")
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" },
					null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			/*----5.发送数据到微信的退款接口---- */
			String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
			HttpPost httpost = new HttpPost(url); // 设置响应头信息
			httpost.setEntity(new StringEntity(xml, "UTF-8"));
			HttpResponse weixinResponse = httpClient.execute(httpost);
			if (weixinResponse.getEntity() == null) {
				resultMap.put("status", "error");
				resultMap.put("error", "无响应");
				return resultMap;
			}

			String jsonStr = EntityUtils.toString(weixinResponse.getEntity(), "UTF-8");

			Document document = XmlUtils.getDocumentByXml(jsonStr);
			String return_code = XmlUtils.getValueByTagName(document, "return_code");
			String return_msg = XmlUtils.getValueByTagName(document, "return_msg");
			String result_code = XmlUtils.getValueByTagName(document, "result_code");
			String err_code_des = XmlUtils.getValueByTagName(document, "err_code_des");

			if ("FAIL".equals(return_code)) {
				if ("invalid total_fee".equals(return_msg)) {
					resultMap.put("status", "error");
					resultMap.put("error", "无效的总金额");
					return resultMap;
				} else {
					resultMap.put("status", "error");
					resultMap.put("error", return_msg);
					return resultMap;
				}
			} else {
				if ("FAIL".equals(result_code)) {
					resultMap.put("status", "error");
					resultMap.put("error", err_code_des);
					return resultMap;
				}
			}
		} catch (Exception e) {
			resultMap.put("status", "error");
			resultMap.put("error", e.getMessage());
			return resultMap;
		}

		resultMap.put("status", "ok");
		return resultMap;
	}

	/**
	 * 微信小程序支付下单
	 * 
	 * @return
	 */
	public static Map<String, String> wxLitePay(Map<String, Object> map) {
		// 设置微信原生支付所需参数
		String appid = map.get("wx_lite_appid") + "";// "wxe5703c4e06a09cc8";
		String appsecret = map.get("wx_lite_appsecret") + ""; // merchantsWeiXinBean.getWeixin_appsecret();
		String partnerkey = map.get("wx_lite_partnerkey") + "";// "HAYServices137670713564607753998";//merchantsWeiXinBean.getPartnerkey();
		String mch_id = map.get("wx_lite_mch_id") + "";// "1265437601";//merchantsWeiXinBean.getMch_id();
		String nonce_str = NumberUtils.createRandom(false, 32);
		String openid = map.get("wx_lite_openid") + "";// memberBean2.getWx_pub_openid();
		String out_trade_no = map.get("out_trade_no") + "";
		String spbill_create_ip = "172.168.0.1";

		String total_fee = map.get("total_fee") + "";
		String trade_type = "JSAPI";
		String sign_type = "MD5";

		// 封装
		SortedMap<String, String> paraMap = new TreeMap<String, String>();
		paraMap.put("appid", appid);
		paraMap.put("attach", StringUtils.isNull(map.get("attach") + "") ? "商品购买" : map.get("attach") + "");
		paraMap.put("body", StringUtils.isNull(map.get("body") + "") ? "商品购买" : map.get("body") + "");
		paraMap.put("mch_id", mch_id);
		paraMap.put("nonce_str", nonce_str);

		paraMap.put("openid", openid);
		paraMap.put("out_trade_no", out_trade_no);
		paraMap.put("spbill_create_ip", spbill_create_ip);
		paraMap.put("total_fee", total_fee);
		paraMap.put("trade_type", trade_type);
		paraMap.put("notify_url", map.get("wx_lite_notify_url") + "");
		paraMap.put("sign_type", sign_type);

		// 签名
		RequestHandler reqHandler = new RequestHandler(null, null);
		reqHandler.init(appid, appsecret, partnerkey);
		String sign = reqHandler.createSign(paraMap);
		paraMap.put("sign", sign);

		// 统一下单
		String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		String xml = WXUtils.ArrayToXml(paraMap);
		System.out.println(xml);
		System.out.println("-=========");
		String prepay_id = "";
		try {
			// 提交
			prepay_id = getPayNo(url, xml);
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

	/**
	 * 微信小程序支付下单
	 * 
	 * @return
	 */
	public static Map<String, String> wxPubPay(Map<String, Object> map) {
		// 设置微信原生支付所需参数
		String appid = map.get("wx_pub_appid") + "";// "wxe5703c4e06a09cc8";
		String appsecret = map.get("wx_pub_appsecret") + ""; // merchantsWeiXinBean.getWeixin_appsecret();
		String partnerkey = map.get("wx_pub_partnerkey") + "";// "HAYServices137670713564607753998";//merchantsWeiXinBean.getPartnerkey();
		String mch_id = map.get("wx_pub_mch_id") + "";// "1265437601";//merchantsWeiXinBean.getMch_id();
		String nonce_str = NumberUtils.createRandom(false, 32);
		String openid = map.get("wx_pub_openid") + "";// memberBean2.getWx_pub_openid();
		String out_trade_no = map.get("out_trade_no") + "";
		String spbill_create_ip = "172.168.0.1";

		String total_fee = map.get("total_fee") + "";
		String trade_type = "JSAPI";
		String sign_type = "MD5";

		// 封装
		SortedMap<String, String> paraMap = new TreeMap<String, String>();
		paraMap.put("appid", appid);
		paraMap.put("attach", StringUtils.isNull(map.get("attach") + "") ? "商品购买" : map.get("attach") + "");
		paraMap.put("body", StringUtils.isNull(map.get("body") + "") ? "商品购买" : map.get("body") + "");
		paraMap.put("mch_id", mch_id);
		paraMap.put("nonce_str", nonce_str);

		paraMap.put("openid", openid);
		paraMap.put("out_trade_no", out_trade_no);
		paraMap.put("spbill_create_ip", spbill_create_ip);
		paraMap.put("total_fee", total_fee);
		paraMap.put("trade_type", trade_type);
		paraMap.put("notify_url", map.get("wx_pub_notify_url") + "");
		paraMap.put("sign_type", sign_type);

		// 签名
		RequestHandler reqHandler = new RequestHandler(null, null);
		reqHandler.init(appid, appsecret, partnerkey);
		String sign = reqHandler.createSign(paraMap);
		paraMap.put("sign", sign);

		// 统一下单
		String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		String xml = WXUtils.ArrayToXml(paraMap);
		System.out.println(xml);
		System.out.println("-=========");
		String prepay_id = "";
		try {
			// 提交
			prepay_id = getPayNo(url, xml);
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

	public static String wxPcPay(Map<String, Object> map) {
		// 设置微信原生支付所需参数
		String appid = map.get("wx_pub_appid") + "";// "wxe5703c4e06a09cc8";
		String appsecret = map.get("wx_pub_appsecret") + ""; // merchantsWeiXinBean.getWeixin_appsecret();
		String partnerkey = map.get("wx_pub_partnerkey") + "";// "HAYServices137670713564607753998";//merchantsWeiXinBean.getPartnerkey();
		String mch_id = map.get("wx_pub_mch_id") + "";// "1265437601";//merchantsWeiXinBean.getMch_id();
		String nonce_str = NumberUtils.createRandom(false, 32);
		String out_trade_no = map.get("out_trade_no") + "";
		String spbill_create_ip = "172.168.0.1";

		String total_fee = map.get("total_fee") + "";
		String trade_type = "NATIVE";
		String sign_type = "MD5";

		// 封装
		SortedMap<String, String> paraMap = new TreeMap<String, String>();
		paraMap.put("appid", appid);
		paraMap.put("attach", StringUtils.isNull(map.get("attach") + "") ? "商品购买" : map.get("attach") + "");
		paraMap.put("body", StringUtils.isNull(map.get("body") + "") ? "商品购买" : map.get("body") + "");
		paraMap.put("mch_id", mch_id);
		paraMap.put("nonce_str", nonce_str);

		paraMap.put("out_trade_no", out_trade_no);
		paraMap.put("spbill_create_ip", spbill_create_ip);
		paraMap.put("total_fee", total_fee);
		paraMap.put("trade_type", trade_type);
		paraMap.put("notify_url", map.get("wx_pub_notify_url") + "");
		paraMap.put("sign_type", sign_type);

		// 签名
		RequestHandler reqHandler = new RequestHandler(null, null);
		reqHandler.init(appid, appsecret, partnerkey);
		String sign = reqHandler.createSign(paraMap);
		paraMap.put("sign", sign);

		// 统一下单
		String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		String xml = WXUtils.ArrayToXml(paraMap);
		System.out.println(xml);
		System.out.println("-=========");

		String code_url = "";
		try {
			String result = HttpUtils.getDataByJson(url, xml);
			if (result.indexOf("FAIL") != -1) {
				return null;
			}
			// Map map = doXMLParse(result);
			// String return_code = (String) map.get("return_code");
			Document document = XmlUtils.getDocumentByXml(result);
			code_url = XmlUtils.getValueByTagName(document, "code_url");
			return code_url;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			System.out.println("------------------------------" + e.getMessage());
		}
		return null;
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

	public static SortedMap<String, String> wxPay(Map<String, Object> map) {
		// 设置微信原生支付所需参数
		String body = StringUtils.getNull(map.get("body") + "", "商品购买");
		String nonce_str = NumberUtils.createRandom(false, 30);
		String out_trade_no = map.get("out_trade_no") + "";
		System.out.println(out_trade_no);
		String spbill_create_ip = "127.0.0.1";
		int total_fee = NumberUtils.Integer(map.get("total_fee") + "");
		String trade_type = "APP";
		String notify_url = map.get("notify_url") + "";
		String packageValue = "Sign=WXPay";
		// 封装
		SortedMap<String, String> paraMap = new TreeMap<String, String>();
		paraMap.put("appid", map.get("wx_appid") + "");
		paraMap.put("body", body);
		paraMap.put("mch_id", map.get("wx_mch_id") + "");
		paraMap.put("nonce_str", nonce_str);
		paraMap.put("spbill_create_ip", spbill_create_ip);
		paraMap.put("out_trade_no", out_trade_no);
		paraMap.put("total_fee", total_fee + "");// total_fee
		paraMap.put("trade_type", trade_type);
		paraMap.put("notify_url", notify_url);

		// 签名
		RequestHandler reqHandler = new RequestHandler(null, null);
		reqHandler.init(map.get("wx_appid") + "", map.get("wx_appsecret") + "", map.get("wx_partnerkey") + "");
		String sign = reqHandler.createSign(paraMap);
		paraMap.put("sign", sign);

		// 统一下单https://api.mch.weixin.qq.com/pay/unifiedorder
		String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		String xml = XmlUtils.ArrayToXml(paraMap);
		String prepay_id = "";
		try {
			// 提交
			prepay_id = WXUtils.getPayNo(url, xml);
			if (prepay_id.equals("")) {
				System.out.println("统一支付接口获取预支付订单出错");
				return null;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			return null;
		}
		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		// 需要再次签名，这里要加上时间戳
		String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
		packageParams.put("appid", map.get("wx_appid") + "");
		packageParams.put("timestamp", timestamp);
		packageParams.put("noncestr", nonce_str);
		packageParams.put("package", packageValue);
		packageParams.put("prepayid", prepay_id);
		packageParams.put("partnerid", map.get("wx_mch_id") + "");
		String sign1 = reqHandler.createSign(packageParams);
		packageParams.put("sign", sign1);
		return packageParams;
	}

	public static Map<String, Object> wxAppRefund(Map<String, Object> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		String path = map.get("path") + "";// this.getClass().getResource("/").getFile().toString()
											// + "apiclient_cert.p12";
		// String path = "D:\\mnt\\tomcat\\images\\clue\\apiclient_cert.p12";
		String refund_no = map.get("refund_no") + "";
		String nonce_str = NumberUtils.createRandom(false, 30);
		String mch_id = map.get("wx_mch_id") + "";
		String appid = map.get("wx_appid") + "";
		String secret = map.get("wx_appsecret") + "";
		String partnerkey = map.get("wx_partnerkey") + "";
		String out_trade_no = map.get("out_trade_no") + "";
		int total_fee = NumberUtils.Integer(map.get("total_fee") + "");
		int refund_fee = NumberUtils.Integer(map.get("refund_fee") + "");

		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", appid);
		packageParams.put("mch_id", mch_id);
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("out_trade_no", out_trade_no);
		packageParams.put("out_refund_no", refund_no);
		packageParams.put("total_fee", total_fee + "");
		packageParams.put("refund_fee", refund_fee + "");
		/*----2.根据package生成签名sign---- */
		RequestHandler reqHandler = new RequestHandler(null, null);
		reqHandler.init(appid, secret, partnerkey);
		String sign = reqHandler.createSign(packageParams);
		System.out.println("sign=" + sign);
		/*----3.拼装需要提交到微信的数据xml---- */
		String xml = "<xml>" + "<appid>" + appid + "</appid>" + "<mch_id>" + mch_id + "</mch_id>" + "<nonce_str>"
				+ nonce_str + "</nonce_str>" + "<out_refund_no>" + refund_no + "</out_refund_no>" + "<out_trade_no>"
				+ out_trade_no + "</out_trade_no>" + "<total_fee>" + total_fee + "</total_fee>" + "<refund_fee>"
				+ refund_fee + "</refund_fee>" + "<sign>" + sign + "</sign>" + "</xml>";
		try {
			/*----4.读取证书文件,这一段是直接从微信支付平台提供的demo中copy的，所以一般不需要修改---- */
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			FileInputStream instream = new FileInputStream(new File(path));
			try {
				keyStore.load(instream, mch_id.toCharArray());
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				instream.close();
			}
			// Trust own CA and all self-signed certs
			@SuppressWarnings("deprecation")
			SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, mch_id.toCharArray()).build();
			// Allow TLSv1 protocol only
			@SuppressWarnings("deprecation")
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" },
					null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			/*----5.发送数据到微信的退款接口---- */
			String url = "https://api.mch.weixin.qq.com/secapi/pay/refund";
			HttpPost httpost = new HttpPost(url); // 设置响应头信息
			httpost.setEntity(new StringEntity(xml, "UTF-8"));
			HttpResponse weixinResponse = httpClient.execute(httpost);
			if (weixinResponse.getEntity() == null) {
				resultMap.put("status", "error");
				resultMap.put("error", "无响应");
				return resultMap;
			}

			String jsonStr = EntityUtils.toString(weixinResponse.getEntity(), "UTF-8");

			Document document = XmlUtils.getDocumentByXml(jsonStr);
			String return_code = XmlUtils.getValueByTagName(document, "return_code");
			String return_msg = XmlUtils.getValueByTagName(document, "return_msg");
			String result_code = XmlUtils.getValueByTagName(document, "result_code");
			String err_code_des = XmlUtils.getValueByTagName(document, "err_code_des");

			if ("FAIL".equals(return_code)) {
				if ("invalid total_fee".equals(return_msg)) {
					resultMap.put("status", "error");
					resultMap.put("error", "无效的总金额");
					return resultMap;
				} else {
					resultMap.put("status", "error");
					resultMap.put("error", return_msg);
					return resultMap;
				}
			} else {
				if ("FAIL".equals(result_code)) {
					resultMap.put("status", "error");
					resultMap.put("error", err_code_des);
					return resultMap;
				}
			}

		} catch (Exception e) {
			resultMap.put("status", "error");
			resultMap.put("error", e.getMessage());
			return resultMap;
		}

		resultMap.put("status", "ok");
		return resultMap;

	}

	public static String alipay(Map<String, Object> map) {
		try {
			AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
			model.setBody(StringUtils.getNull(map.get("body") + "", "商品购买"));
			model.setSubject(StringUtils.getNull(map.get("subject") + "", "商品购买"));
			model.setOutTradeNo(map.get("out_trade_no") + "");
			model.setTotalAmount(map.get("total_fee") + "");

			// 实例化客户端
			AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
					map.get("alipay_app_id") + "", map.get("alipay_private_key") + "", "json", "utf-8",
					map.get("alipay_public_key") + "", "RSA2");
			// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
			AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
			// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
			// AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
			model.setProductCode("QUICK_MSECURITY_PAY");
			request.setBizModel(model);
			request.setNotifyUrl(map.get("notify_url") + "");
			AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
			// response.getBody()可以直接给客户端请求，无需再做处理。
			return response.getBody();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static String alipayPc(Map<String, Object> map) {
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
				map.get("alipay_app_id") + "", map.get("alipay_private_key") + "", "JSON", "utf-8",
				map.get("alipay_public_key") + "", "RSA2"); // 获得初始化的AlipayClient
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
		alipayRequest.setReturnUrl(map.get("return_url") + "");
		alipayRequest.setNotifyUrl(map.get("notify_url") + "");// 在公共参数中设置回跳和通知地址
		alipayRequest.setBizContent("{" + "    \"out_trade_no\":\"" + map.get("out_trade_no") + "\","
				+ "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," + "    \"total_amount\":" + map.get("total_fee")
				+ "," + "    \"subject\":\"商品购买\"," + "    \"body\":\"商品购买\"," + "    \"passback_params\":\"\","
				+ "    \"extend_params\":{" + "    \"sys_service_provider_id\":\"" + map.get("alipay_pid") + "\""
				+ "    }" + "  }");// 填充业务参数
		String form = "";
		try {
			form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
			return form;
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		String out_trade_no = "g" + NumberUtils.createRandom(true, 6) + "";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("out_trade_no", out_trade_no);
		map.put("alipay_pid", "2088121059657923");
		map.put("alipay_app_id", "2015123001053898");
		map.put("alipay_private_key", "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQC/vKYjow89vvmtxDH9bnZE0C0mlZPBa8smYDEQwsP2kMBMGo2+9l47KIIeb/Bih4e11YzKrRF5wGK3FS0XI/+JrvrMhpfi9Pmy52s6D1jSPnMbxkYnDJq1OPdEHyiv9yWvKDxfiqBMyWHPT/frgKrLU1p6/SC1QYwP96yLLr/tsZdfDoxJDPCBgyIseW/2ycnlfe+eO1Uz3yOYIKiu4/kiik3fclTnF5GxOYnqCYN2lrke6ChuqZhc9I0AHbXTukXCpuyuYEFoCaNg3RlfdV4lgdMX2Bf75p+SUHPXou7Ey3+0bPNBabsJ83ZPuhgGutu9Xm5ZibJQwy+HEetebRMJAgMBAAECggEAacgtrQmgNgOwAoN0xQp1a5+i2V+6pgLPkLuPNl0N+nF/9jzMKSgJcv/1Uc+WQvXdFJ/dzk/PjWlrzPB88QBmUlLcgYxcLdXUETUF/oFLEqtrnE42lAKrNAJawRWjv/lNrCY5sMhtig+sy9ClyiMxl33ENIiEzBt+p6yQYDWJpBva2Q+Cv2c3Quo4DO9evIqbHf+ZjM6ypyJqCExIu/eBeVqoa5ak5Gg60sY3kjycGn+wcwHbPBjsoNBP7TMuL2VbCOY1LDIxU/MVpAYrIQq2wdDBka8KfrStCY2nX3SI2nxIitQBIAtsA9FMzSk+O8KMwaC+W99Amb990R4amxt7gQKBgQDoLNhvw6nQ+kFnPBw1qM6GCq+Z12eGFbg4CKWUy+kHn7xBTcUYrxGXWcI2vnI4PJx7lLEm4OPxdioKCN36CdBgaPKIKld46m85eqF+rMuXw2XDbPPWWoQRmTHwWQl1iS0YjQkzuE2c0EzdoZM13ggovkpf2iiWixnQcqXpICaYUQKBgQDTaYFlmpQe6VQpCuQNSDOcqjWTPL81mvgP3rTS5wkX+pZbikxzvd4CIxClF6p6l6v0Ycqpoby5yU80PoDwlPpeWYwTyLlhuFSu8Bxxbszdsdf0JpCYVjSynmjQa6V47aSnk3ydQoQa44Kqu0rgZV6+xtKFp065j+wHHiL09ZFZOQKBgQCtHKrwgoJ+1+mmMLKT6965IQSXf32oA0/NL91OGdARqC90vajk47wJDpr5uHxvo/nFRzPjWjF7W3Cy9LOV+HVPPVEA6Bk6hgoSYHZDflF7Qe0Bjp4syGbKvF/45lpgMbzXHmmrD5OHBeUaJ5wcwQVyY5gO6hnzTZocyy8bqKY+UQKBgQCuh/NjRfHycv4fw/XxYSH6vCnum7/fKUiREXKGimVffmiSueHTy3N0oC4lnRwIiR5Uakc9M2Dyn9bbcp5P/y2SpqqVyqgAnISMx30zyB0pCKEX1p6YpNJsg4pURgodg1LjZUcDLN6StDAzctul1QoaxVkXLcA4QTDBz4dcYz7TQQKBgQDSBKWfcXwpoGx5elC6WVU0fQfaurR2/Js1HBI+o7xuNUESb95slHP0Y2NdDozflSi8n/aaaD2lGFK+x4TapDlbHPpzaZ1owZtDvCvekeDkuAsyjq+ORXizl3roti+LeHkUDNUJf1/vLFzM5mRavUmUz/ZdmDhaIdlQaVDpJpXL4g==");
		map.put("alipay_public_key", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkENbpPFGXGIJVxRLIMyB5d3nqbBryKhUwF3HOqQgVGsFhd/r7mSORLAjlil2wkj5OUTLX2++03o0bcITomRyFdMLoIsXuEfxGLCE8DWegkAtBD7Zq7hOse3afZ8yYAdzQfypM0h2vCp0CDPVhXLPB74VQtXdaf6vd7kEqkZ8Wx6+GrcwBqit5DfHrA+MoOjfs7h2VUfJvgs+cC4dlJ0FiJ8X25J0eBIG2lFQyY9GOWSXKiJBaFE2ZZ5ffEi9OFS+PJ1KWbOisKZwJvB3c/a7SqALI5I9L1KPJklfF5iyUlKXYG0W12G/QpVLUL0nTvQqdwrL5Aw+AeScYx2wDEik2wIDAQAB");
		
//		map.put("alipay_pid", "2088511833207846");
//		map.put("alipay_app_id", "2018011001751531");
//		map.put("alipay_private_key","MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDHf78kcP1nSHpziYBfzYGoeJn/IZp1NlB071I2Cjzrqh2PMCA9pAGJ2UjhVEJNF/7ALY6l32Jin/pesaAflq/reggO6LxGiQSy67UnvEc7BSerrZzkZw/1dqxjizbZEAZZSWOOvYmeGjNASH8Zs+5Gly5MAPrcL2v0Vh5gCgl8IAIiBvb7xB3RvQbJwn9lLdAxR6iJAEYSVG+n41OgWJyfXudmNRLV9hq3E1xUV71xTYBP3ri66REoCi/WnAfHzLy5Cxp222EdQ9ZQ51THyukAO3LwDmYGffCyUU6q7Gebahzz5ERzF5+M/OMx0DtsRSYHAtHxwcFYxYg5Di2cccMvAgMBAAECggEBAI6gcAEXnrMmiBTt6w+TFu1hO4fBeHHwINlY+AeWjjNV7cge+g3XoRnydD5URQpk60Zty5we9nHYOeFVUEsFKkRJfFVcYq5y6x8XkO4Vlz9E0jXU62QHoss0ys5oCxBoeoF/DGRScX7M8HM24Vd44hMppnnEAZVFegK3RwQWaO2JmXsx5Mh3wPA/j+XosHv2BRx0KTW0dwnMSCn2JuqAAaqJLNeKWbIo7hXUPGmcjhSNn5rT8OVWROZqv2kxVe7eFYys2CekmIZZq0pYnPGgQFHt2SSMTG7ujwqklhlfqtImYADrTX11mRV86hbsbTP6Rk9R9tmGfG8ZvlSDLL9D8HECgYEA6DQ/Ux3ZhOyrmu0sLsEQx4Oaf7B32QhYgaT1Qd27qx+/7PXb8geIL4wKjJ9UOzVQJV4Il5U/DptYYLTcC9M5d43AN8Qj0aJwowy5/WBDbhBj1kEBUn1ftmxO7xoFi72aIXQAGdhFSNwSaMewArSXAqRpTjqW5feZ77lk3XpqgFUCgYEA2/F/pkINu4vMTb+J2v3LDKoV0I1GzUbPhTQwjw1UqBhZ1841m1hi7JWkV48y9TgRe6MxeXe2eh1/Y+kyGwKpKq/+o6/nkHgR+FsSJYebI6K27sqUpjLZuQ81pv0hMGn8EwUA8ogCZSRuYxiU4i4PtXeOps6DJuFfGbRsH2paqXMCgYB3FkyfyQBEvshnxVlShSug1yrGb++XPEOAAeTSqfBUnAznb1Qk9Z3vnKfQZOpjDz2SXH6VlzJmwF78AeWUnvirCuTY9NvV6LRRuvYsL1GFwhwhxubxsmEDAtscn0DW4R+KJp7iolsuOcerOzZWvN1xunZTa5L2UBz/qBpFyEGUnQKBgQDP4ONbSpccKbeBzIUJHFLrt15C7SR8JG9DYN58docLEWjpFZeJKfLl1VGtCEWLi+DKUKYUPleT94lN7zxSVyN4mzs7jqh43WNurvTpz8+L0ODBtWrl4q3xwTRejmTuE14Sw+nvUSmiWtqSgstFM2/ZfhSwCAPhnaV68BI5ZxYljQKBgQCUQuvBtOjKhzS0MZx0X/s2gNYWug9SWDn/zN8/+3ZfRzZtcMKRKuiy6/fXLln7VIHK1yCgxrGCA+SY1AX+mzK9LDJP5Hd/gTUMuF4wNA7+/qPDfXYAFa6ntoMADL3OgWXoV3VYel5ch/QS74lghbHKMhi6m7ohPZ4DRbnUBsDPdA==");
//		map.put("alipay_public_key","MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApVAcTQM9bgljv2z+jng9mhKbziluNdlFCiIpN8wKGjAICDOhM12Q1Aumo/WoW24LR6YyTCvzDhpp/YMVRdrWQ4Bs5nI8KH5t5MeRoulZy/vJLvOQEa5AqR4vkxQUtHLc4yepXSjMyo1VHOLpWa5ISAA2F+NFWTFyIM1R1u8DNVth9izrV1I1M6wzmy+12kX/Pew0dUbb0O728TiH/p+4YE/mFM+hssW72w+aAZ45OxjyFi2dW94K8tIwZkzdUKTnu1DG1qXcxpq+MI9EyMzGiI8547mHqYp8Rg85ow0YFlqi8W1wSd/30iV9v0DFOQoaiBORpPMGgq3+e/+oAYb1kwIDAQAB");
//		
		map.put("notify_url", "http://huixiang.shareuniversal.com/orderInterfaces/v1.0/alipayCallback");
		map.put("total_fee", 0.01);
		String result = PayUtils.alipayH5(map);
		System.out.print(result);
	}
	
	public static String alipayH5(Map<String, Object> map) {
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
				map.get("alipay_app_id") + "", map.get("alipay_private_key") + "", "json", "utf-8",
				map.get("alipay_public_key") + "", "RSA2"); // 获得初始化的AlipayClient
		AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();// 创建API对应的request
		alipayRequest.setReturnUrl(map.get("return_url") + "");
		alipayRequest.setNotifyUrl(map.get("notify_url") + "");// 在公共参数中设置回跳和通知地址
		alipayRequest.setBizContent("{" + " \"out_trade_no\":\"" + map.get("out_trade_no") + "\","
				+ " \"total_amount\":\"" + map.get("total_fee") + "\"," + " \"subject\":\"商品购买\","
				+ " \"product_code\":\"QUICK_WAP_PAY\"" + " }");// 填充业务参数
		String form = "";
		try {
			form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
		} catch (AlipayApiException e) {
			e.printStackTrace();
			return null;
		}
		return form;
	}

	/**
	 * 支付宝退款接口
	 * 
	 * @param out_trade_no
	 *            订单支付时传入的商户订单号,不能和支付宝交易号（trade_no）同时为空。
	 * @param trade_no
	 *            支付宝交易号
	 * @param refund_amount
	 *            需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数
	 * @return 将提示信息返回
	 */
	public static Map<String, Object> alipayRefund(Map<String, Object> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// out_request_no随机数 不是全额退款，部分退款使用该参数
		try {
			AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
					map.get("alipay_app_id") + "", map.get("alipay_private_key") + "", "json", "utf-8",
					map.get("alipay_public_key") + "", "RSA2");
			AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
			request.setBizContent("{" + "\"out_trade_no\":\"" + map.get("out_trade_no") + "" + "\"," +
			// "\"trade_no\":\"" + refundBean.getPay_no() + "\"," +
					"\"refund_amount\":\"" + map.get("refund_fee") + "\"," + "\"out_request_no\":\""
					+ map.get("refund_no") + "\"," + "\"refund_reason\":\"正常退款\"" + " }");
			AlipayTradeRefundResponse response = alipayClient.execute(request);
			if (!response.isSuccess()) {
				resultMap.put("status", "error");
				resultMap.put("error", response.getSubMsg());
				return resultMap;
			}

		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("status", "error");
			resultMap.put("error", e.getMessage());
			return resultMap;
		}
		resultMap.put("status", "ok");
		return resultMap;
	}

	public static void main23(String[] args) {
		// Map<String, Object> map = new HashMap<String, Object>();
		// map.put("path", "/mnt/tomcat/images/clue/"+"apiclient_cert.p12");
		// map.put("out_trade_no","g2067966463485935625");
		// map.put("refund_no", NumberUtils.createRandom(false, 10));
		// map.put("total_fee", 1);// total_fee
		// map.put("refund_fee", 1);// total_fee
		// map.put("wx_appid", "wxdaeea85921c0c658");
		// map.put("wx_appsecret", "51ca476fcf7623149a6e33b1eb47e5a5");
		// map.put("wx_partnerkey", "q2kcawea9fg0r8fdq8ezs4necfbrd314");
		// map.put("wx_mch_id", "1505733491");
		// Map<String,Object> resultMap=PayUtils.wxAppRefund(map);
		// System.out.print(JSON.toJSON(resultMap));

		// Map<String, Object> map = new HashMap<String, Object>();
		//
		// map.put("alipay_app_id", "2018052360247120");
		// map.put("alipay_private_key",
		// "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCbBfqtSxNnhQ1RmrDFVkXkAsN+T1srmLrqUSIp+jyvhlXqQzOtEuz956WcpwRYlTJ9giIORO/fGJwCR0ZnDus5HxbWq9oM/Q6xYDftZLl6i0Ym/xQuvHNV3V1GZxuklS/pVxkMc25WCIT3a8Yx6GTewnIhjjfj9pFy+CoCIHqRm/3txzJEfmgqm9tbmykImUV23S9qFyAS1Coa6LQ+sNQwgiN3mTYyEqwDYqXKa/hX2FCKyiXEzq+Od0TFz3RPxBztfDY35c05obeGrxn0BJHNj++plW+UXhIxYFpKbAUUzASlq1qACuptZ23ehqRob6dhz3eq/nWkRumaWDotms89AgMBAAECggEBAImXrP7Se86N0Vx0qCD+idnuegVJ+emgDYabrG8Fo4dG/EqIiv06pw5U5DE+LCVThxTOw9tWZHDnLtD24g3mt/BjH6o5rbeJg9j7Rah2lgmmRAWosQkqSlQTvg4Wxfo2T+gTXjAm4++IcDwKdEcntR/iBdqyl/jFiCM7EE4C9cb1+ycLvSfg9ZiH/nllzXD2ZmNtg/9A3dfli783iepqfm7D0DB1G1L6qeuI83S07Lokej6373xARtslLKcG5r7eyh8AXm3SVJ/0rt7Y/N+poJ8GB4Ce9paP8civDnbCLS0g3qEwp3lQV1j7Sc7pBUhhxgWpnSf45npHhJBbWBvJHQECgYEA+BHikAfnP+FYFN3ZNJSZ1np7PwPu+JDclxU31N8l+DF6bGCfLWmeAl+4zduFi4ypQZs0tfznr/YCcJA3Bp5yQ78J2UBk9B4YtyVtpCBD+0j0jnIwTywa8OsxKbSYFTufp9PbqwyfqJW4FsJtYhKTVtTTDxeMfuslVbqDwItdfNkCgYEAn/qih3ZgLEsbLzrgzXKbleIQkzd7/4r3K8U1vnHd13vngQ+zUbwANQB+ycEpqqisoJQsWPuN1lD3NNZ7ZDI6dzTO+PKkJrtgGDNPNdnHjtb3GqEq7j8KKUyEpOxeAby7yO91uZ4Onv9+dXMfDNAAqB3MsFLYrGJi9vODCUCi9wUCgYBN0daAFmqd6IQoL5wm2YMU/GFTWFmMEm2Q27AjEEmp/WOJQhpNNbfCyOKBeZ8AMwUZtqWnfYn08ji7tRH9+pCf3fsp8wB4cESSl6Q4e4K3/p/xW7L58z0UXMOUcLnQ115zWIutsg0X5rfUM/P6cxdTgvoe3uVNH1kb9qHEMjQGqQKBgGS9Wl19IICj5wFtzSPyeKEAkzlxJgc8RfttGzPK1kycPKLb9SqR/XtizXRUy90ojFQuGmMKPT3pDFJcgaUNsB1ixrajbNTrB08V+FpLwktjeIVvWe5fChIJmjmUknn7lDCrAfIZ4tEiyEpDbRkPXmp/IWcjNEgRSIqDu083QafVAoGBAMSCztg4ELs2KYc7/LjbfnXKZlLx1uTk4Ioye+Ofs3ydX2OIk/2FVDnRBnFug7bjKO1UZfI55OktKij2R2Dx+zjGaYDJ3+Jr4APD5SFhyPnxQOUi7pMTzHsykEEBGQh8a+AL5xDIIzGRtIOeDrlptj7ZnDAiRaUwfvhACxzocS++");
		// map.put("alipay_public_key",
		// "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnYqIw3qipB2aSDvIEQg6rWLp7U/aztqf6nIECz1VS1M5KYbRe/enIFhJIZSsfWzxzbI56NxelSFrSkTT35gykMDv7Qvgr2Sk9B9wuAe9mxYEGcBrjI98f81KOR4uxCf5NyHyvTNBvzy4HtW8EYaLW41QS3MuF4T39SiMNZd+eACQw/DWz+NQ5TjzsLGpT2/b24dBhWVZ7a+zkPmBKHIIodc6hYvjh2eoHeHDUi34NjGK0hCnnzKjRtYdUaWfZBc6LzQwGs58HTbHRkol7IEKaBczIF1GyKHvRNIn5tBqFCXntzo5WpVlL3LWRDGcUGc3HHD676qx3BGyNHlocf9sGwIDAQAB");
		//
		// map.put("out_trade_no", "g2075917213772021767");
		// map.put("refund_no", NumberUtils.createRandom(false, 10));
		// map.put("refund_fee", 1);// total_fee
		//
		// Map<String, Object> resultMap = PayUtils.alipayRefund(map);
		// System.out.print(JSON.toJSON(resultMap));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("out_trade_no", "1234");
		map.put("total_fee", 1);// total_fee
		map.put("wx_pub_appid", "wx0cb523803506b99a");
		map.put("wx_pub_appsecret", "2e834f710b3c35f42fabc0af8a38eeca");
		map.put("wx_pub_partnerkey", "d8578edf8458ce06fbc5bb76a58c5ca4");
		map.put("wx_pub_mch_id", "1501705381");
		map.put("wx_pub_openid", "123");

		map.put("wx_pub_notify_url", "http://shop-blh.tstweiguanjia.com/orderInterfaces/v1.0/wxCallback");
		map.put("total_fee", 1);// total_fee
		String code_url = PayUtils.wxPcPay(map);
		System.out.println(code_url);
	}
}
