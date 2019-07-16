package tst.project.service.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.aspect.AppException;
import tst.project.bean.excel.ExcelBean;
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
import tst.project.controller.IGoodsServiceC;
import tst.project.dao.controller.GoodsDaoC;
import tst.project.page.PageBean;
import tst.project.utils.ExcelUtils;
import tst.project.utils.NumberUtils;
import tst.project.utils.TimeUtils;

@Service
@Transactional(rollbackFor = AppException.class)
public class GoodsServiceC implements IGoodsServiceC {

	@Autowired
	GoodsDaoC goodsDaoC;

	@Value("${img_path}")
	private String img_path;
	
	@Value("${img_url}")
	private String img_url;
	
	@Override
	public Object getMonthStatistics(ProductClassBean productClassBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getMonthStatistics(productClassBean);
	}
	
	@Override
	public Object getGoodsStatistics(GoodsBean goodsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> maps= goodsDaoC.getGoodsStatistics(goodsBean,pageBean);
		return pageBean.setObject(maps);
	}
	
	@Override
	public Object exportGoodsStatistics(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> maps= goodsDaoC.getGoodsStatistics(goodsBean);
		
		List<ExcelBean> excelBeans = new ArrayList<ExcelBean>();
		excelBeans.add(new ExcelBean().setName("商品名称").setType("goods_name"));
		excelBeans.add(new ExcelBean().setName("商品类型").setType("goods_type"));
		excelBeans.add(new ExcelBean().setName("销售量").setType("goods_num"));
		excelBeans.add(new ExcelBean().setName("总销售额").setType("sales_price"));
		
		excelBeans.add(new ExcelBean().setName("总成本价").setType("toatl_price"));
		excelBeans.add(new ExcelBean().setName("总运费").setType("logistics_price"));
		excelBeans.add(new ExcelBean().setName("总税费").setType("taxation_price"));
		
		
		String fileName = "商品统计"+TimeUtils.getCurrentTime("yyyyMMddHHmmss") + ".xls";
		boolean is_success = ExcelUtils.exportExcelMap(img_path+"/excel/"+fileName, excelBeans, maps);
		if(!is_success){
			throw new AppException("导出失败!");
		}
		
		return img_url+"/excel/"+fileName;
	}
	
	@Override
	public Object getProductClassStatistics(ProductClassBean productClassBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getProductClassStatistics(productClassBean);
	}
	
	@Override
	public Object getProductStatistics(ProductBean productBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> maps= goodsDaoC.getProductStatistics(productBean,pageBean);
		return pageBean.setObject(maps);
	}
	
	@Override
	public Object exportProductStatistics(ProductBean productBean) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> maps= goodsDaoC.getProductStatistics(productBean);
		
		List<ExcelBean> excelBeans = new ArrayList<ExcelBean>();
		excelBeans.add(new ExcelBean().setName("产品名称").setType("product_name"));
		excelBeans.add(new ExcelBean().setName("产品类型").setType("product_type"));
		excelBeans.add(new ExcelBean().setName("浏览量").setType("browser_count"));
		excelBeans.add(new ExcelBean().setName("销售量").setType("product_count"));
		
		excelBeans.add(new ExcelBean().setName("销售额(已结算)").setType("order_actual_price"));
		excelBeans.add(new ExcelBean().setName("总销售额").setType("order_total_price"));
		excelBeans.add(new ExcelBean().setName("总成本价").setType("batch_price"));
		
		excelBeans.add(new ExcelBean().setName("销售分成").setType("profit_price"));
		
		String fileName = "产品统计"+TimeUtils.getCurrentTime("yyyyMMddHHmmss") + ".xls";
		boolean is_success = ExcelUtils.exportExcelMap(img_path+"/excel/"+fileName, excelBeans, maps);
		if(!is_success){
			throw new AppException("导出失败!");
		}
		
