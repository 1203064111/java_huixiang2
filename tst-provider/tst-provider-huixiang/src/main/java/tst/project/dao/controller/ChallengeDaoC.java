package tst.project.dao.controller;

import java.util.List;

import tst.project.annotation.Mapper;
import tst.project.bean.setting.ChallengeActivityBean;
import tst.project.bean.setting.ChallengeFixedRewardBean;
import tst.project.bean.setting.ChallengeRuleBean;
import tst.project.bean.setting.ChallengeSalesRewardBean;
import tst.project.bean.setting.FixedRewardBean;
import tst.project.bean.setting.FixedRewardModelBean;
import tst.project.bean.setting.MemberChallengeBean;
import tst.project.bean.setting.MemberRewardBean;
import tst.project.bean.setting.RewardTemplateBean;
import tst.project.page.PageBean;

@Mapper
public interface ChallengeDaoC {
	/**
	 * 挑战活动列表
	 * @param challengeActivityBean
	 * @param pageBean
	 * @return
	 */
	public List<ChallengeActivityBean> getChallengeActivitys(ChallengeActivityBean challengeActivityBean,
			PageBean pageBean);
	/**
	 * 修改挑战活动
	 * @param challengeActivityBean
	 * @return
	 */
	public int updateChallengeActivity(ChallengeActivityBean challengeActivityBean);
	/**
	 * 删除挑战活动
	 * @param challengeActivityBean
	 * @return
	 */
	public int deleteChallengeActivity(ChallengeActivityBean challengeActivityBean);
	/**
	 * 添加挑战活动
	 * @param challengeActivityBean
	 * @return
	 */
	public int insertChallengeActivity(ChallengeActivityBean challengeActivityBean);
	/**
	 * 挑战活动详情
	 * @param challengeActivityBean
	 * @return
	 */
	public ChallengeActivityBean getChallengeActivity(ChallengeActivityBean challengeActivityBean);
	/**
	 * 挑战规则列表
	 * @param challengeRuleBean
	 * @param pageBean
	 * @return
	 */
	public List<ChallengeRuleBean> getChallengeRules(ChallengeRuleBean challengeRuleBean, PageBean pageBean);
	/**
	 * 修改挑战规则
	 * @param challengeRuleBean
	 * @return
	 */
	public int updateChallengeRule(ChallengeRuleBean challengeRuleBean);
	/**
	 * 删除挑战规则
	 * @param challengeRuleBean
	 * @return
	 */
	public int deleteChallengeRule(ChallengeRuleBean challengeRuleBean);
	/**
	 * 添加挑战规则
	 * @param challengeRuleBean
	 * @return
	 */
	public int insertChallengeRule(ChallengeRuleBean challengeRuleBean);
	/**
	 * 挑战规则详情
	 * @param challengeRuleBean
	 * @return
	 */
	public ChallengeRuleBean getChallengeRule(ChallengeRuleBean challengeRuleBean);
	
	/**
	 * 奖励方式模板
	 * @param rewardTemplateBean
	 * @param pageBean
	 * @return
	 */
	public List<RewardTemplateBean> getRewardTemplates(RewardTemplateBean rewardTemplateBean, PageBean pageBean);
	/**
	 * 销售分成不分页
	 * @param rewardTemplateBean
	 * @return
	 */
	public List<RewardTemplateBean> getRewardTemplatesNoPage(RewardTemplateBean rewardTemplateBean);
	/**
	 * 修改奖励模板
	 * @param rewardTemplateBean
	 * @return
	 */
	public int updateRewardTemplate(RewardTemplateBean rewardTemplateBean);
	/**
	 * 删除奖励模板
	 * @param rewardTemplateBean
	 * @return
	 */
	public int deleteRewardTemplate(RewardTemplateBean rewardTemplateBean);
	/**
	 * 添加奖励模板
	 * @param rewardTemplateBean
	 * @return
	 */
	public int insertRewardTemplate(RewardTemplateBean rewardTemplateBean);
	/**
	 * 奖励模板详情
	 * @param rewardTemplateBean
	 * @return
	 */
	public RewardTemplateBean getRewardTemplate(RewardTemplateBean rewardTemplateBean);
	
