package tst.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppController;
import tst.project.bean.setting.BannerBean;
import tst.project.bean.system.MoudleBean;
import tst.project.bean.system.RoleBean;
import tst.project.bean.system.SystemAccountBean;
import tst.project.bean.system.SystemLoginBean;
import tst.project.page.PageBean;

@Controller
@RequestMapping("/systemController/v1.0")
public class SystemController {
	@Autowired
	ISystemService systemService;
	

	
	@RequestMapping("/updateRoleAuthority") 
    @AppController(isVerSystemToken=true)
    public Object updateRoleAuthority(MoudleBean moudleBean) throws Exception{ 

		return systemService.updateRoleAuthority(moudleBean);
	}
	
	@RequestMapping("/updateRoleAuthoritys") 
    @AppController(isVerSystemToken=true)
    public Object updateRoleAuthoritys(String json) throws Exception{ 
		List<MoudleBean> moudleBeans=JSON.parseArray(json, MoudleBean.class);
		if(moudleBeans!=null){
			for (int i = 0; i < moudleBeans.size(); i++) {
				systemService.updateRoleAuthority(moudleBeans.get(i));
			}
		}
		return "成功";
	}
	
	@RequestMapping("/getRoleAuthoritys") 
    @AppController(isVerSystemToken=true)
    public Object getRoleAuthoritys(MoudleBean moudleBean) throws Exception{ 
		return systemService.getRoleAuthoritys(moudleBean);
	}
	
	@RequestMapping("/insertSystemRole") 
    @AppController(isVerSystemToken=true)
    public Object insertSystemRole(RoleBean roleBean) throws Exception{ 
		return systemService.insertSystemRole(roleBean);
	}
	
	@RequestMapping("/updateSystemRole") 
    @AppController(isVerSystemToken=true)
    public Object updateSystemRole(RoleBean roleBean) throws Exception{ 
		return systemService.updateSystemRole(roleBean);
	}
	
	@RequestMapping("/deleteSystemRole") 
    @AppController(isVerSystemToken=true)
    public Object deleteSystemRole(RoleBean roleBean) throws Exception{ 
		return systemService.deleteSystemRole(roleBean);
	}
	
	@RequestMapping("/getSystemRoleDetail") 
    @AppController(isVerSystemToken=true)
    public Object getSystemRoleDetail(RoleBean roleBean) throws Exception{ 
		return systemService.getSystemRoleDetail(roleBean);
	}
	
	@RequestMapping("/getSystemRoles") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getSystemRoles(RoleBean roleBean,PageBean pageBean) throws Exception{ 
		return systemService.getSystemRoles(roleBean,pageBean);
	}
	
	@RequestMapping("/getSystemRolesNoPage") 
    @AppController(isVerSystemToken=true)
    public Object getSystemRolesNoPage(RoleBean roleBean) throws Exception{ 
		return systemService.getSystemRolesNoPage(roleBean);
	}
	
	@RequestMapping("/getSystemAccountDetail") 
    @AppController(isVerSystemToken=true)
    public Object getSystemAccountDetail(SystemAccountBean systemAccountBean) throws Exception{ 
		return systemService.getSystemAccountDetail(systemAccountBean);
	}
	
	@RequestMapping("/insertSystemAccount") 
    @AppController(isVerSystemToken=true)
    public Object insertSystemAccount(SystemAccountBean systemAccountBean) throws Exception{ 
		return systemService.insertSystemAccount(systemAccountBean);
	}
	
	@RequestMapping("/updateSystemAccount") 
    @AppController(isVerSystemToken=true)
    public Object updateSystemAccount(SystemAccountBean systemAccountBean) throws Exception{ 
		return systemService.updateSystemAccount(systemAccountBean);
	}
	
	@RequestMapping("/deleteSystemAccount") 
    @AppController(isVerSystemToken=true)
    public Object deleteSystemAccount(SystemAccountBean systemAccountBean) throws Exception{ 
		return systemService.deleteSystemAccount(systemAccountBean);
	}
	
	@RequestMapping("/getSystemAccounts") 
    @AppController(isVerSystemToken=true,isPage=true)
    public Object getSystemAccounts(SystemAccountBean systemAccountBean,PageBean pageBean) throws Exception{ 
		return systemService.getSystemAccounts(systemAccountBean,pageBean);
	}
	
	
	@RequestMapping("/insertMoudle") 
    @AppController(isVerSystemToken=true)
    public Object insertMoudle(MoudleBean moudleBean) throws Exception{ 
		return systemService.insertMoudle(moudleBean);
	}
	
	@RequestMapping("/updateMoudle") 
    @AppController(isVerSystemToken=true)
    public Object updateMoudle(MoudleBean moudleBean) throws Exception{ 
		return systemService.updateMoudle(moudleBean);
	}
	
	@RequestMapping("/deleteMoudle") 
    @AppController(isVerSystemToken=true)
    public Object deleteMoudle(MoudleBean moudleBean) throws Exception{ 
		return systemService.deleteMoudle(moudleBean);
	}
	@RequestMapping("/getMoudleDetail") 
    @AppController(isVerSystemToken=true)
    public Object getMoudleDetail(MoudleBean moudleBean) throws Exception{ 
		return systemService.getMoudleDetail(moudleBean);
	}
	
	@RequestMapping("/getMoudles") 
    @AppController(isVerSystemToken=true)
    public Object getMoudles(MoudleBean moudleBean) throws Exception{ 
		return systemService.getMoudles(moudleBean);
	}
	/**
	 * 系统用户登录
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/systemLogin") 
    @AppController
    public Object systemLogin(SystemAccountBean systemAccountBean,SystemLoginBean systemLoginBean) throws Exception{ 
		return systemService.systemLogin(systemAccountBean,systemLoginBean);
	}
	/**
	 *  角色拥有的模块列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getRoleMoudles") 
    @AppController(isVerSystemToken=true)
    public Object getRoleMoudles(MoudleBean moudleBean,int account_id1) throws Exception{ 
		return systemService.getRoleMoudles(moudleBean,account_id1);
	}
	/**
	 * 轮播列表
	 */
	@RequestMapping("/getBanner")
	@AppController(isVerSystemToken = true, isPage = true)
	public Object getBanner(BannerBean bannerBean, PageBean pageBean) throws Exception{
		return systemService.getBanner(bannerBean,pageBean);
	}

	/**
	 * 插入轮播图
	 * @param bannerBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertBanner")
	@AppController(isVerSystemToken=true)
	public Object insertBanner(BannerBean bannerBean) throws Exception{
		return systemService.insertBanner(bannerBean);
	}

	/**
	 * 更新轮播图
	 * @param bannerBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateBanner")
	@AppController(isVerSystemToken=true)
	public Object updateBanner(BannerBean bannerBean) throws Exception{
		return systemService.updateBanner(bannerBean);
	}

	/**
	 * 删除轮播图
	 * @param bannerBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteBanner")
	@AppController(isVerSystemToken=true)
	public Object deleteBanner(BannerBean bannerBean) throws Exception{
		return systemService.deleteBanner(bannerBean);
	}

	/**
	 * 轮播图详情
	 * @param bannerBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getBannerDetail")
	@AppController(isVerSystemToken=true)
	public Object getBannerDetail(BannerBean bannerBean) throws Exception{
		return systemService.getBannerDetail(bannerBean);
	}

}
