package tst.project.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import tst.project.aspect.AppException;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.MemberBillBean;
import tst.project.bean.product.ProductBean;
import tst.project.bean.product.ProductClassBean;
import tst.project.bean.setting.ChallengeActivityBean;
import tst.project.bean.setting.ChallengeFixedRewardBean;
import tst.project.bean.setting.ChallengeRuleBean;
import tst.project.bean.setting.ChallengeSalesRewardBean;
import tst.project.bean.setting.FixedRewardBean;
import tst.project.bean.setting.FixedRewardModelBean;
import tst.project.bean.setting.MemberChallengeBean;
import tst.project.bean.setting.MemberRewardBean;
import tst.project.bean.setting.RewardTemplateBean;
import tst.project.controller.IChallengeServiceC;
import tst.project.dao.controller.ChallengeDaoC;
import tst.project.dao.controller.GoodsDaoC;
import tst.project.dao.controller.MemberDaoC;
import tst.project.dao.interfaces.ChallengeDao;
import tst.project.page.PageBean;
import tst.project.utils.StringUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class ChallengeServiceC implements IChallengeServiceC {
	@Autowired
	ChallengeDaoC challengeDaoC;
	

	@Autowired
	GoodsDaoC goodsDaoC;
	
	@Autowired
	MemberDaoC memberDaoC;

	@Override
	public Object getChallengeActivitys(ChallengeActivityBean challengeActivityBean, PageBean pageBean) {
		List<ChallengeActivityBean> challengeActivityBeans = challengeDaoC.getChallengeActivitys(challengeActivityBean,
				pageBean);
		return pageBean.setObject(challengeActivityBeans);
	}

	@Override
	public Object getChallengeActivity(ChallengeActivityBean challengeActivityBean) {
		ChallengeActivityBean challengeActivityBean2 = challengeDaoC.getChallengeActivity(challengeActivityBean);
		if (challengeActivityBean2 != null) {
			List<ChallengeSalesRewardBean> challengeSalesRewardBeans = challengeDaoC.getChallengeSalesRewards(
					new ChallengeSalesRewardBean().setChallenge_id(challengeActivityBean2.getActivity_id()));
			if (!CollectionUtils.isEmpty(challengeSalesRewardBeans)) {
				challengeActivityBean2.setChallengeSalesRewardBeans(challengeSalesRewardBeans);
			}
			List<ChallengeFixedRewardBean> challengeFixedRewardBeans = challengeDaoC.getChallengeFixedRewards(
					new ChallengeFixedRewardBean().setChallenge_id(challengeActivityBean2.getActivity_id()));
			if (!CollectionUtils.isEmpty(challengeFixedRewardBeans)) {
				challengeActivityBean2.setChallengeFixedRewardBeans(challengeFixedRewardBeans);
			}

		}
		return challengeActivityBean2;
	}

	@Override
	public Object updateChallengeActivity(ChallengeActivityBean challengeActivityBean) {
		int num = challengeDaoC.updateChallengeActivity(challengeActivityBean);
		if (num <= 0) {
			throw new AppException("失败");
		}
		return num;
	}

	@Override
	public Object insertChallengeActivity(ChallengeActivityBean challengeActivityBean) {
		int num = challengeDaoC.insertChallengeActivity(challengeActivityBean);
		if (num <= 0) {
			throw new AppException("失败");
		}
		// 附带固定奖励方式
		if (!StringUtils.isNull(challengeActivityBean.getFixed_reward())) {
			List<FixedRewardBean> fixedRewardBeans = challengeDaoC.getFixedRewardsNoPage(
					new FixedRewardBean().setParent_id(Integer.valueOf(challengeActivityBean.getFixed_reward())));
			for (FixedRewardBean fixedRewardBean : fixedRewardBeans) {
				num = challengeDaoC.insertChallengeFixedReward(new ChallengeFixedRewardBean()
						.setChallenge_id(challengeActivityBean.getActivity_id())
						.setRank_start(fixedRewardBean.getRank_start()).setRank_end(fixedRewardBean.getRank_end())
						.setRank_value(fixedRewardBean.getRank_value()));
				if (num <= 0) {
					throw new AppException("失败");
				}

			}
		}
		// 附带销售分成奖励方式
		if (!StringUtils.isNull(challengeActivityBean.getPercent_reward())) {
			List<RewardTemplateBean> rewardTemplateBeans = challengeDaoC.getRewardTemplatesNoPage(
					new RewardTemplateBean().setParent_id(Integer.valueOf(challengeActivityBean.getPercent_reward())));
			for (RewardTemplateBean rewardTemplateBean : rewardTemplateBeans) {
				num = challengeDaoC.insertChallengeSalesReward(new ChallengeSalesRewardBean()
						.setChallenge_id(challengeActivityBean.getActivity_id())
						.setRank_start(rewardTemplateBean.getRank_start()).setRank_end(rewardTemplateBean.getRank_end())
						.setRank_value(String.valueOf(rewardTemplateBean.getRank_percent())));

				if (num <= 0) {
					throw new AppException("失败");
				}
			}
		}

		return num;
	}

	@Override
	public Object deleteChallengeActivity(ChallengeActivityBean challengeActivityBean) {
		int num = challengeDaoC.deleteChallengeActivity(challengeActivityBean);
		if (num <= 0) {
			throw new AppException("失败");
		}
		return num;
	}

	@Override
	public Object getChallengeRules(ChallengeRuleBean challengeRuleBean, PageBean pageBean) {
		List<ChallengeRuleBean> challengeRuleBeans = challengeDaoC.getChallengeRules(challengeRuleBean, pageBean);
		return pageBean.setObject(challengeRuleBeans);
	}

	@Override
	public Object getChallengeRule(ChallengeRuleBean challengeRuleBean) {
		return challengeDaoC.getChallengeRule(challengeRuleBean);
	}

	@Override
	public Object updateChallengeRule(ChallengeRuleBean challengeRuleBean) {
		int num = challengeDaoC.updateChallengeRule(challengeRuleBean);
		if (num <= 0) {
			throw new AppException("失败");
		}
		return num;
	}

	@Override
	public Object insertChallengeRule(ChallengeRuleBean challengeRuleBean) {
		int num = challengeDaoC.insertChallengeRule(challengeRuleBean);
		if (num <= 0) {
			throw new AppException("失败");
		}
		return num;
	}

	@Override
	public Object deleteChallengeRule(ChallengeRuleBean challengeRuleBean) {
		int num = challengeDaoC.deleteChallengeRule(challengeRuleBean);
		if (num <= 0) {
			throw new AppException("失败");
		}
		return num;
	}

	@Override
	public Object getRewardTemplates(RewardTemplateBean rewardTemplateBean, PageBean pageBean) {
		List<RewardTemplateBean> rewardTemplateBeans = challengeDaoC.getRewardTemplates(rewardTemplateBean, pageBean);
		return pageBean.setObject(rewardTemplateBeans);
	}

	@Override
	public Object getRewardTemplate(RewardTemplateBean rewardTemplateBean) {
		return challengeDaoC.getRewardTemplate(rewardTemplateBean);
	}

	@Override
	public Object updateRewardTemplate(RewardTemplateBean rewardTemplateBean) {
		int num = challengeDaoC.updateRewardTemplate(rewardTemplateBean);
		if (num <= 0) {
			throw new AppException("失败");
		}
		return num;
	}

	@Override
	public Object insertRewardTemplate(RewardTemplateBean rewardTemplateBean) {
		int num = challengeDaoC.insertRewardTemplate(rewardTemplateBean);
		if (num <= 0) {
			throw new AppException("失败");
		}
		return num;
	}

	@Override
	public Object deleteRewardTemplate(RewardTemplateBean rewardTemplateBean) {
		int num = challengeDaoC.deleteRewardTemplate(rewardTemplateBean);
		if (num <= 0) {
			throw new AppException("失败");
		}
		return num;
	}

	@Override
	public Object getMemberChallenges(MemberChallengeBean memberChallengeBean, PageBean pageBean) {
		List<MemberChallengeBean> memberChallengeBeans = challengeDaoC.getMemberChallenges(memberChallengeBean,
				pageBean);
		return pageBean.setObject(memberChallengeBeans);
	}

	@Override
	public Object getMemberChallenge(MemberChallengeBean memberChallengeBean) {

		return challengeDaoC.getMemberChallenge(memberChallengeBean);
	}

	@Override
	public Object updateMemberChallenge(MemberChallengeBean memberChallengeBean) {
		int num = challengeDaoC.updateMemberChallenge(memberChallengeBean);
		if (num <= 0) {
			throw new AppException("失败");
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
		}

		int num = challengeDaoC.insertMemberChallenge(memberChallengeBean);
		if (num <= 0) {
			throw new AppException("失败");
		}
		return num;
	}

	@Override
	public Object deleteMemberChallenge(MemberChallengeBean memberChallengeBean) {
		int num = challengeDaoC.deleteMemberChallenge(memberChallengeBean);
		if (num <= 0) {
			throw new AppException("失败");
		}
		return num;
	}

	@Override
	public Object getFixedRewards(FixedRewardBean fixedRewardBean, PageBean pageBean) {
		List<FixedRewardBean> fixedRewardBeans = challengeDaoC.getFixedRewards(fixedRewardBean, pageBean);
		return pageBean.setObject(fixedRewardBeans);
	}

	@Override
	public Object getFixedReward(FixedRewardBean fixedRewardBean) {
		return challengeDaoC.getFixedReward(fixedRewardBean);
	}

	@Override
	public Object updateFixedReward(FixedRewardBean fixedRewardBean) {
		int num = challengeDaoC.updateFixedReward(fixedRewardBean);
		if (num <= 0) {
			throw new AppException("失败");
		}
		return num;
	}

	@Override
	public Object insertFixedReward(FixedRewardBean fixedRewardBean) {
		int num = challengeDaoC.insertFixedReward(fixedRewardBean);
		if (num <= 0) {
			throw new AppException("失败");
		}
		return num;
	}

	@Override
	public Object deleteFixedReward(FixedRewardBean fixedRewardBean) {
		int num = challengeDaoC.deleteFixedReward(fixedRewardBean);
		if (num <= 0) {
			throw new AppException("失败");
		}
		return num;
	}

	@Override
	public Object getFixedRewardModels(FixedRewardModelBean fixedRewardModelBean, PageBean pageBean) {
		List<FixedRewardModelBean> fixedRewardModelBeans = challengeDaoC.getFixedRewardModels(fixedRewardModelBean,
				pageBean);
		return pageBean.setObject(fixedRewardModelBeans);
	}

	@Override
	public Object getFixedRewardModelNoPage(FixedRewardModelBean fixedRewardModelBean) {
		return challengeDaoC.getFixedRewardModelNoPage(fixedRewardModelBean);
	}

	@Override
	public Object getFixedRewardModel(FixedRewardModelBean fixedRewardModelBean) {
		return challengeDaoC.getFixedRewardModel(fixedRewardModelBean);
	}

	@Override
	public Object updateFixedRewardModel(FixedRewardModelBean fixedRewardModelBean) {
		int num = challengeDaoC.updateFixedRewardModel(fixedRewardModelBean);
		if (num <= 0) {
			throw new AppException("修改失败");
		}
		return num;
	}

	@Override
	public Object insertFixedRewardModel(FixedRewardModelBean fixedRewardModelBean) {
		int num = challengeDaoC.insertFixedRewardModel(fixedRewardModelBean);
		if (num <= 0) {
			throw new AppException("添加失败");
		}
		return num;
	}

	@Override
	public Object deleteFixedRewardModel(FixedRewardModelBean fixedRewardModelBean) {
		int num = challengeDaoC.deleteFixedRewardModel(fixedRewardModelBean);
		if (num <= 0) {
			throw new AppException("删除失败");
		}
		return num;
	}
	@Override
	public Object getMemberRewards(MemberRewardBean memberRewardBean,PageBean pageBean) {
		return pageBean.setObject(challengeDaoC.getMemberRewards(memberRewardBean, pageBean));
	}
	@Override
	public Object updateMemberReward(MemberRewardBean memberRewardBean) {
		int num = challengeDaoC.updateMemberReward(memberRewardBean);
		if (num <= 0) {
			throw new AppException("修改失败");
		}
		MemberRewardBean memberRewardBean2 = challengeDaoC.getMemberRewardDetail(memberRewardBean);
		if(memberRewardBean2==null){
			throw new AppException("详情不存在");
		}
		num = memberDaoC.insertMemberBill(new MemberBillBean().setBill_desc("挑战结算奖励")
				.setBill_type("11")
				.setBill_value(memberRewardBean2.getReward_value())
				.setMember_id(memberRewardBean2.getMember_id()));
		if (num <= 0) {
			throw new AppException("修改失败");
		}
		num=memberDaoC.updateMemberBalance(new MemberBean().setMember_id(Integer.valueOf(memberRewardBean2.getMember_id()))
				.setMember_balance(memberRewardBean2.getReward_value()));
		if (num <= 0) {
			throw new AppException("余额更新失败!");
		}
		return num;
	}
	
}