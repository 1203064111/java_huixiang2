package tst.project.interfaces;

import tst.project.bean.challenge.ChallengeFollowBean;
import tst.project.bean.challenge.ChallengeFootprintBean;
import tst.project.bean.member.CollectionBean;
import tst.project.bean.setting.MemberChallengeBean;
import tst.project.bean.setting.MemberRewardBean;
import tst.project.page.PageBean;

public interface ICollectionService {
	
	/**
	 * 收藏列表
	 * @author sjb
	 * @param collectionBean
	 * @param pageBean
	 * @return
	 */
	public Object getCollections(CollectionBean collectionBean,PageBean pageBean);
	
	/**
	 * 足迹的视频列表
	 * @author lx
	 * @param challengeFootprintBean
	 * @param pageBean
	 * @return
	 */
	public Object getFootprints(ChallengeFootprintBean challengeFootprintBean,PageBean pageBean);
	/**
	 * 用户的关注用户列表
	 * @author lx
	 * @param challengeFollowBean
	 * @param pageBean
	 * @return
	 */
	public Object getFollowMembers(ChallengeFollowBean challengeFollowBean,PageBean pageBean);
	
	/**
	 * 用户的粉丝列表
	 * @author lx
	 * @param challengeFollowBean
	 * @param pageBean
	 * @return
	 */
	public Object getFansMembers(ChallengeFollowBean challengeFollowBean,PageBean pageBean);
	
	
	
	/**
	 * 此用户的挑战
	 * @author lx
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberChallengesByMember(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	/**
	 * 搜索商品对应的视频列表
	 * @author lx
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberChallengesBySearch(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	/**
	 * 此用户点赞过的视频
	 * @author lx
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberChallengesIsWellByMember(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	
	/**
	 * 添加/取消收藏
	 * @param collectionBean
	 * @return
	 */
	public Object insertCollection(CollectionBean collectionBean);
	
	/**
	 * 用户奖励列表
	 * @author lx
	 * @param memberRewardBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberRewards(MemberRewardBean memberRewardBean,PageBean pageBean);
}
