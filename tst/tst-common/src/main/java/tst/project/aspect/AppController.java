package tst.project.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author SpeedJ
 * 
 *         app controller 统一包装注解类
 *
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ResponseBody
public @interface AppController {
	/**
	 * 若是成功是否需要 @ControllerUtils.getSuccessfulResponse() 进行包装，默认true 是需要
	 * 
	 * @return
	 */
	boolean isNeedPackage() default true;
	
	/**
	 * 是否分页
	 * @return
	 */
	boolean isPage() default false;
	
	/**
	 * 前端是否验证token
	 * @return
	 */
	boolean isVerToken() default false;
	
	/**
	 * 后端是否验证token
	 * @return
	 */
	boolean isVerSystemToken() default false;
	
	/**
	 * 是否打日志 默认打
	 */
	boolean isLog() default true;
}
