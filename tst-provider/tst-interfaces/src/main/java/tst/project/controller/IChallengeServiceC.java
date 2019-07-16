package tst.project.controller;

import tst.project.bean.setting.ChallengeActivityBean;
import tst.project.bean.setting.ChallengeRuleBean;
import tst.project.bean.setting.FixedRewardBean;
import tst.project.bean.setting.FixedRewardModelBean;
import tst.project.bean.setting.MemberChallengeBean;
import tst.project.bean.setting.MemberRewardBean;
import tst.project.bean.setting.RewardTemplateBean;
import tst.project.page.PageBean;

public interface IChallengeServiceC {
	/**
	 * 挑战活动列表
	 * @author lx
	 * @param challengeActivityBean
	 * @param pageBean
	 * @return
	 */
	public Object getChallengeActivitys(ChallengeActivityBean challengeActivityBean, PageBean pageBean);
	/**
	 * 挑战活动详情
	 * @author lx
	 * @param challengeActivityBean
	 * @return
	 */
	public Object getChallengeActivity(ChallengeActivityBean challengeActivityBean);
	/**
	 * 修改挑战活动
	 * @author lx
	 * @param challengeActivityBean
	 * @return
	 */
	public Object updateChallengeActivity(ChallengeActivityBean challengeActivityBean);
	/**
	 * 添加挑战活动
	 * @author lx
	 * @param challengeActivityBean
	 * @return
	 */
	public Object insertChallengeActivity(ChallengeActivityBean challengeActivityBean);
	/**
	 * 删除挑战活动
	 * @author lx
	 * @param challengeActivityBean
	 * @return
	 */
	public Object deleteChallengeActivity(ChallengeActivityBean challengeActivityBean);
	/**
	 * 挑战规则列表
	 * @author lx
	 * @param challengeRuleBean
	 * @param pageBean
	 * @return
	 */
	public Object getChallengeRules(ChallengeRuleBean challengeRuleBean, PageBean pageBean);
	/**
	 * 挑战规则详情
	 * @author lx
	 * @param challengeRuleBean
	 * @return
	 */
	public Object getChallengeRule(ChallengeRuleBean challengeRuleBean);
	/**
	 * 修改挑战规则
	 * @author lx
	 * @param challengeRuleBean
	 * @return
	 */
	public Object updateChallengeRule(ChallengeRuleBean challengeRuleBean);
	/**
	 * 添加挑战规则
	 * @author lx
	 * @param challengeRuleBean
	 * @return
	 */
	public Object insertChallengeRule(ChallengeRuleBean challengeRuleBean);
	/**
	 * 删除挑战规则
	 * @author lx
	 * @param challengeRuleBean
	 * @return
	 */
	public Object deleteChallengeRule(ChallengeRuleBean challengeRuleBean);
	
	/**
	 * 奖励方式模板列表
	 * @author lx
	 * @param rewardTemplateBean
	 * @param pageBean
	 * @return
	 */
	public Object getRewardTemplates(RewardTemplateBean rewardTemplateBean, PageBean pageBean);
	/**
	 * 奖励方式模板详情
	 * @author lx
	 * @param rewardTemplateBean
	 * @return
	 */
	public Object getRewardTemplate(RewardTemplateBean rewardTemplateBean);
	/**
	 * 修改奖励方式模板
	 * @author lx
	 * @param rewardTemplateBean
	 * @return
	 */
	public Object updateRewardTemplate(RewardTemplateBean rewardTemplateBean);
	/**
	 * 添加奖励方式模板
	 * @author lx
	 * @param rewardTemplateBean
	 * @return
	 */
	public Object insertRewardTemplate(RewardTemplateBean rewardTemplateBean);
	/**
	 * 删除奖励方式模板
	 * @author lx
	 * @param rewardTemplateBean
	 * @return
	 */
	public Object deleteRewardTemplate(RewardTemplateBean rewardTemplateBean);
	/**
	 * 用户挑战列表
	 * @author lx
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberChallenges(MemberChallengeBean memberChallengeBean, PageBean pageBean);
	/**
	 * 用户挑战详情
	 * @author lx
	 * @param memberChallengeBean
	 * @return
	 */
	public Object getMemberChallenge(MemberChallengeBean memberChallengeBean);
	/**
	 * 修改用户挑战
	 * @author lx
	 * @param memberChallengeBean
	 * @return
	 */
	public Object updateMemberChallenge(MemberChallengeBean memberChallengeBean);
	/**
	 * 添加用户挑战
	 * @author lx
	 * @param memberChallengeBean
	 * @return
	 */
	public Object insertMemberChallenge(MemberChallengeBean memberChallengeBean);
	/**
	 * 删除用户挑战
	 * @author lx
	 * @param memberChallengeBean
	 * @return
	 */
	public Object deleteMemberChallenge(MemberChallengeBean memberChallengeBean);
	/**
	 * 固定值奖励列表
	 * @author lx
	 * @param fixedRewardBean
	 * @param pageBean
	 * @return
	 */
	public Object getFixedRewards(FixedRewardBean fixedRewardBean, PageBean pageBean);
	/**
	 * 固定值详情
	 * @author lx
	 * @param fixedRewardBean
	 * @return
	 */
	public Object getFixedReward(FixedRewardBean fixedRewardBean);
	/**
	 * 修改固定值奖励
	 * @author lx
	 * @param fixedRewardBean
	 * @return
	 */
	public Object updateFixedReward(FixedRewardBean fixedRewardBean);
	/**
	 * 添加固定值奖励
	 * @author lx
	 * @param fixedRewardBean
	 * @return
	 */
	public Object insertFixedReward(FixedRewardBean fixedRewardBean);
	/**
	 * 删除固定值奖励
	 * @author lx
	 * @param fixedRewardBean
	 * @return
	 */
	public Object deleteFixedReward(FixedRewardBean fixedRewardBean);
	
	
	
	/**
	 * 固定值奖励列表
	 * @author lx
	 * @param fixedRewardBean
	 * @param pageBean
	 * @return
	 */
	public Object getFixedRewardModels(FixedRewardModelBean fixedRewardModelBean, PageBean pageBean);
	
	
	/**
	 * 奖励模板不分页 模板类型 fixed固定值 sales销售分成
	 * @author lx
	 * @param fixedRewardModelBean
	 * @return
	 */
	public Object getFixedRewardModelNoPage(FixedRewardModelBean fixedRewardModelBean);
	/**
	 * 固定值详情
	 * @author lx
	 * @param fixedRewardBean
	 * @return
	 */
	public Object getFixedRewardModel(FixedRewardModelBean fixedRewardModelBean);
	/**
	 * 修改固定值奖励
	 * @author lx
	 * @param fixedRewardBean
	 * @return
	 */
	public Object updateFixedRewardModel(FixedRewardModelBean fixedRewardModelBean);
	/**
	 * 添加固定值奖励
	 * @author lx
	 * @param fixedRewardBean
	 * @return
	 */
	public Object insertFixedRewardModel(FixedRewardModelBean fixedRewardModelBean);
	/**
	 * 删除固定值奖励
	 * @author lx
	 * @param fixedRewardBean
	 * @return
	 */
	public Object deleteFixedRewardModel(FixedRewardModelBean fixedRewardModelBean);
	/**
	 * 奖励列表
	 * @author lx
	 * @param memberRewardBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberRewards(MemberRewardBean memberRewardBean,PageBean pageBean);
	/**
	 * 修改奖励结算状态
	 * @author lx
	 * @param memberRewardBean
	 * @return
	 */
	public Object updateMemberReward(MemberRewardBean memberRewardBean);
}
