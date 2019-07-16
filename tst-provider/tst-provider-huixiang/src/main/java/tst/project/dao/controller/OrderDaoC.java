package tst.project.dao.controller;

import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
import tst.project.bean.order.OrderAddressBean;
import tst.project.bean.order.OrderGroupBean;
import tst.project.bean.order.OrderLogisticsBean;
import tst.project.bean.order.OrderLogisticsCompanyBean;
import tst.project.bean.order.OrderMerchantsBean;
import tst.project.bean.order.OrderProductBean;
import tst.project.bean.order.OrderProductGoodsBean;
import tst.project.bean.product.GoodsBatchBean;
import tst.project.bean.product.OrderProductBatchBean;
import tst.project.page.PageBean;

@Mapper
public interface OrderDaoC {
	/**
	 * 平台总的统计
	 * @author sjb
	 * @return
	 */
	public Map<String,Object> getPlatformStatistics();
	
	/**
	 * 添加订单物流发货详情
	 * @param orderLogisticsBean
	 * @return
	 */
	public int insertOrderLogistics(OrderLogisticsBean orderLogisticsBean);
	
	
	/**
	 * 快递列表
	 * @param orderLogisticsCompanyBean
	 * @return
	 */
	public List<OrderLogisticsCompanyBean> getOrderLogisticsCompanys(OrderLogisticsCompanyBean orderLogisticsCompanyBean,PageBean pageBean);
	public List<OrderLogisticsCompanyBean> getOrderLogisticsCompanys(OrderLogisticsCompanyBean orderLogisticsCompanyBean);

	/**
	 * 快递详情
	 * @param orderLogisticsCompanyBean
	 * @return
	 */
	public OrderLogisticsCompanyBean getOrderLogisticsCompanyDetail(OrderLogisticsCompanyBean orderLogisticsCompanyBean);
	
	/**
	 * 添加快递
	 * @param orderLogisticsCompanyBean
	 * @return
	 */
	public int insertOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean);

	/**
	 * 修改快递
	 * @param orderLogisticsCompanyBean
	 * @return
	 */
	public int updateOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean);
	
	/**
	 * 删除快递
	 * @param orderLogisticsCompanyBean
	 * @return
	 */
	public int deleteOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean);
	
	/**
	 * 添加订单批次
	 * @param orderProductBatchBean
	 * @return
	 */
	public int insertOrderProductBatch(OrderProductBatchBean orderProductBatchBean);
	/**
	 * 产品批次列表
	 * @author sjb
	 * @param goodsBatchBean
	 * @return
	 */
	public List<GoodsBatchBean> getGoodsBatchs(GoodsBatchBean goodsBatchBean);
	
	/**
	 * 修改商品的批次库粗
	 * @param goodsBatchBean
	 * @return
	 */
	public int updateGoodsBatchStock(GoodsBatchBean goodsBatchBean);
	/**
	 * 仓库发货
	 * @author sjb
	 * @param orderMerchantsBean
	 * @param orderProductGoodsBean
	 * @return
	 */
	public int sendStorehouse(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 订单的商品列表
	 * @author sjb
	 * @param orderProductGoodsBean
	 * @return
	 */
	public List<OrderProductGoodsBean> getOrderProductGoodss(OrderProductGoodsBean orderProductGoodsBean);
	
	/**
	 * 订单发货
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public int sendOrderMerchants(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 团购详情
	 * @param orderGroupBean
	 * @return
	 */
	public OrderGroupBean getOrderGroupDetail(OrderGroupBean orderGroupBean);
	/**
	 * 订单产品信息
	 * @param orderProductBean
	 * @return
	 */
	public List<OrderProductBean> getOrderProducts(OrderProductBean orderProductBean);
	/**
	 * 订单地址信息
	 * @param orderAddressBean
	 * @return
	 */
	public OrderAddressBean getOrderAddressDetail(OrderAddressBean orderAddressBean);
	/**
	 * 订单详情
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public OrderMerchantsBean getOrderMerchantsDetail(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 订单列表
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public List<OrderMerchantsBean> getOrderMerchants(OrderMerchantsBean orderMerchantsBean,PageBean pageBean);
	
	public List<Map<String, Object>> exportOrderMerchants(OrderMerchantsBean orderMerchantsBean);

}
