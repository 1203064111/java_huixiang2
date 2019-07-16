package tst.project.interfaces;

import tst.project.bean.order.OrderAssessmentBean;
import tst.project.bean.order.OrderMerchantsBean;
import tst.project.bean.product.FootprintBean;
import tst.project.bean.product.ProductBean;
import tst.project.bean.product.ProductClassBean;
import tst.project.bean.product.ShopBean;
import tst.project.bean.product.ShopProductBean;
import tst.project.page.PageBean;
public interface IProductService {
	
	/**
	 * 自己店铺详情
	 * @author sjb
	 * @param shopBean
	 * @return
	 */
	public Object getMemberShopDetail(ShopBean shopBean);
	/**
	 * 添加店铺
	 * @author sjb
	 * @param shopBean
	 * @return
	 */
	public Object insertShop(ShopBean shopBean);
	
	/**
	 * 店铺详情
	 * @author sjb
	 * @param shopBean
	 * @return
	 */
	public Object getShopDetail(ShopBean shopBean);
	
	/**
	 * 平台产品数量
	 * @author sjb
	 * @param productBean
	 * @return
	 */
	public Object getProductCount(ProductBean productBean);
	
	/**
	 * 店铺可添加的产品列表
	 * @author sjb
	 * @return
	 */
	public Object getShopAddProducts(ShopProductBean shopProductBean,PageBean pageBean);
	
	/**
	 * 获得店铺的商品列表
	 * @author sjb
	 * @param shopProductBean
	 * @return
	 */
	public Object getShopProducts(ShopProductBean shopProductBean,PageBean pageBean);
	
	/**
	 * 店铺上架/下架商品
	 * @author sjb
	 * @param memberProductBean
	 * @return
	 */
	public Object insertShopProduct(ShopProductBean shopProductBean);
	
	/**
	 * 足迹列表
	 * @author sjb
	 * @param footprintBean
	 * @param pageBean
	 * @return
	 */
	public Object getFootprints(FootprintBean footprintBean,PageBean pageBean);
	
	/**
	 * 产品的评价列表
	 * @author sjb
	 * @param orderAssessmentBean
	 * @return
	 */
	public Object getProductAssessments(OrderAssessmentBean orderAssessmentBean,PageBean pageBean);
	
	/**
	 * 产品分类
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object getProductClasss(ProductClassBean productClassBean);
	/**
	 * 产品详情
	 * @author sjb
	 * @param productBean
	 * @return
	 */
    public Object getProductDetail(ProductBean productBean);
    /**
     * 产品列表（各种条件）
     * @author sjb
     * @param productBean
     * @param pageBean
     * @return
     */
    public Object getProducts(ProductBean productBean,PageBean pageBean);
    
    /**
     * 二期的商城 推荐top6
     * @author lx
     * @param productBean
     * @return
     */
    public Object getProductsByRecommand(ProductBean productBean);
    /**
     * 二期的商城 火热销量 top3
     * @author lx
     * @param productBean
     * @return
     */
    public Object getProductsByHot(ProductBean productBean);
    
    
    
    
    /**
     * 用户购买的商品列表
     * @author lx
     * @param orderMerchantsBean
     * @return
     */
    public Object getProductsByMemberOrder(OrderMerchantsBean orderMerchantsBean,PageBean pageBean);


}
