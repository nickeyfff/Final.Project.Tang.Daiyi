package itp341.tang.daiyi.finalprojecttangdaiyi.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import itp341.tang.daiyi.finalprojecttangdaiyi.R;
import itp341.tang.daiyi.finalprojecttangdaiyi.TodayActivity;
import itp341.tang.daiyi.finalprojecttangdaiyi.interfaces.OnDateSelectedListener;
import itp341.tang.daiyi.finalprojecttangdaiyi.objects.CalendarDate;
import itp341.tang.daiyi.finalprojecttangdaiyi.views.CustomCalendarView;

public class MyCalendarActivity extends AppCompatActivity {
    public static final String TAG = MyCalendarActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.fragment_container);

        f = MyCalendarFragment.newInstance();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, f);
        fragmentTransaction.commit();
    }


//    ImageView homeSymbol;
//    TextView mTextDay;
//    TextView mTextDayOfWeek;
//    CustomCalendarView mCustomCalendar;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.calender);
//
//        homeSymbol = (ImageView) findViewById(R.id.back_home_symbol);
//        mTextDay = (TextView) findViewById(R.id.activity_main_text_day_of_month);
//        mTextDayOfWeek = (TextView) findViewById(R.id.activity_main_text_day_of_week);
//        mCustomCalendar = (CustomCalendarView) findViewById(R.id.activity_main_view_custom_calendar);
//        mCustomCalendar.setOnDateSelectedListener(this);
//
//        homeSymbol.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setResult(1, getIntent());
//                finish();
//            }
//        });
//
//    }
//
//    @Override
//    public void onDateSelected(CalendarDate date) {
//        mTextDay.setText(date.dayToString());
//        mTextDayOfWeek.setText(date.dayOfWeekToStringName());
//    }

}
