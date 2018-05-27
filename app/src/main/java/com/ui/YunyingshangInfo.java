package com.ui;

import java.io.File;
import java.lang.annotation.Annotation;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import com.lidroid.xutils.view.annotation.event.OnClick;
import com.ui.utils.AllIntents;
import com.ui.view.DataLoadingProgressDialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class YunyingshangInfo extends Activity implements OnClickListener{

	
	private Button btn,readSimInfo,readDown,changSong,readPdf,readWord,mp4ToMt,mtTomp4;
	private TextView simType,simPhoneNum,newSong,times,phoneinfo;
	//回调方法
	private static ChangNva changNva;
	//设置
	public static void setNvaChangListener(ChangNva nva){
		changNva = nva;
	}
	
	
	private String songName[] = {"李白","梦境","小苹果","下一个天亮","茶汤","美丽新世界","味道","怒放的生命","兄弟"}; 
	private Button testD;
	DataLoadingProgressDialog dtpro;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);
		btn = (Button) findViewById(R.id.btn);
		changSong = (Button) findViewById(R.id.change_btn);
		readSimInfo = (Button) findViewById(R.id.read_sim);
		readDown = (Button) findViewById(R.id.read_download);
		readPdf = (Button) findViewById(R.id.readpdf);
		readWord = (Button) findViewById(R.id.readword);
		phoneinfo =  (TextView) findViewById(R.id.phoneinfo);
		mp4ToMt = (Button) findViewById(R.id.btn_r1);
		mtTomp4 =  (Button) findViewById(R.id.btn_r2);
		testD = (Button)findViewById(R.id.testd);
		testD.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(dtpro==null){
					dtpro = new DataLoadingProgressDialog();
					dtpro.showProgressDialog(YunyingshangInfo.this);
				}else{
					dtpro.unShowProgressDialog();
					dtpro = null;
				}
			}
		});
		
		mp4ToMt.setOnClickListener(this);
		mtTomp4.setOnClickListener(this);
		btn.setOnClickListener(this);
		readSimInfo.setOnClickListener(this);
		readDown.setOnClickListener(this);
		changSong.setOnClickListener(this);
		readPdf.setOnClickListener(this);
		readWord.setOnClickListener(this);
		
		times = (TextView) findViewById(R.id.times);
		simType = (TextView) findViewById(R.id.simType);
		simPhoneNum = (TextView) findViewById(R.id.simPhoneNum);
		newSong =  (TextView) findViewById(R.id.new_song);
		
