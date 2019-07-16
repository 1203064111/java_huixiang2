/**
 * 
 */
package tst.project.controller;

import java.util.List;

import tst.project.bean.member.CityHotBean;
import tst.project.bean.setting.AdviceBean;
import tst.project.bean.setting.CityBean;
import tst.project.bean.setting.HotSearchBean;
import tst.project.bean.setting.HtmlBean;
import tst.project.bean.setting.PercentBean;
import tst.project.bean.setting.PlatformBean;
import tst.project.page.PageBean;

/**
 * @author sjb
 *
 */
public interface ISettingServiceC {

	/**
	 * 修改基础信息
	 * @author sjb
	 * @param platformBean
	 * @return
	 */
	public Object updatePlatform(PlatformBean platformBean);
	/**
	 * 基础信息详情
	 * @author sjb
	 * @param platformBean
	 * @return
	 */
	public Object getPlatformDetail(PlatformBean platformBean);
	
	/**
	 * 建议列表
	 * @author sjb
	 * @param adviceBean
	 * @param pageBean
	 * @return
	 */
	public Object getAdvices(AdviceBean adviceBean,PageBean pageBean);
	/**
	 * 保存比例设置
	 * @author sjb
	 * @param percentBeans
	 * @return
	 */
	public Object updatePercents(List<PercentBean> percentBeans);
	/**
	 * 比例设置列表
	 * @author sjb
	 * @param percentBean
	 * @return
	 */
	public List<PercentBean> getPercents(PercentBean percentBean);
	
	/**
	 * 单层省市区
	 * @param cityBean
	 * @return
	 */
	public List<CityBean> getOneCitys(CityBean cityBean);
	
	/**
	 * 省市区列表
	 * @param cityBean
	 * @return
	 */
	public Object getCitys(CityBean cityBean);
	
	/**
	 * 热门城市
	 * @author hwq
	 * @param cityBean
	 * @return
	 */
	public Object getCityHots(CityHotBean cityHotBean, PageBean pageBean);
	
	/**
	 * 非热门城市
	 * @author hwq
	 * @param cityBean
	 * @return
	 */
	public Object getCityOutHots(CityBean cityBean);
	
	/**
	 * 添加热门城市
	 * @author hwq
	 * @param cityHotBean
	 * @return
	 */
	public Object insertCityHot(CityHotBean cityHotBean);
	
	/**
	 * 删除热门城市
	 * @author hwq
	 * @param cityHotBean
	 * @return
	 */
	public Object deleteCityHot(CityHotBean cityHotBean);
	
	/**
	 * 添加图文
	 * @param htmlBean
	 * @return
	 */
	public int insertHtml(HtmlBean htmlBean);
	
	/**
	 * 修改图文
	 * @param htmlBean
	 * @return
	 */
	public int updateHtml(HtmlBean htmlBean);
	
	/**
	 * 删除图文
	 * @param htmlBean
	 * @return
	 */
	public int deleteHtml(HtmlBean htmlBean);
	/**
	 * 图文详情
	 * @param htmlBean
	 * @return
	 */
	public Object getHtmlDetail(HtmlBean htmlBean);
	/**
	 * 图文列表
	 * @param htmlBean
	 * @return
	 */
	public Object getHtmls(HtmlBean htmlBean,PageBean pageBean);
	/**
	 * 添加热搜
	 * @author lx
	 * @param hotSearchBean
	 * @return
	 */
	public Object insertHotSearch(HotSearchBean hotSearchBean);
	
	/**
	 * 修改热搜关键字
	 * @author lx
	 * @param hotSearchBean
	 * @return
	 */
	public Object updateHotSearch(HotSearchBean hotSearchBean);
	
	/**
	 * 删除热搜关键字
	 * @author lx
	 * @param hotSearchBean
	 * @return
	 */
	public Object deleteHotSearch(HotSearchBean hotSearchBean);
	
	/**
	 * 热搜关键词列表
	 * @author lx
	 * @param hotSearchBean
	 * @param pageBean
	 * @return
	 */
	public Object getHotSearchs(HotSearchBean hotSearchBean,PageBean pageBean);
	
	/**
	 * 热搜详情
	 * @author lx
	 * @param hotSearchBean
	 * @return
	 */
	public Object getHotSearch(HotSearchBean hotSearchBean);

}
