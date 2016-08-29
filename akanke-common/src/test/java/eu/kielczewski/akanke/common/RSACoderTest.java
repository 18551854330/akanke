package eu.kielczewski.akanke.common;

import java.security.Key;
import java.util.Base64;
import java.util.Map;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import eu.kielczewski.akanke.common.util.security.RSACoder;

public class RSACoderTest {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(RSACoderTest.class);

	/* 公钥 */
	private byte[] publicKey;

	/* 私钥 */
	private byte[] privateKey;

	@Before
	public void setUp() throws Exception {
		Map<String, Key> keyMap = RSACoder.initKey();

		publicKey = RSACoder.getPublicKey(keyMap);
		privateKey = RSACoder.getPrivateKey(keyMap);

		LOGGER.info("publicKey={}",
				Base64.getEncoder().encodeToString(publicKey));
		LOGGER.info("privateKey={}",
				Base64.getEncoder().encodeToString(privateKey));
	}

	@Test
	public void testSign() {

		String inputStr = "Copyright (c) 2016 Nanjing Njfans Information Technology Co.,Ltd.";
		byte[] data = StringUtils.getBytesUtf8(inputStr);

		// 产生签名
		byte[] sign = RSACoder.sign(data, privateKey);
		LOGGER.info("sign={}", Base64.getEncoder().encodeToString(sign));

		// 验证签名
		boolean status = RSACoder.verify(data, publicKey, sign);
		LOGGER.info("status={}", status);
		Assert.assertTrue(status);
	}

}
