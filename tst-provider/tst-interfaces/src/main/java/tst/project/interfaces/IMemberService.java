package tst.project.interfaces;


import java.util.List;
import java.util.Map;

import org.objectweb.asm.CodeVisitor;

import com.alipay.api.domain.Member;

import tst.project.bean.CodeBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.MemberBillBean;
import tst.project.bean.member.MemberMsgBean;
import tst.project.bean.member.MemberWithdrawBean;
import tst.project.bean.member.RealnameBean;
import tst.project.page.PageBean;


public interface IMemberService {
	public Object test(List<Map> maps);
	
	/**
	 * 申请提现
	 * @author sjb
	 * @param memberWithdrawBean
	 * @return
	 */
	public Object insertMemberWithdraw(MemberWithdrawBean memberWithdrawBean);
	/**
	 * 用户账单明细
	 * @author sjb
	 * @param memberBillBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberBills(MemberBillBean memberBillBean,PageBean pageBean);
	
	/**
	 * 个人中心各种统计
	 * @author sjb
	 * @param memberBean
	 * @return
	 */
	public Object getStatistics(MemberBean memberBean);
	
	/**
	 * 用户实名认证信息
	 * @author sjb
	 * @param realnameBean
	 */
	public RealnameBean getMemberRelaname(RealnameBean realnameBean);
	
	/**
	 * 用户提交实名认证信息
	 * @author sjb
	 * @param realnameBean
	 */
	public Object insetMemberRelaname(RealnameBean realnameBean);
	
	/**
	 * 退出登录
	 * @author sjb
	 * @param memberBean
	 * @return
	 */
	public Object outLogin(MemberBean memberBean);
	
	/**
	 * 用户详情
	 * @param memberBean
	 * @return
	 */
	MemberBean getMemberDetail(MemberBean memberBean);
	
	/**
	 * 其他用户主页详情
	 * @author lx
	 * @param memberBean
	 * @return
	 */
	Object getOtherMemberDetail(MemberBean memberBean);
	
	/**
	 * 修改用户详情
	 * @param memberBean
	 * @return
	 */
	int updateMemberDetail(MemberBean memberBean);
	
	
	/**
	 * 用户注册
	 * @param memberBean
	 * @param codeBean
	 * @return
	 */
	Object registerMember(MemberBean memberBean,CodeBean codeBean);
	
	
	/**
	 * 用户登录
	 * @param memberBean
	 * @return
	 */
	Object loginMember(MemberBean memberBean);
	
	/**
	 * 用户验证码登录
	 * @author lx
	 * @param memberBean
	 * @param codeBean
	 * @return
	 */
	Object loginMemberByCode(MemberBean memberBean,CodeBean codeBean);
	
	/**
	 * 微信小程序用户登录
	 * @param memberBean
	 * @return
	 */
	Object wxPubLoginMember(String code,String is_bind_mobile);
	/**
	 * 微信公众号获取微信用户信息
	 * @author lx
	 * @param code
	 * @return
	 */
	Object wxPublicMemberInfo(String code);
	
	/**
	 * 微信小程序用户登录
	 * @param memberBean
	 * @return
	 */
	Object wxLiteLoginMember(String code,String is_bind_mobile,String decryptData,String iv);
	
	/**
	 * 微信小程序绑定手机号
	 * @author sjb
	 * @param memberBean
	 * @param codeBea
	 * @return
	 */
	Object wxLitBindMobile(MemberBean memberBean,CodeBean codeBea);
	
	/**
	 * 微信登录
	 * @author lx
	 * @param code
	 * @param is_bind_mobile
	 * @return
	 */
	Object wxLoginMember(MemberBean memberBean);
	
	/**
	 * 微信绑定手机号
	 * @author lx
	 * @param memberBean
	 * @param codeBean
	 * @return
	 */
	Object wxBindMobile(MemberBean memberBean,CodeBean codeBean);
	
	/**
	 * qq登录
	 * @author lx
	 * @param code
	 * @param is_bind_mobile
	 * @return
	 */
	Object qqLoginMember(MemberBean memberBean);
	/**
	 * qq绑定手机号
	 * @author lx
	 * @param memberBean
	 * @param codeBean
	 * @return
	 */
	Object qqBindMobile(MemberBean memberBean,CodeBean codeBean);
	
	/**
	 * 忘记密码
	 * @param memberBean
	 * @return
	 */
	Object forgetPassword(MemberBean memberBean, CodeBean codeBean);
	
	/**
	 * 设置支付密码
	 * @param memberBean
	 * @param codeBean
	 * @return
	 */
	Object payPassword(MemberBean memberBean, CodeBean codeBean);
	
	/**
	 * 获取个人消息
	 * @author gxq
	 * @param memberMsgBean
	 * @param pageBean
	 * @return
	 */
	Object getMemberMsgs(MemberMsgBean memberMsgBean, PageBean pageBean);
	
	
	/**
	 * 查看个人消息
	 * @author lx
	 * @param memberMsgBean
	 * @return
	 */
	MemberMsgBean getMemberMsgsDetail(MemberMsgBean memberMsgBean);
	

}
