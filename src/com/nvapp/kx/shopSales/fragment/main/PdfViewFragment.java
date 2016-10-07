package com.nvapp.kx.shopSales.fragment.main;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.nvapp.kx.shopSales.R;
import com.shockwave.pdfium.PdfDocument;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PdfViewFragment extends BaseFragment implements OnPageChangeListener, OnLoadCompleteListener {
	private View curView = null;
	private PDFView pdfView;
	private static final String SAMPLE_FILE = "01emsnt.pdf";

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

		curView = inflater.inflate(R.layout.fragment_main_pdf, null);

		pdfView = (PDFView) curView.findViewById(R.id.pdfView);
		displayFromAsset();

		return curView;
	}

	private void displayFromAsset() {
		pdfView.fromAsset(SAMPLE_FILE).defaultPage(0).onPageChange(this).enableAnnotationRendering(true).onLoad(this)
				.scrollHandle(new DefaultScrollHandle(this.getContext())).load();
	}

	@Override
	public void loadComplete(int nbPages) {
		PdfDocument.Meta meta = pdfView.getDocumentMeta();
		Log.e("xxxx", "title = " + meta.getTitle());
		Log.e("xxxx", "author = " + meta.getAuthor());
		Log.e("xxxx", "subject = " + meta.getSubject());
		Log.e("xxxx", "keywords = " + meta.getKeywords());
		Log.e("xxxx", "creator = " + meta.getCreator());
		Log.e("xxxx", "producer = " + meta.getProducer());
		Log.e("xxxx", "creationDate = " + meta.getCreationDate());
		Log.e("xxxx", "modDate = " + meta.getModDate());
	}

	@Override
	public void onPageChanged(int page, int pageCount) {
		Log.d("xxxx", String.format("%s %s / %s", "xxxx", page + 1, pageCount));
	}

}