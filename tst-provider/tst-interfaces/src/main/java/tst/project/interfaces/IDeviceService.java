package tst.project.interfaces;

import tst.project.bean.member.MemberDeviceBean;
import tst.project.bean.product.DeviceBean;
import tst.project.bean.product.DeviceCargoBean;
import tst.project.bean.product.DeviceReplenishmentBean;
import tst.project.bean.product.DeviceReplenishmentCargoBean;
import tst.project.page.PageBean;

public interface IDeviceService {
	/**
	 * 获取设备货道商品详情
	 * @author sjb
	 * @param deviceCargoBean
	 * @return
	 */
	public Object getDeviceCargoDetail(DeviceCargoBean deviceCargoBean);
	
	/**
	 * 补货记录详情
	 * @author sjb
	 * @param deviceReplenishmentCargoBean
	 * @return
	 */
	public Object getDeviceReplenishmentCargos(DeviceReplenishmentCargoBean deviceReplenishmentCargoBean);
	/**
	 * 补货记录
	 * @author sjb
	 * @param deviceReplenishmentBean
	 * @param pageBean
	 * @return
	 */
	public Object getDeviceReplenishments(DeviceReplenishmentBean deviceReplenishmentBean,PageBean pageBean);
	
	/**
	 * 申请补货
	 * @author sjb
	 * @param deviceReplenishmentBean
	 * @return
	 */
	public Object insertDeviceReplenishment(DeviceReplenishmentBean deviceReplenishmentBean);
	
	/**
	 * 修改售货机信息
	 * @author sjb
	 * @param deviceBean
	 * @return
	 */
	public Object updateDevice(DeviceBean deviceBean);
	
	/**
	 * 设备的货道列表
	 * @author sjb
	 * @param deviceCargoBean
	 * @return
	 */
	public Object getDeviceCargos(DeviceCargoBean deviceCargoBean,PageBean pageBean);
	/**
	 * 用户的设备列表
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberDevices(DeviceBean deviceBean,PageBean pageBean);
	
	/**
	 * 用户售卖机申请列表
	 * @author sjb
	 * @param memberDeviceBean
	 * @param pageBean
	 * @return
	 */
	public Object getMemberApplyDevices(MemberDeviceBean memberDeviceBean,PageBean pageBean);
	
	/**
	 * 用户申请设备
	 * @author sjb
	 * @param memberDeviceBean
	 * @return
	 */
	public Object insertMemberDevice(MemberDeviceBean memberDeviceBean);
	
	/**
	 * 设备列表
	 * @author sjb
	 * @param deviceBean
	 * @return
	 */
	public Object getDevices(DeviceBean deviceBean,PageBean pageBean);
	
	/**
	 * 设备想起
	 * @author sjb
	 * @param deviceBean
	 * @return
	 */
	public Object getDeviceDetail(DeviceBean deviceBean);
}
