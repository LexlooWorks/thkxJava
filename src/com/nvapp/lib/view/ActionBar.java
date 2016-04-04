package com.nvapp.lib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class ActionBar extends LinearLayout {
	public ActionBar(Context context) {
		this(context, null);
	}

	public ActionBar(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ActionBar(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		LayoutParams lpParams = new LayoutParams(LayoutParams.MATCH_PARENT, 60);
		this.setLayoutParams(lpParams);
	}
}