		return img_url+"/excel/"+fileName;
	}
	
	@Override
	public Object getGoodsStocks(GoodsStockBean goodsStockBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<GoodsStockBean> goodsStockBeans=goodsDaoC.getGoodsStocks(goodsStockBean, pageBean);
		return pageBean.setObject(goodsStockBeans);
	}
	
	@Override
	public Object insertSupplierGoods(SupplierGoodsBean supplierGoodsBean) {
		// TODO Auto-generated method stub
		SupplierGoodsBean supplierGoodsBean2 = goodsDaoC.getSupplierGoodsDetail(supplierGoodsBean);
		if (supplierGoodsBean2 != null) {
			throw new AppException("已添加过此商品!");
		}
		int num = goodsDaoC.insertSupplierGoods(supplierGoodsBean);
		if (num <= 0) {
			throw new AppException("添加失败!");
		}
		return num;
	}

	@Override
	public Object updateSupplierGoods(SupplierGoodsBean supplierGoodsBean) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.updateSupplierGoods(supplierGoodsBean);
		if (num <= 0) {
			throw new AppException("修改失败!");
		}
		return num;
	}

	@Override
	public Object deleteSupplierGoodss(SupplierGoodsBean supplierGoodsBean) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.deleteSupplierGoodss(supplierGoodsBean);
		if (num <= 0) {
			throw new AppException("删除失败!");
		}
		return num;
	}

	@Override
	public Object getSupplierGoodsDetail(SupplierGoodsBean supplierGoodsBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getSupplierGoodsDetail(supplierGoodsBean);
	}

	@Override
	public Object getSupplierGoodss(SupplierGoodsBean supplierGoodsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<SupplierGoodsBean> supplierGoodsBeans = goodsDaoC.getSupplierGoodss(supplierGoodsBean, pageBean);
		return pageBean.setObject(supplierGoodsBeans);
	}

	@Override
	public Object getProducts(ProductBean productBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<ProductBean> productBeans = goodsDaoC.getProducts(productBean, pageBean);
		return pageBean.setObject(productBeans);
	}
	@Override
	public Object getMallProductsNoPage(ProductBean productBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getMallProductsNoPage(productBean);
	}
	

	@Override
	public Object getProductDetail(ProductBean productBean) {
		// TODO Auto-generated method stub
		ProductBean productBean2 = goodsDaoC.getProductDetail(productBean);
		if (productBean2 != null) {
			List<ProductSpecificationBean> productSpecificationBeans = goodsDaoC.getProductSpecifications(
					new ProductSpecificationBean().setProduct_id(productBean2.getProduct_id() + ""));
			if (productSpecificationBeans != null) {
				for (int i = 0; i < productSpecificationBeans.size(); i++) {
					ProductSpecificationBean productSpecificationBean = productSpecificationBeans.get(i);
					List<ProductSpecificationGoodsBean> productSpecificationGoodsBeans = goodsDaoC
							.getProductSpecificationGoodss(new ProductSpecificationGoodsBean()
									.setSpecification_id(productSpecificationBean.getSpecification_id() + ""));

					productSpecificationBean.setProductSpecificationGoodsBeans(productSpecificationGoodsBeans);
				}
			}
			productBean2.setProductSpecificationBeans(productSpecificationBeans);
		}
		return productBean2;
	}

	@Override
	public Object deleteProduct(ProductBean productBean) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.deleteProduct(productBean);
		if (num <= 0) {
			throw new AppException("删除失败!");
		}
		return num;
	}

	@Override
	public Object updateProduct(ProductBean productBean, List<ProductSpecificationBean> productSpecificationBeans) {
		// TODO Auto-generated method stub
		int num = 0;

		String product_origin_price = "";// 产品原价(区间)
		double product_origin_min_price = 0;// 产品原价最小价
		double product_origin_max_price = 0;// 产品原价最大价

		String product_now_price = "";// 产品现价(区间)
		double product_now_min_price = 0;// 产品现价最小价
		double product_now_max_price = 0;// 产品现价最大价

		String profit_price = "";// 销售可得价格(区间)
		double profit_min_price = 0;// 销售可得最小价格
		double profit_max_price = 0;// 销售可得最大价格

		String group_price = "";// 团购价(区间)
		double group_min_price = 0;// 团购最大价
		double group_max_price = 0;// 团购最大价

		int product_stock = 0;// 产品库存

		String specification_uuid = UUID.randomUUID().toString();

		if (productSpecificationBeans != null) {
			goodsDaoC.deleteProductSpecifications(
					new ProductSpecificationBean().setProduct_id(productBean.getProduct_id() + ""));
			goodsDaoC.deleteProductSpecificationGoodss(new ProductSpecificationGoodsBean()
					.setProduct_id(productBean.getProduct_id() + "").setSpecification_uuid(specification_uuid));

			for (int i = 0; i < productSpecificationBeans.size(); i++) {
				ProductSpecificationBean productSpecificationBean = productSpecificationBeans.get(i);

				product_stock += NumberUtils.Integer(productSpecificationBean.getSpecification_stock());
				if (i == 0) {
					product_origin_min_price = NumberUtils
							.Double(productSpecificationBean.getSpecification_origin_price());
					product_origin_max_price = NumberUtils
							.Double(productSpecificationBean.getSpecification_origin_price());

					product_now_min_price = NumberUtils.Double(productSpecificationBean.getSpecification_price());
					product_now_max_price = NumberUtils.Double(productSpecificationBean.getSpecification_price());

					profit_min_price = NumberUtils.Double(productSpecificationBean.getProfit_price());
					profit_max_price = NumberUtils.Double(productSpecificationBean.getProfit_price());

					group_min_price = NumberUtils.Double(productSpecificationBean.getGroup_price());
					group_max_price = NumberUtils.Double(productSpecificationBean.getGroup_price());
				} else {
					if (product_origin_min_price > NumberUtils
							.Double(productSpecificationBean.getSpecification_origin_price())) {// 替换最小价格
						product_origin_min_price = NumberUtils
								.Double(productSpecificationBean.getSpecification_origin_price());
					}
					if (product_origin_max_price < NumberUtils
							.Double(productSpecificationBean.getSpecification_origin_price())) {
						product_origin_max_price = NumberUtils
								.Double(productSpecificationBean.getSpecification_origin_price());
					}

					if (product_now_min_price > NumberUtils.Double(productSpecificationBean.getSpecification_price())) {// 替换最小价格
						product_now_min_price = NumberUtils.Double(productSpecificationBean.getSpecification_price());
					}
					if (product_now_max_price < NumberUtils.Double(productSpecificationBean.getSpecification_price())) {
						product_now_max_price = NumberUtils.Double(productSpecificationBean.getSpecification_price());
					}
					if (profit_min_price > NumberUtils.Double(productSpecificationBean.getProfit_price())) {// 替换最小价格
						profit_min_price = NumberUtils.Double(productSpecificationBean.getProfit_price());
					}
					if (profit_max_price < NumberUtils.Double(productSpecificationBean.getProfit_price())) {
						profit_max_price = NumberUtils.Double(productSpecificationBean.getProfit_price());
					}

					if (group_min_price > NumberUtils.Double(productSpecificationBean.getGroup_price())) {// 替换最小价格
						group_min_price = NumberUtils.Double(productSpecificationBean.getGroup_price());
					}
					if (group_max_price < NumberUtils.Double(productSpecificationBean.getGroup_price())) {
						group_max_price = NumberUtils.Double(productSpecificationBean.getGroup_price());
					}
				}
				
				if (productSpecificationBean.getSpecification_id() == 0) {
					num = goodsDaoC.insertProductSpecification(
							productSpecificationBean.setProduct_id(productBean.getProduct_id() + ""));
					if (num <= 0) {
						throw new AppException("规格添加失败!");
					}
				} 

				List<ProductSpecificationGoodsBean> productSpecificationGoodsBeans = productSpecificationBean
						.getProductSpecificationGoodsBeans();
				if (productSpecificationGoodsBeans == null || productSpecificationGoodsBeans.size() <= 0) {
					throw new AppException("请先选择规格商品!");
				}

				for (int j = 0; j < productSpecificationGoodsBeans.size(); j++) {
					ProductSpecificationGoodsBean productSpecificationGoodsBean = productSpecificationGoodsBeans.get(j);

					GoodsBean goodsBean = goodsDaoC.getGoodsDetail(new GoodsBean()
							.setGoods_id(NumberUtils.Integer(productSpecificationGoodsBean.getGoods_id())));
					int goods_stock = NumberUtils.Integer(goodsBean.getGoods_stock());
					int goods_num = NumberUtils.Integer(productSpecificationBean.getSpecification_stock())
							* NumberUtils.Integer(productSpecificationGoodsBean.getGoods_num());
					int stock = 0;
					int count = 0;
					if (productSpecificationGoodsBean.getSpecification_goods_id() == 0) {

						stock = goods_stock - goods_num;
						count = goods_num;
						if (stock < 0) {
							throw new AppException("商品:" + goodsBean.getGoods_name() + "库存不足!");
						}

						num = goodsDaoC.insertProductSpecificationGoods(
								productSpecificationGoodsBean.setProduct_id(productBean.getProduct_id() + "")
										.setSpecification_id(productSpecificationBean.getSpecification_id() + ""));
						if (num <= 0) {
							throw new AppException("规格商品添加失败!");
						}
					} else {

						Map<String, Object> stockMap = goodsDaoC
								.getProductSpecificationGoodsStock(productSpecificationGoodsBean);

						stock = goods_stock - goods_num + NumberUtils.Integer(stockMap.get("specification_stock") + "");
						count = goods_num - NumberUtils.Integer(stockMap.get("specification_stock") + "");
						if (stock < 0) {
							throw new AppException("商品:" + goodsBean.getGoods_name() + "库存不足!");
						}

						num = goodsDaoC.updateProductSpecificationGoods(productSpecificationGoodsBean);
						if (num <= 0) {
							throw new AppException("规格商品修改失败!");
						}
					}

					num = goodsDaoC.updateGoods(
							new GoodsBean().setGoods_id(goodsBean.getGoods_id()).setGoods_stock(stock + ""));
					if (num <= 0) {
						throw new AppException("商品更新库存失败!");
					}

					num = goodsDaoC.insertGoodsStock(new GoodsStockBean().setGoods_id(goodsBean.getGoods_id() + "")
							.setGoods_stock(Math.abs(count) + "").setStock_type(count > 0 ? "4" : "5")
							.setProduct_id(productBean.getProduct_id()+""));
					if (num <= 0) {
						throw new AppException("库存明细入库失败!");
					}
				}

				if (productSpecificationBean.getSpecification_id() != 0) {//必须放在商品添加之后 因为要计算商品库存!
					num = goodsDaoC.updateProductSpecification(productSpecificationBean);
					if (num <= 0) {
						throw new AppException("规格修改失败!");
					}
				} 
			}

			List<Map<String, Object>> maps = goodsDaoC.getReleaseProductSpecificationGoodss(
					new ProductSpecificationGoodsBean().setSpecification_uuid(specification_uuid));// 释放产品库存
			if (maps != null) {
				for (int i = 0; i < maps.size(); i++) {
					Map<String, Object> map = maps.get(i);

					num = goodsDaoC
							.updateGoodsStock(new GoodsBean().setGoods_id(NumberUtils.Integer(map.get("goods_id") + ""))
									.setGoods_stock(map.get("stock") + ""));
					if (num <= 0) {
						throw new AppException("商品更新库存失败!");
					}

					num = goodsDaoC.insertGoodsStock(new GoodsStockBean().setGoods_id(map.get("goods_id") + "")
							.setGoods_stock(map.get("stock") + "").setStock_type("5")
							.setProduct_id(productBean.getProduct_id()+""));
					if (num <= 0) {
						throw new AppException("库存明细入库失败!");
					}
				}
			}
		}

		product_origin_price = product_origin_min_price + "";
		if (product_origin_min_price != product_origin_max_price) {
			product_origin_price = product_origin_min_price + "~" + product_origin_max_price;
		}

		product_now_price = product_now_min_price + "";
		if (product_now_min_price != product_now_max_price) {
			product_now_price = product_now_min_price + "~" + product_now_max_price;
		}

		profit_price = profit_min_price + "";
		if (profit_min_price != profit_max_price) {
			profit_price = profit_min_price + "~" + profit_max_price;
		}

		group_price = group_min_price + "";
		if (group_min_price != group_max_price) {
			group_price = group_min_price + "~" + group_max_price;
		}

		num = goodsDaoC.updateProduct(productBean.setProduct_origin_price(product_origin_price)
				.setProduct_origin_min_price(product_origin_min_price + "")
				.setProduct_origin_max_price(product_origin_max_price + "").setProduct_now_price(product_now_price)
				.setProduct_now_min_price(product_now_min_price + "")
				.setProduct_now_max_price(product_now_max_price + "").setProfit_price(profit_price)
				.setProfit_min_price(profit_min_price + "").setProfit_max_price(profit_max_price + "")
				.setProduct_stock(product_stock + "").setGroup_price(group_price)
				.setGroup_min_price(group_min_price + "").setGroup_max_price(group_max_price + "")
				.setSpecification_count(productSpecificationBeans.size()+""));
		if (num <= 0) {
			throw new AppException("修改失败!");
		}
		return num;
	}

	@Override
	public Object insertProduct(ProductBean productBean, List<ProductSpecificationBean> productSpecificationBeans) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.insertProduct(productBean.setSpecification_count(productSpecificationBeans.size()+""));
		if (num <= 0) {
			throw new AppException("添加失败!");
		}

		String product_origin_price = "";// 产品原价(区间)
		double product_origin_min_price = 0;// 产品原价最小价
		double product_origin_max_price = 0;// 产品原价最大价

		String product_now_price = "";// 产品现价(区间)
		double product_now_min_price = 0;// 产品现价最小价
		double product_now_max_price = 0;// 产品现价最大价

		String profit_price = "";// 销售可得价格(区间)
		double profit_min_price = 0;// 销售可得最小价格
		double profit_max_price = 0;// 销售可得最大价格

		String group_price = "";// 团购价(区间)
		double group_min_price = 0;// 团购最大价
		double group_max_price = 0;// 团购最大价

		int product_stock = 0;// 产品库存

		if (productSpecificationBeans != null) {
			for (int i = 0; i < productSpecificationBeans.size(); i++) {
				ProductSpecificationBean productSpecificationBean = productSpecificationBeans.get(i);

				product_stock += NumberUtils.Integer(productSpecificationBean.getSpecification_stock());
				if (i == 0) {
					product_origin_min_price = NumberUtils
							.Double(productSpecificationBean.getSpecification_origin_price());
					product_origin_max_price = NumberUtils
							.Double(productSpecificationBean.getSpecification_origin_price());

					product_now_min_price = NumberUtils.Double(productSpecificationBean.getSpecification_price());
					product_now_max_price = NumberUtils.Double(productSpecificationBean.getSpecification_price());

					profit_min_price = NumberUtils.Double(productSpecificationBean.getProfit_price());
					profit_max_price = NumberUtils.Double(productSpecificationBean.getProfit_price());

					group_min_price = NumberUtils.Double(productSpecificationBean.getGroup_price());
					group_max_price = NumberUtils.Double(productSpecificationBean.getGroup_price());
				} else {
					if (product_origin_min_price > NumberUtils
							.Double(productSpecificationBean.getSpecification_origin_price())) {// 替换最小价格
						product_origin_min_price = NumberUtils
								.Double(productSpecificationBean.getSpecification_origin_price());
					}
					if (product_origin_max_price < NumberUtils
							.Double(productSpecificationBean.getSpecification_origin_price())) {
						product_origin_max_price = NumberUtils
								.Double(productSpecificationBean.getSpecification_origin_price());
					}

					if (product_now_min_price > NumberUtils.Double(productSpecificationBean.getSpecification_price())) {// 替换最小价格
						product_now_min_price = NumberUtils.Double(productSpecificationBean.getSpecification_price());
					}
					if (product_now_max_price < NumberUtils.Double(productSpecificationBean.getSpecification_price())) {
						product_now_max_price = NumberUtils.Double(productSpecificationBean.getSpecification_price());
					}
					if (profit_min_price > NumberUtils.Double(productSpecificationBean.getProfit_price())) {// 替换最小价格
						profit_min_price = NumberUtils.Double(productSpecificationBean.getProfit_price());
					}
					if (profit_max_price < NumberUtils.Double(productSpecificationBean.getProfit_price())) {
						profit_max_price = NumberUtils.Double(productSpecificationBean.getProfit_price());
					}

					if (group_min_price > NumberUtils.Double(productSpecificationBean.getGroup_price())) {// 替换最小价格
						group_min_price = NumberUtils.Double(productSpecificationBean.getGroup_price());
					}
					if (group_max_price < NumberUtils.Double(productSpecificationBean.getGroup_price())) {
						group_max_price = NumberUtils.Double(productSpecificationBean.getGroup_price());
					}
				}

				num = goodsDaoC.insertProductSpecification(
						productSpecificationBean.setProduct_id(productBean.getProduct_id() + ""));
				if (num <= 0) {
					throw new AppException("规格添加失败!");
				}

				List<ProductSpecificationGoodsBean> productSpecificationGoodsBeans = productSpecificationBean
						.getProductSpecificationGoodsBeans();
				if (productSpecificationGoodsBeans == null || productSpecificationGoodsBeans.size() <= 0) {
					throw new AppException("请先选择规格商品!");
				}
				for (int j = 0; j < productSpecificationGoodsBeans.size(); j++) {
					ProductSpecificationGoodsBean productSpecificationGoodsBean = productSpecificationGoodsBeans.get(j);

					GoodsBean goodsBean = goodsDaoC.getGoodsDetail(new GoodsBean()
							.setGoods_id(NumberUtils.Integer(productSpecificationGoodsBean.getGoods_id())));
					int goods_stock = NumberUtils.Integer(goodsBean.getGoods_stock());
					int goods_num = NumberUtils.Integer(productSpecificationBean.getSpecification_stock())
							* NumberUtils.Integer(productSpecificationGoodsBean.getGoods_num());
					if (goods_stock < goods_num) {
						throw new AppException("商品:" + goodsBean.getGoods_name() + "库存不足!");
					}

					num = goodsDaoC.updateGoods(new GoodsBean().setGoods_id(goodsBean.getGoods_id())
							.setGoods_stock((goods_stock - goods_num) + ""));
					if (num <= 0) {
						throw new AppException("商品更新库存失败!");
					}

					num = goodsDaoC.insertGoodsStock(new GoodsStockBean().setGoods_id(goodsBean.getGoods_id() + "")
							.setGoods_stock(goods_num + "").setStock_type("4")
							.setProduct_id(productBean.getProduct_id()+""));
					if (num <= 0) {
						throw new AppException("库存明细入库失败!");
					}

					num = goodsDaoC.insertProductSpecificationGoods(
							productSpecificationGoodsBean.setProduct_id(productBean.getProduct_id() + "")
									.setSpecification_id(productSpecificationBean.getSpecification_id() + ""));
					if (num <= 0) {
						throw new AppException("规格商品添加失败!");
					}
				}
			}
		}

		product_origin_price = product_origin_min_price + "";
		if (product_origin_min_price != product_origin_max_price) {
			product_origin_price = product_origin_min_price + "~" + product_origin_max_price;
		}

		product_now_price = product_now_min_price + "";
		if (product_now_min_price != product_now_max_price) {
			product_now_price = product_now_min_price + "~" + product_now_max_price;
		}

		profit_price = profit_min_price + "";
		if (profit_min_price != profit_max_price) {
			profit_price = profit_min_price + "~" + profit_max_price;
		}

		group_price = group_min_price + "";
		if (group_min_price != group_max_price) {
			group_price = group_min_price + "~" + group_max_price;
		}

		num = goodsDaoC.updateProduct(new ProductBean().setProduct_id(productBean.getProduct_id())
				.setProduct_origin_price(product_origin_price)
				.setProduct_origin_min_price(product_origin_min_price + "")
				.setProduct_origin_max_price(product_origin_max_price + "").setProduct_now_price(product_now_price)
				.setProduct_now_min_price(product_now_min_price + "")
				.setProduct_now_max_price(product_now_max_price + "").setProfit_price(profit_price)
				.setProfit_min_price(profit_min_price + "").setProfit_max_price(profit_max_price + "")
				.setProduct_stock(product_stock + "").setGroup_price(group_price)
				.setGroup_min_price(group_min_price + "").setGroup_max_price(group_max_price + ""));
		if (num <= 0) {
			throw new AppException("修改失败!");
		}
		return num;
	}

	@Override
	public Object getFreights(FreightBean freightBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<FreightBean> freightBeans = goodsDaoC.getFreights(freightBean, pageBean);

		return pageBean.setObject(freightBeans);
	}

	@Override
	public Object getFreightsNoPage(FreightBean freightBean) {
		// TODO Auto-generated method stub
		List<FreightBean> freightBeans = goodsDaoC.getFreightsNoPage(freightBean);
		return freightBeans;
	}

	@Override
	public Object getFreightDetail(FreightBean freightBean) {
		// TODO Auto-generated method stub
		FreightBean freightBean2 = goodsDaoC.getFreightDetail(freightBean);
		if (freightBean2 != null) {
			List<FreightCityBean> freightCityBeans = goodsDaoC
					.getFreightCitys(new FreightCityBean().setFreight_id(freightBean.getFreight_id() + ""));
			freightBean2.setFreightCityBeans(freightCityBeans);

			List<FreightFreeBean> freightFreeBeans = goodsDaoC
					.getFreightFrees(new FreightFreeBean().setFreight_id(freightBean.getFreight_id() + ""));
			freightBean2.setFreightFreeBeans(freightFreeBeans);
		}
		return freightBean2;
	}

	@Override
	public int insertFreight(FreightBean freightBean, List<FreightCityBean> freightCityBeans,
			List<FreightFreeBean> freightFreeBeans) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.insertFreight(freightBean);
		if (num <= 0) {
			throw new AppException("添加失败!");
		}

		if ("1".equals(freightBean.getFreight_way())) {
			if (freightCityBeans != null) {
				for (int i = 0; i < freightCityBeans.size(); i++) {
					FreightCityBean freightCityBean = freightCityBeans.get(i);

					num = goodsDaoC.insertFreightCity(freightCityBean.setFreight_id(freightBean.getFreight_id() + ""));
					if (num <= 0) {
						throw new AppException("运费价格入库失败!");
					}
				}
			}

			if (freightFreeBeans != null) {
				for (int i = 0; i < freightFreeBeans.size(); i++) {
					FreightFreeBean freightFreeBean = freightFreeBeans.get(i);
					num = goodsDaoC.insertFreightFree(freightFreeBean.setFreight_id(freightBean.getFreight_id() + ""));
					if (num <= 0) {
						throw new AppException("免运费入库失败!");
					}
				}
			}
		}
		return num;
	}

	@Override
	public int updateFreight(FreightBean freightBean, List<FreightCityBean> freightCityBeans,
			List<FreightFreeBean> freightFreeBeans) {
		// TODO Auto-generated method stub

		int num = 0;
		if ("1".equals(freightBean.getFreight_way())) {
			goodsDaoC.deleteFreightCitys(new FreightCityBean().setFreight_id(freightBean.getFreight_id() + ""));
			if (freightCityBeans != null) {
				for (int i = 0; i < freightCityBeans.size(); i++) {
					FreightCityBean freightCityBean = freightCityBeans.get(i);

					if (freightCityBean.getFreight_city_id() == 0) {
						num = goodsDaoC
								.insertFreightCity(freightCityBean.setFreight_id(freightBean.getFreight_id() + ""));
						if (num <= 0) {
							throw new AppException("运费价格入库失败!");
						}
					} else {
						num = goodsDaoC.updateFreightCity(freightCityBean);
						if (num <= 0) {
							throw new AppException("运费价格修改失败!");
						}
					}
				}
			}

			goodsDaoC.deleteFreightFrees(new FreightFreeBean().setFreight_id(freightBean.getFreight_id() + ""));
			if (freightFreeBeans != null) {
				for (int i = 0; i < freightFreeBeans.size(); i++) {
					FreightFreeBean freightFreeBean = freightFreeBeans.get(i);
					if (freightFreeBean.getFreight_free_id() == 0) {
						num = goodsDaoC
								.insertFreightFree(freightFreeBean.setFreight_id(freightBean.getFreight_id() + ""));
						if (num <= 0) {
							throw new AppException("免运费入库失败!");
						}
					} else {
						num = goodsDaoC.updateFreightFree(freightFreeBean);
						if (num <= 0) {
							throw new AppException("免运费修改失败!");
						}
					}

				}
			}
		}
		num = goodsDaoC.updateFreight(freightBean);
		if (num <= 0) {
			throw new AppException("修改失败!");
		}
		return num;
	}

	@Override
	public int deleteFreight(FreightBean freightBean) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.deleteFreight(freightBean);
		if (num <= 0) {
			throw new AppException("删除失败!");
		}
		return num;
	}

	@Override
	public Object getServices(ServiceBean serviceBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<ServiceBean> serviceBeans = goodsDaoC.getServices(serviceBean, pageBean);

		return pageBean.setObject(serviceBeans);
	}

	@Override
	public Object getServicesNoPage(ServiceBean serviceBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getServices(serviceBean);
	}

	@Override
	public Object getServiceDetail(ServiceBean serviceBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getServiceDetail(serviceBean);
	}

	@Override
	public Object deleteService(ServiceBean serviceBean) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.deleteService(serviceBean);
		if (num <= 0) {
			throw new AppException("删除失败!");
		}
		return num;
	}

	@Override
	public Object updateService(ServiceBean serviceBean) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.updateService(serviceBean);
		if (num <= 0) {
			throw new AppException("修改失败!");
		}
		return num;
	}

	@Override
	public Object insertService(ServiceBean serviceBean) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.insertService(serviceBean);
		if (num <= 0) {
			throw new AppException("添加失败!");
		}
		return num;
	}

	@Override
	public Object getProductClasss(ProductClassBean productClassBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<ProductClassBean> productClassBeans = goodsDaoC.getProductClasss(productClassBean, pageBean);
		return pageBean.setObject(productClassBeans);
	}

	@Override
	public Object getProductClassLinks(ProductClassBean productClassBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getProductClassLinks(productClassBean);
	}

	@Override
	public Object getProductClassDetail(ProductClassBean productClassBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getProductClassDetail(productClassBean);
	}

	@Override
	public Object deleteProductClass(ProductClassBean productClassBean) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.deleteProductClass(productClassBean);
		if (num <= 0) {
			throw new AppException("删除失败!");
		}
		return num;
	}

	@Override
	public Object updateProductClass(ProductClassBean productClassBean) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.updateProductClass(productClassBean);
		if (num <= 0) {
			throw new AppException("修改失败!");
		}
		return num;
	}

	@Override
	public Object insertProductClass(ProductClassBean productClassBean) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.insertProductClass(productClassBean.setClass_uuid(UUID.randomUUID().toString()));
		if (num <= 0) {
			throw new AppException("添加失败!");
		}
		return num;
	}

	@Override
	public Object getGoodsBatchs(GoodsBatchBean goodsBatchBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<GoodsBatchBean> goodsBatchBeans = goodsDaoC.getGoodsBatchs(goodsBatchBean, pageBean);
		return pageBean.setObject(goodsBatchBeans);
	}

	@Override
	public Object getGoodsBatchDetail(GoodsBatchBean goodsBatchBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getGoodsBatchDetail(goodsBatchBean);
	}

	@Override
	public Object deleteGoodsBatch(GoodsBatchBean goodsBatchBean) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.deleteGoodsBatch(goodsBatchBean);
		if (num <= 0) {
			throw new AppException("删除失败!");
		}
		return num;
	}

	@Override
	public Object updateGoodsBatch(GoodsBatchBean goodsBatchBean) {
		// TODO Auto-generated method stub
		GoodsBatchBean goodsBatchBean2 = goodsDaoC.getGoodsBatchDetail(goodsBatchBean);
		if (goodsBatchBean2 == null) {
			throw new AppException("批次不存在!");
		}

		int num = goodsDaoC.updateGoodsBatch(goodsBatchBean);
		if (num <= 0) {
			throw new AppException("修改失败!");
		}

		int batch_stock = NumberUtils.Integer(goodsBatchBean.getBatch_stock())
				- NumberUtils.Integer(goodsBatchBean2.getBatch_stock());
		num = goodsDaoC.updateGoodsStock(new GoodsBean().setGoods_id(NumberUtils.Integer(goodsBatchBean.getGoods_id()))
				.setGoods_stock(batch_stock + ""));
		if (num <= 0) {
			throw new AppException("库存更新失败");
		}
		if (batch_stock != 0) {
			num = goodsDaoC.insertGoodsStock(new GoodsStockBean().setGoods_id(goodsBatchBean.getGoods_id())
					.setGoods_stock(Math.abs(batch_stock) + "").setStock_type(batch_stock > 0 ? "2" : "3")
					.setBatch_id(goodsBatchBean2.getBatch_id()+""));
			if (num <= 0) {
				throw new AppException("库存明细入库失败!");
			}
		}
		return num;
	}

	@Override
	public Object insertGoodsBatch(GoodsBatchBean goodsBatchBean) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.insertGoodsBatch(goodsBatchBean);
		if (num <= 0) {
			throw new AppException("添加失败");
		}

		num = goodsDaoC.updateGoodsStock(new GoodsBean().setGoods_id(NumberUtils.Integer(goodsBatchBean.getGoods_id()))
				.setGoods_stock(goodsBatchBean.getBatch_stock()));
		if (num <= 0) {
			throw new AppException("库存更新失败");
		}

		num = goodsDaoC.insertGoodsStock(new GoodsStockBean().setGoods_id(goodsBatchBean.getGoods_id())
				.setGoods_stock(goodsBatchBean.getBatch_stock()).setStock_type("1")
				.setBatch_id(goodsBatchBean.getBatch_id()+""));
		if (num <= 0) {
			throw new AppException("库存明细入库失败!");
		}
		return num;
	}

	@Override
	public Object getGoodss(GoodsBean goodsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<GoodsBean> goodsBeans = goodsDaoC.getGoodss(goodsBean, pageBean);
		return pageBean.setObject(goodsBeans);
	}

	@Override
	public Object getGoodsDetail(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getGoodsDetail(goodsBean);
	}

	@Override
	public Object deleteGoods(GoodsBean goodsBean) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.deleteGoods(goodsBean);
		if (num <= 0) {
			throw new AppException("删除失败!");
		}
		return num;
	}

	@Override
	public Object updateGoods(GoodsBean goodsBean) {

		int num = goodsDaoC.updateGoods(goodsBean);
		if (num <= 0) {
			throw new AppException("修改失败!");
		}
		return num;

	}

	@Override
	public Object insertGoods(GoodsBean goodsBean) {

		
		int num1 = goodsDaoC.insertGoods(goodsBean);
		if (num1 <= 0) {
			throw new AppException("添加失败!");
		}
		return num1;
	}

	@Override
	public Object getSuppliers(SupplierBean supplierBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<SupplierBean> supplierBeans = goodsDaoC.getSuppliers(supplierBean, pageBean);
		return pageBean.setObject(supplierBeans);
	}

	@Override
	public Object getSupplierDetail(SupplierBean supplierBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getSupplierDetail(supplierBean);
	}

	@Override
	public Object deleteSupplier(SupplierBean supplierBean) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.deleteSupplier(supplierBean);
		if (num <= 0) {
			throw new AppException("删除失败!");
		}
		return num;
	}

	@Override
	public Object updateSupplier(SupplierBean supplierBean) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.updateSupplier(supplierBean);
		if (num <= 0) {
			throw new AppException("修改失败!");
		}
		return num;
	}

	@Override
	public Object insertSupplier(SupplierBean supplierBean) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.insertSupplier(supplierBean);
		if (num <= 0) {
			throw new AppException("添加失败!");
		}
		return num;
	}

	@Override
	public Object getPurchases(PurchaseBean purchaseBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<PurchaseBean> purchaseBeans = goodsDaoC.getPurchases(purchaseBean, pageBean);
		return pageBean.setObject(purchaseBeans);
	}

	@Override
	public Object getPurchaseDetail(PurchaseBean purchaseBean) {
		// TODO Auto-generated method stub
		PurchaseBean purchaseBean2 = goodsDaoC.getPurchaseDetail(purchaseBean);
		if (purchaseBean2 != null) {
			List<PurchaseGoodsBean> purchaseGoodsBeans = goodsDaoC
					.getPurchaseGoodss(new PurchaseGoodsBean().setPurchase_id(purchaseBean2.getPurchase_id() + ""));
			purchaseBean2.setPurchaseGoodsBeans(purchaseGoodsBeans);
		}
		return purchaseBean2;
	}

	@Override
	public Object deletePurchase(PurchaseBean purchaseBean) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.deletePurchase(purchaseBean);
		if (num <= 0) {
			throw new AppException("删除失败!");
		}
		return num;
	}

	@Override
	public Object updatePurchase(PurchaseBean purchaseBean, List<PurchaseGoodsBean> purchaseGoodsBeans) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.updatePurchase(purchaseBean);
		if (num <= 0) {
			throw new AppException("修改失败!");
		}

		goodsDaoC.deletePurchaseGoodss(new PurchaseGoodsBean().setPurchase_id(purchaseBean.getPurchase_id() + ""));
		if (purchaseGoodsBeans != null) {
			for (int i = 0; i < purchaseGoodsBeans.size(); i++) {
				PurchaseGoodsBean purchaseGoodsBean = purchaseGoodsBeans.get(i);
				if (purchaseGoodsBean.getPurchase_goods_id() == 0) {
					num = goodsDaoC
							.insertPurchaseGoods(purchaseGoodsBean.setPurchase_id(purchaseBean.getPurchase_id() + ""));
					if (num <= 0) {
						throw new AppException("添加商品失败!");
					}
				} else {
					num = goodsDaoC.updatePurchaseGoods(purchaseGoodsBean);
					if (num <= 0) {
						throw new AppException("修改商品失败!");
					}
				}
			}
		}
		return num;
	}

	@Override
	public Object insertPurchase(PurchaseBean purchaseBean, List<PurchaseGoodsBean> purchaseGoodsBeans) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.insertPurchase(purchaseBean);
		if (num <= 0) {
			throw new AppException("添加失败!");
		}

		if (purchaseGoodsBeans != null) {
			for (int i = 0; i < purchaseGoodsBeans.size(); i++) {
				PurchaseGoodsBean purchaseGoodsBean = purchaseGoodsBeans.get(i);
				num = goodsDaoC
						.insertPurchaseGoods(purchaseGoodsBean.setPurchase_id(purchaseBean.getPurchase_id() + ""));
				if (num <= 0) {
					throw new AppException("添加商品失败!");
				}
			}
		}
		return num;
	}

	@Override
	public Object getPurchaseBatchs(PurchaseBean purchaseBean) {
		// TODO Auto-generated method stub
		return goodsDaoC.getPurchaseBatchs(purchaseBean);
	}

	@Override
	public Object insertPurchaseBatchs(PurchaseBean purchaseBean, List<GoodsBatchBean> goodsBatchBeans) {
		// TODO Auto-generated method stub
		int num = goodsDaoC.updatePurchase(purchaseBean.setPurchase_state("2"));
		if (num <= 0) {
			throw new AppException("入库失败");
		}

		for (int i = 0; i < goodsBatchBeans.size(); i++) {
			GoodsBatchBean goodsBatchBean = goodsBatchBeans.get(i);

			int batch_stock = NumberUtils.Integer(goodsBatchBean.getBatch_stock());// 这批次的实际入库商品库存
			int batch_unqualified_stock = NumberUtils.Integer(goodsBatchBean.getBatch_unqualified_stock());// 本批次
																											// 不合格库存数
			int purchase_stock = NumberUtils.Integer(goodsBatchBean.getPurchase_stock());// 本批次
																							// 采购库存
			if (batch_stock + batch_unqualified_stock != purchase_stock) {
				throw new AppException("总库存数不等于采购数!");
			}

			num = goodsDaoC.insertGoodsBatch(goodsBatchBean.setPurchase_id(purchaseBean.getPurchase_id() + ""));
			if (num <= 0) {
				throw new AppException("添加失败");
			}

			num = goodsDaoC.updateGoodsStock(new GoodsBean().setGoods_id(NumberUtils.Integer(goodsBatchBean.getGoods_id()))
							.setGoods_stock(goodsBatchBean.getBatch_stock()));
			if (num <= 0) {
				throw new AppException("库存更新失败");
			}

			num = goodsDaoC.insertGoodsStock(new GoodsStockBean().setGoods_id(goodsBatchBean.getGoods_id())
					.setGoods_stock(goodsBatchBean.getBatch_stock())
					.setStock_type("1")
					.setBatch_id(goodsBatchBean.getBatch_id()+""));
			if (num <= 0) {
				throw new AppException("库存明细入库失败!");
			}
		}
		return num;
	}

}
