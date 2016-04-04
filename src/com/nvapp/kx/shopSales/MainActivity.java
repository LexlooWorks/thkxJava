package com.nvapp.kx.shopSales;

import com.nvapp.lib.ui.TintStatusBarManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		TintStatusBarManager.tintByActivity(this, R.color.red);

		setContentView(R.layout.activity_main);
	}
}
