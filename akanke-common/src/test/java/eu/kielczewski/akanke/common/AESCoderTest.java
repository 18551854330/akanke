package eu.kielczewski.akanke.common;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.kielczewski.akanke.common.util.security.AESCoder;

public class AESCoderTest {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AESCoderTest.class);

	@Test
	public void testEncryptStr() {
		String actual = AESCoder.encryptStr("test");
		LOGGER.info("encrypt result={}", actual);
	}

	@Test
	public void testDecryptStr() {
		String actual = AESCoder.decryptStr("ABD22Gze3temevcHtdU+3w==");
		LOGGER.info("decrypt result={}", actual);
	}

}
