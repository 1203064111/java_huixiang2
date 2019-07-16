package tst.project.service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.aspect.AppException;
import tst.project.bean.member.CityHotBean;
import tst.project.bean.setting.BannerBean;
import tst.project.bean.system.MoudleBean;
import tst.project.bean.system.RoleBean;
import tst.project.bean.system.SystemAccountBean;
import tst.project.bean.system.SystemLoginBean;
import tst.project.controller.ISystemService;
import tst.project.dao.controller.SystemDao;
import tst.project.page.PageBean;
import tst.project.utils.MD5Util;
import tst.project.utils.NumberUtils;
import tst.project.utils.RedisUtils;
import tst.project.utils.RongCloudUtils;
import tst.project.utils.StringUtils;

@Service
@Transactional
public class SystemService implements ISystemService {

    @Autowired
    SystemDao systemDao;


    @Value("${rongcloud_AppID}")
    private String rongcloud_AppID;

    @Value("${rongcloud_AppSecret}")
    private String rongcloud_AppSecret;

    @Value("${img_url}")
    private String img_url;
    @Value("${appcode}")
    private String appcode;


    /**
     * 分配角色权限
     *
     * @param moudleBean
     * @return
     * @throws Exception
     */
    @Override
    public int updateRoleAuthority(MoudleBean moudleBean) {
        systemDao.updateRoleAuthority(moudleBean);

//		List<MoudleBean> moudleBeans = moudleBean.getMenuBeans();
//		if (moudleBeans != null) {
//			if(moudleBeans.size()>0){
//				int m = systemDao.insertRoleAuthority(moudleBean);
//				if(m<=0){
//					throw new AppException("保存失败");
//				}
//				insertMoudleBeans(moudleBean, moudleBeans);
//			}
//		}
        return 1;
    }

    public int insertMoudleBeans(MoudleBean moudleBean, List<MoudleBean> moudleBeans) {
        for (int i = 0; i < moudleBeans.size(); i++) {
            if (moudleBeans.get(i).getIs_authority().equals("1")) {
                int k = systemDao.insertRoleAuthority(moudleBeans.get(i));
                if (k < 0) {
                    throw new AppException("权限添加失败");
                }
            }
        }
        return 1;
    }

    /**
     * 获得角色拥有权限
     *
     * @param moudleBean
     * @return
     */
    @Override
    public List<MoudleBean> getRoleAuthoritys(MoudleBean moudleBean) {
        List<MoudleBean> moudleBeans = systemDao.getRoleAuthoritys(moudleBean.setParent_id("-1"));
//		for (int i = 0; i < moudleBeans.size(); i++) {
//			List<MoudleBean> menuBeans = systemDao
//					.getRoleAuthoritys(moudleBean.setParent_id(moudleBeans.get(i).getMoudle_id() + ""));
//			if(menuBeans==null||menuBeans.size()<=0){
//				moudleBeans.get(i).setIs_authority("0");
//			}else{
//				boolean is_authority=true;
//				for (int j = 0; j < menuBeans.size(); j++) {
//					if(!"1".equals(menuBeans.get(j).getIs_authority())){
//						is_authority=false;
//						break;
//					}
//				}
//				if(!is_authority){
//					moudleBeans.get(i).setIs_authority("0");
//				}
//			}
//			
//			
//			moudleBeans.get(i).setMenuBeans(menuBeans);
//		}
        return moudleBeans;
    }

    /**
     * 添加系统角色
     *
     * @param SystemAccountBean
     * @return
     */
    @Override
    public Object insertSystemRole(RoleBean roleBean) {
        int num = systemDao.insertSystemRole(roleBean);
        if (num <= 0) {
            throw new AppException("添加失败");
        }
        return "添加成功";
    }

    /**
     * 修改系统角色
     *
     * @param SystemAccountBean
     * @return
     */
    @Override
    public int updateSystemRole(RoleBean roleBean) {
        int num = systemDao.updateSystemRole(roleBean);
        if (num <= 0) {
            throw new AppException("修改失败");
        }
        return num;
    }

