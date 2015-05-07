package com.example.viewpagertest3;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
	private ArrayList<CustomWebViewFragment> fList;

	public MyFragmentStatePagerAdapter(FragmentManager fm,
			ArrayList<CustomWebViewFragment> fList) {
		super(fm);
		this.fList = fList;
	}
	@Override
	public Fragment getItem(int i) {
		return fList.get(i);
	}
	@Override
	public int getCount() {
		return fList.size();
	}
	@Override
	public CharSequence getPageTitle(int position) {
		return "Page " + position;
	}

	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}
}