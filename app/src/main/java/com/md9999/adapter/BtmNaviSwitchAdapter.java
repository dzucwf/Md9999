package com.md9999.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.md9999.ui.fragment.HealthFileFragment;
import com.md9999.ui.fragment.MineFragment;
import com.md9999.ui.fragment.MyDoctorFragment;
import com.md9999.ui.fragment.ServiceFragment;


import java.util.ArrayList;

public class BtmNaviSwitchAdapter extends FragmentPagerAdapter {
	private ArrayList<Fragment> mFragments;
	
	public BtmNaviSwitchAdapter(FragmentManager fm) {
		super(fm);
		mFragments = new ArrayList<>();
		mFragments.add(new ServiceFragment());
        mFragments.add(new HealthFileFragment());
		mFragments.add(new MyDoctorFragment());
		mFragments.add(new MineFragment());

	}

	@Override
	public int getCount() {
		return mFragments.size();
	}

	@Override
	public Fragment getItem(int position) {
		return mFragments.get(position);
	}

}
