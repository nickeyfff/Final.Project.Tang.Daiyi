package itp341.tang.daiyi.finalprojecttangdaiyi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.robertsimoes.shareable.Shareable;

/**
 * Created by tangdaiyi on 17/11/28.
 */

public class CheckPhoto extends AppCompatActivity{
    private static String TAG = "CheckPhoto";

    ImageView backSymbol;
    ImageView myPhoto;
    Button buttonShare;
    Button buttonDelete;

    Uri pictureUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called");
        setContentView(R.layout.check_photo);

        backSymbol = (ImageView) findViewById(R.id.back_symbol);
        myPhoto = (ImageView) findViewById(R.id.sample_image);
        buttonShare = (Button) findViewById(R.id.button_share);
        buttonDelete = (Button) findViewById(R.id.button_delete);
        pictureUri=getIntent().getData();

        backSymbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(1, getIntent());
                finish();
            }
        });

        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Shareable imageShare = new Shareable.Builder(getApplication())
                        .message("have a nice day")
                        .image(pictureUri)
                        .socialChannel(Shareable.Builder.FACEBOOK)
                        .build();
                imageShare.share();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Delete.class);
                startActivityForResult(i, 1);
            }
        });
    }
}
