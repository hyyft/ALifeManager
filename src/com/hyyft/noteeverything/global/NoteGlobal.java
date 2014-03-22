package com.hyyft.noteeverything.global;

import java.util.LinkedList;

import com.hyyft.noteeverything.modal.DayPlan;

import android.app.Application;

public class NoteGlobal extends Application {
	public LinkedList<DayPlan> planList = new LinkedList<DayPlan>();
	public int maxPlanOrder = 0;

	public void AddAPlan(DayPlan dayPlan) {
		int j;
		for ( j= 0; j < planList.size()
				&& (planList.get(j).getPlanBeginTime() < dayPlan.getPlanBeginTime()); j++);
		planList.add( j, dayPlan );
		maxPlanOrder++;

	}
}
