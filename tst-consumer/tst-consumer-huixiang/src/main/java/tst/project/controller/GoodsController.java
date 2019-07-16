package tst.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppController;
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

@Controller
@RequestMapping("/goodsController/v1.0")
public class GoodsController {
	@Autowired
	IGoodsServiceC goodsServiceC;
	
	@RequestMapping("getMonthStatistics")
	@AppController(isVerSystemToken = true)
	public Object getMonthStatistics(ProductClassBean productClassBean) throws Exception {
		return goodsServiceC.getMonthStatistics(productClassBean);
	}
	
	
	@RequestMapping("/getGoodsStatistics")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getGoodsStatistics(GoodsBean goodsBean,PageBean pageBean) throws Exception {
		return goodsServiceC.getGoodsStatistics(goodsBean,pageBean);
	}
	
	@RequestMapping("/exportGoodsStatistics")
	@AppController(isVerSystemToken = true)
	public Object exportGoodsStatistics(GoodsBean goodsBean) throws Exception {
		return goodsServiceC.exportGoodsStatistics(goodsBean);
	}
	
	
	@RequestMapping("/getProductClassStatistics")
	@AppController(isVerSystemToken = true)
	public Object getProductClassStatistics(ProductClassBean productClassBean) throws Exception {
		return goodsServiceC.getProductClassStatistics(productClassBean);
	}
	
	
	@RequestMapping("/getProductStatistics")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getProductStatistics(ProductBean productBean,PageBean pageBean) throws Exception {
		return goodsServiceC.getProductStatistics(productBean,pageBean);
	}
	
	@RequestMapping("/exportProductStatistics")
	@AppController(isVerSystemToken = true)
	public Object exportProductStatistics(ProductBean productBean) throws Exception {
		return goodsServiceC.exportProductStatistics(productBean);
	}
	
	
	@RequestMapping("/getGoodsStocks")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getGoodsStocks(GoodsStockBean goodsStockBean,PageBean pageBean) throws Exception {
		return goodsServiceC.getGoodsStocks(goodsStockBean,pageBean);
	}
	
	@RequestMapping("/getSupplierGoodss")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getSupplierGoodss(SupplierGoodsBean supplierGoodsBean,PageBean pageBean) throws Exception {
		return goodsServiceC.getSupplierGoodss(supplierGoodsBean,pageBean);
	}

	@RequestMapping("/getSupplierGoodsDetail")
	@AppController(isVerSystemToken = true)
	public Object getSupplierGoodsDetail(SupplierGoodsBean supplierGoodsBean) throws Exception {
		return goodsServiceC.getSupplierGoodsDetail(supplierGoodsBean);
	}

	@RequestMapping("/deleteSupplierGoodss")
	@AppController(isVerSystemToken = true)
	public Object deleteSupplierGoodss(SupplierGoodsBean supplierGoodsBean) throws Exception {
		return goodsServiceC.deleteSupplierGoodss(supplierGoodsBean);
	}

	@RequestMapping("/updateSupplierGoods")
	@AppController(isVerSystemToken = true)
	public Object updateSupplierGoods(SupplierGoodsBean supplierGoodsBean) throws Exception {
		return goodsServiceC.updateSupplierGoods(supplierGoodsBean);
	}

	@RequestMapping("/insertSupplierGoods")
	@AppController(isVerSystemToken = true)
	public Object insertSupplierGoods(SupplierGoodsBean supplierGoodsBean) throws Exception {
		return goodsServiceC.insertSupplierGoods(supplierGoodsBean);
	}
	
	
	
	
	@RequestMapping("/getProducts")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getProducts(ProductBean productBean,PageBean pageBean) throws Exception {
		return goodsServiceC.getProducts(productBean,pageBean);
	}
	@RequestMapping("/getMallProductsNoPage")
	@AppController(isVerSystemToken = true)
	public Object getMallProductsNoPage(ProductBean productBean) throws Exception {
		return goodsServiceC.getMallProductsNoPage(productBean);
	}

	@RequestMapping("/getProductDetail")
	@AppController(isVerSystemToken = true)
	public Object getProductDetail(ProductBean productBean) throws Exception {
		return goodsServiceC.getProductDetail(productBean);
	}

	@RequestMapping("/deleteProduct")
	@AppController(isVerSystemToken = true)
	public Object deleteProduct(ProductBean productBean) throws Exception {
		return goodsServiceC.deleteProduct(productBean);
	}

	@RequestMapping("/updateProduct")
	@AppController(isVerSystemToken = true)
	public Object updateProduct(ProductBean productBean,String specifications) throws Exception {
		return goodsServiceC.updateProduct(productBean,JSON.parseArray(specifications,ProductSpecificationBean.class));
	}

	@RequestMapping("/insertProduct")
	@AppController(isVerSystemToken = true)
	public Object insertProduct(ProductBean productBean,String specifications) throws Exception {
		return goodsServiceC.insertProduct(productBean,JSON.parseArray(specifications,ProductSpecificationBean.class));
	}
	
	
	@RequestMapping("/getFreights") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getFreights(FreightBean freightBean,PageBean pageBean) throws Exception{ 
		return goodsServiceC.getFreights(freightBean,pageBean);
	}

