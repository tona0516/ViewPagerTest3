package com.example.viewpagertest3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
		webView = (WebView) v.findViewById(R.id.webview);
		if (savedInstanceState != null) {
			webView.restoreState(savedInstanceState);
		} else if (url != null) {
			webView.loadUrl(url);
		} else {
			webView.loadUrl("https://www.google.co.jp");
		}
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebViewClient(new WebViewClient() {
		});
		return v;
	}
}