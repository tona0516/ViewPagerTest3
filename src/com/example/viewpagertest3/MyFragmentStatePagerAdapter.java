package com.example.viewpagertest3;

import java.util.ArrayList;

import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
	private ArrayList<CustomWebViewFragment> fList;
	private FragmentManager fManager;
	private android.support.v4.app.FragmentTransaction fTransaction;

	public MyFragmentStatePagerAdapter(FragmentManager fm,
			ArrayList<CustomWebViewFragment> fList) {
		super(fm);
		this.fList = fList;
		this.fManager = fm;
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

	public void addFragment() {
		CustomWebViewFragment newFragment = new CustomWebViewFragment(null);
		if(fManager != null){
//			fTransaction = fManager.beginTransaction();
//			fTransaction.add(newFragment, null);
//			fTransaction.commit();
			fList.add(newFragment);
			notifyDataSetChanged();
		}
	}

	public void removeFragment(int index) {
		if(fManager != null){
//			fTransaction = fManager.beginTransaction();
//			fTransaction.remove(fList.get(index));
//			fTransaction.commit();
			fList.remove(index);
			notifyDataSetChanged();
		}
	}
}