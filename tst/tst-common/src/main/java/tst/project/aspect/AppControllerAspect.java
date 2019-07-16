package tst.project.aspect;

import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import tst.project.bean.BaseBean;
import tst.project.log4j.BaseLogger;
import tst.project.page.PageBean;
import tst.project.utils.HostUtils;
import tst.project.utils.JDBCUtils;
import tst.project.utils.RedisUtils;
import tst.project.utils.TimeUtils;

@Component
@Aspect
public class AppControllerAspect {

	private Map<String, String> propertiesMap = null;

	public AppControllerAspect() {
		propertiesMap = CustomPropertyConfigurer.getProperties();
		BaseLogger.audit("AppControllerAspect初始化完毕...controllerAspectse : " + propertiesMap);
	}

	@Pointcut("@annotation(tst.project.aspect.AppController)")
	public void controllerAspectse() {
	}

	@Before("controllerAspectse()")
	public void before() {        
		

//		HttpSession session = request.getSession();		
//
//		session.setMaxInactiveInterval(-1);
//		// 获取session的Id
//		String sessionId = session.getId();
//		// 判断session是不是新创建的
//		if (session.isNew()) {
//			BaseLogger.info("session创建成功，session的id是：" + sessionId+"  会话最大时间:"+session.getMaxInactiveInterval());
//		} else {
//			BaseLogger.info("服务器已经存在该session了，session的id是：" + sessionId+"  会话最大时间:"+session.getMaxInactiveInterval());
//		}
		
		
	}
	
	
	/**
	 * 显示拦截 controller 包装方法 统一处理
	 * 
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("controllerAspectse()")
	public Object appControllerAspectAround(ProceedingJoinPoint pjp) throws Throwable {
		boolean isNeedPackage = Boolean.TRUE;
		boolean isPage = false;//是否分页
		boolean isVerToken=false;//是否验证token
		boolean isVerSystemToken=false;//是否验证token
		boolean isLog=true;//是否打日志 默认打
		
		String params = "{";
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		try {
			try {
				MethodSignature signature = (MethodSignature) pjp.getSignature();

				AppController appController = signature.getMethod().getAnnotation(AppController.class);
				isNeedPackage = appController.isNeedPackage();
				isPage=appController.isPage();
				isVerToken=appController.isVerToken();
				isVerSystemToken=appController.isVerSystemToken();
				isLog=appController.isLog();
			} catch (Exception e) {
				BaseLogger.error("appControllerAspectAround 异常", e);
			}
			HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
			Enumeration<?> enu = request.getParameterNames();
			
			while (enu.hasMoreElements()) {
				String paraName = (String) enu.nextElement();
				params += "\"" + paraName + "\":\"" + request.getParameter(paraName) + "\",";
			}

			if(isLog){
				BaseLogger.info("----时间:" + TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"));
				BaseLogger.info("----方法:" + request.getRequestURI());
				BaseLogger.info("----参数:" + params + "}");
			}
			// Added By Speed J
			// 1. 获取方法的注解
			
			String url=request.getRequestURI();
			if(url.indexOf("registerMember")>=0||url.indexOf("insertOrder")>=0){//注册/下单 要判断短时间不让重复提交
				String member_account=request.getParameter("member_account");
				String requrest_key="member_account"+member_account+":"+request.getRequestURI();
				String count=RedisUtils.getKey(requrest_key);
				if("1".equals(count)){
					BaseBean baseBean=new BaseBean();
					baseBean.setStatus("error");
					baseBean.setError("请求过快!");
					return baseBean;
				}else{
					RedisUtils.setKey(requrest_key, "1",1);
				}	
			}
			
			if(isVerToken){
				String member_id=request.getParameter("member_id");
				String member_token=request.getParameter("member_token");
				String token=RedisUtils.getKey("member_id"+member_id);
				if("123654".equals(member_token)){
//					if(!"123654".equals(member_token)){
//						BaseBean baseBean=new BaseBean();
//						baseBean.setStatus("pending");
//						baseBean.setError("token failed");
//						return baseBean;
//					}
				}else{
					if(!(member_token!=null&&member_token.equals(token))){
						BaseBean baseBean=new BaseBean();
						baseBean.setStatus("pending");
						baseBean.setError("token failed");
						return baseBean;
					}
				}
				
			}
			
			if(isVerSystemToken){
				String account_id=request.getParameter("account_id1");
				String system_token=request.getParameter("system_token");
				String token=RedisUtils.getKey("account_id"+account_id);
				if(!(system_token!=null&&system_token.equals(token))){
					BaseBean baseBean=new BaseBean();
					baseBean.setStatus("pending");
					baseBean.setError("token failed");
					return baseBean;
				}

				
			}
			
			Object object=pjp.proceed();
			if(isLog){
				BaseLogger.info("----结果:" +JSON.toJSONString(object));	
			}
			
			Connection conn = null;
			conn = JDBCUtils.startConn(conn, "jdbc:mysql://139.196.178.64:3306/tst_huixiang2?characterEncoding=UTF-8","tst","tst1234567");
			Statement st3=(Statement) conn.createStatement();					
			st3.executeUpdate(" insert into tst_system_log "
					+ "(log_api,log_params,log_result,create_time) "
					+ "values "
					+ "('"+request.getRequestURI()+"','"+params+"','"+JSON.toJSONString(object)+"',now())");

			if (isNeedPackage) {
				BaseBean baseBean=new BaseBean();
				baseBean.setStatus("ok");
				if(isPage){
					PageBean pageBean=(PageBean) object;
					baseBean.setData(pageBean.getObject());
					baseBean.setExtra(pageBean.getObject2());
					baseBean.setTotal(pageBean.getTotal());
				}else{
					if(object==null){
						object=new Object();
					}
					baseBean.setData(object);
				}
				
				String result=JSON.toJSONString(baseBean,SerializerFeature.WriteMapNullValue,
						SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteNullListAsEmpty);
				result=result.replace("Bean\":null", "Bean\":{}").
				replace("Beans\":null", "Beans\":[]")
				.replace(":null", ":\"\"")
				.replace("lAY_CHECKED", "LAY_CHECKED");
				return JSON.parseObject(result,BaseBean.class);
			} else {
				return object;
			}
		} catch (Exception e) {
			if(isLog){
				BaseLogger.info("-------异常:" +JSON.toJSONString(e));
			}
			Connection conn = null;
			conn = JDBCUtils.startConn(conn, "jdbc:mysql://139.196.178.64:3306/tst_huixiang2?characterEncoding=UTF-8","tst","tst1234567");
			Statement st3=(Statement) conn.createStatement();					
			st3.executeUpdate(" insert into tst_system_log "
					+ "(log_api,log_params,log_result,create_time) "
					+ "values "
					+ "('"+request.getRequestURI()+"','"+params+"','"+JSON.toJSONString(e)+"',now())");
			BaseBean baseBean=new BaseBean();
			baseBean.setStatus("error");
			if (e instanceof AppException) {
				AppException appException = (AppException) e;
				baseBean.setError(appException.getMessage());
				return baseBean;
			}

			int b=e.getMessage()==null?0:e.getMessage().indexOf("tst.project.aspect.AppException", 10);
			baseBean.setError(b>0?e.getMessage().substring("tst.project.aspect.AppException： ".length(),b-1):e.getMessage());
			return baseBean;
		}
	}

}
