package com.ui.view;

import com.ui.R;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

public class DataLoadingProgressDialog {
	
	private static Dialog mDialog = null;
	public static void showProgressDialog(Context context){
		unShowProgressDialog();
	   mDialog = new Dialog(context);
		mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);	//去除标题栏
		mDialog.requestWindowFeature(Window.FEATURE_OPTIONS_PANEL);
		mDialog.setContentView(R.layout.progress);
		//设置activity中的控件透明 
		Window window = mDialog.getWindow();	
		window.setBackgroundDrawableResource(R.color.transparent);
		WindowManager.LayoutParams wl 	= window.getAttributes();  
		wl.flags 						= WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON; 
		wl.alpha						=1.0f;//设置透明度,0.0为完全透明，1.0为完全不透明 
		wl.dimAmount              =0.0f;//设置黑暗度,0.0为完全不暗，1.0为完全暗   
		window.setAttributes(wl);
		mDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
		mDialog.show();
	}
	
	public static void showIsCancelProgressDialog(Context context, boolean isCancel){
		showProgressDialog(context);
		mDialog.setCancelable(isCancel);
	}
	
	public static void unShowProgressDialog() {
		if(mDialog != null &&mDialog.isShowing()){
			mDialog.dismiss();
			mDialog = null;
		}
	}
}
