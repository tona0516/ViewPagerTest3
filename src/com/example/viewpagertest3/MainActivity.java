package com.example.viewpagertest3;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
public class MainActivity extends FragmentActivity {
	ViewPager viewPager;
	ArrayList<CustomWebViewFragment> fList;
	MyFragmentStatePagerAdapter adapter;
	int currentPosition = 0, previousPosition = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setOffscreenPageLimit(5);
		fList = new ArrayList<CustomWebViewFragment>();
		fList.add(new CustomWebViewFragment("http://www.amazon.co.jp/"));
		fList.add(new CustomWebViewFragment("http://www.kakaku.com/"));
		adapter = new MyFragmentStatePagerAdapter(getSupportFragmentManager(), fList);
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				super.onPageSelected(position);
				previousPosition = currentPosition;
				currentPosition = position;
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.create) {
			if (fList.size() != 1) {
				adapter.addFragment();
				// viewPager.setCurrentItem(fList.size());
			}
		} else if (id == R.id.remove) {
			fList.remove(currentPosition);
			ArrayList<CustomWebViewFragment> list = new ArrayList<CustomWebViewFragment>();
			list.addAll(fList);
			adapter = new MyFragmentStatePagerAdapter(getSupportFragmentManager(), fList);
			fList = list;
			viewPager.destroyDrawingCache();
			viewPager.setAdapter(adapter);
			viewPager.setCurrentItem(currentPosition);
		}
		viewPager.setOffscreenPageLimit(fList.size());
		return super.onOptionsItemSelected(item);
	}
}