//		Timestamp timestamp = Timestamp.valueOf("1451028545000");
//		setTimes(timestamp);
		
		readSimInfo();
		getPhoneInfo();
	}
	
	private void getPhoneInfo(){
//		Build.BOARD  //主板 
//		Build.BOOTLOADER//系统启动程序版本
//		Build.BRAND//系统定制商
//		Build.CPU_ABI//cpu指令集
//		Build.CPU_ABI2//cpu指令集2
//		Build.DEVICE//设置参数 
//		Build.DISPLAY//显示屏参数
//		Build.MANUFACTURER//硬件制造商
//		Build.getRadioVersion//无线电固件版本
//		Build.FINGERPRINT//硬件识别码
//		Build.HARDWARE//硬件名称
//		Build.HOST //HOS
//		Build.ID// 修订版本列表
//		Build.MODEL//手机型号(MI XXX)
//		Build.SERIAL//硬件序列号
//		Build.PRODUCT//手机制造商
//		Build.TAGS//描述Build的标签
//		Build.TIME//编译时间
//		Build.TYPE//builder类型
//		Build.USER//USER
//		Build.VERSION.CODENAME//当前开发代号
//		Build.VERSION.INCREMENTAL//源码控制版本号
//		Build.VERSION.SDK_INT//版本号
//		Build.VERSION.RELEASE//版本字符串

		/**
		 * android.os.Build.BOARD：获取设备基板名称

		 android.os.Build.BOOTLOADER:获取设备引导程序版本号

		 android.os.Build.BRAND：获取设备品牌

		 android.os.Build.CPU_ABI：获取设备指令集名称（CPU的类型）

		 android.os.Build.CPU_ABI2：获取第二个指令集名称

		 android.os.Build.DEVICE：获取设备驱动名称

		 android.os.Build.DISPLAY：获取设备显示的版本包（在系统设置中显示为版本号）和ID一样

		 android.os.Build.FINGERPRINT：设备的唯一标识。由设备的多个信息拼接合成。

		 android.os.Build.HARDWARE：设备硬件名称,一般和基板名称一样（BOARD）

		 android.os.Build.HOST：设备主机地址

		 android.os.Build.ID:设备版本号。

		 android.os.Build.MODEL ：获取手机的型号 设备名称。如：SM-N9100（三星Note4）

		 android.os.Build.MANUFACTURER:获取设备制造商。如：samsung

		 android:os.Build.PRODUCT：整个产品的名称

		 android:os.Build.RADIO：无线电固件版本号，通常是不可用的 显示

		 unknownandroid.os.Build.TAGS：设备标签。如release-keys 或测试的 test-keys

		 android.os.Build.TIME：时间

		 android.os.Build.TYPE:设备版本类型 主要为"user" 或"eng".

		 android.os.Build.USER:设备用户名 基本上都为android-build

		 android.os.Build.VERSION.RELEASE：获取系统版本字符串。如4.1.2 或2.2 或2.3等

		 android.os.Build.VERSION.CODENAME：设备当前的系统开发代号，一般使用REL代替

		 android.os.Build.VERSION.INCREMENTAL：系统源代码控制值，一个数字或者git hash值

		 android.os.Build.VERSION.SDK：系统的API级别 一般使用下面大的SDK_INT 来查看

		 android.os.Build.VERSION.SDK_INT：系统的API级别 数字表示

		 android.os.Build.VERSION_CODES类 中有所有的已公布的Android版本号。全部是Int常亮。可用于与SDK_INT进行比较来判断当前的系统版本
		 *
		 */

		String phoneInfo = "Product: " + android.os.Build.PRODUCT;  
        phoneInfo += ",<br /> CPU_ABI: " + android.os.Build.CPU_ABI;  
        phoneInfo += ", <br />TAGS: " + android.os.Build.TAGS;  
        phoneInfo += ", <br />VERSION_CODES.BASE: " + android.os.Build.VERSION_CODES.BASE;  
        phoneInfo += ", <br />MODEL: " + android.os.Build.MODEL;  
        phoneInfo += ", <br />SDK: " + android.os.Build.VERSION.SDK;  
        phoneInfo += ", <br />VERSION.RELEASE: " + android.os.Build.VERSION.RELEASE;  
        phoneInfo += ", <br />DEVICE: " + android.os.Build.DEVICE;  
        phoneInfo += ", <br />DISPLAY: " + android.os.Build.DISPLAY;  
        phoneInfo += ", <br />BRAND: " + android.os.Build.BRAND;  
        phoneInfo += ", <br />BOARD: " + android.os.Build.BOARD;  
        phoneInfo += ", <br />FINGERPRINT: " + android.os.Build.FINGERPRINT;  
        phoneInfo += ", <br />ID: " + android.os.Build.ID;  
        phoneInfo += ", <br />MANUFACTURER: " + android.os.Build.MANUFACTURER;  
        phoneInfo += ", <br />USER: " + android.os.Build.USER;  
        phoneInfo += ", <br />SERIAL: " + android.os.Build.SERIAL;  
        phoneInfo += ", <br />TIME: " + android.os.Build.TIME;  
        if(android.os.Build.MODEL.trim().toLowerCase().contains("huawei mt7-tl10")){
        	System.out.println("1:"+android.os.Build.MODEL.trim().toLowerCase());
        		Toast.makeText(this, 1+""+android.os.Build.MODEL.trim().toLowerCase(), Toast.LENGTH_LONG).show();  
        	}else{
        		System.out.println("2:"+android.os.Build.MODEL.trim().toLowerCase());
        		Toast.makeText(this, "2:"+android.os.Build.MODEL.trim().toLowerCase(), Toast.LENGTH_LONG).show();  
        	} 
        System.out.println("===设备终端信息==="+phoneInfo);
        phoneinfo.setText(Html.fromHtml(phoneInfo));
	}

	void setTimes(Timestamp timestamp){
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy h:m:s", Locale.ENGLISH);
			String date = dateFormat.format(timestamp);
			times.setText(date);
	}
	
	void readSimInfo(){
		TelephonyManager telManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE); 
		/**
		 * getCellLocation（） 返回的单元格位置的装置 ACCESS_COARSE_LOCATION或ACCESS_FINE_LOCATION
			getDeviceId（） 返回的IMEI / MEID的设备。 如果该设备是GSM设备 然后IMEI号将被退回，如果该设备是一个CDMA设备然后MEID 将被退回 READ_PHONE_STATE
			getLine1Number（） 返回设备的电话号码（MSISDN号码） READ_PHONE_STATE
			getNetworkOperatorName（） 返回注册的网络运营商的名字
			getNetworkOperator（） 返回的MCC +跨国公司的注册网络运营商
			getNetworkCountryIso（） 返回注册的网络运营商的国家代码
			getSimCountryIso（） 返回SIM卡运营商的国家代码 READ_PHONE_STATE
			getSimOperator（） 返回SIM卡运营商的单个核细胞数+冶 READ_PHONE_STATE
			getSimOperatorName（） 返回SIM卡运营商的名字 READ_PHONE_STATE
			getSimSerialNumber（） 返回SIM卡的序列号 READ_PHONE_STATE
		 */
		
		String operator = telManager.getSimOperator();
		String IMEI = telManager.getDeviceId();
		String PhoneNum = telManager.getLine1Number();
		
		//运营商类型
		if(operator!=null){
			if(operator.equals("46000") || operator.equals("46002") || operator.equals("46007") ){
				//中国移动
				simType.setText("运营商：中国移动"+"-IMEI:"+IMEI);
			}else if(operator.equals("46001")){
				//中国联通
				simType.setText("运营商：中国联通"+"-IMEI:"+IMEI);
			}else if(operator.equals("46003")){
				//中国电信
				simType.setText("运营商：中国电信"+"-IMEI:"+IMEI);
			} 
		}else{
			Toast.makeText(YunyingshangInfo.this, "read fail", Toast.LENGTH_SHORT).show();
		}
		
		//手机号码
		if(PhoneNum!=null){
			simPhoneNum.setText("手机号码："+PhoneNum);
		}
		
	}
	
	void openUrl(String url){
		Uri uri = Uri.parse(downUrl);
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(intent);
	}
	
	
	String downUrl="https://mail.mxhichina.com/attachment/downloadex?et=normal&m=2_0%3ADzzzzydbiwK%24----4JBQYkn&f=e7ae4d70-de6b-4f78-9e59-47ba40d17ee9&e=mingtingjie%40runbone.com.cn&ext=xlsx&n=%E4%BA%AC%E4%B8%9C%E4%BC%97%E7%AD%B9%E5%8F%91%E8%B4%A7%E5%9C%B0%E5%9D%80%EF%BC%88%E9%A1%BA%E4%B8%B0%EF%BC%89.xlsx&ri=%2Falimail%2FinternalLinks%2FrefreshToken";
	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.btn:
			Toast.makeText(YunyingshangInfo.this, "33", Toast.LENGTH_SHORT).show();
			//调用回调方法切换导航,导航跳转
			changNva.replaceNva();
			break;
		case R.id.read_sim:
			readSimInfo();
			break;
		case R.id.read_download:
			openUrl(downUrl);
			break;
		case R.id.change_btn:
			if(i==9)
				i=0;
			newSong.setText(songName[i]);
			System.out.println("====settext===i==="+i);
        	try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        	
        	executorService.shutdownNow();
        	executorService = Executors.newSingleThreadExecutor();
			executorService.execute(new TestRunnable());
			break;
		case R.id.readpdf:
			 try
     		  {
            Intent intent =AllIntents.getPdfFileIntent("android_assets/bpm.pdf");
            	startActivity(intent);
     	  }catch(Exception e)
         {
     		  Toast.makeText(YunyingshangInfo.this, "请安装手机PDF阅读工具！", Toast.LENGTH_SHORT).show();
         }
			break;
		case R.id.readword:
