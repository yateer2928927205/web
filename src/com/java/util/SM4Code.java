package com.java.util;

import com.sgitg.sgcc.sm.SM4Utils;
import java.io.IOException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class SM4Code {
	private static String keyStr = "!QA2Z@w1sxO*(-8L";

	private static String sm4Switch = "ture";

	private static SM4Utils sm4Utils = new SM4Utils();

	public static SM4Code getInstance() {
		return new SM4Code();
	}

	public String encrypt(String content) {
		if (sm4Switch.equals("false")) {
			return content;
		}

		if (content == null) {
			System.out.println("待加密内容为�?");
			return null;
		}
		if ((keyStr == null) || (keyStr.length() != 16)) {
			System.out.println("密钥错误");
			return null;
		}

		BASE64Encoder enc = new BASE64Encoder();

		byte[] encodeText = "00".getBytes();
		byte[] keyBytes = keyStr.getBytes();
		byte[] plainBytes = content.getBytes();
		try {
			encodeText = sm4Utils.SG_EncECBData(keyBytes, plainBytes);
			if (encodeText == null) {
				System.out.println("加密失败");
				return null;
			}

			return enc.encodeBuffer(encodeText);
		} catch (Exception e) {
			System.out.println("加密服务异常");
		}
		return null;
	}

	public String decrypt(String content) {
		if (sm4Switch.equals("false")) {
			return content;
		}

		if (content == null) {
			System.out.println("密文为空");
			return null;
		}

		if ((keyStr == null) || (keyStr.length() != 16)) {
			System.out.println("密钥错误");
			return null;
		}

		BASE64Decoder dec = new BASE64Decoder();

		byte[] cipherBytes = null;
		byte[] decodeText = "00".getBytes();
		byte[] keyBytes = keyStr.getBytes();
		try {
			cipherBytes = dec.decodeBuffer(content);

			decodeText = sm4Utils.SG_DecECBData(keyBytes, cipherBytes);

			if (decodeText == null) {
				System.out.println("解密失败");
				return null;
			}
			String plainText = new String(decodeText);

			System.out.println("解密成功");
			return plainText;
		} catch (IOException e) {
			System.out.println("解密服务异常");
		}
		return null;
	}
}