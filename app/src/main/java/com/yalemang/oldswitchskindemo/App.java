package com.yalemang.oldswitchskindemo;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    public static App INSTANCE;
    //存活的Activity集合
    private List<Activity> activeActivityList = new ArrayList<>();
    //记录当前的Style
    private int currentSkin = R.style.Theme_OldSwitchSkinDemo_SkinBlue;

    public int getCurrentSkin() {
        return currentSkin;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
                activeActivityList.add(activity);
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {

            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {
                activeActivityList.remove(activity);
            }
        });
    }

    /**
     * 切换Style,遍历Activity进行重构
     * @param resid
     */
    @Override
    public void setTheme(int resid) {
        super.setTheme(resid);
        currentSkin = resid;
        for (Activity activity : activeActivityList) {
            activity.recreate();
        }
    }
}
