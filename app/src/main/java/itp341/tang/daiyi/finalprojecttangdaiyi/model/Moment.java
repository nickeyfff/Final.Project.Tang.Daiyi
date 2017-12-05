package itp341.tang.daiyi.finalprojecttangdaiyi.model;

import android.media.Image;
import android.net.Uri;
import android.widget.ImageView;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by tangdaiyi on 17/11/20.
 */

public class Moment extends SugarRecord<Moment>{

    private String pictureUri;

    public String getPictureUri() {
        return pictureUri;
    }

    public void setPictureUri(String pictureUri) {
        this.pictureUri = pictureUri;
    }

    public Moment(String pictureUri) {

        this.pictureUri = pictureUri;
    }

    public Moment(){
        super();
    }



    @Override
    public String toString() {
        return "Moment{" +
                "moment=" + pictureUri +
                '}';
    }
}
