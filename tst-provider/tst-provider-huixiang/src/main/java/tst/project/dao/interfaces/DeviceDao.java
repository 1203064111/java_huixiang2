package tst.project.dao.interfaces;

import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
import tst.project.bean.member.MemberDeviceBean;
import tst.project.bean.product.DeviceBean;
import tst.project.bean.product.DeviceCargoBean;
import tst.project.bean.product.DeviceReplenishmentBean;
import tst.project.bean.product.DeviceReplenishmentCargoBean;
import tst.project.page.PageBean;

@Mapper
public interface DeviceDao {
	/**
	 * 获取设备货道商品详情
	 * @author sjb
	 * @param deviceCargoBean
	 * @return
	 */
	public Map<String,Object> getDeviceCargoDetail(DeviceCargoBean deviceCargoBean);
	
	/**
	 * 补货记录详情
	 * @author sjb
	 * @param deviceReplenishmentCargoBean
	 * @return
	 */
	public List<DeviceReplenishmentCargoBean> getDeviceReplenishmentCargos(DeviceReplenishmentCargoBean deviceReplenishmentCargoBean);
	
	/**
	 * 补货记录
	 * @author sjb
	 * @param deviceReplenishmentBean
	 * @param pageBean
	 * @return
	 */
	public List<DeviceReplenishmentBean> getDeviceReplenishments(DeviceReplenishmentBean deviceReplenishmentBean,PageBean pageBean);
	
	
	/**
	 * 申请补货----货道详情入库
	 * @param deviceReplenishmentBean
	 * @return
	 */
	public int insertDeviceReplenishmentCargos(DeviceReplenishmentBean deviceReplenishmentBean);
	
	/**
	 * 获取最新一条申请记录
	 * @param deviceReplenishmentBean
	 * @return
	 */
	public DeviceReplenishmentBean getLastDeviceReplenishment(DeviceReplenishmentBean deviceReplenishmentBean);
	
	/**
	 * 申请补货
	 * @author sjb
	 * @param deviceReplenishmentBean
	 * @return
	 */
	public int insertDeviceReplenishment(DeviceReplenishmentBean deviceReplenishmentBean);
	
	/**
	 * 设备的货道列表
	 * @author sjb
	 * @param deviceCargoBean
	 * @return
	 */
	public List<DeviceCargoBean> getDeviceCargos(DeviceCargoBean deviceCargoBean,PageBean pageBean);
	
	/**
	 * 用户的设备列表
	 * @author sjb
	 * @param deviceBean
	 * @param pageBean
	 * @return
	 */
	public List<DeviceBean> getMemberDevices(DeviceBean deviceBean,PageBean pageBean);
	
	/**
	 * 用户的申请的详情
	 * @param memberDeviceBean
	 * @return
	 */
	public MemberDeviceBean getMemberDeviceDetail(MemberDeviceBean memberDeviceBean);
	
	/**
	 * 用户售卖机申请列表
	 * @author sjb
	 * @param memberDeviceBean
	 * @param pageBean
	 * @return
	 */
	public List<DeviceBean> getMemberApplyDevices(MemberDeviceBean memberDeviceBean,PageBean pageBean);
	
	
	/**
	 * 修改设备信息
	 * @param deviceBean
	 * @return
	 */
	public int updateDevice(DeviceBean deviceBean);
	
	/**
	 * 用户申请设备
	 * @author sjb
	 * @param memberDeviceBean
	 * @return
	 */
	public int insertMemberDevice(MemberDeviceBean memberDeviceBean);
	
	/**
	 * 设备列表
	 * @author sjb
	 * @param deviceBean
	 * @return
	 */
	public List<DeviceBean> getDevices(DeviceBean deviceBean,PageBean pageBean);
	
	/**
	 * 设备想起
	 * @author sjb
	 * @param deviceBean
	 * @return
	 */
	public DeviceBean getDeviceDetail(DeviceBean deviceBean);
}
