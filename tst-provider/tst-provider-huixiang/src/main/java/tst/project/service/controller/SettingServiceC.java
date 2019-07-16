package tst.project.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppException;
import tst.project.bean.member.CityHotBean;
import tst.project.bean.setting.AdviceBean;
import tst.project.bean.setting.CityBean;
import tst.project.bean.setting.HotSearchBean;
import tst.project.bean.setting.HtmlBean;
import tst.project.bean.setting.PercentBean;
import tst.project.bean.setting.PlatformBean;
import tst.project.controller.ISettingServiceC;
import tst.project.dao.controller.SettingDaoC;
import tst.project.page.PageBean;
import tst.project.utils.RedisUtils;

@Service 
@Transactional(rollbackFor=AppException.class)
public class SettingServiceC implements ISettingServiceC{
	@Autowired
	SettingDaoC settingDaoC;
	
	@Override
	public Object getPlatformDetail(PlatformBean platformBean) {
		// TODO Auto-generated method stub
		return settingDaoC.getPlatformDetail(platformBean);
	}
	
	@Override
	public Object updatePlatform(PlatformBean platformBean) {
		// TODO Auto-generated method stub
		int num=settingDaoC.updatePlatform(platformBean);
		if(num<=0){
			throw new AppException("保存失败!");
		}
		return num;
	}
	
	@Override
	public Object getAdvices(AdviceBean adviceBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<AdviceBean> adviceBeans=settingDaoC.getAdvices(adviceBean, pageBean);
		return pageBean.setObject(adviceBeans);
	}
	@Override
	public Object updatePercents(List<PercentBean> percentBeans) {
		// TODO Auto-generated method stub
		for (int i = 0; i < percentBeans.size(); i++) {
			PercentBean percentBean=percentBeans.get(i);
			int num=settingDaoC.updatePercent(percentBean);
			if(num<=0){
				throw new AppException("保存失败!");
			}
		}
		return 1;
	}
	
	@Override
	public List<PercentBean> getPercents(PercentBean percentBean) {
		// TODO Auto-generated method stub
		return settingDaoC.getPercents(percentBean);
	}
	
	@Override
	public List<CityBean> getOneCitys(CityBean cityBean) {
		// TODO Auto-generated method stub
		return settingDaoC.getOneCitys(cityBean);
	}
	
	@Override
	public Object getCitys(CityBean cityBean) {
		// TODO Auto-generated method stub
		String citys=RedisUtils.getKey("citys");
				
		List<CityBean> cityBeans=null;
		if(citys==null||citys.equals("")){
			cityBeans=settingDaoC.getCitys(cityBean);
			boolean is_success=RedisUtils.setKey("citys", JSON.toJSONString(cityBeans));
			if(!is_success){
				throw new AppException("缓存失败!");
			}
		}else{
			cityBeans=JSON.parseArray(citys, CityBean.class);
		}
		
		return cityBeans;
	}
	
	@Override
	public Object getCityHots(CityHotBean cityHotBean, PageBean pageBean) {
		List<CityHotBean> cityHotBeans = settingDaoC.getCityHots(cityHotBean, pageBean);
		return pageBean.setObject(cityHotBeans);
	}
	
	@Override
	public Object getCityOutHots(CityBean cityBean) {
		List<CityBean> cityBeans = settingDaoC.getCityOutHots(cityBean);
		return cityBeans;
	}

	@Override
	public Object insertCityHot(CityHotBean cityHotBean) {
		int num = settingDaoC.insertCityHot(cityHotBean);
		if(num <= 0) {
			throw new AppException("添加失败");
		}
		return num;
	}
	
	@Override
	public Object deleteCityHot(CityHotBean cityHotBean) {
		int num = settingDaoC.deleteCityHot(cityHotBean);
		if(num <= 0) {
			throw new AppException("删除失败");
		}
		return num;
	}
	
	@Override
	public int insertHtml(HtmlBean htmlBean) {
		// TODO Auto-generated method stub
		int num=settingDaoC.insertHtml(htmlBean);
		if(num<=0){
			throw new AppException("添加失败!");
		}
		return num;
	}

	
	
	@Override
	public int updateHtml(HtmlBean htmlBean) {
		// TODO Auto-generated method stub
		int num=settingDaoC.updateHtml(htmlBean);
		if(num<=0){
			throw new AppException("修改失败!");
		}
		return num;
	}

	@Override
	public int deleteHtml(HtmlBean htmlBean) {
		// TODO Auto-generated method stub
		int num=settingDaoC.deleteHtml(htmlBean);
		if(num<=0){
			throw new AppException("删除失败!");
		}
		return num;
	}

	@Override
	public Object getHtmlDetail(HtmlBean htmlBean) {
		// TODO Auto-generated method stub
		return settingDaoC.getHtmlDetail(htmlBean);
	}

	@Override
	public Object getHtmls(HtmlBean htmlBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<HtmlBean> htmlBeans=settingDaoC.getHtmls(htmlBean, pageBean);
		return pageBean.setObject(htmlBeans);
	}

	@Override
	public Object insertHotSearch(HotSearchBean hotSearchBean) {
		int num = settingDaoC.insertHotSearch(hotSearchBean);
		if(num <= 0){
			throw new AppException("添加失败!");
		}
		return num;
	}

	@Override
	public Object updateHotSearch(HotSearchBean hotSearchBean) {
		int num = settingDaoC.updateHotSearch(hotSearchBean);
		if(num <= 0){
			throw new AppException("修改失败!");
		}
		return num;
	}

	@Override
	public Object deleteHotSearch(HotSearchBean hotSearchBean) {
		int num = settingDaoC.deleteHotSearch(hotSearchBean);
		if(num <= 0){
			throw new AppException("删除失败!");
		}
		return num;
	}

	@Override
	public Object getHotSearchs(HotSearchBean hotSearchBean, PageBean pageBean) {
		return pageBean.setObject(settingDaoC.getHotSearchs(hotSearchBean, pageBean));
	}

	@Override
	public Object getHotSearch(HotSearchBean hotSearchBean) {
		// TODO Auto-generated method stub
		return settingDaoC.getHotSearch(hotSearchBean);
	}


}
