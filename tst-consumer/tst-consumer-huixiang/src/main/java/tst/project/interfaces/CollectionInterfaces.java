package tst.project.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tst.project.aspect.AppController;
import tst.project.bean.challenge.ChallengeFollowBean;
import tst.project.bean.challenge.ChallengeFootprintBean;
import tst.project.bean.member.CollectionBean;
import tst.project.bean.setting.MemberChallengeBean;
import tst.project.bean.setting.MemberRewardBean;
import tst.project.page.PageBean;

@Controller
@RequestMapping("/collectionInterfaces/v1.0")
public class CollectionInterfaces {
	
	@Autowired
	ICollectionService collectionService;
	
	
	@RequestMapping("/getCollections")
	@AppController(isPage=true)
	public Object getCollections(CollectionBean collectionBean,PageBean pageBean) throws Exception {
		return collectionService.getCollections(collectionBean,pageBean);
	}
	
	@RequestMapping("/getFootprints")
	@AppController(isPage=true)
	public Object getFootprints(ChallengeFootprintBean challengeFootprintBean,PageBean pageBean) throws Exception {
		return collectionService.getFootprints(challengeFootprintBean,pageBean);
	}
	@RequestMapping("/getFollowMembers")
	@AppController(isPage=true)
	public Object getFollowMembers(ChallengeFollowBean challengeFollowBean,PageBean pageBean) throws Exception {
		return collectionService.getFollowMembers(challengeFollowBean,pageBean);
	}
	@RequestMapping("/getFansMembers")
	@AppController(isPage=true)
	public Object getFansMembers(ChallengeFollowBean challengeFollowBean,PageBean pageBean) throws Exception {
		return collectionService.getFansMembers(challengeFollowBean,pageBean);
	}
	
	@RequestMapping("/getMemberChallengesByMember")
	@AppController(isPage=true)
	public Object getMemberChallengesByMember(MemberChallengeBean memberChallengeBean, PageBean pageBean)throws Exception{
		return collectionService.getMemberChallengesByMember(memberChallengeBean, pageBean);
	}	
	@RequestMapping("/getMemberChallengesBySearch")
	@AppController(isPage=true)
	public Object getMemberChallengesBySearch(MemberChallengeBean memberChallengeBean, PageBean pageBean)throws Exception{
		return collectionService.getMemberChallengesBySearch(memberChallengeBean, pageBean);
	}	
	@RequestMapping("/getMemberChallengesIsWellByMember")
	@AppController(isPage=true)
	public Object getMemberChallengesIsWellByMember(MemberChallengeBean memberChallengeBean, PageBean pageBean)throws Exception{
		return collectionService.getMemberChallengesIsWellByMember(memberChallengeBean, pageBean);
	}	
	
	@RequestMapping("/insertCollection")
	@AppController(isVerToken=true)
	public Object insertCollection(CollectionBean collectionBean) throws Exception {
		return collectionService.insertCollection(collectionBean);
	}
	
	@RequestMapping("/getMemberRewards")
	@AppController(isPage=true)
	public Object getMemberRewards(MemberRewardBean memberRewardBean,PageBean pageBean) throws Exception {
		return collectionService.getMemberRewards(memberRewardBean,pageBean);
	}
}
