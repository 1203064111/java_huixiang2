package tst.project.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tst.project.aspect.AppException;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.MemberBillBean;
import tst.project.bean.member.MemberWithdrawBean;
import tst.project.bean.member.RealnameBean;
import tst.project.bean.product.ShopBean;
import tst.project.controller.IMemberServiceC;
import tst.project.dao.controller.MemberDaoC;
import tst.project.page.PageBean;
import tst.project.utils.NumberUtils;
import tst.project.utils.PayUtils;
import tst.project.utils.UUIDUtils;
import tst.project.utils.WXUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lhw
 */
@Service
@Transactional(rollbackFor=AppException.class)
public class MemberServiceC implements IMemberServiceC {
	@Autowired
	MemberDaoC memberDaoC;
	
	@Value("${wx_lite_AppID}")
	private String wx_lite_appid;

	@Value("${wx_lite_AppSecret}")
	private String wx_lite_appsecret;

	@Value("${weixin_lite_partnerkey}")
	private String wx_lite_partnerkey;

	@Value("${weixin_lite_mchid}")
	private String wx_lite_mch_id;
	
	@Value("${erqi_wx_lite_AppID}")
	private String erqi_wx_lite_appid;

	@Value("${erqi_wx_lite_AppSecret}")
	private String erqi_wx_lite_appsecret;

	@Value("${erqi_weixin_lite_partnerkey}")
	private String erqi_wx_lite_partnerkey;

	@Value("${erqi_weixin_lite_mchid}")
	private String erqi_wx_lite_mch_id;
	
	@Value("${is_real_pay}")
	private String is_real_pay;
	
	@Value("${img_path}")
	private String img_path;
	
	@Override
	public Object getMemberWithdraws(MemberWithdrawBean memberWithdrawBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MemberWithdrawBean> memberWithdrawBeans=memberDaoC.getMemberWithdraws(memberWithdrawBean, pageBean);
		return pageBean.setObject(memberWithdrawBeans);
	}
	
	@Override
	public Object updateMemberWithdraw(MemberWithdrawBean memberWithdrawBean) {
		// TODO Auto-generated method stub
	
		
		int num=memberDaoC.updateMemberWithdraw(memberWithdrawBean);
		if (num <= 0) {
			throw new AppException("保存失败!");
		}
		if("3".equals(memberWithdrawBean.getWithdraw_state())){
			Map<String, Object> memberWithdrawBean2=memberDaoC.getMemberWithdrawDetail(memberWithdrawBean);
			
			MemberBean memberBean = memberDaoC.getMemberDetail(
					new MemberBean().setMember_id(NumberUtils.Integer(memberWithdrawBean.getMember_id())));
			if(memberBean==null){
				throw new AppException("用户不存在!");
			}
			double member_ing_withdrawal = NumberUtils.Double(memberBean.getMember_ing_withdrawal());// 正在提现金额
			double member_balance = NumberUtils.Double(memberBean.getMember_balance());// 现有余额
			double withdrawals_price = NumberUtils.Double(memberWithdrawBean2.get("withdraw_price")+"");// 本次提现金额

			num = memberDaoC.updateMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id())
					.setMember_balance((member_balance + withdrawals_price) + "")
					.setMember_ing_withdrawal((member_ing_withdrawal - withdrawals_price) + ""));
			if (num <= 0) {
				throw new AppException("用户余额更新失败!");
			}
			
