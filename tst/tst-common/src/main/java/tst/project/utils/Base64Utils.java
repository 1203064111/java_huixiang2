/**
 * 
 * Base64Utils - 工具类 
 * 
 */
package tst.project.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Base64Utils - 工具类 
 * 
 * @author		BF
 * 
 * @version     1.0
 * 
 */
public class Base64Utils {
	public static String decodeBase64(String text) throws Exception {
		try{
			String result=new String(org.apache.commons.codec.binary.Base64.decodeBase64(text), "UTF-8");
			return result;
		}catch (Exception e) {
			// TODO: handle exception
			return "";
		}
	}
	
	/**
	 * 根据字节数组转换base64编码
	 * @param text 原字节数组
	 * @return base64字符串
	 * @throws UnsupportedEncodingException
	 */
	public static String getBytesBase64(byte[] text) throws UnsupportedEncodingException {
		byte[] bytes = org.apache.commons.codec.binary.Base64.encodeBase64(text);
		return new String(bytes, "utf-8");
	}
	
	/**
	 * 根据字符串转换base64编码
	 * @param text 原字符串
	 * @return base64字符串
	 * @throws UnsupportedEncodingException
	 */
	public static String getBase64(String text) throws UnsupportedEncodingException {
		byte[] bytes = org.apache.commons.codec.binary.Base64.encodeBase64(text.getBytes("utf-8"));
		return new String(bytes, "utf-8");
	}
	
	
	/**
     * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
     * @param imgSrcPath 生成64编码的图片的路径
     * @return base64字符串
     */
	public static String getBase64Image(String imgSrcPath){
    	if(null == imgSrcPath || "".equals(imgSrcPath)){
    		return"";
    	}
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(imgSrcPath);        
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);//返回Base64编码过的字节数组字符串
    }
    
    /**
     * 对字节数组字符串进行Base64解码并生成图片
     * @param imgStr            转换为图片的字符串
     * @param imgCreatePath     将64编码生成图片的路径
     * @return  
     */
    public static boolean generateImage(String imgStr, String imgCreatePath){
        if (imgStr == null) //图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i) {
                if(b[i]<0) {//调整异常数据
                    b[i]+=256;
                }
            }
            OutputStream out = new FileOutputStream(imgCreatePath);    
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
