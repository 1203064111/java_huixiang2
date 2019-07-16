package tst.project.interfaces;


import tst.project.bean.order.OrderAssessmentBean;
import tst.project.bean.order.OrderBean;
import tst.project.bean.order.OrderGroupBean;
import tst.project.bean.order.OrderLogisticsBean;
import tst.project.bean.order.OrderMerchantsBean;
import tst.project.bean.product.DeviceBean;
import tst.project.page.PageBean;

public interface IOrderService {
	
	/**
	 * 修改订单信息
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object updateOrderMerchants(OrderMerchantsBean orderMerchantsBean);
	/**
	 * 设备的销售记录
	 * @author sjb
	 * @return
	 */
	public Object getDeivceSales(DeviceBean deviceBean,PageBean pageBean);
	
	/**
	 * 物流详情
	 * @author sjb
	 * @param orderLogisticsBean
	 * @return
	 */
	public Object getOrderLogisticsDetails(OrderLogisticsBean orderLogisticsBean);
	/**
	 * 定时查询物流信息
	 * @author sjb
	 * @return
	 */
	public Object timeOrderLogistics();
	/**
	 * 定时取消超时订单
	 * @author sjb
	 * @return
	 */
	public Object timingCancelOrder();
	
	/**
	 * 定时取消到期的团购订单
	 * @author sjb
	 * @return
	 */
	public Object timingCancelGroupOrder();
	
	/**
	 * 团购详情
	 * @author sjb
	 * @param orderGroupBean
	 * @return
	 */
	public Object getOrderGroupDetail(OrderGroupBean orderGroupBean);
	/**
	 * 用户自己的团购列表
	 * @author sjb
	 * @param orderGroupBean
	 * @param pageBean
	 * @return
	 */
	public Object getOrderGroups(OrderGroupBean orderGroupBean,PageBean pageBean);
	
	/**
	 * 产品正在进行中的团购列表
	 * @author sjb
	 * @param orderGroupBean
	 * @param pageBean
	 * @return
	 */
	public Object getProductGroups(OrderGroupBean orderGroupBean,PageBean pageBean);
	
	/**
	 * 评价详情
	 * @author sjb
	 * @param orderAssessmentBean
	 * @return
	 */
	public Object getOrderAssessmentDetail(OrderAssessmentBean orderAssessmentBean);
	
	/**
	 * 评价产品
	 * @author sjb
	 * @param orderProductBean
	 * @return
	 */
	public Object assessmentProduct(OrderAssessmentBean orderAssessmentBean);
	
	/**
	 * 获得待评价的产品列表
	 * @author sjb
	 * @param orderBean
	 * @return
	 */
	public Object getAssessmentProducts(OrderBean orderBean,PageBean pageBean);
	
	/**
	 * 删除订单
	 * @author sjb
	 * @param orderBean
	 * @return
	 */
	public Object deleteOrder(OrderBean orderBean);
	
	/**
	 * 确认收货
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object receiveOrder(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 取消订单
	 * @author sjb
	 * @param orderBean
	 * @return
	 */
	public Object cancelOrder(OrderBean orderBean);
	/**
	 * 订单列表
	 * @author sjb
	 * @param orderBean
	 * @param pageBean
	 * @return
	 */
	public Object getOrders(OrderBean orderBean,PageBean pageBean);
	
	/**
	 * 订单详情
	 * @author sjb
	 * @param orderBean
	 * @return
	 */
	public Object getOrderDetail(OrderBean orderBean);
	
	/**
	 * 支付订单
	 * @param orderBean
	 * @return
	 */
	public Object payGoodsCallback(OrderBean orderBean,String pay_password);
	
	
	/**
	 * 支付订单 获取支付凭证
	 * @author sjb
	 * @param orderBean
	 * @return
	 */
	public Object payRealOrder(OrderBean orderBean);
	
	/**
	 * 下单
	 * @author sjb
	 * @return
	 */
	public Object insertOrder(OrderBean orderBean,String is_summit);

}
