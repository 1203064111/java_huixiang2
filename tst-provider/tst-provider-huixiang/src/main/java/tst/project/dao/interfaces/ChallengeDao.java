package tst.project.dao.interfaces;
import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
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
import tst.project.bean.setting.MemberRewardBean;
import tst.project.page.PageBean;

@Mapper
public interface ChallengeDao {
	/**
	 * 添加视频足迹
	 * @param challengeFootprintBean
	 * @return
	 */
	public int insertChallengeFootprint(ChallengeFootprintBean challengeFootprintBean);
	
	/**
	 * 点赞视频
	 * @author lx
	 * @param challengeWellBean
	 * @return
	 */
	public int insertChallengeWell(ChallengeWellBean challengeWellBean);
	
	
	/**
	 * 点赞记录
	 * @param challengeWellBean
	 * @return
	 */
	public ChallengeWellBean getChallengeWellDetail(ChallengeWellBean challengeWellBean);
	/**
	 * 取消点赞
	 * @param challengeWellBean
	 * @return
	 */
	public int deleteChallengeWell(ChallengeWellBean challengeWellBean);
	
	/**
	 * 添加用户标签
	 * @param memberLableBean
	 * @return
	 */
	public int insertMemberLable(MemberLableBean memberLableBean);
	/**
	 * 修改用户标签
	 * @param memberLableBean
	 * @return
	 */
	public int updateMemberLable(MemberLableBean memberLableBean);
	
	/**
	 * 用户标签详情
	 * @param memberLableBean
	 * @return
	 */
	public MemberLableBean getMemberLableDetail(MemberLableBean memberLableBean);
	/**
	 * 分享视频
	 * @author lx
	 * @param challengeShareBean
	 * @return
	 */
	public int insertChallengeShare(ChallengeShareBean challengeShareBean);
	/**
	 * 评论视频
	 * @author lx
	 * @param challengeCommentBean
	 * @return
	 */
	public int insertChallengeComment(ChallengeCommentBean challengeCommentBean);
	/**
	 * 收藏视频
	 * @author lx
	 * @param challengeCollectionBean
	 * @return
	 */
	public int insertChallengeCollection(ChallengeCollectionBean challengeCollectionBean);
	/**
	 * 取消收藏
	 * @param challengeCollectionBean
	 * @return
	 */
	public int deleteChallengeCollection(ChallengeCollectionBean challengeCollectionBean);
	
	/**
	 * 收藏记录
	 * @param challengeCollectionBean
	 * @return
	 */
	public ChallengeCollectionBean getChallengeCollectionDetail(ChallengeCollectionBean challengeCollectionBean);
	
	/**
	 * 关注记录
	 * @param challengeFollowBean
	 * @return
	 */
	public ChallengeFollowBean getChallengeFollowDetail(ChallengeFollowBean challengeFollowBean);
	/**
	 * 足迹记录
	 * @param challengeFootprintBean
	 * @return
	 */
	public ChallengeFootprintBean getChallengeFootprintDetail(ChallengeFootprintBean challengeFootprintBean);
	/**
	 * 添加关注
	 * @param challengeFollowBean
	 * @return
	 */
	public int insertChallengeFollow(ChallengeFollowBean challengeFollowBean);
	/**
	 * 取消关注
	 * @param challengeFollowBean
	 * @return
	 */
	public int deleteChallengeFollow(ChallengeFollowBean challengeFollowBean);
	
	
	
	/**
	 * 挑战活动列表
	 * @param challengeActivityBean
	 * @param pageBean
	 * @return
	 */
	public List<ChallengeActivityBean> getChallengeActivitys(ChallengeActivityBean challengeActivityBean,PageBean pageBean);
	
	
	/**
	 * 挑战规则列表
	 * @param challengeRuleBean
	 * @param pageBean
	 * @return
	 */
	public List<ChallengeRuleBean> getChallengeRules(ChallengeRuleBean challengeRuleBean,PageBean pageBean);
	
	/*
	 * 规则详情
	 */
	public ChallengeRuleBean getChallengeRuleDetail(ChallengeRuleBean challengeRuleBean);
	
