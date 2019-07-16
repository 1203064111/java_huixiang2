package tst.project.service.interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;

import com.alibaba.fastjson.JSON;
import com.alipay.util.AlipaySubmit;

import tst.project.aspect.AppException;
import tst.project.bean.member.AddressBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.MemberBillBean;
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
import tst.project.bean.product.ProductCarBean;
import tst.project.bean.product.ProductSpecificationBean;
import tst.project.bean.product.ShopBean;
import tst.project.dao.interfaces.AddressDao;
import tst.project.dao.interfaces.MemberDao;
import tst.project.dao.interfaces.OrderDao;
import tst.project.dao.interfaces.ProductCarDao;
import tst.project.dao.interfaces.ProductDao;
import tst.project.interfaces.IOrderService;
import tst.project.page.PageBean;
import tst.project.utils.HaiguanUtils;
import tst.project.utils.HttpUtils;
import tst.project.utils.MD5Util;
import tst.project.utils.NumberUtils;
import tst.project.utils.PayUtils;
import tst.project.utils.RedisUtils;
import tst.project.utils.StringUtils;
import tst.project.utils.TimeUtils;
import tst.project.utils.UUIDUtils;
import tst.project.utils.WXUtils;
import tst.project.utils.XmlUtils;
import tst.project.utils.kd100Utils;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderService implements IOrderService {
	@Autowired
	OrderDao orderDao;

	@Autowired
	AddressDao addressDao;

	@Autowired
	MemberDao memberDao;

	@Autowired
	ProductDao productDao;
	
	@Autowired
	ProductCarDao productCarDao;

	@Value("${wx_lite_AppID}")
	private String wx_lite_appid;

	@Value("${wx_lite_AppSecret}")
	private String wx_lite_appsecret;

	@Value("${weixin_lite_partnerkey}")
	private String wx_lite_partnerkey;

	@Value("${weixin_lite_mchid}")
	private String wx_lite_mch_id;

	@Value("${weixin_lite_notify_url}")
	private String wx_lite_notify_url;

	@Value("${wx_pub_appid}")
	private String wx_pub_appid;

	@Value("${wx_pub_appsecret}")
	private String wx_pub_appsecret;

	@Value("${wx_pub_partnerkey}")
	private String wx_pub_partnerkey;

	@Value("${wx_pub_mch_id}")
	private String wx_pub_mch_id;

	@Value("${wx_pub_notify_url}")
	private String wx_pub_notify_url;
	
	@Value("${erqi_wx_app_secret}")
	private String erqi_wx_app_secret;
	
	@Value("${erqi_wx_app_id}")
	private String erqi_wx_app_id;
	
	@Value("${erqi_wx_partner_key}")
	private String erqi_wx_partner_key;
	
	@Value("${erqi_wx_mch_id}")
	private String erqi_wx_mch_id;
	
	@Value("${erqi_wx_notify_url}")
	private String erqi_wx_notify_url;
	
	
	
	

	@Value("${wx_AppID}")
	private String wx_appid;

	@Value("${wx_AppSecret}")
	private String wx_appsecret;

	@Value("${weixin_partnerkey}")
	private String wx_partnerkey;

	@Value("${weixin_mchid}")
	private String wx_mch_id;

	@Value("${weixin_pub_notify_url}")
	private String wx_notify_url;

	@Value("${alipay_pid}")
	private String alipay_pid;
	
	@Value("${alipay_app_id}")
	private String alipay_app_id;

	@Value("${alipay_private_key}")
	private String alipay_private_key;

	@Value("${alipay_public_key}")
	private String alipay_public_key;

	@Value("${alipay_notify_url}")
	private String alipay_notify_url;

	@Value("${alipay_return_url}")
	private String alipay_return_url;
	

	@Value("${erqi_alipay_app_id}")
	private String erqi_alipay_app_id;

	@Value("${erqi_alipay_private_key}")
	private String erqi_alipay_private_key;

	@Value("${erqi_alipay_public_key}")
	private String erqi_alipay_public_key;

	@Value("${erqi_alipay_notify_url}")
	private String erqi_alipay_notify_url;
	
	
	
	
	@Value("${is_real_pay}")
	private String is_real_pay;

	@Value("${img_path}")
	private String img_path;

	@Value("${kd100_key}")
	private String kd100_key;

	@Value("${kd100_customer}")
	private String kd100_customer;
	
	@Value("${haiguan_code}")
	private String haiguan_code;
	
	@Value("${merchant_customs_code}")
	private String merchant_customs_code;

	@Value("${merchant_customs_name}")
	private String merchant_customs_name;


	@Override
	public Object updateOrderMerchants(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		int num=orderDao.updateOrderMerchants(orderMerchantsBean);
		if (num <=0) {
			throw new AppException("订单海关状态更新失败!");
		}
		return num;
	}
	
	
	@Override
	public Object getDeivceSales(DeviceBean deviceBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> maps = orderDao.getDeivceSales(deviceBean, pageBean);
		return pageBean.setObject(maps);
	}

	@Override
	public Object getOrderLogisticsDetails(OrderLogisticsBean orderLogisticsBean) {
		// TODO Auto-generated method stub
		OrderLogisticsBean orderLogisticsBean2 = orderDao.getOrderLogistics(orderLogisticsBean);
		if (orderLogisticsBean2 != null) {
			OrderAddressBean orderAddressBean = orderDao
					.getOrderAddressDetail(new OrderAddressBean().setOrder_id(orderLogisticsBean2.getOrder_id()));
			orderLogisticsBean2.setOrderAddressBean(orderAddressBean);

			List<OrderLogisticsDetailBean> orderLogisticsDetailBeans = orderDao.getOrderLogisticsDetails(
					new OrderLogisticsDetailBean().setLogistics_no(orderLogisticsBean2.getLogistics_no()));

			orderLogisticsBean2.setOrderLogisticsDetailBeans(orderLogisticsDetailBeans);
		}
		return orderLogisticsBean2;
	}

	@Override
	public Object timeOrderLogistics() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> maps = orderDao.getLogisticsOrders();
		if (maps == null) {
			throw new AppException("无订单!");
		}
		for (int i = 0; i < maps.size(); i++) {
			Map<String, Object> map = maps.get(i);

			String logistics_state = map.get("logistics_state") + "";
			String logistics_time = "";
			String order_state = map.get("order_state") + "";

			Map<String, Object> resultMap = kd100Utils.getLogisticss(kd100_key, kd100_customer,
					map.get("logistics_pinyin") + "", map.get("logistics_no") + "");

			if (resultMap != null) {
				logistics_state = resultMap.get("state") + "";

				int count = orderDao
						.getLogisticsCount(new OrderLogisticsBean().setLogistics_no(map.get("logistics_no") + ""));

				List<OrderLogisticsDetailBean> orderLogisticsDetailBeans = new ArrayList<OrderLogisticsDetailBean>();

				List<Map<String, Object>> logisticsMaps = (List<Map<String, Object>>) resultMap.get("data");

				if (logisticsMaps.size() > 0) {
					logistics_time = logisticsMaps.get(logisticsMaps.size() - 1).get("ftime") + "";
				}
				for (int j = count; j < logisticsMaps.size(); j++) {
					Map<String, Object> logMap = logisticsMaps.get(j);
					OrderLogisticsDetailBean logisticBean = new OrderLogisticsDetailBean();
					logisticBean.setLogistics_context(logMap.get("context") + "")
							.setLogistics_time(logMap.get("ftime") + "").setLogistics_no(map.get("logistics_no") + "");
					orderLogisticsDetailBeans.add(logisticBean);
				}

				if (orderLogisticsDetailBeans != null && orderLogisticsDetailBeans.size() > 0) {
					int num = orderDao.insertOrderLogisticsDetails(orderLogisticsDetailBeans);
					if (num <= 0) {
						throw new AppException("插入物流详情失败");
					}
				}

				if ("3".equals(logistics_state)) {
					OrderMerchantsBean orderMerchantsBean = new OrderMerchantsBean()
							.setOrder_merchants_id(NumberUtils.Integer(map.get("order_merchants_id") + ""))
							.setLogistics_time(logistics_time);

					if (order_state.equals("wait_receive")) {
						orderMerchantsBean.setOrder_state("wait_assessment");
					}
					orderDao.updateOrderMerchants(orderMerchantsBean);
				}

				orderDao.updateOrderLogistics(new OrderLogisticsBean()
						.setLogistics_order_id(NumberUtils.Integer(map.get("logistics_order_id") + ""))
						.setLogistics_state(logistics_state));
			}

		}
		return "成功";
	}

	@Override
	public Object timingCancelOrder() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> orderMaps = orderDao.getCancelOrders();
		if (orderMaps == null) {
			throw new AppException("无订单!");
		}

		for (int i = 0; i < orderMaps.size(); i++) {
			Map<String, Object> orderMap = orderMaps.get(i);
			try {
				cancelOrder(new OrderBean().setOrder_id(NumberUtils.Integer(orderMap.get("order_id") + ""))
						.setMember_id(orderMap.get("member_id") + ""));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return null;
	}

	@Override
	public Object timingCancelGroupOrder() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> groupMaps = orderDao.getCancelGroupOrders();
		if (groupMaps == null) {
			throw new AppException("无订单!");
		}
		int num = 0;
		for (int i = 0; i < groupMaps.size(); i++) {
			Map<String, Object> groupMap = groupMaps.get(i);

			num = orderDao.timingCancelGroupOrder(new OrderMerchantsBean()
					.setOrder_merchants_id(NumberUtils.Integer(groupMap.get("order_merchants_id") + "")));
			if (num <= 0) {
				throw new AppException("取消失败");
			}

			num = orderDao.cancelProductStock(new OrderMerchantsBean()
					.setOrder_merchants_id(NumberUtils.Integer(groupMap.get("order_merchants_id") + "")));
			if (num <= 0) {
				throw new AppException("库存更新失败");
			}

			num = orderDao.cancelProductSales(new OrderMerchantsBean()
					.setOrder_merchants_id(NumberUtils.Integer(groupMap.get("order_merchants_id") + "")));
			if (num <= 0) {
				throw new AppException("销量更新失败");
			}

			num = memberDao.insertMemberBill(new MemberBillBean().setMember_id(groupMap.get("member_id") + "")
					.setBill_type("7").setBill_desc("余额提现申请").setBill_value(groupMap.get("order_actual_price") + ""));
			if (num <= 0) {
				throw new AppException("账号明细入库失败!");
			}

			Double order_actual_price = NumberUtils.Double(groupMap.get("order_actual_price") + "");
			Double refund_price = order_actual_price;
			if (order_actual_price > 0) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("out_trade_no", groupMap.get("out_trade_no"));
				map.put("refund_no", NumberUtils.createRandom(false, 19));

				if ("wx".equals(groupMap.get("pay_way"))) {
					map.put("path", img_path + "apiclient_cert.p12");
					map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(refund_price * 100) : 1);
					map.put("refund_fee",
							"1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_actual_price * 100) : 1);
					map.put("wx_appid", wx_appid);
					map.put("wx_appsecret", wx_appsecret);
					map.put("wx_partnerkey", wx_partnerkey);
					map.put("wx_mch_id", wx_mch_id);
					Map<String, Object> resultMap = PayUtils.wxAppRefund(map);
					if ("error".equals(resultMap.get("status"))) {
						throw new AppException(resultMap.get("error") + "");
					}
				} else if ("wx_lite".equals(groupMap.get("pay_way"))) {
					map.put("path", img_path + "wx_lite.p12");
					map.put("refund_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(refund_price * 100) : 1);
					map.put("total_fee",
							"1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_actual_price * 100) : 1);
					map.put("wx_appid", wx_lite_appid);
					map.put("wx_appsecret", wx_lite_appsecret);
					map.put("wx_partnerkey", wx_lite_partnerkey);
					map.put("wx_mch_id", wx_lite_mch_id);
					Map<String, Object> resultMap = PayUtils.wxAppRefund(map);
					if ("error".equals(resultMap.get("status"))) {
						throw new AppException(resultMap.get("error") + "");
					}
				} else if ("alipay".equals(groupMap.get("pay_way"))) {
					map.put("alipay_app_id", alipay_app_id);
					map.put("alipay_private_key", alipay_private_key);
					map.put("alipay_public_key", alipay_public_key);
					map.put("refund_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(refund_price, 2) : 0.01);
					Map<String, Object> resultMap = PayUtils.alipayRefund(map);
					if ("error".equals(resultMap.get("status"))) {
						throw new AppException(resultMap.get("error") + "");
					}
				}
			}

		}
		return "成功";
	}

	@Override
	public Object getOrderGroupDetail(OrderGroupBean orderGroupBean) {
		// TODO Auto-generated method stub
		Map<String, Object> map = orderDao.getOrderGroupDetail(orderGroupBean);
		if (map != null) {
			List<Map<String, Object>> memberBeans = orderDao
					.getOrderGroupMembers(new OrderGroupBean().setMember_id(map.get("member_id") + "")
							.setOrder_group_id(NumberUtils.Integer(map.get("order_group_id") + "")));
			map.put("memberBeans", memberBeans);
		}
		return map;
	}

	@Override
	public Object getOrderGroups(OrderGroupBean orderGroupBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> orderMerchantsBeans = orderDao.getOrderGroups(orderGroupBean, pageBean);
		for (int i = 0; i < orderMerchantsBeans.size(); i++) {
			Map<String, Object> orderBean2 = orderMerchantsBeans.get(i);
			List<OrderProductBean> orderProductBeans = orderDao
					.getOrderProducts(new OrderProductBean().setOrder_merchants_id(orderBean2.get("order_id") + ""));
			orderBean2.put("orderProductBeans", orderProductBeans);
		}
		return pageBean.setObject(orderMerchantsBeans);
	}

	@Override
	public Object getProductGroups(OrderGroupBean orderGroupBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> maps = orderDao.getProductGroups(orderGroupBean, pageBean);

		return pageBean.setObject(maps);
	}

	@Override
	public Object assessmentProduct(OrderAssessmentBean orderAssessmentBean) {
		Set<String> sensitiveWord = RedisUtils.getSetList("sensitive");
		for(String s : sensitiveWord){
			if(orderAssessmentBean.getAssessment_desc().contains(s)){
				throw new AppException("评论内容含敏感词汇！");
			}
		}
		// TODO Auto-generated method stub
		int num = orderDao.insertOrderAssessement(orderAssessmentBean);
		if (num <= 0) {
			throw new AppException("评价失败");
		}

		num = orderDao.assessmentProduct(orderAssessmentBean);
		if (num <= 0) {
			throw new AppException("评价失败!");
		}
		return num;
	}

	@Override
	public Object getOrderAssessmentDetail(OrderAssessmentBean orderAssessmentBean) {
		// TODO Auto-generated method stub
		return orderDao.getOrderAssessmentDetail(orderAssessmentBean);
	}

	@Override
	public Object getAssessmentProducts(OrderBean orderBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<OrderProductBean> orderProductBeans = orderDao.getAssessmentProducts(orderBean);
		return pageBean.setObject(orderProductBeans);
	}

	@Override
	public Object deleteOrder(OrderBean orderBean) {
		// TODO Auto-generated method stub
		int num = orderDao.deleteOrder(orderBean);
		if (num <= 0) {
			throw new AppException("删除失败");
		}
		return num;
	}

	@Override
	public Object receiveOrder(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		OrderMerchantsBean orderMerchantsBean2 = orderDao.getOrderMerchantsDetail(
				new OrderMerchantsBean().setOrder_merchants_id(NumberUtils.Integer(orderMerchantsBean.getOrder_id())));
		if (orderMerchantsBean2 == null) {
			throw new AppException("订单不存在");
		}

		if (!("wait_receive".equals(orderMerchantsBean2.getOrder_state()))) {
			throw new AppException("此订单不可确认收货!");
		}

		int num = orderDao.receiveOrder(
				new OrderMerchantsBean().setOrder_merchants_id(NumberUtils.Integer(orderMerchantsBean.getOrder_id()))
						.setMember_id(orderMerchantsBean.getMember_id()));
		if (num <= 0) {
			throw new AppException("确认失败!");
		}
		return num;
	}

	@Override
	public Object cancelOrder(OrderBean orderBean) {
		// TODO Auto-generated method stub
		OrderBean orderBean2 = orderDao.getOrderDetail(orderBean);
		if (orderBean2 == null) {
			throw new AppException("订单不存在");
		}
		if (!"wait_pay".equals(orderBean2.getOrder_state())) {
			throw new AppException("非代付款订单!");
		}

		int num = orderDao.cancelOrder(orderBean);
		if (num <= 0) {
			throw new AppException("取消失败!");
		}

		num = orderDao.cancelOrderMerchants(new OrderMerchantsBean().setOrder_id(orderBean2.getOrder_id() + "")
				.setMember_id(orderBean.getMember_id()));
		if (num <= 0) {
			throw new AppException("取消失败");
		}

		num = orderDao.cancelProductStock(new OrderMerchantsBean().setOrder_id(orderBean2.getOrder_id() + ""));
		if (num <= 0) {
			throw new AppException("库存更新失败");
		}

		return num;
	}

	@Override
	public Object getOrderDetail(OrderBean orderBean) {
		// TODO Auto-generated method stub
		Map<String, Object> orderBean2 = orderDao.getOrderMap(orderBean);
		if (orderBean2 != null) {
			OrderAddressBean orderAddressBean = null;
			List<OrderProductBean> orderProductBeans = null;
			if ("wait_pay".equals(orderBean2.get("order_state")) || "cancel".equals(orderBean2.get("order_state"))) {
				orderAddressBean = orderDao
						.getOrderAddressDetail(new OrderAddressBean().setOrder_id(orderBean2.get("order_id") + ""));

				orderProductBeans = orderDao
						.getOrderProducts(new OrderProductBean().setOrder_id(orderBean2.get("order_id") + ""));
			} else {
				orderAddressBean = orderDao
						.getOrderAddressDetail(new OrderAddressBean().setOrder_id(orderBean2.get("order_id2") + ""));
				orderProductBeans = orderDao.getOrderProducts(
						new OrderProductBean().setOrder_merchants_id(orderBean2.get("order_id") + ""));
			}
			if ("group".equals(orderBean2.get("order_type") + "")) {
				Object object = getOrderGroupDetail(new OrderGroupBean()
						.setOrder_group_id(NumberUtils.Integer(orderBean2.get("order_group_id") + "")));
				orderBean2.put("orderGroupBean", object);
			}

			orderBean2.put("orderAddressBean", orderAddressBean);
			orderBean2.put("orderProductBeans", orderProductBeans);
		}
		return orderBean2;
	}

	@Override
	public Object getOrders(OrderBean orderBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> orderBeans = orderDao.getOrders(orderBean, pageBean);
		if (orderBeans != null) {
			for (int i = 0; i < orderBeans.size(); i++) {
				Map<String, Object> orderBean2 = orderBeans.get(i);
				List<OrderProductBean> orderProductBeans = null;
				if ("wait_pay".equals(orderBean2.get("order_state"))
						|| "cancel".equals(orderBean2.get("order_state"))) {
					orderProductBeans = orderDao
							.getOrderProducts(new OrderProductBean().setOrder_id(orderBean2.get("order_id") + "")
									.setMember_id(orderBean.getMember_id()));
				} else {
					orderProductBeans = orderDao.getOrderProducts(
							new OrderProductBean().setOrder_merchants_id(orderBean2.get("order_id") + "")
							.setMember_id(orderBean.getMember_id()));
				}

				orderBean2.put("orderProductBeans", orderProductBeans);
			}
		}
		return pageBean.setObject(orderBeans);
	}

	@Override
	public Object payGoodsCallback(OrderBean orderBean, String pay_password) {
		// TODO Auto-generated method stub
		OrderBean orderBeanTemp = orderDao.getOrderPayDetail(orderBean);
		if (orderBeanTemp != null) {
			orderBean.setOrder_id(orderBeanTemp.getOrder_id()).setOut_trade_no("");
		}

		OrderBean orderBean2 = orderDao.getOrderDetail(orderBean);
		if (orderBean2 == null) {
			throw new AppException("订单不存在!");
		}

		if (!"wait_pay".equals(orderBean2.getOrder_state())) {
			throw new AppException(orderBean.getOut_trade_no() + "非代付款订单!" + orderBean2.getOrder_id());
		}

		String order_state = "wait_send";
		if ("device".equals(orderBean2.getOrder_type())) {// 售货机订单
			order_state = "end";
		}
		
		int num = orderDao.payOrder(new OrderBean().setOrder_id(orderBean2.getOrder_id())
				.setMember_id(orderBean2.getMember_id())
				.setOrder_state(order_state)
				.setTrade_no(orderBean.getTrade_no()));
		if (num <= 0) {
			throw new AppException("付款失败!");
		}

		num = orderDao.payOrderMerchants(new OrderMerchantsBean().setOrder_id(orderBean2.getOrder_id() + "")
				.setMember_id(orderBean2.getMember_id()).setOrder_state(order_state));
		if (num <= 0) {
			throw new AppException("付款商家失败!");
		}

		if ("device".equals(orderBean2.getOrder_type())) {// 售货机订单
			num = orderDao.updateDeviceCargoStock(orderBean2);
			if (num <= 0) {
				throw new AppException("库存更新失败!");
			}

			DeviceReplenishmentBatchBean deviceReplenishmentBatchBean = orderDao
					.getDeviceReplenishmentBatch(orderBean2);
			if (deviceReplenishmentBatchBean == null) {
				throw new AppException("批次不存在!");
			}

			num = orderDao.insertOrderProductBatch(
					new OrderProductBatchBean().setBatch_id(deviceReplenishmentBatchBean.getBatch_id())
							.setBatch_no(deviceReplenishmentBatchBean.getBatch_no())
							.setBatch_now_stock(deviceReplenishmentBatchBean.getBatch_now_stock()).setBatch_stock("1")
							.setBatch_price(deviceReplenishmentBatchBean.getBatch_price())
							.setPurchase_id(deviceReplenishmentBatchBean.getPurchase_id())
							.setOrder_id(orderBean2.getOrder_id() + "")
							.setReplenishment_batch_id(deviceReplenishmentBatchBean.getReplenishment_batch_id() + ""));
			if (num <= 0) {
				throw new AppException("产品批次入库失败!");
			}

			num = orderDao.updateDeviceReplenishmentBatch(deviceReplenishmentBatchBean);
			if (num <= 0) {
				throw new AppException("批次库存更新失败!");
			}
		} else {
			num = orderDao.updateProductSales(new OrderBean().setOrder_id(orderBean2.getOrder_id()));
			if (num <= 0) {
				throw new AppException("产品销量更新失败!");
			}
		}

		if ("group".equals(orderBean2.getOrder_type())) {// 团购订单
			num = orderDao.updateOrderGroup(
					new OrderGroupBean().setOrder_group_id(NumberUtils.Integer(orderBean2.getOrder_group_id())));
			if (num <= 0) {
				throw new AppException("团购失败!");
			}

		}

		if ("wx_lite".equals(orderBean2.getPay_way())) {// 线上商城小程序支付
			num = memberDao.insertMemberBill(new MemberBillBean().setMember_id(orderBean2.getMember_id())
					.setBill_type("1").setBill_desc("线上商城微信消费").setBill_value(orderBean2.getOrder_actual_price()));
			if (num <= 0) {
				throw new AppException("账号明细入库失败!");
			}
		} else if ("balance".equals(orderBean2.getPay_way())) {// 线上商城余额支付
			
			MemberBean memberBean=memberDao.getMemberDetail(new MemberBean()
					.setMember_id(NumberUtils.Integer(orderBean2.getMember_id())));
			if(memberBean==null){
				throw new AppException("用户不存在!");
			}
			double member_balance=NumberUtils.Double(memberBean.getMember_balance());
			double order_actual_price=NumberUtils.Double(orderBean2.getOrder_actual_price());
			if(member_balance<order_actual_price){
				throw new AppException("余额不足");
			}
			
			num=memberDao.updateMemberDetail(new MemberBean()
					.setMember_id(memberBean.getMember_id())
					.setMember_balance((member_balance-order_actual_price)+""));
			if (num <= 0) {
				throw new AppException("余额更新失败!");
			}
			
			num = memberDao.insertMemberBill(new MemberBillBean().setMember_id(orderBean2.getMember_id())
					.setBill_type("2").setBill_desc("线上商城余额消费").setBill_value(orderBean2.getOrder_actual_price()));
			if (num <= 0) {
				throw new AppException("账号明细入库失败!");
			}
		}
		
		if ("device".equals(orderBean2.getOrder_type())) {//
			haiguanOrder(new OrderMerchantsBean().setOrder_id(orderBean2.getOrder_id()+""));//海关订单入库
		}
		return num;
	}
	
	/**
	 * 海关下单
	 */
	public void haiguanOrder(OrderMerchantsBean orderMerchantsBean){
		List<Map<String, Object>> haiguanMaps=orderDao.getHaiguanOrders(orderMerchantsBean);
		if(haiguanMaps!=null){
			for (int i = 0; i < haiguanMaps.size(); i++) {
				Map<String, Object> map=haiguanMaps.get(i);
				String SenderId="50089609C5";//华龙用户名
				String password="50089609C";
				
				String ActionType="1";//
				
				String GUID=UUID.randomUUID().toString();
				
				
				String CUSTOMS_CODE="8013";//申报海关代码
				String BIZ_TYPE_CODE="I20";//业务类型
				String ORIGINAL_ORDER_NO=map.get("order_merchants_no")+"";//原始订单编号
				String ESHOP_ENT_CODE="50089609C5";//电商企业代码
				String ESHOP_ENT_NAME="重庆华龙百家科技发展有限公司";//电商企业名称
				
				String DESP_ARRI_COUNTRY_CODE="116";//起运国
				String SHIP_TOOL_CODE="Y";//运输方式
				
				
				String RECEIVER_ID_NO=map.get("realname_card")+"";//收货人身份证号码
				String RECEIVER_NAME=map.get("realname_name")+"";//收货人姓名
				String RECEIVER_ADDRESS=map.get("address_detailed")+"";//收货人地址
				String RECEIVER_TEL=map.get("realname_mobile")+"";//收货人电话
				
				
				String PROXY_ENT_CODE="";//代理企业代码
				String PROXY_ENT_NAME="";//代理企业名称
				String SORTLINE_ID="SORTLINE02";//分拣线ID
				
				
			  	String CC_TRADE_CODE="500666001T";//仓储企业代码
				String CC_TRADE_NAME="重庆丝路广序国际物流有限公司";//仓储企业名称
				String UNI_ESHOP_ENT_CODE="50122604QT";//联营电商代码
				String UNI_ESHOP_ENT_NAME="重庆圆通快递有限公司";//联营电商名称
				String CHECK_TYPE="R";//验证类型
				String SEND_ENT_CODE="50089609C5";//发送企业代码
				
				String BUYER_REG_NO=map.get("member_id")+"";//订购人注册号
				String BUYER_NAME=map.get("realname_name")+"";//订购人姓名
				String BUYER_ID_TYPE="1";//订购人证件类型
				String BUYER_ID=map.get("realname_card")+"";//订购人证件号码
				String DISCOUNT="0";//优惠减免金额
				String INSURED_FEE="0";//保费
				
				String EBP_CODE="50089609C5";//电商平台编码
				String EBP_NAME="重庆华龙百家科技发展有限公司";//电商平台名称
				String PAY_CODE="";//支付企业的海关注册
				String PAY_NAME="";//支付企业在海关注册登记的企业名称
				String BATCH_NUMBERS="";//商品批次号
				String CONSIGNEE_DISTRICT="";//参照国家统计局公布的国家行政区划标准填制。
				String NOTE="";//备注
				String BILL_NO="";//货物提单或运单的编号
				String TRANSACTION_ID="";//支付企业唯一的支付流水号
				String TRAF_NO="";//货物进出境的运输工具的名称或运输工具编号。填报内容应与运输部门向海关申报的载货清单所列相应内容一致；同报关单填制规范。
				String VOYAGE_NO="";//货物进出境的运输工具的航次编号
				String LOCT_NO="";//针对同一申报地海关下有多个跨境电子商务的监管场所,需要填写区分
				String LICENSE_NO="";//商务主管部门及其授权发证机关签发的进出口货物许可证件的编号
				String ASSURE_CODE="50089609C5";//担保扣税的企业海关注册登记编号，只限清单的电商平台企业、电商企业、物流企业。
				String GOODSINFO="";//配送的商品信息，包括商品名称、数量等
				String ORG_CODE="";//施检机构代码
				
				
				List<Map<String, Object>> goodsMaps=orderDao.getHaiguanOrderGoodss(new OrderProductGoodsBean()
						.setOrder_merchants_id(map.get("order_merchants_id")+""));
				
				double weight=0;
				String goods_sku="";
				
				double product_total_price=NumberUtils.KeepDecimal(map.get("order_actual_price")+"", 2);

				for (int j = 0; j < goodsMaps.size(); j++) {
					Map<String, Object> goodsMap=goodsMaps.get(j);
					String SKU=goodsMap.get("SKU")+"";//商品货号
					String GOODS_SPEC=goodsMap.get("GOODS_SPEC")+"";//规格型号
					String CURRENCY_CODE=goodsMap.get("CURRENCY_CODE")+"";//币制代码
					String PRICE=goodsMap.get("PRICE")+"";//商品单价
					String QTY=goodsMap.get("QTY")+"";//商品数量
					double GOODS_FEE2=NumberUtils.KeepDecimal(goodsMap.get("GOODS_FEE2")+"",2);//商品总价
					//product_total_price+=GOODS_FEE2;
					String TAX_FEE2=NumberUtils.subZeroAndDot(NumberUtils.KeepDecimal(GOODS_FEE2*0.091,2)+"");//税款金额
					String COUNTRY=goodsMap.get("COUNTRY")+"";//原产国
					String G_NUM=goodsMap.get("G_NUM")+"";//序号
					String BAR_CODE=goodsMap.get("BAR_CODE")+"";//国际通用的商品条形码，一般由前缀部分、制造厂商代码、商品代码和校验码组成
					String UNIT_CODE=goodsMap.get("UNIT_CODE")+"";//填写海关标准的参数代码，参照《JGS-20 海关业务代码集》- 计量单位代码。
					String NOTE2="";//备注
					String GOODS_NAME=goodsMap.get("GOODS_NAME")+"";
					String HS_CODE=goodsMap.get("HS_CODE")+"";//商品编码
					String UNIT2="";//第二单位
					String QTY2="";//第二数量
					weight+=NumberUtils.Double(goodsMap.get("record_reduced_num")+"")*NumberUtils.Integer(goodsMap.get("QTY")+"");
					goods_sku+="<ORDER_DETAIL>"
							+ "<SKU>"+SKU+"</SKU>"
							+ "<GOODS_SPEC>"+GOODS_SPEC+"</GOODS_SPEC>"
							+ "<CURRENCY_CODE>"+CURRENCY_CODE+"</CURRENCY_CODE>"
							+ "<PRICE>"+PRICE+"</PRICE>"
							+ "<QTY>"+QTY+"</QTY>"
							+ "<GOODS_FEE>"+GOODS_FEE2+"</GOODS_FEE>"
							+ "<TAX_FEE>"+TAX_FEE2+"</TAX_FEE>"
							+ "<COUNTRY>"+COUNTRY+"</COUNTRY>"
							+ "<G_NUM>"+G_NUM+"</G_NUM>"
							+ "<BAR_CODE>"+BAR_CODE+"</BAR_CODE>"
							+ "<UNIT_CODE>"+UNIT_CODE+"</UNIT_CODE>"
							+ "<NOTE>"+NOTE2+"</NOTE>"
							+ "<GOODS_NAME>"+GOODS_NAME+"</GOODS_NAME>"
							+ "<HS_CODE>"+HS_CODE+"</HS_CODE>"
							+ "<UNIT2>"+UNIT2+"</UNIT2>"
							+ "<QTY2>"+QTY2+"</QTY2>"
						+ "</ORDER_DETAIL>";
				}
				
				double freight_price=NumberUtils.KeepDecimal(map.get("freight_price")+"", 2);
				String TRANSPORT_FEE=NumberUtils.subZeroAndDot(freight_price+"");//运费
				
				String GOODS_FEE=NumberUtils.subZeroAndDot(product_total_price+"");//货款总额
				String TAX_FEE=NumberUtils.subZeroAndDot(NumberUtils.KeepDecimal(product_total_price*0.091,2)+"");//税金总额
				
				String ACTUAL_PAID=NumberUtils.subZeroAndDot(NumberUtils.KeepDecimal((product_total_price+product_total_price*0.091),2)+"");//实际支付金额

				String NET_WEIGHT=NumberUtils.KeepDecimal(weight,2)+"";//净重
				String GROSS_WEIGHT=NumberUtils.KeepDecimal(weight+0.3,2)+"";//毛重
				
				String xml=
						"<DTC_Message>"
						+ "<MessageHead>"
								+ "<MessageType>ORDER_INFO</MessageType>"
								+ "<MessageId>"+UUID.randomUUID().toString()+"</MessageId>"
								+ "<ActionType>1</ActionType>"
								+ "<MessageTime>"+TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss")+"</MessageTime>"
								+ "<SenderId>"+SenderId+"</SenderId>"
								+ "<ReceiverId>CQITC</ReceiverId>"
								+ "<SenderAddress>"
								+ "</SenderAddress>"
								+ "<ReceiverAddress>"
								+ "</ReceiverAddress>"
								+ "<PlatFormNo>"
								+ "</PlatFormNo>"
								+ "<CustomCode>"+CUSTOMS_CODE+"</CustomCode>"
								+ "<SeqNo>"
								+ "</SeqNo>"
								+ "<Note>"
								+ "</Note>"
								+ "<UserNo>"+SenderId+"</UserNo>"
								+ "<Password>"+password+"</Password>"
						+ "</MessageHead>"
						+ "<MessageBody>"
							+ "<DTCFlow>"
								+ "<ORDER_HEAD>"
									+ "<CUSTOMS_CODE>"+CUSTOMS_CODE+"</CUSTOMS_CODE>"
									+ "<BIZ_TYPE_CODE>"+BIZ_TYPE_CODE+"</BIZ_TYPE_CODE>"
									+ "<SORTLINE_ID>"+SORTLINE_ID+"</SORTLINE_ID>"
									+ "<ORIGINAL_ORDER_NO>"+ORIGINAL_ORDER_NO+"</ORIGINAL_ORDER_NO>"
									+ "<ESHOP_ENT_CODE>"+ESHOP_ENT_CODE+"</ESHOP_ENT_CODE>"
									+ "<ESHOP_ENT_NAME>"+ESHOP_ENT_NAME+"</ESHOP_ENT_NAME>"
									+ "<DESP_ARRI_COUNTRY_CODE>"+DESP_ARRI_COUNTRY_CODE+"</DESP_ARRI_COUNTRY_CODE>"
									+ "<SHIP_TOOL_CODE>"+SHIP_TOOL_CODE+"</SHIP_TOOL_CODE>"
									+ "<RECEIVER_ID_NO>"+RECEIVER_ID_NO+"</RECEIVER_ID_NO>"
									+ "<RECEIVER_NAME>"+RECEIVER_NAME+"</RECEIVER_NAME>"
									+ "<RECEIVER_ADDRESS>"+RECEIVER_ADDRESS+"</RECEIVER_ADDRESS>"
									+ "<RECEIVER_TEL>"+RECEIVER_TEL+"</RECEIVER_TEL>"
									+ "<GOODS_FEE>"+GOODS_FEE+"</GOODS_FEE>"
									+ "<TAX_FEE>"+TAX_FEE+"</TAX_FEE>"
									+ "<GROSS_WEIGHT>"+GROSS_WEIGHT+"</GROSS_WEIGHT>"
									+ "<PROXY_ENT_CODE>"+PROXY_ENT_CODE+"</PROXY_ENT_CODE>"
									+ "<PROXY_ENT_NAME>"+PROXY_ENT_NAME+"</PROXY_ENT_NAME>"
									+ "<TRANSPORT_FEE>"+TRANSPORT_FEE+"</TRANSPORT_FEE>"
									+ "<CC_TRADE_CODE>"+CC_TRADE_CODE+"</CC_TRADE_CODE>"
									+ "<CC_TRADE_NAME>"+CC_TRADE_NAME+"</CC_TRADE_NAME>"
									+ "<UNI_ESHOP_ENT_CODE>"+UNI_ESHOP_ENT_CODE+"</UNI_ESHOP_ENT_CODE>"
									+ "<UNI_ESHOP_ENT_NAME>"+UNI_ESHOP_ENT_NAME+"</UNI_ESHOP_ENT_NAME>"
									+ "<CHECK_TYPE>"+CHECK_TYPE+"</CHECK_TYPE>"
									+ "<SEND_ENT_CODE>"+SEND_ENT_CODE+"</SEND_ENT_CODE>"
									+ "<BUYER_REG_NO>"+BUYER_REG_NO+"</BUYER_REG_NO>"
									+ "<BUYER_NAME>"+BUYER_NAME+"</BUYER_NAME>"
									+ "<BUYER_ID_TYPE>"+BUYER_ID_TYPE+"</BUYER_ID_TYPE>"
									+ "<BUYER_ID>"+BUYER_ID+"</BUYER_ID>"
									+ "<DISCOUNT>"+DISCOUNT+"</DISCOUNT>"
									+ "<ACTUAL_PAID>"+ACTUAL_PAID+"</ACTUAL_PAID>"
									+ "<INSURED_FEE>"+INSURED_FEE+"</INSURED_FEE>"
									+ "<EBP_CODE>"+EBP_CODE+"</EBP_CODE>"
									+ "<EBP_NAME>"+EBP_NAME+"</EBP_NAME>"
									+ "<PAY_CODE>"+PAY_CODE+"</PAY_CODE>"
									+ "<PAY_NAME>"+PAY_NAME+"</PAY_NAME>"
									+ "<BATCH_NUMBERS>"+BATCH_NUMBERS+"</BATCH_NUMBERS>"
									+ "<CONSIGNEE_DISTRICT>"+CONSIGNEE_DISTRICT+"</CONSIGNEE_DISTRICT>"
									+ "<NOTE>"+NOTE+"</NOTE>"
									+ "<BILL_NO>"+BILL_NO+"</BILL_NO>"
									+ "<TRANSACTION_ID>"+TRANSACTION_ID+"</TRANSACTION_ID>"
									+ "<TRAF_NO>"+TRAF_NO+"</TRAF_NO>"
									+ "<VOYAGE_NO>"+VOYAGE_NO+"</VOYAGE_NO>"
									+ "<LOCT_NO>"+LOCT_NO+"</LOCT_NO>"
									+ "<LICENSE_NO>"+LICENSE_NO+"</LICENSE_NO>"
									+ "<ASSURE_CODE>"+ASSURE_CODE+"</ASSURE_CODE>"
									+ "<GOODSINFO>"+GOODSINFO+"</GOODSINFO>"
									+ "<ORG_CODE>"+ORG_CODE+"</ORG_CODE>"
									+ "<NET_WEIGHT>"+NET_WEIGHT+"</NET_WEIGHT>"
									+goods_sku
								+ "</ORDER_HEAD>"
							+ "</DTCFlow>"
						+ "</MessageBody>"
						+ "</DTC_Message>";
				HaiguanUtils.insertOrder(xml);
				
				//haiguanAlipay(map,goodsMaps);
				
				int num=orderDao.updateOrderMerchants(new OrderMerchantsBean()
						.setOrder_merchants_id(NumberUtils.Integer(map.get("order_merchants_id")+""))
						.setCross_border_state("1"));
				if (num <=0) {
					throw new AppException("订单海关状态更新失败!");
				}
				if("wx_pub".equals(map.get("pay_way")+"")||"wx_lite".equals(map.get("pay_way")+"")){
					haiguanWx(map);
				}else if("alipay".equals(map.get("pay_way")+"")){
					haiguanAlipay(map);
				}
				
			}
		}
	}
	

	public void haiguanWx(Map<String, Object> map) {
		try{
			String sign="";
			String appid=wx_pub_appid;//"wx180ca754d5cecf54";
			String mch_id=wx_pub_mch_id;//"1528445061";
			String out_trade_no=map.get("order_merchants_no")+"";//"g2242450667748720642679051";
			String transaction_id=map.get("trade_no")+"";//"4200000303201904253432806607";
			String customs="CHONGQING";
			String mch_customs_no=haiguan_code;
			String duty="";
			String action_type="";
			
			String cert_type="IDCARD";
			String cert_id=map.get("realname_card")+"";//"320723199102260611";
			String name=map.get("realname_name")+"";//"沈佳波";
			
			
	//		String sub_order_no="";
	//		String fee_type="CNY";
	//		String order_fee="";
	//		String transport_fee="";
	//		String product_fee="";
			
			String key="wvgvfuy6e17r67m6h6yp9axa1f7b4ca4";
			String wait_sign = "appid=" + appid 
					
					+ "&cert_id=" + cert_id 
					+ "&cert_type=" + cert_type 
					+ "&customs=" + customs 
	
					+ "&mch_customs_no=" + mch_customs_no 
					+ "&mch_id=" + mch_id 
					
					
					+ "&name=" + name
					
					+ "&out_trade_no=" + out_trade_no 
					+ "&transaction_id="+ transaction_id 
					+ "&key=" + key;
			System.out.println(wait_sign);
			String paySign = MD5Util.md5EncodeOrigin(wait_sign).toUpperCase();
			
			Map<String, String> parMap=new HashMap<String, String>();
			parMap.put("appid", appid);
			parMap.put("cert_id", cert_id);
			parMap.put("cert_type", cert_type);
			parMap.put("customs", customs);
			parMap.put("mch_id", mch_id);
			parMap.put("mch_customs_no", mch_customs_no);
			parMap.put("name", name);
			parMap.put("out_trade_no", out_trade_no);
			parMap.put("transaction_id", transaction_id);
			parMap.put("sign", paySign);
			String xmlParam=WXUtils.ArrayToXml(parMap);
			String result = HttpUtils.getDataByJson("https://api.mch.weixin.qq.com/cgi-bin/mch/customs/customdeclareorder", xmlParam);
			if(result!=null){
				Document doc=XmlUtils.getDocumentByXml(result);
				String return_code=XmlUtils.getValueByTagName(doc, "return_code");
				String result_code=XmlUtils.getValueByTagName(doc, "result_code");
				if("SUCCESS".equals(return_code)&&"SUCCESS".equals(result_code)){
					orderDao.updateOrderMerchants(new OrderMerchantsBean()
							.setOrder_merchants_id(NumberUtils.Integer(map.get("order_merchants_id")+""))
							.setCross_border_pay_state("1"));
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void haiguanAlipay(Map<String, Object> map){
		String service="alipay.acquire.customs";
		String partner=alipay_pid;
		String _input_charset="utf-8";
		String sign_type="MD5";
		String sign="";
		
		String out_request_no=map.get("order_merchants_no")+"";//"2241994716092563456";
		String trade_no=map.get("trade_no")+"";//"2019042422001403281028801790";//该交易在支付宝系统中的交易流水号，最长64位。

		
		String amount=map.get("order_actual_price")+"";//"0.01";
		String customs_place="zongshu";
		String is_split="T";
		String sub_out_biz_no=map.get("order_merchants_no")+"";//"2241994716092563456";//商户子订单号。拆单时由商户传入，且拆单时必须传入，否则会报INVALID_PARAMETER错误码。
		String buyer_name=map.get("realname_name")+"";//"沈佳波";//订购人姓名
		String buyer_id_no=map.get("realname_card")+"";//"320723199102260611";//订购人身份证号
		
		Map<String, String> sPara=new HashMap<String, String>();
		sPara.put("service", service);
		sPara.put("partner", partner);
		sPara.put("_input_charset", _input_charset);
		sPara.put("out_request_no", out_request_no);
		sPara.put("trade_no", trade_no);
		sPara.put("merchant_customs_code", merchant_customs_code);
		sPara.put("amount", amount);
		sPara.put("customs_place", customs_place);
		sPara.put("merchant_customs_name", merchant_customs_name);
		sPara.put("is_split", is_split);
		sPara.put("sub_out_biz_no", sub_out_biz_no);
		sPara.put("buyer_name", buyer_name);
		sPara.put("buyer_id_no", buyer_id_no);
		
		sPara.put("sign_type", sign_type);
		sPara.put("sign", sign);
		String result=AlipaySubmit.buildRequest(sPara,"post","确认提交");
		if(result!=null){
			Document doc=XmlUtils.getDocumentByXml(result);
			String is_success=XmlUtils.getValueByTagName(doc, "is_success");
			String result_code=XmlUtils.getValueByTagName(doc, "result_code");
			if("T".equals(is_success)&&"SUCCESS".equals(result_code)){
				orderDao.updateOrderMerchants(new OrderMerchantsBean()
						.setOrder_merchants_id(NumberUtils.Integer(map.get("order_merchants_id")+""))
						.setCross_border_pay_state("1"));
			}
		}
	}

	@Override
	public Object payRealOrder(OrderBean orderBean) {
		// TODO Auto-generated method stub
		OrderBean orderBean2 = orderDao.getOrderDetail(new OrderBean().setOrder_id(orderBean.getOrder_id()));
		if (orderBean2 == null) {
			throw new AppException("订单不存在!");
		}
		if (!"wait_pay".equals(orderBean2.getOrder_state())) {
			throw new AppException("非代付款订单!");
		}

		MemberBean memberBean = memberDao
				.getMemberDetail(new MemberBean().setMember_id(NumberUtils.Integer(orderBean.getMember_id())));

		double order_actual_price = NumberUtils.Double(orderBean2.getOrder_actual_price());
		String out_trade_no = "g" + orderBean2.getOrder_no() + NumberUtils.createRandom(true, 6) + "";// 商品支付单号
		orderBean.setOut_trade_no(out_trade_no);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("out_trade_no", out_trade_no);

		Map<String, String> wxMap = null;
		String result = "";
		if ("wx".equals(orderBean.getPay_way())) {
			map.put("notify_url", erqi_wx_notify_url);
			map.put("wx_appid", erqi_wx_app_id);
			map.put("wx_appsecret", erqi_wx_app_secret);
			map.put("wx_partnerkey", erqi_wx_partner_key);
			map.put("wx_mch_id", erqi_wx_mch_id);
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_actual_price * 100) : 1);// total_fee

			wxMap = PayUtils.wxPay(map);
			if (wxMap == null) {
				throw new AppException("凭证生成失败!");
			}

			orderBean.setPay_charge(JSON.toJSONString(wxMap));
		} else if ("alipay".equals(orderBean.getPay_way())) {
			map.put("alipay_app_id", erqi_alipay_app_id);
			map.put("alipay_private_key", erqi_alipay_private_key);
			map.put("alipay_public_key", erqi_alipay_public_key);
			map.put("notify_url", erqi_alipay_notify_url);
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_actual_price, 2) : 0.01);
			result = PayUtils.alipay(map);
			if (result == null) {
				throw new AppException("凭证生成失败!");
			}

			orderBean.setPay_charge(result);
		} else if ("alipay_h5".equals(orderBean.getPay_way())) {
			map.put("alipay_app_id", alipay_app_id);
			map.put("alipay_private_key", alipay_private_key);
			map.put("alipay_public_key", alipay_public_key);
			map.put("notify_url", alipay_notify_url);
			map.put("return_url", alipay_return_url);
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_actual_price, 2) : 0.01);
			result = PayUtils.alipayH5(map);
			if (result == null) {
				throw new AppException("凭证生成失败!");
			}

			orderBean.setPay_charge(result);
		} else if ("wx_pub".equals(orderBean.getPay_way())) {
			map.put("wx_pub_appid", wx_pub_appid);
			map.put("wx_pub_appsecret", wx_pub_appsecret);
			map.put("wx_pub_partnerkey", wx_pub_partnerkey);
			map.put("wx_pub_mch_id", wx_pub_mch_id);
			map.put("wx_pub_openid", memberBean.getWeixin_pub_open_id());
			map.put("wx_pub_notify_url", wx_pub_notify_url);
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_actual_price * 100) : 1);// total_fee
			wxMap = PayUtils.wxPubPay(map);
			if (wxMap == null) {
				throw new AppException("支付凭证生成失败!");
			}
			orderBean.setPay_charge(JSON.toJSONString(wxMap));
		} else if ("wx_lite".equals(orderBean.getPay_way())) {
			map.put("total_fee", 1);// total_fee
			map.put("wx_lite_appid", wx_lite_appid);
			map.put("wx_lite_appsecret", wx_lite_appsecret);
			map.put("wx_lite_partnerkey", wx_lite_partnerkey);
			map.put("wx_lite_mch_id", wx_lite_mch_id);
			map.put("wx_lite_openid", memberBean.getWeixin_lite_open_id());
			map.put("wx_lite_notify_url", wx_lite_notify_url);
			map.put("total_fee", "1".equals(is_real_pay) ? NumberUtils.KeepDecimal(order_actual_price * 100) : 1);// total_fee
			wxMap = PayUtils.wxLitePay(map);
			if (wxMap == null) {
				throw new AppException("支付凭证生成失败!");
			}
			orderBean.setPay_charge(JSON.toJSONString(wxMap));
		}else if ("balance".equals(orderBean.getPay_way())) {
			
		}

		int num = orderDao.updateOrder(orderBean);
		if (num <= 0) {
			throw new AppException("支付失败!");
		}

		num = orderDao.insertOrderPay(orderBean);
		if (num <= 0) {
			throw new AppException("支付记录入库失败");
		}

		num = orderDao.payRealOrderMerchants(
				new OrderMerchantsBean().setOrder_id(orderBean.getOrder_id() + "").setPay_way(orderBean.getPay_way()));

		if (num <= 0) {
			throw new AppException("支付失败");
		}

		if ("wx".equals(orderBean.getPay_way())) {
			return wxMap;
		} else if ("wx_pub".equals(orderBean.getPay_way())) {
			return wxMap;
		} else if ("wx_lite".equals(orderBean.getPay_way())) {
			return wxMap;
		} else if ("alipay".equals(orderBean.getPay_way())) {
			return result;
		} else if ("alipay_h5".equals(orderBean.getPay_way())) {
			return result;
		}else if ("balance".equals(orderBean.getPay_way())) {
			payGoodsCallback(orderBean, "");
			return "success";
		}
		return null;
	}

	@Override
	public Object insertOrder(OrderBean orderBean, String is_summit) {
		// TODO Auto-generated method stub
		String order_no = new UUIDUtils(0).nextId(false, 10) + "";
		String order_state = "wait_pay";

		int num = 0;
		if("1".equals(is_summit)){
			unpackOrder(orderBean);//拆单 分跨境 不跨境订单
		}
		
		
		ShopBean shopBean = productDao
				.getShopDetail(new ShopBean().setShop_id(NumberUtils.Integer(orderBean.getShop_id())));
		if (shopBean != null) {
			orderBean.setShop_name(shopBean.getShop_name());
		}

		if ("1".equals(is_summit)) {
			if (orderBean.getCar_ids() != null && !"".equals(orderBean.getCar_ids())) {
				num = productCarDao.deleteProductCar(new ProductCarBean().
						setCar_ids(orderBean.getCar_ids()).setMember_id(orderBean.getMember_id()));
			}
			
			num = orderDao.insertOrder(orderBean.setOrder_no(order_no).setOrder_state(order_state));
			if (num <= 0) {
				throw new AppException("订单添加失败!");
			}
		}
		insertOrderAddress(orderBean, is_summit);// 添加订单地址
		insertOrderMerchants(orderBean, is_summit);// 添加订单明细

		if ("1".equals(is_summit)) {
			num = orderDao.updateOrder(orderBean);
			if (num <= 0) {
				throw new AppException("订单修改失败!");
			}
		}
		return orderBean;
	}

	/**
	 * 订单拆弹
	 * @param orderBean
	 */
	public void unpackOrder(OrderBean orderBean) {
		List<OrderMerchantsBean> orderMerchantsBeans = orderBean.getOrderMerchantsBeans();
		
		List<OrderMerchantsBean> orderMerchantsBeans2 = new ArrayList<OrderMerchantsBean>();
		for (int i = 0; i < orderMerchantsBeans.size(); i++) {
			OrderMerchantsBean orderMerchantsBean = orderMerchantsBeans.get(i);
			List<OrderProductBean> orderProductBeans = orderMerchantsBean.getOrderProductBeans();

			List<OrderProductBean> orderProductBeans1 = new ArrayList<OrderProductBean>();
			List<OrderProductBean> orderProductBeans2 = new ArrayList<OrderProductBean>();
			for (int j = 0; j < orderProductBeans.size(); j++) {
				OrderProductBean orderProductBean = orderProductBeans.get(j);
				ProductBean productBean = productDao.getProductDetail(
						new ProductBean().setProduct_id(NumberUtils.Integer(orderProductBean.getProduct_id())));
				if(productBean==null){
					throw new AppException("产品已不存在!");
				}
				if ("3".equals(productBean.getProduct_type())) {
					orderProductBeans2.add(orderProductBean);
				} else {
					orderProductBeans1.add(orderProductBean);
				}
			}

			if (orderProductBeans1.size() > 0) {
				OrderMerchantsBean orderMerchantsBean2=new OrderMerchantsBean();
				orderMerchantsBean2.setOrderProductBeans(orderProductBeans1)
					.setMerchants_id(orderMerchantsBean.getMerchants_id())
					.setIs_cross_border("0");
				orderMerchantsBeans2.add(orderMerchantsBean2);
			}

			if (orderProductBeans2.size() > 0) {
				OrderMerchantsBean orderMerchantsBean2=new OrderMerchantsBean();
				orderMerchantsBean2.setOrderProductBeans(orderProductBeans2)
					.setMerchants_id(orderMerchantsBean.getMerchants_id())
					.setIs_cross_border("1");
				orderMerchantsBeans2.add(orderMerchantsBean2);
			}
		}
		orderBean.setOrderMerchantsBeans(orderMerchantsBeans2);
	}

	/**
	 * 添加订单明细
	 */
	public void insertOrderMerchants(OrderBean orderBean, String is_summit) {
		List<OrderMerchantsBean> orderMerchantsBeans = orderBean.getOrderMerchantsBeans();
		if (orderMerchantsBeans == null || orderMerchantsBeans.size() <= 0) {
			throw new AppException("未提交任何订单");
		}

		double freight_price = 0;// 多商家邮费总金额
		double profit_price = 0;// 销售可得价格
		double product_total_price = 0;
		double merchants_order_actual_price = 0;// 多商家实际支付金额
		for (int i = 0; i < orderMerchantsBeans.size(); i++) {
			OrderMerchantsBean orderMerchantsBean = orderMerchantsBeans.get(i);
			orderMerchantsBean.setOrder_type(orderBean.getOrder_type());
			orderMerchantsBean.setDevice_no(orderBean.getDevice_no());
			orderMerchantsBean.setCargo_no(orderBean.getCargo_no());
			orderMerchantsBean.setShop_id(orderBean.getShop_id());
			orderMerchantsBean.setShop_name(orderBean.getShop_name());

			String order_merchants_no = new UUIDUtils(0).nextId(false, 10) + "";

			orderMerchantsBean.setMember_id(orderBean.getMember_id()).setOrder_id(orderBean.getOrder_id() + "")
					.setOrder_no(orderBean.getOrder_no()).setOrder_merchants_no(order_merchants_no)
					.setOrder_state(orderBean.getOrder_state());

			int num = 0;

			if ("1".equals(is_summit)) {
				num = orderDao.insertOrderMerchants(orderMerchantsBean);
				if (num <= 0) {
					throw new AppException("订单明细添加失败!");
				}
			}
			double order_total_price = 0;// 订单总金额
			double order_actual_price = 0;// 订单实际支付金额

			insertOrderProducts(orderBean, orderMerchantsBean, is_summit);// 添加订单产品
			order_total_price += NumberUtils.Double(orderMerchantsBean.getFreight_price())
					+ NumberUtils.Double(orderMerchantsBean.getProduct_total_price());
			order_actual_price += NumberUtils.Double(orderMerchantsBean.getFreight_price())
					+ NumberUtils.Double(orderMerchantsBean.getProduct_total_price());
			product_total_price += NumberUtils.Double(orderMerchantsBean.getProduct_total_price());
			profit_price += NumberUtils.Double(orderMerchantsBean.getProfit_price());
			freight_price += NumberUtils.Double(orderMerchantsBean.getFreight_price());
			merchants_order_actual_price += order_actual_price;
			if ("1".equals(is_summit)) {
				orderMerchantsBean.setOrder_total_price(order_total_price + "")
						.setOrder_actual_price(order_actual_price + "");

				num = orderDao.updateOrderMerchants(orderMerchantsBean);
				if (num <= 0) {
					throw new AppException("订单明细修改失败!");
				}
			}
		}

		orderBean.setOrder_actual_price(merchants_order_actual_price + "").setFreight_price(freight_price + "")
				.setProfit_price(profit_price + "").setProduct_total_price(product_total_price + "");
	}

	public void insertOrderProducts(OrderBean orderBean, OrderMerchantsBean orderMerchantsBean, String is_summit) {
		List<OrderProductBean> orderProductBeans = orderMerchantsBean.getOrderProductBeans();
		if (orderProductBeans == null || orderProductBeans.size() <= 0) {
			throw new AppException("未选择购买产品!");
		}

		int num = 0;

		double freight_price = 0;// 所有商品 计算的邮费
		double freight_max_price = 0;// 多个商品 取最大的基础邮费
		double merchants_product_total_price = 0;// 商家总商品金额
		double profit_price = 0;// 销售可得价格

		for (int i = 0; i < orderProductBeans.size(); i++) {
			OrderProductBean orderProductBean = orderProductBeans.get(i);
			double product_total_price = 0;// 产品总价
			double product_actual_price;// 用户实际支付计算出来的价格

			ProductBean productBean = orderDao.getProductDetail(
					new ProductBean().setProduct_id(NumberUtils.Integer(orderProductBean.getProduct_id())));
			if (productBean == null) {
				throw new AppException("产品不存在!");
			}

			ProductSpecificationBean productSpecificationBean = orderDao
					.getProductSpecificationDetail(new ProductSpecificationBean()
							.setSpecification_id(NumberUtils.Integer(orderProductBean.getSpecification_id())));
			if (productSpecificationBean == null) {
				throw new AppException("规格不存在!");
			}
			int specification_stock = NumberUtils.Integer(productSpecificationBean.getSpecification_stock());// 规格库存

			DeviceCargoBean deviceCargoBean = null;
			if ("device".equals(orderMerchantsBean.getOrder_type())) {// 售货机下单
				deviceCargoBean = orderDao.getDeviceCargoDetail(new DeviceCargoBean()
						.setCargo_no(orderBean.getCargo_no()).setDevice_id(orderBean.getDevice_no()));
				if (deviceCargoBean == null) {
					throw new AppException("货道不存在!");
				}
				specification_stock = NumberUtils.Integer(deviceCargoBean.getProduct_stock());
			}

			int product_count = NumberUtils.Integer(orderProductBean.getProduct_count());// 购买数量
			if (specification_stock < product_count) {
				throw new AppException("产品:" + productBean.getProduct_name() + "库存不足!");
			}

			if ("group".equals(orderMerchantsBean.getOrder_type())) {// 团购下单
				product_total_price = product_count * NumberUtils.Double(productSpecificationBean.getGroup_price());
				product_actual_price = product_count * NumberUtils.Double(productSpecificationBean.getGroup_price());
				merchants_product_total_price += product_count
						* NumberUtils.Double(productSpecificationBean.getGroup_price());
			} else {
				product_total_price = product_count
						* NumberUtils.Double(productSpecificationBean.getSpecification_price());
				product_actual_price = product_count
						* NumberUtils.Double(productSpecificationBean.getSpecification_price());
				merchants_product_total_price += product_count
						* NumberUtils.Double(productSpecificationBean.getSpecification_price());
			}
			profit_price += product_count * NumberUtils.Double(productSpecificationBean.getProfit_price());

			orderProductBean.setOrder_id(orderMerchantsBean.getOrder_id())
					.setOrder_merchants_id(orderMerchantsBean.getOrder_merchants_id() + "")
					.setProduct_name(productBean.getProduct_name()).setProduct_img(productBean.getProduct_img())
					.setProduct_volume(productBean.getProduct_volume())
					.setProduct_weight(productBean.getProduct_weight()).setFreight_id(productBean.getFreight_id())
					.setSpecification_name(productSpecificationBean.getSpecification_name())
					.setSpecification_stock(specification_stock + "")
					.setSpecification_img(productSpecificationBean.getSpecification_img())
					.setSpecification_price(productSpecificationBean.getSpecification_price())
					.setGroup_price(productSpecificationBean.getGroup_price())
					.setProduct_total_price(product_total_price + "").setProduct_actual_price(product_actual_price + "")
					.setProfit_price(productSpecificationBean.getProfit_price());

			if (!StringUtils.isNull(orderBean.getOrderAddressBean().getAddress_city())) {
				Map<String, Object> freightMap = orderDao
						.getProductFreightDetail(new FreightCityBean().setFreight_id(productBean.getFreight_id())
								.setCity_names(orderBean.getOrderAddressBean().getAddress_city()));

				if (freightMap != null) {// 商品未选择邮费 或者 设置的邮费已被删除
					orderProductBean.setFreight_type(freightMap.get("freight_type").toString());
					orderProductBean.setFreight_way(freightMap.get("freight_way").toString());
					if ("2".equals(freightMap.get("freight_way").toString())) {// 卖家承担运费

					} else if ("1".equals(freightMap.get("freight_way").toString())) {// 买家承担运费
						double freight_range = NumberUtils.Double(freightMap.get("freight_range").toString());
						double freight_base_price = NumberUtils.Double(freightMap.get("freight_price").toString());
						double freight_add_range = NumberUtils.Double(freightMap.get("freight_add_range").toString());
						double freight_add_price = NumberUtils.Double(freightMap.get("freight_add_price").toString());
						double free_range = freightMap.get("free_range") == null ? -1
								: NumberUtils.Double(freightMap.get("free_range").toString());

						orderProductBean.setFree_range(free_range + "");
						orderProductBean.setFreight_range(freight_range + "");
						orderProductBean.setFreight_price(freight_base_price + "");
						orderProductBean.setFreight_add_range(freight_add_range + "");
						orderProductBean.setFreight_add_price(freight_add_price + "");

						double freight_num = 0;// 物流的总计算的 数量/重量/一级
						if ("1".equals(freightMap.get("freight_type").toString())) {// 按件
							freight_num = product_count;// 等于商品购买数量
						} else if ("2".equals(freightMap.get("freight_type").toString())) {// 按重量
							freight_num = product_count * NumberUtils.Double(orderProductBean.getProduct_weight());
						} else if ("3".equals(freightMap.get("freight_type").toString())) {// 按体积
							freight_num = product_count * NumberUtils.Double(orderProductBean.getProduct_volume());
						}

						if (free_range == -1 || freight_num < free_range) {// 未设置该城市免邮
																			// 或者
																			// 不满足免邮条件
							if (freight_base_price > freight_max_price) {// 如果该商品的首件邮费高于其他商品
																			// 则替换最大基础邮费
								freight_max_price = freight_base_price;
							}

							int freight_coefficient = (int) Math.ceil(freight_num / freight_add_range);// 计算出
																										// 超出部分的倍数
																										// 向上取整
							freight_price += freight_coefficient * freight_add_price;

						}
					}
				}
			}

			if ("1".equals(is_summit)) {
				if ("device".equals(orderBean.getOrder_type())) {// 设备订单

				} else {
					num = orderDao.updateProductStock(new ProductSpecificationBean()
							.setSpecification_id(productSpecificationBean.getSpecification_id())
							.setSpecification_stock(product_count + ""));
					if (num <= 0) {
						throw new AppException("库存更新失败!");
					}
				}

				num = orderDao.insertOrderProduct(orderProductBean);
				if (num <= 0) {
					throw new AppException("邮费更新失败!");
				}

				orderDao.insertOrderProductGoodss(
						new OrderProductGoodsBean().setSpecification_id(orderProductBean.getSpecification_id())
								.setOrder_id(orderProductBean.getOrder_id())
								.setOrder_merchants_id(orderProductBean.getOrder_merchants_id())
								.setOrder_product_id(orderProductBean.getOrder_product_id() + ""));

				if ("group".equals(orderMerchantsBean.getOrder_type())) {// 团购下单
					if (StringUtils.isNull(orderBean.getOrder_group_id())) {// 自己创建团
						OrderGroupBean orderGroupBean = new OrderGroupBean().setMember_id(orderBean.getMember_id())
								.setProduct_id(productBean.getProduct_id() + "")
								.setNeed_count(productBean.getGroup_need_count())
								.setNeed_time(productBean.getGroup_need_time());
						num = orderDao.insertOrderGroup(orderGroupBean);
						if (num <= 0) {
							throw new AppException("团购创建失败!");
						}

						orderBean.setOrder_group_id(orderGroupBean.getOrder_group_id() + "");
						orderMerchantsBean.setOrder_group_id(orderGroupBean.getOrder_group_id() + "");
					} else {// 加入团
						orderMerchantsBean.setOrder_group_id(orderBean.getOrder_group_id());
					}

				}
			}
		}
		freight_price += freight_max_price;

		orderMerchantsBean.setProfit_price(profit_price + "");
		orderMerchantsBean.setFreight_price(freight_price + "");
		orderMerchantsBean.setProduct_total_price(merchants_product_total_price + "");
	}

	/**
	 * 添加订单地址
	 * 
	 * @param orderAddressBean
	 */
	public void insertOrderAddress(OrderBean orderBean, String is_summit) {
		if ("1".equals(is_summit) && !"device".equals(orderBean.getOrder_type())) {
			if (StringUtils.isNull(orderBean.getOrder_id() + "")) {
				throw new AppException("请先选择地址!");
			}
		}
		OrderAddressBean orderAddressBean = new OrderAddressBean();

		AddressBean addressBean = addressDao.getAddressDetail(new AddressBean()
				.setMember_id("device".equals(orderBean.getOrder_type())?"-1":orderBean.getMember_id())
				.setAddress_id("device".equals(orderBean.getOrder_type())?-1:NumberUtils.Integer(orderBean.getAddress_id())));
		if ("1".equals(is_summit) && !"device".equals(orderBean.getOrder_type()) && addressBean == null) {
			throw new AppException("地址不存在!");
		}

		if (addressBean != null) {
			orderAddressBean = new OrderAddressBean().setOrder_id(orderBean.getOrder_id() + "")
					.setAddress_city(addressBean.getAddress_city()).setAddress_country(addressBean.getAddress_country())
					.setAddress_detailed(addressBean.getAddress_detailed()).setAddress_id(orderBean.getAddress_id())
					.setAddress_latitude(addressBean.getAddress_latitude())
					.setAddress_longitude(addressBean.getAddress_longitude())
					.setAddress_mobile(addressBean.getAddress_mobile()).setAddress_name(addressBean.getAddress_name())
					.setAddress_province(addressBean.getAddress_province())
					.setAddress_road(addressBean.getAddress_road())
					.setAddress_zip_code(addressBean.getAddress_zip_code());
		}
		if(!"device".equals(orderBean.getOrder_type())){
			orderBean.setOrderAddressBean(orderAddressBean);
		}else{
			orderBean.setOrderAddressBean(new OrderAddressBean());
		}
		
		if ("1".equals(is_summit)) {
			int num = orderDao.insertOrderAddress(orderAddressBean);
			if (num <= 0) {
				throw new AppException("添加订单地址异常!");
			}
		}
	}
}