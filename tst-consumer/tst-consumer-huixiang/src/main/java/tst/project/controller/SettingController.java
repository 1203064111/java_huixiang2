package tst.project.controller;

import org.aspectj.weaver.tools.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppController;
import tst.project.bean.member.CityHotBean;
import tst.project.bean.setting.AdviceBean;
import tst.project.bean.setting.CityBean;
import tst.project.bean.setting.HotSearchBean;
import tst.project.bean.setting.HtmlBean;
import tst.project.bean.setting.PercentBean;
import tst.project.bean.setting.PlatformBean;
import tst.project.page.PageBean;

@Controller
@RequestMapping("/settingController/v1.0")
public class SettingController {
	@Autowired
	ISettingServiceC settingService;

	
	
	@RequestMapping("/updatePlatform")
	@AppController(isVerSystemToken = true)
	public Object updatePlatform(PlatformBean platformBean) throws Exception {
		return settingService.updatePlatform(platformBean);
	}
	
	@RequestMapping("/getPlatformDetail")
	@AppController(isVerSystemToken = true)
	public Object getPlatformDetail(PlatformBean platformBean) throws Exception {
		return settingService.getPlatformDetail(platformBean);
	}
	
	
	@RequestMapping("/getAdvices")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getAdvices(AdviceBean adviceBean,PageBean pageBean) throws Exception {
		return settingService.getAdvices(adviceBean,pageBean);
	}
	
	@RequestMapping("/updatePercents")
	@AppController(isVerSystemToken = true)
	public Object updatePercents(String percents) throws Exception {
		return settingService.updatePercents(JSON.parseArray(percents, PercentBean.class));
	}
	
	@RequestMapping("/getPercents")
	@AppController(isVerSystemToken = true)
	public Object getPercents(PercentBean percentBean) throws Exception {
		return settingService.getPercents(percentBean);
	}
	
	@RequestMapping("/getCityHots")
	@AppController(isVerSystemToken = true, isPage = true)
	public Object getCityHots(CityHotBean cityHotBean, PageBean pageBean) throws Exception {
		return settingService.getCityHots(cityHotBean, pageBean);
	}

	@RequestMapping("/getCityOutHots")
	@AppController(isVerSystemToken = true)
	public Object getCityOutHots(CityBean cityBean) throws Exception {
		return settingService.getCityOutHots(cityBean);
	}

	@RequestMapping("/insertCityHot")
	@AppController(isVerSystemToken = true)
	public Object insertCityHot(CityHotBean cityHotBean) throws Exception {
		return settingService.insertCityHot(cityHotBean);
	}

	@RequestMapping("/deleteCityHot")
	@AppController(isVerSystemToken = true)
	public Object deleteCityHot(CityHotBean cityHotBean) throws Exception {
		return settingService.deleteCityHot(cityHotBean);
	}

	@RequestMapping("/getCitys")
	@AppController(isVerSystemToken = true)
	public Object getHtmls(CityBean cityBean) throws Exception {
		return settingService.getCitys(cityBean);
	}

	@RequestMapping("/getOneCitys")
	@AppController(isVerSystemToken = true)
	public Object getOneCitys(CityBean cityBean) throws Exception {
		return settingService.getOneCitys(cityBean);
	}

	/**
	 * 获取协议列表
	 * @param htmlBean
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getHtmls")
	@AppController(isVerSystemToken = true, isPage = true)
	public Object getHtmls(HtmlBean htmlBean, PageBean pageBean) throws Exception {
		return settingService.getHtmls(htmlBean, pageBean);
	}

	/**
	 * 获取协议详情
	 * @param htmlBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getHtmlDetail")
	@AppController(isVerSystemToken = true)
	public Object getHtmlDetail(HtmlBean htmlBean) throws Exception {
		return settingService.getHtmlDetail(htmlBean);
	}

	/**
	 * 插入协议
	 * @param htmlBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertHtml")
	@AppController(isVerSystemToken = true)
	public Object insertHtml(HtmlBean htmlBean) throws Exception {
		return settingService.insertHtml(htmlBean);
	}

	/**
	 * 更新协议
	 * @param htmlBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateHtml")
	@AppController(isVerSystemToken = true)
	public Object updateHtml(HtmlBean htmlBean) throws Exception {
		return settingService.updateHtml(htmlBean);
	}

	/**
	 * 删除协议
	 * @param htmlBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteHtml")
	@AppController(isVerSystemToken = true)
	public Object deleteHtml(HtmlBean htmlBean) throws Exception {
		return settingService.deleteHtml(htmlBean);
	}
	
	@RequestMapping("/insertHotSearch")
	@AppController(isVerSystemToken = true)
	public Object insertHotSearch(HotSearchBean hotSearchBean) throws Exception {
		return settingService.insertHotSearch(hotSearchBean);
	}
	
	@RequestMapping("/deleteHotSearch")
	@AppController(isVerSystemToken = true)
	public Object deleteHotSearch(HotSearchBean hotSearchBean) throws Exception {
		return settingService.deleteHotSearch(hotSearchBean);
	}
	
	@RequestMapping("/updateHotSearch")
	@AppController(isVerSystemToken = true)
	public Object updateHotSearch(HotSearchBean hotSearchBean) throws Exception {
		return settingService.updateHotSearch(hotSearchBean);
	}
	@RequestMapping("/getHotSearch")
	@AppController(isVerSystemToken = true)
	public Object getHotSearch(HotSearchBean hotSearchBean) throws Exception {
		return settingService.getHotSearch(hotSearchBean);
	}
	
	@RequestMapping("/getHotSearchs")
	@AppController(isVerSystemToken = true,isPage=true)
	public Object getHotSearchs(HotSearchBean hotSearchBean,PageBean pageBean) throws Exception {
		return settingService.getHotSearchs(hotSearchBean,pageBean);
	}

}
