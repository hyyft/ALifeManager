package com.hyyft.noteeverything.fragment;

import com.hyyft.noteeverything.R;
import com.hyyft.noteeverything.weather.Weather;
import com.hyyft.noteeverything.weather.WeatherAsyncTast;
import com.hyyft.noteeverything.weather.WeatherAsyncTast.GetWeatherTast;

import android.view.View.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class HomeFragment extends Fragment { 


	private TextView addrTextView , temTextView , windTextView , weatherTextView;
	private TextView updateTextView;
	private View view;
	private Weather[] weathers;
	private final int WEATHER_DAY = 4;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		weathers = new Weather[WEATHER_DAY];
		WeatherAsyncTast wAsyncTast = new WeatherAsyncTast(getWeatherTast);
		wAsyncTast.execute(new String[]{});
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		view = inflater.inflate(R.layout.homefragment_layout, container, false);	
		findView(view);
		if( weathers[0] != null ){
			getWeather();
		}
		updateTextView.setOnClickListener(updateListener);
		return view;		
	}
	
	private OnClickListener updateListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			WeatherAsyncTast wAsyncTast = new WeatherAsyncTast(getWeatherTast);
			HomeFragment.this.updateTextView.setText("更新中.....");
			wAsyncTast.execute(new String[]{});
			
		}
	}; 
	
	/**
	 * 获取各个控件的对象
	 * @param view  fragment的布局
	 */
	private void findView(View view){
		addrTextView =  (TextView)view.findViewById(R.id.w_addr_tv);
		temTextView = (TextView)view.findViewById(R.id.w_tem_tv);
		windTextView = (TextView)view.findViewById(R.id.w_wind_tv);
		weatherTextView = (TextView)view.findViewById(R.id.w_weather_tv);
		updateTextView = (TextView)view.findViewById(R.id.w_update_tv);
	}
	
	/**
	 * 更新UI
	 */
	private void getWeather(){
		Resources resources = getActivity().getResources();		
		addrTextView.setText(weathers[0].getAddr());
		temTextView.setText(weathers[0].getTemNow());
		windTextView.setText(resources.getString(R.string.w_text_weather)+weathers[0].getWind());
		weatherTextView.setText(resources.getString(R.string.w_text_wind)+weathers[0].getWeather());
	}
	
	/**
	 * 更新UI的接口对象，可以在此匿名对象中更新fragment的UI
	 */
	private GetWeatherTast getWeatherTast = new GetWeatherTast() {
		
		@Override
		public void updateWeather(Weather[] weathers) {
			// TODO Auto-generated method stub
			if (weathers == null) {
					Toast.makeText(getActivity(), "网络超时", Toast.LENGTH_LONG).show();
					
			} else {
				HomeFragment.this.weathers = weathers;
				getWeather();
			}
			if(updateTextView.getText().toString().equals("更新中.....")){
				updateTextView.setText(getActivity().getResources().getString(R.string.w_text_update));
			}
	
		}
	};

	
}
