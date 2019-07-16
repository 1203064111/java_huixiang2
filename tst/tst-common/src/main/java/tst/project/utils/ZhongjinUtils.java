package tst.project.utils;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

import payment.api.tx.marketorder.Tx1311Request;

public class ZhongjinUtils {

	public static void main(String[] args) throws Exception {
//		KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
//		gen.initialize(2048);
//		KeyPair pair = gen.generateKeyPair();
//		// rsa生成一对公私钥
//		PublicKey publicKey = pair.getPublic();
//		PrivateKey privateKey =pair.getPrivate(); 
//		byte[] privateBT = privateKey.getEncoded();
//        // base64
//        System.out.println(Base64.encodeBase64String(privateBT));
		create();
	}

	public static void create() throws Exception {
		// 2.创建交易请求对象
		String institutionID = TimeUtils.getCurrentTime("yyyyMMddHHmmss");
		String orderNo = institutionID;
		String paymentNo = institutionID;
		long amount = 10;
		long fee = 0;
		String notificationURL = "123";

		// Map<String, String> map=new HashMap<String, String>();
		// map.put("institutionID", institutionID);
		// map.put("orderNo", orderNo);
		// map.put("paymentNo", paymentNo);
		// map.put("amount", amount+"");
		// map.put("fee", fee+"");
		// map.put("notificationURL", notificationURL);
		// map.put("bankID", "401");
		// map.put("accountType", "11");
		// map.put("cardType", "01");
		// String xml=XmlUtils.ArrayToXml(map);

		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?> " + "<Request version=\"2.1\"> "
				+ "<Head> " + "<TxCode>1311</TxCode> " + "</Head> " + "<Body> "
				+ "<InstitutionID>004543</InstitutionID> " + "<OrderNo>" + orderNo + "</OrderNo> " + "<PaymentNo>"
				+ paymentNo + "</PaymentNo> " + "<Amount>" + amount + "</Amount> " + "<Remark/> "
				+ "<NotificationURL>http://localhost:8380/Shop_xiaozhen/ReceiveNoticePage</NotificationURL> "
				+ "<PayeeList/> " + "<BankID>700</BankID> " + "<AccountType>11</AccountType> " + "<CardType/> "
				+ "</Body> " + "</Request>";
		System.out.println(xml);
		byte[] b = xml.getBytes("UTF-8");
		String message = Base64.encodeBase64String(b);
		System.out.println(message);

		// KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
		// gen.initialize(2048);
		// KeyPair pair = gen.generateKeyPair();
		// //rsa生成一对公私钥
		// PublicKey publicKey = pair.getPublic();
		PrivateKey privateKey = getPrivateKey(
				"MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC8urMqEyF231a65gu1Y4XDBfyp6oaqWuBlpR8boAkT1my8v46spEPlwhBN6s6qnI+cZSh64Ljvq6oodPq8x1hLVHPtRXhZFzMSMbh7KkszoA7zIbaMMUUsqj+ubjRSevlpqfznl2WOT++LonpGSBo1Gbyb/VUMdJUpBedi4gP/Y0Y+hmD9SMAbzQPcuiFOGd19QShn4Ph+9806MYoQJEg0klbqOTX8m8PR/O7T5iwiPXt4i7xslk2emnz6iVQ0G/jlIOs52U0M2XptPaSpCeJsJdcZBOBqWtL39b9KbCYsXKUfdQj3zLGtgdg88pB6HJz1Pkpz8mHGVF7WHgEa1XjJAgMBAAECggEBAIcPRPAzSJt9MOAHiRGB61OpkSs3/q8i4btb82sdl+FubdqVa1D5LO3bdzeLdeJ6r/tIGTP2ZeJ+gwL41AcM0Y73HQ8LzBhVleLLWi4qEi8buBceZTjmeY6BN5lonGD6SErpr2c83Rx+7/qJh9+L8dVWWbd4D8keFTCKXRBSlnHIKJCEBA0RX0kdpV9DE33rhTQRiylMH+eg+SWaIxS5aDyZdvCvABr4rfrlxyCH7MrSqms0gFK0Kdhya8uU/yIyNcJmyUgIcV/7Gap2YqNzqOm51fi70Xjey4Gg82llsmcBH0edjkcR8/yVOe+yLHOhn8mbQVAp26RQt09RbFveR9ECgYEA+N+vmSR+kR5yvRwXamWazMEePkOfAB9+wlG9zHvGD81vOeZeIHkcLXtVhzqfnXRL3nZu6BMr1FgRoR8HpX/gv98Dq/A03gfbfalt2d7/yLxIG6Ck+7HGPzLN8mHN5OXuPNY7gRmwn17+sG9UdScAosLbAGNMUwAmZw6dIaoPy3sCgYEAwiIjXsFgVPd5a2JruOO984B4xNWNF+byMYoibZvl474il4MdIGt0iMKfcjgZWrjdFTbeY0FPEcfPd7ebj/dzLsfR23La23yo9T7dt020tPBTdhGX+N6oKPUZiY+NcbLLYnPRVH1R1MmPdLfe4vCxipC8h41HpmAa6LxXpw8S54sCgYAayI/wTkIkwf8dJQHMHIUtVfc4QjTBYaJVrVBcylFFcBlxRL6Khh4nMufAdumom1Ry65IB/dYwsw2qplk/UWTRoWGWxnIaFwRjILHGyb4DT2f/OSmoQLiSIpiRZj8vTCN4fqHGwgoFDMciG8keFoV1/rxs7ULQh+qaGrOEZPXwMwKBgBVW81RjJVexrGMlennkbujpYl0grFXISS8w4//wdyDFsb+95eG+bhzqZ+SCTicu0v6V/XQjpbFqqV+bizoUFVE7HdJlmbEuztPGiVCw9gA9uq7r2Cy/LPTznE8GvKGW6cx0trn23JvrXB2UaKfBlYKJzm+IFCwxvEOBEJGIkqdpAoGAJCe5EZ0xFc9TN/uUkD/erOYzYRdrux33QAXzOItp5sON+ea6imtmNyHwwgnO5gSQbu0NEMep4k3LlSP8/svP82xmfon6G5yIlTynzctD33BlcGJcbRHLisSpqNlU8TeHBcEEAowDC0KGFzeZNZVHh8+/UWxrX/FxyEaqb4UJ3/Y=");
		Signature sign = Signature.getInstance("SHA1withRSA");
		sign.initSign(privateKey);

		// 更新用于签名的数据
		sign.update(b);
		byte[] signature = sign.sign();
		String s = bytesToHexString(signature);
		System.out.println(s);
	}

	public static PrivateKey getPrivateKey(String key) throws Exception {
		byte[] keyBytes;
		keyBytes = Base64.decodeBase64(key);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		return privateKey;
	}

	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}
}
