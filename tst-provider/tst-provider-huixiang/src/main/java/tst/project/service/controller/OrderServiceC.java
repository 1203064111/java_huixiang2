package tst.project.service.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.aspect.AppException;
import tst.project.bean.excel.ExcelBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.MemberBillBean;
import tst.project.bean.order.OrderAddressBean;
import tst.project.bean.order.OrderBean;
import tst.project.bean.order.OrderGroupBean;
import tst.project.bean.order.OrderLogisticsBean;
import tst.project.bean.order.OrderLogisticsCompanyBean;
import tst.project.bean.order.OrderMerchantsBean;
import tst.project.bean.order.OrderProductBean;
import tst.project.bean.order.OrderProductGoodsBean;
import tst.project.bean.product.DeviceBean;
import tst.project.bean.product.GoodsBatchBean;
import tst.project.bean.product.OrderProductBatchBean;
import tst.project.bean.product.ShopBean;
import tst.project.controller.IOrderServiceC;
import tst.project.dao.controller.DeviceDaoC;
import tst.project.dao.controller.GoodsDaoC;
import tst.project.dao.controller.MemberDaoC;
import tst.project.dao.controller.OrderDaoC;
import tst.project.page.PageBean;
import tst.project.service.interfaces.OrderService;
import tst.project.utils.ExcelUtils;
import tst.project.utils.NumberUtils;
import tst.project.utils.StringUtils;
import tst.project.utils.TimeUtils;

@Service
@Transactional(rollbackFor=Exception.class)
public class OrderServiceC implements IOrderServiceC{
	@Autowired
	OrderDaoC orderDaoC;
	
	@Autowired
	MemberDaoC memberDaoC;
	
	@Autowired
	DeviceDaoC deviceDaoC;
	
	@Autowired
	OrderService orderService;
	
	@Value("${img_path}")
	private String img_path;
	
	@Value("${img_url}")
	private String img_url;
	
	@Override
	public Object getPlatformStatistics() {
		// TODO Auto-generated method stub
		return orderDaoC.getPlatformStatistics();
	}
	
	@Override
	public Object getOrderLogisticsCompanys(OrderLogisticsCompanyBean orderLogisticsCompanyBean) {
		// TODO Auto-generated method stub
		return orderDaoC.getOrderLogisticsCompanys(orderLogisticsCompanyBean);
	}
	
	public Object getOrderLogisticsCompanys(OrderLogisticsCompanyBean orderLogisticsCompanyBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<OrderLogisticsCompanyBean> orderLogisticsCompanyBeans = orderDaoC
				.getOrderLogisticsCompanys(orderLogisticsCompanyBean, pageBean);
		return pageBean.setObject(orderLogisticsCompanyBeans);
	}

	public Object getOrderLogisticsCompanyDetail(OrderLogisticsCompanyBean orderLogisticsCompanyBean) {
		// TODO Auto-generated method stub
		OrderLogisticsCompanyBean orderLogisticsCompanyBean2 = orderDaoC
				.getOrderLogisticsCompanyDetail(orderLogisticsCompanyBean);
		return orderLogisticsCompanyBean2;
	}

