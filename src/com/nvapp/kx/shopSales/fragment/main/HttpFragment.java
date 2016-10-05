package com.nvapp.kx.shopSales.fragment.main;

import java.io.File;

import org.xutils.x;
import org.xutils.common.Callback.CommonCallback;
import org.xutils.http.RequestParams;

import com.nvapp.kx.shopSales.R;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class HttpFragment extends BaseFragment {
	private View curView = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("xxxx", "xxxx");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null != curView) {
			((ViewGroup) curView.getParent()).removeView(curView);

			return curView;
		}

		curView = inflater.inflate(R.layout.fragment_main_http, null);

		Button btn = (Button) curView.findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				RequestParams params = new RequestParams("http://192.168.1.102:8080/yypt/file.mobi");
				params.addQueryStringParameter("code", "log");
				params.addQueryStringParameter("tenant_guid", "from mobi");
				params.addQueryStringParameter("file_name", "ABC.jpg");
				params.setMultipart(false);
				params.addBodyParameter("file",
						new File(Environment.getExternalStorageDirectory().getPath() + "/ABC.jpg"));
				// params.uploadFile = new File("/sdcard/test.txt");
				// params.setAsJsonContent(false);

				x.http().post(params, new CommonCallback<String>() {

					@Override
					public void onCancelled(CancelledException cex) {
						cex.printStackTrace();
						Log.d("xxxx", "B" + cex.getMessage());
					}

					@Override
					public void onError(Throwable ex, boolean isOnCallback) {
						Log.d("xxxx", "C" + ex.getMessage());
					}

					@Override
					public void onFinished() {
						Log.d("xxxx", "finished");
					}

					@Override
					public void onSuccess(String result) {
						Log.d("xxxx", "A" + result);
					}
				});
			}

		});

		return curView;
	}
}