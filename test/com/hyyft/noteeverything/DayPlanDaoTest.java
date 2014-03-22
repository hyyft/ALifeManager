package com.hyyft.noteeverything;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.hyyft.noteeverything.dao.DayPlanDao;
import com.hyyft.noteeverything.dao.PlanDbHelperContract.PlanTableInfo;
import com.hyyft.noteeverything.modal.DayPlan;

import android.R.integer;
import android.content.ContentValues;
import android.test.AndroidTestCase;
import android.text.format.Time;
import android.util.Log;

public class DayPlanDaoTest extends AndroidTestCase {

	private static final String TAG = "DayPlanDaoTest";

	public void testAdd() {
		DayPlanDao dao = new DayPlanDao(this.getContext());
		DayPlan dayPlan = new DayPlan();
		dayPlan.setLevel("A");
		dayPlan.setOrder(1);
		dayPlan.setTitle("计划1");
		dayPlan.setContent("篮球运动");
		dayPlan.setBigTag("运动");
		dayPlan.setLitleTag("篮球");
		dayPlan.setPlanBeginTime(System.currentTimeMillis());
		dayPlan.setRealBeginTime(System.currentTimeMillis());
		dayPlan.setPlanTime(4);
		dayPlan.setRealTime(0);
		dayPlan.setIsFinish((short)0);
		dayPlan.setDate("2014-2-26");
		dao.add(dayPlan);
		
		dayPlan = new DayPlan();
		dayPlan.setLevel("A");
		dayPlan.setOrder(1);
		dayPlan.setTitle("计划1");
		dayPlan.setContent("篮球运动");
		dayPlan.setBigTag("运动");
		dayPlan.setLitleTag("篮球");
		dayPlan.setPlanBeginTime(System.currentTimeMillis());
		dayPlan.setRealBeginTime(System.currentTimeMillis());
		dayPlan.setPlanTime(4);
		dayPlan.setRealTime(0);
		dayPlan.setIsFinish((short)0);
		dayPlan.setDate("2014-2-27");
		dao.add(dayPlan);
		
		dayPlan = new DayPlan();
		dayPlan.setLevel("B");
		dayPlan.setOrder(2);
		dayPlan.setTitle("计划2");
		dayPlan.setContent("足球运动");
		dayPlan.setBigTag("运动");
		dayPlan.setLitleTag("足球");
		dayPlan.setPlanBeginTime(System.currentTimeMillis());
		dayPlan.setRealBeginTime(System.currentTimeMillis());
		dayPlan.setPlanTime(4);
		dayPlan.setRealTime(0);
		dayPlan.setIsFinish((short)0);
		dayPlan.setDate("2014-2-26");
		dao.add(dayPlan);
	}

	public void testDelete() {
		DayPlanDao dao = new DayPlanDao(this.getContext());
		dao.delete( 0, "2014-2-26");
	}

	public void testGetAll() {
		DayPlanDao dao = new DayPlanDao(this.getContext());
		List<DayPlan> listA = new ArrayList<DayPlan>();
		listA = dao.getAll(PlanTableInfo.PLAN_TABLE_NAME, "2014-2-26");
		Log.i(TAG , "onTestGetAll");
		for(int i = 0 ; i <  listA.size() ; i++ ){
			Log.i(TAG , listA.get(i).toString());
		}
		
		List<DayPlan> listA1 = new ArrayList<DayPlan>();
		listA1 = dao.getAll(PlanTableInfo.PLAN_TABLE_NAME, "2014-2-27");
		for(int i = 0 ; i <  listA1.size() ; i++ ){
			Log.i(TAG , listA1.get(i).toString());
		}
		
		
	}

	public void testUpdate(){
//		DayPlanDao dao = new DayPlanDao(this.getContext());
//		ContentValues values = new ContentValues();
//		values.put(PlanTableInfo.COLUMN_NAME_BIGTAG, "日常");
//		values.put(PlanTableInfo.COLUMN_NAME_ISFINISH, (short)1);
//		values.put(PlanTableInfo.COLUMN_NAME_REALTIME, 60);
//		dao.update(values, 1, "2014-2-26");
		Time time = new Time();
		time.set(0, 20 , 9 , 28, 2 , 2014);
		long t = time.toMillis(true);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(t);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		Log.i(TAG , year+":"+month+":"+day+":"+hour+":"+minute);
		
	}

}
