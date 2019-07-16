package tst.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppController;
import tst.project.bean.member.MemberDeviceBean;
import tst.project.bean.order.OrderMerchantsBean;
import tst.project.bean.product.DeviceBean;
import tst.project.bean.product.DeviceCargoBean;
import tst.project.bean.product.DeviceCargoLoadingBean;
import tst.project.bean.product.DeviceClerkBean;
import tst.project.bean.product.DeviceReplenishmentBean;
import tst.project.bean.product.DeviceReplenishmentCargoBean;
import tst.project.bean.product.ProductBean;
import tst.project.interfaces.IDeviceService;
import tst.project.page.PageBean;
import tst.project.utils.NumberUtils;
@Controller
@RequestMapping("/deviceController/v1.0")
public class DeviceController {
	@Autowired
	IDeviceServiceC deviceServiceC;
	
	@Autowired
	IDeviceService deviceService;
	

	
	@RequestMapping("/loadingDeviceReplenishment")
	@AppController(isVerSystemToken = true)
	public Object loadingDeviceReplenishment(DeviceReplenishmentBean deviceReplenishmentBean) throws Exception {
		
		return deviceServiceC.loadingDeviceReplenishment(deviceReplenishmentBean);
	}
	
	
	@RequestMapping("/updateClerkDevices")
	@AppController(isVerSystemToken = true)
	public Object updateClerkDevices(DeviceBean deviceBean) throws Exception {
		return deviceServiceC.updateClerkDevices(deviceBean);
	}
	
	@RequestMapping("/getClerkDevices")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getClerkDevices(DeviceBean deviceBean,PageBean pageBean) throws Exception {
		return deviceServiceC.getClerkDevices(deviceBean,pageBean);
	}
	
	
	@RequestMapping("/insertDeviceClerk")
	@AppController(isVerSystemToken = true)
	public Object insertDeviceClerk(DeviceClerkBean deviceClerkBean) throws Exception {
		return deviceServiceC.insertDeviceClerk(deviceClerkBean);
	}
	
	@RequestMapping("/updateDeviceClerk")
	@AppController(isVerSystemToken = true)
	public Object updateDeviceClerk(DeviceClerkBean deviceClerkBean) throws Exception {
		return deviceServiceC.updateDeviceClerk(deviceClerkBean);
	}
	
	@RequestMapping("/deleteDeviceClerk")
	@AppController(isVerSystemToken = true)
	public Object deleteDeviceClerk(DeviceClerkBean deviceClerkBean) throws Exception {
		return deviceServiceC.deleteDeviceClerk(deviceClerkBean);
	}
	
	
	@RequestMapping("/getDeviceClerkDetail")
	@AppController(isVerSystemToken = true)
	public Object getDeviceClerkDetail(DeviceClerkBean deviceClerkBean) throws Exception {
		return deviceServiceC.getDeviceClerkDetail(deviceClerkBean);
	}
	
	@RequestMapping("/getDeviceClerks")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getDeviceClerks(DeviceClerkBean deviceClerkBean,PageBean pageBean) throws Exception {
		return deviceServiceC.getDeviceClerks(deviceClerkBean,pageBean);
	}
	
	
	
	@RequestMapping("/insertDeviceReplenishment")
	@AppController(isVerSystemToken=true)
	public Object insertDeviceReplenishment(DeviceReplenishmentBean deviceReplenishmentBean) throws Exception {
		return deviceService.insertDeviceReplenishment(deviceReplenishmentBean);
	}
	
	@RequestMapping("/getProductBatchs")
	@AppController(isVerSystemToken = true)
	public Object getProductBatchs(ProductBean productBean) throws Exception {
		return deviceServiceC.getProductBatchs(productBean);
	}
	
	@RequestMapping("/getDeviceReplenishmentCargos")
	@AppController(isVerSystemToken = true)
	public Object getDeviceReplenishmentCargos(DeviceReplenishmentCargoBean deviceReplenishmentCargoBean) throws Exception {
		return deviceServiceC.getDeviceReplenishmentCargos(deviceReplenishmentCargoBean);
	}
	
	@RequestMapping("/examineDeviceReplenishment")
	@AppController(isVerSystemToken = true)
	public Object examineDeviceReplenishment(DeviceReplenishmentBean deviceReplenishmentBean,String device_cargos) throws Exception {
		return deviceServiceC.examineDeviceReplenishment(deviceReplenishmentBean,JSON.parseArray(device_cargos,DeviceReplenishmentCargoBean.class));
	}
	
	@RequestMapping("/getDeviceReplenishments")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getDeviceReplenishments(DeviceReplenishmentBean deviceReplenishmentBean,PageBean pageBean) throws Exception {
		return deviceServiceC.getDeviceReplenishments(deviceReplenishmentBean,pageBean);
	}
	
	@RequestMapping("/examineMemberService")
	@AppController(isVerSystemToken = true)
	public Object examineMemberService(MemberDeviceBean memberDeviceBean) throws Exception {
		return deviceServiceC.examineMemberService(memberDeviceBean);
	}
	
