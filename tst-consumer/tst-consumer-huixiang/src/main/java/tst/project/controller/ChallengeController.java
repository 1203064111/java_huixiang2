package tst.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tst.project.aspect.AppController;
import tst.project.bean.setting.ChallengeActivityBean;
import tst.project.bean.setting.ChallengeRuleBean;
import tst.project.bean.setting.FixedRewardBean;
import tst.project.bean.setting.FixedRewardModelBean;
import tst.project.bean.setting.MemberChallengeBean;
import tst.project.bean.setting.MemberRewardBean;
import tst.project.bean.setting.RewardTemplateBean;
import tst.project.page.PageBean;

@Controller
@RequestMapping("/challengeController/v1.0")
public class ChallengeController {
	@Autowired
	IChallengeServiceC challengeServiceC;

	@RequestMapping("/getChallengeActivitys")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getChallengeActivitys(ChallengeActivityBean challengeActivityBean, PageBean pageBean)throws Exception{
		return challengeServiceC.getChallengeActivitys(challengeActivityBean, pageBean);
	}	
	@RequestMapping("/updateChallengeActivity")
	@AppController(isVerSystemToken=true)
	public Object updateChallengeActivity(ChallengeActivityBean challengeActivityBean)throws Exception{
		return challengeServiceC.updateChallengeActivity(challengeActivityBean);
	}	
	@RequestMapping("/getChallengeActivity")
	@AppController(isVerSystemToken=true)
	public Object getChallengeActivity(ChallengeActivityBean challengeActivityBean)throws Exception{
		return challengeServiceC.getChallengeActivity(challengeActivityBean);
	}
	@RequestMapping("/deleteChallengeActivity") 
    @AppController(isVerSystemToken=true)
    public Object deleteChallengeActivity(ChallengeActivityBean challengeActivityBean) throws Exception{ 
		return challengeServiceC.deleteChallengeActivity(challengeActivityBean);
	}
	
	@RequestMapping("/insertChallengeActivity") 
    @AppController(isVerSystemToken=true)
	public Object insertChallengeActivity(ChallengeActivityBean challengeActivityBean) throws Exception{ 
		
		return challengeServiceC.insertChallengeActivity(challengeActivityBean);
	}
	
	
	
	@RequestMapping("/getChallengeRules")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getChallengeRules(ChallengeRuleBean challengeRuleBean, PageBean pageBean)throws Exception{
		return challengeServiceC.getChallengeRules(challengeRuleBean, pageBean);
	}	
	@RequestMapping("/updateChallengeRule")
	@AppController(isVerSystemToken=true)
	public Object updateChallengeRule(ChallengeRuleBean challengeRuleBean)throws Exception{
		return challengeServiceC.updateChallengeRule(challengeRuleBean);
	}	
	@RequestMapping("/getChallengeRule")
	@AppController(isVerSystemToken=true)
	public Object getChallengeRule(ChallengeRuleBean challengeRuleBean)throws Exception{
		return challengeServiceC.getChallengeRule(challengeRuleBean);
	}
	@RequestMapping("/deleteChallengeRule") 
    @AppController(isVerSystemToken=true)
    public Object deleteChallengeRule(ChallengeRuleBean challengeRuleBean) throws Exception{ 
		return challengeServiceC.deleteChallengeRule(challengeRuleBean);
	}
	
	@RequestMapping("/insertChallengeRule") 
    @AppController(isVerSystemToken=true)
	public Object insertChallengeRule(ChallengeRuleBean challengeRuleBean) throws Exception{ 
		
		return challengeServiceC.insertChallengeRule(challengeRuleBean);
	}
	
	

	
	@RequestMapping("/getRewardTemplates")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getRewardTemplates(RewardTemplateBean rewardTemplateBean, PageBean pageBean)throws Exception{
		return challengeServiceC.getRewardTemplates(rewardTemplateBean, pageBean);
	}	
	@RequestMapping("/updateRewardTemplate")
	@AppController(isVerSystemToken=true)
	public Object updateRewardTemplate(RewardTemplateBean rewardTemplateBean)throws Exception{
		return challengeServiceC.updateRewardTemplate(rewardTemplateBean);
	}	
	@RequestMapping("/getRewardTemplate")
	@AppController(isVerSystemToken=true)
	public Object getRewardTemplate(RewardTemplateBean rewardTemplateBean)throws Exception{
		return challengeServiceC.getRewardTemplate(rewardTemplateBean);
	}
	@RequestMapping("/deleteRewardTemplate") 
    @AppController(isVerSystemToken=true)
    public Object deleteRewardTemplate(RewardTemplateBean rewardTemplateBean) throws Exception{ 
		return challengeServiceC.deleteRewardTemplate(rewardTemplateBean);
	}
	
	@RequestMapping("/insertRewardTemplate") 
    @AppController(isVerSystemToken=true)
	public Object insertRewardTemplate(RewardTemplateBean rewardTemplateBean) throws Exception{ 
		
		return challengeServiceC.insertRewardTemplate(rewardTemplateBean);
	}
	
