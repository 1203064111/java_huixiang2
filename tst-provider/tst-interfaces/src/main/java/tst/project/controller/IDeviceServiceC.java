package tst.project.controller;

import java.util.List;
import java.util.Map;

import tst.project.bean.member.MemberDeviceBean;
import tst.project.bean.order.OrderMerchantsBean;
import tst.project.bean.product.DeviceBean;
import tst.project.bean.product.DeviceCargoBean;
import tst.project.bean.product.DeviceCargoLoadingBean;
import tst.project.bean.product.DeviceClerkBean;
import tst.project.bean.product.DeviceReplenishmentBean;
import tst.project.bean.product.DeviceReplenishmentCargoBean;
import tst.project.bean.product.ProductBean;
import tst.project.page.PageBean;

public interface IDeviceServiceC {
	
	/**
	 * 导出补货
	 * @author sjb
	 * @param deviceReplenishmentBean
	 * @return
	 */
	public Object loadingDeviceReplenishment(DeviceReplenishmentBean deviceReplenishmentBean);

	/**
	 * 分配设备给上货员
	 * @author sjb
	 * @param deviceBean
	 * @return
	 */
	public Object updateClerkDevices(DeviceBean deviceBean);
	
	/**
	 * 获取还没有分配上货员的设备列表
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public Object getClerkDevices(DeviceBean deviceBean,PageBean pageBean);
	
	/**
	 * 添加设备上货员
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public Object insertDeviceClerk(DeviceClerkBean deviceClerkBean);
	/**
	 * 修改设备上货员
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public Object updateDeviceClerk(DeviceClerkBean deviceClerkBean);
	
	/**
	 * 删除设备上货员
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public Object deleteDeviceClerk(DeviceClerkBean deviceClerkBean);
	
	/**
	 * 设备上货员详情
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public Object getDeviceClerkDetail(DeviceClerkBean deviceClerkBean);
	
	/**
	 * 设备上货员列表
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public Object getDeviceClerks(DeviceClerkBean deviceClerkBean,PageBean pageBean);
	
	
	/**
	 * 修改货道信息
	 * @author sjb
	 * @param deviceCargoBean
	 * @return
	 */
	public DeviceCargoBean updateDeviceCargoStock(DeviceCargoBean deviceCargoBean);
	
	/**
	 * 产品的批次列表
	 * @author sjb
	 * @param productBean
	 * @return
	 */
	public Object getProductBatchs(ProductBean productBean);
	
	/**
	 * 获取设备需要出货信息
	 * @author sjb
	 * @return
	 */
	public Map<String, Object> shipmentDevice(OrderMerchantsBean orderMerchantsBean);
	
	/**
	 * 修改设备需要出货信息
	 * @author sjb
	 * @param orderMerchantsBean
	 * @return
	 */
	public Object updateShipmentDevice(OrderMerchantsBean orderMerchantsBean);
	/**
	 * 获得上货详情
	 * @author sjb
	 * @param deviceCargoBeans
	 * @return
	 */
	public DeviceCargoLoadingBean getDeviceCargoLoading(DeviceCargoLoadingBean deviceCargoLoadingBean);
	
	/**
	 * 修改上货的信息
	 * @author sjb
	 * @param deviceCargoLoadingBean
	 * @return
	 */
	public Object updateDeviceCargoLoading(DeviceCargoLoadingBean deviceCargoLoadingBean); 
	
	/**
	 * 补货货道详情
	 * @author sjb
	 * @param deviceReplenishmentCargoBean
	 * @return
	 */
	public Object getDeviceReplenishmentCargos(DeviceReplenishmentCargoBean deviceReplenishmentCargoBean);
	
	/**
	 * 审核设备补货
	 * @author sjb
	 * @param memberDeviceBean
	 * @return
	 */
	public Object examineDeviceReplenishment(DeviceReplenishmentBean deviceReplenishmentBean,List<DeviceReplenishmentCargoBean> deviceReplenishmentCargoBeans);
	
	/**
	 * 补货申请记录
	 * @author sjb
	 * @param deviceCargoBeans
	 * @return
	 */
	public Object getDeviceReplenishments(DeviceReplenishmentBean deviceReplenishmentBean,PageBean pageBean);
	
	/**
	 * 审核设备申请
	 * @author sjb
	 * @param memberDeviceBean
	 * @return
	 */
	public Object examineMemberService(MemberDeviceBean memberDeviceBean);
	
	/**
	 * 申请设备列表
	 * @author sjb
	 * @param memberDeviceBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberDevices(MemberDeviceBean memberDeviceBean,PageBean pageBean);
	
	/**
	 * 添加设备
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public Object insertDevice(DeviceBean deviceBean,List<DeviceCargoBean> deviceCargoBeans);
	/**
	 * 修改设备
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public Object updateDevice(DeviceBean deviceBean,List<DeviceCargoBean> deviceCargoBeans);
	
	/**
	 * 删除设备
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public Object deleteDevice(DeviceBean deviceBean);
	
	/**
	 * 设备详情
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public Object getDeviceDetail(DeviceBean deviceBean);
	
	/**
	 * 设备列表
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public Object getDevices(DeviceBean deviceBean,PageBean pageBean);
}
