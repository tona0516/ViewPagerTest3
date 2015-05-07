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

	private WebView mWebView = null;
	private String mUrl = null;

	public CustomWebViewFragment(String url) {
		this.mUrl = url;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment0, null);
		mWebView = (WebView) v.findViewById(R.id.webview);
		if (savedInstanceState != null) {
			Log.d("State", "" + savedInstanceState);
			mWebView.restoreState(savedInstanceState);
		} else {
			mWebView.getSettings().setJavaScriptEnabled(true);
			mWebView.setWebViewClient(new WebViewClient() {
				@Override
				public void onPageFinished(WebView view, String url) {
					super.onPageFinished(view, url);
					mUrl = url;
				}
			});
			if (mUrl != null)
				mWebView.loadUrl(mUrl);
			else
				mWebView.loadUrl("https://www.google.co.jp");
		}
		return v;
	}

	@Override
	public void setMenuVisibility(boolean menuVisible) {
		super.setMenuVisibility(menuVisible);
		Log.d("visibility", menuVisible + ":" + mUrl);
		Bundle bundle = new Bundle();
		if (!menuVisible && mWebView != null)
			mWebView.saveState(bundle);
		// Log.d("visibility", menuVisible + ":" + mUrl + "," +
		// mWebView.getScaleX() + "," + mWebView.getScrollY());
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
        mWebView.saveState(outState);
    }

	@Override
	public void onViewStateRestored(Bundle savedInstanceState) {
		super.onViewStateRestored(savedInstanceState);
		mWebView.restoreState(savedInstanceState);
	}
}