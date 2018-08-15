package com.videorecord.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
		String str = "2017_08_16";
		Date dt = sdf.parse(str);

		for (int i = 0; i < 52; i++) {
			Calendar rightNow = Calendar.getInstance();
			rightNow.setTime(dt);
			// rightNow.add(Calendar.YEAR, -1);// 日期减1年
			// rightNow.add(Calendar.MONTH, 3);// 日期加3个月
			rightNow.add(Calendar.DAY_OF_YEAR, 7);// 日期加10天
			dt = rightNow.getTime();
			String reStr = sdf.format(dt);
			System.out.println(reStr + "_");
		}
	}
}
