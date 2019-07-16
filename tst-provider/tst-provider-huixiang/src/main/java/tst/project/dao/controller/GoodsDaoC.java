package tst.project.dao.controller;

import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
import tst.project.bean.product.FreightBean;
import tst.project.bean.product.FreightCityBean;
import tst.project.bean.product.FreightFreeBean;
import tst.project.bean.product.GoodsBatchBean;
import tst.project.bean.product.GoodsBean;
import tst.project.bean.product.GoodsStockBean;
import tst.project.bean.product.ProductBean;
import tst.project.bean.product.ProductClassBean;
import tst.project.bean.product.ProductSpecificationBean;
import tst.project.bean.product.ProductSpecificationGoodsBean;
import tst.project.bean.product.PurchaseBean;
import tst.project.bean.product.PurchaseGoodsBean;
import tst.project.bean.product.ServiceBean;
import tst.project.bean.product.SupplierBean;
import tst.project.bean.product.SupplierGoodsBean;
import tst.project.page.PageBean;

@Mapper
public interface GoodsDaoC {
	/**
	 * 月销售额统计
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public List<Map<String, Object>> getMonthStatistics(ProductClassBean productClassBean);
	/**
	 * 商品统计
	 * @author sjb
	 * @param productBean
	 * @param pageBean
	 * @return
	 */
	public List<Map<String, Object>> getGoodsStatistics(GoodsBean goodsBean,PageBean pageBean);
	public List<Map<String, Object>> getGoodsStatistics(GoodsBean goodsBean);
	
	/**
	 * 产品分类统计
	 * @author sjb
	 * @param productBean
	 * @param pageBean
	 * @return
	 */
	public List<Map<String, Object>> getProductClassStatistics(ProductClassBean productClassBean);
	
	/**
	 * 产品统计
	 * @author sjb
	 * @param productBean
	 * @param pageBean
	 * @return
	 */
	public List<Map<String, Object>> getProductStatistics(ProductBean productBean,PageBean pageBean);
	public List<Map<String, Object>> getProductStatistics(ProductBean productBean);

	/**
	 * 商品库存明细
	 * @author sjb
	 * @param goodsStockBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsStockBean> getGoodsStocks(GoodsStockBean goodsStockBean,PageBean pageBean);
	/**
	 * 添加供应商商品
	 * @author sjb
	 * @param supplierGoodsBean
	 */
	public int insertSupplierGoods(SupplierGoodsBean supplierGoodsBean);
	
	/**
	 * 修改供应商商品
	 * @author sjb
	 * @param supplierGoodsBean
	 */
	public int updateSupplierGoods(SupplierGoodsBean supplierGoodsBean);
	
	/**
	 * 删除供应商商品
	 * @author sjb
	 * @param supplierGoodsBean
	 */
	public int deleteSupplierGoodss(SupplierGoodsBean supplierGoodsBean);
	
	/**
	 * 供应商商品列表
	 * @author sjb
	 * @param supplierGoodsBean
	 */
	public List<SupplierGoodsBean> getSupplierGoodss(SupplierGoodsBean supplierGoodsBean,PageBean pageBean);
	
	/**
	 * 供应商商品详情
	 * @author sjb
	 * @param supplierGoodsBean
	 */
	public SupplierGoodsBean getSupplierGoodsDetail(SupplierGoodsBean supplierGoodsBean);
	
    /**
     * 获取需要释放的产品商品列表
     *
     * @param productSpecificationGoodsBean
     * @return
     */
    public List<Map<String, Object>> getReleaseProductSpecificationGoodss(ProductSpecificationGoodsBean productSpecificationGoodsBean);

    /**
     * 产品规格商品的库存信息
     *
     * @param productSpecificationGoodsBean
     * @return
     */
    public Map<String, Object> getProductSpecificationGoodsStock(ProductSpecificationGoodsBean productSpecificationGoodsBean);


    /**
     * 产品规格商品列表
     *
     * @param productSpecificationGoodsBean
     * @return
     */
    public List<ProductSpecificationGoodsBean> getProductSpecificationGoodss(ProductSpecificationGoodsBean productSpecificationGoodsBean);


