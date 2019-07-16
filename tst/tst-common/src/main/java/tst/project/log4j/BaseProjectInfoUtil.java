package tst.project.log4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目基本信息
 * 
 * @author Speed J Date : 2013-10-20
 */
public class BaseProjectInfoUtil {

	public static final Map<String, String> baseInfoMap = new HashMap<String, String>();
	public static final Map<String, String> containerInfaMap = new HashMap<String, String>();
	public static final Map<String, String> remoteInfoMap = new HashMap<String, String>();
	static {
		PropertiesUtils.properties2Map("base-info.properties", baseInfoMap);
		PropertiesUtils.properties2Map("container_info.properties", containerInfaMap);
		PropertiesUtils.properties2Map("remote.properties", remoteInfoMap);
	}

	/**
	 * @param key
	 * @return
	 */
	public static String getBaseInfoValue(String key) {
		return baseInfoMap.get(key);
	}

	/**
	 * @param key
	 * @return
	 */
	public static String getContainerInfoValue(String key) {
		return containerInfaMap.get(key);
	}

	/**
	 * @param key
	 * @return
	 */
	public static String getRomteInfoValue(String key) {
		return remoteInfoMap.get(key);
	}

}
