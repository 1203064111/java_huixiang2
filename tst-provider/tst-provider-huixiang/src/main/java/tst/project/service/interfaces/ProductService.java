package tst.project.service.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.aspect.AppException;
import tst.project.bean.member.MemberBean;
import tst.project.bean.order.OrderAssessmentBean;
import tst.project.bean.order.OrderMerchantsBean;
import tst.project.bean.order.OrderProductBean;
import tst.project.bean.product.FootprintBean;
import tst.project.bean.product.ProductBean;
import tst.project.bean.product.ProductClassBean;
import tst.project.bean.product.ProductSpecificationBean;
import tst.project.bean.product.ServiceBean;
import tst.project.bean.product.ShopBean;
import tst.project.bean.product.ShopProductBean;
import tst.project.dao.interfaces.MemberDao;
import tst.project.dao.interfaces.ProductDao;
import tst.project.interfaces.IProductService;
import tst.project.page.PageBean;
import tst.project.utils.NumberUtils;
import tst.project.utils.StringUtils;


@Service
@Transactional(rollbackFor = Exception.class)
public class ProductService implements IProductService {

    @Autowired
    ProductDao productDao;
    
    @Autowired
    MemberDao memberDao;
    
    @Override
    public Object getMemberShopDetail(ShopBean shopBean) {
    	// TODO Auto-generated method stub
    	return productDao.getMemberShopDetail(shopBean);
    }
    
    @Override
    public Object insertShop(ShopBean shopBean) {
    	// TODO Auto-generated method stub
    	ShopBean shopBean2=productDao.getMemberShopDetail(shopBean);
    	if(shopBean2!=null){
    		throw new AppException("已申请过");
    	}
    	int num=productDao.insertShop(shopBean);
		if(num<=0){
			throw new AppException("添加失败!");
		}
		return num;
    }
    
    @Override
    public Object getShopDetail(ShopBean shopBean) {
    	// TODO Auto-generated method stub
    	return productDao.getShopDetail(shopBean);
    }
    
    @Override
    public Object getProductCount(ProductBean productBean) {
    	// TODO Auto-generated method stub
    	return productDao.getProductCount(productBean);
    }
    
    @Override
    public Object getShopAddProducts(ShopProductBean shopProductBean, PageBean pageBean) {
    	// TODO Auto-generated method stub
    	MemberBean memberBean=memberDao.getMemberDetail(new MemberBean()
    			.setMember_id(NumberUtils.Integer(shopProductBean.getMember_id())));
    	if(!"2".equals(memberBean.getMember_type())){
    		throw new AppException("您还未成为商家!");
    	}
    	
    	List<ProductBean> productBeans=productDao.getShopAddProducts(shopProductBean.setShop_id(memberBean.getShop_id()), pageBean);
    	
    	return pageBean.setObject(productBeans);
    }
    
    @Override
    public Object getShopProducts(ShopProductBean shopProductBean, PageBean pageBean) {
    	// TODO Auto-generated method stub
    	
    	List<ProductBean> productBeans=productDao
    			.getShopProducts(shopProductBean, pageBean);
    	return pageBean.setObject(productBeans);
    }
    

    @Override
    public Object insertShopProduct(ShopProductBean shopProductBean) {
    	// TODO Auto-generated method stub
    	MemberBean memberBean=memberDao.getMemberDetail(new MemberBean()
    			.setMember_id(NumberUtils.Integer(shopProductBean.getMember_id())));
    	if(!"2".equals(memberBean.getMember_type())){
    		throw new AppException("您还未成为商家!");
    	}
    	
    	int num=0;
    	ShopProductBean shopProductBean2=productDao.getShopProductDetail(shopProductBean.setShop_id(memberBean.getShop_id()));
		if(shopProductBean2==null){
			num=productDao.insertShopProduct(shopProductBean);
			if(num<=0){
				throw new AppException("添加失败!");
			}
		}else{
			num=productDao.updateShopProduct(shopProductBean2);
			if(num<=0){
				throw new AppException("添加失败!");
			}
		}
		
    	return num;
    }
    
    @Override
    public Object getFootprints(FootprintBean footprintBean, PageBean pageBean) {
    	// TODO Auto-generated method stub
    	List<ProductBean> productBeans=productDao.getFootprints(footprintBean, pageBean);
    	return pageBean.setObject(productBeans);
    }
    
    @Override
    public Object getProductAssessments(OrderAssessmentBean orderAssessmentBean, PageBean pageBean) {
    	// TODO Auto-generated method stub
    	List<OrderAssessmentBean> orderAssessmentBeans=productDao.getProductAssessments(orderAssessmentBean, pageBean);
    	
    	return pageBean.setObject(orderAssessmentBeans);
    }
    
    @Override
    public Object getProductClasss(ProductClassBean productClassBean) {
    	// TODO Auto-generated method stub
    	return productDao.getProductClasss(productClassBean);
    }
    
    @Override
    public Object getProductDetail(ProductBean productBean) {
    	ProductBean productBean2=productDao.getProductDetail(productBean);
    	if(productBean2!=null){
    		productDao.insertFootprint(new FootprintBean()
    				.setMember_id(productBean.getMember_id())
    				.setProduct_id(productBean2.getProduct_id()+""));
    		
    		List<ServiceBean> serviceBeans=productDao.getProductServices(new ServiceBean()
    				.setService_ids(productBean2.getService_ids()));
    		productBean2.setServiceBeans(serviceBeans);
    		
    		List<ProductSpecificationBean> productSpecificationBeans=productDao
    				.getProductSpecifications(new ProductSpecificationBean().setProduct_id(productBean2.getProduct_id()+""));
    		productBean2.setProductSpecificationBeans(productSpecificationBeans);
    		
    		if(!StringUtils.isNull(productBean2.getClass_id())){
    			Map<String, Object> map = productDao.getProductParentClass(new ProductBean().setClass_id(productBean2.getClass_id()));
    			if(map!=null){
    				productBean2.setClass_parent_id(map.get("parent_id").toString());
    			}
    		}
    	}
        return productBean2;
    }

    @Override
    public Object getProducts(ProductBean productBean,PageBean pageBean) {
    	List<ProductBean> productBeans=productDao.getProducts(productBean,pageBean);
        return pageBean.setObject(productBeans);
    }
    @Override
    public Object getProductsByHot(ProductBean productBean) {
        return productDao.getProductsByHot(productBean);
    }
    @Override
    public Object getProductsByRecommand(ProductBean productBean) {
        return productDao.getProductsByRecommand(productBean);
    }
    
    @Override
    public Object getProductsByMemberOrder(OrderMerchantsBean orderMerchantsBean,PageBean pageBean) {
    	List<OrderProductBean> orderProductBeans=productDao.getProductsByMemberOrder(orderMerchantsBean,pageBean);
        return pageBean.setObject(orderProductBeans);
    }

	

	
    

}