	public Object insertOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean) {
		// TODO Auto-generated method stub
		int num = orderDaoC.insertOrderLogisticsCompany(orderLogisticsCompanyBean);
		if (num <= 0) {
			throw new AppException("添加失败");
		}
		return num;
	}

	public Object updateOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean) {
		// TODO Auto-generated method stub
		int num = orderDaoC.updateOrderLogisticsCompany(orderLogisticsCompanyBean);
		if (num <= 0) {
			throw new AppException("修改失败");
		}
		return num;
	}

	public Object deleteOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean) {
		// TODO Auto-generated method stub
		int num = orderDaoC.deleteOrderLogisticsCompany(orderLogisticsCompanyBean);
		if (num <= 0) {
			throw new AppException("删除失败");
		}
		return num;
	}
	
	
	@Override
	public Object getGoodsBatchs(GoodsBatchBean goodsBatchBean) {
		// TODO Auto-generated method stub
		return orderDaoC.getGoodsBatchs(goodsBatchBean);
	}
	
	@Override
	public Object sendStorehouse(OrderMerchantsBean orderMerchantsBean,OrderLogisticsBean orderLogisticsBean,
			List<OrderProductGoodsBean> orderProductGoodsBeans) {
		// TODO Auto-generated method stub
		OrderMerchantsBean orderMerchantsBean2 = orderDaoC.getOrderMerchantsDetail(orderMerchantsBean);
		if (orderMerchantsBean2 == null) {
			throw new AppException("订单不存在");
		}

	
		int num=orderDaoC.sendStorehouse(orderMerchantsBean);
		if(num<=0){
			throw new AppException("发货失败!");
		}
		
		num = orderDaoC.insertOrderLogistics(orderLogisticsBean.setOrder_id(orderMerchantsBean2.getOrder_id()));
		if (num <= 0) {
			throw new AppException("物流入库失败");
		}
		
		for (int i = 0; i < orderProductGoodsBeans.size(); i++) {
			OrderProductGoodsBean orderProductGoodsBean=orderProductGoodsBeans.get(i);
			
			List<OrderProductBatchBean> orderProductBatchBeans=orderProductGoodsBean.getOrderProductBatchBeans();
			
			
			if(orderProductBatchBeans==null){
				throw new AppException("请先选择商品批次!");
			}
			
			int goods_num=NumberUtils.Integer(orderProductGoodsBean.getGoods_num());
			int batch_total_stock=0;
			for (int j = 0; j < orderProductBatchBeans.size(); j++) {
				OrderProductBatchBean orderProductBatchBean=orderProductBatchBeans.get(j);
				int batch_now_stock=NumberUtils.Integer(orderProductBatchBean.getBatch_now_stock());
				int batch_stock=NumberUtils.Integer(orderProductBatchBean.getBatch_stock());
				batch_total_stock+=batch_stock;
				
				if(batch_now_stock<batch_stock){
					throw new AppException("批次库存不足!");
				}
				
				num=orderDaoC.insertOrderProductBatch(orderProductBatchBean
						.setOrder_merchants_id(orderProductGoodsBean.getOrder_merchants_id()+"")
						.setOrder_product_goods_id(orderProductGoodsBean.getOrder_product_goods_id()+"")
						.setOrder_id(orderProductGoodsBean.getOrder_id())
						.setOrder_product_id(orderProductGoodsBean.getOrder_product_id()));
				if(num<=0){
					throw new AppException("批次库存添加失败!");
				}
				
				num=orderDaoC.updateGoodsBatchStock(new GoodsBatchBean()
						.setBatch_id(NumberUtils.Integer(orderProductBatchBean.getBatch_id()))
						.setBatch_now_stock(batch_stock+""));
				if(num<=0){
					throw new AppException("批次库存更新失败!");
				}
			}
			if(goods_num!=batch_total_stock){
				throw new AppException("批次库存总数不等于发货数");
			}
		}
		
		
		if("1".equals(orderMerchantsBean2.getIs_cross_border())&&"1".equals(orderMerchantsBean.getIs_cross_border())){
			orderService.haiguanOrder(new OrderMerchantsBean()
					.setOrder_merchants_id(orderMerchantsBean2.getOrder_merchants_id()));
		}
		return num;
	}
	
	@Override
	public Object haiguanOrder(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		OrderMerchantsBean orderMerchantsBean2 = orderDaoC.getOrderMerchantsDetail(orderMerchantsBean);
		if (orderMerchantsBean2 == null) {
			throw new AppException("订单不存在");
		}

		
		if("1".equals(orderMerchantsBean2.getIs_cross_border())){
			orderService.haiguanOrder(new OrderMerchantsBean()
					.setOrder_merchants_id(orderMerchantsBean2.getOrder_merchants_id()));
		}
		return 1;
	}
	
	@Override
	public Object getOrderProductGoodss(OrderProductGoodsBean orderProductGoodsBean) {
		// TODO Auto-generated method stub
		return orderDaoC.getOrderProductGoodss(orderProductGoodsBean);
	}
	
	@Override
	public Object sendOrderMerchants(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		OrderMerchantsBean orderMerchantsBean2=orderDaoC.getOrderMerchantsDetail(orderMerchantsBean);
		if(!"wait_send".equals(orderMerchantsBean2.getOrder_state())){
			throw new AppException("此订单不可发货!");
		}
		
		if("group".equals(orderMerchantsBean2.getOrder_type())
				&&!"2".equals(orderMerchantsBean2.getGroup_state())){
			throw new AppException("此订单还未拼团成功!");
		}
		
		int num=orderDaoC.sendOrderMerchants(orderMerchantsBean);
		if(num<=0){
			throw new AppException("发货失败!");
		}
		
		if("device".equals(orderMerchantsBean2.getOrder_type())){
			DeviceBean deviceBean=deviceDaoC.getDeviceDetail(new DeviceBean().setDevice_no(orderMerchantsBean2.getDevice_no()));
			if(deviceBean!=null&&!StringUtils.isNull(deviceBean.getMember_id())){
				double profit_price=NumberUtils.Double(orderMerchantsBean2.getProfit_price());
				if(profit_price>0){
					num=memberDaoC.insertMemberBill(new MemberBillBean()
							.setMember_id(deviceBean.getMember_id())
							.setBill_type("3")
							.setBill_desc("售货机售卖获得")
							.setBill_value(profit_price+""));
					if (num <= 0) {
						throw new AppException("账号明细入库失败!");
					}
					
					num=memberDaoC.updateMemberBalance(new MemberBean()
							.setMember_id(NumberUtils.Integer(deviceBean.getMember_id()))
							.setMember_balance(profit_price+""));
					if (num <= 0) {
						throw new AppException("余额更新失败!");
					}
				}
			}
			
		}else{
			if(!StringUtils.isNull(orderMerchantsBean2.getShop_id())&&!"-1".equals(orderMerchantsBean2.getShop_id())){
				ShopBean shopBean=memberDaoC.getShopDetail(new ShopBean()
						.setShop_id(NumberUtils.Integer(orderMerchantsBean2.getShop_id())));
				if(shopBean!=null&&!StringUtils.isNull(shopBean.getMember_id())){
					double profit_price=NumberUtils.Double(orderMerchantsBean2.getProfit_price());
					if(profit_price>0){
						num=memberDaoC.insertMemberBill(new MemberBillBean()
								.setMember_id(shopBean.getMember_id())
								.setBill_type("4")
								.setBill_desc("线上商城售卖获得")
								.setBill_value(profit_price+""));
						if (num <= 0) {
							throw new AppException("账号明细入库失败!");
						}
						
						num=memberDaoC.updateMemberBalance(new MemberBean()
								.setMember_id(NumberUtils.Integer(shopBean.getMember_id()))
								.setMember_balance(profit_price+""));
						if (num <= 0) {
							throw new AppException("余额更新失败!");
						}
					}
				}
			}
		}
		
		
		return num;
	}
	
	
	@Override
	public Object getOrderMerchantsDetail(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		OrderMerchantsBean orderMerchantsBean2=orderDaoC.getOrderMerchantsDetail(orderMerchantsBean);
		if(orderMerchantsBean2!=null){
			OrderAddressBean orderAddressBean=orderDaoC.getOrderAddressDetail(new OrderAddressBean()
					.setOrder_id(orderMerchantsBean2.getOrder_id()));
			orderMerchantsBean2.setOrderAddressBean(orderAddressBean);
			
			List<OrderProductBean> orderProductBeans=orderDaoC.getOrderProducts(new OrderProductBean()
					.setOrder_merchants_id(orderMerchantsBean2.getOrder_merchants_id()+""));
			orderMerchantsBean2.setOrderProductBeans(orderProductBeans);
			
			OrderGroupBean orderGroupBean=orderDaoC.getOrderGroupDetail(new OrderGroupBean()
					.setOrder_group_id(NumberUtils.Integer(orderMerchantsBean2.getOrder_group_id())));
			orderMerchantsBean2.setOrderGroupBean(orderGroupBean);
		}
		return orderMerchantsBean2;
	}
	
	@Override
	public Object getOrderMerchants(OrderMerchantsBean orderMerchantsBean,PageBean pageBean) {
		// TODO Auto-generated method stub
		List<OrderMerchantsBean> orderMerchantsBeans=orderDaoC.getOrderMerchants(orderMerchantsBean, pageBean);
//		if(orderMerchantsBeans!=null){
//			for (int i = 0; i < orderMerchantsBeans.size(); i++) {
//				OrderMerchantsBean orderMerchantsBean2=orderMerchantsBeans.get(i);
//				OrderAddressBean orderAddressBean=orderDaoC
//						.getOrderAddressDetail(new OrderAddressBean().setOrder_id(orderMerchantsBean2.getOrder_id()));
//				orderMerchantsBean2.setOrderAddressBean(orderAddressBean);
//			}
//		}
		return pageBean.setObject(orderMerchantsBeans);
	}
	
	@Override
	public Object exportOrderMerchants(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> maps= orderDaoC.exportOrderMerchants(orderMerchantsBean);
		
		List<ExcelBean> excelBeans = new ArrayList<ExcelBean>();
		excelBeans.add(new ExcelBean().setName("订单号").setType("order_merchants_no"));
		excelBeans.add(new ExcelBean().setName("订单类型").setType("order_type_show"));
		excelBeans.add(new ExcelBean().setName("店铺名称").setType("shop_name"));
		excelBeans.add(new ExcelBean().setName("下单日期").setType("create_time"));
		
		excelBeans.add(new ExcelBean().setName("总金额").setType("order_total_price"));
		excelBeans.add(new ExcelBean().setName("实付金额").setType("order_actual_price"));
		excelBeans.add(new ExcelBean().setName("产品总价").setType("product_total_price"));
		
		excelBeans.add(new ExcelBean().setName("运费").setType("freight_price"));
		excelBeans.add(new ExcelBean().setName("佣金").setType("order_state_show"));
		
		String fileName = "财务统计"+TimeUtils.getCurrentTime("yyyyMMddHHmmss") + ".xls";
		boolean is_success = ExcelUtils.exportExcelMap(img_path+"/excel/"+fileName, excelBeans, maps);
		if(!is_success){
			throw new AppException("导出失败!");
		}
		
		return img_url+"/excel/"+fileName;
	}
}
