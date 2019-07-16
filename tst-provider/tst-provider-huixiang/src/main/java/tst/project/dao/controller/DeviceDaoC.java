package tst.project.dao.controller;

import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
import tst.project.bean.member.MemberDeviceBean;
import tst.project.bean.order.OrderMerchantsBean;
import tst.project.bean.product.DeviceBean;
import tst.project.bean.product.DeviceCargoBean;
import tst.project.bean.product.DeviceCargoLoadingBean;
import tst.project.bean.product.DeviceClerkBean;
import tst.project.bean.product.DeviceReplenishmentBatchBean;
import tst.project.bean.product.DeviceReplenishmentBean;
import tst.project.bean.product.DeviceReplenishmentCargoBean;
import tst.project.bean.product.GoodsBatchBean;
import tst.project.bean.product.ProductBean;
import tst.project.page.PageBean;

@Mapper
public interface DeviceDaoC {
	/**
	 * 导出补货
	 * @author sjb
	 * @param deviceReplenishmentBean
	 * @return
	 */
	public int loadingDeviceReplenishment(DeviceReplenishmentBean deviceReplenishmentBean);
	public List<Map<String, Object>> getLoadingDeviceReplenishments(DeviceReplenishmentBean deviceReplenishmentBean);
	public List<Map<String, Object>> getLoadingDeviceReplenishments2(DeviceReplenishmentBean deviceReplenishmentBean);

	/**
	 * 分配设备给上货员
	 * @author sjb
	 * @param deviceBean
	 * @return
	 */
	public int updateClerkDevices(DeviceBean deviceBean);
	
	/**
	 * 获取还没有分配上货员的设备列表
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public List<DeviceBean> getClerkDevices(DeviceBean deviceBean,PageBean pageBean);
	
	/**
	 * 添加设备上货员
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public int insertDeviceClerk(DeviceClerkBean deviceClerkBean);
	/**
	 * 修改设备上货员
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public int updateDeviceClerk(DeviceClerkBean deviceClerkBean);
	
	/**
	 * 删除设备上货员
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public int deleteDeviceClerk(DeviceClerkBean deviceClerkBean);
	
	/**
	 * 设备上货员详情
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public DeviceClerkBean getDeviceClerkDetail(DeviceClerkBean deviceClerkBean);
	
	/**
	 * 设备上货员列表
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public List<DeviceClerkBean> getDeviceClerks(DeviceClerkBean deviceClerkBean,PageBean pageBean);
	
	/**
	 * 修改货道信息
	 * @author sjb
	 * @param deviceCargoBean
	 * @return
	 */
	public int updateDeviceCargoStock(DeviceCargoBean deviceCargoBean);
	/**
	 * 修改产品的库存数量
	 * @param productBean
	 * @return
	 */
	public int updateProductStock(ProductBean productBean);
	
	/**
	 * 添加货道上货批次
	 * @param deviceReplenishmentBatchBean
	 * @return
	 */
	public int insertDeviceReplenishmentBatch(DeviceReplenishmentBatchBean deviceReplenishmentBatchBean);
	
	/**
	 * 产品的批次列表
	 * @author sjb
	 * @param productBean
	 * @return
	 */
	public List<GoodsBatchBean> getProductBatchs(ProductBean productBean);
	
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
	public int updateShipmentDevice(OrderMerchantsBean orderMerchantsBean);
	
	
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
	public int updateDeviceCargoLoading(DeviceCargoLoadingBean deviceCargoLoadingBean); 
	
	/**
	 * 补货货道详情
	 * @author sjb
	 * @param deviceReplenishmentCargoBean
	 * @return
	 */
	public List<DeviceReplenishmentCargoBean> getDeviceReplenishmentCargos(DeviceReplenishmentCargoBean deviceReplenishmentCargoBean);
	
	/**
	 * 审核设备补货
	 * @author sjb
	 * @param memberDeviceBean
	 * @return
	 */
	public int examineDeviceReplenishment(DeviceReplenishmentBean deviceReplenishmentBean);
	
	/**
	 * 补货申请记录
	 * @author sjb
	 * @param deviceCargoBeans
	 * @return
	 */
	public List<DeviceReplenishmentBean> getDeviceReplenishments(DeviceReplenishmentBean deviceReplenishmentBean,PageBean pageBean);
	/**
	 * 修改设备为通过状态
	 * @param memberDeviceBean
	 * @return
	 */
	public int examineMemberService(MemberDeviceBean memberDeviceBean);
	/**
	 * 修改设备申请
	 * @param memberDeviceBean
	 * @return
	 */
	public int updateMemberDevice(MemberDeviceBean memberDeviceBean);
	
	/**
	 * 申请设备列表
	 * @author sjb
	 * @param memberDeviceBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberDeviceBean> getMemberDevices(MemberDeviceBean memberDeviceBean,PageBean pageBean);
	
	/**
	 * 获得设备货道列表
	 * @param deviceCargoBean
	 * @return
	 */
	public List<DeviceCargoBean> getDeviceCargos(DeviceCargoBean deviceCargoBean);
	public DeviceCargoBean getDeviceCargoDetail(DeviceCargoBean deviceCargoBean);
	/**
	 * 删除设备货道
	 * @param deviceCargoBean
	 * @return
	 */
	public int deleteDeviceCargos(DeviceCargoBean deviceCargoBean);
	
	/**
	 * 修改设备货道
	 * @param deviceCargoBean
	 * @return
	 */
	public int updateDeviceCargo(DeviceCargoBean deviceCargoBean);
	
	/**
	 * 添加设备货道
	 * @param deviceCargoBean
	 * @return
	 */
	public int insertDeviceCargo(DeviceCargoBean deviceCargoBean);
	
	/**
	 * 添加货道上货信息
	 * @param deviceCargoLoadingBean
	 * @return
	 */
	public int insertDeviceCargoLoading(DeviceCargoLoadingBean deviceCargoLoadingBean);
	/**
	 * 添加设备
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public int insertDevice(DeviceBean deviceBean);
	/**
	 * 修改设备
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public int updateDevice(DeviceBean deviceBean);
	
	/**
	 * 删除设备
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public int deleteDevice(DeviceBean deviceBean);
	
	/**
	 * 设备详情
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public DeviceBean getDeviceDetail(DeviceBean deviceBean);
	
	/**
	 * 设备列表
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public List<DeviceBean> getDevices(DeviceBean deviceBean,PageBean pageBean);
}
