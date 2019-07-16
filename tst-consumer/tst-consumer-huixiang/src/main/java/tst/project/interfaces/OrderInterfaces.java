package tst.project.interfaces;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppController;
import tst.project.bean.order.OrderAssessmentBean;
import tst.project.bean.order.OrderBean;
import tst.project.bean.order.OrderGroupBean;
import tst.project.bean.order.OrderLogisticsBean;
import tst.project.bean.order.OrderMerchantsBean;
import tst.project.bean.product.DeviceBean;
import tst.project.bean.product.RecordBean;
import tst.project.controller.IRecordServiceC;
import tst.project.page.PageBean;
import tst.project.utils.Base64Utils;
import tst.project.utils.WXUtils;
import tst.project.utils.XmlUtils;

@Controller
@RequestMapping("/orderInterfaces/v1.0")
public class OrderInterfaces {
	@Autowired
	IOrderService orderService;
	
	@Autowired
	IRecordServiceC recordServiceC;
	
	/**
	 * 海关总署回调接口
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/zongshuhaiguanCallback")
	@AppController(isNeedPackage = false)
	public Object zongshuhaiguanCallback(String openReq,String sessionID,String serviceTime) throws Exception {
		Map<String, Object> reqMap=JSON.parseObject(openReq,Map.class);
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code", "10000");
		map.put("message", "");
		map.put("serviceTime",reqMap.get("serviceTime"));
		return map;
	}
	
	
	
	/**
	 * 重庆海关回调接口
	 * @param data
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/haiguanCallback")
	@AppController(isNeedPackage = false)
	public Object haiguanCallback(String data) throws Exception {	
		String xml=Base64Utils.decodeBase64(data);
		Document doc=XmlUtils.getDocumentByXml(xml);
		String RETN=XmlUtils.getValueByTagName(doc, "RETN");
		String BIZNO=XmlUtils.getValueByTagName(doc, "BIZNO");
		String MSGTYPE=XmlUtils.getValueByTagName(doc, "MSGTYPE");//KJDD:添加订单回调  
		
		String MessageType=XmlUtils.getValueByTagName(doc, "MessageType");
		String SKU=XmlUtils.getValueByTagName(doc, "SKU");
		String CIQ_STATUS_CODE=XmlUtils.getValueByTagName(doc, "CIQ_STATUS_CODE");
		String UserNo=XmlUtils.getValueByTagName(doc, "UserNo");
		
		if("KJDD".equals(MSGTYPE)){
			orderService.updateOrderMerchants(new OrderMerchantsBean()
					.setOrder_merchants_no(BIZNO)
					.setCross_border_state("0".equals(RETN)?"2":"3"));
		}else if("CB_CIQ_SKU_INFO_FB".equals(MessageType)){
			if("30".equals(CIQ_STATUS_CODE)||"130".equals(CIQ_STATUS_CODE)){
				recordServiceC.throughRecord(new RecordBean()
						.setRecord_sku(SKU)
						.setRecord_number(UserNo));
			}else{
				recordServiceC.refusedRecord(new RecordBean().setRecord_sku(SKU));
			}
		}
		return "success";
	}
	@RequestMapping("/getDeivceSales")
	@AppController(isPage=true)
	public Object getDeivceSales(DeviceBean deviceBean,PageBean pageBean) throws Exception {
		return orderService.getDeivceSales(deviceBean,pageBean);
	}
	
	@RequestMapping("/getOrderLogisticsDetails")
	@AppController(isVerToken=true)
	public Object getOrderLogisticsDetails(OrderLogisticsBean orderLogisticsBean) throws Exception {
		return orderService.getOrderLogisticsDetails(orderLogisticsBean);
	}
	
	@RequestMapping("/timeOrderLogistics")
	@AppController(isLog=false)
	public Object timeOrderLogistics() throws Exception {
		return orderService.timeOrderLogistics();
	}
	
	
	@RequestMapping("/timingCancelOrder")
	@AppController(isLog=false)
	public Object timingCancelOrder() throws Exception {
		return orderService.timingCancelOrder();
	}
	
	@RequestMapping("/timingCancelGroupOrder")
	@AppController(isLog=false)
	public Object timingCancelGroupOrder() throws Exception {
		return orderService.timingCancelGroupOrder();
	}
	
	
	@RequestMapping("/getOrderGroupDetail")
	@AppController
	public Object getOrderGroupDetail(OrderGroupBean orderGroupBean) throws Exception {
		return orderService.getOrderGroupDetail(orderGroupBean);
	}
	
	@RequestMapping("/getOrderGroups")
	@AppController(isVerToken=true,isPage=true)
	public Object getOrderGroups(OrderGroupBean orderGroupBean,PageBean pageBean) throws Exception {
		return orderService.getOrderGroups(orderGroupBean,pageBean);
	}
	
	@RequestMapping("/getProductGroups")
	@AppController(isPage=true)
	public Object getProductGroups(OrderGroupBean orderGroupBean,PageBean pageBean) throws Exception {
		return orderService.getProductGroups(orderGroupBean,pageBean);
	}
	
	@RequestMapping("/getOrderAssessmentDetail")
	@AppController(isVerToken = true)
	public Object getOrderAssessmentDetail(OrderAssessmentBean orderAssessmentBean) throws Exception {
		return orderService.getOrderAssessmentDetail(orderAssessmentBean);
	}
	
	@RequestMapping("/assessmentProduct")
	@AppController(isVerToken = true)
	public Object assessmentProduct(OrderAssessmentBean orderAssessmentBean) throws Exception {
		return orderService.assessmentProduct(orderAssessmentBean);
	}
	
	@RequestMapping("/getAssessmentProducts")
	@AppController(isVerToken = true,isPage=true)
	public Object getAssessmentProducts(OrderBean orderBean,PageBean pageBean) throws Exception {
		return orderService.getAssessmentProducts(orderBean,pageBean);
	}
	
	
	@RequestMapping("/deleteOrder")
	@AppController(isVerToken = true)
	public Object deleteOrder(OrderBean orderBean) throws Exception {
		return orderService.deleteOrder(orderBean);
	}

	
	@RequestMapping("/receiveOrder")
	@AppController(isVerToken = true)
	public Object receiveOrder(OrderMerchantsBean orderMerchantsBean) throws Exception {
		return orderService.receiveOrder(orderMerchantsBean);
	}
	
	@RequestMapping("/cancelOrder")
	@AppController(isVerToken = true)
	public Object cancelOrder(OrderBean orderBean) throws Exception {
		return orderService.cancelOrder(orderBean);
	}
	
	@RequestMapping("/getOrderDetail")
	@AppController(isVerToken = true)
	public Object getOrderDetail(OrderBean orderBean) throws Exception {
		return orderService.getOrderDetail(orderBean);
	}
	
	
	@RequestMapping("/getOrders")
	@AppController(isVerToken = true,isPage=true)
	public Object getOrders(OrderBean orderBean,PageBean pageBean) throws Exception {
		return orderService.getOrders(orderBean,pageBean);
	}
	
	/**
	 * 微信支付回调
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/wxCallback")
	@AppController(isNeedPackage = false)
	public Object wxpayMemberIntegralOrder(HttpServletRequest request) throws Exception {
		InputStream inStream = request.getInputStream();
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outSteam.write(buffer, 0, len);
		}
		outSteam.close();
		inStream.close();
		String resultStr = new String(outSteam.toByteArray(), "UTF-8");
		Map<String, String> resultMap = WXUtils.doXMLParse(resultStr);

		String out_trade_no = resultMap.get("out_trade_no");
		String transaction_id = resultMap.get("transaction_id");
		String sign = resultMap.get("sign");
		String return_code = resultMap.get("return_code");
		String cash_fee = resultMap.get("cash_fee");
		if(out_trade_no.indexOf("g")>=0){//产品支付成功回调
		    orderService.payGoodsCallback(new OrderBean()
		    		.setOrder_no(out_trade_no.substring(1,out_trade_no.length()-6))
		    		.setTrade_no(transaction_id),"");
		}
	    return "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
	}
	
	
	
	@RequestMapping("/payGoodsCallback")
	@AppController(isNeedPackage = false)
	public Object payGoodsCallback(OrderBean orderBean) throws Exception {
		orderService.payGoodsCallback(orderBean,"");
	    return "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
	}
	
	@RequestMapping("/alipayCallback")
	@AppController
	public Object alipayCallback(String out_trade_no,String trade_no,String trade_status) throws Exception {
		if("TRADE_SUCCESS".equals(trade_status)){//支付成功回调
			if(out_trade_no.indexOf("g")>=0){//商品支付成功回调
			    return orderService.payGoodsCallback(new OrderBean()
			    		.setOut_trade_no(out_trade_no)
			    		.setTrade_no(trade_no),"");
			}else{//充值
			    return orderService.payGoodsCallback(new OrderBean()
			    		.setOut_trade_no(out_trade_no)
			    		.setTrade_no(trade_no),"");
			}
		}else if("TRADE_CLOSED".equals(trade_status)){//退款成功回调
			return "ok";
		}else{
			return "ok";
		}
	}
	
	@RequestMapping("/payRealOrder")
	@AppController(isVerToken = true)
	public Object payRealOrder(OrderBean orderBean) throws Exception {
		return orderService.payRealOrder(orderBean);
	}
	
	@RequestMapping("/insertOrder")
	@AppController(isVerToken = true)
	public Object insertOrder(String json, String is_summit) throws Exception {
		OrderBean orderBean=JSON.parseObject(json,OrderBean.class);
		
		return orderService.insertOrder(orderBean, is_summit);
	}
}
