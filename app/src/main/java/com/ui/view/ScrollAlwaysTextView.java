package com.ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author mingtj
 * ???瀹?涔?TextView??т欢
 * ???瀛???垮害杩???胯????ㄦ?????
 *
 */
public class ScrollAlwaysTextView extends TextView {  
	   
	 public ScrollAlwaysTextView(Context context) {  
		 this(context, null);  
	 }  
	   
	 public ScrollAlwaysTextView(Context context, AttributeSet attrs) {  
		 this(context, attrs, android.R.attr.textViewStyle);  
	 }  
	   
	 public ScrollAlwaysTextView(Context context, AttributeSet attrs,int defStyle) {  
		 super(context, attrs, defStyle);  
	 }  
	   
	 @Override 
	 protected void onFocusChanged(boolean focused, int direction,Rect previouslyFocusedRect) {  
		 if (focused)  
			 super.onFocusChanged(focused, direction, previouslyFocusedRect);  
	 }  
	   
	 @Override 
	 public void onWindowFocusChanged(boolean focused) {  
		 if (focused)  
			 super.onWindowFocusChanged(focused);  
	 }  
	   
	 @Override 
	 public boolean isFocused() {  
		 return true;  
	 }  
	} 
