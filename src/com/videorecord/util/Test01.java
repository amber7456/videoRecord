package com.videorecord.util;

import java.io.File;
import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
		String rootPath = "F:\\迅雷下载\\(BD 1440x1080 x.265 Flac)";
		File file = new File(rootPath);
		String[] paths = file.list();
		Arrays.sort(paths, String.CASE_INSENSITIVE_ORDER);// 增加了按照字母排序
		for (String path : paths) {
			String newName = path.toString();
			newName = newName.replace("�0�5", "½");

//			String str1 = "EXTRA__";
//			newName = newName.replace(str1, "");
			System.out.println(newName);
			File newFile = new File(rootPath + "\\" + path.toString());
			if (newFile.renameTo(new File(rootPath + "\\" + newName))) {
				System.out.println("重命名成功：" + newName);
			} else {
				System.out.println("重命名失败：" + newName);
			}
		}
	}
}
