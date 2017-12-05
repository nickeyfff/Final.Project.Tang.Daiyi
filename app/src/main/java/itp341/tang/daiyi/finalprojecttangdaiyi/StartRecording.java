package itp341.tang.daiyi.finalprojecttangdaiyi;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by tangdaiyi on 17/11/28.
 */

public class StartRecording extends AppCompatActivity{
    private static String TAG = "startRecording";

//    private static final String LOG_TAG = "AudioRecordTest";
//    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
//    private static String mFileName = null;
//
//    private MediaPlayer mPlayer = null;
//    private MediaRecorder mRecorder = null;

    ImageView backSymbol;
    ImageView startTalkLabel;
    Button startTalkText;

//    // Requesting permission to RECORD_AUDIO
//    private boolean permissionToRecordAccepted = false;
//    private String [] permissions = {Manifest.permission.RECORD_AUDIO};

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode){
//            case REQUEST_RECORD_AUDIO_PERMISSION:
//                permissionToRecordAccepted  = grantResults[0] == PackageManager.PERMISSION_GRANTED;
//                break;
//        }
//        if (!permissionToRecordAccepted ) finish();
//
//    }
//
//    private void onRecord(boolean start) {
//        if (start) {
//            startRecording();
//        } else {
//            stopRecording();
//        }
//    }
//
//    private void onPlay(boolean start) {
//        if (start) {
//            startPlaying();
//        } else {
//            stopPlaying();
//        }
//    }
//
//    private void startPlaying() {
//        mPlayer = new MediaPlayer();
//        try {
//            mPlayer.setDataSource(mFileName);
//            mPlayer.prepare();
//            mPlayer.start();
//        } catch (IOException e) {
//            Log.e(LOG_TAG, "prepare() failed");
//        }
//    }
//
//    private void stopPlaying() {
//        mPlayer.release();
//        mPlayer = null;
//    }
//
//    private void startRecording() {
//        mRecorder = new MediaRecorder();
//        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
//        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
//        mRecorder.setOutputFile(mFileName);
//        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
//
//        try {
//            mRecorder.prepare();
//        } catch (IOException e) {
//            Log.e(LOG_TAG, "prepare() failed");
//        }
//
//        mRecorder.start();
//    }
//
//    private void stopRecording() {
//        mRecorder.stop();
//        mRecorder.release();
//        mRecorder = null;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called");
        setContentView(R.layout.start_recording_audio);

//        // Record to the external cache directory for visibility
//        mFileName = getExternalCacheDir().getAbsolutePath();
//        mFileName += "/audiorecordtest.3gp";
//
//        ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO_PERMISSION);

        backSymbol = (ImageView) findViewById(R.id.back_symbol);
        startTalkLabel = (ImageView) findViewById(R.id.image_start_talk);
        startTalkText = (Button) findViewById(R.id.text_start_talk);

        backSymbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(1, getIntent());
                finish();
            }
        });

        startTalkLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Recording.class);
                startActivityForResult(i, 1);

//                boolean mStartRecording = true;
//                onRecord(mStartRecording);
//                mStartRecording = !mStartRecording;
            }
        });
        startTalkText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Recording.class);
                startActivityForResult(i, 1);
            }
        });

    }

//    @Override
//    public void onStop() {
//        super.onStop();
//        if (mRecorder != null) {
//            mRecorder.release();
//            mRecorder = null;
//        }
//
//        if (mPlayer != null) {
//            mPlayer.release();
//            mPlayer = null;
//        }
//    }
}
