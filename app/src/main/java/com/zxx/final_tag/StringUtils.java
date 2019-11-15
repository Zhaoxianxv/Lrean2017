package com.zxx.final_tag;


import android.annotation.SuppressLint;
import android.content.Context;
import android.media.ExifInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class StringUtils {



	public static String getDate(int year, int month, int day) {
		StringBuilder sb = new StringBuilder();
		sb.append(year).append("/");
		int month2 = month + 1;
		if (month2 < 10) {
			sb.append("0").append(month2).append("/");
		} else {
			sb.append(month2).append("/");
		}
		if (day < 10) {
			sb.append("0").append(day);
		} else {
			sb.append(day);
		}
		return sb.toString();
	}

	public static String getDate2(int year, int month, int day) {
		StringBuilder sb = new StringBuilder();
		sb.append(year).append("年");
		int month2 = month + 1;
		if (month2 < 10) {
			sb.append("0").append(month2).append("/");
		} else {
			sb.append(month2).append("月");
		}
		if (day < 10) {
			sb.append("0").append(day).append("日");
		} else {
			sb.append(day).append("日");
		}
		return sb.toString();
	}





	@SuppressLint("SimpleDateFormat")
	public static String getCurrentTime() {
		String rel = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		Date curDate = new Date(System.currentTimeMillis());
		rel = formatter.format(curDate);
		return rel;
	}

	@SuppressLint("SimpleDateFormat")
	public static String getCurrentTime2() {
		String rel = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
		Date curDate = new Date(System.currentTimeMillis());
		rel = formatter.format(curDate);
		return rel;
	}


	/**
	 * 获取文件大小
	 */
	public static long getFileSize(String filePath) {
		long size = 0;
		File file = new File(filePath);
		if (file.exists()) {
			size = file.length();
		}
		return size;
	}

	/**
	 * 将子节数转换为Kb
	 */
	public static String convertBytesToOther(long byteSize) {
		String result = null;
		float size;

		DecimalFormat decimalFormat1 = new DecimalFormat(".0");
		DecimalFormat decimalFormat2 = new DecimalFormat(".00");

		if (byteSize < 1024) {
			result = byteSize + "B";
		} else {
			size = byteSize / 1024;
			if (size < 1024) {
				result = decimalFormat1.format(size) + "KB";
			} else {
				size = size / 1024;
				if (size < 1024) {
					result = decimalFormat2.format(size) + "M";
				} else {
					size = size / 1024;
					if (size < 1024) {
						result = decimalFormat2.format(size) + "G";
					}
				}
			}
		}
		return result;
	}

	public static int getBitmapDegree(String path) {
		int degree = 0;
		try {
			// 从指定路径下读取图片，并获取其EXIF信息
			ExifInterface exifInterface = new ExifInterface(path);
			// 获取图片的旋转信息
			int orientation = exifInterface.getAttributeInt(
					ExifInterface.TAG_ORIENTATION,
					ExifInterface.ORIENTATION_NORMAL);
			switch (orientation) {
				case ExifInterface.ORIENTATION_ROTATE_90:
					degree = 90;
					break;
				case ExifInterface.ORIENTATION_ROTATE_180:
					degree = 180;
					break;
				case ExifInterface.ORIENTATION_ROTATE_270:
					degree = 270;
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return degree;
	}

	public static int getRecordDuration(Context context, String path) {
		MediaPlayer mp = MediaPlayer.create(context, Uri.parse(path));
		int duration = mp.getDuration();
		mp.release();
		mp = null;
		return duration;
	}

	public static String getFileName(String path) {

		File file = new File(path);
		if (file.exists()) {
			return file.getName();
		}
		return "";
	}

	public static String getFileName2(String pathandname) {

		int start = pathandname.lastIndexOf("/");
		int end = pathandname.lastIndexOf(".");
		if (start != -1 && end != -1) {
			return pathandname.substring(start + 1, end);
		} else {
			return null;
		}

	}

	public static String getLastDate(String path) {

		File file = new File(path);
		if (file.exists()) {
			long time = file.lastModified();
			String ctime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
					.format(new Date(time));
			return ctime;
		}

		return "";
	}

	
}