	@RequestMapping("/getFreightsNoPage") 
    @AppController(isVerSystemToken=true)
    public Object getFreightsNoPage(FreightBean freightBean) throws Exception{ 
		return goodsServiceC.getFreightsNoPage(freightBean);
	}
	
	@RequestMapping("/getFreightDetail") 
    @AppController(isVerSystemToken=true)
    public Object getFreightDetail(FreightBean freightBean) throws Exception{ 
		return goodsServiceC.getFreightDetail(freightBean);
	}
	
	
	@RequestMapping("/insertFreight") 
    @AppController(isVerSystemToken=true)
    public Object insertFreight(FreightBean freightBean,String freight_citys,String freight_frees) throws Exception{ 

		return goodsServiceC.insertFreight(freightBean,
							JSON.parseArray(freight_citys, FreightCityBean.class),
							JSON.parseArray(freight_frees, FreightFreeBean.class));
	}
	
	
	@RequestMapping("/updateFreight") 
    @AppController(isVerSystemToken=true)
    public Object updateFreight(FreightBean freightBean,String freight_citys,String freight_frees) throws Exception{ 
		return goodsServiceC.updateFreight(freightBean,
								JSON.parseArray(freight_citys, FreightCityBean.class),
								JSON.parseArray(freight_frees, FreightFreeBean.class));
	}
	
	
	@RequestMapping("/deleteFreight") 
    @AppController(isVerSystemToken=true)
    public Object deleteFreight(FreightBean freightBean) throws Exception{ 
		return goodsServiceC.deleteFreight(freightBean);
	}
	
	
	
	@RequestMapping("/getServices")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getServices(ServiceBean serviceBean,PageBean pageBean) throws Exception {
		return goodsServiceC.getServices(serviceBean,pageBean);
	}
	
	@RequestMapping("/getServicesNoPage")
	@AppController(isVerSystemToken = true)
	public Object getServicesNoPage(ServiceBean serviceBean) throws Exception {
		return goodsServiceC.getServicesNoPage(serviceBean);
	}

	@RequestMapping("/getServiceDetail")
	@AppController(isVerSystemToken = true)
	public Object getServiceDetail(ServiceBean serviceBean) throws Exception {
		return goodsServiceC.getServiceDetail(serviceBean);
	}

	@RequestMapping("/deleteService")
	@AppController(isVerSystemToken = true)
	public Object deleteService(ServiceBean serviceBean) throws Exception {
		return goodsServiceC.deleteService(serviceBean);
	}

	@RequestMapping("/updateService")
	@AppController(isVerSystemToken = true)
	public Object updateService(ServiceBean serviceBean) throws Exception {
		return goodsServiceC.updateService(serviceBean);
	}

	@RequestMapping("/insertService")
	@AppController(isVerSystemToken = true)
	public Object insertService(ServiceBean serviceBean) throws Exception {
		return goodsServiceC.insertService(serviceBean);
	}
	
	
	@RequestMapping("/getProductClasss")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getProductClasss(ProductClassBean productClassBean,PageBean pageBean) throws Exception {
		return goodsServiceC.getProductClasss(productClassBean,pageBean);
	}
	
	@RequestMapping("/getProductClassLinks")
	@AppController(isVerSystemToken = true)
	public Object getProductClassLinks(ProductClassBean productClassBean) throws Exception {
		return goodsServiceC.getProductClassLinks(productClassBean);
	}

	@RequestMapping("/getProductClassDetail")
	@AppController(isVerSystemToken = true)
	public Object getProductClassDetail(ProductClassBean productClassBean) throws Exception {
		return goodsServiceC.getProductClassDetail(productClassBean);
	}

	@RequestMapping("/deleteProductClass")
	@AppController(isVerSystemToken = true)
	public Object deleteProductClass(ProductClassBean productClassBean) throws Exception {
		return goodsServiceC.deleteProductClass(productClassBean);
	}

	@RequestMapping("/updateProductClass")
	@AppController(isVerSystemToken = true)
	public Object updateProductClass(ProductClassBean productClassBean) throws Exception {
		return goodsServiceC.updateProductClass(productClassBean);
	}

	@RequestMapping("/insertProductClass")
	@AppController(isVerSystemToken = true)
	public Object insertProductClass(ProductClassBean productClassBean) throws Exception {
		return goodsServiceC.insertProductClass(productClassBean);
	}
	
	
	@RequestMapping("/getGoodsBatchs")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getGoodsBatchs(GoodsBatchBean goodsBatchBean,PageBean pageBean) throws Exception {
		return goodsServiceC.getGoodsBatchs(goodsBatchBean,pageBean);
	}

	@RequestMapping("/getGoodsBatchDetail")
	@AppController(isVerSystemToken = true)
	public Object getGoodsBatchDetail(GoodsBatchBean goodsBatchBean) throws Exception {
		return goodsServiceC.getGoodsBatchDetail(goodsBatchBean);
	}