    /**
     * 删除系统角色
     *
     * @param SystemAccountBean
     * @return
     */
    @Override
    public int deleteSystemRole(RoleBean roleBean) {
        int num = systemDao.deleteSystemRole(roleBean);
        if (num <= 0) {
            throw new AppException("删除失败");
        }
        return num;
    }

    @Override
    public Object getSystemRoleDetail(RoleBean roleBean) {
        // TODO Auto-generated method stub
        return systemDao.getSystemRoleDetail(roleBean);
    }

    /**
     * 系统账号角色
     *
     * @param systemAccountBean
     * @param pageBean
     * @return
     */
    @Override
    public Object getSystemRoles(RoleBean roleBean, PageBean pageBean) {
        List<RoleBean> roleBeans = systemDao.getSystemRoles(roleBean, pageBean);
        return pageBean.setObject(roleBeans);
    }

    @Override
    public Object getSystemRolesNoPage(RoleBean roleBean) {
        return systemDao.getSystemRolesNoPage(roleBean);
    }

    @Override
    public Object getSystemAccountDetail(SystemAccountBean systemAccountBean) {
        // TODO Auto-generated method stub
        return systemDao.getAccountDetail(systemAccountBean);
    }

    /**
     * 添加系统账号
     *
     * @param SystemAccountBean
     * @return
     */
    @Override
    public int insertSystemAccount(SystemAccountBean systemAccountBean) {

        SystemAccountBean systemAccountBean2 = systemDao.getAccountDetail(systemAccountBean);
        if (systemAccountBean2 != null) {
            throw new AppException("账号已存在!");
        }
        String system_password = "";
        try {
            system_password = MD5Util.md5Encode(systemAccountBean.getSystem_password());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new AppException("密码加密失败!");
        }
        String system_token = UUID.randomUUID().toString();


        int num = systemDao.insertSystemAccount(systemAccountBean
                .setSystem_password(system_password)
                .setSystem_token(system_token));
        if (num <= 0) {
            throw new AppException("添加失败!");
        }


        return num;
    }

    @Override
    public int updateMerchantsAccount(SystemAccountBean systemAccountBean) {
        // TODO Auto-generated method stub
        return systemDao.updateMerchantsAccount(systemAccountBean);
    }

    /**
     * 修改系统账号
     *
     * @param SystemAccountBean
     * @return
     */
    @Override
    public int updateSystemAccount(SystemAccountBean systemAccountBean) {
        if (systemAccountBean.getSystem_password() != null && !"".equals(systemAccountBean.getSystem_password())) {
            String system_password = "";
            try {
                system_password = MD5Util.md5Encode(systemAccountBean.getSystem_password());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                throw new AppException("密码加密失败!");
            }
            systemAccountBean.setSystem_password(system_password);
        }
        int num = systemDao.updateSystemAccount(systemAccountBean);
        if (num <= 0) {
            throw new AppException("修改失败!");
        }
        return num;
    }

    /**
     * 删除系统账号
     *
     * @param SystemAccountBean
     * @return
     */
    @Override
    public int deleteSystemAccount(SystemAccountBean systemAccountBean) {
        int num = systemDao.deleteSystemAccount(systemAccountBean);
        if (num <= 0) {
            throw new AppException("删除失败!");
        }
        return num;
    }

    /**
     * 系统账号列表
     *
     * @param systemAccountBean
     * @param pageBean
     * @return
     */
    @Override
    public Object getSystemAccounts(SystemAccountBean systemAccountBean, PageBean pageBean) {
        List<SystemAccountBean> systemAccountBeans = systemDao.getSystemAccounts(systemAccountBean, pageBean);
        return pageBean.setObject(systemAccountBeans);
    }

    /**
     * 添加系统模块
     *
     * @param moudleBean
     * @param pageBean
     * @return
     */
    @Override
    public int insertMoudle(MoudleBean moudleBean) {

        String moudle_uuid = UUID.randomUUID().toString();

        int num = systemDao.insertMoudle(moudleBean.setMoudle_uuid(moudle_uuid));
        if (num <= 0) {
            throw new AppException("添加失败");
        }
        return num;
    }