	@RequestMapping("/getMemberChallenges")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getMemberChallenges(MemberChallengeBean memberChallengeBean, PageBean pageBean)throws Exception{
		return challengeServiceC.getMemberChallenges(memberChallengeBean, pageBean);
	}	
	@RequestMapping("/updateMemberChallenge")
	@AppController(isVerSystemToken=true)
	public Object updateMemberChallenge(MemberChallengeBean memberChallengeBean)throws Exception{
		return challengeServiceC.updateMemberChallenge(memberChallengeBean);
	}	
	@RequestMapping("/insertMemberChallenge")
	@AppController(isVerSystemToken=true)
	public Object insertMemberChallenge(MemberChallengeBean memberChallengeBean)throws Exception{
		return challengeServiceC.insertMemberChallenge(memberChallengeBean);
	}	
	@RequestMapping("/getMemberChallenge")
	@AppController(isVerSystemToken=true)
	public Object getMemberChallenge(MemberChallengeBean memberChallengeBean)throws Exception{
		return challengeServiceC.getMemberChallenge(memberChallengeBean);
	}
	@RequestMapping("/deleteMemberChallenge") 
    @AppController(isVerSystemToken=true)
    public Object deleteMemberChallenge(MemberChallengeBean memberChallengeBean) throws Exception{ 
		return challengeServiceC.deleteMemberChallenge(memberChallengeBean);
	}
	

	@RequestMapping("/getFixedRewards")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getFixedRewards(FixedRewardBean fixedRewardBean, PageBean pageBean)throws Exception{
		return challengeServiceC.getFixedRewards(fixedRewardBean, pageBean);
	}	
	@RequestMapping("/updateFixedReward")
	@AppController(isVerSystemToken=true)
	public Object updateFixedReward(FixedRewardBean fixedRewardBean)throws Exception{
		return challengeServiceC.updateFixedReward(fixedRewardBean);
	}	
	@RequestMapping("/getFixedReward")
	@AppController(isVerSystemToken=true)
	public Object getFixedReward(FixedRewardBean fixedRewardBean)throws Exception{
		return challengeServiceC.getFixedReward(fixedRewardBean);
	}
	@RequestMapping("/deleteFixedReward") 
    @AppController(isVerSystemToken=true)
    public Object deleteFixedReward(FixedRewardBean fixedRewardBean) throws Exception{ 
		return challengeServiceC.deleteFixedReward(fixedRewardBean);
	}
	
	@RequestMapping("/insertFixedReward") 
    @AppController(isVerSystemToken=true)
	public Object insertFixedReward(FixedRewardBean fixedRewardBean) throws Exception{ 
		
		return challengeServiceC.insertFixedReward(fixedRewardBean);
	}
	
	@RequestMapping("/getFixedRewardModelNoPage")
	@AppController()
	public Object getFixedRewardModelNoPage(FixedRewardModelBean fixedRewardModelBean)throws Exception{
		return challengeServiceC.getFixedRewardModelNoPage(fixedRewardModelBean);
	}	
	@RequestMapping("/getFixedRewardModels")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getFixedRewardModels(FixedRewardModelBean fixedRewardModelBean, PageBean pageBean)throws Exception{
		return challengeServiceC.getFixedRewardModels(fixedRewardModelBean, pageBean);
	}	
	@RequestMapping("/updateFixedRewardModel")
	@AppController(isVerSystemToken=true)
	public Object updateFixedRewardModel(FixedRewardModelBean fixedRewardModelBean)throws Exception{
		return challengeServiceC.updateFixedRewardModel(fixedRewardModelBean);
	}	
	@RequestMapping("/getFixedRewardModel")
	@AppController(isVerSystemToken=true)
	public Object getFixedRewardModel(FixedRewardModelBean fixedRewardModelBean)throws Exception{
		return challengeServiceC.getFixedRewardModel(fixedRewardModelBean);
	}
	@RequestMapping("/deleteFixedRewardModel") 
    @AppController(isVerSystemToken=true)
    public Object deleteFixedRewardModel(FixedRewardModelBean fixedRewardModelBean) throws Exception{ 
		return challengeServiceC.deleteFixedRewardModel(fixedRewardModelBean);
	}
	
	@RequestMapping("/insertFixedRewardModel") 
    @AppController(isVerSystemToken=true)
	public Object insertFixedRewardModel(FixedRewardModelBean fixedRewardModelBean) throws Exception{ 
		
		return challengeServiceC.insertFixedRewardModel(fixedRewardModelBean);
	}
	@RequestMapping("/getMemberRewards") 
    @AppController(isVerSystemToken=true,isPage=true)
	public Object getMemberRewards(MemberRewardBean memberRewardBean,PageBean pageBean) throws Exception{ 
		
		return challengeServiceC.getMemberRewards(memberRewardBean,pageBean);
	}
	@RequestMapping("/updateMemberReward") 
    @AppController(isVerSystemToken=true)
	public Object updateMemberReward(MemberRewardBean memberRewardBean) throws Exception{ 
		
		return challengeServiceC.updateMemberReward(memberRewardBean);
	}
	
	
}
