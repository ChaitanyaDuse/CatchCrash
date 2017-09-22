package com.example.cduse.catchcrash;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
 


    public static MyApplication instace;
 
	@Override
	public void onCreate() {
		super.onCreate();

		instace = this;
	}
	
	@Override
	public Context getApplicationContext() {
		return super.getApplicationContext();
	}
 
	public static MyApplication getIntance() {
		return instace;
	}
}