			num=memberDaoC.updateMemberBill(new MemberBillBean()
					.setWithdraw_id(memberWithdrawBean.getWithdraw_id())
					.setBill_desc("余额提现被拒绝"));
		}else if("4".equals(memberWithdrawBean.getWithdraw_state())){
			Map<String, Object> memberWithdrawBean2=memberDaoC.getMemberWithdrawDetail(memberWithdrawBean);
			double withdraw_price=NumberUtils.Double(memberWithdrawBean2.get("withdraw_price")+"");
			String partner_trade_no = new UUIDUtils(0).nextId(false, 10) + "";
			
			MemberBean memberBean = memberDaoC.getMemberDetail(
					new MemberBean().setMember_id(NumberUtils.Integer(memberWithdrawBean.getMember_id())));
			if(memberBean==null){
				throw new AppException("用户不存在!");
			}
			double member_ing_withdrawal = NumberUtils.Double(memberBean.getMember_ing_withdrawal());// 正在提现金额
			double member_end_withdrawal = NumberUtils.Double(memberBean.getMember_end_withdrawal());// 现有余额
			double withdrawals_price = NumberUtils.Double(memberWithdrawBean2.get("withdraw_price")+"");// 本次提现金额

			num = memberDaoC.updateMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id())
					.setMember_end_withdrawal((member_end_withdrawal + withdrawals_price) + "")
					.setMember_ing_withdrawal((member_ing_withdrawal - withdrawals_price) + ""));
			if (num <= 0) {
				throw new AppException("用户余额更新失败!");
			}
			
			num=memberDaoC.updateMemberWithdraw(new MemberWithdrawBean()
					.setWithdraw_id(memberWithdrawBean.getWithdraw_id())
					.setPartner_trade_no(partner_trade_no));
			if (num <= 0) {
				throw new AppException("交易失败!");
			}
			num=memberDaoC.updateMemberBill(new MemberBillBean()
					.setWithdraw_id(memberWithdrawBean.getWithdraw_id())
					.setBill_desc("余额提现打款成功"));
			
			
			Map<String, Object> map = new HashMap<String, Object>();
			 map.put("path", img_path+"wx_lite.p12");
			 map.put("mchid", erqi_wx_lite_mch_id);
			 map.put("mch_appid",erqi_wx_lite_appid);
			 
			 map.put("openid", memberWithdrawBean2.get("openid")+"");
			 map.put("partner_trade_no", partner_trade_no);// total_fee
			 map.put("amount", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(withdraw_price * 100) : 40);
			 map.put("desc", "提现");
			 map.put("wx_appsecret", erqi_wx_lite_appsecret);
			 map.put("wx_partnerkey", erqi_wx_lite_partnerkey);
			 
			 Map<String,Object> resultMap=PayUtils.transfers(map);
			 if(!"ok".equals(resultMap.get("status")+"")){
				 throw new AppException(resultMap.get("error")+"");
			 }
		}
		return num;
	}
	
	@Override
	public Object updateMemberBalance(MemberBean memberBean) {
		// TODO Auto-generated method stub
		int num=memberDaoC.insertMemberBill(new MemberBillBean()
				.setMember_id(memberBean.getMember_id()+"")
				.setBill_type("6")
				.setBill_desc("后台充值")
				.setBill_value(memberBean.getMember_balance()));
		if (num <= 0) {
			throw new AppException("账号明细入库失败!");
		}
		
		num=memberDaoC.updateMemberBalance(memberBean);
		if (num <= 0) {
			throw new AppException("余额更新失败!");
		}
		return num;
	}
	
	@Override
	public Object getShops(ShopBean shopBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<ShopBean> shopBeans=memberDaoC.getShops(shopBean, pageBean);
		return pageBean.setObject(shopBeans);
	}
	
	@Override
	public Object getShopDetail(ShopBean shopBean) {
		// TODO Auto-generated method stub
		return memberDaoC.getShopDetail(shopBean);
	}
	
	@Override
	public Object examineShop(ShopBean shopBean) {
		// TODO Auto-generated method stub
		int num = memberDaoC.updateShop(shopBean);
		if (num <= 0) {
			throw new AppException("修改失败!");
		}
		if("2".equals(shopBean.getApply_state())){
			num = memberDaoC.updateMember(new MemberBean()
					.setMember_id(NumberUtils.Integer(shopBean.getMember_id()))
					.setMember_type("2")
					.setShop_id(shopBean.getShop_id()+""));
			if (num <= 0) {
				throw new AppException("审核失败!");
			}
		}
		return num;
	}
	
	@Override
	public Object updateShop(ShopBean shopBean) {
		// TODO Auto-generated method stub
		int num = memberDaoC.updateShop(shopBean);
		if (num <= 0) {
			throw new AppException("修改失败!");
		}
		return num;
	}
	
	@Override
	public Object insertShop(ShopBean shopBean) {
		// TODO Auto-generated method stub
		int num = memberDaoC.insertShop(shopBean);
		if (num <= 0) {
			throw new AppException("审核失败!");
		}
		
		
		return num;
	}
	
	@Override
	public Object examineMemberRelaname(RealnameBean realnameBean) {
		// TODO Auto-generated method stub
		int num = memberDaoC.examineMemberRelaname(realnameBean);

		if (num <= 0) {
			throw new AppException("审核失败!");
		}
		return num;
	}
	
	@Override
	public Object getMemberRealnames(RealnameBean realnameBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<RealnameBean> realnameBeans=memberDaoC.getMemberRealnames(realnameBean, pageBean);
		return pageBean.setObject(realnameBeans);
	}
	
	

	@Override
	public Object updateMember(MemberBean memberBean) {
		// TODO Auto-generated method stub
		int num=memberDaoC.updateMember(memberBean);
		if(num<=0){
			throw new AppException("修改失败!");
		}
		return num;
	}

	@Override
	public Object deleteMember(MemberBean memberBean) {
		// TODO Auto-generated method stub
		int num=memberDaoC.deleteMember(memberBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}

	@Override
	public Object getMemberDetail(MemberBean memberBean) {
		return memberDaoC.getMemberDetail(memberBean);
	}

	@Override
	public Object getMembers(MemberBean memberBean, PageBean pageBean) {
		List<MemberBean> memberBeans = memberDaoC.getMembers(memberBean, pageBean);
		if(memberBeans!=null){
			for (int i = 0; i < memberBeans.size(); i++) {
				MemberBean memberBean2=memberBeans.get(i);
				String member_nick_name = "";
				try {
					member_nick_name = URLDecoder.decode(memberBean2.getMember_nick_name(), "utf-8");
					memberBean2.setMember_nick_name(member_nick_name);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return pageBean.setObject(memberBeans);
	}
	
}
