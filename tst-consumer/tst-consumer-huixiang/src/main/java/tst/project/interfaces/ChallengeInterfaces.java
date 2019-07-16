package tst.project.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tst.project.aspect.AppController;
import tst.project.bean.challenge.ChallengeCollectionBean;
import tst.project.bean.challenge.ChallengeCommentBean;
import tst.project.bean.challenge.ChallengeFollowBean;
import tst.project.bean.challenge.ChallengeFootprintBean;
import tst.project.bean.challenge.ChallengeShareBean;
import tst.project.bean.challenge.ChallengeWellBean;
import tst.project.bean.challenge.MemberLableBean;
import tst.project.bean.setting.ChallengeActivityBean;
import tst.project.bean.setting.ChallengeRuleBean;
import tst.project.bean.setting.MemberChallengeBean;
import tst.project.page.PageBean;

@Controller
@RequestMapping("/challengeInterfaces/v1.0")
public class ChallengeInterfaces {
	@Autowired
	IChallengeService challengeService;

	@RequestMapping("/getChallengeActivitys")
	@AppController(isPage=true)
	public Object getChallengeActivitys(ChallengeActivityBean challengeActivityBean, PageBean pageBean)throws Exception{
		return challengeService.getChallengeActivitys(challengeActivityBean, pageBean);
	}	
	@RequestMapping("/getChallengeRules")
	@AppController(isPage=true)
	public Object getChallengeRules(ChallengeRuleBean challengeRuleBean, PageBean pageBean)throws Exception{
		return challengeService.getChallengeRules(challengeRuleBean, pageBean);
	}	
	@RequestMapping("/getChallengeRuleDetail")
	@AppController()
	public Object getChallengeRuleDetail(ChallengeRuleBean challengeRuleBean)throws Exception{
		return challengeService.getChallengeRuleDetail(challengeRuleBean);
	}	
	
	@RequestMapping("/getChallengeActivity")
	@AppController()
	public Object getChallengeActivity(ChallengeActivityBean challengeActivityBean)throws Exception{
		return challengeService.getChallengeActivity(challengeActivityBean);
	}
	@RequestMapping("/getCurrentChallengeActivity")
	@AppController()
	public Object getCurrentChallengeActivity(ChallengeActivityBean challengeActivityBean)throws Exception{
		return challengeService.getCurrentChallengeActivity(challengeActivityBean);
	}
	@RequestMapping("/getNextChallengeActivity")
	@AppController()
	public Object getNextChallengeActivity(ChallengeActivityBean challengeActivityBean)throws Exception{
		return challengeService.getNextChallengeActivity(challengeActivityBean);
	}
	

	@RequestMapping("/getMemberChallenges")
	@AppController(isPage=true)
	public Object getMemberChallenges(MemberChallengeBean memberChallengeBean, PageBean pageBean)throws Exception{
		return challengeService.getMemberChallenges(memberChallengeBean, pageBean);
	}	
	
	@RequestMapping("/getMemberChallengesByRank")
	@AppController(isPage=true)
	public Object getMemberChallengesByRank(MemberChallengeBean memberChallengeBean, PageBean pageBean)throws Exception{
		return challengeService.getMemberChallengesByRank(memberChallengeBean, pageBean);
	}
	@RequestMapping("/getMemberChallengesByFront")
	@AppController(isPage=true)
	public Object getMemberChallengesByFront(MemberChallengeBean memberChallengeBean, PageBean pageBean)throws Exception{
		return challengeService.getMemberChallengesByFront(memberChallengeBean, pageBean);
	}	
	
	@RequestMapping("/getMemberChallengesByWidth")
	@AppController(isPage=true)
	public Object getMemberChallengesByWidth(MemberChallengeBean memberChallengeBean, PageBean pageBean)throws Exception{
		return challengeService.getMemberChallengesByWidth(memberChallengeBean, pageBean);
	}	
	@RequestMapping("/getMemberChallengesByWidthTest")
	@AppController(isPage=true)
	public Object getMemberChallengesByWidthTest(MemberChallengeBean memberChallengeBean, PageBean pageBean)throws Exception{
		return challengeService.getMemberChallengesByWidthTest(memberChallengeBean, pageBean);
	}	
	@RequestMapping("/getMemberChallengesByHeight")
	@AppController(isPage=true)
	public Object getMemberChallengesByHeight(MemberChallengeBean memberChallengeBean, PageBean pageBean)throws Exception{
		return challengeService.getMemberChallengesByHeight(memberChallengeBean, pageBean);
	}	
	@RequestMapping("/getMemberChallengesByHeightTest")
	@AppController(isPage=true)
	public Object getMemberChallengesByHeightTest(MemberChallengeBean memberChallengeBean, PageBean pageBean)throws Exception{
		return challengeService.getMemberChallengesByHeightTest(memberChallengeBean, pageBean);
	}	
	@RequestMapping("/getMemberChallengesByProdClass")
	@AppController(isPage=true)
	public Object getMemberChallengesByProdClass(MemberChallengeBean memberChallengeBean, PageBean pageBean)throws Exception{
		return challengeService.getMemberChallengesByProdClass(memberChallengeBean, pageBean);
	}	
	@RequestMapping("/getMemberChallengesByClass")
	@AppController(isPage=true)
	public Object getMemberChallengesByClass(MemberChallengeBean memberChallengeBean, PageBean pageBean)throws Exception{
		return challengeService.getMemberChallengesByClass(memberChallengeBean, pageBean);
	}	
	
