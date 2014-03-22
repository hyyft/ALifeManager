package com.hyyft.noteeverything.dao;

import com.hyyft.noteeverything.dao.PlanDbHelperContract.DoWhatTableInfo;
import com.hyyft.noteeverything.dao.PlanDbHelperContract.PlanTableInfo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DaoDbHelper extends SQLiteOpenHelper{
	

	public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "NoteEverything.db";
	private static final String TAG = "PlanDbHelper";
	public DaoDbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
		
	}
	
	
	public void onCreate(SQLiteDatabase db) {
		createPlanTable(db);
		createDoWhatTable(db);
		
    }
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        
    }
	
	/**
	 * 创建Plan信息表
	 * @param db
	 */
	private void createPlanTable(SQLiteDatabase db){
		String sql = "create table "+ PlanTableInfo.PLAN_TABLE_NAME+"("+
				PlanTableInfo.COLUMN_NAME_ID+" INTEGER PRIMARY KEY ," +
				PlanTableInfo.COLUMN_NAME_LEVEL+" CHAR(1) ,"+
				PlanTableInfo.COLUMN_NAME_ORDER+" INTEGER,"+
				PlanTableInfo.COLUMN_NAME_TITLE+"  VARCHAR(30),"+
				PlanTableInfo.COLUMN_NAME_CONTENT+" TEXT , "+
				PlanTableInfo.COLUMN_NAME_BIGTAG+" TEXT ,"+
				PlanTableInfo.COLUMN_NAME_LITTLETAG+" TEXT ,"+
				PlanTableInfo.COLUMN_NAME_PLANBEGINTIME+" DOUBLE ,"+
				PlanTableInfo.COLUMN_NAME_REALBEGINTIME+" DOUBLE ,"+
				PlanTableInfo.COLUMN_NAME_PLANTIME+" INTEGER,"+
				PlanTableInfo.COLUMN_NAME_REALTIME+" INTEGER,"+
				PlanTableInfo.COLUMN_NAME_ISFINISH+" INTEGER,"+
				PlanTableInfo.COLUMN_NAME_DATE+" TEXT);";
	Log.i(TAG , sql);
	db.execSQL(sql);
	}
	
	
	
	/**
	 * 创建
	 * @param db
	 */
	private void createDoWhatTable(SQLiteDatabase db){
		String sql = "create table "+ DoWhatTableInfo.TABLE_NAME+"("+
				DoWhatTableInfo.COLUMN_NAME_ID+" INTEGER PRIMARY KEY ," +
				DoWhatTableInfo.COLUMN_NAME_ORDER+" INTEGER ," +
				DoWhatTableInfo.COLUMN_NAME_CONTENT+" TEXT , "+
				DoWhatTableInfo.COLUMN_NAME_BIGTAG+" TEXT ,"+
				DoWhatTableInfo.COLUMN_NAME_LITTLETAG+" TEXT ,"+
				DoWhatTableInfo.COLUMN_NAME_BEGINTIME+" INTEGER,"+
				DoWhatTableInfo.COLUMN_NAME_REALTIME+" INTEGER,"+
				DoWhatTableInfo.COLUMN_NAME_DATE+" TEXT);";
	Log.i(TAG , sql);
	db.execSQL(sql);
	}
	
	
	
	

}
