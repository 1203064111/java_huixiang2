package tst.project.service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.aspect.AppException;
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
import tst.project.controller.IDeviceServiceC;
import tst.project.dao.controller.DeviceDaoC;
import tst.project.dao.controller.OrderDaoC;
import tst.project.page.PageBean;
import tst.project.utils.ExcelUtils;
import tst.project.utils.NumberUtils;
import tst.project.utils.TimeUtils;
import tst.project.utils.UUIDUtils;

@Service
@Transactional(rollbackFor=AppException.class)
public class DeviceServiceC implements IDeviceServiceC{
	@Autowired
	DeviceDaoC deviceDaoC;
	
	@Autowired
	OrderDaoC orderDaoC;
	
	@Value("${img_path}")
	private String img_path;
	
	@Value("${img_url}")
	private String img_url;
	
	@Override
	public Object loadingDeviceReplenishment(DeviceReplenishmentBean deviceReplenishmentBean) {
		// TODO Auto-generated method stub
		String loading_no = new UUIDUtils(0).nextId(false, 10) + "";
		deviceReplenishmentBean.setLoading_no(loading_no);
		int num=deviceDaoC.loadingDeviceReplenishment(deviceReplenishmentBean);
		if(num<=0){
			throw new AppException("操作失败!");
		}
		
		List<Map<String, Object>> maps=deviceDaoC.getLoadingDeviceReplenishments(deviceReplenishmentBean);
		List<Map<String, Object>> maps2=deviceDaoC.getLoadingDeviceReplenishments2(deviceReplenishmentBean);

		
		String fileName = "补货"+loading_no + ".xls";
		boolean is_success = ExcelUtils.exportExcelDevice(img_path+"/excel/" + fileName,maps,maps2);
		if(!is_success){
			throw new AppException("导出失败!");
		}
		
//		String fileName2 = "仓库出货单"+loading_no + ".xls";
//		is_success=ExcelUtils.exportExcelDevice2(img_path+"/excel/" + fileName2,maps2);
//		if(!is_success){
//			throw new AppException("导出失败");
//		}
		return img_url+"/excel/"+fileName;
	}
	
	
	@Override
	public Object updateClerkDevices(DeviceBean deviceBean) {
		// TODO Auto-generated method stub
		int num=deviceDaoC.updateClerkDevices(deviceBean);
		if(num<=0){
			throw new AppException("添加失败!");
		}
		return num;
	}
	
	@Override
	public Object getClerkDevices(DeviceBean deviceBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<DeviceBean> deviceBeans=deviceDaoC.getClerkDevices(deviceBean, pageBean);
		return pageBean.setObject(deviceBeans);
	}
	
	@Override
	public Object insertDeviceClerk(DeviceClerkBean deviceClerkBean) {
		// TODO Auto-generated method stub
		int num=deviceDaoC.insertDeviceClerk(deviceClerkBean);
		if(num<=0){
			throw new AppException("添加失败!");
		}
		return num;
	}

	@Override
	public Object updateDeviceClerk(DeviceClerkBean deviceClerkBean) {
		// TODO Auto-generated method stub
		int num=deviceDaoC.updateDeviceClerk(deviceClerkBean);
		if(num<=0){
			throw new AppException("修改失败!");
		}
		return num;
	}

