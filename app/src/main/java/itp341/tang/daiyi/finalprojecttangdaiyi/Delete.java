package itp341.tang.daiyi.finalprojecttangdaiyi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import itp341.tang.daiyi.finalprojecttangdaiyi.application.App;

/**
 * Created by tangdaiyi on 17/12/1.
 */

public class Delete extends AppCompatActivity{
    private static String TAG = "Delete";

    ImageView buttonCancel;
    ImageView buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called");
        setContentView(R.layout.check_photo);

        buttonCancel = (ImageView) findViewById(R.id.button_cancel);
        buttonDelete = (ImageView) findViewById(R.id.button_label_delete);

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(1, getIntent());
                finish();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
