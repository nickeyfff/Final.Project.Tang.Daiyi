package itp341.tang.daiyi.finalprojecttangdaiyi.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangdaiyi on 17/11/28.
 */

public class MomentSingleton {

    private List<Moment> mMomentLists;
    private Context mContext;

    private static MomentSingleton sSingleton;

    private MomentSingleton(Context c) {
        mContext = c;
        mMomentLists = new ArrayList<>();
    }

    //Singleton get method
    public static MomentSingleton get(Context c){
        if (sSingleton == null) {
            sSingleton = new MomentSingleton(c);
        }
        return sSingleton;
    }

    //getMomentList (all items)
    public List<Moment> getAllMoments(){
        return Moment.listAll(Moment.class);
    }

    //getMomentList (single items)
    public Moment getMoment(long id){
        if (id >= 1){
            return Moment.findById(Moment.class, id);
        }
        else {
            return null;
        }
    }

    //addMoment
    public void addMoment (Moment moment) {
        moment.save();
    }

    //removeMoment
    public void removeMoment(long id) {
        if (id >= 1) {
            Moment moment = Moment.findById(Moment.class, id);
            if (moment != null) {
                moment.delete();
            }
        }
    }

    //updateMoment
    public void updateMoment(long id, Moment moment) {
        if (id >= 1){
            moment.setId(id);
            moment.save();
        }
    }

}
