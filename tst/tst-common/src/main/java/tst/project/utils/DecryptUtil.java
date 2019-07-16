package tst.project.utils;

import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class DecryptUtil {

	private static final Logger log = Logger.getLogger(DecryptUtil.class);

	private static final String AES = "AES";
	private static final String AES_CBC_PKCS5 = "AES/CBC/PKCS5Padding";
	private static final String AES_CBC_PKCS7 = "AES/CBC/PKCS7Padding";
	/**
	 * <p>
	 * 对小程序wx.getUserInfo 返回的数据进行解密
	 * </p>
	 * 
	 * <br>
	 * 开发者如需要获取敏感数据，需要对接口返回的加密数据( encryptedData )进行对称解密。 解密算法如下：</br>
	 * <li>对称解密使用的算法为 AES-128-CBC，数据采用PKCS#7填充</li>
	 * <li>对称解密的目标密文为 Base64_Decode(encryptedData)</li>
	 * <li>对称解密秘钥 aeskey = Base64_Decode(session_key), aeskey 是16字节。</li>
	 * <li>对称解密算法初始向量 为Base64_Decode(iv)，其中iv由数据接口返回</li>
	 * 
	 * @param encryptedData
	 *            小程序wx.getUserInfo接口返回的密文
	 * @param sessionKey
	 *            会话key
	 * @param iv
	 *            小程序接口返回的初始向量
	 * @return {"openId":"oJ1P50LFpYwzZYaPhV1bjOrM2etY","nickName":"dimi","gender":1,"language":"zh_CN","city":"Haidian","province":"Beijing","country":"CN","avatarUrl":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJjUAIicI0k90UNwz7tTyWt46HrMMaxgSFPcR7Zh0MKZ4vzKibht4Sy3SrTwmYWoFSFOZOE0O1QJ0GQ/0","unionId":"orZ7js0oYCV859piu1kybaWlKGVc","watermark":{"timestamp":1493360456,"appid":"wxe87de3069cac4cf9"}}
	 * @throws Exception
	 * @throws WechatBusinessException
	 */
	public static String decryptJsUserInfo(String encryptedData, String iv, String sessionKey){

		try {
			System.out.println(encryptedData + "-===============");
			System.out.println(iv + "-===============");
			System.out.println(sessionKey + "-===============");
			byte[] data = Base64.decode(encryptedData);
			byte[] aseKey = Base64.decode(sessionKey);
			byte[] ivData = Base64.decode(iv);
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

			Cipher cipher = Cipher.getInstance(AES_CBC_PKCS7);
			Key sKeySpec = new SecretKeySpec(aseKey, AES);
			cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIv(ivData));// 初始化

			if (data == null) {
				System.out.println("解密错误");
			}
			byte[] result = cipher.doFinal(data);
			return new String(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return decryptJsUserInfo2(encryptedData, iv, sessionKey);
		}

	}
	
	public static String decryptJsUserInfo2(String encryptedData, String iv, String sessionKey){

		try {
			System.out.println(encryptedData + "-===============");
			System.out.println(iv + "-===============");
			System.out.println(sessionKey + "-===============");
			byte[] data = Base64.decode(encryptedData);
			byte[] aseKey = Base64.decode(sessionKey);
			byte[] ivData = Base64.decode(iv);
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

			Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5);
			Key sKeySpec = new SecretKeySpec(aseKey, AES);
			cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIv(ivData));// 初始化

			if (data == null) {
				System.out.println("解密错误");
			}
			byte[] result = cipher.doFinal(data);
			return new String(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	public static AlgorithmParameters generateIv(byte[] iv) throws Exception {
		AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
		params.init(new IvParameterSpec(iv));
		return params;
	}

	public static void main(String[] args) {

		String encryptedData = "U+QeXW4mIFesiF+vsso2O5LS1XYgIpqoVg3apXQzRDhAbksqbO18I2ALyF5KgwbG6nWCkz7n5P3gzYHVVrjubQ1XDQ/q9IM1iEytNDyIUBe/FhHv4oqMtSVAQ0qLpnO2yyBi0UjoH1ZDNAAUlrCQWktJ59mWsJnypvKQvHSFjw+o9+Ex+h7xyJwL78Sdp0H+z2NeSAKlJK40+Qb9iEkHtDrDOpSI0nK3D5xUjiNIjF1zo0Hk5Zb3yfpusiiXv1Wohg2Fxda+sRmpZIJcF/QAdpfcWO1gTmoNeSGl132jlnq4GqkOnsH7WhL2GKdRVtv6UgPdxwn9yS9B02NzgrLF1m42ij0g8js1zo/mQIMAJ6GTAiX5Jv5AGBhhfJTgK5cNCAqVzhe//XBCKrfsy+0+cMTVcnSDfOhV/eMQMqyejKkdii/toB5hXqtoOQpE35CU8816B06UduTicWfksPDlcD0i05pultA1zpoOktOgzx6QHFSs6A7ouBsJEeQ5WsfEoFEVvN/oS0A6Eoijn9Q6MbiSynAFANhXNw/5bFtbzBw==";
		String iv = "9/ie8SgHELFyvi0BCkadkA==";
		String sessionKey = "HMomtNpgITQ+6//xMSr12g==";
		System.out.println(decryptJsUserInfo(encryptedData, iv, sessionKey));
	}

}
