package com.videorecord.util.des;

import com.videorecord.util.CommonConstants;

public class TestDES {
	public static void main(String[] args) throws Exception {
		String str1 = "{\"POS\": {\"source\": {\"requestorID\": {\"ID\": \"DBKY01\",\"URL\": \"75E702474873FA42525A7AEA3C36E14F\",\"messagePassword\": \"cdp$$001\"}}}}";

		String str2 = DesUtil.desEncrypt(str1, CommonConstants.DESKEY);
		System.out.println(str2);
		
//	    String str2 =  "4dKuc6lgEgjGJx5QSlzM7PoNVag59DaG+07F9OMIiSMrJcAzYDjQ7KrA9CJDMZ4MW6dJFJA6uOQz/SmhTZsHMSug6vmVdz7LR0yV0dU1p1oM2Tq6v74UbA==";

		
		String str3 = DesUtil.desDecrypt(str2, CommonConstants.DESKEY );
		System.out.println(str3);

	}
}
