package com.example.cduse.catchcrash;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class CrashHandler implements Thread.UncaughtExceptionHandler {


    private Activity activity;

    public CrashHandler(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {

        Log.e("CRASH HANDLED", ex.getMessage());
        ex.printStackTrace();
        Intent intent = new Intent(activity, MainActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_CLEAR_TASK
                | Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                MyApplication.getIntance().getBaseContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);


        AlarmManager mgr = (AlarmManager) MyApplication.getIntance().getBaseContext()
                .getSystemService(Context.ALARM_SERVICE);
        mgr.setExact
                (AlarmManager.RTC, System.currentTimeMillis() + 10,
                        pendingIntent);

        activity.finish();


        System.exit(2);


    }
}