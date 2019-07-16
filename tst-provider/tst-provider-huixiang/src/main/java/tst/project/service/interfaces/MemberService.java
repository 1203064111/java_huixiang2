package tst.project.service.interfaces;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppException;
import tst.project.bean.CodeBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.MemberBillBean;
import tst.project.bean.member.MemberMsgBean;
import tst.project.bean.member.MemberWithdrawBean;
import tst.project.bean.member.RealnameBean;
import tst.project.bean.wx.WXPubBean;
import tst.project.bean.wx.WxLiteBean;
import tst.project.dao.interfaces.MemberDao;
import tst.project.dao.interfaces.SettingDao;
import tst.project.interfaces.IMemberService;
import tst.project.page.PageBean;
import tst.project.utils.DecryptUtil;
import tst.project.utils.MD5Util;
import tst.project.utils.NumberUtils;
import tst.project.utils.RedisUtils;
import tst.project.utils.StringUtils;
import tst.project.utils.TimeUtils;
import tst.project.utils.WXUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService implements IMemberService {

	@Autowired
	MemberDao memberDao;

	@Autowired
	private SettingDao settingDao;

	@Value("${erqi_wx_public_secret}")
	private String erqi_wx_public_secret;

	@Value("${erqi_wx_public_app_id}")
	private String erqi_wx_public_app_id;

	@Value("${erqi_wx_app_secret}")
	private String erqi_wx_app_secret;
	@Value("${erqi_wx_app_id}")
	private String erqi_wx_app_id;

	@Value("${wx_lite_AppID}")
	private String wx_lite_AppID;

	@Value("${wx_lite_AppSecret}")
	private String wx_lite_AppSecret;

	@Value("${wx_pub_appid}")
	private String wx_pub_appid;

	@Value("${wx_pub_appsecret}")
	private String wx_pub_appsecret;

	@Override
	public Object test(List<Map> maps) {
		// TODO Auto-generated method stub
		return memberDao.test(maps);
	}

	@Override
	public Object insertMemberWithdraw(MemberWithdrawBean memberWithdrawBean) {
		// TODO Auto-generated method stub
		int num = memberDao.insertMemberWithdraw(memberWithdrawBean);
		if (num > 0) {
			MemberBean memberBean = memberDao.getMemberDetail(
					new MemberBean().setMember_id(NumberUtils.Integer(memberWithdrawBean.getMember_id())));

			double member_ing_withdrawal = NumberUtils.Double(memberBean.getMember_ing_withdrawal());// 正在提现金额
			double member_balance = NumberUtils.Double(memberBean.getMember_balance());// 现有余额
			double withdrawals_price = NumberUtils.Double(memberWithdrawBean.getWithdraw_price());// 本次提现金额

			if (member_balance < withdrawals_price) {
				throw new AppException("超过可提现余额了");
			}

			num = memberDao.updateMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id())
					.setMember_balance((member_balance - withdrawals_price) + "")
					.setMember_ing_withdrawal((member_ing_withdrawal + withdrawals_price) + ""));
			if (num <= 0) {
				throw new AppException("用户余额更新失败!");
			}

			num = memberDao.insertMemberBill(new MemberBillBean().setMember_id(memberWithdrawBean.getMember_id())
					.setBill_type("5").setBill_desc("余额提现申请").setBill_value(withdrawals_price + "")
					.setWithdraw_id(memberWithdrawBean.getWithdraw_id() + ""));
			if (num <= 0) {
				throw new AppException("账号明细入库失败!");
			}
		}
		return num;
	}

	@Override
	public Object getMemberBills(MemberBillBean memberBillBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MemberBillBean> memberBillBeans = memberDao.getMemberBills(memberBillBean, pageBean);
		return pageBean.setObject(memberBillBeans);
	}

	@Override
	public Object getStatistics(MemberBean memberBean) {
		// TODO Auto-generated method stub
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> groupMap = memberDao.getGroupStatistics(memberBean);
		if (groupMap != null) {
			resultMap.put("group_ing_count", groupMap.get("group_ing_count"));
			resultMap.put("group_end_count", groupMap.get("group_end_count"));
			resultMap.put("group_fail_count", groupMap.get("group_fail_count"));
		} else {
			resultMap.put("group_ing_count", 0);
			resultMap.put("group_end_count", 0);
			resultMap.put("group_fail_count", 0);
		}

		Map<String, Object> footprintMap = memberDao.getFootprintStatistics(memberBean);
		if (footprintMap != null) {
			resultMap.put("footprint_count", footprintMap.get("footprint_count"));
		} else {
			resultMap.put("footprint_count", 0);
		}

		Map<String, Object> collectionMap = memberDao.getCollectionStatistics(memberBean);
		if (collectionMap != null) {
			resultMap.put("collection_product_count", collectionMap.get("collection_product_count"));
			resultMap.put("collection_shop_count", collectionMap.get("collection_shop_count"));
		} else {
			resultMap.put("collection_product_count", 0);
			resultMap.put("collection_shop_count", 0);
		}
		return resultMap;
	}

	@Override
	public RealnameBean getMemberRelaname(RealnameBean realnameBean) {
		// TODO Auto-generated method stub
		return memberDao.getMemberRelaname(realnameBean);
	}

	@Override
	public Object insetMemberRelaname(RealnameBean realnameBean) {
		// TODO Auto-generated method stub
		int num = 0;
		RealnameBean realnameBean2 = memberDao.getMemberRelaname(realnameBean);
		if (realnameBean2 == null) {
			num = memberDao.insetMemberRelaname(realnameBean);
			if (num <= 0) {
				throw new AppException("申请失败!");
			}
		} else {
			if ("1".equals(realnameBean2.getRealname_state())) {
				throw new AppException("已在审核中!");
			} else if ("2".equals(realnameBean2.getRealname_state())) {
				throw new AppException("审核已通过!");
			}
			num = memberDao.updateMemberRealname(realnameBean);
			if (num <= 0) {
				throw new AppException("申请失败!");
			}
		}

		return num;
	}

	@Override
	public Object outLogin(MemberBean memberBean) {
		// TODO Auto-generated method stub

		UUID uuid = UUID.randomUUID();
		int num = memberDao.updateMemberDetail(memberBean.setMember_token(uuid.toString()));
		if (num <= 0) {
			throw new AppException("退出失败!");
		}

		boolean is_success = RedisUtils.setKey("member_id" + memberBean.getMember_id(), uuid.toString());
		if (!is_success) {
			throw new AppException("缓存失败!");
		}

		return num;
	}

	@Override
	public MemberBean getMemberDetail(MemberBean memberBean) {
		// TODO Auto-generated method stub
		MemberBean memberBean2 = memberDao.getMemberDetail(memberBean);
		if (memberBean2 != null) {
			if ("1".equals(memberBean2.getMember_state())) {
				throw new AppException("该账户已被拉黑!");
			}

			if (!StringUtils.isNull(memberBean2.getMember_nick_name())) {
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

		return memberBean2;
	}

	@Override
	public MemberBean getOtherMemberDetail(MemberBean memberBean) {
		// TODO Auto-generated method stub
		MemberBean memberBean2 = memberDao.getOtherMemberDetail(memberBean);
		if (memberBean2 != null) {
			if (!StringUtils.isNull(memberBean2.getMember_nick_name())) {
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

		return memberBean2;
	}

	@Override
	public int updateMemberDetail(MemberBean memberBean) {
		// TODO Auto-generated method stub
		return memberDao.updateMemberDetail(memberBean);
	}

	@Override
	public Object registerMember(MemberBean memberBean, CodeBean codeBean) {
		// TODO Auto-generated method stub
		if (memberBean.getMember_account() == null || memberBean.getMember_account().length() != 11) {
			throw new AppException("手机号非法!");
		}

		if (settingDao.getCodeBeanByMobileAndCode(codeBean.setMobile(memberBean.getMember_account())
				.setCode_type("register").setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			throw new AppException("此验证码已过期!");
		}

		MemberBean memberBean2 = memberDao
				.getMemberDetail(new MemberBean().setMember_account(memberBean.getMember_account()));
		if (memberBean2 != null) {
			throw new AppException("该手机号已注册过!");
		}

		try {
			String pass = "";
			try {
				pass = MD5Util.md5Encode(memberBean.getMember_password());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new AppException("加密失败!");
			}

			if (StringUtils.isNull(memberBean.getMember_nick_name())) {
				String member_nick_name = NumberUtils.createRandom(false, 10);
				memberBean.setMember_nick_name(member_nick_name);
			}
			int num = memberDao
					.registerMember(memberBean.setMember_password(pass).setMember_token(UUID.randomUUID().toString()));

			if (num > 0) {
				settingDao.deleteCodeByMobileAndCode(codeBean);
				return memberDao.getMemberDetail(memberBean);
			} else {
				throw new AppException("注册失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

	}

	@Override
	public Object loginMember(MemberBean memberBean) {
		// TODO Auto-generated method stub
		String member_password = "";
		try {
			member_password = MD5Util.md5Encode(memberBean.getMember_password());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("加密失败!");
		}
		UUID uuid = UUID.randomUUID();

		MemberBean memberBean2 = memberDao.getMemberDetail(memberBean.setMember_password(""));
		if (memberBean2 == null) {
			throw new AppException("该手机号还未注册!");
		}
		if ("1".equals(memberBean2.getMember_state())) {
			throw new AppException("该账户已被拉黑!");
		}
		if (!StringUtils.isNull(memberBean2.getMember_nick_name())) {
			String member_nick_name = "";
			try {
				member_nick_name = URLDecoder.decode(memberBean2.getMember_nick_name(), "utf-8");
				memberBean2.setMember_nick_name(member_nick_name);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!member_password.equals(memberBean2.getMember_password())) {
			throw new AppException("密码错误!");
		}

		int num = memberDao.updateMemberDetail(
				new MemberBean().setMember_id(memberBean2.getMember_id()).setMember_token(uuid.toString()));
		if (num <= 0) {
			throw new AppException("token更新失败");
		}

		boolean is_success = RedisUtils.setKey("member_id" + memberBean2.getMember_id(), uuid.toString());
		if (!is_success) {
			throw new AppException("缓存失败!");
		}
		return memberBean2.setMember_token(uuid.toString()).setMember_password("2");
	}

	@Override
	public Object loginMemberByCode(MemberBean memberBean, CodeBean codeBean) {
		// TODO Auto-generated method stub

		UUID uuid = UUID.randomUUID();

		MemberBean memberBean2 = memberDao.getMemberDetail(memberBean);
		if (memberBean2 == null) {
			throw new AppException("该手机号还未注册!");
		}
		if ("1".equals(memberBean2.getMember_state())) {
			throw new AppException("该账户已被拉黑!");
		}
		if (!StringUtils.isNull(memberBean2.getMember_nick_name())) {
			String member_nick_name = "";
			try {
				member_nick_name = URLDecoder.decode(memberBean2.getMember_nick_name(), "utf-8");
				memberBean2.setMember_nick_name(member_nick_name);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 验证码
		if (settingDao.getCodeBeanByMobileAndCode(codeBean.setMobile(memberBean.getMember_account())
				.setCode_type("login").setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			throw new AppException("此验证码已过期!");
		}

		int num = memberDao.updateMemberDetail(
				new MemberBean().setMember_id(memberBean2.getMember_id()).setMember_token(uuid.toString()));
		if (num <= 0) {
			throw new AppException("token更新失败");
		}

		boolean is_success = RedisUtils.setKey("member_id" + memberBean2.getMember_id(), uuid.toString());
		if (!is_success) {
			throw new AppException("缓存失败!");
		}
		settingDao.deleteCodeByMobileAndCode(codeBean);
		return memberBean2.setMember_token(uuid.toString());
	}

	@Override
	public Object wxPublicMemberInfo(String code) {
		// TODO Auto-generated method stub

		WXPubBean wxPubBean = WXUtils.getWXUserInfo(erqi_wx_public_app_id, erqi_wx_public_secret, code);
		if (wxPubBean == null) {
			throw new AppException("微信code有误");
		}
		return wxPubBean;
	}

	@Override
	public Object wxPubLoginMember(String code, String is_bind_mobile) {
		// TODO Auto-generated method stub

		WXPubBean wxPubBean = WXUtils.getWXUserInfo(wx_pub_appid, wx_pub_appsecret, code);
		if (wxPubBean == null) {
			throw new AppException("微信code有误");
		}
		UUID uuid = UUID.randomUUID();
		MemberBean memberBean2 = new MemberBean().setWeixin_pub_open_id(wxPubBean.getOpenid())
				.setUnionid(wxPubBean.getUnionid()).setMember_nick_name(wxPubBean.getNickname())
				.setMember_img(wxPubBean.getHeadimgurl()).setMember_token(uuid.toString());

		MemberBean memberBean1 = memberDao.getMemberDetail(new MemberBean().setUnionid(wxPubBean.getUnionid()));
		if (memberBean1 != null) {
			int num = memberDao.updateMemberDetail(
					memberBean1.setMember_token(uuid.toString()).setWeixin_pub_open_id(wxPubBean.getOpenid()));
			if (num <= 0) {
				throw new AppException("更新失败");
			}
		} else {
			if ("1".equals(is_bind_mobile)) {// 需要绑定手机号 先不注册入库
				return new MemberBean().setWeixin_lite_open_id(wxPubBean.getOpenid())
						.setMember_nick_name(wxPubBean.getNickname()).setMember_img(wxPubBean.getHeadimgurl());
			} else {
				String pass = "";
				String t = NumberUtils.createRandom(true, 6);
				boolean is_success = false;
				try {
					pass = MD5Util.md5Encode(NumberUtils.createRandom(false, 10));

				} catch (Exception e) {
					// TODO: handle exception
				}

				String incode = NumberUtils.createRandom(false, 7); // 生成七位数的邀请码
				int num = memberDao.registerMember(memberBean2.setMember_token(uuid.toString()));
				if (num > 0) {
					memberBean1 = memberDao.getMemberDetail(new MemberBean().setMember_id(memberBean2.getMember_id()));
				} else {
					throw new AppException("注册失败");
				}
			}
		}

		boolean is_success = RedisUtils.setKey("member_id" + memberBean1.getMember_id(), uuid.toString());
		if (!is_success) {
			throw new AppException("缓存失败!");
		}

		return memberBean1.setMember_password("");
	}

	@Override
	public Object wxLiteLoginMember(String code, String is_bind_mobile, String decryptData, String iv) {
		// TODO Auto-generated method stub
		WXPubBean wxPubBean = WXUtils.getWXLiteUserInfo(wx_lite_AppID, wx_lite_AppSecret, code);
		if (wxPubBean == null) {
			throw new AppException("微信code有误");
		}

		WxLiteBean wxLiteBean = null;
		if (!StringUtils.isNull(decryptData)) {
			try {
				String decryptJsUserInfo = DecryptUtil.decryptJsUserInfo(decryptData, iv, wxPubBean.getSession_key());
				System.out.println(decryptJsUserInfo + "-------");
				if (decryptJsUserInfo == null) {
					throw new AppException("解密失败");
				}
				System.out.print(decryptJsUserInfo);
				wxLiteBean = JSON.parseObject(decryptJsUserInfo, WxLiteBean.class);
			} catch (Exception e) {
				// TODO: handle exception
				throw new AppException("解密失败2");
			}
		}

		UUID uuid = UUID.randomUUID();

		MemberBean memberBean1 = memberDao.getMemberDetail(new MemberBean().setUnionid(wxLiteBean.getUnionId()));
		if (memberBean1 != null) {
			int num = memberDao.updateMemberDetail(
					memberBean1.setMember_token(uuid.toString()).setWeixin_lite_open_id(wxPubBean.getOpenid()));
			if (num <= 0) {
				throw new AppException("更新失败");
			}

			boolean is_success = RedisUtils.setKey("member_id" + memberBean1.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败");
			}
		} else {

			if ("1".equals(is_bind_mobile)) {// 需要绑定手机号 先不注册入库
				return new MemberBean().setWeixin_lite_open_id(wxPubBean.getOpenid())
						.setMember_nick_name(wxPubBean.getNickname()).setMember_img(wxPubBean.getHeadimgurl());
			} else {
				String nickName = wxLiteBean.getNickName();
				try {
					nickName = URLEncoder.encode(wxLiteBean.getNickName(), "utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					// throw new AppException("转化失败");
				}

				MemberBean memberBean2 = new MemberBean().setWeixin_lite_open_id(wxPubBean.getOpenid())
						.setUnionid(wxLiteBean.getUnionId()).setMember_token(uuid.toString())
						.setMember_nick_name(nickName).setMember_img(wxLiteBean.getAvatarUrl());
				boolean is_success = false;

				int num = memberDao.registerMember(memberBean2.setMember_token(uuid.toString()));
				if (num > 0) {
					memberBean1 = memberDao.getMemberDetail(new MemberBean().setMember_id(memberBean2.getMember_id()));
				} else {
					throw new AppException("注册失败");
				}

				is_success = RedisUtils.setKey("member_id" + memberBean1.getMember_id(), uuid.toString());
				if (!is_success) {
					throw new AppException("缓存失败!");
				}
			}
		}

		String member_nick_name = "";
		try {
			member_nick_name = URLDecoder.decode(memberBean1.getMember_nick_name(), "utf-8");
			memberBean1.setMember_nick_name(member_nick_name);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberBean1.setMember_password("");
	}

	@Override
	public Object wxLitBindMobile(MemberBean memberBean, CodeBean codeBean) {
		// TODO Auto-generated method stub

		if (memberBean.getMember_account() == null || memberBean.getMember_account().length() != 11) {
			throw new AppException("手机号非法!");
		}

		if (settingDao.getCodeBeanByMobileAndCode(
				codeBean.setMobile(memberBean.getMember_account()).setCode_type("binding_mobile")
						.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			throw new AppException("此验证码已过期!");
		}

		MemberBean memberBean2 = memberDao
				.getMemberDetail(new MemberBean().setMember_account(memberBean.getMember_account()));

		UUID uuid = UUID.randomUUID();

		if (memberBean2 != null) {// 该手机号已经注册过
			if (!StringUtils.isNull(memberBean2.getWeixin_lite_open_id())) {
				throw new AppException("该手机号已绑定小程序");
			}

			int num = memberDao.updateMemberDetail(new MemberBean().setMember_id(memberBean2.getMember_id())
					.setWeixin_lite_open_id(memberBean.getWeixin_lite_open_id())
					.setMember_img(memberBean.getMember_img()).setMember_nick_name(memberBean.getMember_nick_name())
					.setMember_token(uuid.toString()));
			if (num <= 0) {
				throw new AppException("更新失败");
			}

			boolean is_success = RedisUtils.setKey("member_id" + memberBean2.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}

			settingDao.deleteCodeByMobileAndCode(codeBean);

			return memberBean2.setMember_id(memberBean2.getMember_id())
					.setWeixin_lite_open_id(memberBean.getWeixin_lite_open_id())
					.setMember_img(memberBean.getMember_img()).setMember_nick_name(memberBean.getMember_nick_name())
					.setMember_token(uuid.toString()).setMember_password("");
		} else {

			boolean is_success = false;

			int num = memberDao.registerMember(memberBean.setMember_token(uuid.toString()));
			if (num <= 0) {
				throw new AppException("注册失败!");
			}

			MemberBean memberBean3 = memberDao
					.getMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id()));

			is_success = RedisUtils.setKey("member_id" + memberBean3.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}

			settingDao.deleteCodeByMobileAndCode(codeBean);
			return memberBean3.setMember_password("");
		}
	}

	@Override
	public Object wxLoginMember(MemberBean memberBean) {

		MemberBean memberBean2 = memberDao.getMemberDetail(new MemberBean().setWx_open_id(memberBean.getWx_open_id()));
		if (memberBean2 != null) {// 已经登录过
			if ("1".equals(memberBean2.getMember_state())) {
				throw new AppException("该账户已被拉黑!");
			}
			UUID uuid = UUID.randomUUID();
			int num = memberDao.updateMemberDetail(memberBean2.setMember_token(uuid.toString()));
			if (num <= 0) {
				throw new AppException("更新失败");
			}

			boolean is_success = RedisUtils.setKey("member_id" + memberBean2.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}
			if (!StringUtils.isNull(memberBean2.getMember_nick_name())) {
				String member_nick_name = "";
				try {
					member_nick_name = URLDecoder.decode(memberBean2.getMember_nick_name(), "utf-8");
					memberBean2.setMember_nick_name(member_nick_name);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return memberBean2.setMember_password("");
		} else {// 未登录过 需要绑定手机号
			return memberBean;
		}

	}

	@Override
	public Object wxBindMobile(MemberBean memberBean, CodeBean codeBean) {
		// TODO Auto-generated method stub

		if (memberBean.getMember_account() == null || memberBean.getMember_account().length() != 11) {
			throw new AppException("手机号非法!");
		}

		if (settingDao.getCodeBeanByMobileAndCode(
				codeBean.setMobile(memberBean.getMember_account()).setCode_type("binding_mobile")
						.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			throw new AppException("此验证码已过期!");
		}

		MemberBean memberBean2 = memberDao
				.getMemberDetail(new MemberBean().setMember_account(memberBean.getMember_account()));

		
		UUID uuid = UUID.randomUUID();

		if (memberBean2 != null) {// 该手机号已经注册过
			if ("1".equals(memberBean2.getMember_state())) {
				throw new AppException("该账户已被拉黑!");
			}
			if (!StringUtils.isNull(memberBean2.getWx_open_id())) {
				throw new AppException("该手机号已绑定微信");
			}

			int num = memberDao.updateMemberDetail(new MemberBean().setMember_id(memberBean2.getMember_id())
					.setWx_open_id(memberBean.getWx_open_id()).setMember_img(memberBean.getMember_img())
					.setMember_nick_name(memberBean.getMember_nick_name()).setMember_token(uuid.toString()));
			if (num <= 0) {
				throw new AppException("更新失败");
			}

			boolean is_success = RedisUtils.setKey("member_id" + memberBean2.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}

			settingDao.deleteCodeByMobileAndCode(codeBean);

			return memberBean2.setMember_id(memberBean2.getMember_id()).setWx_open_id(memberBean.getWx_open_id())
					.setMember_img(memberBean.getMember_img()).setMember_nick_name(memberBean.getMember_nick_name())
					.setMember_token(uuid.toString()).setMember_password("");
		} else {
			if (!StringUtils.isNull(memberBean.getMember_nick_name())) {
				String nickName = memberBean.getMember_nick_name();
				try {
					nickName = URLEncoder.encode(memberBean.getMember_nick_name(), "utf-8");
					memberBean.setMember_nick_name(nickName);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					// throw new AppException("转化失败");
				}
			}

			boolean is_success = false;

			int num = memberDao.registerMember(memberBean.setMember_token(uuid.toString()));
			if (num <= 0) {
				throw new AppException("注册失败!");
			}

			MemberBean memberBean3 = memberDao
					.getMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id()));
			if ("1".equals(memberBean3.getMember_state())) {
				throw new AppException("该账户已被拉黑!");
			}
			is_success = RedisUtils.setKey("member_id" + memberBean3.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}

			settingDao.deleteCodeByMobileAndCode(codeBean);
			return memberBean3.setMember_password("");
		}
	}

	@Override
	public Object qqBindMobile(MemberBean memberBean, CodeBean codeBean) {
		// TODO Auto-generated method stub

		if (memberBean.getMember_account() == null || memberBean.getMember_account().length() != 11) {
			throw new AppException("手机号非法!");
		}

		if (settingDao.getCodeBeanByMobileAndCode(
				codeBean.setMobile(memberBean.getMember_account()).setCode_type("binding_mobile")
						.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			throw new AppException("此验证码已过期!");
		}

		MemberBean memberBean2 = memberDao
				.getMemberDetail(new MemberBean().setMember_account(memberBean.getMember_account()));
		
		UUID uuid = UUID.randomUUID();

		if (memberBean2 != null) {// 该手机号已经注册过
			if ("1".equals(memberBean2.getMember_state())) {
				throw new AppException("该账户已被拉黑!");
			}
			if (!StringUtils.isNull(memberBean2.getQq_open_id())) {
				throw new AppException("该手机号已绑定QQ");
			}

			int num = memberDao.updateMemberDetail(new MemberBean().setMember_id(memberBean2.getMember_id())
					.setQq_open_id(memberBean.getQq_open_id()).setMember_img(memberBean.getMember_img())
					.setMember_nick_name(memberBean.getMember_nick_name()).setMember_token(uuid.toString()));
			if (num <= 0) {
				throw new AppException("更新失败");
			}

			boolean is_success = RedisUtils.setKey("member_id" + memberBean2.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}

			settingDao.deleteCodeByMobileAndCode(codeBean);

			return memberBean2.setMember_id(memberBean2.getMember_id()).setQq_open_id(memberBean.getQq_open_id())
					.setMember_img(memberBean.getMember_img()).setMember_nick_name(memberBean.getMember_nick_name())
					.setMember_token(uuid.toString()).setMember_password("");
		} else {
			if (!StringUtils.isNull(memberBean.getMember_nick_name())) {
				String nickName = memberBean.getMember_nick_name();
				try {
					nickName = URLEncoder.encode(memberBean.getMember_nick_name(), "utf-8");
					memberBean.setMember_nick_name(nickName);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					// throw new AppException("转化失败");
				}
			}
			boolean is_success = false;

			int num = memberDao.registerMember(memberBean.setMember_token(uuid.toString()));
			if (num <= 0) {
				throw new AppException("注册失败!");
			}

			MemberBean memberBean3 = memberDao
					.getMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id()));
			if ("1".equals(memberBean3.getMember_state())) {
				throw new AppException("该账户已被拉黑!");
			}
			is_success = RedisUtils.setKey("member_id" + memberBean3.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}

			settingDao.deleteCodeByMobileAndCode(codeBean);
			return memberBean3.setMember_password("");
		}
	}

	@Override
	public Object qqLoginMember(MemberBean memberBean) {
		// TODO Auto-generated method stub
		MemberBean memberBean2 = memberDao.getMemberDetail(new MemberBean().setQq_open_id(memberBean.getQq_open_id()));
		if (memberBean2 != null) {// 已经登录过
			if ("1".equals(memberBean2.getMember_state())) {
				throw new AppException("该账户已被拉黑!");
			}
			UUID uuid = UUID.randomUUID();

			int num = memberDao.updateMemberDetail(memberBean2.setMember_token(uuid.toString()));
			if (num <= 0) {
				throw new AppException("更新失败");
			}

			boolean is_success = RedisUtils.setKey("member_id" + memberBean2.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}
			if (!StringUtils.isNull(memberBean2.getMember_nick_name())) {
				String member_nick_name = "";
				try {
					member_nick_name = URLDecoder.decode(memberBean2.getMember_nick_name(), "utf-8");
					memberBean2.setMember_nick_name(member_nick_name);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return memberBean2.setMember_password("");
		} else {// 未登录过 需要绑定手机号
			return memberBean;
		}

	}

	@Override
	public Object forgetPassword(MemberBean memberBean, CodeBean codeBean) {
		// TODO Auto-generated method stub
		MemberBean memberDetail = memberDao.getMemberDetail(new MemberBean()
				.setMember_account(memberBean.getMember_account()).setMember_type(memberBean.getMember_type()));
		if (memberDetail == null) {
			throw new AppException("此号码未注册");
		}
		if ("1".equals(memberDetail.getMember_state())) {
			throw new AppException("该账户已被拉黑!");
		}
		try {
			if (MD5Util.md5Encode(memberBean.getMember_password()).equals(memberDetail.getMember_password())) {
				throw new AppException("新密码不可以与原密码相同");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("新密码不可以与原密码相同");
		}
		if (settingDao.getCodeBeanByMobileAndCode(
				codeBean.setMobile(memberBean.getMember_account()).setCode_type("forget_password")
						.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			throw new AppException("验证码已过期");
		}

		try {
			memberBean.setMember_password(MD5Util.md5Encode(memberBean.getMember_password()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("密码加密失败");
		}

		int num = memberDao.updateMemberDetail(memberBean);
		if (num > 0) {
			settingDao.deleteCodeByMobileAndCode(codeBean);
		} else {
			throw new AppException("修改密码失败");
		}
		return "密码修改成功";
	}

	@Override
	public Object payPassword(MemberBean memberBean, CodeBean codeBean) {
		if (settingDao.getCodeBeanByMobileAndCode(
				codeBean.setMobile(memberBean.getMember_account()).setCode_type("pay_password")
						.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			throw new AppException("验证码已过期");
		}

		try {
			memberBean.setPay_password(MD5Util.md5Encode(memberBean.getPay_password()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("密码加密失败");
		}

		int num = memberDao.payPassword(memberBean);
		if (num > 0) {
			settingDao.deleteCodeByMobileAndCode(codeBean);
		} else {
			throw new AppException("设置密码失败");
		}
		return "密码设置成功";

	}

	@Override
	public Object getMemberMsgs(MemberMsgBean memberMsgBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MemberMsgBean> memberMsgBeans = memberDao.getMemberMsgs(memberMsgBean, pageBean);
		return pageBean.setObject(memberMsgBeans);
	}

	@Override
	public MemberMsgBean getMemberMsgsDetail(MemberMsgBean memberMsgBean) {
		MemberMsgBean memberMsgBean2 = memberDao.getMemberMsgsDetail(memberMsgBean);
		int num = memberDao
				.updateMemberMsgDetail(new MemberMsgBean().setIs_read("1").setMsg_id(memberMsgBean2.getMsg_id()));
		if (num <= 0) {
			throw new AppException("消息更新失败");
		}
		return memberMsgBean2;
	}
}