	/**
	 * 挑战活动详情
	 * @param challengeActivityBean
	 * @return
	 */
	public ChallengeActivityBean getChallengeActivity(ChallengeActivityBean challengeActivityBean);
	
	/**
	 * 当前的挑战活动
	 * @param challengeActivityBean
	 * @return
	 */
	public ChallengeActivityBean getCurrentChallengeActivity(ChallengeActivityBean challengeActivityBean);
	/**
	 * 下一个待挑战活动
	 * @param challengeActivityBean
	 * @return
	 */
	public ChallengeActivityBean getNextChallengeActivity(ChallengeActivityBean challengeActivityBean);
	
	/**
	 * 用户挑战列表
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberChallengeBean> getMemberChallenges(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	
	/**
	 * 挑战列表 排名信息
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberChallengeBean> getMemberChallengesByRank(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	
	
	/**
	 * 分类的视频列表
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberChallengeBean> getMemberChallengesByClass(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	
	/**
	 * 首页的推荐视频列表
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberChallengeBean> getMemberChallengesByFront(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	/**
	 * 上下滑动的视频列表
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public List<Map<String,Object>> getMemberChallengesByHeight(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	public List<MemberChallengeBean> getMemberChallengesByHeightTest(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	
	public List<MemberChallengeBean> getMemberChallengesByWidthTest(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	/**
	 * 左右滑动的视频列表
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public List<Map<String,Object>> getMemberChallengesByWidth(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	
	/**
	 * 挑战视频左滑获取此类的视频
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public List<Map<String,Object>> getMemberChallengesByProdClass(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	

	
	
	
	/**
	 * 首页推荐的用户挑战列表
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberChallengeBean> getMemberChallengesIsFront(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	
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
	 * 用户挑战详情(不关联)
	 * @param memberChallengeBean
	 * @return
	 */
	public MemberChallengeBean getMemberChallengeDetail(MemberChallengeBean memberChallengeBean);
	/**
	 * 用户评论列表
	 * @param challengeCommentBean
	 * @param pageBean
	 * @return
	 */
	public List<ChallengeCommentBean> getChallengeComments(ChallengeCommentBean challengeCommentBean,PageBean pageBean); 
	/**
	 * 待结算的挑战列表
	 * @return
	 */
	public List<ChallengeActivityBean> getWaitPayChallenges();
	
	/**
	 * 用户挑战的排名  不分页
	 * 返回用户id
	 * @param memberChallengeBean
	 * @return
	 */
	public List<Map<String,Object>> getMemberChallengeByWell(MemberChallengeBean memberChallengeBean);
	
	/**
	 * 获取每个用户的最高点赞视频列表
	 * @param memberChallengeBean
	 * @return
	 */
	public List<Map<String, Object>> getHighestWellGroupByMember(MemberChallengeBean memberChallengeBean);
	
	
	/**
	 * 计算挑战的产品在时间内的销售总额以及销售量
	 * @param challengeActivityBean
	 * @return
	 */
	public Map<String, Object> getProductSalesAmount(ChallengeActivityBean challengeActivityBean);
	
	/**
	 * 添加用户奖金记录
	 * @param memberRewardBean
	 * @return
	 */
	public int insertMemberReward(MemberRewardBean memberRewardBean);
	/**
	 * 修改奖金打款状态
	 * @param memberRewardBean
	 * @return
	 */
	public int updateMemberReward(MemberRewardBean memberRewardBean);
	/**
	 * 找出当前用户的挑战视频排名信息
	 * @param memberChallengeBean
	 * @return
	 */
	public MemberChallengeBean getMemberRankByProductAndTime(MemberChallengeBean memberChallengeBean);
	/**
	 * 获取当前的排名信息
	 * @param memberChallengeBean
	 * @return
	 */
	public List<Map<String, Object>> getMemberRank(MemberChallengeBean memberChallengeBean);
	
	/**
	 * 当前挑战视频的排名信息
	 * @param memberChallengeBean
	 * @return
	 */
	public List<MemberChallengeBean> getCurrentTopTenMemberChallenges(MemberChallengeBean memberChallengeBean);
	/**
	 * 用户奖金列表
	 * @param memberRewardBean
	 * @return
	 */
	public List<MemberRewardBean> getMemberRewards(MemberRewardBean memberRewardBean);
	
	
}