	/**
	 * 用户挑战列表
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberChallengeBean> getMemberChallenges(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	/**
	 * 修改用户挑战
	 * @param memberChallengeBean
	 * @return
	 */
	public int updateMemberChallenge(MemberChallengeBean memberChallengeBean);
	/**
	 * 删除用户挑战
	 * @param memberChallengeBean
	 * @return
	 */
	public int deleteMemberChallenge(MemberChallengeBean memberChallengeBean);
	/**
	 * 添加用户挑战
	 * @param memberChallengeBean
	 * @return
	 */
	public int insertMemberChallenge(MemberChallengeBean memberChallengeBean);
	/**
	 * 用户挑战详情
	 * @param memberChallengeBean
	 * @return
	 */
	public MemberChallengeBean getMemberChallenge(MemberChallengeBean memberChallengeBean);
	
	/**
	 * 固定值奖励列表
	 * @param fixedRewardBean
	 * @param pageBean
	 * @return
	 */
	public List<FixedRewardBean> getFixedRewards(FixedRewardBean fixedRewardBean,PageBean pageBean);
	
	/**
	 * 固定值奖励不分页
	 * @param fixedRewardBean
	 * @return
	 */
	public List<FixedRewardBean> getFixedRewardsNoPage(FixedRewardBean fixedRewardBean);
	/**
	 * 修改固定值奖励
	 * @param fixedRewardBean
	 * @return
	 */
	public int updateFixedReward(FixedRewardBean fixedRewardBean);
	/**
	 * 删除固定值奖励
	 * @param fixedRewardBean
	 * @return
	 */
	public int deleteFixedReward(FixedRewardBean fixedRewardBean);
	/**
	 * 添加固定值奖励
	 * @param fixedRewardBean
	 * @return
	 */
	public int insertFixedReward(FixedRewardBean fixedRewardBean);
	/**
	 * 固定值详情
	 * @param fixedRewardBean
	 * @return
	 */
	public FixedRewardBean getFixedReward(FixedRewardBean fixedRewardBean);
	
	
	/**
	 * 模板列表
	 * @param fixedRewardBean
	 * @param pageBean
	 * @return
	 */
	public List<FixedRewardModelBean> getFixedRewardModels(FixedRewardModelBean fixedRewardModelBean,PageBean pageBean);
	/**
	 * 模板不分页
	 * @param fixedRewardModelBean
	 * @return
	 */
	public List<FixedRewardModelBean> getFixedRewardModelNoPage(FixedRewardModelBean fixedRewardModelBean);
	/**
	 * 修改模板
	 * @param fixedRewardBean
	 * @return
	 */
	public int updateFixedRewardModel(FixedRewardModelBean fixedRewardModelBean);
	/**
	 * 删除模板
	 * @param fixedRewardBean
	 * @return
	 */
	public int deleteFixedRewardModel(FixedRewardModelBean fixedRewardModelBean);
	/**
	 * 添加模板
	 * @param fixedRewardBean
	 * @return
	 */
	public int insertFixedRewardModel(FixedRewardModelBean fixedRewardModelBean);
	/**
	 * 模板详情
	 * @param fixedRewardBean
	 * @return
	 */
	public FixedRewardModelBean getFixedRewardModel(FixedRewardModelBean fixedRewardModelBean);
	
	/**
	 * 添加固定值
	 * @param challengeFixedRewardBean
	 * @return
	 */
	public int insertChallengeFixedReward(ChallengeFixedRewardBean challengeFixedRewardBean);
	
	/**
	 * 添加分成
	 * @param challengeSalesRewardBean
	 * @return
	 */
	public int insertChallengeSalesReward(ChallengeSalesRewardBean challengeSalesRewardBean);
	
	/**
	 * 销售分成明细
	 * @param challengeSalesRewardBean
	 * @return
	 */
	public List<ChallengeSalesRewardBean> getChallengeSalesRewards(ChallengeSalesRewardBean challengeSalesRewardBean);
	
	/**
	 * 固定奖励明细
	 * @param challengeFixedRewardBean
	 * @return
	 */
	public List<ChallengeFixedRewardBean> getChallengeFixedRewards(ChallengeFixedRewardBean challengeFixedRewardBean);
	
	/**
	 * 奖励列表
	 * @param memberRewardBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberRewardBean> getMemberRewards(MemberRewardBean memberRewardBean,PageBean pageBean);
	/**
	 * 修改奖励结算状态
	 * @param memberRewardBean
	 * @return
	 */
	public int updateMemberReward(MemberRewardBean memberRewardBean);
	/**
	 * 奖励详情
	 * @param memberRewardBean
	 * @return
	 */
	public MemberRewardBean getMemberRewardDetail(MemberRewardBean memberRewardBean);
	
	

}
