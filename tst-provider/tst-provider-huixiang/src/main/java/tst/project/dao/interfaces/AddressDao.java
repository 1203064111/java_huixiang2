package tst.project.dao.interfaces;

import java.util.List;
import java.util.Map;

import tst.project.annotation.Mapper;
import tst.project.bean.member.AddressBean;
import tst.project.bean.member.CityHotBean;
import tst.project.bean.setting.CityBean;
import tst.project.page.PageBean;

@Mapper
public interface AddressDao {
	
	/**
	 * 获得市级列表（按字母做聚合）
	 * @return
	 */
	public List<Map<String,Object>> getCitysGroupPY();
	
	public List<CityBean> getCitysByPY(Map<String, Object> map); 
	
	/**
	 * 获得省市县列表
	 * @param cityBean
	 * @return
	 */
	public List<CityBean> getCitys(CityBean cityBean);
	
	public List<Map<String, Object>> getCitysV2(CityBean cityBean);
	
	/**
	 * 热门城市
	 * @author hwq
	 * @param cityBean
	 * @return
	 */
	public List<CityHotBean> getCityHots(CityHotBean cityHotBean);
	
	/**
	 * 添加用户地址
	 * @param addressBean
	 * @return
	 */
	public int insertAddress(AddressBean addressBean);
	
	/**
	 * 删除地址
	 * @param addressBean
	 * @return
	 */
	public int deleteAddress(AddressBean addressBean);
	
	/**
	 * 修改用户地址
	 * @param addressBean
	 * @return
	 */
	public int updateAddress(AddressBean addressBean);
	
	/**
	 * 
	 * 查询用户地址列表
	 * @param addressBean
	 * @param pageBean
	 * @return
	 */
	public List<AddressBean> getMemberAddress(AddressBean addressBean, PageBean pageBean);
	
	/**
	 * 设置用户默认地址
	 * @param addressBean
	 * @return
	 */
	public int updateDefaultAddress(AddressBean addressBean);
	
	/**
	 * 得到用户默认地址
	 * @param addressBean
	 * @return
	 */
	public AddressBean getDefaultAddress(AddressBean addressBean);
	
	/**
	 * 得到用户地址详情
	 * @param addressBean
	 * @return
	 */
	public AddressBean getAddressDetail(AddressBean addressBean);
}
