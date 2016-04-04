package com.nvapp.kx.shopSales;

import com.nvapp.lib.ui.TintStatusBarManager;
import com.nvapp.lib.view.NaviTabButton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;

@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity {
	private NaviTabButton[] mTabButtons;
	private Fragment[] mFragments;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		TintStatusBarManager.tintByActivity(this, R.color.red);

		setContentView(R.layout.activity_main);

		this.initTab();
		this.initFragment();
		this.setFragmentIndicator(0);
	}

	private void initTab() {
		mTabButtons = new NaviTabButton[4];

		mTabButtons[0] = (NaviTabButton) findViewById(R.id.navi_btn_chat);
		mTabButtons[1] = (NaviTabButton) findViewById(R.id.navi_btn_contact);
		mTabButtons[2] = (NaviTabButton) findViewById(R.id.navi_btn_internal);
		mTabButtons[3] = (NaviTabButton) findViewById(R.id.navi_btn_my);

		mTabButtons[0].setTitle(getString(R.string.navi_btn_contact));
		mTabButtons[0].setSelectedImage(getResources().getDrawable(R.drawable.navi_btn_contact_sel));
		mTabButtons[0].setUnselectedImage(getResources().getDrawable(R.drawable.navi_btn_contact_nor));
		mTabButtons[0].setUnreadNotify(10);
		mTabButtons[0].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				setFragmentIndicator(0);
			}
		});

		mTabButtons[1].setTitle(getString(R.string.navi_btn_contact));
		mTabButtons[1].setSelectedImage(getResources().getDrawable(R.drawable.navi_btn_contact_sel));
		mTabButtons[1].setUnselectedImage(getResources().getDrawable(R.drawable.navi_btn_contact_nor));
		mTabButtons[1].setUnreadNotify(3);
		mTabButtons[1].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				setFragmentIndicator(1);
			}
		});

		mTabButtons[2].setTitle(getString(R.string.navi_btn_contact));
		mTabButtons[2].setSelectedImage(getResources().getDrawable(R.drawable.navi_btn_contact_sel));
		mTabButtons[2].setUnselectedImage(getResources().getDrawable(R.drawable.navi_btn_contact_nor));
		mTabButtons[2].setUnreadNotify(100);
		mTabButtons[2].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				setFragmentIndicator(2);
			}
		});

		mTabButtons[3].setTitle(getString(R.string.navi_btn_contact));
		mTabButtons[3].setSelectedImage(getResources().getDrawable(R.drawable.navi_btn_contact_sel));
		mTabButtons[3].setUnselectedImage(getResources().getDrawable(R.drawable.navi_btn_contact_nor));
		mTabButtons[3].setUnreadNotify(9);
		mTabButtons[3].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				setFragmentIndicator(3);
			}
		});
	}

	private void initFragment() {
		mFragments = new Fragment[4];
		mFragments[0] = getSupportFragmentManager().findFragmentById(R.id.fragment_main_chat);
		mFragments[1] = getSupportFragmentManager().findFragmentById(R.id.fragment_main_contact);
		mFragments[2] = getSupportFragmentManager().findFragmentById(R.id.fragment_main_internal);
		mFragments[3] = getSupportFragmentManager().findFragmentById(R.id.fragment_main_my);
	}

	public void setFragmentIndicator(int which) {
		getSupportFragmentManager().beginTransaction().hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2])
				.hide(mFragments[3]).show(mFragments[which]).commit();

		mTabButtons[0].setSelectedButton(false);
		mTabButtons[1].setSelectedButton(false);
		mTabButtons[2].setSelectedButton(false);
		mTabButtons[3].setSelectedButton(false);

		mTabButtons[which].setSelectedButton(true);
	}
}
