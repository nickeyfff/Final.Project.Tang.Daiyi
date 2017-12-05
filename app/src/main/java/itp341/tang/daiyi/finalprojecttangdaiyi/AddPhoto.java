package itp341.tang.daiyi.finalprojecttangdaiyi;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.util.List;

import itp341.tang.daiyi.finalprojecttangdaiyi.model.Moment;
import itp341.tang.daiyi.finalprojecttangdaiyi.model.MomentSingleton;

/**
 * Created by tangdaiyi on 17/11/28.
 */

public class AddPhoto extends AppCompatActivity{
    private static String TAG = "AddPhoto";

    //Bundle key
//    public static final String ARGS_POSITION = "args_position";

    ImageView backSymbol;
    ImageView photoSelected;
    Button buttonAddPhoto;

    long id;

    public final static int PIC_FROM_CAMERA = 0;
    public final static int PIC_FROM_LOCALPHOTO = 1;
    public final static int CANCEL = 2;
    public final static int PIC_CUT = 3;

    Uri pictureUri=null;

//    Moment moment = MomentSingleton.get(getApplication()).getMoment(id);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called");
        setContentView(R.layout.add_photo);

        backSymbol = (ImageView) findViewById(R.id.back_symbol);
        photoSelected = (ImageView) findViewById(R.id.sample_image);
        buttonAddPhoto = (Button) findViewById(R.id.button_add);

        Bitmap bitmap = getIntent().getParcelableExtra("image");
        photoSelected.setImageBitmap(bitmap);

        backSymbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(1, getIntent());
                finish();
            }
        });

        buttonAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TodayActivity.class);
                i.setData(pictureUri);
                saveAndClose();
                startActivityForResult(i, 1);
            }
        });

        Intent intent = new Intent (Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);

        //check if this is an existing or new listing
//        if(id != -1) {
//            Moment moment = MomentSingleton.get(getApplication()).getMoment(id);
//            if(moment != null) {
//                loadData(moment);
//            }
//        }

    }

    private void saveAndClose(){
        Log.d(TAG, "saveAndClose");
        //1. make a moment
        Moment moment = new Moment();
        moment.setPictureUri(pictureUri.toString());

        if (id> 0){
            MomentSingleton.get(getApplication()).updateMoment(id, moment);
        }
        else{
            MomentSingleton.get(getApplication()).addMoment(moment);
        }

        List<Moment> a=Moment.listAll(Moment.class);
        Log.d(TAG, "ok, moment siz:"+a.size());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ContentResolver resolver = getContentResolver();
        Bitmap bm = null;
        Log.w(String.valueOf(AddPhoto.class),"request code:"+requestCode +" result code:"+resultCode);
        if(0==resultCode){
            Toast.makeText(this, "please select photo", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        switch (requestCode) {
            case PIC_FROM_CAMERA:
                break;

            case PIC_FROM_LOCALPHOTO:
                pictureUri = data.getData(); // get the image's uri
                try {
                    bm = MediaStore.Images.Media.getBitmap(resolver, pictureUri);
                    photoSelected.setImageBitmap(bm);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case PIC_CUT:
                break;

            default:
                break;
        }
    }

    private void loadData(Moment moment) {
        //photoSelected.setImageResource(moment.setMoment(photoSelected.setImageURI(pictureUri)));
        photoSelected.setImageURI(pictureUri);
    }
}