    /**
     * 添加产品规格商品
     *
     * @param productSpecificationGoodsBean
     * @return
     */
    public int insertProductSpecificationGoods(ProductSpecificationGoodsBean productSpecificationGoodsBean);

    /**
     * 修改产品规格商品
     *
     * @param productSpecificationGoodsBean
     * @return
     */
    public int updateProductSpecificationGoods(ProductSpecificationGoodsBean productSpecificationGoodsBean);

    /**
     * 删除产品规格商品
     *
     * @param productSpecificationGoodsBean
     * @return
     */
    public int deleteProductSpecificationGoodss(ProductSpecificationGoodsBean productSpecificationGoodsBean);


    /**
     * 产品规格列表
     *
     * @param productSpecificationBean
     * @return
     */
    public List<ProductSpecificationBean> getProductSpecifications(ProductSpecificationBean productSpecificationBean);

    /**
     * 根据规格id查找规格
     *
     * @param productSpecificationBean
     * @return ProductSpecificationBean
     */
    public ProductSpecificationBean getProductSpecificationsById(ProductSpecificationBean productSpecificationBean);

    /**
     * 删除产品规格
     *
     * @param productSpecificationBean
     * @return
     */
    public int deleteProductSpecifications(ProductSpecificationBean productSpecificationBean);

    /**
     * 添加产品规格
     *
     * @param productSpecificationBean
     * @return
     */
    public int insertProductSpecification(ProductSpecificationBean productSpecificationBean);

    /**
     * 修改产品规格
     *
     * @param productSpecificationBean
     * @return
     */
    public int updateProductSpecification(ProductSpecificationBean productSpecificationBean);


    /**
     * 产品列表
     *
     * @param productBean
     * @return
     * @author sjb
     */
    public List<ProductBean> getProducts(ProductBean productBean, PageBean pageBean);
    
    
    /**
     * 商城商品不分页
     * @param productBean
     * @return
     */
    public List<ProductBean> getMallProductsNoPage(ProductBean productBean);

    /**
     * 产品详情
     *
     * @param productBean
     * @return
     * @author sjb
     */
    public ProductBean getProductDetail(ProductBean productBean);

    /**
     * 删除产品
     *
     * @param productBean
     * @return
     * @author sjb
     */
    public int deleteProduct(ProductBean productBean);

    /**
     * 修改产品
     *
     * @param productBean
     * @return
     * @author sjb
     */
    public int updateProduct(ProductBean productBean);

    /**
     * 添加产品
     *
     * @param productBean
     * @return
     * @author sjb
     */
    public int insertProduct(ProductBean productBean);


    /**
     * 获得运费城市价格列表
     *
     * @param freightCityBean
     * @return
     */
    public List<FreightCityBean> getFreightCitys(FreightCityBean freightCityBean);

    /**
     * 添加运费城市价格
     *
     * @param freightCityBean
     * @return
     */
    public int insertFreightCity(FreightCityBean freightCityBean);

    /**
     * 修改运费城市价格
     *
     * @param freightCityBean
     * @return
     */
    public int updateFreightCity(FreightCityBean freightCityBean);

    /**
     * 删除运费城市价格
     *
     * @param freightCityBean
     * @return
     */
    public int deleteFreightCitys(FreightCityBean freightCityBean);

    /**
     * 添加运费城市的免邮条件
     *
     * @param freightFreeBean
     * @return
     */
    public int insertFreightFree(FreightFreeBean freightFreeBean);

    /**
     * 添加运费城市的免邮条件
     *
     * @param freightFreeBean
     * @return
     */
    public int updateFreightFree(FreightFreeBean freightFreeBean);

    /**
     * 添加运费城市的免邮条件
     *
     * @param freightFreeBean
     * @return
     */
    public int deleteFreightFrees(FreightFreeBean freightFreeBean);

    /**
     * 获得运费城市免邮列表
     *
     * @param freightFreeBean
     * @return
     */
    public List<FreightFreeBean> getFreightFrees(FreightFreeBean freightFreeBean);


