package com.nvapp.kx.shopSales;

import org.xutils.x;

import android.app.Application;
import android.util.Log;

public class KxApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("xxxx", "application create");
		
		x.Ext.init(this);
	    x.Ext.setDebug(BuildConfig.DEBUG);
	}
}
