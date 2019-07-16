package tst.project.utils;

import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import net.iharder.Base64;

public class RsaUtils {

    private static final String ALGORITHM = "RSA";

    public static final String DEFAULT_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC4L/7MhR99+yswtvSr0dKenD/oJUaow2AEJ6OYn2n12Y4H9RIQY2W5Sr/h4iwMzQTpWFNT5y7jjpGY+qYNQOR1GS6bG2GuTMK9W1BwC41y2gd0xwqWV+df2+S9eHqxqOdib/4/+t2JYxLTJvAC5pGPEvt3z8RXmO8mvtlVzBLaZQIDAQAB";
    public static final String DEFAULT_PRIVATE_KEY = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALgv/syFH337KzC29KvR0p6cP+glRqjDYAQno5ifafXZjgf1EhBjZblKv+HiLAzNBOlYU1PnLuOOkZj6pg1A5HUZLpsbYa5Mwr1bUHALjXLaB3THCpZX51/b5L14erGo52Jv/j/63YljEtMm8ALmkY8S+3fPxFeY7ya+2VXMEtplAgMBAAECgYAguvauZWGpQ37zUy+7cLfa061PlYAu8TkYw+qAbqOnupdQtq4VF3S2LqBWhZiKVcxvovB70nM0oNsisjfb1xJBpyfDBFug7d+y2f8yr6aTOezoY5DBYEF3Svg9Kp9ra+vvAYX/7fh+tHCU0HOvp0z8ikZiRSWZaQ+3A2GiCIJrwQJBAPKVji89hGAMEWLJJFZaPiLBqZUwR2W/rp7Ely5ddKfjcosHhggHfOb71BnrMOm0h4S85Gx6a87n9R2To0c51q0CQQDCX6yYdt/9JGORyNSXfzMfSZyVOrMpIo77R0YwKa3UOwwLA56l2Lc4AYO10/lyAyZCKse2/5D9ZZUB7xoYEmGZAkB8MEJVPuoY/bSc3RqENrjetERsAwZaObJcx4oaC3AgTxmhwV1FmQfBfKTODBDDZE+Ijedm/ZlZmHhtBtstKJgVAkBKma/DgHRtUscIT90QHBjB3F3FhJb4pbPcyzksCQMXXmY73/LG0ktXqnUjlyy4zm6jnIm0OZgrOQ6chGkubfeZAkBMCGF2tPfEJh8XODOvlw5ADnUiq+Qe/abcpKowkiT9zP+rYT9XJAx7QxChjdwTZb6ahnJY1+ny1emEHUOs2fm8";
   
    public static RSAPublicKey getPublicKey(String publicKey) throws Exception {
        byte[] keyBytes = Base64.decode(publicKey.getBytes());
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        return (RSAPublicKey) keyFactory.generatePublic(spec);
    }

    public static RSAPrivateKey getPrivateKey(String privateKey) throws Exception {
        byte[] keyBytes = Base64.decode(privateKey.getBytes());
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        return (RSAPrivateKey) keyFactory.generatePrivate(spec);
    }

    public static void main(String args[]) throws Exception {
      


        String data="register";



        
//        /*
//         * 加密过程
//         */
//        RSAPublicKey publicKey = getPublicKey(DEFAULT_PUBLIC_KEY);
//
//        Cipher cipher1 = Cipher.getInstance("RSA");  
//        cipher1.init(Cipher.ENCRYPT_MODE, publicKey);  
//       
//        byte[] output= cipher1.doFinal(data.getBytes()); 
//        String a=new String(Base64.encodeBytes(output));
//        
//        System.out.println("密文:"+new String(Base64.encodeBytes(output)));
//        
        
//        RSAPrivateKey privateKey = RsaUtils.getPrivateKey(RsaUtils.DEFAULT_PRIVATE_KEY);
//		Cipher cipher = Cipher.getInstance("RSA");
//		cipher.init(Cipher.DECRYPT_MODE, privateKey);
//		byte[] type = cipher.doFinal(Base64.decode("FSkWh8mR5jUPy150HC0BEsyWl/vtGMHH2AvX/s1ctcbMtM5mcPxAzfimnGmwkgud70DYzD5U45TbMdZjJHQOMIxirS9i5As4xO0gkuVChhkl6B6xEoaZy4Gd519iSObdW265JdLKOQh7P4Qz+qAXoQPBQN8xo5sICvp87KH67qY="));
//		System.out.print(new String(type));
        /*
         * 解密过程   
         */
        
        RSAPrivateKey privateKey = getPrivateKey(DEFAULT_PRIVATE_KEY);
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.DECRYPT_MODE, privateKey);  
        byte[] output11= cipher.doFinal(Base64.decode("fHrkx1qXtvNqDyLx6STnBv9GQI0dhBPrWVNwhkSHWGkdaB5mLfVnfYBaquxr9t08v6NXcvx8J4eQbMMV5Lyr2OwtvNzHNcYwX6bUho9GXkp+20IESyL/6bPVdBdc+DNf8VGYKD2RrTRIewfGYomfaqb7xVcue+iXV6IYw6lJlXk="));
        
        System.out.println("明文:"+new String(output11));

    }
}
