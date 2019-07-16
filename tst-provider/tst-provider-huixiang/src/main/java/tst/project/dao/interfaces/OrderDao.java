package tst.project.dao.interfaces;

import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
import tst.project.bean.order.OrderAddressBean;
import tst.project.bean.order.OrderAssessmentBean;
import tst.project.bean.order.OrderBean;
import tst.project.bean.order.OrderGroupBean;
import tst.project.bean.order.OrderLogisticsBean;
import tst.project.bean.order.OrderLogisticsDetailBean;
import tst.project.bean.order.OrderMerchantsBean;
import tst.project.bean.order.OrderProductBean;
import tst.project.bean.order.OrderProductGoodsBean;
import tst.project.bean.product.DeviceBean;
import tst.project.bean.product.DeviceCargoBean;
import tst.project.bean.product.DeviceReplenishmentBatchBean;
import tst.project.bean.product.FreightCityBean;
import tst.project.bean.product.OrderProductBatchBean;
import tst.project.bean.product.ProductBean;
import tst.project.bean.product.ProductSpecificationBean;
import tst.project.page.PageBean;

@Mapper
public interface OrderDao {
	/**
	 * 需要海关下单的订单列表
	 * @param orderBean
	 * @return
	 */
	public List<Map<String, Object>> getHaiguanOrders(OrderMerchantsBean orderMerchantsBean);
	/**
	 * 需要海关下单的商品列表
	 * @param orderProductGoodsBean
	 * @return
	 */
	public List<Map<String, Object>> getHaiguanOrderGoodss(OrderProductGoodsBean orderProductGoodsBean);
	/**
	 * 获得订单支付详情
	 * @param orderBean
	 * @return
	 */
	public OrderBean getOrderPayDetail(OrderBean orderBean);
	
	/**
	 * 添加订单支付记录
	 * @param orderBean
	 * @return
	 */
	public int insertOrderPay(OrderBean orderBean);
	/**
	 * 设备的销售记录
	 * @author sjb
	 * @return
	 */
	public List<Map<String, Object>> getDeivceSales(DeviceBean deviceBean,PageBean pageBean);
	/**
	 * 订单的物流信息
	 * @author sjb
	 * @param orderLogisticsDetailBean
	 * @return
	 */
	public List<OrderLogisticsDetailBean> getOrderLogisticsDetails(OrderLogisticsDetailBean orderLogisticsDetailBean);
	
	/**
	 * 物流信息
	 * @author hwq
	 * @param orderLogisticsBean
	 * @return
	 */
	public OrderLogisticsBean getOrderLogistics(OrderLogisticsBean orderLogisticsBean);
	
	/**
	 * 修改订单物流信息
	 * @param orderLogisticsBean
	 * @return
	 */
	public int updateOrderLogistics(OrderLogisticsBean orderLogisticsBean);
	/**
	 * 批量插入物流详情
	 * @param orderLogisticsDetailBeans
	 * @return
	 */
	public int insertOrderLogisticsDetails(List<OrderLogisticsDetailBean> orderLogisticsDetailBeans);

	/**
	 * 该物流单号 已经入库的物流条数
	 * @param orderLogisticsBean
	 * @return
	 */
	public int getLogisticsCount(OrderLogisticsBean orderLogisticsBean);
	/**
	 * 需要查询物流的订单列表
	 * @return
	 */
	public List<Map<String, Object>> getLogisticsOrders();
	/**
	 * 超时订单列表
	 * @return
	 */
	public List<Map<String, Object>> getCancelOrders();
	/**
	 * 处理拼团失败!
	 * @param orderMerchantsBean
	 * @return
	 */
	public int timingCancelGroupOrder(OrderMerchantsBean orderMerchantsBean);
	/**
	 * 取消订单 恢复商品的销量
	 * 
	 * @param orderMerchantsBean
	 * @return
	 */
	public int cancelProductSales(OrderMerchantsBean orderMerchantsBean);
	
	
	/**
	 * 获得超时失败的团购订单
	 * @return
	 */
	public List<Map<String, Object>> getCancelGroupOrders();
	
