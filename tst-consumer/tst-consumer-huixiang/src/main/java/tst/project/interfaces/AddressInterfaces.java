package tst.project.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tst.project.aspect.AppController;
import tst.project.bean.member.AddressBean;
import tst.project.bean.member.CityHotBean;
import tst.project.bean.setting.CityBean;
import tst.project.page.PageBean;

@Controller
@RequestMapping("/addressInterfaces/v1.0")
public class AddressInterfaces {
	
	@Autowired
	private IAddressService addressService;
	

	@RequestMapping("/getCitysGroupPY")
    @AppController
	public Object getCitysGroupPY(CityBean cityBean)throws Exception{
		Object object = addressService.getCitysGroupPY(cityBean);
    	return object;
	}
	
	
	
	/**
	 * 获得省市县列表
	 * @param cityBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getCitys")
    @AppController
	public Object getCitys(CityBean cityBean)throws Exception{
		Object object = addressService.getCitys(cityBean);
    	return object;
	}
	
	@RequestMapping("/getCityHots") 
    @AppController
    public Object getCityHots(CityHotBean cityHotBean) throws Exception{ 
		return addressService.getCityHots(cityHotBean);
	}
	
	/**
	 * 获得省市县列表
	 * @param cityBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getCitysV2")
    @AppController(isNeedPackage=false)
	public Object getCitysV2(CityBean cityBean)throws Exception{
		Object object = addressService.getCitysV2(cityBean);
    	return object;
	}
	
	 /**
     * 添加用户地址
     * @param addressBean
     * @return
     * @throws Exception
     */
    @RequestMapping("/insertAddress")
    @AppController(isVerToken=true)
    public Object insertAddress(AddressBean addressBean)throws Exception{
    	Object object = addressService.insertAddress(addressBean);
    	return object;
    } 
    
    /**
     * 删除地址
     * @param addressBean
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteAddress")
    @AppController(isVerToken=true)
    public Object deleteAddress(AddressBean addressBean)throws Exception{
    	Object object = addressService.deleteAddress(addressBean);
    	return object;
    }

	/**
	 * 修改地址
	 * @param addressBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateAddress")
	@AppController(isVerToken=true)
	public Object updateAddress(AddressBean addressBean)throws Exception{
		Object object = addressService.updateAddress(addressBean);
		return object;
	}

    /**
     * 查询用户地址列表
     * @param addressBean
     * @return
     * @throws Exception
     */
    @RequestMapping("/getMemberAddress")
    @AppController(isVerToken=true, isPage=true)
    public Object getMemberAddress(AddressBean addressBean, PageBean pageBean)throws Exception{
    	Object object = addressService.getMemberAddress(addressBean, pageBean);
    	return object;
    }
    
    /**
     * 设置用户默认地址
     * @param addressBean
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateDefaultAddress")
    @AppController(isVerToken=true)
    public Object updateDefaultAddress(AddressBean addressBean)throws Exception{
    	Object object = addressService.updateDefaultAddress(addressBean);
    	return object;
    }
    
    /**
     * 得到用户默认地址
     * @param addressBean
     * @return
     * @throws Exception
     */
    @RequestMapping("/getDefaultAddress")
    @AppController(isVerToken=true)
    public Object getDefaultAddress(AddressBean addressBean)throws Exception{
    	Object object = addressService.getDefaultAddress(addressBean);
    	return object;
    }
    
    /**
     * 得到用户地址详情
     * @param addressBean
     * @return
     * @throws Exception
     */
    @RequestMapping("/getAddressDetail")
    @AppController(isVerToken=true)
    public Object getAddressDetail(AddressBean addressBean)throws Exception{
    	Object object = addressService.getAddressDetail(addressBean);
    	return object;
    }
}