	@Override
	public Object deleteDeviceClerk(DeviceClerkBean deviceClerkBean) {
		// TODO Auto-generated method stub
		int num=deviceDaoC.deleteDeviceClerk(deviceClerkBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}

	@Override
	public Object getDeviceClerkDetail(DeviceClerkBean deviceClerkBean) {
		// TODO Auto-generated method stub
		return deviceDaoC.getDeviceClerkDetail(deviceClerkBean);
	}

	@Override
	public Object getDeviceClerks(DeviceClerkBean deviceClerkBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<DeviceClerkBean> deviceClerkBeans=deviceDaoC.getDeviceClerks(deviceClerkBean, pageBean);
		return pageBean.setObject(deviceClerkBeans);
	}

	
	@Override
	public DeviceCargoBean updateDeviceCargoStock(DeviceCargoBean deviceCargoBean) {
		// TODO Auto-generated method stub
		DeviceCargoBean deviceCargoBean2=deviceDaoC.getDeviceCargoDetail(deviceCargoBean);
		deviceDaoC.updateDeviceCargoStock(deviceCargoBean);
		return deviceCargoBean2;
	}
	
	@Override
	public Object getProductBatchs(ProductBean productBean) {
		// TODO Auto-generated method stub
		return deviceDaoC.getProductBatchs(productBean);
	}	
	
	@Override
	public Map<String, Object> shipmentDevice(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		return deviceDaoC.shipmentDevice(orderMerchantsBean);
	}
	
	@Override
	public Object updateShipmentDevice(OrderMerchantsBean orderMerchantsBean) {
		// TODO Auto-generated method stub
		return deviceDaoC.updateShipmentDevice(orderMerchantsBean);
	}
	
	@Override
	public DeviceCargoLoadingBean getDeviceCargoLoading(DeviceCargoLoadingBean deviceCargoLoadingBean) {
		// TODO Auto-generated method stub
		return deviceDaoC.getDeviceCargoLoading(deviceCargoLoadingBean);
	}
	@Override
	public Object updateDeviceCargoLoading(DeviceCargoLoadingBean deviceCargoLoadingBean) {
		// TODO Auto-generated method stub
		int num=deviceDaoC.updateDeviceCargoLoading(deviceCargoLoadingBean);
		if(num<=0){
			throw new AppException("修改失败!");
		}
		return num;
	}
	
	@Override
	public Object getDeviceReplenishmentCargos(DeviceReplenishmentCargoBean deviceReplenishmentCargoBean) {
		// TODO Auto-generated method stub
		return deviceDaoC.getDeviceReplenishmentCargos(deviceReplenishmentCargoBean);
	}
	
	@Override
	public Object examineDeviceReplenishment(DeviceReplenishmentBean deviceReplenishmentBean,List<DeviceReplenishmentCargoBean> deviceReplenishmentCargoBeans) {
		// TODO Auto-generated method stub
		int num=deviceDaoC.examineDeviceReplenishment(deviceReplenishmentBean);
		if(num<=0){
			throw new AppException("审核失败!");
		}
		if("2".equals(deviceReplenishmentBean.getReplenishment_state())){//审核通过
			for (int i = 0; i < deviceReplenishmentCargoBeans.size(); i++) {
				DeviceReplenishmentCargoBean deviceReplenishmentCargoBean=deviceReplenishmentCargoBeans.get(i);
				int replenishment_stock=NumberUtils.Integer(deviceReplenishmentCargoBean.getReplenishment_stock());//需要补货的库存
				int batch_total_stock=0;
				
				List<DeviceReplenishmentBatchBean> deviceReplenishmentBatchBeans=deviceReplenishmentCargoBean.getDeviceReplenishmentBatchBeans();
				if(deviceReplenishmentBatchBeans==null){
					throw new AppException("货道:"+deviceReplenishmentCargoBean.getCargo_no()+"请先选择批次!");
				}
				for (int j = 0; j < deviceReplenishmentBatchBeans.size(); j++) {
					DeviceReplenishmentBatchBean deviceReplenishmentBatchBean=deviceReplenishmentBatchBeans.get(j);
					int batch_stock=NumberUtils.Integer(deviceReplenishmentBatchBean.getBatch_stock());
					batch_total_stock+=batch_stock;
					
					num=deviceDaoC.insertDeviceReplenishmentBatch(deviceReplenishmentBatchBean
							.setReplenishment_id(deviceReplenishmentBean.getReplenishment_id()+"")
							.setReplenishment_cargo_id(deviceReplenishmentCargoBean.getReplenishment_cargo_id()+"")
							.setDevice_no(deviceReplenishmentCargoBean.getDevice_no())
							.setCargo_no(deviceReplenishmentCargoBean.getCargo_no())
							.setProduct_id(deviceReplenishmentCargoBean.getProduct_id()));
					if(num<=0){
						throw new AppException("货道:"+deviceReplenishmentCargoBean.getCargo_no()+"添加失败!");
					}
					
					
					num=orderDaoC.updateGoodsBatchStock(new GoodsBatchBean()
							.setBatch_id(NumberUtils.Integer(deviceReplenishmentBatchBean.getBatch_id()))
							.setBatch_now_stock(batch_stock+""));
					if(num<=0){
						throw new AppException("货道:"+deviceReplenishmentCargoBean.getCargo_no()+"批次库存更新失败!");
					}
				}
				
				if(replenishment_stock<batch_total_stock){
					throw new AppException("货道:"+deviceReplenishmentCargoBean.getCargo_no()+"上货库存大于批次库存总和!");
				}
				
				num=deviceDaoC.updateProductStock(new ProductBean()
						.setProduct_id(NumberUtils.Integer(deviceReplenishmentCargoBean.getProduct_id()))
						.setProduct_stock(batch_total_stock+""));
				if(num<=0){
					throw new AppException("产品库存更新失败!");
				}
			}
		}
		return num;
	}
	
	@Override
	public Object getDeviceReplenishments(DeviceReplenishmentBean deviceReplenishmentBean,PageBean pageBean) {
		// TODO Auto-generated method stub
		List<DeviceReplenishmentBean> deviceReplenishmentBeans=deviceDaoC.getDeviceReplenishments(deviceReplenishmentBean, pageBean);
		return pageBean.setObject(deviceReplenishmentBeans);
	}
	
	@Override
	public Object examineMemberService(MemberDeviceBean memberDeviceBean) {
		// TODO Auto-generated method stub
		int num=deviceDaoC.updateMemberDevice(memberDeviceBean);
		if(num<=0){
			throw new AppException("审核失败!");
		}
		if("2".equals(memberDeviceBean.getApply_state())){
			num=deviceDaoC.examineMemberService(memberDeviceBean);
			if(num<=0){
				throw new AppException("通过失败!");
			}
		}
		return num;
	}
	
	@Override
	public Object getMemberDevices(MemberDeviceBean memberDeviceBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MemberDeviceBean> memberDeviceBeans=deviceDaoC.getMemberDevices(memberDeviceBean, pageBean);
		return pageBean.setObject(memberDeviceBeans);
	}
	
	@Override
	public Object insertDevice(DeviceBean deviceBean,List<DeviceCargoBean> deviceCargoBeans) {
		// TODO Auto-generated method stub
		int num=deviceDaoC.insertDevice(deviceBean.setDevice_count(deviceCargoBeans.size()+""));
		if(num<=0){
			throw new AppException("添加失败!");
		}
		
		for (int i = 0; i < deviceCargoBeans.size(); i++) {
			DeviceCargoBean deviceCargoBean=deviceCargoBeans.get(i);
			num=deviceDaoC.insertDeviceCargo(deviceCargoBean.setDevice_id(deviceBean.getDevice_id()+""));
			if(num<=0){
				throw new AppException("货道添加失败!");
			}
			
			num=deviceDaoC.insertDeviceCargoLoading(new DeviceCargoLoadingBean()
					.setDevice_no(deviceBean.getDevice_no())
					.setCargo_id(deviceCargoBean.getCargo_id()+"")
					.setCargo_num(deviceCargoBean.getCargo_num())
					.setCargo_name(deviceCargoBean.getCargo_name())
					.setCargo_img(deviceCargoBean.getCargo_img())
					.setCargo_no(deviceCargoBean.getCargo_no())
					.setProduct_id(deviceCargoBean.getProduct_id())
					.setProduct_price(deviceCargoBean.getProduct_now_price())
					.setProduct_stock(deviceCargoBean.getProduct_stock()));
			if(num<=0){
				throw new AppException("货道上货添加失败!");
			}
		}
		return num;
	}

	@Override
	public Object updateDevice(DeviceBean deviceBean,List<DeviceCargoBean> deviceCargoBeans) {
		// TODO Auto-generated method stub
		int num=deviceDaoC.updateDevice(deviceBean.setDevice_count(deviceCargoBeans.size()+""));
		if(num<=0){
			throw new AppException("修改失败!");
		}
		
		deviceDaoC.deleteDeviceCargos(new DeviceCargoBean().setDevice_id(deviceBean.getDevice_id()+""));
		for (int i = 0; i < deviceCargoBeans.size(); i++) {
			DeviceCargoBean deviceCargoBean=deviceCargoBeans.get(i);
			if(deviceCargoBean.getCargo_id()==0){
				num=deviceDaoC.insertDeviceCargo(deviceCargoBean.setDevice_id(deviceBean.getDevice_id()+""));
				if(num<=0){
					throw new AppException("货道添加失败!");
				}
			}else{
				num=deviceDaoC.updateDeviceCargo(deviceCargoBean);
				if(num<=0){
					throw new AppException("货道修改失败!");
				}
			}
			
			num=deviceDaoC.insertDeviceCargoLoading(new DeviceCargoLoadingBean()
					.setDevice_no(deviceBean.getDevice_no())
					.setCargo_id(deviceCargoBean.getCargo_id()+"")
					.setCargo_num(deviceCargoBean.getCargo_num())
					.setCargo_name(deviceCargoBean.getCargo_name())
					.setCargo_img(deviceCargoBean.getCargo_img())
					.setCargo_no(deviceCargoBean.getCargo_no())
					.setProduct_id(deviceCargoBean.getProduct_id())
					.setProduct_price(deviceCargoBean.getProduct_now_price())
					.setProduct_stock(deviceCargoBean.getProduct_stock()));
			if(num<=0){
				throw new AppException("货道上货添加失败!");
			}
		}
		return num;
	}

	@Override
	public Object deleteDevice(DeviceBean deviceBean) {
		// TODO Auto-generated method stub
		int num=deviceDaoC.deleteDevice(deviceBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}

	@Override
	public Object getDeviceDetail(DeviceBean deviceBean) {
		// TODO Auto-generated method stub
		DeviceBean deviceBean2=deviceDaoC.getDeviceDetail(deviceBean);
		if(deviceBean2!=null){
			List<DeviceCargoBean> deviceCargoBeans=deviceDaoC
					.getDeviceCargos(new DeviceCargoBean().setDevice_id(deviceBean2.getDevice_id()+""));
			deviceBean2.setDeviceCargoBeans(deviceCargoBeans);
		}
		return deviceBean2;
	}

	@Override
	public Object getDevices(DeviceBean deviceBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<DeviceBean> deviceBeans=deviceDaoC.getDevices(deviceBean, pageBean);
		return pageBean.setObject(deviceBeans);
	}

	
}
