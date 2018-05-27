package com.ui;


import com.lidroid.xutils.util.LogUtils;

import android.app.TabActivity;
import android.content.BroadcastReceiver;
import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;


public class AcouasmMusicActivity extends TabActivity {
	private TabHost tab ;
	private LayoutInflater layoutInflater ;
	private Intent it;

	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acouasmmusic);
        init();
        //注册回调事件
        YunyingshangInfo.setNvaChangListener(changNva);
    }
    
    @Override
    protected void onStart() {
    	// TODO Auto-generated method stub
    	super.onStart();
    }
    
    public void init(){
		tab = getTabHost();
		tab.setFocusable(true);
		layoutInflater = LayoutInflater.from(this);
		
////		for(int i=0;i<3;i++){
////			TabSpec tabSpec = tab.newTabSpec(Constant.ConValue.mTextviewArray[i]).
////			setIndicator(getTabItemView(i)).
////			setContent(getTabItemIntent(i));
////			tab.addTab(tabSpec);
////			//设置TabHost样式
////			tab.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
//			tab.setOnTabChangedListener(new OnTabChangeListener() {
//				
//				@Override
//				public void onTabChanged(String tabId) {
//					if(tabId.equals("cavas")){
//						Intent intent = new Intent(AcouasmMusicActivity.this, ScreenInfoActivity.class);
//						startActivity(intent);
//					}else{
//						for(int i=0;i<3;i++){
//						TabSpec tabSpec = tab.newTabSpec(Constant.ConValue.mTextviewArray[i]).
//								setIndicator(getTabItemView(i)).
//								setContent(getTabItemIntent(i));
//								tab.addTab(tabSpec);
//								//设置TabHost样式
//								tab.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
//								}
//					}
//				}
//			});
		
		
		
		for(int i=0;i<4;i++){
			TabSpec tabSpec = tab.newTabSpec(Constant.ConValue.mTextviewArray[i]).
			setIndicator(getTabItemView(i)).
			setContent(getTabItemIntent(i));
			tab.addTab(tabSpec);
			//设置TabHost样式
			tab.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
//			tab.setOnTabChangedListener(new OnTabChangeListener() {
//				
//				@Override
//				public void onTabChanged(String tabId) {
//					if(tabId.equals("cavas")){
//						Intent intent = new Intent(AcouasmMusicActivity.this, ScreenInfoActivity.class);
//						startActivity(intent);
//					}
//				}
//			});
		}
		
	}
	
    //回调方法，处理回调之后的逻辑
    private ChangNva changNva = new ChangNva(){

		@Override
		public void replaceNva() {
			//跳转到第二个页面   index为1
			tab.setCurrentTab(1);
		}

		
		
	};
	
	//设置选项卡格式  包括图片资源  背景   文字大小等
	private View getTabItemView(int index){
		//载入新的资源
		View view = layoutInflater.inflate(R.layout.tab_item_view, null);
		TextView textView = (TextView) view.findViewById(R.id.textview);		
		textView.setText(Constant.ConValue.mTextviewArray[index]);	
		
		return view;
		
	}
	
	//设置选项卡对应的Activity
	private Intent getTabItemIntent(int index)
	{
		Intent intent = new Intent(this, Constant.ConValue.mTabClassArray[index]);
		
		return intent;
	}
	
	
	private class MyCompletionListener extends BroadcastReceiver{
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
		}
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	

}
	