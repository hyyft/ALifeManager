package com.hyyft.noteeverything.planactivity;

import com.hyyft.noteeverything.R;
import com.hyyft.noteeverything.R.id;
import com.hyyft.noteeverything.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;


public class CalendarActivity extends Activity {
	
	public static final int CALENDAR_RESULT_CODE_OK = 1;
	public static final String CALENDAR_RESULT = "date";
	private CalendarView calendarView;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        
        calendarView=(CalendarView) findViewById(R.id.calendar_view);
        
        calendarView.setOnDateChangeListener(new OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                    int dayOfMonth) {
                // TODO Auto-generated method stub
                String date = year + "-" + (month+1) + "-" + dayOfMonth;
                Intent intent = new Intent();
                intent.putExtra(CALENDAR_RESULT, date);
                setResult(CALENDAR_RESULT_CODE_OK , intent);
                finish();
//                Toast.makeText(getApplicationContext(), date, 0).show();
            }
            
        });
    }    

}
