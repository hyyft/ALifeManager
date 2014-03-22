package com.hyyft.noteeverything.weather;


import android.os.AsyncTask;

/**
 * 用于获取天气的asyncTast对象
 * @author Administrator
 *
 */
public class WeatherAsyncTast extends AsyncTask<String, String, Weather[]> {

	private GetWeather getWeather;
	private Weather[] weathers;
	private GetWeatherTast getWeatherTast;
	
	public WeatherAsyncTast(GetWeatherTast getWeatherTast){
		this.getWeatherTast = getWeatherTast;
	}
	@Override
	protected Weather[] doInBackground(String... params) {
		// TODO Auto-generated method stub
		getWeather = new GetWeather();
		weathers = new Weather[4];
		try {
			weathers = getWeather.getWeather();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
		return weathers;
	}

	@Override
	protected void onPostExecute(Weather[] result) {
		// TODO Auto-generated method stub
		getWeatherTast.updateWeather(result);
	}
	
	
	/**
	 * WeatherAsyncTast的回调接口
	 * @author Administrator
	 *
	 */
	public interface GetWeatherTast{
		/**
		 * 在WeatherAsyncTast.onPostExecute中回调,更新天气控件UI
		 * @param weathers
		 */
		public void updateWeather(Weather[] weathers);
	}
}
