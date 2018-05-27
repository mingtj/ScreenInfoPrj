package com.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class CompareActivity extends Activity implements OnClickListener{


	
	private TextView mName,mJiage,mXiaoliang,mDate;
	private ListView mListview;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comparelayout);
		initView();
	}
	
	void initView(){
		mName = (TextView) findViewById(R.id.name);
		mJiage = (TextView) findViewById(R.id.jiage);
		mXiaoliang = (TextView) findViewById(R.id.xiaoliang);
		mDate = (TextView) findViewById(R.id.riqi);
		
		mListview =(ListView) findViewById(R.id.listview);
		
		mName.setOnClickListener(this);
		mJiage.setOnClickListener(this);
		mXiaoliang.setOnClickListener(this);
		mDate.setOnClickListener(this);
	}

	
	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.name:
			
			break;
		case R.id.jiage:
			
			break;
		case R.id.xiaoliang:
			
			break;
		case R.id.riqi:
			
			break;
		default:
			break;
		}
	}
	
	
}
