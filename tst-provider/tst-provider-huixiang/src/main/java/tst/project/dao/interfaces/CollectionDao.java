package tst.project.dao.interfaces;

import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
import tst.project.bean.challenge.ChallengeFollowBean;
import tst.project.bean.challenge.ChallengeFootprintBean;
import tst.project.bean.member.CollectionBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.product.FootprintBean;
import tst.project.bean.setting.MemberChallengeBean;
import tst.project.bean.setting.MemberRewardBean;
import tst.project.page.PageBean;

@Mapper
public interface CollectionDao {
	
	/**
	 * 收藏列表
	 * @author sjb
	 * @param collectionBean
	 * @param pageBean
	 * @return
	 */
	public List<Map<String,Object>> getCollections(CollectionBean collectionBean,PageBean pageBean);
	
	
	/**
	 * 修改收藏
	 * @param collectionBean
	 * @return
	 */
	public int updateCollection(CollectionBean collectionBean);
	
	/**
	 * 添加收藏
	 * @param collectionBean
	 * @return
	 */
	public int insertCollection(CollectionBean collectionBean);
	
	/**
	 * 收藏详情
	 * @param collectionBean
	 * @return
	 */
	public CollectionBean getCollectionDetail(CollectionBean collectionBean);
	/**
	 * 关注用户列表
	 * @param challengeFollowBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberBean> getFollowMembers(ChallengeFollowBean challengeFollowBean,PageBean pageBean);
	/**
	 * 用户的粉丝列表
	 * @param challengeFollowBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberBean> getFansMembers(ChallengeFollowBean challengeFollowBean,PageBean pageBean);
	
	
	/**
	 * 此用户的挑战列表
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberChallengeBean> getMemberChallengesByMember(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	/**
	 * 搜索的商品视频列表
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberChallengeBean> getMemberChallengesBySearch(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	
	/**
	 * 此用户点赞过的视频
	 * @param memberChallengeBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberChallengeBean> getMemberChallengesIsWellByMember(MemberChallengeBean memberChallengeBean,PageBean pageBean);
	
	/**
	 * 足迹的用户视频列表
	 * @param footprintBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberChallengeBean> getFootprints(ChallengeFootprintBean challengeFootprintBean,PageBean pageBean);
	
	/**
	 * 用户的奖励收成列表
	 * @param memberRewardBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberRewardBean> getMemberRewards(MemberRewardBean memberRewardBean,PageBean pageBean);
}
