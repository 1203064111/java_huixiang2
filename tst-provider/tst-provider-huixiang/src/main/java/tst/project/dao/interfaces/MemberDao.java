package tst.project.dao.interfaces;

import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.MemberBillBean;
import tst.project.bean.member.MemberMsgBean;
import tst.project.bean.member.MemberWithdrawBean;
import tst.project.bean.member.RealnameBean;
import tst.project.page.PageBean;

@Mapper
public interface MemberDao {
	public int test(List<Map> maps);
	/**
	 * 申请提现
	 * @param memberWithdrawalsBean
	 * @return
	 */
	public int insertMemberWithdraw(MemberWithdrawBean memberWithdrawBean);
	
	/**
	 * 账单明细入库
	 * @param memberBillBean
	 * @return
	 */
	public int insertMemberBill(MemberBillBean memberBillBean);
	/**
	 * 用户账单明细
	 * @author sjb
	 * @param memberBillBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberBillBean> getMemberBills(MemberBillBean memberBillBean,PageBean pageBean);
	
	/**
	 * 个人中心 收藏统计
	 * @param memberBean
	 * @return
	 */
	public Map<String, Object> getCollectionStatistics(MemberBean memberBean);
	
	/**
	 * 个人中心 足迹统计
	 * @param memberBean
	 * @return
	 */
	public Map<String, Object> getFootprintStatistics(MemberBean memberBean);
	/**
	 * 个人中心团购统计
	 * @author sjb
	 * @param memberBean
	 * @return
	 */
	public Map<String, Object> getGroupStatistics(MemberBean memberBean);
	
	/**
	 * 用户实名认证信息
	 * @author sjb
	 * @param realnameBean
	 */
	public RealnameBean getMemberRelaname(RealnameBean realnameBean);
	
	/**
	 * 修改用户的实名认证信息
	 * @param realnameBean
	 * @return
	 */
	public int updateMemberRealname(RealnameBean realnameBean);
	
	/**
	 * 用户提交实名认证信息
	 * @author sjb
	 * @param realnameBean
	 */
	public int insetMemberRelaname(RealnameBean realnameBean);
	
	/**
	 * 获取用户详情
	 * @param memberBean
	 * @return
	 */
	MemberBean getMemberDetail(MemberBean memberBean);
	/**
	 * 其他用户主页详情
	 * @param memberBean
	 * @return
	 */
	MemberBean getOtherMemberDetail(MemberBean memberBean);
	
	/**
	 * 用户注册
	 * @param memberbean
	 * @return
	 */
	int registerMember(MemberBean memberbean);
	/**
	 * 修改用户详情
	 * @param memberbean
	 * @return
	 */
	int updateMemberDetail(MemberBean memberbean);
	
	/**
	 * 设置支付密码
	 * @param memberBean
	 * @param codeBean
	 * @return
	 */
	public int payPassword(MemberBean memberBean);
	
	/**
	 * 用户消息列表
	 * @param memberMsgBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberMsgBean> getMemberMsgs(MemberMsgBean memberMsgBean, PageBean pageBean);

	/**
	 * 用户消息详情
	 * @param memberMsgBean
	 * @return
	 */
	public MemberMsgBean getMemberMsgsDetail(MemberMsgBean memberMsgBean);
	
	/**
	 * 修改用户消息
	 * @param setMsg_id
	 * @return
	 */
	public int updateMemberMsgDetail(MemberMsgBean setMsg_id);

}
