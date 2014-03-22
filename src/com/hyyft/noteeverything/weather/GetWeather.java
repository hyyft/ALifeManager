package com.hyyft.noteeverything.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.hyyft.noteeverything.modal.CustomerHttpClient;

import android.util.Log;

public class GetWeather {

	private static final String TAG = "GetWeather";
	private JSONObject jsonObject;
	private JSONArray jsonArray;
	private Weather[] weather;
	private String cityName;
	
	
	public  Weather[] getWeather() throws Exception{
		cityName = getLocation();
		
		weather = new Weather[4];
		HttpClient client = CustomerHttpClient.getHttpClient();
		HttpGet httpGet = 
				new HttpGet("http://api.map.baidu.com/telematics/v3/weather?location="+cityName+"" +
						"&output=json&ak=gHaKUba6IsofT4WO6qgU6l3V");
		
		StringBuilder builder = new StringBuilder();
		
		try {
			HttpResponse response = client.execute(httpGet);
			BufferedReader reader = 
					new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			 for (String s = reader.readLine(); s != null; s = reader.readLine()) {
		            builder.append(s);
			 }
			 jsonObject = new JSONObject(builder.toString());
			 jsonArray = jsonObject.getJSONArray("results").getJSONObject(0).getJSONArray("weather_data");
			 
		} catch (JSONException e) {
			// TODO: handle exception
			Log.e(TAG, "��ȡjsonʧ��"); 
		}
		catch (IOException e1) {
			// TODO: handle exception
			Log.e(TAG, "��ȡjsonʧ��");
		}
		analyDateJson();
//		Log.i(TAG , weather[0].toString());
//		Log.i(TAG , weather[1].toString());
//		Log.i(TAG , weather[2].toString());
//		Log.i(TAG , weather[3].toString());
		return weather;
	}
	
	private String getLocation() throws Exception{
		String city=null;
		HttpClient client = CustomerHttpClient.getHttpClient();
		HttpGet httpGet = new HttpGet("http://api.map.baidu.com/location/ip?ak=gHaKUba6IsofT4WO6qgU6l3V");
		StringBuilder builder = new StringBuilder();
		try {
			HttpResponse response = client.execute(httpGet);
			BufferedReader reader = 
					new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			 for (String s = reader.readLine(); s != null; s = reader.readLine()) {
		            builder.append(s);
			 }
//			 Log.i(TAG , "��ȡλ�óɹ�");
			 JSONObject json = new JSONObject(builder.toString()).getJSONObject("content").getJSONObject("address_detail");
			 city = analyticJson(json , "city").toString();
			 
			 Log.i(TAG , city.substring(0, city.length()-1) );
		} catch (Exception e) {
			// TODO: handle exception
			Log.e(TAG, "Locationʧ��"); 
			return null;
		}
		return city.substring(0, city.length()-1);
	}
	
	private String analyticJson(JSONObject json , String tag){
		String realTem = "";
		try{
			realTem=json.getString(tag);  
		}catch(JSONException exception){
			Log.i(TAG , "����ʧ��");
		}
		
		return realTem;
	}

	private void analyDateJson(){
		JSONObject info;
		for(int i=0 ; i<4 ; i++){
			
			try {
				info = jsonArray.getJSONObject(i);
//				Log.i(TAG , info.getString("date") );
				weather[i] = new Weather();
				weather[i].setDate(info.getString("date").split("\\(")[0]);
				if (i == 0) {
					String temNow = info.getString("date").split("\\��")[1];
					weather[i].setTemNow(temNow.substring(0,
							temNow.length() - 1));
				}
				weather[i].setAddr(cityName);
				weather[i].setTemHight(info.getString("temperature"));
				weather[i].setWeather(info.getString("weather"));
				weather[i].setWind(info.getString("wind"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}