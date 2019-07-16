package tst.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tst.project.aspect.AppController;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.MemberBillBean;
import tst.project.bean.member.MemberWithdrawBean;
import tst.project.bean.member.RealnameBean;
import tst.project.bean.product.ShopBean;
import tst.project.interfaces.IMemberService;
import tst.project.page.PageBean;


@Controller
@RequestMapping("/memberController/v1.0")
public class MemberController {
	@Autowired
	IMemberServiceC memberServiceC;
	
	@Autowired
	IMemberService memberService;
	
	@RequestMapping("/getMemberBills")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getMemberBills(MemberBillBean memberBillBean,PageBean pageBean) throws Exception {
		return memberService.getMemberBills(memberBillBean,pageBean);
	}
	
	@RequestMapping("/getMemberWithdraws")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getMemberWithdraws(MemberWithdrawBean memberWithdrawBean,PageBean pageBean) throws Exception{
		return memberServiceC.getMemberWithdraws(memberWithdrawBean,pageBean);
	}
	
	@RequestMapping("/updateMemberWithdraw")
	@AppController(isVerSystemToken = true)
	public Object updateMemberWithdraw(MemberWithdrawBean memberWithdrawBean) throws Exception{
		return memberServiceC.updateMemberWithdraw(memberWithdrawBean);
	}
	
	
	@RequestMapping("/updateMemberBalance")
	@AppController(isVerSystemToken = true)
	public Object updateMemberBalance(MemberBean memberBean) throws Exception{
		return memberServiceC.updateMemberBalance(memberBean);
	}
	
	
	@RequestMapping("/getShops")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getShops(ShopBean shopBean,PageBean pageBean) throws Exception{
		return memberServiceC.getShops(shopBean,pageBean);
	}
	
	@RequestMapping("/getShopDetail")
	@AppController(isVerSystemToken = true)
	public Object getShopDetail(ShopBean shopBean) throws Exception{
		return memberServiceC.getShopDetail(shopBean);
	}
	@RequestMapping("/examineShop")
	@AppController(isVerSystemToken = true)
	public Object examineShop(ShopBean shopBean) throws Exception{
		return memberServiceC.examineShop(shopBean);
	}
	@RequestMapping("/updateShop")
	@AppController(isVerSystemToken = true)
	public Object updateShop(ShopBean shopBean) throws Exception{
		return memberServiceC.updateShop(shopBean);
	}
	@RequestMapping("/insertShop")
	@AppController(isVerSystemToken = true)
	public Object insertShop(ShopBean shopBean) throws Exception{
		return memberServiceC.insertShop(shopBean);
	}
	
	@RequestMapping("/examineMemberRelaname")
	@AppController(isVerSystemToken = true)
	public Object examineMemberRelaname(RealnameBean realnameBean) throws Exception{
		return memberServiceC.examineMemberRelaname(realnameBean);
	}
	
	@RequestMapping("/getMemberRealnames")
	@AppController(isVerSystemToken = true, isPage = true)
	public Object getMemberRealnames(RealnameBean realnameBean, PageBean pageBean) throws Exception{
		return memberServiceC.getMemberRealnames(realnameBean,pageBean);
	}
	
	/**
	 * 用户,商家列表
	 */
	@RequestMapping("/getMembers")
	@AppController(isVerSystemToken = true, isPage = true)
	public Object getMembers(MemberBean memberBean, PageBean pageBean) throws Exception{
		return memberServiceC.getMembers(memberBean,pageBean);
	}



	/**
	 * 更新用户,商家
	 * @param memberBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateMember")
	@AppController(isVerSystemToken=true)
	public Object updateMember(MemberBean memberBean) throws Exception{
		return memberServiceC.updateMember(memberBean);
	}

	/**
	 * 删除用户,商家
	 * @param memberBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteMember")
	@AppController(isVerSystemToken=true)
	public Object deleteMember(MemberBean memberBean) throws Exception{
		return memberServiceC.deleteMember(memberBean);
	}

	/**
	 * 用户,商家详情
	 * @param memberBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMemberDetail")
	@AppController(isVerSystemToken=true)
	public Object getMemberDetail(MemberBean memberBean) throws Exception{
		return memberServiceC.getMemberDetail(memberBean);
	}

}