	/**
	 * 更新补货的商品库存
	 * @param deviceReplenishmentBatchBean
	 * @return
	 */
	public int updateDeviceReplenishmentBatch(DeviceReplenishmentBatchBean deviceReplenishmentBatchBean);
	/**
	 * 获取补货的商品列表
	 * @param deviceReplenishmentBatchBean
	 * @return
	 */
	public DeviceReplenishmentBatchBean getDeviceReplenishmentBatch(OrderBean orderBean); 
	
	/**
	 * 添加订单产品批次
	 * @param orderProductBatchBean
	 * @return
	 */
	public int insertOrderProductBatch(OrderProductBatchBean orderProductBatchBean);
	/**
	 * 修改货道的库存
	 * @param deviceCargoBean
	 * @return
	 */
	public int updateDeviceCargoStock(OrderBean orderBean);
	
	/**
	 * 设备货道详情
	 * @param deviceCargoBean
	 * @return
	 */
	public DeviceCargoBean getDeviceCargoDetail(DeviceCargoBean deviceCargoBean);
	
	/**
	 * 团购详情
	 * @author sjb
	 * @param orderGroupBean
	 * @return
	 */
	public Map<String, Object> getOrderGroupDetail(OrderGroupBean orderGroupBean);
	
	/**
	 * 获得团购的用户列表
	 * @param orderGroupBean
	 * @return
	 */
	public List<Map<String, Object>> getOrderGroupMembers(OrderGroupBean orderGroupBean);
	/**
	 * 用户自己的团购列表
	 * @author sjb
	 * @param orderGroupBean
	 * @param pageBean
	 * @return
	 */
	public List<Map<String, Object>> getOrderGroups(OrderGroupBean orderGroupBean,PageBean pageBean);
	
	/**
	 * 产品正在进行中的团购列表
	 * @author sjb
	 * @param orderGroupBean
	 * @param pageBean
	 * @return
	 */
	public List<Map<String, Object>> getProductGroups(OrderGroupBean orderGroupBean,PageBean pageBean);
	
	/**
	 * 修改团购订单信息
	 * @param orderGroupBean
	 * @return
	 */
	public int updateOrderGroup(OrderGroupBean orderGroupBean);
	
	/**
	 * 添加团购订单信息
	 * @param orderGroupBean
	 * @return
	 */
	public int insertOrderGroup(OrderGroupBean orderGroupBean);
	
	/**
	 * 评价详情
	 * @author sjb
	 * @param orderAssessmentBean
	 * @return
	 */
	public OrderAssessmentBean getOrderAssessmentDetail(OrderAssessmentBean orderAssessmentBean);
	
	
	/**
	 * 评价产品 更新订单状态
	 * @param orderAssessmentBean
	 * @return
	 */
	public int assessmentProduct(OrderAssessmentBean orderAssessmentBean);
	
	/**
	 * 评价订单入库
	 * @param orderAssessmentBean
	 * @return
	 */
	public int insertOrderAssessement(OrderAssessmentBean orderAssessmentBean);
	
	/**
	 * 获得待评价的产品列表
	 * @author sjb
	 * @param orderBean
	 * @return
	 */
	public List<OrderProductBean> getAssessmentProducts(OrderBean orderBean);
	
	/**
	 * 删除订单
	 * @param orderBean
	 * @return
	 */
	public int deleteOrder(OrderBean orderBean);
	