	@RequestMapping("/deleteGoodsBatch")
	@AppController(isVerSystemToken = true)
	public Object deleteGoodsBatch(GoodsBatchBean goodsBatchBean) throws Exception {
		return goodsServiceC.deleteGoodsBatch(goodsBatchBean);
	}

	@RequestMapping("/updateGoodsBatch")
	@AppController(isVerSystemToken = true)
	public Object updateGoodsBatch(GoodsBatchBean goodsBatchBean) throws Exception {
		return goodsServiceC.updateGoodsBatch(goodsBatchBean);
	}

	@RequestMapping("/insertGoodsBatch")
	@AppController(isVerSystemToken = true)
	public Object insertGoodsBatch(GoodsBatchBean goodsBatchBean) throws Exception {
		return goodsServiceC.insertGoodsBatch(goodsBatchBean);
	}
	
	
	@RequestMapping("/getGoodss")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getGoodss(GoodsBean goodsBean,PageBean pageBean) throws Exception {
		return goodsServiceC.getGoodss(goodsBean,pageBean);
	}

	@RequestMapping("/getGoodsDetail")
	@AppController(isVerSystemToken = true)
	public Object getGoodsDetail(GoodsBean goodsBean) throws Exception {
		return goodsServiceC.getGoodsDetail(goodsBean);
	}

	@RequestMapping("/deleteGoods")
	@AppController(isVerSystemToken = true)
	public Object deleteGoods(GoodsBean goodsBean) throws Exception {
		return goodsServiceC.deleteGoods(goodsBean);
	}

	@RequestMapping("/updateGoods")
	@AppController(isVerSystemToken = true)
	public Object updateGoods(GoodsBean goodsBean) throws Exception {
		return goodsServiceC.updateGoods(goodsBean);
	}

	@RequestMapping("/insertGoods")
	@AppController(isVerSystemToken = true)
	public Object insertGoods(GoodsBean goodsBean) throws Exception {
		return goodsServiceC.insertGoods(goodsBean);
	}

	
	@RequestMapping("/getSuppliers")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getSuppliers(SupplierBean supplierBean,PageBean pageBean) throws Exception {
		return goodsServiceC.getSuppliers(supplierBean,pageBean);
	}

	@RequestMapping("/getSupplierDetail")
	@AppController(isVerSystemToken = true)
	public Object getSupplierDetail(SupplierBean supplierBean) throws Exception {
		return goodsServiceC.getSupplierDetail(supplierBean);
	}

	@RequestMapping("/deleteSupplier")
	@AppController(isVerSystemToken = true)
	public Object deleteSupplier(SupplierBean supplierBean) throws Exception {
		return goodsServiceC.deleteSupplier(supplierBean);
	}

	@RequestMapping("/updateSupplier")
	@AppController(isVerSystemToken = true)
	public Object updateSupplier(SupplierBean supplierBean) throws Exception {
		return goodsServiceC.updateSupplier(supplierBean);
	}

	@RequestMapping("/insertSupplier")
	@AppController(isVerSystemToken = true)
	public Object insertSupplier(SupplierBean supplierBean) throws Exception {
		return goodsServiceC.insertSupplier(supplierBean);
	}
	
	
	
	@RequestMapping("/getPurchases")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getPurchases(PurchaseBean purchaseBean,PageBean pageBean) throws Exception {
		return goodsServiceC.getPurchases(purchaseBean,pageBean);
	}

	@RequestMapping("/getPurchaseDetail")
	@AppController(isVerSystemToken = true)
	public Object getPurchaseDetail(PurchaseBean purchaseBean) throws Exception {
		return goodsServiceC.getPurchaseDetail(purchaseBean);
	}

	@RequestMapping("/deletePurchase")
	@AppController(isVerSystemToken = true)
	public Object deletePurchase(PurchaseBean purchaseBean) throws Exception {
		return goodsServiceC.deletePurchase(purchaseBean);
	}

	@RequestMapping("/updatePurchase")
	@AppController(isVerSystemToken = true)
	public Object updatePurchase(PurchaseBean purchaseBean,String purchase_goodss) throws Exception {
		return goodsServiceC.updatePurchase(purchaseBean,JSON.parseArray(purchase_goodss,PurchaseGoodsBean.class));
	}

	@RequestMapping("/insertPurchase")
	@AppController(isVerSystemToken = true)
	public Object insertPurchase(PurchaseBean purchaseBean,String purchase_goodss) throws Exception {
		return goodsServiceC.insertPurchase(purchaseBean,JSON.parseArray(purchase_goodss,PurchaseGoodsBean.class));
	}
	
	@RequestMapping("/getPurchaseBatchs")
	@AppController(isVerSystemToken = true)
	public Object getPurchaseBatchs(PurchaseBean purchaseBean) throws Exception {
		return goodsServiceC.getPurchaseBatchs(purchaseBean);
	}
	
	@RequestMapping("/insertPurchaseBatchs")
	@AppController(isVerSystemToken = true)
	public Object insertPurchaseBatchs(PurchaseBean purchaseBean,String purchase_batchs) throws Exception {
		return goodsServiceC.insertPurchaseBatchs(purchaseBean,JSON.parseArray(purchase_batchs,GoodsBatchBean.class));
	}
}
