package tst.project.interfaces;

import com.alipay.api.domain.AlipaySocialBaseChatGmemberConfirmModel;

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

public interface IChallengeService {
	
	/**
	 * 添加视频足迹
	 * @author lx
	 * @param challengeFootprintBean
	 * @return
	 */
	public Object insertChallengeFootprint(ChallengeFootprintBean challengeFootprintBean);
	/**
	 * 点赞视频
	 * @author lx
	 * @param challengeWellBean
	 * @return
	 */
	public Object insertChallengeWell(ChallengeWellBean challengeWellBean);
	/**
	 * 取消点赞
	 * @author lx
	 * @param challengeWellBean
	 * @return
	 */
	public Object deleteChallengeWell(ChallengeWellBean challengeWellBean);
	/**
	 * 分享视频
	 * @author lx
	 * @param challengeShareBean
	 * @return
	 */
	public Object insertChallengeShare(ChallengeShareBean challengeShareBean);
	/**
	 * 评论视频
	 * @author lx
	 * @param challengeCommentBean
	 * @return
	 */
	public Object insertChallengeComment(ChallengeCommentBean challengeCommentBean);
	/**
	 * 评论列表
	 * @author lx
	 * @param challengeCommentBean
	 * @return
	 */
	public Object getChallengeComments(ChallengeCommentBean challengeCommentBean,PageBean pageBean);
	/**
	 * 关注用户
	 * @author lx
	 * @param challengeCommentBean
	 * @return
	 */
	public Object insertChallengeFollow(ChallengeFollowBean challengeFollowBean);
	
	/**
	 * 添加用户标签
	 * @author lx
	 * @param memberLableBean
	 * @return
	 */
	public Object insertMemberLable(MemberLableBean memberLableBean);
	/**
	 * 修改用户标签
	 * @author lx
	 * @param memberLableBean
	 * @return
	 */
	public Object updateMemberLable(MemberLableBean memberLableBean);
	/**
	 * 查看用户标签详情
	 * @author lx
	 * @param memberLableBean
	 * @return
	 */
	public Object getMemberLableDetail(MemberLableBean memberLableBean);
	/**
	 * 取消关注
	 * @author lx
	 * @param challengeCommentBean
	 * @return
	 */
	public Object deleteChallengeFollow(ChallengeFollowBean challengeFollowBean);
	
	/**
	 * 收藏视频
	 * @author lx
	 * @param challengeCollectionBean
	 * @return
	 */
	public Object insertChallengeCollection(ChallengeCollectionBean challengeCollectionBean);
	/**
	 * 取消收藏
	 * @author lx
	 * @param challengeCollectionBean
	 * @return
	 */
	public Object deleteChallengeCollection(ChallengeCollectionBean challengeCollectionBean);
	

	/**
	 * 挑战活动列表
	 * @author lx
	 * @param challengeActivityBean
	 * @param pageBean
	 * @return
	 */
	public Object getChallengeActivitys(ChallengeActivityBean challengeActivityBean, PageBean pageBean);
	/**
	 * 规则列表
	 * @author lx
	 * @param challengeRuleBean
	 * @param pageBean
	 * @return
	 */
	public Object getChallengeRules(ChallengeRuleBean challengeRuleBean, PageBean pageBean);
	
	
	/**
	 * 规则详情
	 * @author lx
	 * @param challengeRuleBean
	 * @return
	 */
	public Object getChallengeRuleDetail(ChallengeRuleBean challengeRuleBean);
	/**
	 * 挑战活动详情
	 * @author lx
	 * @param challengeActivityBean
	 * @return
	 */
	public Object getChallengeActivity(ChallengeActivityBean challengeActivityBean);
	/**
	 * 获取当前的挑战
	 * @author lx
	 * @param challengeActivityBean
	 * @return
	 */
	public Object getCurrentChallengeActivity(ChallengeActivityBean challengeActivityBean);
	/**
	 * 获取下一个待挑战
	 * @author lx
	 * @param challengeActivityBean
	 * @return
	 */
	public Object getNextChallengeActivity(ChallengeActivityBean challengeActivityBean);
	
	
	/**
	 * 用户挑战列表
	 * @author lx
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberChallenges(MemberChallengeBean memberChallengeBean, PageBean pageBean);
	/**
	 * 用户挑战列表 排名信息等
	 * @author lx
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberChallengesByRank(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	
	
	/**
	 * 视频列表首页推荐
	 * @author lx
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberChallengesByFront(MemberChallengeBean memberChallengeBean, PageBean pageBean);
	
	/**
	 * 左右滑动视频列表
	 * @author lx
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberChallengesByWidth(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	public Object getMemberChallengesByWidthTest(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	
	/**
	 * 上下滑动视频列表
	 * @author lx
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberChallengesByHeight(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	public Object getMemberChallengesByHeightTest(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	
	
	/**
	 * 挑战视频左右滑动视频列表
	 * @author lx
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberChallengesByProdClass(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	
	
	
	/**
	 * 分类的视频列表
	 * @author lx
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberChallengesByClass(MemberChallengeBean memberChallengeBean, PageBean pageBean);
	
	
	/**
	 * 用户挑战列表首页推荐
	 * @author lx
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberChallengesIsFront(MemberChallengeBean memberChallengeBean, PageBean pageBean);
	
	
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
	 * 当前用户的挑战排名信息
	 * @author lx
	 * @param memberChallengeBean
	 * @return
	 */
	public Object getCurrentRankChallenge(MemberChallengeBean memberChallengeBean);
	/**
	 * 定时结算挑战金额
	 * @author lx
	 * @return
	 */
	public Object timingPayChallenge();

}
