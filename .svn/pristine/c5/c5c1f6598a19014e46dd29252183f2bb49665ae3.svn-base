package com.hyyft.noteeverything.modal;

import java.util.Calendar;
 

/**
 * 每天计划内容类
 * @author Administrator
 *
 */
public class DayPlan { 

	private int id;
	private String level; 
	private int  order;
	private String title;
	
	private String bigTag;
	private String littleTag;
	
	private String content;
	
	private long planBeginTime;
	private long realBeginTime;
	
	private int planTime;
	private int realTime;
	
	private short isFinish;
	private String date;
	
	
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setLevel(String level){
		this.level = level;
	}
	public String getLevel(){
		return this.level;
	}
	
	public void  setOrder(int order){
		this.order = order;
	}
	public  int  getOrder(){
		return this.order;
	}
	
	public  void setTitle(String title){
		this.title =title;
	}
	public String  getTitle(){
		return this.title;
	}
	
	public  void setBigTag(String bigTag){
		this.bigTag = bigTag;
	}
	public String  getBigTag(){
		return this.bigTag;
	}
	
	public  void setLitleTag(String litleTag){
		this.littleTag = litleTag;
	}
	public String  getLitleTag(){
		return this.littleTag;
	}
	
	public  void setContent(String content){
		this.content = content;
	}
	public String  getContent(){
		return this.content;
	}
	
	public  void setPlanBeginTime(long planBeginTime){
		this.planBeginTime = planBeginTime;
	}
	public long getPlanBeginTime(){
		return this.planBeginTime;
	}
	public  void setRealBeginTime(long realBeginTime){
		this.realBeginTime = realBeginTime;
	}
	public long getRealBeginTime(){
		return this.realBeginTime;
	}
	
	public  void setPlanTime(int  planTime){
		this.planTime = planTime;
	}
	public int  getPlanTime(){
		return this.planTime;
	}
	
	public  void setRealTime(int  realTime){
		this.realTime = realTime;
	}
	public int  getRealTime(){
		return this.realTime;
	}
	
	public void setIsFinish(short isFinish){
		
	    this.isFinish = isFinish;
	}
	public short getIsFinish(){
		 return this.isFinish;
	}
	
	public  void setDate(String date){
		this.date = date;
	}
	public String  getDate(){
		return this.date ;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		Calendar mCalendar=Calendar.getInstance();
		mCalendar.setTimeInMillis(planBeginTime);
		return id+":"+level+":"+order+":"+title+":"+bigTag+":"+littleTag+":"+content+
				":"+mCalendar.get(Calendar.HOUR_OF_DAY)+"|"+mCalendar.get(Calendar.MINUTE)+":"+planTime+":"+realTime+":"+isFinish+":"+date;
	}
	
	
	
	
}
