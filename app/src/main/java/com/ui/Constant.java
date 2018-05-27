package com.ui;


public class Constant {

	
	public static String fileBase ="/mnt/sdcard/karaok";
	public static String logBaseFile ="/karaok_base.txt";//基础信息log文件，直接上传
	
	public static String file ="/mnt/sdcard/karaok/karaok_log";
	public static String logFile  ="/karaok_server_logfile.txt";//写入的log文件,给张硕.c用
	 public static String logjavaFile ="/karaok_javaLog.txt";//java中的log写入文件
	 public static String logTvmicFile = "/karaok_tvmiclog.txt";//给张志写log文件用
    public static String logZipFile  ="/karaok_logfile.zip";//将写log的文件压缩然后上传的zip文件
    
    public static String SoundParameterFile ="/sound_parameter.txt";//混响参数
    public static String SoundEquParameterFile = "/sound_equ_parameter.txt";//均衡器参数
	
	public static final class ConValue{

		public static String mTextviewArray[] = {"屏幕及定时", "运营商信息","cavas","均衡器"};//,"排序比价"
		
		public static Class<?> mTabClassArray[]= {ScreenActivity.class,
			YunyingshangInfo.class,CustomActivity.class,E.class};//,CompareActivity.class
		
	}
}
