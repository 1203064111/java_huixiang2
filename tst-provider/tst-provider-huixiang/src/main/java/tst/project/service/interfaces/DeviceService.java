package tst.project.service.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.aspect.AppException;
import tst.project.bean.member.MemberDeviceBean;
import tst.project.bean.product.DeviceBean;
import tst.project.bean.product.DeviceCargoBean;
import tst.project.bean.product.DeviceReplenishmentBean;
import tst.project.bean.product.DeviceReplenishmentCargoBean;
import tst.project.dao.interfaces.DeviceDao;
import tst.project.interfaces.IDeviceService;
import tst.project.page.PageBean;
import tst.project.utils.NumberUtils;

@Service
@Transactional(rollbackFor=Exception.class)
public class DeviceService implements IDeviceService{

	@Autowired
	DeviceDao deviceDao;
	
	@Override
	public Object getDeviceCargoDetail(DeviceCargoBean deviceCargoBean) {
		// TODO Auto-generated method stub
		return deviceDao.getDeviceCargoDetail(deviceCargoBean);
	}
	
	@Override
	public Object getDeviceReplenishmentCargos(DeviceReplenishmentCargoBean deviceReplenishmentCargoBean) {
		// TODO Auto-generated method stub
		return deviceDao.getDeviceReplenishmentCargos(deviceReplenishmentCargoBean);
	}
	
	@Override
	public Object getDeviceReplenishments(DeviceReplenishmentBean deviceReplenishmentBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<DeviceReplenishmentBean> deviceReplenishmentBeans=deviceDao.getDeviceReplenishments(deviceReplenishmentBean, pageBean);
		return pageBean.setObject(deviceReplenishmentBeans);
	}
	
	@Override
	public Object insertDeviceReplenishment(DeviceReplenishmentBean deviceReplenishmentBean) {
		// TODO Auto-generated method stub
		
		DeviceReplenishmentBean deviceReplenishmentBean2=deviceDao.getLastDeviceReplenishment(deviceReplenishmentBean);
		if(deviceReplenishmentBean2!=null){
			if(!"4".equals(deviceReplenishmentBean2.getReplenishment_state())){
				throw new AppException("该设备补货申请 还在进行中!");
			}
		}
		
		int num=deviceDao.insertDeviceReplenishment(deviceReplenishmentBean);
		if(num<=0){
			throw new AppException("申请失败!");
		}
		
		num=deviceDao.insertDeviceReplenishmentCargos(deviceReplenishmentBean);
		if(num<=0){
			throw new AppException("申请详情失败!");
		}
		return num;
	}
	
	
	@Override
	public Object updateDevice(DeviceBean deviceBean) {
		// TODO Auto-generated method stub
		int num=deviceDao.updateDevice(deviceBean);
		if(num<=0){
			throw new AppException("修改失败!");
		}
		return num;
	}
	
	@Override
	public Object getDeviceCargos(DeviceCargoBean deviceCargoBean,PageBean pageBean) {
		// TODO Auto-generated method stub
		List<DeviceCargoBean> deviceCargoBeans=deviceDao.getDeviceCargos(deviceCargoBean, pageBean);
		return pageBean.setObject(deviceCargoBeans);
	}
	
	
	@Override
	public Object getMemberDevices(DeviceBean deviceBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<DeviceBean> deviceBeans=deviceDao.getMemberDevices(deviceBean, pageBean);
		return pageBean.setObject(deviceBeans);
	}
	
	@Override
	public Object getMemberApplyDevices(MemberDeviceBean memberDeviceBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<DeviceBean> deviceBeans=deviceDao.getMemberApplyDevices(memberDeviceBean, pageBean);
		return pageBean.setObject(deviceBeans);
	}
	
	@Override
	public Object insertMemberDevice(MemberDeviceBean memberDeviceBean) {
		// TODO Auto-generated method stub
		
		DeviceBean deviceBean=deviceDao.getDeviceDetail(new DeviceBean().setDevice_id(NumberUtils.Integer(memberDeviceBean.getDevice_id())));
		if(deviceBean==null){
			throw new AppException("设备不存在!");
		}
		
		if(!"0".equals(deviceBean.getApply_state())){
			throw new AppException("该设备已有人申请!");
		}
		
		MemberDeviceBean memberDeviceBean2=deviceDao.getMemberDeviceDetail(memberDeviceBean);
		if(memberDeviceBean2!=null){
			if(!"3".equals(memberDeviceBean2.getApply_state())){
				throw new AppException("您已申请过该设备了!不可以重复申请!");
			}
		}
		
		int num=deviceDao.insertMemberDevice(memberDeviceBean);
		if(num<=0){
			throw new AppException("申请失败!");
		}
//		num=deviceDao.updateDevice(new DeviceBean()
//				.setDevice_id(NumberUtils.Integer(memberDeviceBean.getDevice_id()))
//				.setApply_state("1"));
//		if(num<=0){
//			throw new AppException("设备状态失败!");
//		}
		return num;
	}
	
	@Override
	public Object getDevices(DeviceBean deviceBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<DeviceBean> deviceBeans=deviceDao.getDevices(deviceBean, pageBean);
		return pageBean.setObject(deviceBeans);
	}

	@Override
	public Object getDeviceDetail(DeviceBean deviceBean) {
		// TODO Auto-generated method stub
		return deviceDao.getDeviceDetail(deviceBean);
	}

}
