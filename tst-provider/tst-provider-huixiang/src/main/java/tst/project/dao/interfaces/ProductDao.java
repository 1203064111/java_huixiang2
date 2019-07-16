package tst.project.dao.interfaces;
import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
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
import tst.project.page.PageBean;

/**
 * @author Miscanthus
 */
@Mapper
public interface ProductDao {
	/**
	 * 自己店铺详情
	 * @author sjb
	 * @param shopBean
	 * @return
	 */
	public ShopBean getMemberShopDetail(ShopBean shopBean);
	
	/**
	 * 添加店铺
	 * @author sjb
	 * @param shopBean
	 * @return
	 */
	public int insertShop(ShopBean shopBean);
	
	
	
	/**
	 * 店铺详情
	 * @author sjb
	 * @param shopBean
	 * @return
	 */
	public ShopBean getShopDetail(ShopBean shopBean);
	
	/**
	 * 平台产品数量
	 * @author sjb
	 * @param productBean
	 * @return
	 */
	public int getProductCount(ProductBean productBean);
	
	
	/**
	 * 店铺可添加的产品列表
	 * @author sjb
	 * @return
	 */
	public List<ProductBean> getShopAddProducts(ShopProductBean shopProductBean,PageBean pageBean);
	
	
	/**
	 * 获得店铺的商品列表
	 * @author sjb
	 * @param shopProductBean
	 * @return
	 */
	public List<ProductBean> getShopProducts(ShopProductBean shopProductBean,PageBean pageBean);
	
	/**
	 * 修改店铺产品
	 * @param shopProductBean
	 * @return
	 */
	public int updateShopProduct(ShopProductBean shopProductBean);
	
	/**
	 * 添加店铺产品
	 * @param shopProductBean
	 * @return
	 */
	public int insertShopProduct(ShopProductBean shopProductBean);
	/**
	 * 店铺产品详情
	 * @param shopProductBean
	 * @return
	 */
	public ShopProductBean getShopProductDetail(ShopProductBean shopProductBean);
	/**
	 * 足迹列表
	 * @author sjb
	 * @param footprintBean
	 * @param pageBean
	 * @return
	 */
	public List<ProductBean> getFootprints(FootprintBean footprintBean,PageBean pageBean);
	
	/**
	 * 添加用户浏览产品足迹
	 * @param footprintBean
	 * @return
	 */
	public int insertFootprint(FootprintBean footprintBean);
	
	/**
	 * 产品的评价列表
	 * @author sjb
	 * @param orderAssessmentBean
	 * @return
	 */
	public List<OrderAssessmentBean> getProductAssessments(OrderAssessmentBean orderAssessmentBean,PageBean pageBean);
	
	/**
	 * 产品分类
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public List<ProductClassBean> getProductClasss(ProductClassBean productClassBean);
	
	/**
	 * 产品规格列表
	 * @return
	 */
	public List<ProductSpecificationBean> getProductSpecifications(ProductSpecificationBean productSpecificationBean);

	/**
	 * 产品服务列表
	 * @param serviceBean
	 * @return
	 */
	public List<ServiceBean> getProductServices(ServiceBean serviceBean);
	
	 /**
     * 获取产品详情
     * @param productBean
     * @return
     */
    public ProductBean getProductDetail(ProductBean productBean);
    
    
    /**
     * 根据条件查询
     * @param productBean
     * @param searchCriteria
     * @return
     */
    public List<ProductBean> getProducts(ProductBean productBean,PageBean pageBean);
    
    /**
     * 二期商城 top3热销
     * @param productBean
     * @return
     */
    public List<ProductBean> getProductsByHot(ProductBean productBean);
    
    /**
     * 二期商城 top6推荐
     * @param productBean
     * @return
     */
    public List<ProductBean> getProductsByRecommand(ProductBean productBean);
    
    /**
     * 用户在二期购买的商品列表
     * @param orderMerchantsBean
     * @param pageBean
     * @return
     */
    public List<OrderProductBean> getProductsByMemberOrder(OrderMerchantsBean orderMerchantsBean,PageBean pageBean);
    
    /**
     * 产品的大类
     * @param productBean
     * @return
     */
    public Map<String, Object> getProductParentClass(ProductBean productBean);
    
    
}
