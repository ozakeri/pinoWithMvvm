package com.gap.pino_copy.service;

import android.content.Context;

import androidx.annotation.NonNull;

import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {
    public final static String TAG = MyWorker.class.getSimpleName();
    private Context context;

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
    }


    @NonNull
    @Override
    public Result doWork() {
        //AlarmManagerUtil.scheduleChatMessageReceiver(context);
        //Log.v(TAG, "=====doWork=====");
        //Log.v(TAG, String.valueOf(new Date()));


        /*try {
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //Log.v(TAG, "Work finished");
        return Worker.Result.success();
    }
}
