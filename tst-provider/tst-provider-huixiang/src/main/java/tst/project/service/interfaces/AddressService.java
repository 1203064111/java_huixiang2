package tst.project.service.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppException;
import tst.project.bean.member.AddressBean;
import tst.project.bean.member.CityHotBean;
import tst.project.bean.setting.CityBean;
import tst.project.dao.interfaces.AddressDao;
import tst.project.interfaces.IAddressService;
import tst.project.page.PageBean;
import tst.project.utils.RedisUtils;

@Service
@Transactional(rollbackFor=Exception.class)
public class AddressService implements IAddressService {

	@Autowired
	AddressDao addressDao;
	
	
	@Override
	public Object getCitysGroupPY(CityBean cityBean) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> maps=addressDao.getCitysGroupPY();
		if(maps!=null){
			for (int i = 0; i < maps.size(); i++) {
				Map<String, Object> map=maps.get(i);
				List<CityBean> cityBeans=addressDao.getCitysByPY(map);
				map.put("cityBeans", cityBeans);
			}
		}
		return maps;
	}
	
	@Override
	public Object getCitys(CityBean cityBean) {
		// TODO Auto-generated method stub
			
			String citys=RedisUtils.getKey("citys");
			
			List<CityBean> cityBeans=null;
			if(citys==null||citys.equals("")){
				cityBeans=addressDao.getCitys(cityBean);
				boolean is_success=RedisUtils.setKey("citys", JSON.toJSONString(cityBeans));
				if(!is_success){
					throw new AppException("缓存失败!");
				}
			}else{
				cityBeans=JSON.parseArray(citys, CityBean.class);
			}
			
			return cityBeans;
	}

	@Override
	public Object getCitysV2(CityBean cityBean) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> maps=addressDao.getCitysV2(cityBean.setParent_id("-1"));
		for (int i = 0; i < maps.size(); i++) {
			Map map=maps.get(i);
			List<Map<String, Object>> maps2=addressDao.getCitysV2(cityBean.setParent_id(map.get("value")+""));
//			for (int j = 0; j < maps2.size(); j++) {
//				Map map2=maps2.get(j);
//				List<Map<String, Object>> maps3=addressDao.getCitysV2(cityBean.setParent_id(map2.get("value")+""));
//				map2.put("children", maps3);
//			}
			map.put("children", maps2);
		}
		return maps;
	}
	
	@Override
	public Object insertAddress(AddressBean addressBean) {
		// TODO Auto-generated method stub
		if(addressBean.getAddress_id()==0) {
			List<AddressBean> addressBeans = addressDao.getMemberAddress(addressBean, new PageBean());
			if (addressBeans == null || addressBeans.size() == 0) {
				addressBean.setIs_default("1");
			} else {
				addressBean.setIs_default("0");
			}
		}
		int num = 0;
		if(addressBean.getAddress_id()==0) {
			num = addressDao.insertAddress(addressBean);
			if (num <= 0) {
				throw new AppException("地址添加失败");
			}
			return addressBean.getAddress_id();
		}else {
			num = addressDao.updateAddress(addressBean);
			if (num <= 0) {
				throw new AppException("地址修改失败");
			}
			return "修改成功";
		}
		
	}

	@Override
	public Object deleteAddress(AddressBean addressBean) {
		// TODO Auto-generated method stub
		int num = addressDao.deleteAddress(addressBean);
		if (num <= 0) {
			throw new AppException("删除地址失败");
		}
		/**
		 * 删除之后还要判断有没有默认地址
		 */
		List<AddressBean> addressBeans = addressDao.getMemberAddress(addressBean, new PageBean().setPageSize(1000));
		boolean is_have_default = false;

		if (addressBeans != null && addressBeans.size() > 0) {
			for (int i = 0; i < addressBeans.size(); i++) {
				if (addressBeans.get(i).getIs_default().equals("1")) {
					is_have_default = true;
					break;
				}
			}
			/**
			 * 如果没有默认,设置第一条为默认
			 */
			if (!is_have_default) {
				updateDefaultAddress(addressBeans.get(0));
			}
		}
		

		
		return num;
	}


	@Override
	public Object getMemberAddress(AddressBean addressBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<AddressBean> Address = addressDao.getMemberAddress(addressBean, pageBean);
		PageBean object = pageBean.setObject(Address);
		return object;
	}

	@Override
	public Object updateDefaultAddress(AddressBean addressBean) {
		// TODO Auto-generated method stub
		int num = addressDao.updateDefaultAddress(addressBean);
		if(num<=0){
			throw new AppException("设置失败");
		}
		return num;
	}

	@Override
	public Object updateAddress(AddressBean addressBean) {
		// TODO Auto-generated method stub
		int num = addressDao.updateAddress(addressBean);
		if(num<=0){
			throw new AppException("更新失败");
		}
		return num;
	}


	@Override
	public Object getDefaultAddress(AddressBean addressBean) {
		// TODO Auto-generated method stub
		AddressBean defaultAddress = addressDao.getDefaultAddress(addressBean);
		return defaultAddress;
	}


	@Override
	public AddressBean getAddressDetail(AddressBean addressBean) {
		// TODO Auto-generated method stub
		AddressBean addressDetail = addressDao.getAddressDetail(addressBean);
		return addressDetail;
	}

	@Override
	public Object getCityHots(CityHotBean cityHotBean) {
		// TODO Auto-generated method stub
		List<CityHotBean> cityHotBeans = addressDao.getCityHots(cityHotBean);
		return cityHotBeans;
	}

}
