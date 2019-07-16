package tst.project.dao.controller;

import tst.project.annotation.Mapper;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.MemberBillBean;
import tst.project.bean.member.MemberWithdrawBean;
import tst.project.bean.member.RealnameBean;
import tst.project.bean.product.ShopBean;
import tst.project.page.PageBean;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberDaoC {
	public int updateMemberDetail(MemberBean memberBean);
	
	/**
	 * 修改账单信息
	 * @param memberBillBean
	 * @return
	 */
	public int updateMemberBill(MemberBillBean memberBillBean);
	/**
	 * 用户提现列表
	 * @author sjb
	 * @param memberWithdrawBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberWithdrawBean> getMemberWithdraws(MemberWithdrawBean memberWithdrawBean,PageBean pageBean);
	/**
	 * 提现详情
	 * @author sjb
	 * @param memberWithdrawBean
	 * @return
	 */
	public Map<String, Object> getMemberWithdrawDetail(MemberWithdrawBean memberWithdrawBean);
	
	/**
	 * 修改提现状态
	 * @author sjb
	 * @param memberWithdrawBean
	 * @return
	 */
	public int updateMemberWithdraw(MemberWithdrawBean memberWithdrawBean);
	
	
	/**
	 * 账单明细入库
	 * @param memberBillBean
	 * @return
	 */
	public int insertMemberBill(MemberBillBean memberBillBean);
	/**
	 * 店铺列表
	 * @author sjb
	 * @param shopBean
	 * @return
	 */
	public List<ShopBean> getShops(ShopBean shopBean,PageBean pageBean);
	/**
	 * 店铺详情
	 * @author sjb
	 * @param shopBean
	 * @return
	 */
	public ShopBean getShopDetail(ShopBean shopBean);
	/**
	 * 修改店铺
	 * @author sjb
	 * @param shopBean
	 * @return
	 */
	public int updateShop(ShopBean shopBean);
	
	/**
	 * 添加店铺
	 * @author sjb
	 * @param shopBean
	 * @return
	 */
	public int insertShop(ShopBean shopBean);
	
	/**
	 * 审核实名认证
	 * @author sjb
	 * @param realnameBean
	 * @return
	 */
	public int examineMemberRelaname(RealnameBean realnameBean);
	
	/**
	 * 实名认证申请列表
	 * @author sjb
	 * @param realnameBean
	 * @param pageBean
	 * @return
	 */
	public List<RealnameBean> getMemberRealnames(RealnameBean realnameBean,PageBean pageBean);
	
	/**
	 * 用户列表
	 * @param memberBean
	 * @param pageBean
	 * @return
	 */
	List<MemberBean> getMembers(MemberBean memberBean, PageBean pageBean);

	/**
	 * 用户详情
	 * @param memberBean
	 * @return
	 */
	MemberBean getMemberDetail(MemberBean memberBean);

	/**
	 * 删除用户
	 * @param memberBean
	 * @return
	 */
	int deleteMember(MemberBean memberBean);

	/**
	 * 修改用户信息
	 * @param memberBean
	 * @return
	 */
	int updateMember(MemberBean memberBean);
	
	/**
	 * 修改用户余额
	 * @param memberBean
	 * @return
	 */
	int updateMemberBalance(MemberBean memberBean);

}
