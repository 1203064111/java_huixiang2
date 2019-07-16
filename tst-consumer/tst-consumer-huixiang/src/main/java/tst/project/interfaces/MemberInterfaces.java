package tst.project.interfaces;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.qiniu.util.Auth;

import tst.project.BaseController;
import tst.project.aspect.AppController;
import tst.project.aspect.AppException;
import tst.project.bean.CodeBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.MemberBillBean;
import tst.project.bean.member.MemberMsgBean;
import tst.project.bean.member.MemberWithdrawBean;
import tst.project.bean.member.RealnameBean;
import tst.project.page.PageBean;
import tst.project.utils.ExcelUtils;
@Controller
@RequestMapping("/memberInterfaces/v1.0")
public class MemberInterfaces extends BaseController{

	@Autowired
	IMemberService memberService;
	
	@RequestMapping("/test")
	@AppController
	public Object test(HttpServletRequest request) throws Exception {
		String file_name=saveFile(request,"file",false);
		if(file_name==null){
			throw new AppException("文件为空!");
		}
		
		String a=ExcelUtils.readExcel("/mnt/tomcat/images/clue/"+file_name);
		memberService.test(JSON.parseArray(a,Map.class));
		return "success";
	}
	
	@RequestMapping("/getQiniuToken")
	@AppController
	public Object getQiniuToken(HttpServletRequest request,HttpServletResponse response) throws Exception {

//		String accessKey = "pR_CsEkFcTn1Kgf8ZNIh2zUB_w8bzaeLYEgjBItT";
//		String secretKey = "Vr2R_DMBvVHAtVmcwVGKF_C-ol6jDtCXqpiXlZZY";
		String accessKey = "ZcsNZRAYVcESGbGBwbQIb_Wt8J-Ig1oJHkhSk1Z0";
		String secretKey = "BwdxFoyAEqV9OCLN5qmL6SSY0WoJP3w431Qtij6y";
		
		String bucket = "hx2";
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);
		return upToken;
	}
	
	@RequestMapping("/insertMemberWithdraw")
	@AppController(isVerToken = true)
	public Object insertMemberWithdraw(MemberWithdrawBean memberWithdrawBean) throws Exception {
		return memberService.insertMemberWithdraw(memberWithdrawBean);
	}
	
	@RequestMapping("/getMemberBills")
	@AppController(isVerToken = true,isPage=true)
	public Object getMemberBills(MemberBillBean memberBillBean,PageBean pageBean) throws Exception {
		return memberService.getMemberBills(memberBillBean,pageBean);
	}
	
	
	@RequestMapping("/getStatistics")
	@AppController(isVerToken = true)
	public Object getStatistics(MemberBean memberBean) throws Exception {
		return memberService.getStatistics(memberBean);
	}
	
	
	@RequestMapping("/getMemberRelaname")
	@AppController(isVerToken = true)
	public Object getMemberRelaname(RealnameBean realnameBean) throws Exception {
		return memberService.getMemberRelaname(realnameBean);
	}
	
	@RequestMapping("/insetMemberRelaname")
	@AppController(isVerToken = true)
	public Object insetMemberRelaname(RealnameBean realnameBean) throws Exception {
		
		return memberService.insetMemberRelaname(realnameBean);
	}
	
	/**
	 * 退出登录
	 * @author sjb
	 * @param memberBean
	 * @return
	 */
	@RequestMapping("/outLogin")
	@AppController(isVerToken = true)
	public Object outLogin(MemberBean memberBean) throws Exception {
		return memberService.outLogin(memberBean);
	}
	
	

	/**
	 * 用户详情
	 * 
	 * @param memberBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMemberDetail")
	@AppController(isVerToken = true)
	public Object getMemberDetail(MemberBean memberBean) throws Exception {
		return memberService.getMemberDetail(memberBean);
	}
	/**
	 * 其他用户的个人主页
	 * @param memberBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getOtherMemberDetail")
	@AppController()
	public Object getOtherMemberDetail(MemberBean memberBean) throws Exception {
		return memberService.getOtherMemberDetail(memberBean);
	}
	
	
	/**
	 * 微信公众号用户登录
	 * 
	 * @param is_bind_mobile
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/wxPubLoginMember")
	@AppController
	public Object wxPubLoginMember(String code,String is_bind_mobile) throws Exception {
		return memberService.wxPubLoginMember(code,is_bind_mobile);
	}
	/**
	 * 微信公众号获取信息
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/wxPublicMemberInfo")
	@AppController
	public Object wxPublicMemberInfo(String code) throws Exception {
		return memberService.wxPublicMemberInfo(code);
	}

	/**
	 * 微信小程序用户登录
	 * 
	 * @param is_bind_mobile
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/wxLiteLoginMember")
	@AppController
	public Object wxLiteLoginMember(String code,String is_bind_mobile,String encryptedData,String iv) throws Exception {
		return memberService.wxLiteLoginMember(code,is_bind_mobile,encryptedData,iv);
	}
	
	
	/**
	 * 微信小程序绑定手机号码
	 * 
	 * @param memberBean
	 * @param codeBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/wxLitBindMobile")
	@AppController
	public Object wxLitBindMobile(MemberBean memberBean,CodeBean codeBean) throws Exception {
		return memberService.wxLitBindMobile(memberBean,codeBean);
	}



	@RequestMapping("/wxLoginMember")
	@AppController
	public Object wxLoginMember(MemberBean memberBean) throws Exception {
		return memberService.wxLoginMember(memberBean);
	}
	@RequestMapping("/wxBindMobile")
	@AppController
	public Object wxBindMobile(MemberBean memberBean,CodeBean codeBean) throws Exception {
		return memberService.wxBindMobile(memberBean,codeBean);
	}
	@RequestMapping("/qqLoginMember")
	@AppController
	public Object qqLoginMember(MemberBean memberBean) throws Exception {
		return memberService.qqLoginMember(memberBean);
	}
	@RequestMapping("/qqBindMobile")
	@AppController
	public Object qqBindMobile(MemberBean memberBean,CodeBean codeBean) throws Exception {
		return memberService.qqBindMobile(memberBean,codeBean);
	}

	/**
	 * 用户登录
	 * 
	 * @param memberBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/loginMember")
	@AppController
	public Object loginMember(MemberBean memberBean) throws Exception {
		return memberService.loginMember(memberBean);
	}
	
	@RequestMapping("/loginMemberByCode")
	@AppController
	public Object loginMemberByCode(MemberBean memberBean,CodeBean codeBean) throws Exception {
		return memberService.loginMemberByCode(memberBean,codeBean);
	}
	


	/**
	 * 用户注册
	 * 
	 * @param memberBean
	 * @param codeBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/registerMember")
	@AppController
	public Object registerMember(MemberBean memberBean, CodeBean codeBean) throws Exception {
		Object object = memberService.registerMember(memberBean, codeBean);
		return object;
	}

	/**
	 * 忘记密码
	 * @param memberBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/forgetPassword")
	@AppController
	public Object forgetPassword(MemberBean memberBean, CodeBean codeBean) throws Exception {
		Object object = memberService.forgetPassword(memberBean, codeBean);
		return object;
	}
	
	/**
	 * 设置支付密码
	 * 
	 * @param memberBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/payPassword")
	@AppController
	public Object payPassword(MemberBean memberBean, CodeBean codeBean) throws Exception {
		
		return memberService.payPassword(memberBean, codeBean);
	}

	
	/**
	 * 修改个人资料
	 * @param memberBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateMemberDetail")
	@AppController(isVerToken = true)
	public Object updateMemberDetail(MemberBean memberBean)throws Exception{
		Object object = memberService.updateMemberDetail(memberBean);
		return object;
	}
	

	
	/**
	 * 获取个人消息列表
	 * @author gxq
	 * @param memberMsgBean
	 * @param pageBean
	 * @return
	 */
	@RequestMapping("/getMemberMsgs")
	@AppController(isVerToken = true,isPage=true)
	public Object getMemberMsgs(MemberMsgBean memberMsgBean,PageBean pageBean) {
		
		return memberService.getMemberMsgs(memberMsgBean,pageBean);
	}
	
	/**
	 * 查看消息详情
	 * @author gxq
	 * @param memberMsgBean
	 * @return
	 */
	@RequestMapping("/getMemberMsgsDetail")
	@AppController(isVerToken = true)
	public Object getMemberMsgsDetail( MemberMsgBean memberMsgBean) {
		return memberService.getMemberMsgsDetail(memberMsgBean);
	}
	
	
	

}
