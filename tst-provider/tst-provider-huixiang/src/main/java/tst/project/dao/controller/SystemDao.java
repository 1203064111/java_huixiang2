package tst.project.dao.controller;

import java.util.List;

import tst.project.annotation.Mapper;
import tst.project.bean.setting.BannerBean;
import tst.project.bean.system.MoudleBean;
import tst.project.bean.system.RoleBean;
import tst.project.bean.system.SystemAccountBean;
import tst.project.bean.system.SystemLoginBean;
import tst.project.page.PageBean;

@Mapper
public interface SystemDao {
	

	

	/**
	 * 分配角色权限
	 * 
	 * @param moudleBean
	 * @return
	 * @throws Exception
	 */
	public int updateRoleAuthority(MoudleBean moudleBean);
	
	public int insertRoleAuthority(MoudleBean moudleBean);
	/**
	 * 获得角色拥有权限
	 * 
	 * @param moudleBean
	 * @return
	 */
	public List<MoudleBean> getRoleAuthoritys(MoudleBean moudleBean);
	
	/**
	 * 添加系统角色
	 * @param SystemAccountBean
	 * @return
	 */
	public int insertSystemRole(RoleBean roleBean);
	/**
	 * 修改系统角色
	 * @param SystemAccountBean
	 * @return
	 */
	public int updateSystemRole(RoleBean roleBean);
	
	/**
	 * 删除系统角色
	 * @param SystemAccountBean
	 * @return
	 */
	public int deleteSystemRole(RoleBean roleBean);
	/**
	 * 系统角色详情
	 * @param SystemAccountBean
	 * @return
	 */
	public RoleBean getSystemRoleDetail(RoleBean roleBean);
	
	/**
	 * 系统账号角色
	 * @param systemAccountBean
	 * @param pageBean
	 * @return
	 */
	public List<RoleBean> getSystemRoles(RoleBean roleBean,PageBean pageBean);
	
	public List<RoleBean> getSystemRolesNoPage(RoleBean roleBean);
	
	/**
	 * 添加系统账号
	 * @param SystemAccountBean
	 * @return
	 */
	public int insertSystemAccount(SystemAccountBean systemAccountBean);
	
	/**
	 * 修改系统账号
	 * @param SystemAccountBean
	 * @return
	 */
	public int updateSystemAccount(SystemAccountBean systemAccountBean);
	
	/**
	 * 修改商家账号姓名
	 * @author sjb
	 * @param systemAccountBean
	 * @return
	 */
	public int updateMerchantsAccount(SystemAccountBean systemAccountBean);
	
	/**
	 * 删除系统账号
	 * @param SystemAccountBean
	 * @return
	 */
	public int deleteSystemAccount(SystemAccountBean systemAccountBean);
	
	/**
	 * 系统账号列表
	 * @param systemAccountBean
	 * @param pageBean
	 * @return
	 */
	public List<SystemAccountBean> getSystemAccounts(SystemAccountBean systemAccountBean,PageBean pageBean);
	/**
	 * 添加系统模块
	 * @param moudleBean
	 * @param pageBean
	 * @return
	 */
	public int insertMoudle(MoudleBean moudleBean);
	
	/**
	 * 修改系统模块
	 * @param moudleBean
	 * @param pageBean
	 * @return
	 */
	public int updateMoudle(MoudleBean moudleBean);
	
	/**
	 * 删除系统模块
	 * @param moudleBean
	 * @param pageBean
	 * @return
	 */
	public int deleteMoudle(MoudleBean moudleBean);
	
	/**
	 * 模块详情
	 * @param moudleBean
	 * @return
	 */
	public Object getMoudleDetail(MoudleBean moudleBean);
	
	/**
	 * 模块列表
	 * @param moudleBean
	 * @return
	 */
	public List<MoudleBean> getMoudles(MoudleBean moudleBean);
	/**
	 * 账号详情
	 * @param systemAccountBean
	 * @return
	 */
	public SystemAccountBean getAccountDetail(SystemAccountBean systemAccountBean);
	
	/**
	 * 角色拥有的模块列表
	 * @param moudleBean
	 * @return
	 */
	public List<MoudleBean> getRoleMoudles(MoudleBean moudleBean);
	/**
	 * 系统用户登录
	 * @param systemAccountBean
	 * @return
	 */
	public SystemAccountBean systemLogin(SystemAccountBean systemAccountBean);
	
	/**
	 * 修改系统用户详情
	 * @param systemAccountBean
	 * @return
	 */
	public int updateSystemAccountDetail(SystemAccountBean systemAccountBean);

	/**
	 * 获取轮播列表
	 * @param bannerBean
	 * @param pageBean
	 * @return
	 */
	public List<BannerBean> getBanner(BannerBean bannerBean, PageBean pageBean);

	/**
	 * 插入轮播列表
	 * @param bannerBean
	 * @return
	 */
	public int insertBanner(BannerBean bannerBean);

	/**
	 * 更新轮播列表
	 * @param bannerBean
	 * @return
	 */
	public int updateBanner(BannerBean bannerBean);


	/**
	 * 删除轮播图
	 * @param bannerBean
	 * @return
	 */
	public int deleteBanner(BannerBean bannerBean);

	/**
	 * 查看轮播图详情
	 * @param bannerBean
	 * @return
	 */
	public Object getBannerDetail(BannerBean bannerBean);
}
