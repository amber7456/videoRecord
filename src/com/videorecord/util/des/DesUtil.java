package com.videorecord.util.des;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DesUtil {
	/**
	 * 这个函数是加密，可以把 key 给抽出来作为一个成员变量，现在只是测试代码 其中，iv 初始向量，测试代码中为了简单使用的是
	 * key；实际中为了安全，肯定用另一套值， 也必须是８个字节，６４位； 初始向量双方也必须保持一致；
	 * 
	 * @param message
	 *            要加密的值
	 * @param key
	 *            密钥，双方要保持一致，必须是８个字节，64位
	 * @return 返回的是 64 位的编码，如果不经过这个转换，那么加密后返回的结果是乱码，在解密时会有问题
	 * @throws Exception
	 */
	public static String desEncrypt(String message, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

		return Base64.encodeToString(cipher.doFinal(message.getBytes("UTF-8")));
		// return new sun.misc.BASE64Encoder().encode());
	}

	/**
	 * 这个函数是解密，可以把 key 给抽出来作为一个成员变量，现在只是测试代码 其中，iv 初始向量，测试代码中为了简单使用的是
	 * key；实际中为了安全，肯定用另一套值， 也必须是８个字节，６４位； 初始向量双方也必须保持一致；
	 * 
	 * @param message
	 *            要加密的值，必须先转换为６４位编码，然后解密，再然后转换为字符串
	 * @param key
	 *            密钥，双方要保持一致，必须是８个字节，64位
	 * @return
	 * 
	 * @throws Exception
	 */
	public static String desDecrypt(String message, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

		// Decode base64 to get bytes
		// byte[] buffer = new sun.misc.BASE64Decoder().decodeBuffer(message);
		byte[] buffer = Base64.decode(message);
		// Decrypt
		byte[] utf8 = cipher.doFinal(buffer);

		// Decode using utf-8
		return new String(utf8, "UTF8");
	}

}