    /**
     * 获得运费模板列表
     *
     * @param freightBean
     * @return
     */
    public List<FreightBean> getFreights(FreightBean freightBean, PageBean pageBean);

    /**
     * 获得运费模板列表
     *
     * @param freightBean
     * @return
     */
    public List<FreightBean> getFreightsNoPage(FreightBean freightBean);

    /**
     * 获得运费模板详情
     *
     * @param freightBean
     * @return
     */
    public FreightBean getFreightDetail(FreightBean freightBean);

    /**
     * 添加运费模板
     *
     * @param freightBean
     * @return
     */
    public int insertFreight(FreightBean freightBean);

    /**
     * 修改运费模板
     *
     * @param freightBean
     * @return
     */
    public int updateFreight(FreightBean freightBean);

    /**
     * 删除运费模板
     *
     * @param freightBean
     * @return
     */
    public int deleteFreight(FreightBean freightBean);


    /**
     * 产品分类服务
     *
     * @param serviceBean
     * @return
     * @author sjb
     */
    public List<ServiceBean> getServices(ServiceBean serviceBean, PageBean pageBean);

    public List<ServiceBean> getServices(ServiceBean serviceBean);

    /**
     * 产品分类服务
     *
     * @param serviceBean
     * @return
     * @author sjb
     */
    public ServiceBean getServiceDetail(ServiceBean serviceBean);

    /**
     * 删除产品服务
     *
     * @param serviceBean
     * @return
     * @author sjb
     */
    public int deleteService(ServiceBean serviceBean);

    /**
     * 修改产品服务
     *
     * @param serviceBean
     * @return
     * @author sjb
     */
    public int updateService(ServiceBean serviceBean);

    /**
     * 添加产品服务
     *
     * @param serviceBean
     * @return
     * @author sjb
     */
    public int insertService(ServiceBean serviceBean);


    /**
     * 产品分类列表
     *
     * @param productClassBean
     * @return
     * @author sjb
     */
    public List<ProductClassBean> getProductClasss(ProductClassBean productClassBean, PageBean pageBean);

    /**
     * 产品分类多级联动
     *
     * @param productClassBean
     * @return
     * @author sjb
     */
    public List<ProductClassBean> getProductClassLinks(ProductClassBean productClassBean);

    /**
     * 产品分类详情
     *
     * @param productClassBean
     * @return
     * @author sjb
     */
    public ProductClassBean getProductClassDetail(ProductClassBean productClassBean);

    /**
     * 删除产品分类
     *
     * @param productClassBean
     * @return
     * @author sjb
     */
    public int deleteProductClass(ProductClassBean productClassBean);

    /**
     * 修改产品分类
     *
     * @param productClassBean
     * @return
     * @author sjb
     */
    public int updateProductClass(ProductClassBean productClassBean);

    /**
     * 添加产品分类
     *
     * @param productClassBean
     * @return
     * @author sjb
     */
    public int insertProductClass(ProductClassBean productClassBean);


    /**
     * 添加商品库存变动明细
     *
     * @param goodsStockBean
     * @return
     */
    public int insertGoodsStock(GoodsStockBean goodsStockBean);

    /**
     * 商品列表批次
     *
     * @param goodsBatchBean
     * @return
     * @author sjb
     */
    public List<GoodsBatchBean> getGoodsBatchs(GoodsBatchBean goodsBatchBean, PageBean pageBean);

    /**
     * 商品详情批次
     *
     * @param goodsBatchBean
     * @return
     * @author sjb
     */
    public GoodsBatchBean getGoodsBatchDetail(GoodsBatchBean goodsBatchBean);

    /**
     * 删除商品批次
     *
     * @param goodsBatchBean
     * @return
     * @author sjb
     */
    public int deleteGoodsBatch(GoodsBatchBean goodsBatchBean);


    /**
     * 修改商品批次
     *
     * @param goodsBatchBean
     * @return
     * @author sjb
     */
    public int updateGoodsBatch(GoodsBatchBean goodsBatchBean);

    /**
     * 发布商品批次
     *
     * @param goodsBatchBean
     * @return
     * @author sjb
     */
    public int insertGoodsBatch(GoodsBatchBean goodsBatchBean);

