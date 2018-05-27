//package com.ui;
//
//import java.util.Timer;
//import java.util.TimerTask;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.ScheduledFuture;
//import java.util.concurrent.TimeUnit;
//
////import com.huan.edu.tvplayer.view.MyVideoView;
//import com.ui.view.ScrollAlwaysTextView;
//
//import android.R;
//import android.app.Activity;
//import android.content.Intent;
//import android.graphics.Color;
//import android.graphics.drawable.Drawable;
//import android.net.Uri;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.text.Html;
//import android.text.Spannable;
//import android.text.SpannableStringBuilder;
//import android.text.TextUtils;
//import android.text.style.ForegroundColorSpan;
//import android.text.style.ImageSpan;
//import android.util.DisplayMetrics;
//import android.util.Log;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.MediaController;
//import android.widget.RelativeLayout;
//import android.widget.ScrollView;
//import android.widget.TextView;
//
//public class ScreenInfoActivity extends Activity  implements OnClickListener{
//
//	private TextView mIntroduce,mDensity,mDensityDpi,mWidth,mHeight,mWidthHeight,mTestTimer;
//	private Button mShareToWX,mShareToWxF,mLoginWx;
//	private ScrollAlwaysTextView mScollText;
////	private com.huan.edu.tvplayer.view.MyVideoView myVieoView;
//	/**
//	 * 密度
//	 * 0.75(120dpi)-低分辨率－ldpi-(类型)QVGA
//	 * 1.0(160dpi)-中分辨率－mdpi-(类型)HVGA,VGA
//	 * 1.5(240dpi)-高分辨率－hdpi-(类型)WVGA
//	 * 2.0(320dpi)-超高分辨率－xhdpi－(类型)WQVGA  
//	 */
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//        
//        //初始化控件
//        initView();
//        //计时  timer方式实现
////        initTimer();
//        //ScheduledExecutor方式实现
////        initScheduledExecutorService();
//        //微信
//        wxOpreat();
//        
//        //获取屏幕信息
//        getScreenInfo();
//        
//        
//
//    }
//    /****
//     * CCTV-1综合,http://183.58.12.204:30001/PLTV/88888905/224/3221227518/index.m3u8
//CCTV-1综合,http://live.aishang.ctlcdn.com/hls/ch237_10240127/ch237_10240127forsec.m3u8
//CCTV-1综合,http://live.aishang.ctlcdn.com/hls/ch136_10240001/ch136_10240001forsec.m3u8
//CCTV-2财经,http://183.58.12.204:30001/PLTV/88888905/224/3221227582/index.m3u8
//CCTV-2财经,http://live.aishang.ctlcdn.com/hls/ch137_10240002/ch137_10240002forsec.m3u8
//CCTV-4(亚洲),http://live.aishang.ctlcdn.com/hls/ch139_10240005/ch139_10240005forsec.m3u8
//CCTV-7军事与农业,http://live.aishang.ctlcdn.com/hls/ch142_10240009/ch142_10240009forsec.m3u8
//CCTV-9纪录,http://live.aishang.ctlcdn.com/hls/ch143_10240014/ch143_10240014forsec.m3u8
//CCTV-10科教,http://live.aishang.ctlcdn.com/hls/ch144_10240015/ch144_10240015forsec.m3u8
//CCTV-11戏曲,http://live.aishang.ctlcdn.com/hls/ch145_10240016/ch145_10240016forsec.m3u8
//CCTV-12社会与法,http://183.58.12.204:30001/PLTV/88888905/224/3221227640/index.m3u8
//CCTV-12社会与法,http://live.aishang.ctlcdn.com/hls/ch146_10240017/ch146_10240017forsec.m3u8
//CCTV-13新闻,http://zv.3gv.ifeng.com/live/CCTV13.m3u8
//CCTV-13新闻,http://zb.v.qq.com:1863/?progid=3106580178&ostype=iptv
//CCTV-13新闻,http://live.aishang.ctlcdn.com/hls/ch236_10240126/ch236_10240126forsec.m3u8
//CCTV-13新闻,http://ptvlivef1.people.com.cn/2010/cctv13/live_600.flv
//CCTV-14少儿,http://live.aishang.ctlcdn.com/hls/ch148_10240085/ch148_10240085forsec.m3u8
//CCTV-15音乐,http://live.aishang.ctlcdn.com/hls/ch149_10240086/ch149_10240086forsec.m3u8
//CCTV-5+体育赛事,http://live.aishang.ctlcdn.com/hls/ch238_10240128/ch238_10240128forsec.m3u8
//     */
//    
//    /**
//     * 日韩CR电影4,rtmp://123.108.164.71/etv2/phd1003
//韩国01,rtmp://123.108.164.71/etv2sb/pld59
//韩国02,rtmp://123.108.164.71/etv2sb/pld60
//韩国03,rtmp://123.108.164.71/etv2sb/pld61
//韩国04,rtmp://123.108.164.71/etv2sb/pld62
//韩国05,rtmp://123.108.164.71/etv2sb/pld63
//韩国06,rtmp://123.108.164.71/etv2sb/pld64
//韩国08,rtmp://123.108.164.71/etv2sb/pld499
//韩国09,rtmp://123.108.164.71/etv2sb/pld501
//韩国10,rtmp://123.108.164.71/etv2sb/pld511
//韩国13,rtmp://123.108.164.71/etv2sb/pld769
//韩国14,rtmp://123.108.164.71/etv2sb/pld771
//韩国15,rtmp://123.108.164.71/etv2sb/pld772
//韩国18,rtmp://123.108.164.71/etv2sb/pld968
//韩国19,rtmp://123.108.164.71/etv2sb/pld991
//韩国20,rtmp://123.108.164.71/etv2sb/pld992
//韩国21,rtmp://123.108.164.71/etv2sb/pld993
//韩国22,rtmp://123.108.164.71/etv2/pld1003
//韩国23,rtmp://123.108.164.71/etv2/pld1005
//韩国24,rtmp://123.108.164.71/etv2/pld1006
//韩国25,rtmp://123.108.164.71/etv2/pld1008
//韩国01,rtmp://123.108.164.71/etv2sb/phd59
//韩国02,rtmp://123.108.164.71/etv2sb/phd60
//韩国03,rtmp://123.108.164.71/etv2sb/phd61
//韩国04,rtmp://123.108.164.71/etv2sb/phd62
//韩国05,rtmp://123.108.164.71/etv2sb/phd63
//韩国06,rtmp://123.108.164.71/etv2sb/phd64
//韩国08,rtmp://123.108.164.71/etv2sb/phd499
//韩国09,rtmp://123.108.164.71/etv2sb/phd501
//韩国10,rtmp://123.108.164.71/etv2sb/phd511
//韩国13,rtmp://123.108.164.71/etv2sb/phd769
//韩国有14,rtmp://123.108.164.71/etv2sb/phd771
//韩国有15,rtmp://123.108.164.71/etv2sb/phd772
//韩国有18,rtmp://123.108.164.71/etv2sb/phd968
//韩国有19,rtmp://123.108.164.71/etv2sb/phd991
//韩国有20,rtmp://123.108.164.71/etv2sb/phd992
//韩国有21,rtmp://123.108.164.71/etv2sb/phd993
//韩国有22,rtmp://123.108.164.71/etv2/phd1003
//韩国有23,rtmp://123.108.164.71/etv2/phd1005
//韩国有24,rtmp://123.108.164.71/etv2/phd1006
//韩国有25,rtmp://123.108.164.71/etv2/phd1008
//韩国KCTV,rtmp://122.202.129.136:1935/live/ch4
//韩国KCTV-HD,rtmp://122.202.129.136:1935/live/ch5
//KTV-HD,rtmp://218.38.152.31/klive/klive.stream
//韩国KCTV,rtmp://122.202.129.136:1935/live/ch4
//韩国KCTV-HD,rtmp://122.202.129.136:1935/live/ch5
//     */
//    String urls1= "http://zv.3gv.ifeng.com/live/CCTV13.m3u8";
//   String  urls2= "rtmp://123.108.164.71/etv2sb/pld992";
//   String urls3 = "http://183.232.54.210:8935/live/hcctv_108/chunklist.m3u8";
//    
//   private final Timer timer = new Timer();
//   private TimerTask task;
//   private int count = 0;
//   private Runnable runableTask;
//   Handler handler = new Handler() {
//       @Override
//       public void handleMessage(Message msg) {
//           // TODO Auto-generated method stub
//           super.handleMessage(msg);
//           switch (msg.what) {
//		case 1:
//			 // 要做的事情
//	           count = count+1;
//	    	   mTestTimer.setText(""+count);
////	    	   throw new RuntimeException(); 
//	    	   
//			break;
//
//		default:
//			break;
//		}
//       
//       }
//   };
//   
//   private static final ScheduledExecutorService scheduExec = Executors.newScheduledThreadPool(1); 
//   
//   ScheduledExecutorTest scheduledExecutorTest;
//   
//   void initScheduledExecutorService(){
//	   scheduledExecutorTest = new ScheduledExecutorTest();
////	   runableTask = new Runnable() {
////		
////		@Override
////		public void run() {
//////			throw new RuntimeException(); 
////			Message message = new Message();
////	        message.what = 1;
////	        handler.sendMessage(message);
////		}
////	};
////	//开始计时
////	/**
////	 * final ScheduledFuture<?> checkerHandle = scheduler.scheduleAtFixedRate(checker, 1, 5, TimeUnit.MINUTES); 
////	 */
////	scheduExec.scheduleWithFixedDelay(runableTask, 1000, 1000, TimeUnit.MILLISECONDS); 
//	   
//	   
//	   scheduledExecutorTest.lanuchTimer(handler);
//   }
//   
//   void initTimer(){
//	   task = new TimerTask() {
//		    @Override
//		    public void run() {
//		        // TODO Auto-generated method stub
//		        Message message = new Message();
//		        message.what = 1;
//		        handler.sendMessage(message);
//		    	
//		    	throw new RuntimeException(); 
//		    }
//		}; 
//		
//		timer.schedule(task, 1000, 1000); 
//		//timer.cancel();取消计时
//   }
//   
//    protected void onResume() {
//    	super.onResume();
////    	startVideoView(urls3);
//    }
//    
//    
//    void initView(){
//    	/**控件初始化**/
//        mIntroduce = (TextView) findViewById(R.id.introduce);
//        mDensity = (TextView) findViewById(R.id.screen_density);
//        mDensityDpi = (TextView) findViewById(R.id.screen_density_dpi);
//        mWidth = (TextView) findViewById(R.id.screen_width);
//        mHeight = (TextView) findViewById(R.id.screen_height);
//        mWidthHeight = (TextView) findViewById(R.id.screen_width_height);
//        mScollText = (ScrollAlwaysTextView) findViewById(R.id.scolltext);
////        myVieoView = (MyVideoView) findViewById(R.id.videoview);
//        mTestTimer = (TextView) findViewById(R.id.test_timer);
////        myVieoView.setOnClickListener(this);
//        mScollText.setOnClickListener(this);
//        
//        /**
//         * wx
//         */
//        mShareToWX = (Button) findViewById(R.id.share_to_wx);
//        mShareToWxF = (Button) findViewById(R.id.share_to_wxf);
//        mLoginWx = (Button) findViewById(R.id.login_wx);
//        
//        mShareToWX.setOnClickListener(this);
//    }
//    
//    boolean fullscreen = false;
//    void screenChange(){
//    	 if(!fullscreen){//设置RelativeLayout的全屏模式
//    	        RelativeLayout.LayoutParams layoutParams=
//    	               new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);
//    	            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//    	            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
//    	            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
//    	            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
////    	            myVieoView.setLayoutParams(layoutParams);
//    	            
//    	            fullscreen = true;//改变全屏/窗口的标记
//    	        }else{//设置RelativeLayout的窗口模式
//    	           RelativeLayout.LayoutParams lp=new  RelativeLayout.LayoutParams(300,300);
//    	           lp.addRule(RelativeLayout.CENTER_IN_PARENT);
////    	           myVieoView.setLayoutParams(lp);
//    	             fullscreen = false;//改变全屏/窗口的标记
//    	        }    
//    }
//    
////	public void startVideoView(String videoUrl) {
////	if (myVieoView != null && !myVieoView.isPlaying()) {
////		try {
////				MediaController mc = new MediaController(this);
////				mc.setVisibility(View.GONE);
////				myVieoView.setMediaController(mc);
////		} catch (Exception e) {
////			// TODO: handle exception
////			Log.e("Exception", "Scree" + e.toString());
////
////		}
////		try {
////				// 自己编辑
////				myVieoView.setVideoURI(parseUri(videoUrl));
////				if (!myVieoView.isPlaying()) {
////					myVieoView.start();
////				}
////
////		} catch (Exception e) {
////			Log.e("Exception", "fragment：613行,后台没返回视频地址");
////		}
////	}
////}
//	public Uri parseUri(String uri) {
//	return Uri.parse(uri);
//
//}
//    void wxOpreat(){
//    	
//    }
//    
//    /**
//     * 获取屏幕分辨率
//     */
//    void getScreenInfo(){
//    	/**读取屏幕信息**/
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int widthPixels= dm.widthPixels;
//        int heightPixels= dm.heightPixels;
//        float density = dm.density;
//        int densityDpi = dm.densityDpi;
//        int screenWidth = (int) (widthPixels * density) ;
//        int screenHeight = (int) (heightPixels * density) ;
//        
//        /**设备屏幕信息**/
//        mIntroduce.setText(Html.fromHtml("0.75(120dpi)-低分辨率－ldpi-(类型)QVGA"+"<br>"+
//        								 "1.0(160dpi)-中分辨率－mdpi-(类型)HVGA,VGA"+"<br>"+
//        								 "1.5(240dpi)-高分辨率－hdpi-(类型)WVGA"+"<br>"+
//        								 "2.0(320dpi)-超高分辨率－xhdpi－(类型)WQVGA"));
//        
//        //屏幕密度
//        mDensity.setText("密度:"+density);
////        String a = "aa";
////        String b = "11";
////        String c = null;
////       c =  TextUtils.isEmpty(a)?"a为null":b;
////        mDensity.setText("密度:"+c);
//        
////        mDensity.setText(Html.fromHtml("<font color=white>正在播出： </font><font color=\"#e9b90d\">"+"花花"+"</font>"));
//        //密度DPI
//        mDensityDpi.setText("密度DPI:"+densityDpi);
//        
////        mDensityDpi.setText(Html.fromHtml("<font color=white>用微信扫一扫“</font><font color=#e9b90d size=100>关注</font><font color=white>”我们的官方微博精彩视频资讯早知道。</font>"));
//		
//        //屏幕实际宽 ＝ 分辨率宽＊密度
//        mWidth.setText("实际宽:"+screenWidth+"(计算方式:widthPixels*density)");
//        //屏幕实际高 ＝ 分辨率高＊密度
//        mHeight.setText("实际高:"+screenHeight+"(计算方式:heightPixels*density)");
//        //分辨率  高－宽
//        mWidthHeight.setText("分辨率(高*宽):"+heightPixels+"*"+widthPixels);
//        
//        mScollText.setText("====实际宽:"+screenWidth+"(计算方式:widthPixels*density)");
//    }
//
//    boolean  timerIsCancel = false;
//	@Override
//	public void onClick(View v) {
//		switch (v.getId()) {
////		case R.id.videoview:
////			screenChange();
////			break;
//		case R.id.scolltext:
//			screenChange();
//			break;
//		case R.id.share_to_wx:
//			if(timerIsCancel){
////				timer.schedule(task, 1000, 1000);
////				timer.
////				initTimer();
////				if(scheduExec.isShutdown()){
////					scheduExec.scheduleWithFixedDelay(runableTask,1000, 1000, TimeUnit.MILLISECONDS);
////				}
//				initScheduledExecutorService();
//				timerIsCancel = false;
//			}else{
////				timer.cancel();
////				scheduExec.shutdown();
//				scheduledExecutorTest.stopTimer();
//				timerIsCancel = true;
//			}
//			
//			break;
//		default:
//			break;
//		}
//	}
//}