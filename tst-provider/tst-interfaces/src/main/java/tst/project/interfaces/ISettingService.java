package tst.project.interfaces;

import com.alibaba.dubbo.container.page.Page;

import tst.project.bean.CodeBean;
import tst.project.bean.setting.AdviceBean;
import tst.project.bean.setting.BannerBean;
import tst.project.bean.setting.HotSearchBean;
import tst.project.bean.setting.HtmlBean;
import tst.project.bean.setting.PlatformBean;
import tst.project.page.PageBean;

public interface ISettingService {
	/**
	 * 获得微信权限
	 * @param url
	 * @return
	 */
	Object getWxAutho(String url);
	
	
	/**
	 * 平台基础信息
	 * @author sjb
	 * @param platformBean
	 * @return
	 */
	public Object getPlatformDetail(PlatformBean platformBean);
	
	/**
	 * 提交意见反馈
	 * @author sjb
	 * @param adviceBean
	 * @return
	 */
	public Object insertAdvice(AdviceBean adviceBean);
	
	/**
	 * 获得android版本号
	 * 
	 * @author sjb
	 * @return
	 */
	public Object getAndroidVersion();

	/**
	 * 阿里云发送验证码(加密)
	 * 
	 * @param codeBean
	 * @return
	 */
	public Object sendAliCode(CodeBean codeBean, String language);

	/**
	 * 图文配置详情
	 * 
	 * @param htmlBean
	 * @return
	 */
	public Object getHtmlDetail(HtmlBean htmlBean);

	/**
	 * 图文配置列表
	 * 
	 * @author sjb
	 * @param htmlBean
	 * @return
	 */
	public Object getHtmls(HtmlBean htmlBean);

	/**
	 * 获取轮播列表
	 * @param bannerBean
	 * @return
	 */
	public Object getBanner(BannerBean bannerBean, PageBean pageBean);
	
	/**
	 * 热搜关键词列表
	 * @author lx
	 * @param hotSearchBean
	 * @return
	 */
	public Object getHotSearchs(HotSearchBean hotSearchBean,PageBean pageBean);
}