    /**
     * 更新商品库存
     *
     * @param goodsBean
     * @return
     */
    public int updateGoodsStock(GoodsBean goodsBean);

    /**
     * 商品列表
     *
     * @param goodsBean
     * @return
     * @author sjb
     */
    public List<GoodsBean> getGoodss(GoodsBean goodsBean, PageBean pageBean);

    /**
     * 商品详情
     *
     * @param goodsBean
     * @return
     * @author sjb
     */
    public GoodsBean getGoodsDetail(GoodsBean goodsBean);

    /**
     * 删除商品
     *
     * @param goodsBean
     * @return
     * @author sjb
     */
    public int deleteGoods(GoodsBean goodsBean);


    /**
     * 修改商品
     *
     * @param goodsBean
     * @return
     * @author sjb
     */
    public int updateGoods(GoodsBean goodsBean);

    /**
     * 发布商品
     *
     * @param goodsBean
     * @return
     * @author sjb
     */
    public int insertGoods(GoodsBean goodsBean);


    /**
     * 供应商列表
     *
     * @param supplierBean
     * @return
     * @author sjb
     */
    public List<SupplierBean> getSuppliers(SupplierBean supplierBean, PageBean pageBean);

    /**
     * 供应商详情
     *
     * @param supplierBean
     * @return
     * @author sjb
     */
    public SupplierBean getSupplierDetail(SupplierBean supplierBean);

    /**
     * 删除供应商
     *
     * @param supplierBean
     * @return
     * @author sjb
     */
    public int deleteSupplier(SupplierBean supplierBean);

    /**
     * 修改供应商
     *
     * @param supplierBean
     * @return
     * @author sjb
     */
    public int updateSupplier(SupplierBean supplierBean);

    /**
     * 添加供应商
     *
     * @param supplierBean
     * @return
     * @author sjb
     */
    public int insertSupplier(SupplierBean supplierBean);


    /**
     * 采购列表
     *
     * @param purchaseBean
     * @return
     * @author sjb
     */
    public List<PurchaseBean> getPurchases(PurchaseBean purchaseBean, PageBean pageBean);

    /**
     * 采购详情
     *
     * @param purchaseBean
     * @return
     * @author sjb
     */
    public PurchaseBean getPurchaseDetail(PurchaseBean purchaseBean);

    /**
     * 删除采购
     *
     * @param purchaseBean
     * @return
     * @author sjb
     */
    public int deletePurchase(PurchaseBean purchaseBean);

    /**
     * 修改采购
     *
     * @param purchaseBean
     * @return
     * @author sjb
     */
    public int updatePurchase(PurchaseBean purchaseBean);

    /**
     * 添加采购
     *
     * @param purchaseBean
     * @return
     * @author sjb
     */
    public int insertPurchase(PurchaseBean purchaseBean);
    
    /**
     * 添加采购商品
     * @param purchaseGoodsBean
     * @return
     */
    public int insertPurchaseGoods(PurchaseGoodsBean purchaseGoodsBean);
    
    /**
     * 修改采购商品
     * @param purchaseGoodsBean
     * @return
     */
    public int updatePurchaseGoods(PurchaseGoodsBean purchaseGoodsBean);
    
    /**
     * 删除采购商品
     * @param purchaseGoodsBean
     * @return
     */
    public int deletePurchaseGoodss(PurchaseGoodsBean purchaseGoodsBean);
    
    /**
     * 获得采购商品列表
     * @param purchaseGoodsBean
     * @return
     */
    public List<PurchaseGoodsBean> getPurchaseGoodss(PurchaseGoodsBean purchaseGoodsBean);

    /**
     * 判断备案有没有重复
     * @param goodsBean
     * @return
     */
    public List<GoodsBean> selectGoodsByRecord(GoodsBean goodsBean);
    
    /**
	 * 采购批次列表
	 * @author sjb
	 * @param purchaseBean
	 * @return
	 */
	public List<GoodsBatchBean> getPurchaseBatchs(PurchaseBean purchaseBean);
	
	
}
