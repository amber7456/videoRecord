package com.videorecord.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class CommonUtils {

	/**
	 * 日志输出
	 */
	@SuppressWarnings("unused")
	private static final Logger LOG = Log4jFactory.getLogger(CommonUtils.class);

	// 静态方法，便于作为工具类
	public static String getMd5(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// 32位加密
			return buf.toString();
			// 16位的加密
			// return buf.toString().substring(8, 24);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * Date类型转为指定格式的String类型
	 * 
	 * @param source
	 * @param pattern
	 * @return
	 */
	public static String DateToString(Date source, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(source);
	}

	/**
	 * 
	 * 字符串转换为对应日期
	 * 
	 * @param source
	 * @param pattern
	 * @return
	 */
	public static Date stringToDate(String source, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = simpleDateFormat.parse(source);
		} catch (Exception e) {
		}
		return date;
	}

	public static String getID() {
		// 我要获取当前的日期
		Date date = new Date();
		// 设置要获取到什么样的时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		// 获取String类型的时间
		String createdate = sdf.format(date);
		return createdate;
	}

	// 下载excel文件
	public static boolean downLoadFile(HttpServletRequest request, HttpServletResponse response, String fileName,
			File file) throws Exception {
		// 设置输出的格式
		response.reset();
		// 根据浏览器设置下载文件名的编码
		if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
			fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
		} else if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
			// fileName = URLEncoder.encode(fileName, "UTF-8");
			fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
		} else {
			// fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
			fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
		}
		response.setContentType("application/xls;charset=GBK");
		// 设置下载文件头
		response.addHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
		response.setHeader("Connection", "close");
		// 设置文件长度
		int fileLeng = Integer.parseInt(file.length() + "");
		response.setContentLength(fileLeng);

		byte[] buffer = new byte[4096];// 缓冲区
		BufferedOutputStream output = null;
		BufferedInputStream input = null;
		try {
			input = new BufferedInputStream(new FileInputStream(file));
			output = new BufferedOutputStream(response.getOutputStream());
			int n = -1;
			// 遍历，开始下载
			while ((n = input.read(buffer, 0, 4096)) > -1) {
				output.write(buffer, 0, n);
			}
			output.flush(); // 不可少
			response.flushBuffer();// 不可少
		} catch (Exception e) {
			// 异常捕捉
			e.printStackTrace();
		} finally {
			// 关闭流，不可少
			if (input != null)
				input.close();
			if (output != null)
				output.close();
			file.delete();
		}
		return false;
	}

	/**
	 * 文件的复制
	 * 
	 * @param beginFilename
	 *            原始文件
	 * @param endFilename
	 *            目标文件
	 */
	public static void fileCopy(String beginFilename, String endFilename) {
		// 创建输入输出流对象
		InputStream input = null;
		OutputStream output = null;
		int length;
		try {
			input = new FileInputStream(beginFilename);
			output = new FileOutputStream(endFilename);
			// 获取文件长度
			try {
				length = input.available();

				// 创建缓存区域
				byte[] buffer = new byte[length];
				// 将文件中的数据写入缓存数组
				input.read(buffer);
				// 将缓存数组中的数据输出到文件
				output.write(buffer);

			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} finally {
			if (input != null && output != null) {
				try {
					input.close(); // 关闭流
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	/**
	 * 判断对象不为空
	 * 
	 * @param obj
	 *            对象名
	 * @return 是否不为空
	 */
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}

	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		if ((obj instanceof List)) {
			return ((List) obj).size() == 0;
		}
		if ((obj instanceof String)) {
			return ((String) obj).trim().equals("");
		}
		return false;
	}

	/**
	 * 使用ArrayList处理，如果是自己定义的类，则要合理重写equals方法
	 * 
	 * @param a
	 * @return
	 */
	public static <T> int getMostFrequentByArrayList(T a[]) {
		if (a == null || a.length == 0) {
			return 0;
		}
		int size = a.length;
		int result = 0;
		// 持有所有集合的集合。指定容量以免扩容带来的性能消耗，不过可能浪费空间
		ArrayList<ArrayList<T>> severalTempList = new ArrayList<ArrayList<T>>(size);

		for (int i = 0; i < size; i++) {
			boolean isAdd = false;
			T t = a[i];
			// 遍历severalTempList每个ArrayList，找到t所属的则添加上去
			for (int j = 0; j < severalTempList.size(); j++) {
				ArrayList<T> singleTemps = severalTempList.get(j);
				if (singleTemps != null) {
					if (t.equals(singleTemps.get(0))) {
						singleTemps.add(t);
						isAdd = true;
					}
				}
			}
			// 找不到t所属的则创建新的ArrayList添加到severalTempList，并将t添加到新的ArrayList
			if (!isAdd) {
				ArrayList<T> singleTemps = new ArrayList<T>();
				singleTemps.add(t);
				severalTempList.add(singleTemps);
			}
		}

		// 经过拆分后长度最大的集合
		ArrayList<T> largestList = severalTempList.get(0);
		// 从索引为1开始就可以了
		for (int i = 1; i < severalTempList.size(); i++) {
			// 通过遍历找到元素最多的集合
			if (severalTempList.get(i).size() > largestList.size()) {
				largestList = severalTempList.get(i);
			}

			result = largestList.size();
		}

		return result;

	}
}
