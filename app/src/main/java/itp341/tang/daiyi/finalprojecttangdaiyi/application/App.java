package itp341.tang.daiyi.finalprojecttangdaiyi.application;

//used online resource: https://github.com/ShirlyK/android-calendar

import android.app.Application;
import android.content.Context;

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



    }
}
