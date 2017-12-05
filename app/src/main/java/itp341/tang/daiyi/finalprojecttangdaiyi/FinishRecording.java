package itp341.tang.daiyi.finalprojecttangdaiyi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by tangdaiyi on 17/11/29.
 */

public class FinishRecording extends AppCompatActivity{
    private static String TAG = "finishRecording";

    ImageView backSymbol;
    Button buttonFinishRecording;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called");
        setContentView(R.layout.finish_recording_audio);

        backSymbol = (ImageView) findViewById(R.id.back_symbol);
        buttonFinishRecording = (Button) findViewById(R.id.button_check_record);

        backSymbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), StartRecording.class);
                startActivityForResult(i, 1);
            }
        });

        buttonFinishRecording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TodayActivity.class);
                startActivityForResult(i, 1);
            }
        });
    }
}
