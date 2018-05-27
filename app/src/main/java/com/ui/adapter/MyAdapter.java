package com.ui.adapter;

import java.util.List;
import java.util.Map;

import com.ui.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class MyAdapter extends BaseAdapter {

		 private LayoutInflater mInflater;
		  private List<Map<String, String>> listData;
		  private List<Map<String, String>> splitData;
		  public MyAdapter(Context context,List<Map<String, String>> listData,List<Map<String, String>> splitData) {

		   this.mInflater = LayoutInflater.from(context);
		   this.listData = listData;
		   this.splitData = splitData;
		  }
		 
		  @Override
		  public int getCount() {
		   return listData.size();
		  }
		 
		  @Override
		  public Object getItem(int position) {
		   return listData.get(position);
		  }
		 
		  @Override
		  public long getItemId(int position) {
		   return position;
		  }
		 
		  @Override
		  public boolean isEnabled(int position) {
		   if (splitData.contains(listData.get(position))) {
		     return false;
		   }
		   return super.isEnabled(position);
		  }
		 
		  @Override
		  public View getView(final int position, View convertView, ViewGroup parent) {
			  final Holder holder = new Holder();
			  
			  
			  
			  if (splitData.contains(listData.get(position))) {
				     convertView = mInflater.inflate(R.layout.spilt_items_tag, null);
				   } else {
				     convertView = mInflater.inflate(R.layout.spilt_items, null);
				   }
			  
		   holder.mNewsTitle = (TextView) convertView.findViewById(R.id.item_paper_title);
		   holder.mNewsImg = (ImageView) convertView.findViewById(R.id.item_paper_img);
		   holder.mNewsPaper = (TextView) convertView.findViewById(R.id.item_paper_name);
		   
		   holder.mNewsTitle.setText(listData.get(position).get("ItemName"));
		   holder.mNewsPaper.setText(listData.get(position).get("paperName"));
		   
			
		   return convertView;
		  }
		  
			 class Holder {
				TextView mNewsTitle;
				ImageView mNewsImg;
				TextView mNewsPaper;
			}
	}