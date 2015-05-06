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
	ArrayList<Fragment0> fList;
	MyFragmentStatePagerAdapter adapter;
	int currentPosition = 0, previousPosition = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setOffscreenPageLimit(10);
		fList = new ArrayList<Fragment0>();
		fList.add(new Fragment0());
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
		if (id == R.id.remove) {
			if (fList.size() != 1) {
				adapter.removeFragment(currentPosition);
				viewPager.setCurrentItem(previousPosition);
			}
		} else if (id == R.id.create) {
			adapter.addFragment();
			viewPager.setCurrentItem(fList.size()-1);
		}
		return super.onOptionsItemSelected(item);
	}
}
