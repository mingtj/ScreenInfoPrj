package com.ui;

import java.util.ArrayList;
import java.util.List;

import com.ui.bean.Sport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class GroupActivity extends Activity {


	private ListView listview;
	private List<Sport> sportList = new ArrayList<Sport>();
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group);
        
        //初始化控件
        initView();
        initData();
    }
    
    void initView(){
    	/**控件初始化**/
    	listview = (ListView) findViewById(R.id.listview);
    	
    	
    }
    
    void initData(){
    	Sport s1  = new Sport();
    	s1.setDates("2015-12-07");
    	s1.setDistances("15km");
    	
    	Sport s2  = new Sport();
    	s2.setDates("2015-12-07");
    	s2.setDistances("17km");
    	
    	Sport s3  = new Sport();
    	s3.setDates("2015-12-07");
    	s3.setDistances("19km");
    	
    	
    	Sport s4  = new Sport();
    	s4.setDates("2015-12-09");
    	s4.setDistances("50km");
    	
    	Sport s5  = new Sport();
    	s5.setDates("2015-12-12");
    	s5.setDistances("150km");
    	
    	Sport s6  = new Sport();
    	s6.setDates("2015-12-12");
    	s6.setDistances("159km");
    	
    	sportList.add(s1);
    	sportList.add(s2);
    	sportList.add(s3);
    	sportList.add(s4);
    	sportList.add(s5);
    	sportList.add(s6);
    	
    }
    
    
}