package com.videorecord.util;

import java.io.File;
import java.util.Map;

public class Test {

	private static Map<String, String> numMap = new java.util.HashMap<String, String>();

	public static void main(String[] args) throws Exception {
		String rootPath = "H:\\网络\\侣行_第3季";
		String oldFormat = "第X期 ";// #X$
		String newFormat = "侣行_第3季_X_";
		Integer numLength = 2;
		File file = new File(rootPath);
		String[] paths = file.list();
		// Arrays.sort(paths, String.CASE_INSENSITIVE_ORDER);// 增加了按照字母排序
		for (String path : paths) {
			String newName = "";
			//newName = test01(oldFormat, newFormat, path.toString());
			  newName = formatNum(oldFormat, path.toString(), "");
			  newName = reName(newName, oldFormat, newFormat, numLength);
			newName = replaceStr(newName, ".kux", "");
			System.out.println(newName);
			 File newFile = new File(rootPath + "\\" + path.toString());
			 if (newFile.renameTo(new File(rootPath + "\\" + newName))) {
			 System.out.println("重命名成功：" + newName);
			 } else {
			 System.out.println("重命名失败：" + newName);
			 }
		}
	}

	public static String test01(String oldFormat, String newFormat, String name) {
		String newName = "";
		String str1 = oldFormat.split("X")[0];
		String str2 = oldFormat.split("X")[1];

		String number = name.substring(name.indexOf(str1)+1, name.indexOf(str2));

		newFormat = newFormat.replace("X", number);
		newName = newFormat + name.substring(0, name.indexOf(str1))
				+ name.substring(name.indexOf(str2) , name.length());

		return newName;
	}

	public static String replaceStr(String name, String oldStr, String newStr) {
		return name.replace(oldStr, newStr);
	}

	@SuppressWarnings("unused")
	public static String reName(String name, String oldStr, String newStr, Integer numLength) {
		String newName = "";
		Integer begin = 0;
		if (oldStr.split("X")[0] != null && oldStr.split("X")[0].length() > 0) {
			begin = name.indexOf(oldStr.split("X")[0]);
		}
		Integer end = 0;
		if (oldStr.split("X")[1] != null && oldStr.split("X")[1].length() > 0) {
			end = name.indexOf(oldStr.split("X")[1]);
		}
		if (end > 0) {

			String number = name.substring(0, end).replace(oldStr.split("X")[0], "");

			boolean lengthFlag = true;
			while (lengthFlag) {
				if (number.length() < numLength) {
					number = "0" + number;
				} else {
					lengthFlag = false;
				}
			}
			newStr = newStr.replace("X", number);
			newName = newStr + name.substring(end + oldStr.split("X")[1].length(), name.length());
		} else {
			newName = name;
		}
		return newName;
	}

	public static String formatNum(String oldStr, String name, String index) {
		// num
		numMap.put("零", "0");
		numMap.put("一", "1");
		numMap.put("二", "2");
		numMap.put("三", "3");
		numMap.put("四", "4");
		numMap.put("五", "5");
		numMap.put("六", "6");
		numMap.put("七", "7");
		numMap.put("八", "8");
		numMap.put("九", "9");

		String newName = "";

		Integer end = 0;
		if (oldStr.split("X")[1] != null && oldStr.split("X")[1].length() > 0) {
			end = name.indexOf(oldStr.split("X")[1]);
		}

		if (end > 0) {

			char[] a = null;
			if (index == null) {
				String str = name.substring(0, end + oldStr.split("X")[1].length());
				a = str.toCharArray();
			} else {
				a = name.toCharArray();
			}
			StringBuffer s = new StringBuffer();
			for (int i = 0; i < a.length; i++) {

				String charStr = String.valueOf(a[i]);
				if (i <= end) {

					if (String.valueOf(a[i]).equals("十")) {
						if (numMap.get(String.valueOf(a[i - 1])) != null
								&& numMap.get(String.valueOf(a[i + 1])) != null) {
							charStr = "";
						} else if (numMap.get(String.valueOf(a[i - 1])) != null
								&& numMap.get(String.valueOf(a[i + 1])) == null) {
							charStr = "0";
						} else if (numMap.get(String.valueOf(a[i - 1])) == null
								&& numMap.get(String.valueOf(a[i + 1])) != null) {
							charStr = "1";
						} else if (numMap.get(String.valueOf(a[i - 1])) == null
								&& numMap.get(String.valueOf(a[i + 1])) == null) {
							charStr = "10";
						}
					}
					if (String.valueOf(a[i]).equals("百")) {
						if (numMap.get(String.valueOf(a[i - 1])) != null
								&& numMap.get(String.valueOf(a[i + 1])) != null) {
							charStr = "";
						} else if (numMap.get(String.valueOf(a[i - 1])) != null
								&& numMap.get(String.valueOf(a[i + 1])) == null) {
							charStr = "00";
						}
					}
					if (numMap.get(String.valueOf(a[i])) != null && numMap.get(String.valueOf(a[i])).length() > 0) {
						charStr = numMap.get(String.valueOf(a[i]));
					}
				}
				s.append(charStr);
			}
			if (index == null) {
				newName = s.toString();
				newName = newName.replace(oldStr.split("X")[0], "").replace(oldStr.split("X")[1], "");
				newName = "#" + newName + "$" + name;
			} else {
				newName = s.toString();
			}
		} else {
			newName = name;
		}
		return newName;
	}

}
