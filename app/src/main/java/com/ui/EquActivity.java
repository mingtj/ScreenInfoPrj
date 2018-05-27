package com.ui;



import com.ui.utils.LogHttpUtil;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class EquActivity extends Activity implements OnClickListener,OnSeekBarChangeListener{

	private final String TAG = "EquActivity";
	
	private SeekBar seekbar_def_1, seekbar_def_2,seekbar_def_3,seekbar_def_4,seekbar_def_5,seekbar_def_6,seekbar_def_7,seekbar_def_8,seekbar_def_9,seekbar_def_10,
	seekbar_def_11,seekbar_def_12,seekbar_def_13,seekbar_def_14,seekbar_def_15,seekbar_def_16,seekbar_def_17,seekbar_def_18,seekbar_def_19;
//	private TextView text_1,text_2,text_3,text_4,text_5,text_6,text_7,text_8,text_9,text_10,text_11,text_12,text_13,text_14,text_15,text_16,text_17,text_18,text_19;
	private TextView text_v1,text_v2,text_v3,text_v4,text_v5,text_v6,text_v7,text_v8,text_v9,text_v10,text_v11,text_v12,text_v13,text_v14,text_v15,text_v16,text_v17,text_v18,text_v19;
	private int v1=-1;
	private int v2 =-1;
	private int v3=-1;
	private int v4 =-1;
	private int v5 = -1;
	private int v6 = -1;
	private int v7 = -1;
	private int v8 = -1;
	private int v9 = -1;
	private int v10 = -1;
	private int v11 = -1;
	private int v12 = -1;
	private int v13 = -1;
	private int v14 = -1;
	private int v15 = -1;
	private int v16 = -1;
	private int v17 = -1;
	private int v18 = -1;
	private int v19 = -1;
	private int defaultValue = 18;
	
	private Button button_sure,button_reset;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equ);
		init();
		initEquData();
	}
	
	private void init(){
		seekbar_def_1 = (SeekBar) findViewById(R.id.seekbar_def_1);
		seekbar_def_2 = (SeekBar) findViewById(R.id.seekbar_def_2);
		seekbar_def_3 = (SeekBar) findViewById(R.id.seekbar_def_3);
		seekbar_def_4 = (SeekBar) findViewById(R.id.seekbar_def_4);
		seekbar_def_5 = (SeekBar) findViewById(R.id.seekbar_def_5);
		seekbar_def_6 = (SeekBar) findViewById(R.id.seekbar_def_6);
		seekbar_def_7 = (SeekBar) findViewById(R.id.seekbar_def_7);
		seekbar_def_8 = (SeekBar) findViewById(R.id.seekbar_def_8);
		seekbar_def_9 = (SeekBar) findViewById(R.id.seekbar_def_9);
		seekbar_def_10 = (SeekBar) findViewById(R.id.seekbar_def_10);
		seekbar_def_11 = (SeekBar) findViewById(R.id.seekbar_def_11);
		seekbar_def_12 = (SeekBar) findViewById(R.id.seekbar_def_12);
		seekbar_def_13 = (SeekBar) findViewById(R.id.seekbar_def_13);
		seekbar_def_14 = (SeekBar) findViewById(R.id.seekbar_def_14);
		seekbar_def_15 = (SeekBar) findViewById(R.id.seekbar_def_15);
		seekbar_def_16 = (SeekBar) findViewById(R.id.seekbar_def_16);
		seekbar_def_17 = (SeekBar) findViewById(R.id.seekbar_def_17);
		seekbar_def_18 = (SeekBar) findViewById(R.id.seekbar_def_18);
		seekbar_def_19 = (SeekBar) findViewById(R.id.seekbar_def_19);
		
//		text_1 = (TextView) findViewById(R.id.text_1); 
//		text_2 = (TextView) findViewById(R.id.text_2); 
//		text_3 = (TextView) findViewById(R.id.text_3); 
//		text_4 = (TextView) findViewById(R.id.text_4); 
//		text_5 = (TextView) findViewById(R.id.text_5); 
//		text_6 = (TextView) findViewById(R.id.text_6); 
//		text_7 = (TextView) findViewById(R.id.text_7); 
//		text_8 = (TextView) findViewById(R.id.text_8); 
//		text_9 = (TextView) findViewById(R.id.text_9); 
//		text_10 = (TextView) findViewById(R.id.text_10); 
//		text_11 = (TextView) findViewById(R.id.text_11); 
//		text_12 = (TextView) findViewById(R.id.text_12); 
//		text_13 = (TextView) findViewById(R.id.text_13); 
//		text_14 = (TextView) findViewById(R.id.text_14); 
//		text_15 = (TextView) findViewById(R.id.text_15); 
//		text_16 = (TextView) findViewById(R.id.text_16); 
//		text_17 = (TextView) findViewById(R.id.text_17); 
//		text_18 = (TextView) findViewById(R.id.text_18); 
//		text_19 = (TextView) findViewById(R.id.text_19); 
		
		
		text_v1 = (TextView) findViewById(R.id.seekbar_def_1v); 
		text_v2 = (TextView) findViewById(R.id.seekbar_def_2v); 
		text_v3 = (TextView) findViewById(R.id.seekbar_def_3v); 
		text_v4 = (TextView) findViewById(R.id.seekbar_def_4v); 
		text_v5 = (TextView) findViewById(R.id.seekbar_def_5v); 
		text_v6 = (TextView) findViewById(R.id.seekbar_def_6v); 
		text_v7 = (TextView) findViewById(R.id.seekbar_def_7v); 
		text_v8 = (TextView) findViewById(R.id.seekbar_def_8v); 
		text_v9 = (TextView) findViewById(R.id.seekbar_def_9v); 
		text_v10 = (TextView) findViewById(R.id.seekbar_def_10v); 
		text_v11 = (TextView) findViewById(R.id.seekbar_def_11v); 
		text_v12 = (TextView) findViewById(R.id.seekbar_def_12v); 
		text_v13 = (TextView) findViewById(R.id.seekbar_def_13v); 
		text_v14 = (TextView) findViewById(R.id.seekbar_def_14v); 
		text_v15 = (TextView) findViewById(R.id.seekbar_def_15v); 
		text_v16 = (TextView) findViewById(R.id.seekbar_def_16v); 
		text_v17 = (TextView) findViewById(R.id.seekbar_def_17v); 
		text_v18 = (TextView) findViewById(R.id.seekbar_def_18v); 
		text_v19 = (TextView) findViewById(R.id.seekbar_def_19v); 
		
		button_sure = (Button) findViewById(R.id.button_sure);
		button_reset = (Button) findViewById(R.id.button_reset);
		button_sure.setOnClickListener(this);
		button_reset.setOnClickListener(this);
		
		 seekbar_def_1.setOnSeekBarChangeListener(this);
	     seekbar_def_2.setOnSeekBarChangeListener(this);
	     seekbar_def_3.setOnSeekBarChangeListener(this);
	     seekbar_def_4.setOnSeekBarChangeListener(this);
	     seekbar_def_5.setOnSeekBarChangeListener(this);
	     seekbar_def_6.setOnSeekBarChangeListener(this);
	     seekbar_def_7.setOnSeekBarChangeListener(this);
	     seekbar_def_8.setOnSeekBarChangeListener(this);
	     seekbar_def_9.setOnSeekBarChangeListener(this);
	     seekbar_def_10.setOnSeekBarChangeListener(this);
	     seekbar_def_11.setOnSeekBarChangeListener(this);
	     seekbar_def_12.setOnSeekBarChangeListener(this);
	     seekbar_def_13.setOnSeekBarChangeListener(this);
	     seekbar_def_14.setOnSeekBarChangeListener(this);
	     seekbar_def_15.setOnSeekBarChangeListener(this);
	     seekbar_def_16.setOnSeekBarChangeListener(this);
	     seekbar_def_17.setOnSeekBarChangeListener(this);
	     seekbar_def_18.setOnSeekBarChangeListener(this);
	     seekbar_def_19.setOnSeekBarChangeListener(this);
	     
	}

	
	private void initEquData(){
		String localEquValue =  LogHttpUtil.readTxt(Constant.fileBase+Constant.SoundEquParameterFile);
		Log.d(TAG, "local==equ==value=="+localEquValue);
		
		  if(TextUtils.isEmpty(localEquValue)){
			  //没有保存的数据，给默认值
			  setDefaultValue();
		     }else{
		    	 //有保存的数据，读取保存的数据
		    	 
			     String g1 =  localEquValue.split(":")[0].trim().toString();
			     String g2 = localEquValue.split(":")[1].trim().toString();
			     String g3 =  localEquValue.split(":")[2].trim().toString();
			     String g4 = localEquValue.split(":")[3].trim().toString();
			     String g5 =  localEquValue.split(":")[4].trim().toString();
			     String g6 = localEquValue.split(":")[5].trim().toString();
			     String g7 =  localEquValue.split(":")[6].trim().toString();
			     String g8 = localEquValue.split(":")[7].trim().toString();
			     
			     String g9 =  localEquValue.split(":")[8].trim().toString();
			     String g10 = localEquValue.split(":")[9].trim().toString();
			     String g11 =  localEquValue.split(":")[10].trim().toString();
			     String g12 = localEquValue.split(":")[11].trim().toString();
			     String g13 =  localEquValue.split(":")[12].trim().toString();
			     String g14 = localEquValue.split(":")[13].trim().toString();
			     String g15 =  localEquValue.split(":")[14].trim().toString();
			     String g16 = localEquValue.split(":")[15].trim().toString();
			     
			     String g17 = localEquValue.split(":")[16].trim().toString();
			     String g18 =  localEquValue.split(":")[17].trim().toString();
			     String g19 = localEquValue.split(":")[18].trim().toString();
			     
			     
			     System.out.println("g1 = "+g1+"=G1.SIZE="+g1.length());
			     System.out.println("g2 = "+g2+"=G1.SIZE="+g2.length());
			     System.out.println("g3 = "+g3+"=G1.SIZE="+g3.length());
			     System.out.println("g4 = "+g4+"=G1.SIZE="+g4.length());
			     System.out.println("g5 = "+g5+"=G1.SIZE="+g5.length());
			     
			     v1 = Integer.parseInt(g1);
			     v2 = Integer.parseInt(g2);
			     v3 = Integer.parseInt(g3);
			     v4 = Integer.parseInt(g4);
			     v5 = Integer.parseInt(g5);
			     v6 = Integer.parseInt(g6);
			     v7 = Integer.parseInt(g7);
			     v8 = Integer.parseInt(g8);
			     v9 = Integer.parseInt(g9);
			     v10 = Integer.parseInt(g10);
			     v11 = Integer.parseInt(g11);
			     v12 = Integer.parseInt(g12);
			     v13 = Integer.parseInt(g13);
			     v14 = Integer.parseInt(g14);
			     v15 = Integer.parseInt(g15);
			     v16 = Integer.parseInt(g16);
			     v17 = Integer.parseInt(g17);
			     v18 = Integer.parseInt(g18);
			     v19 = Integer.parseInt(g19);
			     
			     text_v1.setText((v1-defaultValue)+"");
			     text_v2.setText((v2-defaultValue)+"");
			     text_v3.setText((v3-defaultValue)+"");
			     text_v4.setText((v4-defaultValue)+"");
			     text_v5.setText((v5-defaultValue)+"");
			     text_v6.setText((v6-defaultValue)+"");
			     text_v7.setText((v7-defaultValue)+"");
			     text_v8.setText((v8-defaultValue)+"");
			     text_v9.setText((v9-defaultValue)+"");
			     text_v10.setText((v10-defaultValue)+"");
			     text_v11.setText((v11-defaultValue)+"");
			     text_v12.setText((v12-defaultValue)+"");
			     text_v13.setText((v13-defaultValue)+"");
			     text_v14.setText((v14-defaultValue)+"");
			     text_v15.setText((v15-defaultValue)+"");
			     text_v16.setText((v16-defaultValue)+"");
			     text_v17.setText((v17-defaultValue)+"");
			     text_v18.setText((v18-defaultValue)+"");
			     text_v19.setText((v19-defaultValue)+"");
			     
			     
			     seekbar_def_1.setProgress(Integer.parseInt(g1));
			     seekbar_def_2.setProgress(Integer.parseInt(g2));
			     seekbar_def_3.setProgress(Integer.parseInt(g3));
			     seekbar_def_4.setProgress(Integer.parseInt(g4));
			     seekbar_def_5.setProgress(Integer.parseInt(g5));
			     seekbar_def_6.setProgress(Integer.parseInt(g6));
			     seekbar_def_7.setProgress(Integer.parseInt(g7));
			     seekbar_def_8.setProgress(Integer.parseInt(g8));
			     seekbar_def_9.setProgress(Integer.parseInt(g9));
			     seekbar_def_10.setProgress(Integer.parseInt(g10));
			     seekbar_def_11.setProgress(Integer.parseInt(g11));
			     seekbar_def_12.setProgress(Integer.parseInt(g12));
			     seekbar_def_13.setProgress(Integer.parseInt(g13));
			     seekbar_def_14.setProgress(Integer.parseInt(g14));
			     seekbar_def_15.setProgress(Integer.parseInt(g15));
			     seekbar_def_16.setProgress(Integer.parseInt(g16));
			     seekbar_def_17.setProgress(Integer.parseInt(g17));
			     seekbar_def_18.setProgress(Integer.parseInt(g18));
			     seekbar_def_19.setProgress(Integer.parseInt(g19));
		     }
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button_sure:
//			Toast.makeText(this, "sure", Toast.LENGTH_SHORT).show();
			//保存之前先移除之前保存的数据
			LogHttpUtil.deleteLogFile(Constant.fileBase, Constant.SoundEquParameterFile);
			
			StringBuffer sb = new StringBuffer();
			
			if(v1<10) sb.append(v1+" "+":");else sb.append(v1+":"); 
			if(v2<10) sb.append(v2+" "+":");else sb.append(v2+":"); 
			if(v3<10) sb.append(v3+" "+":");else sb.append(v3+":"); 
			if(v4<10) sb.append(v4+" "+":");else sb.append(v4+":"); 
			if(v5<10) sb.append(v5+" "+":");else sb.append(v5+":"); 
			if(v6<10) sb.append(v6+" "+":");else sb.append(v6+":"); 
			if(v7<10) sb.append(v7+" "+":");else sb.append(v7+":"); 
			if(v8<10) sb.append(v8+" "+":");else sb.append(v8+":"); 
			if(v9<10) sb.append(v9+" "+":");else sb.append(v9+":"); 
			if(v10<10) sb.append(v10+" "+":");else sb.append(v10+":"); 
			if(v11<10) sb.append(v11+" "+":");else sb.append(v11+":"); 
			if(v12<10) sb.append(v12+" "+":");else sb.append(v12+":"); 
			if(v13<10) sb.append(v13+" "+":");else sb.append(v13+":"); 
			if(v14<10) sb.append(v14+" "+":");else sb.append(v14+":"); 
			if(v15<10) sb.append(v15+" "+":");else sb.append(v15+":"); 
			if(v16<10) sb.append(v16+" "+":");else sb.append(v16+":"); 
			if(v17<10) sb.append(v17+" "+":");else sb.append(v17+":"); 
			if(v18<10) sb.append(v18+" "+":");else sb.append(v18+":"); 
			if(v19<10) sb.append(v19+" ");else sb.append(v19); 
			Log.d(TAG, "length="+sb.toString().length()+"=value="+sb.toString());
			
//			String param_str = v1 +":"+v2+":"+v3+":"+v4+":"+v5+":"+v6+":"+v7+":"+v8+":"+v9+":"+v10+":"+v11+":"+v12+":"+v13+":"+v14+":"+v15+":"+v16+":"+v17+":"+v18+":"+v19;
			
			LogHttpUtil.writeTxtToFile(sb.toString(), Constant.fileBase, Constant.SoundEquParameterFile);
			String txt =LogHttpUtil.readTxt(Constant.fileBase+Constant.SoundEquParameterFile);
			System.out.println("write success"+txt);
			Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
			this.finish();
			break;
		case R.id.button_reset:
//			Toast.makeText(this, "reset", Toast.LENGTH_SHORT).show();
			setDefaultValue();
			Toast.makeText(this, "重置成功", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
	}

	
	
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		// TODO Auto-generated method stub
		
		switch (seekBar.getId()) {
			case R.id.seekbar_def_1:
				seekbar_def_1.setProgress(progress);
//				v1 = progress -defaultValue;
				v1 = progress;
//				text_v1.setText(""+v1);
				text_v1.setText(""+(v1-defaultValue));
				Log.d(TAG, "==current==pro=="+progress+"=v1 = "+v1);
				break;
			case R.id.seekbar_def_2:
				seekbar_def_2.setProgress(progress);
//				v2 = progress -defaultValue;
				v2 = progress;
//				text_v2.setText(""+v2);
				text_v2.setText(""+(v2-defaultValue));
				Log.d(TAG, "==current==pro=="+progress+"=v2 = "+v2);
				break;
			case R.id.seekbar_def_3:
				seekbar_def_3.setProgress(progress);
//				v3 = progress -defaultValue;
				v3 = progress;
//				text_v3.setText(""+v3);
				text_v3.setText(""+(v3-defaultValue));
				Log.d(TAG, "==current==pro=="+progress+"=v3 = "+v3);
				break;
			case R.id.seekbar_def_4:
				seekbar_def_4.setProgress(progress);
//				v4 = progress -defaultValue;
				v4 = progress;
//				text_v4.setText(""+v4);
				text_v4.setText(""+(v4-defaultValue));
				Log.d(TAG, "==current==pro=="+progress+"=v4 = "+v4);
				break;
			case R.id.seekbar_def_5:
				seekbar_def_5.setProgress(progress);
//				v5 = progress -defaultValue;
				v5 = progress;
//				text_v5.setText(""+v5);
				text_v5.setText(""+(v5-defaultValue));
				Log.d(TAG, "==current==pro=="+progress+"=v5 = "+v5);
				break;
			case R.id.seekbar_def_6:
				seekbar_def_6.setProgress(progress);
//				v6 = progress -defaultValue;
				v6 = progress;
//				text_v6.setText(""+v6);
				text_v6.setText(""+(v6-defaultValue));
				Log.d(TAG, "==current==pro=="+progress+"=v6 = "+v6);
				break;
			case R.id.seekbar_def_7:
				seekbar_def_7.setProgress(progress);
//				v7 = progress -defaultValue;
				v7 = progress;
//				text_v7.setText(""+v7);
				text_v7.setText(""+(v7-defaultValue));
				Log.d(TAG, "==current==pro=="+progress+"=v7 = "+v7);
				break;
			case R.id.seekbar_def_8:
				seekbar_def_8.setProgress(progress);
//				v8 = progress -defaultValue;
				v8 = progress;
//				text_v8.setText(""+v8);
				text_v8.setText(""+(v8-defaultValue));
				Log.d(TAG, "==current==pro=="+progress+"=v8 = "+v8);
				break;
			case R.id.seekbar_def_9:
				seekbar_def_9.setProgress(progress);
//				v9 = progress -defaultValue;
				v9 = progress;
//				text_v9.setText(""+v9);
				text_v9.setText(""+(v9-defaultValue));
				Log.d(TAG, "==current==pro=="+progress+"=v9 = "+v9);
				break;
			case R.id.seekbar_def_10:
				seekbar_def_10.setProgress(progress);
//				v10 = progress -defaultValue;
				v10 = progress;
//				text_v10.setText(""+v10);
				text_v10.setText(""+(v10-defaultValue));
				Log.d(TAG, "==current==pro=="+progress+"=v10 = "+v10);
				break;
			case R.id.seekbar_def_11:
				seekbar_def_11.setProgress(progress);
//				v11 = progress -defaultValue;
				v11 = progress;
//				text_v11.setText(""+v11);
				text_v11.setText(""+(v11-defaultValue));
				Log.d(TAG, "==current==pro=="+progress+"=v11 = "+v11);
				break;
			case R.id.seekbar_def_12:
				seekbar_def_12.setProgress(progress);
//				v12 = progress -defaultValue;
				v12 = progress;
//				text_v12.setText(""+v12);
				text_v12.setText(""+(v12-defaultValue));
				Log.d(TAG, "==current==pro=="+progress+"=v12 = "+v12);
				break;
			case R.id.seekbar_def_13:
				seekbar_def_13.setProgress(progress);
//				v13 = progress -defaultValue;
				v13 = progress;
				text_v13.setText(""+v13);
				text_v13.setText(""+(v13-defaultValue));
				Log.d(TAG, "==current==pro=="+progress+"=v13 = "+v13);
				break;
			case R.id.seekbar_def_14:
				seekbar_def_14.setProgress(progress);
//				v14 = progress -defaultValue;
				v14 = progress;
//				text_v14.setText(""+v14);
				text_v14.setText(""+(v14-defaultValue));
				Log.d(TAG, "==current==pro=="+progress+"=v14 = "+v14);
				break;
			case R.id.seekbar_def_15:
				seekbar_def_15.setProgress(progress);
//				v15 = progress -defaultValue;
				v15 = progress;
//				text_v15.setText(""+v15);
				text_v15.setText(""+(v15-defaultValue));
				Log.d(TAG, "==current==pro=="+progress+"=v15 = "+v15);
				break;
			case R.id.seekbar_def_16:
				seekbar_def_16.setProgress(progress);
//				v16 = progress -defaultValue;
				v16 = progress;
//				text_v16.setText(""+v16);
				text_v16.setText(""+(v16-defaultValue));
				Log.d(TAG, "==current==pro=="+progress+"=v16 = "+v16);
				break;
			case R.id.seekbar_def_17:
				seekbar_def_17.setProgress(progress);
//				v17 = progress -defaultValue;
				v17 = progress;
				text_v17.setText(""+v17);
				text_v17.setText(""+(v17-defaultValue));
				Log.d(TAG, "==current==pro=="+progress+"=v17 = "+v17);
				break;
			case R.id.seekbar_def_18:
				seekbar_def_18.setProgress(progress);
//				v18 = progress -defaultValue;
				v18 = progress;
				text_v18.setText(""+v18);
				text_v18.setText(""+(v18-defaultValue));
				Log.d(TAG, "==current==pro=="+progress+"=v18 = "+v18);
				break;
			case R.id.seekbar_def_19:
				seekbar_def_19.setProgress(progress);
//				v19 = progress -defaultValue;
				v19 = progress;
//				text_v19.setText(""+v19);
				text_v19.setText(""+(v19-defaultValue));
				Log.d(TAG, "==current==pro=="+progress+"=v1 = "+v19);
				break;

		default:
			break;
		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void setDefaultValue(){
		v1 = 18;
		v2 = 18;
		v3 = 18;
		v4 = 18;
		v5 = 18;
		v6 = 18;
		v7 = 18 ;
		v8 = 18;
		v9 = 18;
		v10 = 18;
		v11 = 18;
		v12 = 18;
		v13  = 18;
		v14 = 18;
		v15 = 18;
		v16 = 18;
		v17 = 18;
		v18 =18;
		v19 = 18;
		seekbar_def_1.setProgress(defaultValue);
		seekbar_def_2.setProgress(defaultValue);
		seekbar_def_3.setProgress(defaultValue);
		seekbar_def_4.setProgress(defaultValue);
		seekbar_def_5.setProgress(defaultValue);
		seekbar_def_6.setProgress(defaultValue);
		seekbar_def_7.setProgress(defaultValue);
		seekbar_def_8.setProgress(defaultValue);
		seekbar_def_9.setProgress(defaultValue);
		seekbar_def_10.setProgress(defaultValue);
		seekbar_def_11.setProgress(defaultValue);
		seekbar_def_12.setProgress(defaultValue);
		seekbar_def_13.setProgress(defaultValue);
		seekbar_def_14.setProgress(defaultValue);
		seekbar_def_15.setProgress(defaultValue);
		seekbar_def_16.setProgress(defaultValue);
		seekbar_def_17.setProgress(defaultValue);
		seekbar_def_18.setProgress(defaultValue);
		seekbar_def_19.setProgress(defaultValue);
		
		text_v1.setText((v1-defaultValue)+"");
		text_v2.setText((v2-defaultValue)+"");
		text_v3.setText((v3-defaultValue)+"");
		text_v4.setText((v4-defaultValue)+"");
		text_v5.setText((v5-defaultValue)+"");
		text_v6.setText((v6-defaultValue)+"");
		text_v7.setText((v7-defaultValue)+"");
		text_v8.setText((v8-defaultValue)+"");
		text_v9.setText((v9-defaultValue)+"");
		text_v10.setText((v10-defaultValue)+"");
		text_v11.setText((v11-defaultValue)+"");
		text_v12.setText((v12-defaultValue)+"");
		text_v13.setText((v13-defaultValue)+"");
		text_v14.setText((v14-defaultValue)+"");
		text_v15.setText((v15-defaultValue)+"");
		text_v16.setText((v16-defaultValue)+"");
		text_v17.setText((v17-defaultValue)+"");
		text_v18.setText((v18-defaultValue)+"");
		text_v19.setText((v19-defaultValue)+"");
		
	}
	
	
	private String formatEquValue(String v){
		int res = Integer.parseInt(v.trim().toString());
		return (res-defaultValue)+"";
	}
	
}
