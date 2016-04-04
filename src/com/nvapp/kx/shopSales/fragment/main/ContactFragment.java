package com.nvapp.kx.shopSales.fragment.main;

import com.nvapp.kx.shopSales.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ContactFragment extends BaseFragment {
	private View curView = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null != curView) {
			((ViewGroup) curView.getParent()).removeView(curView);

			return curView;
		}

		curView = inflater.inflate(R.layout.fragment_main_contact, null);

		return curView;
	}
}