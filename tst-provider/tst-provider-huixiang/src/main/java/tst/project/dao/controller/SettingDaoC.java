package tst.project.dao.controller;

import java.util.List;

import tst.project.annotation.Mapper;
import tst.project.bean.member.CityHotBean;
import tst.project.bean.setting.AdviceBean;
import tst.project.bean.setting.CityBean;
import tst.project.bean.setting.HotSearchBean;
import tst.project.bean.setting.HtmlBean;
import tst.project.bean.setting.PercentBean;
import tst.project.bean.setting.PlatformBean;
import tst.project.page.PageBean;

@Mapper
public interface SettingDaoC {
	/**
	 * 修改基础信息
	 * @author sjb
	 * @param platformBean
	 * @return
	 */
	public int updatePlatform(PlatformBean platformBean);
	/**
	 * 基础信息详情
	 * @author sjb
	 * @param platformBean
	 * @return
	 */
	public PlatformBean getPlatformDetail(PlatformBean platformBean);
	/**
	 * 建议列表
	 * @author sjb
	 * @param adviceBean
	 * @param pageBean
	 * @return
	 */
	public List<AdviceBean> getAdvices(AdviceBean adviceBean,PageBean pageBean);
	/**
	 * 保存比例设置
	 * @author sjb
	 * @param percentBeans
	 * @return
	 */
	public int updatePercent(PercentBean percentBean);
	/**
	 * 比例设置列表
	 * @author sjb
	 * @param percentBean
	 * @return
	 */
	public List<PercentBean> getPercents(PercentBean percentBean);
	/**
	 * 比例详情
	 * @param percentBean
	 * @return
	 */
	public PercentBean getPercentDetail(PercentBean percentBean);
	
	/**
	 * 单层省市区列表
	 * 
	 * @param cityBean
	 * @return
	 */
	public List<CityBean> getOneCitys(CityBean cityBean);

	/**
	 * 三层省市区列表
	 * 
	 * @param cityBean
	 * @return
	 */
	public List<CityBean> getCitys(CityBean cityBean);

	/**
	 * 热门城市
	 * 
	 * @author hwq
	 * @param cityBean
	 * @return
	 */
	public List<CityHotBean> getCityHots(CityHotBean cityHotBean, PageBean pageBean);

	/**
	 * 非热门城市
	 * 
	 * @author hwq
	 * @param cityBean
	 * @return
	 */
	public List<CityBean> getCityOutHots(CityBean cityBean);

	/**
	 * 添加热门城市
	 * 
	 * @author hwq
	 * @param cityHotBean
	 * @return
	 */
	public int insertCityHot(CityHotBean cityHotBean);

	/**
	 * 删除热门城市
	 * 
	 * @author hwq
	 * @param cityHotBean
	 * @return
	 */
	public int deleteCityHot(CityHotBean cityHotBean);

	/**
	 * 添加图文
	 * 
	 * @param htmlBean
	 * @return
	 */
	public int insertHtml(HtmlBean htmlBean);

	/**
	 * 修改图文
	 * 
	 * @param htmlBean
	 * @return
	 */
	public int updateHtml(HtmlBean htmlBean);

	/**
	 * 删除图文
	 * 
	 * @param htmlBean
	 * @return
	 */
	public int deleteHtml(HtmlBean htmlBean);

	/**
	 * 图文详情
	 * 
	 * @param htmlBean
	 * @return
	 */
	public HtmlBean getHtmlDetail(HtmlBean htmlBean);

	/**
	 * 图文列表
	 * @param htmlBean
	 * @return
	 */
	public List<HtmlBean> getHtmls(HtmlBean htmlBean, PageBean pageBean);
	
	/**
	 * 添加热搜关键字
	 * @param hotSearchBean
	 * @return
	 */
	public int insertHotSearch(HotSearchBean hotSearchBean);
	/**
	 * 修改热搜关键词
	 * @param hotSearchBean
	 * @return
	 */
	public int updateHotSearch(HotSearchBean hotSearchBean);
	/**
	 * 删除热搜关键字
	 * @param hotSearchBean
	 * @return
	 */
	public int deleteHotSearch(HotSearchBean hotSearchBean);
	/**
	 * 热搜关键词列表
	 * @param hotSearchBean
	 * @param pageBean
	 * @return
	 */
	public List<HotSearchBean> getHotSearchs(HotSearchBean hotSearchBean,PageBean pageBean);
	/**
	 * 热搜关键词详情
	 * @param hotSearchBean
	 * @return
	 */
	public HotSearchBean getHotSearch(HotSearchBean hotSearchBean);

}
