package tst.project.interfaces;

import tst.project.bean.member.AddressBean;
import tst.project.bean.member.CityHotBean;
import tst.project.bean.setting.CityBean;
import tst.project.page.PageBean;

public interface IAddressService {
    /**
     * 获得市级列表（按字母做聚合）
     *
     * @param cityBean
     * @return
     * @author sjb
     */
    Object getCitysGroupPY(CityBean cityBean);

    /**
     * 获得省市县列表
     *
     * @param cityBean
     * @return
     */
    Object getCitys(CityBean cityBean);

    /**
     * 热门城市
     *
     * @param cityBean
     * @return
     * @author hwq
     */
    public Object getCityHots(CityHotBean cityHotBean);

    /**
     * 获得省市县列表
     *
     * @param cityBean
     * @return
     */
    Object getCitysV2(CityBean cityBean);

    /**
     * 添加用户地址
     *
     * @param addressBean
     * @return
     */
    Object insertAddress(AddressBean addressBean);


    /**
     * 修改用户地址
     * @param addressBean
     * @return
     */
    Object updateAddress(AddressBean addressBean);

    /**
     * 删除地址
     *
     * @param addressBean
     * @return
     */
    Object deleteAddress(AddressBean addressBean);

    /**
     * 查询用户地址列表
     *
     * @param addressBean
     * @return
     */
    Object getMemberAddress(AddressBean addressBean, PageBean pageBean);

    /**
     * 设置用户默认地址
     *
     * @param addressBean
     * @return
     */
    Object updateDefaultAddress(AddressBean addressBean);

    /**
     * 得到用户默认地址
     *
     * @param addressBean
     * @return
     */
    Object getDefaultAddress(AddressBean addressBean);

    /**
     * 得到用户地址详情
     *
     * @param addressBean
     * @return
     */
    AddressBean getAddressDetail(AddressBean addressBean);
}
