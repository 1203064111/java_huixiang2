package tst.project.controller;

import java.util.List;

import tst.project.bean.product.FreightBean;
import tst.project.bean.product.FreightCityBean;
import tst.project.bean.product.FreightFreeBean;
import tst.project.bean.product.GoodsBatchBean;
import tst.project.bean.product.GoodsBean;
import tst.project.bean.product.GoodsStockBean;
import tst.project.bean.product.ProductBean;
import tst.project.bean.product.ProductClassBean;
import tst.project.bean.product.ProductSpecificationBean;
import tst.project.bean.product.PurchaseBean;
import tst.project.bean.product.PurchaseGoodsBean;
import tst.project.bean.product.ServiceBean;
import tst.project.bean.product.SupplierBean;
import tst.project.bean.product.SupplierGoodsBean;
import tst.project.page.PageBean;

public interface IGoodsServiceC {
	/**
	 * 月销售额统计
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object getMonthStatistics(ProductClassBean productClassBean);
	/**
	 * 商品统计
	 * @author sjb
	 * @param productBean
	 * @param pageBean
	 * @return
	 */
	public Object getGoodsStatistics(GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 * 导出商品统计
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public Object exportGoodsStatistics(GoodsBean goodsBean);
	/**
	 * 产品分类统计
	 * @author sjb
	 * @param productBean
	 * @param pageBean
	 * @return
	 */
	public Object getProductClassStatistics(ProductClassBean productClassBean);
	/**
	 * 产品统计
	 * @author sjb
	 * @param productBean
	 * @param pageBean
	 * @return
	 */
	public Object getProductStatistics(ProductBean productBean,PageBean pageBean);
	
	/**
	 * 导出产品统计
	 * @author sjb
	 * @param productBean
	 * @param pageBean
	 * @return
	 */
	public Object exportProductStatistics(ProductBean productBean);
	/**
	 * 商品库存明细
	 * @author sjb
	 * @param goodsStockBean
	 * @param pageBean
	 * @return
	 */
	public Object getGoodsStocks(GoodsStockBean goodsStockBean,PageBean pageBean);
	
	/**
	 * 添加供应商商品
	 * @author sjb
	 * @param supplierGoodsBean
	 */
	public Object insertSupplierGoods(SupplierGoodsBean supplierGoodsBean);
	
	/**
	 * 修改供应商商品
	 * @author sjb
	 * @param supplierGoodsBean
	 */
	public Object updateSupplierGoods(SupplierGoodsBean supplierGoodsBean);
	
	/**
	 * 删除供应商商品
	 * @author sjb
	 * @param supplierGoodsBean
	 */
	public Object deleteSupplierGoodss(SupplierGoodsBean supplierGoodsBean);
	
	/**
	 * 供应商商品列表
	 * @author sjb
	 * @param supplierGoodsBean
	 */
	public Object getSupplierGoodss(SupplierGoodsBean supplierGoodsBean,PageBean pageBean);
	
	/**
	 * 供应商商品详情
	 * @author sjb
	 * @param supplierGoodsBean
	 */
	public Object getSupplierGoodsDetail(SupplierGoodsBean supplierGoodsBean);
	
	/**
	 * 产品列表
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object getProducts(ProductBean productBean,PageBean pageBean);
	
	
	/**
	 * 商城商品不分页
	 * @author lx
	 * @param productBean
	 * @return
	 */
	public Object getMallProductsNoPage(ProductBean productBean);
	/**
	 * 产品详情
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object getProductDetail(ProductBean productBean);
	/**
	 * 删除产品
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object deleteProduct(ProductBean productBean);
	/**
	 * 修改产品
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object updateProduct(ProductBean productBean,List<ProductSpecificationBean> productSpecificationBeans);
	/**
	 * 添加产品
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object insertProduct(ProductBean productBean,List<ProductSpecificationBean> productSpecificationBeans);
	
	
	
	/**
	 * 获得运费模板列表
	 * @author sjb
	 * @param brandBean
	 * @return
	 */
	public Object getFreights(FreightBean freightBean, PageBean pageBean);

	/**
	 * 获得运费模板列表
	 * @author sjb
	 * @param brandBean
	 * @return
	 */
	public Object getFreightsNoPage(FreightBean freightBean);

	/**
	 * 获得运费模板详情
	 * @author sjb
	 * @param brandBean
	 * @return
	 */
	public Object getFreightDetail(FreightBean freightBean);

	/**
	 * 添加运费模板
	 * @author sjb
	 * @param brandBean
	 * @return
	 */
	public int insertFreight(FreightBean freightBean, List<FreightCityBean> freightCityBeans,List<FreightFreeBean> freightFreeBeans);

	/**
	 * 修改运费模板
	 * @author sjb
	 * @param brandBean
	 * @return
	 */
	public int updateFreight(FreightBean freightBean, List<FreightCityBean> freightCityBeans,List<FreightFreeBean> freightFreeBeans);

	/**
	 * 删除运费模板
	 * @author sjb
	 * @param brandBean
	 * @return
	 */
	public int deleteFreight(FreightBean freightBean);
	
	
	/**
	 * 产品分类服务
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object getServices(ServiceBean serviceBean,PageBean pageBean);
	
	public Object getServicesNoPage(ServiceBean serviceBean);
	/**
	 * 产品分类服务
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object getServiceDetail(ServiceBean serviceBean);
	/**
	 * 删除产品服务
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object deleteService(ServiceBean serviceBean);
	/**
	 * 修改产品服务
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object updateService(ServiceBean serviceBean);
	/**
	 * 添加产品服务
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object insertService(ServiceBean serviceBean);
	
	
	
	/**
	 * 产品分类列表
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object getProductClasss(ProductClassBean productClassBean,PageBean pageBean);
	
	/**
	 * 产品分类多级联动
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object getProductClassLinks(ProductClassBean productClassBean);
	
	/**
	 * 产品分类详情
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object getProductClassDetail(ProductClassBean productClassBean);
	/**
	 * 删除产品分类
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object deleteProductClass(ProductClassBean productClassBean);
	/**
	 * 修改产品分类
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object updateProductClass(ProductClassBean productClassBean);
	/**
	 * 添加产品分类
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object insertProductClass(ProductClassBean productClassBean);
	
	
	/**
	 * 商品列表批次
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public Object getGoodsBatchs(GoodsBatchBean goodsBatchBean,PageBean pageBean);
	
	/**
	 * 商品详情批次
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public Object getGoodsBatchDetail(GoodsBatchBean goodsBatchBean);
	
	/**
	 * 删除商品批次
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public Object deleteGoodsBatch(GoodsBatchBean goodsBatchBean);
	
	
	/**
	 * 修改商品批次
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public Object updateGoodsBatch(GoodsBatchBean goodsBatchBean);
	
	/**
	 * 发布商品批次
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public Object insertGoodsBatch(GoodsBatchBean goodsBatchBean);
	
	
	/**
	 * 商品列表
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public Object getGoodss(GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 * 商品详情
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public Object getGoodsDetail(GoodsBean goodsBean);
	
	/**
	 * 删除商品
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public Object deleteGoods(GoodsBean goodsBean);
	
	
	/**
	 * 修改商品
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public Object updateGoods(GoodsBean goodsBean);
	
	/**
	 * 发布商品
	 * @author sjb
	 * @param goodsBean
	 * @return
	 */
	public Object insertGoods(GoodsBean goodsBean);
	
	
	
	/**
	 * 供应商列表
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object getSuppliers(SupplierBean supplierBean,PageBean pageBean);
	/**
	 * 供应商详情
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object getSupplierDetail(SupplierBean supplierBean);
	/**
	 * 删除供应商
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object deleteSupplier(SupplierBean supplierBean);
	/**
	 * 修改供应商
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object updateSupplier(SupplierBean supplierBean);
	/**
	 * 添加供应商
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object insertSupplier(SupplierBean supplierBean);
	
	
	
	
	/**
	 * 采购列表
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object getPurchases(PurchaseBean purchaseBean,PageBean pageBean);
	/**
	 * 采购详情
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object getPurchaseDetail(PurchaseBean purchaseBean);
	/**
	 * 删除采购
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object deletePurchase(PurchaseBean purchaseBean);
	/**
	 * 修改采购
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object updatePurchase(PurchaseBean purchaseBean,List<PurchaseGoodsBean> purchaseGoodsBeans);
	/**
	 * 添加采购
	 * @author sjb
	 * @param productClassBean
	 * @return
	 */
	public Object insertPurchase(PurchaseBean purchaseBean,List<PurchaseGoodsBean> purchaseGoodsBeans);
	
	/**
	 * 采购批次列表
	 * @author sjb
	 * @param purchaseBean
	 * @return
	 */
	public Object getPurchaseBatchs(PurchaseBean purchaseBean);
	
	/**
	 * 采购批次入库
	 * @author sjb
	 * @param goodsBatchBeans
	 * @return
	 */
	public Object insertPurchaseBatchs(PurchaseBean purchaseBean,List<GoodsBatchBean> goodsBatchBeans);
	
}
