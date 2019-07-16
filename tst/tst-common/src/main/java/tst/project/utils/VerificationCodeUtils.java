/**
 * 
 */
package tst.project.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import tst.project.bean.CodeBean;

/**
 * @author sjb
 * 
 */
public class VerificationCodeUtils {


	/**
	 * 助通
	 * @param verificationBean
	 * @param codeBean
	 * @return
	 * @throws Exception
	 */
	public static CodeBean sendCodeZhutong(String url,String username,String password,int effective_time,CodeBean codeBean){
		// 产生随机验证码
		try {
			String format = "yyyy-MM-dd HH:mm:ss";
			String time = TimeUtils.getCurrentTime(format);
			Date date = TimeUtils.getDateFromTime(format, time);

			codeBean.setCreate_time(time);
			codeBean.setEffective_time(TimeUtils.getTimeMinuteAfter(format, date,effective_time));
			
			String tkey=TimeUtils.getCurrentTime("yyyyMMddHHmmss");
			String mobile=codeBean.getMobile();  //发送的手机号
			String content=codeBean.getCode_desc();   //内容
			
			//String time="2016-09-06 17:48:22";//定时信息所需参数时间格式为yyyy-MM-dd HH:mm:ss
			String xh="";
			try {
				content=URLEncoder.encode(content, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				System.out.print(e.getMessage());
			}
			String param="url="+url
					+"&username="+username
					+"&password="+MD5Util.md5EncodeOrigin(MD5Util.md5EncodeOrigin(password)+tkey)
					+"&tkey="+tkey
					+"&mobile="+mobile
					+"&content="+content
					+"&xh="+xh
					+"&productid=676767";
			//String param="url="+url+"&username="+username+"&password="+MD5Gen.getMD5(MD5Gen.getMD5(password)+tkey)+"&tkey="+tkey+"&time="+time+"&mobile="+mobile+"&content="+content+"&xh="+xh;//定时信息url输出
			String ret=HttpUtils.sendPost(url,param);//定时信息只可为post方式提交
			System.out.println("ret:"+ret);
			System.out.println(param);
			
			if(ret.contains("1,")){
				return codeBean;
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	/**
//	 * 网信通
//	 * @param verificationBean
//	 * @param codeBean
//	 * @return
//	 * @throws Exception
//	 */
//	public static CodeBean sendCodeWangxintong(VerificationBean verificationBean,CodeBean codeBean) throws Exception {
//		// 产生随机验证码
//		try {
//			String format = "yyyy-MM-dd HH:mm:ss";
//			String time = TimeUtils.getCurrentTime(format);
//			Date date = TimeUtils.getDateFromTime(format, time);
//
//			codeBean.setCreate_time(time);
//			codeBean.setEffective_time(TimeUtils.getTimeMinuteAfter(format, date,verificationBean.getEffective_time()));
//			
//			String url=verificationBean.getVerification_url();
//			String username=verificationBean.getVerification_account();//"sky-lns";  //账号
//			String password=verificationBean.getVerification_password();//"333333";  //密码
//			String mobile=codeBean.getMobile();  //发送的手机号
//			String content=codeBean.getCode_desc();//"您的验证码是"+NumberUtils.createRandom(true, 6)+"，验证码有效期为10分钟，感谢您对乐农社的支持！";   //内容
//
//			String xh="";
//			try {
//				content=URLEncoder.encode(content, "gbk");
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//				System.out.print(e.getMessage());
//			}
//			
//			
//			System.out.println(mobile+"-----------------");
//
//			
//			String param="username="+username+"&password="+password+"&mobile="+mobile+"&smscontent="+content;
////			NameValuePair basicNameValuePair1=new NameValuePair("username",username);
////			NameValuePair basicNameValuePair2=new NameValuePair("password",password);
////			NameValuePair basicNameValuePair3=new NameValuePair("mobile",mobile);
////			NameValuePair basicNameValuePair4=new NameValuePair("smscontent",content);
////
////			NameValuePair[] nameValuePairs={basicNameValuePair1,basicNameValuePair2,basicNameValuePair3,basicNameValuePair4};
////			
//			System.out.println(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"));
//			//String ret=HttpUtils.getDataByPost(url,nameValuePairs);//定时信息只可为post方式提交
//			String ret=HttpRequest.sendPost(url, param);//定时信息只可为post方式提交
//
//			System.out.println(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"));
//
//			System.out.println("ret:"+ret);
//			//System.out.println(param);
//			
//			if(ret==null){
//				return null;
//			}
//			return codeBean;	
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

}
