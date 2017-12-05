package itp341.tang.daiyi.finalprojecttangdaiyi.application;

//used online resource: https://github.com/ShirlyK/android-calendar

import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.util.List;

import itp341.tang.daiyi.finalprojecttangdaiyi.model.Moment;

public class App extends Application {

    private static Context sContext;

    public static Context getAppContext() {
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sContext = getApplicationContext();

        //clean database
        Moment.deleteAll(Moment.class);

        List<Moment> result=Moment.listAll(Moment.class);

        Log.d("APP"," monent listall size："+result.size());



    }
}
