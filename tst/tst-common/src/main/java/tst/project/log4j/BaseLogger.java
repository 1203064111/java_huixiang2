package tst.project.log4j;

/**
 * 基础logger
 * 
 * @author Speed J Date : 2013-10-29
 */
public class BaseLogger {
	private static boolean INIT_FLAG = false;

	private static org.apache.log4j.Logger rootLogger;
	private static org.apache.log4j.Logger auditLogger;
	private static org.apache.log4j.Logger carefulLogger;
	static {
		if (!INIT_FLAG) {
			synchronized (BaseLogger.class) {
				if (!INIT_FLAG) {
					init();
				}
			}
		} else {
			BaseLogger.info("Log4j 已经初始化过了");
		}
	}

	private static void init() {
		rootLogger = org.apache.log4j.Logger.getRootLogger();
		auditLogger = org.apache.log4j.Logger.getLogger("Audit");
		carefulLogger = org.apache.log4j.Logger.getLogger("Careful");
		BaseLogger.info("Log4j initiation over! Base path [" + System.getProperty("logger.base.path") + "] project path[" + System.getProperty("logger.project.path") + "] logger level[" + System.getProperty("logger.level") + "]");
		INIT_FLAG = true;
	}

	public static void info(String message) {
		rootLogger.info(message);
	}

	public static void error(String message) {
		carefulLogger.error(message);
	}

	public static void error(String message, Throwable throwable) {
		carefulLogger.error(message, throwable);
	}

	public static void error(Throwable throwable) {
		error("detail exception", throwable);
	}

	public static void warn(String message) {
		carefulLogger.warn(message);
	}

	public static void warn(String message, Throwable throwable) {
		carefulLogger.warn(message, throwable);
	}

	public static void warn(Throwable throwable) {
		carefulLogger.warn(throwable);
	}

	public static void audit(String message) {
		auditLogger.info(message);
	}
}