	/**
	 * 确认收货
	 * 
	 * @param orderDetailBean
	 * @return
	 */
	public int receiveOrder(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 商家订单详情
	 * @param orderMerchantsBean
	 * @return
	 */
	public OrderMerchantsBean getOrderMerchantsDetail(OrderMerchantsBean orderMerchantsBean);
	
	
	/**
	 * 取消订单 恢复产品的库存
	 * 
	 * @return
	 */
	public int cancelProductStock(OrderMerchantsBean orderMerchantsBean);

	
	/**
	 * 取消订单(未支付之前)
	 * 
	 * @param orderBean
	 * @return
	 */
	public int cancelOrder(OrderBean orderBean);

	/**
	 * 取消订单(未支付之前)
	 * 
	 * @param orderBean
	 * @return
	 */
	public int cancelOrderMerchants(OrderMerchantsBean orderMerchantsBean);

	/**
	 * 订单地址详情
	 * @param orderAddressBean
	 * @return
	 */
	public OrderAddressBean getOrderAddressDetail(OrderAddressBean orderAddressBean);
	
	/**
	 * 订单详情
	 * @return
	 */
	public Map<String, Object> getOrderMap(OrderBean orderBean);
	
	/**
	 * 订单的产品列表
	 * @return
	 */
	public List<OrderProductBean> getOrderProducts(OrderProductBean orderProductBean);
	/**
	 * 订单列表
	 * @author sjb
	 * @param orderBean
	 * @param pageBean
	 * @return
	 */
	public List<Map<String, Object>> getOrders(OrderBean orderBean,PageBean pageBean);
	
	/**
	 * 购买修改产品的销量
	 * 
	 * @param orderMerchantsBean
	 * @return
	 */
	public int updateProductSales(OrderBean orderBean);
	/**
	 * 支付订单
	 * 
	 * @param orderBean
	 * @return
	 */
	public int payOrder(OrderBean orderBean);

	/**
	 * 支付商家订单
	 * 
	 * @param orderBean
	 * @return
	 */
	public int payOrderMerchants(OrderMerchantsBean orderMerchantsBean);

	
	
	/**
	 * 真实支付更新商家订单支付方式
	 * @param orderMerchantsBean
	 * @return
	 */
	public int payRealOrderMerchants(OrderMerchantsBean orderMerchantsBean);
	/**
	 * 订单详情
	 * @param orderBean
	 * @return
	 */
	public OrderBean getOrderDetail(OrderBean orderBean);
	
	/**
	 * 更新产品数量
	 * @return
	 */
	public int updateProductStock(ProductSpecificationBean productSpecificationBean);
	
	/**
	 * 批量把规格的商品入库
	 * @param productSpecificationGoodsBean
	 * @return
	 */
	public int insertOrderProductGoodss(OrderProductGoodsBean orderProductGoodsBean);
	
	/**
	 * 添加订单产品详情
	 * @param orderProductBean
	 * @return
	 */
	public int insertOrderProduct(OrderProductBean orderProductBean);
	/**
	 * 获得订单商品的邮费详情
	 * 
	 * @param freightCityBean
	 * @return
	 */
	public Map<String, Object> getProductFreightDetail(FreightCityBean freightCityBean);
	
	/**
	 * 产品详情
	 * @param productBean
	 * @return
	 */
	public ProductBean getProductDetail(ProductBean productBean);
	
	/**
	 * 产品规格详情
	 * @param productSpecificationBean
	 * @return
	 */
	public ProductSpecificationBean getProductSpecificationDetail(ProductSpecificationBean productSpecificationBean);
	
	/**
	 * 订单主表入库
	 * @param orderBean
	 * @return
	 */
	public int insertOrder(OrderBean orderBean);
	
	/**
	 * 修改订单主表
	 * @param orderBean
	 * @return
	 */
	public int updateOrder(OrderBean orderBean);
	
	/**
	 * 添加订单详情
	 * 
	 * @param orderDetailBean
	 * @return
	 */
	public int insertOrderMerchants(OrderMerchantsBean orderDetailBean);
	
	/**
	 * 修改订单详情
	 * @param orderDetailBean
	 * @return
	 */
	public int updateOrderMerchants(OrderMerchantsBean orderDetailBean);
	
	/**
	 * 添加订单地址
	 * 
	 * @param orderAddressBean
	 * @return
	 */
	public int insertOrderAddress(OrderAddressBean orderAddressBean);
}