package com.example.viewpagertest3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
public class CustomWebViewFragment extends Fragment{

	private WebView mWebView = null;
	private String mUrl = null;

	public CustomWebViewFragment(String url) {
		this.mUrl = url;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment0, null);
		mWebView = (WebView) v.findViewById(R.id.webview);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
			}
		});
		if (mUrl != null)
			mWebView.loadUrl(mUrl);
		else
			mWebView.loadUrl("https://www.google.co.jp");

		return v;
	}

	@Override
	public void setMenuVisibility(boolean menuVisible) {
		super.setMenuVisibility(menuVisible);
	}

	public String getUrl(){
		return mWebView.getUrl();
	}

	public String getTitle() {
		if(mWebView != null)
		return mWebView.getTitle();
		else
			return "New Page";
	}
}