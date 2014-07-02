package tk.jimmywang.attendance.app.application;

import android.app.Application;

/**
 * Created by WangJin on 2014/7/2.
 */
public class BaseApplication extends Application{

    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        if(null == baseApplication){
            baseApplication = this;
        }

    }

    public static BaseApplication getInstance(){
        return baseApplication;
    }
}