	@RequestMapping("/getMemberDevices")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getMemberDevices(MemberDeviceBean memberDeviceBean,PageBean pageBean) throws Exception {
		return deviceServiceC.getMemberDevices(memberDeviceBean,pageBean);
	}
	
	
	@RequestMapping("/insertDevice")
	@AppController(isVerSystemToken = true)
	public Object insertDevice(DeviceBean deviceBean,String cargos) throws Exception {
		return deviceServiceC.insertDevice(deviceBean,JSON.parseArray(cargos,DeviceCargoBean.class));
	}
	
	@RequestMapping("/updateDevice")
	@AppController(isVerSystemToken = true)
	public Object updateDevice(DeviceBean deviceBean,String cargos) throws Exception {
		return deviceServiceC.updateDevice(deviceBean,JSON.parseArray(cargos,DeviceCargoBean.class));
	}
	
	@RequestMapping("/deleteDevice")
	@AppController(isVerSystemToken = true)
	public Object deleteDevice(DeviceBean deviceBean) throws Exception {
		return deviceServiceC.deleteDevice(deviceBean);
	}
	
	
	@RequestMapping("/getDeviceDetail")
	@AppController(isVerSystemToken = true)
	public Object getDeviceDetail(DeviceBean deviceBean) throws Exception {
		return deviceServiceC.getDeviceDetail(deviceBean);
	}
	
	@RequestMapping("/getDevices")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getDevices(DeviceBean deviceBean,PageBean pageBean) throws Exception {
		return deviceServiceC.getDevices(deviceBean,pageBean);
	}
	
	
	/**
	 * 中吉售卖机 返回接口
	 * @param FunCode 1000:上货反馈汇报 5001:APP上货结果反馈请求报文 5000:出货结果反馈   4000:售卖机心跳包
	 * @param SlotNo huodaohao
	 * @param Stock 现存（上货/配送后）
	 * @param Quantity 上货/配送 数量
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/zhongjiCallback")
	@AppController(isNeedPackage=false,isLog=false)
	public Object zhongjiCallback(String FunCode,String SlotNo,
			String TradeNo,String MachineID,String Stock,String Quantity) throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		if("1000".equals(FunCode)){
			
			DeviceCargoBean deviceCargoBean=deviceServiceC.updateDeviceCargoStock(new DeviceCargoBean()
					.setCargo_no(SlotNo)
					.setProduct_stock(Stock)
					.setDevice_id(MachineID));
			String cargo_img="";
			if(deviceCargoBean!=null){
				cargo_img=deviceCargoBean.getCargo_img();
			}
			cargo_img=cargo_img.replace("https://img.shareuniversal.com/", "http://img1.shareuniversal.com/");
			map.put("Status", "0");
			map.put("SlotNo", SlotNo);
			map.put("TradeNo", TradeNo);
			map.put("ImageUrl", cargo_img);
			map.put("ImageDetailUrl", cargo_img);
			map.put("Err", "成功");
			
		}else if("5000".equals(FunCode)){
			map.put("Status", "0");
			map.put("SlotNo", SlotNo);
			map.put("TradeNo",TradeNo);
			map.put("Err", "");
		}else if("5001".equals(FunCode)){
			map.put("Status", "0");
			map.put("SlotNo", SlotNo);
			map.put("TradeNo",TradeNo);
			map.put("Err", "成功");
		}else if("4000".equals(FunCode)){//
			Map<String, Object> shipmentMap=deviceServiceC
					.shipmentDevice(new OrderMerchantsBean().setDevice_no(MachineID));
			if(shipmentMap!=null){
				map.put("Status", "0");
				map.put("MsgType", "0");
				map.put("TradeNo",shipmentMap.get("order_merchants_no"));
				map.put("SlotNo",shipmentMap.get("cargo_no"));
				map.put("ProductID",shipmentMap.get("product_id"));
				map.put("Err","成功");	
				
				deviceServiceC.updateShipmentDevice(new OrderMerchantsBean()
						.setOrder_merchants_id(NumberUtils.Integer(shipmentMap.get("order_merchants_id")+"")));
			}else{
				DeviceCargoLoadingBean deviceCargoLoadingBean=deviceServiceC
						.getDeviceCargoLoading(new DeviceCargoLoadingBean().setDevice_no(MachineID));
				if(deviceCargoLoadingBean!=null){
					map.put("Status", "0");
					map.put("MsgType", "1");
					map.put("SlotNo",deviceCargoLoadingBean.getCargo_no());
					map.put("Err", "成功");
					map.put("Capacity",deviceCargoLoadingBean.getCargo_num());
					map.put("Quantity",deviceCargoLoadingBean.getProduct_stock());
					map.put("ProductID",deviceCargoLoadingBean.getProduct_id());
					
					map.put("Name",deviceCargoLoadingBean.getCargo_name());
					map.put("Price", deviceCargoLoadingBean.getProduct_price());
					map.put("Type", "测试");
					map.put("Introduction", "好商品");
					
					String 	cargo_img=deviceCargoLoadingBean.getCargo_img();
					if(cargo_img==null){
						cargo_img="";
					}
					cargo_img=cargo_img.replace("https://img.shareuniversal.com/", "http://img1.shareuniversal.com/");

					map.put("ImageUrl", cargo_img);
					map.put("ImageDetailUrl", cargo_img);
					
					deviceServiceC.updateDeviceCargoLoading(deviceCargoLoadingBean);
				}
			}
			
		}
		return map;
	}
}
