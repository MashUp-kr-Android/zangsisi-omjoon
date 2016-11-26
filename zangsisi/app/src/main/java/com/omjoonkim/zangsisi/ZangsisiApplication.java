package com.omjoonkim.zangsisi;


import android.app.Application;

import io.realm.Realm;


public class ZangsisiApplication extends Application {

	@Override
	public void onCreate() {

		super.onCreate();
		Realm.init( getApplicationContext() );
	}
}
