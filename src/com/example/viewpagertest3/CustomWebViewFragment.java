package com.example.viewpagertest3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
public class CustomWebViewFragment extends Fragment {

	private WebView webView = null;
	private String url = null;

	public CustomWebViewFragment(String url) {
		this.url = url;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment0, null);
		if (savedInstanceState != null) {
			webView.restoreState(savedInstanceState);
			int x,y;
			x = savedInstanceState.getInt("scrollX");
			y = savedInstanceState.getInt("scrollY");
			webView.scrollTo(x, y);
		} else {
			webView = (WebView) v.findViewById(R.id.webview);
			webView.getSettings().setJavaScriptEnabled(true);
			webView.setWebViewClient(new WebViewClient() {
			});
			if (url != null)
				webView.loadUrl(url);
			else
				webView.loadUrl("https://www.google.co.jp");
		}
		return v;
	}
	
	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
		Log.d("hidden", hidden+":"+url);
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		webView.saveState(outState);
		outState.putInt("scrollX", webView.getScrollX());
		outState.putInt("scrollY", webView.getScrollY());
	}
	
	@Override
	public void onViewStateRestored(Bundle savedInstanceState) {
		super.onViewStateRestored(savedInstanceState);
		webView.restoreState(savedInstanceState);
	}
}