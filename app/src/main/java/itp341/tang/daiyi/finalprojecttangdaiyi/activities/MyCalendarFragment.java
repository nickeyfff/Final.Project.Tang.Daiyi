package itp341.tang.daiyi.finalprojecttangdaiyi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import itp341.tang.daiyi.finalprojecttangdaiyi.MainActivity;
import itp341.tang.daiyi.finalprojecttangdaiyi.R;
import itp341.tang.daiyi.finalprojecttangdaiyi.TodayActivityFragment;
import itp341.tang.daiyi.finalprojecttangdaiyi.interfaces.OnDateSelectedListener;
import itp341.tang.daiyi.finalprojecttangdaiyi.objects.CalendarDate;
import itp341.tang.daiyi.finalprojecttangdaiyi.views.CustomCalendarView;

/**
 * Created by tangdaiyi on 17/12/1.
 */

public class MyCalendarFragment extends Fragment implements OnDateSelectedListener{
    private static final String TAG = MyCalendarFragment.class.getSimpleName();

    ImageView homeSymbol;
    TextView mTextDay;
    TextView mTextDayOfWeek;
    CustomCalendarView mCustomCalendar;

    public MyCalendarFragment() {
        //required empty public constructor
    }

    //store newInstance input into fragment argument
    public static MyCalendarFragment newInstance() {
        Bundle args = new Bundle();
        MyCalendarFragment f = new MyCalendarFragment();
        f.setArguments(args);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.calender, container, false);
        Log.d(TAG, "onCreateView");

        //find views
        homeSymbol = (ImageView) v.findViewById(R.id.back_home_symbol);
        mTextDay = (TextView) v.findViewById(R.id.activity_main_text_day_of_month);
        mTextDayOfWeek = (TextView) v.findViewById(R.id.activity_main_text_day_of_week);
        mCustomCalendar = (CustomCalendarView) v.findViewById(R.id.activity_main_view_custom_calendar);
        mCustomCalendar.setOnDateSelectedListener(this);

        homeSymbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivityForResult(i, 1);
            }
        });


        return v;
    }


    public void onDateSelected(CalendarDate date) {
        mTextDay.setText(date.dayToString());
        mTextDayOfWeek.setText(date.dayOfWeekToStringName());
    }

}
