package com.hyyft.noteeverything.service;

import java.util.ArrayList;
import java.util.List;

import com.hyyft.noteeverything.dao.DayPlanDao;
import com.hyyft.noteeverything.dao.PlanDbHelperContract.PlanTableInfo;
import com.hyyft.noteeverything.global.NoteGlobal;
import com.hyyft.noteeverything.modal.DayPlan;
import com.hyyft.noteeverything.myconst.PrefConst;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import android.text.format.Time;
import android.util.Log;
  
/**
 * 初始化全局对象
 * @author Administrator
 *
 */
public class InitService extends Service {

    private static final String TAG = "InitService";
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		
		initDatabase();
		initTag();
		
		
		
//		DayPlan dayPlan  = new DayPlan();
//		dayPlan.setBigTag("运动");
//		dayPlan.setOrder(1);
//		dayPlan.setLitleTag("足球");
//		dayPlan.setTitle("haoba");
//		dayPlan.setContent("yexudfkdfj");
//		dayPlan.setPlanBeginTime(System.currentTimeMillis());
//		dayPlan.setDate(time.year+"-"+(time.month+1)+"-"+time.monthDay);
//		dbDao.add(dayPlan);
//		
//		DayPlan dayPlan1  = new DayPlan();
//		dayPlan1.setBigTag("运动");
//		dayPlan1.setOrder(2);
//		dayPlan1.setLitleTag("篮球");
//		dayPlan1.setTitle("yy");
//		dayPlan1.setContent("坏死的");
//		dayPlan1.setPlanBeginTime(System.currentTimeMillis());
//		dayPlan1.setDate("2014-2-27");
//		dbDao.add(dayPlan1);
//		Log.i(TAG ,"没有存入数据库"+dayPlan.getPlanBeginTime());
			
	
		stopSelf();
		
	}
	
	/**
	 * 初始化类型
	 */
	private void initTag(){
		SharedPreferences sharedPreferences = this.getSharedPreferences(PrefConst.NAME, MODE_PRIVATE);
		Editor editor = sharedPreferences.edit();
		if( sharedPreferences.getInt(PrefConst.FIRSTINIT, 0) == 0 ){
			editor.putInt(PrefConst.FIRSTINIT, 1);
			editor.putString(PrefConst.DATELY_TAG, "日常");
			editor.putString(PrefConst.STUDY_TAG, "学习");
			editor.putString(PrefConst.SPORT_TAG, "运动");
			editor.putString(PrefConst.FUNNY_TAG, "娱乐");
			editor.putString(PrefConst.TRIP_TAG, "旅游");
			editor.putInt(PrefConst.BIGTAG_COUNT, 5);
			
			editor.putString(PrefConst.DATELY_TAG+"-"+"1", "吃饭");
			editor.putString(PrefConst.DATELY_TAG+"-"+"2", "睡觉");
			
			editor.putInt(PrefConst.DATELY_COUNT, 2);
			editor.putInt(PrefConst.STUDY_COUNT, 0);
			editor.putInt(PrefConst.SPORT_COUNT, 0);
			editor.putInt(PrefConst.FUNNY_COUNT, 0);
			editor.putInt(PrefConst.TRIP_COUNT, 0);
			
			editor.commit();
			
		}
		else return;
		
	}
	
	private void initDatabase(){
		NoteGlobal noteGlobal = (NoteGlobal)getApplication();
		DayPlanDao dbDao = new DayPlanDao(this);
		Time time = new Time();
		time.setToNow();
		
		List<DayPlan> arraylist = new ArrayList<DayPlan>();
		arraylist = dbDao.getAll(PlanTableInfo.PLAN_TABLE_NAME,
				time.year+"-"+(time.month+1)+"-"+time.monthDay );
		
		for( int i=0 ; i< arraylist.size() ; i++ ){
			
			
			if( noteGlobal.maxPlanOrder<arraylist.get(i).getOrder() )
				noteGlobal.maxPlanOrder = arraylist.get(i).getOrder();
			if(noteGlobal.planList.isEmpty()){
				noteGlobal.planList.add(arraylist.get(i));
			}
			else{
				int j;
				for( j=0 ; 
					j<noteGlobal.planList.size() && ( noteGlobal.planList.get(j).getPlanBeginTime() < arraylist.get(i).getPlanBeginTime() );
					j++ );
				noteGlobal.planList.add( j , arraylist.get(i));
				
			}
		}
		
		for( int i=0 ; i<noteGlobal.planList.size() ; i++ ){
//			Log.i(TAG ,"存入数据库"+noteGlobal.planList.get(i).getPlanBeginTime());
			Log.i(TAG , noteGlobal.planList.get(i).toString());
		}
	}

}
