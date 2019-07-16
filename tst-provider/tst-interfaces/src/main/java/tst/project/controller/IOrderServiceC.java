package tst.project.controller;

import java.util.List;

import tst.project.bean.order.OrderLogisticsBean;
import tst.project.bean.order.OrderLogisticsCompanyBean;
import tst.project.bean.order.OrderMerchantsBean;
import tst.project.bean.order.OrderProductGoodsBean;
import tst.project.bean.product.GoodsBatchBean;
import tst.project.page.PageBean;

public interface IOrderServiceC {
	
	/**
	 * 平台总的统计
	 * @author sjb
	 * @return
	 */
	public Object getPlatformStatistics();
	/**
	 * 快递列表
	 * @param OrderLogisticsCompanyBean
	 * @return
	 */
	public Object getOrderLogisticsCompanys(OrderLogisticsCompanyBean orderLogisticsCompanyBean);
	
	/**
	 * 快递列表
	 * @param OrderLogisticsCompanyBean
	 * @return
	 */
	public Object getOrderLogisticsCompanys(OrderLogisticsCompanyBean orderLogisticsCompanyBean,PageBean pageBean);

	
	/**
	 * 快递详情
	 * @param OrderLogisticsCompanyBean
	 * @return
	 */
	public Object getOrderLogisticsCompanyDetail(OrderLogisticsCompanyBean orderLogisticsCompanyBean);
	
	/**
	 * 添加快递
	 * @param OrderLogisticsCompanyBean
	 * @return
	 */
	public Object insertOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean);
	
	/**
	 * 修改快递
	 * @param OrderLogisticsCompanyBean
	 * @return
	 */
	public Object updateOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean);

	
	/**
	 * 删除快递
	 * @param OrderLogisticsCompanyBean
	 * @return
	 */
	public Object deleteOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean);
	
	
	/**
	 * 产品批次列表
	 * @author sjb
	 * @param goodsBatchBean
	 * @return
	 */
	public Object getGoodsBatchs(GoodsBatchBean goodsBatchBean);
	
	/**
	 * 仓库发货
	 * @author sjb
	 * @param orderMerchantsBean
	 * @param orderProductGoodsBean
	 * @return
	 */
	public Object sendStorehouse(OrderMerchantsBean orderMerchantsBean,OrderLogisticsBean orderLogisticsBean,List<OrderProductGoodsBean> orderProductGoodsBeans);
	/**
	 * 提交海关
	 * @author sjb
	 * @param orderMerchantsBean
	 * @param orderLogisticsBean
	 * @param orderProductGoodsBeans
	 * @return
	 */
	public Object haiguanOrder(OrderMerchantsBean orderMerchantsBean);

	/**
	 * 订单的商品列表
	 * @author sjb
	 * @param orderProductGoodsBean
	 * @return
	 */
	public Object getOrderProductGoodss(OrderProductGoodsBean orderProductGoodsBean);
	
	/**
	 * 订单发货
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object sendOrderMerchants(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 订单详情
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object getOrderMerchantsDetail(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 订单列表
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object getOrderMerchants(OrderMerchantsBean orderMerchantsBean,PageBean pageBean);
	/**
	 * 导出订单列表
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object exportOrderMerchants(OrderMerchantsBean orderMerchantsBean);

}
