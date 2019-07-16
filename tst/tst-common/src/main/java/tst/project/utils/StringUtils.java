package tst.project.utils;

public class StringUtils {
	public static boolean isNull(String value){
		if(value==null||"".equals(value)||"null".equals(value)){
			return true;
		}
		return false;
	}
	
	public static String getNull(String value,String defalut_value){
		if(isNull(value)){
			return defalut_value;
		}
		return value;
	}
	
	public static void main(String[] args) {
		System.out.println(getNull(null+"","2112"));
	}
}
