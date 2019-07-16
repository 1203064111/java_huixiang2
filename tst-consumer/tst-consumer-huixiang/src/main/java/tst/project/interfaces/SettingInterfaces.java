package tst.project.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import tst.project.BaseController;
import tst.project.aspect.AppController;
import tst.project.aspect.AppException;
import tst.project.bean.CodeBean;
import tst.project.bean.setting.AdviceBean;
import tst.project.bean.setting.BannerBean;
import tst.project.bean.setting.HotSearchBean;
import tst.project.bean.setting.HtmlBean;
import tst.project.bean.setting.PlatformBean;
import tst.project.page.PageBean;
import tst.project.utils.WXUtils;

@Controller
@RequestMapping("/settingInterfaces/v1.0")
public class SettingInterfaces extends BaseController{

	@Autowired
    private ISettingService settingService;
	
	@Value("${wx_lite_AppID}")
	private String wx_lite_AppID;

	@Value("${wx_lite_AppSecret}")
	private String wx_lite_AppSecret;
	
	@Value("${img_path}")
	private String img_path;
	
	@Value("${img_url}")
	private String img_url;
	/**
	 * 
	 * 
	 * @param percentBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getWXACodeUnlimit") 
    @AppController
	public Object getWXACodeUnlimit(String scene,String page)throws Exception {
		return img_url+WXUtils.getWXACodeUnlimit(wx_lite_AppID, wx_lite_AppSecret,scene,page,img_path);
	}
	
	
	/**
	 * 获得微信分享权限
	 * 
	 * @param percentBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getWxAutho") 
    @AppController
	public Object getWxAutho(String url)throws Exception {
		return settingService.getWxAutho(url);
	}
	
	@RequestMapping("/getPlatformDetail") 
    @AppController
    public Object getPlatformDetail(PlatformBean platformBean) throws Exception{ 
        return settingService.getPlatformDetail(platformBean);
    }
	
	@RequestMapping("/insertAdvice") 
    @AppController(isVerToken=true)
    public Object insertAdvice(AdviceBean adviceBean) throws Exception{ 
    	Object object=settingService.insertAdvice(adviceBean);
        return object;   
    }
	
	
	@RequestMapping("/getAndroidVersion") 
    @AppController
    public Object getAndroidVersion() throws Exception{ 
		return settingService.getAndroidVersion();
    }

	/**
	 * 获取验证码
	 * @param codeBean
	 * @param language
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping("/sendAliCode") 
    @AppController
    public Object sendAliCode(CodeBean codeBean, String language) throws Exception{ 
    	Object obejct=settingService.sendAliCode(codeBean,language);
        return obejct;   
    }
	
	
	@RequestMapping("/uploadImg") 
    @AppController
    public Object uploadImg(HttpServletRequest request) throws Exception{ 
		String file_name=saveFile(request,"file");
		if(file_name==null){
			throw new AppException("文件为空!");
		}
        return file_name;   
    }
	
	@RequestMapping("/uploadImg2") 
    @AppController
    public Object uploadImg2(HttpServletRequest request) throws Exception{ 
		String file_name=saveFile(request,"file",false);
		if(file_name==null){
			throw new AppException("文件为空!");
		}
        return file_name;   
    }
	
	@RequestMapping("/uploadImgCK") 
    @AppController(isNeedPackage=false)
    public Object uploadImgCK(HttpServletRequest request) throws Exception{ 
		String file_name=saveFile(request,"upload");
		if(file_name==null){
			throw new AppException("文件为空!");
		}
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("uploaded", "1");
		map.put("fileName", file_name);
		map.put("url", file_name);
        return map;   
    }
	
	/**
	 * 用户layui  文本编辑器
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/uploadImgLayui") 
    @AppController(isNeedPackage=false)
    public Object uploadImgLayui(HttpServletRequest request) throws Exception{ 
		String file_name=saveFile(request,"file");
		if(file_name==null){
			throw new AppException("文件为空!");
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code", "0");
		Map<String, Object> dataMap=new HashMap<String, Object>();
		dataMap.put("src", file_name);
		map.put("data", dataMap);
        return map;   
    }
	
	@RequestMapping("/uploadImgs") 
    @AppController
    public Object uploadImgV2(HttpServletRequest request,MultipartFile file) throws Exception{ 
		List<String> file_names=saveFiles(request,"file");
		if(file_names==null||file_names.size()<=0){
			throw new AppException("文件为空!");
		}
        return file_names;   
    }

	/**
	 * 轮播列表
	 */
	@RequestMapping("/getBanner")
	@AppController(isPage=true)
	public Object getBanner(BannerBean bannerBean, PageBean pageBean) throws Exception{
		return settingService.getBanner(bannerBean,pageBean);
	}

	/**
	 * 图文配置详情
	 * 
	 * @param htmlBean
	 * @throws Exception
	 */
	@RequestMapping("/getHtmlDetail") 
    @AppController
	public Object getHtmlDetail(HtmlBean htmlBean)throws Exception {
		return settingService.getHtmlDetail(htmlBean);
	}
	
	/**
	 * 图文配置详情
	 * 
	 * @param htmlBean
	 * @throws Exception
	 */
	@RequestMapping("/getHtmls") 
    @AppController
	public Object getHtmls(HtmlBean htmlBean)throws Exception {
		return settingService.getHtmls(htmlBean);
	}
	
	@RequestMapping("/getHotSearchs") 
    @AppController(isPage=true)
	public Object getHotSearchs(HotSearchBean hotSearchBean,PageBean pageBean)throws Exception {
		return settingService.getHotSearchs(hotSearchBean,pageBean);
	}
	
	
	
}
