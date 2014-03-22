package com.hyyft.noteeverything.adapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hyyft.noteeverything.R;
import com.hyyft.noteeverything.modal.*;

public class DayPlanAdapter extends BaseAdapter {

	private List<DayPlan> list = new ArrayList<DayPlan>();  
	private Context context;
	
	public DayPlanAdapter(Context context){  
        this.context = context;  
    } 
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size(); 
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView = LayoutInflater.from(context)
				.inflate(R.layout.dayplanfragment_item_layout, null);
		TextView timeTextView , tagTextView , contentTextView , titleTextView;
		timeTextView = (TextView)convertView.findViewById(R.id.dayplanfragment_item_time);
		tagTextView = (TextView)convertView.findViewById(R.id.dayplanfragment_item_tag);
		contentTextView = (TextView)convertView.findViewById(R.id.dayplanfragment_item_content);
		titleTextView = (TextView)convertView.findViewById(R.id.dayplanfragment_item_title);
		
		final Calendar mCalendar=Calendar.getInstance();
		mCalendar.setTimeInMillis(list.get(position).getPlanBeginTime());
		
		timeTextView.setText(mCalendar.get(Calendar.HOUR_OF_DAY)+":"+mCalendar.get(Calendar.MINUTE));
		tagTextView.setText(list.get(position).getBigTag()+"-"+list.get(position).getLitleTag());
		titleTextView.setText(list.get(position).getTitle());
		contentTextView.setText(list.get(position).getContent());
		Log.i("TAG"  , list.get(position).getLevel()+list.get(position).getOrder() );
		return convertView;
	}
	public void addList(DayPlan dayPlan){  
        list.add(dayPlan);  
    } 

}