//			 try
//    		  {
//           Intent intent =AllIntents.getWordFileIntent("assets/bpm.docx");
//           	startActivity(intent);
//    	  }catch(Exception e)
//        {
//    		  Toast.makeText(Main.this, "请安装手机PDF阅读工具！", Toast.LENGTH_SHORT).show();
//        }
//			Intent intent = new Intent(Main.this, ScreenInfoActivity.class);
//			startActivity(intent);
//			overridePendingTransition(0, 0);
			Toast.makeText(YunyingshangInfo.this, getResources().getString(R.string.app_name), Toast.LENGTH_SHORT).show();
			break;
		case R.id.btn_r1:
			//mp4ToMt
			if(fileExist(oldFilePath)){
				Toast.makeText(this, "exist", Toast.LENGTH_SHORT).show();
				System.out.println("==ToMtStart="+System.currentTimeMillis());
				File orginFile = new File(oldFilePath);
				File newFile = new File(newFilePath);
//	            while (newFile.exists()) {
//	                newFile = new File(orginFile.getParent(), System.currentTimeMillis() + responseFileName);
//	            }
//	            return orginFile.renameTo(newFile) ? newFile : orginFile;
				boolean reNameSuccess = orginFile.renameTo(newFile);
				System.out.println("=ToMtEnd="+System.currentTimeMillis()+"=reNameSuccess="+reNameSuccess);
				Toast.makeText(this, "reNameSuccess"+reNameSuccess, Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.btn_r2:
			//MtToMp4
			if(fileExist(newFilePath)){
				Toast.makeText(this, "exist", Toast.LENGTH_SHORT).show();
				System.out.println("=toMp4Start=cur="+System.currentTimeMillis());
				File orginFile = new File(oldFilePath);
				File newFile = new File(newFilePath);
//	            while (newFile.exists()) {
//	                newFile = new File(orginFile.getParent(), System.currentTimeMillis() + responseFileName);
//	            }
//	            return orginFile.renameTo(newFile) ? newFile : orginFile;
				boolean reNameSuccess = newFile.renameTo(orginFile);
				System.out.println("=toMp4End=cur2="+System.currentTimeMillis()+"=reNameSuccess="+reNameSuccess);
				Toast.makeText(this, "reNameSuccess"+reNameSuccess, Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
			}
			break;
		default:
			break;
		}
		
	}
	String oldFilePath = "/storage/emulated/0/TuanZiEdu/VideoCache/2016ZHCS01-04.mp4";
	String newFilePath = "/storage/emulated/0/TuanZiEdu/VideoCache/2016ZHCS01-04.mt";
	boolean rename(File oldFile){
		
		return false;
	}
	
	/**
	 * 文件是否存在
	 * @param filePath
	 * @return
	 */
	public  boolean fileExist(String filePath){
		File file=new File(filePath);    
		if(file.exists())    
		{    
		   return true;
		}
		return false;    
	}
	ExecutorService executorService = Executors.newSingleThreadExecutor() ;
	int i;
	// 只能5个线程同时访问
    final Semaphore semp = new Semaphore(5);
    
	class TestRunnable implements Runnable { 
        public void run() { 
        	System.out.println( "===Runnable===2222===="+songName[i]+"==i==="+i); 
        	i++;
//                System.out.println(Thread.currentThread().getName() + "线程被调用了。"); 
//                while (true) { 
                        try { 
                                Thread.sleep(2000); 
//                                System.out.println(Thread.currentThread().getName()); 
                        } catch (InterruptedException e) { 
                                e.printStackTrace(); 
                        } 
//                } 
        } 
	}
	
}
