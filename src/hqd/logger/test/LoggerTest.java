package hqd.logger.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerTest {

	//存放的文件夹
	private static String fileName = "Logger";
	
	/**
	 * 得到要记录的日志的路径及文件名
	 * @return
	 */
	private static String getLogName() {
		
		StringBuffer logPath = new StringBuffer();
		//logPath.append(System.getProperty("user.home")); 	//用户主目录
		logPath.append("E:\\eclipse\\logs");
		logPath.append("\\"+fileName);
		File file = new File(logPath.toString());
		if(!file.exists()) {
			file.mkdirs();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		logPath.append("\\"+sdf.format(new Date())+".log");
		return logPath.toString();
		
	}
	
	/**
	 * 配置Logger对象输出日志文件路径
	 * @param logger
	 * @param level 	在日志文件中输出level级别以上的信息
	 */
	public static void setLogingProperties(Logger logger,Level level) {
		
		FileHandler fh;
		try {
			fh = new FileHandler(getLogName(), true);
			logger.addHandler(fh); 	//日志输出文件
			fh.setFormatter(new SimpleFormatter()); 	//输出格式
		} catch (SecurityException e) {
			logger.log(level.SEVERE, "安全性错误", e);
		} catch (IOException e) {
			logger.log(level.SEVERE, "读取文件日志错误", e);
		}
		
	}
	
	public static void setLogingProperties(Logger logger) {
		
		setLogingProperties(logger, Level.ALL);
		
	}
	
}
