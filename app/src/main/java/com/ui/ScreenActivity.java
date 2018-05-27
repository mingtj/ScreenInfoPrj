package com.ui;

import org.xutils.x;

import com.ui.view.ScrollAlwaysTextView;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ScreenActivity  extends Activity implements OnClickListener{

	private TextView mIntroduce,mDensity,mDensityDpi,mWidth,mHeight,mWidthHeight,mTestTimer;
	private Button mShareToWX,mShareToWxF,mLoginWx;
	private ScrollAlwaysTextView mScollText;
	private ImageView testImg;
	/**
	 * 密度
	 * 0.75(120dpi)-低分辨率－ldpi-(类型)QVGA
	 * 1.0(160dpi)-中分辨率－mdpi-(类型)HVGA,VGA
	 * 1.5(240dpi)-高分辨率－hdpi-(类型)WVGA
	 * 2.0(320dpi)-超高分辨率－xhdpi－(类型)WQVGA  
	 * 3.0(480dpi)-超超高分辨率－xxhdpi－ 
	 * 4.0(640dpi)-超超超高分辨率－xxxhdpi－ 
	 */
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		x.view().inject(this);
		
		
        //初始化控件
        initView();
        //计时  timer方式实现
//        initTimer();
        //ScheduledExecutor方式实现
//        initScheduledExecutorService();
        //微信
        wxOpreat();
        
        //获取屏幕信息
        getScreenInfo();
        
        
	}

	void initView(){
		mIntroduce = (TextView) findViewById(R.id.introduce);
		mDensity = (TextView) findViewById(R.id.screen_density);
		mDensityDpi = (TextView) findViewById(R.id.screen_density_dpi);
		mWidth = (TextView) findViewById(R.id.screen_width);
		mHeight = (TextView) findViewById(R.id.screen_height);
		mWidthHeight = (TextView) findViewById(R.id.screen_width_height);
		mScollText = (ScrollAlwaysTextView) findViewById(R.id.scolltext);
		mTestTimer = (TextView) findViewById(R.id.test_timer);
		mScollText.setOnClickListener(this);
		
		  /**
         * wx
         */
		mShareToWX = (Button) findViewById(R.id.share_to_wx);
		mShareToWxF =(Button) findViewById(R.id.share_to_wxf);
		mLoginWx = (Button) findViewById(R.id.login_wx);
		mShareToWX.setOnClickListener(this);
		
		testImg = (ImageView) findViewById(R.id.test_img);
		
		ImageUtils.display(testImg, "assets/app_logo.png", true);
//		ImageUtils.display(testImg, "assets/app_logo.png");
	}
	
	
	  /**
     * 获取屏幕分辨率
     */
    void getScreenInfo(){
    	/**读取屏幕信息**/
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int widthPixels= dm.widthPixels;
        int heightPixels= dm.heightPixels;
        float density = dm.density;
        int densityDpi = dm.densityDpi;
        int screenWidth = (int) (widthPixels * density) ;
        int screenHeight = (int) (heightPixels * density) ;
        
        /**设备屏幕信息**/
        mIntroduce.setText(Html.fromHtml("0.75(120dpi)-低分辨率－ldpi-(类型)QVGA"+"<br>"+
        								 "1.0(160dpi)-中分辨率－mdpi-(类型)HVGA,VGA"+"<br>"+
        								 "1.5(240dpi)-高分辨率－hdpi-(类型)WVGA"+"<br>"+
        								 "2.0(320dpi)-超高分辨率－xhdpi－(类型)WQVGA"+"<br>"+		
        								 "3.0(480dpi)-超超高分辨率－xxhdpi"+"<br>"+
        								 "4.0(640dpi)-超超超高分辨率－xxxhdpi"+"<br>"
        		)
        		);
        
        //屏幕密度
        mDensity.setText("密度:"+density);
//        String a = "aa";
//        String b = "11";
//        String c = null;
//       c =  TextUtils.isEmpty(a)?"a为null":b;
//        mDensity.setText("密度:"+c);
        
//        mDensity.setText(Html.fromHtml("<font color=white>正在播出： </font><font color=\"#e9b90d\">"+"花花"+"</font>"));
        //密度DPI
        mDensityDpi.setText("密度DPI:"+densityDpi);
        
//        mDensityDpi.setText(Html.fromHtml("<font color=white>用微信扫一扫“</font><font color=#e9b90d size=100>关注</font><font color=white>”我们的官方微博精彩视频资讯早知道。</font>"));
		
        //屏幕实际宽 ＝ 分辨率宽＊密度
        mWidth.setText("实际宽:"+screenWidth+"(计算方式:widthPixels*density)");
        //屏幕实际高 ＝ 分辨率高＊密度
        mHeight.setText("实际高:"+screenHeight+"(计算方式:heightPixels*density)");
        //分辨率  高－宽
        mWidthHeight.setText("分辨率(高*宽):"+heightPixels+"*"+widthPixels);
        
        mScollText.setText("====实际宽:"+screenWidth+"(计算方式:widthPixels*density)");
    }

    
 void wxOpreat(){
    	
    }
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
}
