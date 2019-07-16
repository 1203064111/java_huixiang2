package tst.project.log4j;

import javax.servlet.ServletContextEvent;

import org.springframework.web.util.Log4jConfigListener;
import org.springframework.web.util.WebUtils;

/**
 * log4j 初始化
 * 
 * @author Speed J Date : 2013-11-10
 */
public class Log4jConfigurationListener extends Log4jConfigListener {

	public void contextInitialized(ServletContextEvent paramServletContextEvent) {

		// 防止多个项目webapp.root 相同 报错
		System.setProperty(WebUtils.DEFAULT_WEB_APP_ROOT_KEY, paramServletContextEvent.getServletContext().getRealPath("/"));

		// 设置log4j system 参数
		StringBuffer plp = new StringBuffer();
		plp.append(BaseProjectInfoUtil.getBaseInfoValue("project_name")).append("/");
		plp.append(BaseProjectInfoUtil.getContainerInfoValue("server_http_port"));
		System.setProperty("logger.base.path", BaseProjectInfoUtil.getBaseInfoValue("logger.base.path"));
		System.setProperty("logger.project.path", plp.toString());
		System.setProperty("logger.level", BaseProjectInfoUtil.getBaseInfoValue("logger.level"));

		super.contextInitialized(paramServletContextEvent);

		BaseLogger.info("Log4jConfigurationListener sucessful!");
	}

	public void contextDestroyed(ServletContextEvent paramServletContextEvent) {
		super.contextDestroyed(paramServletContextEvent);
	}

}