	@RequestMapping("/getMemberChallengesIsFront")
	@AppController(isVerToken=true,isPage=true)
	public Object getMemberChallengesIsFront(MemberChallengeBean memberChallengeBean, PageBean pageBean)throws Exception{
		return challengeService.getMemberChallengesIsFront(memberChallengeBean, pageBean);
	}	
	
	@RequestMapping("/updateMemberChallenge")
	@AppController(isVerToken=true)
	public Object updateMemberChallenge(MemberChallengeBean memberChallengeBean)throws Exception{
		return challengeService.updateMemberChallenge(memberChallengeBean);
	}	
	@RequestMapping("/getMemberChallenge")
	@AppController()
	public Object getMemberChallenge(MemberChallengeBean memberChallengeBean)throws Exception{
		return challengeService.getMemberChallenge(memberChallengeBean);
	}
	@RequestMapping("/deleteMemberChallenge") 
    @AppController(isVerToken=true)
    public Object deleteMemberChallenge(MemberChallengeBean memberChallengeBean) throws Exception{ 
		return challengeService.deleteMemberChallenge(memberChallengeBean);
	}
	
	@RequestMapping("/insertMemberChallenge") 
    @AppController(isVerToken=true)
	public Object insertMemberChallenge(MemberChallengeBean memberChallengeBean) throws Exception{ 
		return challengeService.insertMemberChallenge(memberChallengeBean);
	}
	
	@RequestMapping("/insertChallengeFootprint") 
    @AppController(isVerToken=true)
	public Object insertChallengeFootprint(ChallengeFootprintBean challengeFootprintBean) throws Exception{ 
		return challengeService.insertChallengeFootprint(challengeFootprintBean);
	}
	@RequestMapping("/insertChallengeWell") 
    @AppController()
	public Object insertChallengeWell(ChallengeWellBean challengeWellBean) throws Exception{ 
		return challengeService.insertChallengeWell(challengeWellBean);
	}
	@RequestMapping("/deleteChallengeWell") 
    @AppController(isVerToken=true)
	public Object deleteChallengeWell(ChallengeWellBean challengeWellBean) throws Exception{ 
		return challengeService.deleteChallengeWell(challengeWellBean);
	}
	@RequestMapping("/insertChallengeShare") 
    @AppController(isVerToken=true)
	public Object insertChallengeShare(ChallengeShareBean challengeShareBean) throws Exception{ 
		return challengeService.insertChallengeShare(challengeShareBean);
	}
	@RequestMapping("/insertChallengeCollection") 
    @AppController(isVerToken=true)
	public Object insertChallengeCollection(ChallengeCollectionBean challengeCollectionBean) throws Exception{ 
		return challengeService.insertChallengeCollection(challengeCollectionBean);
	}
	@RequestMapping("/deleteChallengeCollection") 
    @AppController(isVerToken=true)
	public Object deleteChallengeCollection(ChallengeCollectionBean challengeCollectionBean) throws Exception{ 
		return challengeService.deleteChallengeCollection(challengeCollectionBean);
	}
	@RequestMapping("/insertChallengeComment") 
    @AppController(isVerToken=true)
	public Object insertChallengeComment(ChallengeCommentBean challengeCommentBean) throws Exception{ 
		return challengeService.insertChallengeComment(challengeCommentBean);
	}
	@RequestMapping("/getChallengeComments") 
    @AppController(isPage=true)
	public Object getChallengeComments(ChallengeCommentBean challengeCommentBean,PageBean pageBean) throws Exception{ 
		return challengeService.getChallengeComments(challengeCommentBean,pageBean);
	}
	
	@RequestMapping("/insertChallengeFollow") 
    @AppController(isVerToken=true)
	public Object insertChallengeFollow(ChallengeFollowBean challengeFollowBean) throws Exception{ 
		
		return challengeService.insertChallengeFollow(challengeFollowBean);
	}
	
	@RequestMapping("/insertMemberLable") 
    @AppController(isVerToken=true)
	public Object insertMemberLable(MemberLableBean memberLableBean) throws Exception{ 
		return challengeService.insertMemberLable(memberLableBean);
	}
	@RequestMapping("/updateMemberLable") 
    @AppController(isVerToken=true)
	public Object updateMemberLable(MemberLableBean memberLableBean) throws Exception{ 
		return challengeService.updateMemberLable(memberLableBean);
	}
	@RequestMapping("/getMemberLableDetail") 
    @AppController(isVerToken=true)
	public Object getMemberLableDetail(MemberLableBean memberLableBean) throws Exception{ 
		return challengeService.getMemberLableDetail(memberLableBean);
	}
	@RequestMapping("/deleteChallengeFollow") 
    @AppController(isVerToken=true)
	public Object deleteChallengeFollow(ChallengeFollowBean challengeFollowBean) throws Exception{ 
		return challengeService.deleteChallengeFollow(challengeFollowBean);
	}
	@RequestMapping("/getCurrentRankChallenge")
	@AppController(isVerToken=true)
	public Object getCurrentRankChallenge(MemberChallengeBean memberChallengeBean)throws Exception{
		return challengeService.getCurrentRankChallenge(memberChallengeBean);
	}
	
	@RequestMapping("/timingPayChallenge")
	@AppController(isLog=false)
	public Object timingPayChallenge() throws Exception {
		return challengeService.timingPayChallenge();
	}
}
