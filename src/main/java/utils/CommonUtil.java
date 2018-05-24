/**
 * 
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author zhang
 *
 */
public class CommonUtil {
	
	
	public static String getUniqueSign(){
		String uuid = null;
		uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}
	
	public static String getDate(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		return df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
	}
	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
		System.out.println(date);
	}
	
}
