package tst.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppController;
import tst.project.bean.order.OrderLogisticsBean;
import tst.project.bean.order.OrderLogisticsCompanyBean;
import tst.project.bean.order.OrderMerchantsBean;
import tst.project.bean.order.OrderProductGoodsBean;
import tst.project.bean.product.GoodsBatchBean;
import tst.project.page.PageBean;
import tst.project.utils.StringUtils;
import tst.project.utils.TimeUtils;

@Controller
@RequestMapping("/orderController/v1.0")
public class OrderController {
	@Autowired
	IOrderServiceC orderServiceC;

	@RequestMapping("/getPlatformStatistics")
	@AppController(isVerSystemToken=true)
	public Object getPlatformStatistics() throws Exception{
		return orderServiceC.getPlatformStatistics();
	}
	
	@RequestMapping("/getOrderLogisticsCompanysNoPage")
	@AppController(isVerSystemToken=true)
	public Object getOrderLogisticsCompanysNoPage(OrderLogisticsCompanyBean orderLogisticsCompanyBean) throws Exception{
		return orderServiceC.getOrderLogisticsCompanys(orderLogisticsCompanyBean);
	}
	
	@RequestMapping("/getOrderLogisticsCompanys")
	@AppController(isVerSystemToken=true,isPage=true)
	public Object getOrderLogisticss(OrderLogisticsCompanyBean orderLogisticsCompanyBean
			,PageBean pageBean) throws Exception{
		return orderServiceC.getOrderLogisticsCompanys(orderLogisticsCompanyBean, pageBean);
	}
	
	@RequestMapping("/getOrderLogisticsCompanyDetail")
	@AppController(isVerSystemToken=true)
	public Object getOrderLogisticsCompanyDetail(OrderLogisticsCompanyBean orderLogisticsCompanyBean
			) throws Exception{
		return orderServiceC.getOrderLogisticsCompanyDetail(orderLogisticsCompanyBean);
	}
	
	@RequestMapping("/insertOrderLogisticsCompany")
	@AppController(isVerSystemToken=true)
	public Object insertOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean
			) throws Exception{
		return orderServiceC.insertOrderLogisticsCompany(orderLogisticsCompanyBean);
	}
	
	@RequestMapping("/updateOrderLogisticsCompany")
	@AppController(isVerSystemToken=true)
	public Object updateOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean
			) throws Exception{
		return orderServiceC.updateOrderLogisticsCompany(orderLogisticsCompanyBean);
	}
	
	@RequestMapping("/deleteOrderLogisticsCompany")
	@AppController(isVerSystemToken=true)
	public Object deleteOrderLogisticsCompany(OrderLogisticsCompanyBean orderLogisticsCompanyBean
			) throws Exception{
		return orderServiceC.deleteOrderLogisticsCompany(orderLogisticsCompanyBean);
	}
	
	
	@RequestMapping("/getGoodsBatchs")
	@AppController(isVerSystemToken = true)
	public Object getGoodsBatchs(GoodsBatchBean goodsBatchBean) throws Exception {
		return orderServiceC.getGoodsBatchs(goodsBatchBean);
	}
	
	@RequestMapping("/sendStorehouse")
	@AppController(isVerSystemToken = true)
	public Object sendStorehouse(OrderMerchantsBean orderMerchantsBean,OrderLogisticsBean orderLogisticsBean,String product_goodss) throws Exception {
		return orderServiceC.sendStorehouse(orderMerchantsBean,orderLogisticsBean,JSON.parseArray(product_goodss,OrderProductGoodsBean.class));
	}
	
	@RequestMapping("/haiguanOrder")
	@AppController(isVerSystemToken = true)
	public Object haiguanOrder(OrderMerchantsBean orderMerchantsBean) throws Exception {
		return orderServiceC.haiguanOrder(orderMerchantsBean);
	}
	
	@RequestMapping("/getOrderProductGoodss")
	@AppController(isVerSystemToken = true)
	public Object getOrderProductGoodss(OrderProductGoodsBean orderProductGoodsBean) throws Exception {
		return orderServiceC.getOrderProductGoodss(orderProductGoodsBean);
	}
	
	
	@RequestMapping("/sendOrderMerchants")
	@AppController(isVerSystemToken = true)
	public Object sendOrderMerchants(OrderMerchantsBean orderMerchantsBean) throws Exception {
		return orderServiceC.sendOrderMerchants(orderMerchantsBean);
	}
	
	@RequestMapping("/getOrderMerchantsDetail")
	@AppController(isVerSystemToken = true)
	public Object getOrderMerchantsDetail(OrderMerchantsBean orderMerchantsBean) throws Exception {
		return orderServiceC.getOrderMerchantsDetail(orderMerchantsBean);
	}
	
	
	
	@RequestMapping("/getOrderMerchants")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getOrderMerchants(OrderMerchantsBean orderMerchantsBean,String time_type,PageBean pageBean) throws Exception {
		if("1".equals(time_type)&&StringUtils.isNull(orderMerchantsBean.getStart_time())
				&&StringUtils.isNull(orderMerchantsBean.getEnd_time())){//今日订单
			String cur_time=TimeUtils.getCurrentTime("yyyy-MM-dd");
			orderMerchantsBean.setStart_time(cur_time+" 00:00:00");
			orderMerchantsBean.setEnd_time(cur_time+" 23:59:59");
		}
		return orderServiceC.getOrderMerchants(orderMerchantsBean,pageBean);
	}
	
	@RequestMapping("/exportOrderMerchants")
	@AppController(isVerSystemToken = true)
	public Object exportOrderMerchants(OrderMerchantsBean orderMerchantsBean,String time_type) throws Exception {
		if("1".equals(time_type)&&StringUtils.isNull(orderMerchantsBean.getStart_time())
				&&StringUtils.isNull(orderMerchantsBean.getEnd_time())){//今日订单
			String cur_time=TimeUtils.getCurrentTime("yyyy-MM-dd");
			orderMerchantsBean.setStart_time(cur_time+" 00:00:00");
			orderMerchantsBean.setEnd_time(cur_time+" 23:59:59");
		}
		return orderServiceC.exportOrderMerchants(orderMerchantsBean);
	}
}
