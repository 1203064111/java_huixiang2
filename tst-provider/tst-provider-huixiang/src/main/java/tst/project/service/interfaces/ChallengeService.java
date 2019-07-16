package tst.project.service.interfaces;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import tst.project.aspect.AppException;
import tst.project.bean.challenge.ChallengeCollectionBean;
import tst.project.bean.challenge.ChallengeCommentBean;
import tst.project.bean.challenge.ChallengeFollowBean;
import tst.project.bean.challenge.ChallengeFootprintBean;
import tst.project.bean.challenge.ChallengeShareBean;
import tst.project.bean.challenge.ChallengeWellBean;
import tst.project.bean.challenge.MemberLableBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.order.OrderBean;
import tst.project.bean.product.ProductBean;
import tst.project.bean.product.ProductClassBean;
import tst.project.bean.setting.ChallengeActivityBean;
import tst.project.bean.setting.ChallengeFixedRewardBean;
import tst.project.bean.setting.ChallengeRuleBean;
import tst.project.bean.setting.ChallengeSalesRewardBean;
import tst.project.bean.setting.FixedRewardBean;
import tst.project.bean.setting.MemberChallengeBean;
import tst.project.bean.setting.MemberRewardBean;
import tst.project.bean.setting.PercentBean;
import tst.project.dao.controller.ChallengeDaoC;
import tst.project.dao.controller.GoodsDaoC;
import tst.project.dao.controller.SettingDaoC;
import tst.project.dao.interfaces.ChallengeDao;
import tst.project.dao.interfaces.MemberDao;
import tst.project.interfaces.IChallengeService;
import tst.project.page.PageBean;
import tst.project.utils.NumberUtils;
import tst.project.utils.RedisUtils;
import tst.project.utils.StringUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class ChallengeService implements IChallengeService {
	@Autowired
	ChallengeDao challengeDao;

	@Autowired
	ChallengeDaoC challengeDaoC;

	@Autowired
	SettingDaoC settingDaoC;

	@Autowired
	GoodsDaoC goodsDaoC;

	@Autowired
	MemberDao memberDao;

	@Override
	public Object getChallengeActivitys(ChallengeActivityBean challengeActivityBean, PageBean pageBean) {
		List<ChallengeActivityBean> challengeActivityBeans = challengeDao.getChallengeActivitys(challengeActivityBean,
				pageBean);
		return pageBean.setObject(challengeActivityBeans);
	}

	@Override
	public Object getChallengeRules(ChallengeRuleBean challengeRuleBean, PageBean pageBean) {
		List<ChallengeRuleBean> challengeRuleBeans = challengeDao.getChallengeRules(challengeRuleBean, pageBean);
		return pageBean.setObject(challengeRuleBeans);
	}

	@Override
	public Object getChallengeRuleDetail(ChallengeRuleBean challengeRuleBean) {
		return challengeDao.getChallengeRuleDetail(challengeRuleBean);
	}

	@Override
	public Object getChallengeActivity(ChallengeActivityBean challengeActivityBean) {
		ChallengeActivityBean challengeActivityBean2 = challengeDao.getChallengeActivity(challengeActivityBean);
		if (challengeActivityBean2 != null) {
			ProductBean productBean = goodsDaoC.getProductDetail(
					new ProductBean().setProduct_id(Integer.valueOf(challengeActivityBean2.getProduct_id())));
			if (productBean != null) {
				challengeActivityBean2.setProductBean(productBean);
			}
		}
		return challengeDao.getChallengeActivity(challengeActivityBean);
	}

	@Override
	public Object getCurrentChallengeActivity(ChallengeActivityBean challengeActivityBean) {
		ChallengeActivityBean challengeActivityBean2 = challengeDao.getCurrentChallengeActivity(challengeActivityBean);
		if (challengeActivityBean2 != null) {
			ProductBean productBean = goodsDaoC.getProductDetail(
					new ProductBean().setProduct_id(Integer.valueOf(challengeActivityBean2.getProduct_id())));
			if (productBean != null) {
				challengeActivityBean2.setProductBean(productBean);
			}
		}

		return challengeActivityBean2;
	}
	@Override
	public Object getNextChallengeActivity(ChallengeActivityBean challengeActivityBean) {
		ChallengeActivityBean challengeActivityBean2 = challengeDao.getNextChallengeActivity(challengeActivityBean);
		if (challengeActivityBean2 != null) {
			ProductBean productBean = goodsDaoC.getProductDetail(
					new ProductBean().setProduct_id(Integer.valueOf(challengeActivityBean2.getProduct_id())));
			if (productBean != null) {
				challengeActivityBean2.setProductBean(productBean);
			}
		}

		return challengeActivityBean2;
	}
	
	
	@Override
	public Object getMemberChallengesByRank(MemberChallengeBean memberChallengeBean, PageBean pageBean) {
		List<MemberChallengeBean> memberChallengeBeans = challengeDao.getMemberChallengesByRank(memberChallengeBean,
				pageBean);
		for (MemberChallengeBean memberChallengeBean2 : memberChallengeBeans) {
			if (!StringUtils.isNull(memberChallengeBean2.getMember_name())) {
				String member_nick_name = "";
				try {
					member_nick_name = URLDecoder.decode(memberChallengeBean2.getMember_name(), "utf-8");
					memberChallengeBean2.setMember_name(member_nick_name);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return pageBean.setObject(memberChallengeBeans);
	}
	@Override
	public Object getMemberChallenges(MemberChallengeBean memberChallengeBean, PageBean pageBean) {

		List<MemberChallengeBean> memberChallengeBeans = challengeDao.getMemberChallenges(memberChallengeBean,
				pageBean);
		for (MemberChallengeBean memberChallengeBean2 : memberChallengeBeans) {
			if (!StringUtils.isNull(memberChallengeBean2.getMember_name())) {
				String member_nick_name = "";
				try {
					member_nick_name = URLDecoder.decode(memberChallengeBean2.getMember_name(), "utf-8");
					memberChallengeBean2.setMember_name(member_nick_name);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return pageBean.setObject(memberChallengeBeans);
	}

	@Override
	public Object getMemberChallengesByFront(MemberChallengeBean memberChallengeBean, PageBean pageBean) {
		List<PercentBean> percentBeans = settingDaoC.getPercents(new PercentBean());
		for (PercentBean percentBean2 : percentBeans) {
			if ("well".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setGood_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
			if ("comment".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setComment_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
			if ("member_lable".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setLable_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
		}
		List<MemberChallengeBean> memberChallengeBeans = challengeDao.getMemberChallengesByFront(memberChallengeBean,
				pageBean);
		for (MemberChallengeBean memberChallengeBean2 : memberChallengeBeans) {
			if (!StringUtils.isNull(memberChallengeBean2.getMember_name())) {
				String member_nick_name = "";
				try {
					member_nick_name = URLDecoder.decode(memberChallengeBean2.getMember_name(), "utf-8");
					memberChallengeBean2.setMember_name(member_nick_name);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return pageBean.setObject(memberChallengeBeans);
	}

	@Override
	public Object getMemberChallengesByHeight(MemberChallengeBean memberChallengeBean, PageBean pageBean) {
		List<PercentBean> percentBeans = settingDaoC.getPercents(new PercentBean());
		for (PercentBean percentBean2 : percentBeans) {
			if ("well".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setGood_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
			if ("comment".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setComment_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
			if ("member_lable".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setLable_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
		}
		List<Map<String, Object>> memberChallengeBeans = challengeDao.getMemberChallengesByHeight(memberChallengeBean,
				pageBean);

		return pageBean.setObject(memberChallengeBeans);
	}

	@Override
	public Object getMemberChallengesByHeightTest(MemberChallengeBean memberChallengeBean, PageBean pageBean) {
		List<PercentBean> percentBeans = settingDaoC.getPercents(new PercentBean());
		for (PercentBean percentBean2 : percentBeans) {
			if ("well".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setGood_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
			if ("comment".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setComment_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
			if ("member_lable".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setLable_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
		}
		List<MemberChallengeBean> memberChallengeBeans = challengeDao
				.getMemberChallengesByHeightTest(memberChallengeBean, pageBean);
		for (MemberChallengeBean memberChallengeBean2 : memberChallengeBeans) {
			if (!StringUtils.isNull(memberChallengeBean2.getMember_name())) {
				String member_nick_name = "";
				try {
					member_nick_name = URLDecoder.decode(memberChallengeBean2.getMember_name(), "utf-8");
					memberChallengeBean2.setMember_name(member_nick_name);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return pageBean.setObject(memberChallengeBeans);
	}

	@Override
	public Object getMemberChallengesByWidth(MemberChallengeBean memberChallengeBean, PageBean pageBean) {
		List<PercentBean> percentBeans = settingDaoC.getPercents(new PercentBean());
		for (PercentBean percentBean2 : percentBeans) {
			if ("well".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setGood_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
			if ("comment".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setComment_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
			if ("member_lable".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setLable_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
		}
		List<MemberChallengeBean> memberChallengeBeans = challengeDao
				.getMemberChallengesByWidthTest(memberChallengeBean, pageBean);
		for (MemberChallengeBean memberChallengeBean2 : memberChallengeBeans) {
			if (!StringUtils.isNull(memberChallengeBean2.getMember_name())) {
				String member_nick_name = "";
				try {
					member_nick_name = URLDecoder.decode(memberChallengeBean2.getMember_name(), "utf-8");
					memberChallengeBean2.setMember_name(member_nick_name);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return pageBean.setObject(memberChallengeBeans);
	}

	@Override
	public Object getMemberChallengesByWidthTest(MemberChallengeBean memberChallengeBean, PageBean pageBean) {
		List<PercentBean> percentBeans = settingDaoC.getPercents(new PercentBean());
		for (PercentBean percentBean2 : percentBeans) {
			if ("well".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setGood_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
			if ("comment".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setComment_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
			if ("member_lable".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setLable_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
		}
		List<Map<String, Object>> memberChallengeBeans = challengeDao.getMemberChallengesByWidth(memberChallengeBean,
				pageBean);

		return pageBean.setObject(memberChallengeBeans);
	}

	@Override
	public Object getMemberChallengesByProdClass(MemberChallengeBean memberChallengeBean, PageBean pageBean) {
		List<PercentBean> percentBeans = settingDaoC.getPercents(new PercentBean());
		for (PercentBean percentBean2 : percentBeans) {
			if ("well".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setGood_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
			if ("comment".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setComment_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
			if ("member_lable".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setLable_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
		}
		List<Map<String, Object>> memberChallengeBeans = challengeDao
				.getMemberChallengesByProdClass(memberChallengeBean, pageBean);

		return pageBean.setObject(memberChallengeBeans);
	}

	@Override
	public Object getMemberChallengesByClass(MemberChallengeBean memberChallengeBean, PageBean pageBean) {
		List<PercentBean> percentBeans = settingDaoC.getPercents(new PercentBean());
		for (PercentBean percentBean2 : percentBeans) {
			if ("well".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setGood_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
			if ("comment".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setComment_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
			if ("member_lable".equals(percentBean2.getPercent_type())) {
				memberChallengeBean.setLable_set(Integer.valueOf(percentBean2.getPercent_value()));
			}
		}
		List<MemberChallengeBean> memberChallengeBeans = challengeDao.getMemberChallengesByClass(memberChallengeBean,
				pageBean);
		for (MemberChallengeBean memberChallengeBean2 : memberChallengeBeans) {
			if (!StringUtils.isNull(memberChallengeBean2.getMember_name())) {
				String member_nick_name = "";
				try {
					member_nick_name = URLDecoder.decode(memberChallengeBean2.getMember_name(), "utf-8");
					memberChallengeBean2.setMember_name(member_nick_name);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return pageBean.setObject(memberChallengeBeans);
	}

	@Override
	public Object getMemberChallengesIsFront(MemberChallengeBean memberChallengeBean, PageBean pageBean) {
		// List<MemberChallengeBean> memberChallengeBeans =
		// challengeDao.getMemberChallengesIsFront(memberChallengeBean,
		// pageBean);
		return null;
	}

	@Override
	public Object getMemberChallenge(MemberChallengeBean memberChallengeBean) {
		MemberChallengeBean memberChallengeBean2 = challengeDao.getMemberChallenge(memberChallengeBean);
		if (!StringUtils.isNull(memberChallengeBean2.getMember_name())) {
			String member_nick_name = "";
			try {
				member_nick_name = URLDecoder.decode(memberChallengeBean2.getMember_name(), "utf-8");
				memberChallengeBean2.setMember_name(member_nick_name);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return memberChallengeBean2;
	}

	@Override
	public Object updateMemberChallenge(MemberChallengeBean memberChallengeBean) {
		int num = challengeDao.updateMemberChallenge(memberChallengeBean);
		if (num <= 0) {
			throw new AppException("修改失败");
		}
		return num;
	}

	@Override
	public Object insertMemberChallenge(MemberChallengeBean memberChallengeBean) {
		if (memberChallengeBean.getProduct_id() != 0) {
			ProductBean productBean = goodsDaoC
					.getProductDetail(new ProductBean().setProduct_id(memberChallengeBean.getProduct_id()));
			if (productBean != null) {
				ProductClassBean productClassBean = goodsDaoC.getProductClassDetail(
						new ProductClassBean().setClass_id(Integer.valueOf(productBean.getClass_id())));
				if (productClassBean != null) {
					memberChallengeBean.setProduct_class(Integer.valueOf(productClassBean.getParent_id()));

				}
				memberChallengeBean.setProduct_name(productBean.getProduct_name());
				memberChallengeBean.setProduct_img(productBean.getProduct_img());
			}
			ChallengeActivityBean challengeActivityBean = challengeDao.getChallengeActivity(
					new ChallengeActivityBean().setProduct_id(String.valueOf(memberChallengeBean.getProduct_id())));
			if (challengeActivityBean != null) {
				memberChallengeBean.setChallenge_rule(challengeActivityBean.getChallenge_rule());
				if("member".equals(memberChallengeBean.getChallenge_resource())){
					if("0".equals(challengeActivityBean.getActivity_people())){
						throw new AppException("添加失败");
					}
					int activity_people = NumberUtils.Integer(challengeActivityBean.getActivity_people()) - 1;
					int result = challengeDaoC.updateChallengeActivity(new ChallengeActivityBean().setActivity_id(challengeActivityBean.getActivity_id())
							.setActivity_people(activity_people+""));
					if (result <= 0) {
						throw new AppException("添加失败");
					}
				}
			}
		}

		int num = challengeDao.insertMemberChallenge(memberChallengeBean);
		if (num <= 0) {
			throw new AppException("添加失败");
		}
		return num;
	}

	@Override
	public Object deleteMemberChallenge(MemberChallengeBean memberChallengeBean) {
		int num = challengeDao.deleteMemberChallenge(memberChallengeBean);
		if (num <= 0) {
			throw new AppException("删除失败");
		}
		return num;
	}
	@Override
	public Object getCurrentRankChallenge(MemberChallengeBean memberChallengeBean) {
		Map<String, Object> map = new HashMap<>();
		ChallengeActivityBean challengeActivityBean = challengeDao.getCurrentChallengeActivity(new ChallengeActivityBean());
		if(challengeActivityBean==null){
			map.put("topTen", "");
			map.put("personal", "");
			return map;
		}
		//根据当前挑战的时间 和产品筛选出用户的实际挑战视频 用户的视频也按点赞排序
		List<MemberChallengeBean> memberChallengeBeans = challengeDao.getCurrentTopTenMemberChallenges(new MemberChallengeBean()
				.setSales_start_time(challengeActivityBean.getStart_time()).setProduct_id(Integer.valueOf(challengeActivityBean.getProduct_id())));
		for(MemberChallengeBean memberChallengeBean2 : memberChallengeBeans){
			if (!StringUtils.isNull(memberChallengeBean2.getMember_name())) {
				String member_nick_name = "";
				try {
					member_nick_name = URLDecoder.decode(memberChallengeBean2.getMember_name(), "utf-8");
					memberChallengeBean2.setMember_name(member_nick_name);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		MemberChallengeBean memberChallengeBean2 = challengeDao.getMemberRankByProductAndTime(new MemberChallengeBean()
				.setProduct_id(Integer.valueOf(challengeActivityBean.getProduct_id()))
				.setSales_start_time(challengeActivityBean.getStart_time())
				.setMember_id(memberChallengeBean.getMember_id()));
		List<Map<String, Object>> ranks = challengeDao.getMemberRank(
				new MemberChallengeBean()
				.setProduct_id(Integer.valueOf(challengeActivityBean.getProduct_id()))
				.setSales_start_time(challengeActivityBean.getStart_time()));
		for(int i=0;i<ranks.size();i++){
			int challenge_rank = Integer.valueOf(ranks.get(i).get("challenge_id").toString());
			if(memberChallengeBean2!=null){
				if(challenge_rank == memberChallengeBean2.getChallenge_id()){
					memberChallengeBean2.setGood_set(i+1);
				}
			}
			
		}
		
		map.put("topTen", memberChallengeBeans);
		map.put("personal", memberChallengeBean2);
		
		return map;
	}
	

	@Override
	public Object insertChallengeFootprint(ChallengeFootprintBean challengeFootprintBean) {
		ChallengeFootprintBean challengeFootprintBean2 = challengeDao.getChallengeFootprintDetail(challengeFootprintBean);
		if(challengeFootprintBean2 !=null){
			return 1;
		}
		
		int num = challengeDao.insertChallengeFootprint(challengeFootprintBean);
		if (num <= 0) {
			throw new AppException("添加失败");
		}
		// 给用户足迹数+1
		MemberBean memberBean = memberDao
				.getMemberDetail(new MemberBean().setMember_id(challengeFootprintBean.getMember_id()));
		if (memberBean != null) {
			int footprint_num = memberBean.getFootprint_num() + 1;
			num = memberDao.updateMemberDetail(
					new MemberBean().setMember_id(memberBean.getMember_id()).setFootprint_num(footprint_num));
			if (num <= 0) {
				throw new AppException("添加失败");
			}
		}

		return num;
	}

	@Override
	public Object insertChallengeWell(ChallengeWellBean challengeWellBean) {
		ChallengeWellBean challengeWellBean2 = challengeDao.getChallengeWellDetail(challengeWellBean);
		if (challengeWellBean2 != null) {
			throw new AppException("重复点赞失败");
		}
		int num = 1;
		MemberChallengeBean memberChallengeBean = challengeDao.getMemberChallengeDetail(
				new MemberChallengeBean().setChallenge_id(challengeWellBean.getChallenge_id()));
		if (memberChallengeBean != null) {
			int well_count = memberChallengeBean.getGood_num() + 1;
			num = challengeDao.updateMemberChallenge(new MemberChallengeBean()
					.setChallenge_id(memberChallengeBean.getChallenge_id()).setGood_num(well_count));
			if (num <= 0) {
				throw new AppException("点赞失败");
			}
			if (challengeWellBean.getMember_id() > 0) {
				// 点攒操作后给用户喜好度加值
				PercentBean percentBean = settingDaoC
						.getPercentDetail(new PercentBean().setPercent_type("member_love"));
				MemberLableBean memberLableBean = challengeDao.getMemberLableDetail(
						new MemberLableBean().setProduct_class_id(memberChallengeBean.getProduct_class())
								.setMember_id(challengeWellBean.getMember_id()));
				if (percentBean != null) {
					// 比例存在值 判断用户标签是否存在
					if (memberLableBean != null) {
						int grade = memberLableBean.getLable_grade();
						grade = grade + Integer.valueOf(percentBean.getPercent_value());
						num = challengeDao.updateMemberLable(
								new MemberLableBean().setLable_id(memberLableBean.getLable_id()).setLable_grade(grade));
						if (num <= 0) {
							throw new AppException("点赞失败");
						}
					} else {
						num = challengeDao
								.insertMemberLable(new MemberLableBean().setMember_id(challengeWellBean.getMember_id())
										.setLable_grade(Integer.valueOf(percentBean.getPercent_value()))
										.setProduct_class_id(memberChallengeBean.getProduct_class()));
						if (num <= 0) {
							throw new AppException("点赞失败");
						}
					}
				}
				// 给用户的点赞数做记录
				MemberBean memberBean = memberDao
						.getMemberDetail(new MemberBean().setMember_id(challengeWellBean.getMember_id()));
				if (memberBean != null) {
					int well_num = memberBean.getWell_num() + 1;
					num = memberDao.updateMemberDetail(
							new MemberBean().setMember_id(memberBean.getMember_id()).setWell_num(well_num));
					if (num <= 0) {
						throw new AppException("点赞失败");
					}
				}
			}
		}

		num = challengeDao.insertChallengeWell(challengeWellBean);
		if (num <= 0) {
			throw new AppException("点赞失败");
		}
		return num;
	}

	@Override
	public Object insertChallengeShare(ChallengeShareBean challengeShareBean) {
		int num = 1;
		MemberChallengeBean memberChallengeBean = challengeDao.getMemberChallengeDetail(
				new MemberChallengeBean().setChallenge_id(challengeShareBean.getChallenge_id()));
		if (memberChallengeBean != null) {
			int share_count = memberChallengeBean.getShare_num() + 1;
			num = challengeDao.updateMemberChallenge(new MemberChallengeBean()
					.setChallenge_id(memberChallengeBean.getChallenge_id()).setShare_num(share_count));
			if (num <= 0) {
				throw new AppException("分享失败");
			}
		}
		num = challengeDao.insertChallengeShare(challengeShareBean);
		if (num <= 0) {
			throw new AppException("分享失败");
		}
		return num;
	}

	@Override
	public Object insertChallengeFollow(ChallengeFollowBean challengeFollowBean) {

		ChallengeFollowBean challengeFollowBean2 = challengeDao.getChallengeFollowDetail(challengeFollowBean);
		if (challengeFollowBean2 != null) {
			throw new AppException("重复关注用户失败");
		}
		int num = challengeDao.insertChallengeFollow(challengeFollowBean);
		if (num <= 0) {
			throw new AppException("关注用户失败");
		}
		// 给被关注的用户粉丝数+1
		MemberBean memberBean = memberDao
				.getMemberDetail(new MemberBean().setMember_id(challengeFollowBean.getParent_member_id()));
		if (memberBean != null) {
			int fans_num = memberBean.getFans_num() + 1;
			num = memberDao
					.updateMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id()).setFans_num(fans_num));
			if (num <= 0) {
				throw new AppException("关注用户失败");
			}
		}
		// 给用户关注数加1
		MemberBean memberBean2 = memberDao
				.getMemberDetail(new MemberBean().setMember_id(challengeFollowBean.getMember_id()));
		if (memberBean2 != null) {
			int follow_num = memberBean2.getFollow_num() + 1;
			num = memberDao.updateMemberDetail(
					new MemberBean().setMember_id(memberBean2.getMember_id()).setFollow_num(follow_num));
			if (num <= 0) {
				throw new AppException("关注用户失败");
			}
		}
		return num;
	}

	public Object deleteChallengeFollow(ChallengeFollowBean challengeFollowBean) {
		int num = challengeDao.deleteChallengeFollow(challengeFollowBean);
		if (num <= 0) {
			throw new AppException("取消关注失败");
		}
		// 给被关注的用户粉丝数-1
		MemberBean memberBean = memberDao
				.getMemberDetail(new MemberBean().setMember_id(challengeFollowBean.getParent_member_id()));
		if (memberBean != null) {
			int fans_num = memberBean.getFans_num() - 1;
			num = memberDao
					.updateMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id()).setFans_num(fans_num));
			if (num <= 0) {
				throw new AppException("关注用户失败");
			}
		}
		// 给用户关注数-1
		MemberBean memberBean2 = memberDao
				.getMemberDetail(new MemberBean().setMember_id(challengeFollowBean.getMember_id()));
		if (memberBean2 != null) {
			int follow_num = memberBean2.getFollow_num() - 1;
			num = memberDao.updateMemberDetail(
					new MemberBean().setMember_id(memberBean2.getMember_id()).setFollow_num(follow_num));
			if (num <= 0) {
				throw new AppException("关注用户失败");
			}
		}

		return num;
	}

	@Override
	public Object insertChallengeComment(ChallengeCommentBean challengeCommentBean) {
		Set<String> sensitiveWord = RedisUtils.getSetList("sensitive");
		for(String s : sensitiveWord){
			if(challengeCommentBean.getComment_desc().contains(s)){
				throw new AppException("评论内容含敏感词汇！");
			}
		}
		int num = 1;
		MemberChallengeBean memberChallengeBean = challengeDao.getMemberChallengeDetail(
				new MemberChallengeBean().setChallenge_id(challengeCommentBean.getChallenge_id()));
		if (memberChallengeBean != null) {
			int comment_count = memberChallengeBean.getComment_num() + 1;
			num = challengeDao.updateMemberChallenge(new MemberChallengeBean()
					.setChallenge_id(memberChallengeBean.getChallenge_id()).setComment_num(comment_count));
			if (num <= 0) {
				throw new AppException("评论失败");
			}
		}
		num = challengeDao.insertChallengeComment(challengeCommentBean);
		if (num <= 0) {
			throw new AppException("评论失败");
		}
		return num;
	}

	@Override
	public Object getChallengeComments(ChallengeCommentBean challengeCommentBean, PageBean pageBean) {
		List<ChallengeCommentBean> challengeCommentBeans = challengeDao.getChallengeComments(challengeCommentBean,
				pageBean);
		for (ChallengeCommentBean challengeCommentBean2 : challengeCommentBeans) {
			if (!StringUtils.isNull(challengeCommentBean2.getMember_name())) {
				String member_nick_name = "";
				try {
					member_nick_name = URLDecoder.decode(challengeCommentBean2.getMember_name(), "utf-8");
					challengeCommentBean2.setMember_name(member_nick_name);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return pageBean.setObject(challengeCommentBeans);
	}

	public Object deleteChallengeCollection(ChallengeCollectionBean challengeCollectionBean) {
		int num = challengeDao.deleteChallengeCollection(challengeCollectionBean);
		if (num <= 0) {
			throw new AppException("取消收藏失败");
		}
		MemberChallengeBean memberChallengeBean = challengeDao.getMemberChallengeDetail(
				new MemberChallengeBean().setChallenge_id(challengeCollectionBean.getChallenge_id()));
		if (memberChallengeBean != null) {
			int collection_num = memberChallengeBean.getCollection_num() - 1;
			num = challengeDao.updateMemberChallenge(new MemberChallengeBean()
					.setChallenge_id(memberChallengeBean.getChallenge_id()).setCollection_num(collection_num));
			if (num <= 0) {
				throw new AppException("取消失败");
			}
		}
		return num;
	}

	public Object deleteChallengeWell(ChallengeWellBean challengeWellBean) {
		MemberChallengeBean memberChallengeBean = challengeDao.getMemberChallengeDetail(
				new MemberChallengeBean().setChallenge_id(challengeWellBean.getChallenge_id()));
		int num = 1;
		if (memberChallengeBean != null) {
			num = challengeDao.updateMemberChallenge(
					new MemberChallengeBean().setChallenge_id(memberChallengeBean.getChallenge_id())
							.setGood_num(memberChallengeBean.getGood_num() - 1));
			if (num <= 0) {
				throw new AppException("取消失败");
			}
			if (challengeWellBean.getMember_id() > 0) {
				// 给用户的点赞数做记录
				MemberBean memberBean = memberDao
						.getMemberDetail(new MemberBean().setMember_id(challengeWellBean.getMember_id()));
				if (memberBean != null) {
					int well_num = memberBean.getWell_num() - 1;
					num = memberDao.updateMemberDetail(
							new MemberBean().setMember_id(memberBean.getMember_id()).setWell_num(well_num));
					if (num <= 0) {
						throw new AppException("取消失败");
					}
				}
			}
		}
		num = challengeDao.deleteChallengeWell(challengeWellBean);
		if (num <= 0) {
			throw new AppException("取消点赞失败");
		}
		return num;
	}

	@Override
	public Object insertChallengeCollection(ChallengeCollectionBean challengeCollectionBean) {
		ChallengeCollectionBean challengeCollectionBean2 = challengeDao
				.getChallengeCollectionDetail(challengeCollectionBean);
		if (challengeCollectionBean2 != null) {
			throw new AppException("重复收藏失败");
		}
		int num = 1;
		MemberChallengeBean memberChallengeBean = challengeDao.getMemberChallengeDetail(
				new MemberChallengeBean().setChallenge_id(challengeCollectionBean.getChallenge_id()));
		if (memberChallengeBean != null) {
			int collection_count = memberChallengeBean.getCollection_num() + 1;
			num = challengeDao.updateMemberChallenge(new MemberChallengeBean()
					.setChallenge_id(memberChallengeBean.getChallenge_id()).setCollection_num(collection_count));
			if (num <= 0) {
				throw new AppException("收藏失败");
			}

		}
		num = challengeDao.insertChallengeCollection(challengeCollectionBean);
		if (num <= 0) {
			throw new AppException("收藏失败");
		}
		return num;
	}

	@Override
	public Object insertMemberLable(MemberLableBean memberLableBean) {
		int num = 1;
		MemberLableBean memberLableBean2 = challengeDao
				.getMemberLableDetail(new MemberLableBean().setMember_id(memberLableBean.getMember_id())
						.setProduct_class_id(memberLableBean.getProduct_class_id()));
		if (memberLableBean2 != null) {
			int class_grade = memberLableBean2.getLable_grade();
			PercentBean percentBean = settingDaoC.getPercentDetail(new PercentBean().setPercent_type("member_love"));
			if (percentBean != null) {
				class_grade = class_grade + Integer.valueOf(percentBean.getPercent_value());
			}
			// 添加过用户标签 直接修改标签的值
			num = challengeDao.updateMemberLable(
					new MemberLableBean().setLable_id(memberLableBean2.getLable_id()).setLable_grade(class_grade));
			if (num <= 0) {
				throw new AppException("添加失败");
			}
		}
		num = challengeDao.insertMemberLable(memberLableBean);
		if (num <= 0) {
			throw new AppException("添加失败");
		}
		return num;
	}

	@Override
	public Object updateMemberLable(MemberLableBean memberLableBean) {
		int num = challengeDao.updateMemberLable(memberLableBean);
		if (num <= 0) {
			throw new AppException("修改失败");
		}
		return num;
	}

	@Override
	public Object getMemberLableDetail(MemberLableBean memberLableBean) {
		// TODO Auto-generated method stub
		return challengeDao.getMemberLableDetail(memberLableBean);
	}

	@Override
	public Object timingPayChallenge() {
		// TODO Auto-generated method stub
		List<ChallengeActivityBean> challengeActivityBeans = challengeDao.getWaitPayChallenges();
		// 销售额
		double sales_amount = 0;
		double sale_num = 0;
		int num = 1;
		for (ChallengeActivityBean challengeActivityBean : challengeActivityBeans) {
			// 计算挑战产品的在销售分成区间内的销售额
			Map<String, Object> map = challengeDao.getProductSalesAmount(
					new ChallengeActivityBean().setSales_start_time(challengeActivityBean.getSales_start_time())
							.setSales_end_time(challengeActivityBean.getSales_end_time())
							.setProduct_id(challengeActivityBean.getProduct_id()));
			if (map != null) {
				sales_amount = NumberUtils.Double(map.get("total").toString());
				sale_num = NumberUtils.Double(map.get("num").toString());
			}
			// 统计挑战产品在挑战时间区间内的用户挑战排名的用户id
			List<Map<String, Object>> list = challengeDao.getMemberChallengeByWell(
					new MemberChallengeBean().setSales_start_time(challengeActivityBean.getSales_start_time())
							.setSales_end_time(challengeActivityBean.getSales_end_time())
							.setProduct_id(Integer.valueOf(challengeActivityBean.getProduct_id())));
			// 获取挑战活动的模板排名奖励
			// 销售分成的模板
			List<ChallengeSalesRewardBean> challengeSalesRewardBeans = challengeDaoC.getChallengeSalesRewards(
					new ChallengeSalesRewardBean().setChallenge_id(challengeActivityBean.getActivity_id()));
			for (ChallengeSalesRewardBean challengeSalesRewardBean : challengeSalesRewardBeans) {
				// 同个排名 插入一条记录
				if (challengeSalesRewardBean.getRank_start() == challengeSalesRewardBean.getRank_end()) {

					double p = NumberUtils.Double(challengeSalesRewardBean.getRank_value());
					p = p * sales_amount * 0.01;
					if (challengeSalesRewardBean.getRank_start() <= list.size()) {
						num = challengeDao.insertMemberReward(new MemberRewardBean()
								.setChallenge_id(challengeSalesRewardBean.getChallenge_id())
								.setRank(challengeSalesRewardBean.getRank_start()).setMember_id(list
										.get(challengeSalesRewardBean.getRank_start() - 1).get("member_id").toString())
								.setReward_type("sales").setReward_value(p + ""));
						if (num <= 0) {
							throw new AppException("失败");
						}
					}

				}
				if (challengeSalesRewardBean.getRank_start() < challengeSalesRewardBean.getRank_end()) {
					int size = challengeSalesRewardBean.getRank_end() - challengeSalesRewardBean.getRank_start();
					for (int i = 0; i <= size; i++) {
						double p2 = NumberUtils.Double(challengeSalesRewardBean.getRank_value());
						p2 = p2 * sales_amount * 0.01;
						if ((challengeSalesRewardBean.getRank_start() + i) <= list.size()) {
							num = challengeDao.insertMemberReward(
									new MemberRewardBean().setChallenge_id(challengeSalesRewardBean.getChallenge_id())
											.setRank(challengeSalesRewardBean.getRank_start() + i)
											.setMember_id(list.get(challengeSalesRewardBean.getRank_start() + i-1)
													.get("member_id").toString())
											.setReward_type("sales").setReward_value(p2 + ""));
							if (num <= 0) {
								throw new AppException("失败");
							}
						}
					}
				}

			}
			// 奖金分成的模板
			List<ChallengeFixedRewardBean> challengeFixedRewardBeans = challengeDaoC.getChallengeFixedRewards(
					new ChallengeFixedRewardBean().setChallenge_id(challengeActivityBean.getActivity_id()));
			for (ChallengeFixedRewardBean challengeFixedRewardBean : challengeFixedRewardBeans) {
				// 同个排名 插入一条记录
				if (challengeFixedRewardBean.getRank_start() == challengeFixedRewardBean.getRank_end()) {
					if (challengeFixedRewardBean.getRank_start() <= list.size()) {
						num = challengeDao.insertMemberReward(
								new MemberRewardBean().setChallenge_id(challengeFixedRewardBean.getChallenge_id())
										.setRank(challengeFixedRewardBean.getRank_start())
										.setMember_id(list.get(challengeFixedRewardBean.getRank_start() - 1)
												.get("member_id").toString())
										.setReward_type("fixed")
										.setReward_value(challengeFixedRewardBean.getRank_value()));
						if (num <= 0) {
							throw new AppException("添加失败");
						}
					}
				}
				if (challengeFixedRewardBean.getRank_start() < challengeFixedRewardBean.getRank_end()) {
					int size = challengeFixedRewardBean.getRank_end() - challengeFixedRewardBean.getRank_start();
					for (int i = 0; i <= size; i++) {
						if ((challengeFixedRewardBean.getRank_start() + i) <= list.size()) {
							num = challengeDao.insertMemberReward(
									new MemberRewardBean().setChallenge_id(challengeFixedRewardBean.getChallenge_id())
											.setRank(challengeFixedRewardBean.getRank_start() + i)
											.setMember_id(list.get(challengeFixedRewardBean.getRank_start() + i -1)
													.get("member_id").toString())
											.setReward_type("fixed")
											.setReward_value(challengeFixedRewardBean.getRank_value()));
							if (num <= 0) {
								throw new AppException("失败");
							}
						}
					}
				}
			}
			// 最后将销售额和活动状态修改
			num = challengeDaoC.updateChallengeActivity(
					new ChallengeActivityBean().setSales_state("1").setTotal_amount(sales_amount + "")
							.setTotal_num(sale_num + "").setActivity_id(challengeActivityBean.getActivity_id()));
			if (num <= 0) {
				throw new AppException("结算失败");
			}
			
			
			
		}
		return num;
	}

}