package com.rimon.rsa.ibd.print;

import java.io.ByteArrayOutputStream;

public class PrinterDataGoogleCloud {

	private static byte[] arrayOutputStream_patien_result;
	private static ByteArrayOutputStream arrayOutputStream_patien_info;

	private PrinterDataGoogleCloud() {
	
		arrayOutputStream_patien_info = new ByteArrayOutputStream();
	}

	public static byte[] getArrayOutputStream_patien_result() {
		return arrayOutputStream_patien_result;
	}

	public static ByteArrayOutputStream getArrayOutputStream_patien_info() {
		return arrayOutputStream_patien_info;
	}

	public static void setArrayOutputStream_patien_result(
			byte[] arrayOutputStream_patien_result) {
		PrinterDataGoogleCloud.arrayOutputStream_patien_result = arrayOutputStream_patien_result;
	}

	public static void setArrayOutputStream_patien_info(
			ByteArrayOutputStream arrayOutputStream_patien_info) {
		PrinterDataGoogleCloud.arrayOutputStream_patien_info = arrayOutputStream_patien_info;
	}

}
