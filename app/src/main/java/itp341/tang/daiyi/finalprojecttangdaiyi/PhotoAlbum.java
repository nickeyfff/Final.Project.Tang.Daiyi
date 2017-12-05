package itp341.tang.daiyi.finalprojecttangdaiyi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tangdaiyi on 17/11/28.
 */

public class PhotoAlbum extends AppCompatActivity{
    private static String TAG = "PhotoAlbum";

    ImageView backSymbol;
    TextView addPhoto;
    ImageView targetImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called");
        setContentView(R.layout.photo_album);

        backSymbol = (ImageView) findViewById(R.id.back_symbol);
        addPhoto = (TextView) findViewById(R.id.text_add);
        targetImage = (ImageView) findViewById(R.id.photo_album);

        backSymbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(1, getIntent());
                finish();
            }
        });

        addPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddPhoto.class);
                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: requestCode: " + requestCode);

        if(resultCode == 1 && resultCode == 1){

        }
    }

}
