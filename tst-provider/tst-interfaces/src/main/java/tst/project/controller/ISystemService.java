/**
 * 
 */
package tst.project.controller;

import java.util.List;

import tst.project.bean.setting.BannerBean;
import tst.project.bean.system.MoudleBean;
import tst.project.bean.system.RoleBean;
import tst.project.bean.system.SystemAccountBean;
import tst.project.bean.system.SystemLoginBean;
import tst.project.page.PageBean;

/**
 * @author sjb
 *
 */
public interface ISystemService {


	
	/**
	 * 分配角色权限
	 * 
	 * @param moudleBean
	 * @return
	 * @throws Exception
	 */
	public int updateRoleAuthority(MoudleBean moudleBean);
	
	/**
	 * 获得角色拥有权限
	 * 
	 * @param moudleBean
	 * @return
	 */
	public Object getRoleAuthoritys(MoudleBean moudleBean);
	/**
	 * 添加系统角色
	 * @param SystemAccountBean
	 * @return
	 */
	public Object insertSystemRole(RoleBean roleBean);
	
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
	public Object getSystemRoleDetail(RoleBean roleBean);
	
	/**
	 * 系统账号角色
	 * @param systemAccountBean
	 * @param pageBean
	 * @return
	 */
	public Object getSystemRoles(RoleBean roleBean,PageBean pageBean);
	
	public Object getSystemRolesNoPage(RoleBean roleBean);
	
	/**
	 * 账号详情
	 * @author sjb
	 * @param systemAccountBean
	 * @return
	 */
	public Object getSystemAccountDetail(SystemAccountBean systemAccountBean);
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
	public Object getSystemAccounts(SystemAccountBean systemAccountBean,PageBean pageBean);
	
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
	public Object getMoudles(MoudleBean moudleBean);
	/**
	 * 角色拥有的模块列表
	 * @param moudleBean
	 * @return
	 */
	public Object getRoleMoudles(MoudleBean moudleBean,int account_id1);
	
	/**
	 * 系统账号登录
	 * @param systemAccountBean
	 * @return
	 */
	public SystemAccountBean systemLogin(SystemAccountBean systemAccountBean,SystemLoginBean systemLoginBean);

	/**
	 * 获取Banner列表
	 * @param bannerBean
	 * @param pageBean
	 * @return
	 */
	public Object getBanner(BannerBean bannerBean, PageBean pageBean);

	/**
	 * 插入轮播图
	 * @param bannerBean
	 * @return
	 */
	public Object insertBanner(BannerBean bannerBean);

	/**
	 * 更新轮播图
	 * @param bannerBean
	 * @return
	 */
	public Object updateBanner(BannerBean bannerBean);

	/**
	 * 删除轮播图
	 * @param bannerBean
	 * @return
	 */
	public Object deleteBanner(BannerBean bannerBean);

	/**
	 * 查看轮播图信息
	 * @param bannerBean
	 * @return
	 */
	public Object getBannerDetail(BannerBean bannerBean);
}
