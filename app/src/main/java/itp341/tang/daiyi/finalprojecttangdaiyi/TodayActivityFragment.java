package itp341.tang.daiyi.finalprojecttangdaiyi;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import itp341.tang.daiyi.finalprojecttangdaiyi.model.Moment;
import itp341.tang.daiyi.finalprojecttangdaiyi.model.MomentSingleton;

/**
 * Created by tangdaiyi on 17/11/28.
 */

public class TodayActivityFragment extends Fragment {
    private static final String TAG = TodayActivityFragment.class.getSimpleName();
    public static final String ARGS_POSITION = "args_position";
    public static final String EXTRA_POSITION = "extra_position"; //key for the intent extra

    ImageView homeButton;
    ListView momentList;

    Uri pictureUri=null;


    private MomentListAdapter adapter;

    public TodayActivityFragment() {
        //required empty public constructor
    }

    //store newInstance input into fragment argument
    public static TodayActivityFragment newInstance() {
        Bundle args = new Bundle();
        TodayActivityFragment f = new TodayActivityFragment();
        f.setArguments(args);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.today, container, false);
        Log.d(TAG, "onCreateView");

        //find views
        homeButton = (ImageView) v.findViewById(R.id.back_symbol);
        momentList = (ListView) v.findViewById(R.id.moment_list);

        List<Moment> moments = MomentSingleton.get(getContext()).getAllMoments();
        List rrrr=new ArrayList();
        pictureUri=Uri.parse(moments.get(0).getPictureUri());
        rrrr.add(moments.get(0));
        adapter = new MomentListAdapter(getActivity(), R.layout.list_photo_today, rrrr);
        momentList.setAdapter(adapter);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivityForResult(i, 1);
            }
        });

        momentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), CheckPhoto.class);
                i.putExtra(EXTRA_POSITION, id);
                i.setData(pictureUri);
                startActivityForResult(i, 0);

            }
        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: requestCode: " + requestCode);

        if (resultCode == Activity.RESULT_OK) {
            //this means user hit SAVE so we need to refresh
            //get the NEW DATA from superORM
            adapter.clear();   //get rid of current data
            List<Moment> moments = MomentSingleton.get(getActivity()).getAllMoments();
            List rrrr=new ArrayList();
            rrrr.add(moments.get(0));
            adapter.addAll(rrrr);
            adapter.notifyDataSetChanged();

//            pictureUri = data.getData();
//            Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();
        }
    }

    private class MomentListAdapter extends ArrayAdapter<Moment> {
        @Override
        public long getItemId(int position) {
            Moment moments = getItem(position);
            long id = moments.getId();
            return id;
        }

        //default constructor
        public MomentListAdapter(Context c, int resId, List<Moment> moments) {
            super(c, resId, moments);
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Log.d(TAG,"position:"+position);
            //step 1 -- inflate view (row)if necessary
            if (convertView == null) { //this means row has NEVER been created
                convertView = getActivity().getLayoutInflater().inflate(
                        R.layout.list_photo_today,
                        null
                );
            }

            //step 2 -- get references to any necessary widgets in the XML views in the row
            ImageView myPhotoMoment = (ImageView) convertView.findViewById(R.id.photo_added);
//            ImageView myAudioMoment = (ImageView) convertView.findViewById(R.id.audio_image);
//            TextView myAudioTime = (TextView) convertView.findViewById(R.id.audio_time);

            //step 3 -- get the new model data
            Moment moment = getItem(position); //getting the specified moment from the adapter

            //step 4 -- load the data from the model to the view
            String originalUri=moment.getPictureUri();
            ContentResolver resolver=getActivity().getContentResolver();

            try {
               Bitmap bm = MediaStore.Images.Media.getBitmap(resolver, Uri.parse(originalUri));
                myPhotoMoment.setImageBitmap(ThumbnailUtils.extractThumbnail(bm, 400, 400));
            } catch (IOException e) {
                e.printStackTrace();
            }

//            myPhotoMoment.setImageURI(Uri.parse(moment.getPictureUri()));


            return convertView;
        }



    }
}
