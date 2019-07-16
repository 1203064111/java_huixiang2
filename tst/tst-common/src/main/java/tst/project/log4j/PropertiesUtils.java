package tst.project.log4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;


/**
 * properties 工具类
 * 
 * @author Speed J Date : 2013-11-7
 */
public class PropertiesUtils {

	/**
	 * 将properties 文件 转换成 Map<String,String>
	 * 
	 * @param fileName
	 * @param map
	 */
	public static void properties2Map(String fileName, Map<String, String> map) {
		try {
			InputStream is = BaseProjectInfoUtil.class.getClassLoader().getResourceAsStream(fileName);
			if (is != null) {

				Properties p = new Properties();
				try {
					p.load(is);
				} catch (IOException e) {
					BaseLogger.error(e);
				}

				for (Entry<Object, Object> entry : p.entrySet()) {
					String key = (String) entry.getKey();
					if (StringUtils.isNotBlank(key)) {
						map.put(key, (String) entry.getValue());
					}
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					BaseLogger.error(e);
				}
			}

		} catch (Exception e) {
			BaseLogger.error(e);
		}
	}
}
