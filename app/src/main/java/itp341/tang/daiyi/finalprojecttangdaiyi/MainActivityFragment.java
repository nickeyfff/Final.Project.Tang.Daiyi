package itp341.tang.daiyi.finalprojecttangdaiyi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import itp341.tang.daiyi.finalprojecttangdaiyi.activities.MyCalendarActivity;

/**
 * Created by tangdaiyi on 17/11/28.
 */

public class MainActivityFragment extends Fragment{
    private static final String TAG = MainActivityFragment.class.getSimpleName();

    ImageView calender;
    ImageView imageAddPhoto;
    TextView textAddPhoto;
    ImageView imageRecordAudio;
    TextView textRecordAudio;
    Button buttonCheckToday;

    public MainActivityFragment(){
        //required empty public constructor
    }

    //store newInstance input into fragment argument
    public static MainActivityFragment newInstance() {
        Bundle args = new Bundle();
        MainActivityFragment f = new MainActivityFragment();
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main, container, false);

        Log.d(TAG, "onCreateView");

        calender = (ImageView) v.findViewById(R.id.calender_icon);
        imageAddPhoto = (ImageView) v.findViewById(R.id.image_add_photo);
        textAddPhoto = (TextView) v.findViewById(R.id.text_add_photo);
        imageRecordAudio = (ImageView) v.findViewById(R.id.image_record_audio);
        textRecordAudio = (TextView) v.findViewById(R.id.text_record_audio);
        buttonCheckToday = (Button) v.findViewById(R.id.button_check_today);

        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MyCalendarActivity.class);
                startActivityForResult(i, 0);
            }
        });

        imageAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AddPhoto.class);
                startActivityForResult(i, 1);
            }
        });
        textAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AddPhoto.class);
                startActivityForResult(i, 1);
            }
        });

        imageRecordAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), StartRecording.class);
                startActivityForResult(i, 2);
            }
        });
        textRecordAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), StartRecording.class);
                startActivityForResult(i, 2);
            }
        });

        buttonCheckToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), TodayActivity.class);
                startActivityForResult(i, 3);
            }
        });
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: requestCode: " + requestCode);

        if(resultCode == 1 && resultCode == 1){

        }


    }
}
