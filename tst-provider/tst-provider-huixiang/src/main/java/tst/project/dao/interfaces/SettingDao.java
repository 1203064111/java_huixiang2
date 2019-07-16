package tst.project.dao.interfaces;

import java.util.List;

import tst.project.annotation.Mapper;
import tst.project.bean.CodeBean;
import tst.project.bean.hx.HXSettingBean;
import tst.project.bean.setting.AdviceBean;
import tst.project.bean.setting.BannerBean;
import tst.project.bean.setting.HotSearchBean;
import tst.project.bean.setting.HtmlBean;
import tst.project.bean.setting.PlatformBean;
import tst.project.page.PageBean;

@Mapper
public interface SettingDao {
	
	/**
	 * 平台基础信息
	 * @author sjb
	 * @param platformBean
	 * @return
	 */
	public PlatformBean getPlatformDetail(PlatformBean platformBean);
	/**
	 * 提交意见反馈
	 * @author sjb
	 * @param adviceBean
	 * @return
	 */
	public int insertAdvice(AdviceBean adviceBean);
	
	/**
	 * 获得android版本号
	 * @author sjb
	 * @return
	 */
	public String getAndroidVersion();
	
	
	
	/**
	 * 图文配置详情
	 * @param htmlBean
	 * @return
	 */
	public HtmlBean getHtmlDetail(HtmlBean htmlBean);
	
	
	/**
	 * 图文配置列表
	 * @author sjb
	 * @param htmlBean
	 * @return
	 */
	public List<HtmlBean> getHtmls(HtmlBean htmlBean);
	
	/**
	 * 热搜关键词列表
	 * @param hotSearchBean
	 * @return
	 */
	public List<HotSearchBean> getHotSearchs(HotSearchBean hotSearchBean,PageBean pageBean);
	
	/**
	 * 根据验证码获得验证信息
	 * @return
	 */
	public CodeBean getCodeBeanByMobile(CodeBean codeBean);
	
	/**
	 * 添加新的验证码
	 * @param codeBean
	 * @return
	 */
	public int insertCode(CodeBean codeBean);
	/**
	 * 修改验证码
	 * @param codeBean
	 * @return
	 */
	public int deleteCode(CodeBean codeBean);
	/**
	 * 验证手机号验证码是否匹配
	 * @param codeBean
	 * @return
	 */
	public CodeBean getCodeBeanByMobileAndCode(CodeBean codeBean);
	
	/**
	 * 删除验证码
	 * @param codeBean
	 * @return
	 */
	public int deleteCodeByMobileAndCode(CodeBean codeBean);


	/**
	 * 轮播列表
	 * @param bannerBean
	 * @return
	 */
	public List<BannerBean> getBanner(BannerBean bannerBean);
}
