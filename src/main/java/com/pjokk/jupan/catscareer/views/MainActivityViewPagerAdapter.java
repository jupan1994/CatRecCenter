package com.pjokk.jupan.catscareer.views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.pjokk.jupan.catscareer.fragments.AboutUsFragment;
import com.pjokk.jupan.catscareer.fragments.MeetCatsFragment;
import com.pjokk.jupan.catscareer.fragments.RushFragment;

/**
 * Created by jupan on 6/26/17.
 */

public class MainActivityViewPagerAdapter extends FragmentStatePagerAdapter {

	public MainActivityViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		Fragment returnFragment;
		switch (position) {
			case 0:
				returnFragment = AboutUsFragment.newInstance();
				break;
			case 1:
				returnFragment = MeetCatsFragment.newInstance();
				break;
			case 2:
				returnFragment = RushFragment.newInstance();
				break;
			default:
				return null;
		}
		return returnFragment;
	}

	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		CharSequence title;
		switch (position) {
			case 0:
				title = "About Us";
				break;
			case 1:
				title = "Meet Trainers";
				break;
			case 2:
				title = "News & Events";
				break;
			default:
				return null;
		}
		return title;
	}
}
