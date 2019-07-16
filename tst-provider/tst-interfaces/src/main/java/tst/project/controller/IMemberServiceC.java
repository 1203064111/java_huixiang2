package tst.project.controller;

import tst.project.bean.member.MemberBean;
import tst.project.bean.member.MemberWithdrawBean;
import tst.project.bean.member.RealnameBean;
import tst.project.bean.product.ShopBean;

import tst.project.page.PageBean;

/**
 * @author lhw
 */
public interface IMemberServiceC {

	/**
	 * 用户提现列表
	 * @author sjb
	 * @param memberWithdrawBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberWithdraws(MemberWithdrawBean memberWithdrawBean,PageBean pageBean);
	
	/**
	 * 修改提现状态
	 * @author sjb
	 * @param memberWithdrawBean
	 * @return
	 */
	public Object updateMemberWithdraw(MemberWithdrawBean memberWithdrawBean);
	
	/**
	 * 用户充值金额
	 * @author sjb
	 * @param memberBean
	 * @return
	 */
	public Object updateMemberBalance(MemberBean memberBean);
	/**
	 * 店铺列表
	 * @author sjb
	 * @param shopBean
	 * @return
	 */
	public Object getShops(ShopBean shopBean,PageBean pageBean);
	/**
	 * 店铺详情
	 * @author sjb
	 * @param shopBean
	 * @return
	 */
	public Object getShopDetail(ShopBean shopBean);
	
	/**
	 * 审核店铺
	 * @author sjb
	 * @param shopBean
	 * @return
	 */
	public Object examineShop(ShopBean shopBean);
	/**
	 * 修改店铺
	 * @author sjb
	 * @param shopBean
	 * @return
	 */
	public Object updateShop(ShopBean shopBean);
	/**
	 * 添加店铺
	 * @author sjb
	 * @param shopBean
	 * @return
	 */
	public Object insertShop(ShopBean shopBean);
	
	/**
	 * 审核实名认证
	 * @author sjb
	 * @param realnameBean
	 * @return
	 */
	public Object examineMemberRelaname(RealnameBean realnameBean);
	
	/**
	 * 实名认证申请列表
	 * @author sjb
	 * @param realnameBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberRealnames(RealnameBean realnameBean,PageBean pageBean);

    /**
     * 更新用户表
     * @param memberBean
     * @return
     */
    Object updateMember(MemberBean memberBean);

    /**
     * 删除用户表
     * @param memberBean
     * @return
     */
    Object deleteMember(MemberBean memberBean);

    /**
     * 获取用户信息
     * @param memberBean
     * @return
     */
    Object getMemberDetail(MemberBean memberBean);

    /**
     * 获取用户列表
     * @param memberBean
     * @param pageBean
     * @return
     */
    Object getMembers(MemberBean memberBean, PageBean pageBean);

}
