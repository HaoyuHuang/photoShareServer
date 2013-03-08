package com.photoShare.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Format {

	public static Object DateConvert(Class clz, Object obj) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

		if (clz == Date.class) {
			String src = (String) obj;
			Date dest = null;
			try {
				dest = sdf.parse(src);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dest;
		} else if (clz == String.class) {
			Date src = (Date) obj;
			String dest = null;
			dest = sdf.format(src);
			return dest;
		}
		return null;
	}

	public static Timestamp TimeConverte(String str) {
		if (StringisNull(str)) {
			return null;
		}
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		try {
			Timestamp ts = new Timestamp(format.parse(str).getTime());
			return ts;
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static boolean StringisNull(String str) {
		if (str == null || str.equals(""))
			return true;
		return false;
	}

}
