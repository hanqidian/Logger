package hqd.logger.test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 测试类
 * @author hqd
 *
 */
public class Test {

	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger("log.text");
		LoggerTest.setLogingProperties(logger);
		logger.log(Level.INFO, "aaaaaa");
		logger.setLevel(Level.WARNING);
		logger.log(Level.WARNING, "cccccc");
		logger.info("bbbbbb");
		
	}
	
}
