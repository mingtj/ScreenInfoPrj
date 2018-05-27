package com.ui.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.xutils.x;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.util.KeyValue;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.http.body.MultipartBody;

import com.ui.Constant;

import android.content.Context;
import android.util.Log;

public class LogHttpUtil {
	
	
	// 灏?瀛?绗?涓插????ュ?版????????浠朵腑
	public static void writeTxtToFile(String strcontent, String filePath, String fileName) {
	    //?????????浠跺す涔????锛?????????????浠讹??涓???朵????洪??
	    makeFilePath(filePath, fileName);
	    
	    String strFilePath = filePath+fileName;
	    // 姣?娆″????ユ?讹????芥?㈣?????
	    String strContent = strcontent + "\r\n";
	    try {
	        File file = new File(strFilePath);
	        if (!file.exists()) {
	            Log.d("TestFile", "Create the file:" + strFilePath);
	            file.getParentFile().mkdirs();
	            file.createNewFile();
	            file.setExecutable(true);//璁剧疆?????ц????????  
	              file.setReadable(true);//璁剧疆???璇绘?????  
	              file.setWritable(true);//璁剧疆????????????  
	        }
	        RandomAccessFile raf = new RandomAccessFile(file, "rwd");
	        raf.seek(file.length());
	        raf.write(strContent.getBytes());
	        raf.close();
	    } catch (Exception e) {
	        Log.e("TestFile", "Error on write File:" + e);
	    }
	}
	 
	// ?????????浠?
	public static File makeFilePath(String filePath, String fileName) {
	    File file = null;
	    makeRootDirectory(filePath);
	    try {
	        file = new File(filePath + fileName);
	        if (!file.exists()) {
	            file.createNewFile();
	            file.setExecutable(true);//璁剧疆?????ц????????  
	              file.setReadable(true);//璁剧疆???璇绘?????  
	              file.setWritable(true);//璁剧疆????????????  
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return file;
	}
	 
	// ?????????浠跺す
	public static void makeRootDirectory(String filePath) {
	    File file = null;
	    try {
	        file = new File(filePath);
	        if (!file.exists()) {
	            file.mkdir();
	        }
	    } catch (Exception e) {
	        Log.i("error:", e+"");
	    }
	}
	public static void deleteLogFile(String filePath, String fileName){
		File file = null;
	    try {
	        file = new File(filePath + fileName);
	        if (file.exists()) {
	            file.delete();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public static void deleteFile(File file) {
		if (file.exists()) { // ??ゆ?????浠舵?????瀛????
			if (file.isFile()) { // ??ゆ??????????????浠?
				file.delete(); // delete()??规?? 浣?搴?璇ョ?ラ?? ????????ょ????????;
			} else if (file.isDirectory()) { // ??????濡????瀹????涓?涓????褰?
				File files[] = file.listFiles(); // 澹版?????褰?涓?????????????浠? files[];
				for (int i = 0; i < files.length; i++) { // ?????????褰?涓?????????????浠?
					deleteFile(files[i]); // ???姣?涓????浠? ??ㄨ??涓???规??杩?琛?杩?浠?
				}
			}
			file.delete();
		} else {
			Log.e("", "???浠朵??瀛????锛?" + "\n");
		}
	}
	
	public static String readTxt(String logText){
	  try {
        File urlFile = new File(logText);
        if(!urlFile.exists()) return "";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(urlFile), "UTF-8");
        BufferedReader br = new BufferedReader(isr);  
        String str = "";   
        String mimeTypeLine = null ;
        while ((mimeTypeLine = br.readLine()) != null) {
        	str = str+mimeTypeLine;
		} 
        return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
	   return "";
	  
	}
	
	/**
	 * 璇诲???????板????ㄧ?????琛″?ㄨ?剧疆??????
	 * @savePath : 瀛???ㄨ矾寰?
	 * @return
	 */
	public static String readLocalEquParameter(String savePath){
		try {
	        File urlFile = new File(savePath);
	        if(!urlFile.exists()) return "";
	        InputStreamReader isr = new InputStreamReader(new FileInputStream(urlFile), "UTF-8");
	        BufferedReader br = new BufferedReader(isr);  
	        String str = "";   
	        String mimeTypeLine = null ;
	        while ((mimeTypeLine = br.readLine()) != null) {
	        	str = str+mimeTypeLine;
			} 
	        return str;
			} catch (Exception e) {
				e.printStackTrace();
			}
		   return "";
	}
}