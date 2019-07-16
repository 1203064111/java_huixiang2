package tst.project.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tst.project.aspect.AppController;
import tst.project.bean.member.MemberDeviceBean;
import tst.project.bean.product.DeviceBean;
import tst.project.bean.product.DeviceCargoBean;
import tst.project.bean.product.DeviceReplenishmentBean;
import tst.project.bean.product.DeviceReplenishmentCargoBean;
import tst.project.page.PageBean;

@Controller
@RequestMapping("/deviceInterfaces/v1.0")
public class DeviceInterfaces {
	@Autowired
	IDeviceService deviceService;
	
	
	@RequestMapping("/getDeviceCargoDetail")
	@AppController
	public Object getDeviceCargoDetail(DeviceCargoBean deviceCargoBean) throws Exception {
		return deviceService.getDeviceCargoDetail(deviceCargoBean);
	}
	
	@RequestMapping("/getDeviceReplenishmentCargos")
	@AppController(isVerToken=true)
	public Object getDeviceReplenishmentCargos(DeviceReplenishmentCargoBean deviceReplenishmentCargoBean) throws Exception {
		return deviceService.getDeviceReplenishmentCargos(deviceReplenishmentCargoBean);
	}
	
	@RequestMapping("/getDeviceReplenishments")
	@AppController(isVerToken=true,isPage=true)
	public Object getDeviceReplenishments(DeviceReplenishmentBean deviceReplenishmentBean,PageBean pageBean) throws Exception {
		return deviceService.getDeviceReplenishments(deviceReplenishmentBean,pageBean);
	}
	
	@RequestMapping("/insertDeviceReplenishment")
	@AppController(isVerToken=true)
	public Object insertDeviceReplenishment(DeviceReplenishmentBean deviceReplenishmentBean) throws Exception {
		return deviceService.insertDeviceReplenishment(deviceReplenishmentBean);
	}
	
	@RequestMapping("/updateDevice")
	@AppController(isVerToken=true)
	public Object updateDevice(DeviceBean deviceBean) throws Exception {
		return deviceService.updateDevice(deviceBean);
	}
	
	@RequestMapping("/getDeviceCargos")
	@AppController(isVerToken=true,isPage=true)
	public Object getDeviceCargos(DeviceCargoBean deviceCargoBean,PageBean pageBean) throws Exception {
		return deviceService.getDeviceCargos(deviceCargoBean,pageBean);
	}
	
	@RequestMapping("/getMemberDevices")
	@AppController(isVerToken=true,isPage=true)
	public Object getMemberDevices(DeviceBean deviceBean,PageBean pageBean) throws Exception {
		return deviceService.getMemberDevices(deviceBean,pageBean);
	}
	
	@RequestMapping("/getMemberApplyDevices")
	@AppController(isVerToken=true,isPage=true)
	public Object getMemberApplyDevices(MemberDeviceBean memberDeviceBean,PageBean pageBean) throws Exception {
		return deviceService.getMemberApplyDevices(memberDeviceBean,pageBean);
	}
	
	@RequestMapping("/insertMemberDevice")
	@AppController(isVerToken=true)
	public Object insertMemberDevice(MemberDeviceBean memberDeviceBean) throws Exception {
		return deviceService.insertMemberDevice(memberDeviceBean);
	}
	
	@RequestMapping("/getDevices")
	@AppController(isPage=true)
	public Object getDevices(DeviceBean deviceBean,PageBean pageBean) throws Exception {
		return deviceService.getDevices(deviceBean,pageBean);
	}
	
	@RequestMapping("/getDeviceDetail")
	@AppController
	public Object getDeviceDetail(DeviceBean deviceBean) throws Exception {
		return deviceService.getDeviceDetail(deviceBean);
	}
}
