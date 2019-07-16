package tst.project.service.interfaces;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alipay.api.domain.Product;

import tst.project.aspect.AppException;
import tst.project.bean.challenge.ChallengeFollowBean;
import tst.project.bean.challenge.ChallengeFootprintBean;
import tst.project.bean.member.CollectionBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.product.FootprintBean;
import tst.project.bean.product.ProductBean;
import tst.project.bean.setting.MemberChallengeBean;
import tst.project.bean.setting.MemberRewardBean;
import tst.project.bean.setting.PercentBean;
import tst.project.dao.controller.GoodsDaoC;
import tst.project.dao.interfaces.CollectionDao;
import tst.project.dao.interfaces.MemberDao;
import tst.project.dao.interfaces.ProductDao;
import tst.project.interfaces.ICollectionService;
import tst.project.page.PageBean;
import tst.project.utils.StringUtils;

@Service
@Transactional(rollbackFor=Exception.class)
public class CollectionService implements ICollectionService{
	@Autowired
	CollectionDao collectionDao;
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	GoodsDaoC goodsDaoC;
	
	@Override
	public Object getCollections(CollectionBean collectionBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> collectionBeans=collectionDao.getCollections(collectionBean, pageBean);
		return pageBean.setObject(collectionBeans);
	}
	
	@Override
	public Object getFollowMembers(ChallengeFollowBean challengeFollowBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MemberBean> memberBeans=collectionDao.getFollowMembers(challengeFollowBean, pageBean);
		for(MemberBean memberBean : memberBeans){
			String member_nick_name = "";
			try {
				member_nick_name = URLDecoder.decode(memberBean.getMember_nick_name(), "utf-8");
				memberBean.setMember_nick_name(member_nick_name);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pageBean.setObject(memberBeans);
	}
	@Override
	public Object getFansMembers(ChallengeFollowBean challengeFollowBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MemberBean> memberBeans=collectionDao.getFansMembers(challengeFollowBean, pageBean);
		for(MemberBean memberBean : memberBeans){
			String member_nick_name = "";
			try {
				member_nick_name = URLDecoder.decode(memberBean.getMember_nick_name(), "utf-8");
				memberBean.setMember_nick_name(member_nick_name);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pageBean.setObject(memberBeans);
	}
	@Override
	public Object getMemberChallengesByMember(MemberChallengeBean memberChallengeBean, PageBean pageBean) {
		
		List<MemberChallengeBean> memberChallengeBeans = collectionDao.getMemberChallengesByMember(memberChallengeBean, pageBean);
		for(MemberChallengeBean memberChallengeBean2 :memberChallengeBeans){
			if(!StringUtils.isNull(memberChallengeBean2.getMember_name())){
				String member_nick_name = "";
				try {
					member_nick_name = URLDecoder.decode(memberChallengeBean2.getMember_name(), "utf-8");
					memberChallengeBean2.setMember_name(member_nick_name);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return pageBean.setObject(memberChallengeBeans);
	}
	@Override
	public Object getMemberChallengesBySearch(MemberChallengeBean memberChallengeBean, PageBean pageBean) {
		
		List<MemberChallengeBean> memberChallengeBeans = collectionDao.getMemberChallengesBySearch(memberChallengeBean, pageBean);
		for(MemberChallengeBean memberChallengeBean2 :memberChallengeBeans){
			if(!StringUtils.isNull(memberChallengeBean2.getMember_name())){
				String member_nick_name = "";
				try {
					member_nick_name = URLDecoder.decode(memberChallengeBean2.getMember_name(), "utf-8");
					memberChallengeBean2.setMember_name(member_nick_name);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return pageBean.setObject(memberChallengeBeans);
	}
	
	@Override
	public Object getMemberChallengesIsWellByMember(MemberChallengeBean memberChallengeBean, PageBean pageBean) {
		
		List<MemberChallengeBean> memberChallengeBeans = collectionDao.getMemberChallengesIsWellByMember(memberChallengeBean, pageBean);
		for(MemberChallengeBean memberChallengeBean2 :memberChallengeBeans){
			if(!StringUtils.isNull(memberChallengeBean2.getMember_name())){
				String member_nick_name = "";
				try {
					member_nick_name = URLDecoder.decode(memberChallengeBean2.getMember_name(), "utf-8");
					memberChallengeBean2.setMember_name(member_nick_name);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return pageBean.setObject(memberChallengeBeans);
	}
	
	

	@Override
	public Object getFootprints(ChallengeFootprintBean challengeFootprintBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MemberChallengeBean> memberChallengeBeans=collectionDao.getFootprints(challengeFootprintBean, pageBean);
		for(MemberChallengeBean memberChallengeBean : memberChallengeBeans){
			if(!StringUtils.isNull(memberChallengeBean.getMember_name())){
				String member_nick_name = "";
				try {
					member_nick_name = URLDecoder.decode(memberChallengeBean.getMember_name(), "utf-8");
					memberChallengeBean.setMember_name(member_nick_name);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ProductBean productBean = productDao.getProductDetail(new ProductBean().setProduct_id(memberChallengeBean.getProduct_id()));
			if(productBean!=null){
				memberChallengeBean.setProductBean(productBean);
			}
		}
		return pageBean.setObject(memberChallengeBeans);
	}
	
	
	@Override
	public Object insertCollection(CollectionBean collectionBean) {
		// TODO Auto-generated method stub
		CollectionBean collectionBean2=collectionDao.getCollectionDetail(collectionBean);
		if(collectionBean2==null){
			int num=collectionDao.insertCollection(collectionBean);
			if(num<=0){
				throw new AppException("收藏失败!");
			}
			//商品收藏 给用户数量加1
			if("1".equals(collectionBean.getCollection_type())){
				MemberBean memberBean = memberDao.getMemberDetail(new MemberBean().setMember_id(Integer.valueOf(collectionBean.getMember_id())));
				if(memberBean!=null){
					int collection_num = memberBean.getCollection_num();
					collection_num = collection_num + 1;
					num = memberDao.updateMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id())
							.setCollection_num(collection_num));
					if(num<=0){
						throw new AppException("收藏失败!");
					}
				}
			}
			
		}else{
			int num=collectionDao.updateCollection(collectionBean2);
			if(num<=0){
				throw new AppException("收藏失败!");
			}
			//商品取消收藏 给用户收藏数量-1
			if("1".equals(collectionBean.getCollection_type())){
				MemberBean memberBean = memberDao.getMemberDetail(new MemberBean().setMember_id(Integer.valueOf(collectionBean.getMember_id())));
				if(memberBean!=null){
					int collection_num = memberBean.getCollection_num();
					collection_num = collection_num - 1;
					num = memberDao.updateMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id())
							.setCollection_num(collection_num));
					if(num<=0){
						throw new AppException("收藏失败!");
					}
				}
			}
		}
		return 1;
	}

	@Override
	public Object getMemberRewards(MemberRewardBean memberRewardBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		return pageBean.setObject(collectionDao.getMemberRewards(memberRewardBean, pageBean));
	}
}	
