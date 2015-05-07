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
	private Bundle bundle = null;

	public CustomWebViewFragment(String url) {
		this.url = url;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		bundle  =new Bundle();
		View v = inflater.inflate(R.layout.fragment0, null);
		if (savedInstanceState != null) {
			Log.d("not null", "not null");
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
	public void setMenuVisibility(boolean menuVisible) {
		// TODO 自動生成されたメソッド・スタブ
		super.setMenuVisibility(menuVisible);
		if(!menuVisible && webView != null){
			Log.d("visibility", menuVisible+":"+url+","+webView.getScaleX()+","+webView.getScrollY());
		}
	}
}