    /**
     * 修改系统模块
     *
     * @param moudleBean
     * @param pageBean
     * @return
     */
    @Override
    public int updateMoudle(MoudleBean moudleBean) {
        int num = systemDao.updateMoudle(moudleBean);
        if (num <= 0) {
            throw new AppException("修改失败");
        }
        return num;
    }

    /**
     * 删除系统模块
     *
     * @param moudleBean
     * @param pageBean
     * @return
     */
    @Override
    public int deleteMoudle(MoudleBean moudleBean) {
        int num = systemDao.deleteMoudle(moudleBean);
        if (num <= 0) {
            throw new AppException("删除失败");
        }
        return num;
    }

    @Override
    public Object getMoudles(MoudleBean moudleBean) {
        return systemDao.getMoudles(moudleBean);
    }

    @Override
    public Object getMoudleDetail(MoudleBean moudleBean) {
        // TODO Auto-generated method stub
        return systemDao.getMoudleDetail(moudleBean);
    }

    @Override
    public Object getRoleMoudles(MoudleBean moudleBean, int account_id) {

        SystemAccountBean systemAccountBean = systemDao.getAccountDetail(new SystemAccountBean().setAccount_id(account_id));
        moudleBean.setRole_id(systemAccountBean.getRole_id());

        List<MoudleBean> moudleBeans = systemDao.getRoleMoudles(moudleBean.setParent_id("-1"));
//		if(moudleBeans!=null){
//			for (int i = 0; i < moudleBeans.size(); i++) {
//				MoudleBean moudleBean2=moudleBeans.get(i);
//				List<MoudleBean> menuBeans=systemDao.getRoleMoudles(moudleBean.setParent_id(moudleBean2.getMoudle_id()+""));
//				moudleBean2.setMenuBeans(menuBeans);
//			}
//		}
        return moudleBeans;
    }

    @Override
    public SystemAccountBean systemLogin(SystemAccountBean systemAccountBean, SystemLoginBean systemLoginBean) {
        // TODO Auto-generated method stub
        SystemAccountBean systemAccountBean2 = systemDao.systemLogin(systemAccountBean);
        if (systemAccountBean2 == null) {
            throw new AppException("账号不存在!");
        }

        String pas;
        try {
            pas = MD5Util.md5Encode(systemAccountBean.getSystem_password());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new AppException("密码加密失败!");
        }
        if (!systemAccountBean2.getSystem_password().equals(pas)) {
            throw new AppException("密码不正确!");
        }
        UUID uuid = UUID.randomUUID();

        int num = systemDao.updateSystemAccountDetail(new SystemAccountBean()
                .setAccount_id(systemAccountBean2.getAccount_id())
                .setSystem_token(uuid.toString()));
        if (num <= 0) {
            throw new AppException("更新token失败");
        }


        boolean is_success = RedisUtils.setKey("account_id" + systemAccountBean2.getAccount_id(), uuid.toString());
        if (!is_success) {
            throw new AppException("缓存失败!");
        }


        return systemAccountBean2.setSystem_token(uuid.toString());
    }

    @Override
    public Object getBanner(BannerBean bannerBean, PageBean pageBean) {
        List<BannerBean> bannerBeans = systemDao.getBanner(bannerBean, pageBean);
        return pageBean.setObject(bannerBeans);
    }

    @Override
    public Object insertBanner(BannerBean bannerBean) {

        int num = systemDao.insertBanner(bannerBean);
        if (num < 0) {
            throw new AppException("插入轮播列表失败");
        }
        return num;
    }

    @Override
    public Object updateBanner(BannerBean bannerBean) {
        int num = systemDao.updateBanner(bannerBean);
        if (num < 0) {
            throw new AppException("修改轮播列表失败");
        }
        return num;
    }

    @Override
    public Object deleteBanner(BannerBean bannerBean) {
        int num = systemDao.deleteBanner(bannerBean);
        if (num < 0) {
            throw new AppException("删除轮播列表失败");
        }
        return num;
    }

    @Override
    public Object getBannerDetail(BannerBean bannerBean) {
        return systemDao.getBannerDetail(bannerBean);
    }


}
